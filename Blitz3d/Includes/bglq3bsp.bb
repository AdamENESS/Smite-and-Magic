; Quake 3 BSP loader..... 
Global logf=WriteFile("q3bsp.log")
Const kEntities = 0     ; Stores player/Object positions= etc...
Const kTextures = 1         ; Stores texture information
Const kPlanes=2          ; Stores the splitting planes
Const kNodes=3         ; Stores the BSP nodes
Const kLeafs=4        ; Stores the leafs of the nodes
Const kLeafFaces=5       ; Stores the leaf's indices into the faces
Const kLeafBrushes=6     ; Stores the leaf's indices into the brushes
Const kModels=7       ; Stores the info of world models
Const kBrushes=8      ; Stores the brushes info (For collision)
Const kBrushSides=9     ; Stores the brush surfaces info
Const kVertices=10   ; Stores the level vertices
Const kMeshVerts=11    ; Stores the model vertices offsets
Const kShaders=12   ; Stores the shader files (blending= anims..)
Const kFaces=13  ; Stores the faces For the level
Const kLightmaps=14   ; Stores the lightmaps For the level
Const kLightVolumes=15  ; Stores extra world lighting information
Const kVisData=16  ; Stores PVS And cluster info (visibility)
Const maxLumps=17 ; A constant To store the number of lumps
Global q3_file


Type bglq3bsp
	Field vertices			; Vertex array
	Field normals			; normal array
	Field UV[1]				; Texture array 0=texturemap, 1= lightmap
	Field tris				; will change later want untexture level first
	Field tristex			; holds the brush number of the 'linked' tris data.
	Field tex				; holds the reference number of the texture ie so GL can use it
	Field leafs,leafface
	Field nodes,Planes
	Field numleafs, numfaces
	Field facedrawn
	Field visdata, clusters,bpc
End Type

Type q3bspleaf
    Field cluster;           ; The visibility cluster 
    Field area;              ; The area portal 
    Field mins[3];           ; The bounding box min position 
    Field maxs[3];           ; The bounding box max position 
    Field leafface;          ; The first index fieldo the face array 
    Field numOfLeafFaces;    ; The number of faces for this leaf 
   Field leafBrush;         ; The first index for into the brushes 
    Field numOfLeafBrushes;  ; The number of brushes for this leaf 
End Type

Type q3bsptris
    Field texID
    Field effect
    Field typ
    Field vin
    Field nver
    Field min
    Field mver
	Field lmap
    Field lmc[2] 
    Field lms[2] 
    Field lmp[3] 
    Field lmba[3] 
    Field lmbb[3] 
    Field NX#
    Field ny#
    Field nz#
    Field sizea
    Field sizeb
	Field ID
End Type
qt.q3bsptris=New q3bsptris

;bglloadbsp("..\maps\tutorial.bsp")

; this function calls the correct BSP loading routine
Function bglLoadBSP.bglq3bsp(file$)
q3_file=OpenFile(file$)
ident$=q3readstring(4)

ver=q3ReadInt()
DebugLog ident+" "+ver
;If Not ident$="IBSP" And ver<45
;Return Null
;End If
q3.bglq3bsp=New bglq3bsp
q3\vertices=CreateBank(1)
q3\normals=CreateBank(1)
q3\uv[0]=CreateBank(1)
q3\uv[1]=CreateBank(1)
q3\tris=CreateBank(1)

q3\tristex=CreateBank(1)
q3\tex=CreateBank(1)
q3\leafs=CreateBank(1)
q3\planes=CreateBank(1)
q3\nodes=CreateBank(1)
Local offset[16],length[16]
For a=0 To 16
offset[a]=q3readint()
length[a]=q3readint()
WriteLine logf,a+" off:"+offset[a]+" len:"+length[a]
DebugLog a+" off:"+offset[a]+" len:"+length[a]
Next
SeekFile(q3_file,offset[1])
readq3tex(q3,length[1]/72)
SeekFile(q3_file,offset[2])
readq3planes(q3,length[2]/16)
SeekFile(q3_file,offset[3])
readq3nodes(q3,length[3]/36)
SeekFile(q3_file,offset[4])
readq3leafs(q3,length[4]/48)
q3\numleafs=length[4]/48
SeekFile(q3_file,offset[5])
readq3leaffaces(q3,length[5]/4)

SeekFile(q3_file,offset[10])
readq3verts(q3,length[10]/44)
SeekFile(q3_file,offset[13])
readq3tris(q3,length[13]/104)
q3\facedrawn=CreateBank(length[13]/104)
q3\numfaces=length[13]/104
SeekFile(q3_file,offset[14])
readq3light(q3,length[14]/(128*128*3))

SeekFile(q3_file,offset[16])
readq3vislist(q3,length[16])
Return q3



; read vertices

End Function

Function readq3verts(q3.bglq3bsp,sz)
DebugLog sz
WriteLine logf,"VERTICES"
For a=0 To sz-1
If BankSize(q3\vertices)=1
q3\vertices=CreateBank(12)
Else
	ResizeBank(q3\vertices,BankSize(q3\vertices)+12)
EndIf
If BankSize(q3\normals)=1
q3\normals=CreateBank(12)
Else
	ResizeBank(q3\normals,BankSize(q3\normals)+12)
EndIf
For lp=0 To 1
If BankSize(q3\uv[lp])=1
q3\uv[lp]=CreateBank(12)
Else
	ResizeBank(q3\uv[lp],BankSize(q3\uv[lp])+12)
EndIf
Next

 X#=q3readfloat() : Y#=q3readfloat() :  Z#=q3readfloat()
 tu#=q3readfloat() :  tv#=q3readfloat()
 lu#=q3readfloat() :  lv#=q3readfloat()
 NX#=q3readfloat() : NY#=q3readfloat() :  NZ#=q3readfloat()
 R=q3readbyte() :  G=q3readbyte() : B=q3readbyte(): Al=q3readbyte()	
 WriteLine(Logf, a+" - X:"+X+" Y:"+y+" Z:"+Z+"  NX:"+NX+" NY:"+Ny+" NZ:"+NZ+"  U:"+tu+" V:"+tv+"  Light U:"+lu+" light V:"+lv)
 ;WriteLine(logf, BankSize(q3\normals))
 PokeFloat(q3\vertices,(a*12),X#)
 PokeFloat(q3\vertices,(a*12)+4,Z#)
 PokeFloat(q3\vertices,(a*12)+8,-Y#)
 PokeFloat(q3\normals,(a*12),NX#)
 PokeFloat(q3\normals,(a*12)+4,NZ#)
 PokeFloat(q3\normals,(a*12)+8,-NY#)
 PokeFloat(q3\uv[0],(a*8),tu#)
 PokeFloat(q3\uv[0],(a*8)+4,-tv#)
 PokeFloat(q3\uv[1],(a*8),lu#)
 PokeFloat(q3\uv[1],(a*8)+4,-lv#)
Next
End Function

Function readq3tris(q3.bglq3bsp,sz)
DebugLog sz
For a=0 To sz-1
	qt.q3bsptris= First q3bsptris
	;qt\id=a
If BankSize(q3\tris)=1
q3\tris=CreateBank(12)
Else
	ResizeBank(q3\tris,BankSize(q3\tris)+12)
EndIf

If BankSize(q3\tristex)=1
q3\tristex=CreateBank(8)
Else
	ResizeBank(q3\tristex,BankSize(q3\tristex)+8)
EndIf
	qt\texID=q3readint() : qt\effect=q3readint() : qt\typ=q3readint() : qt\vin=q3readint() : qt\nver=q3readint() : qt\min=q3readint() : qt\mver=q3readint() : 	qt\lmap=q3readint()
	;Local lmc[2] : 
	 qt\lmc[1]=q3readint() : qt\lmc[2]=q3readint()
	;Local lms[2] :
	 qt\lms[1]=q3readint() : qt\lms[2]=q3readint()
	;Local lmp[3] :
	 qt\lmp[1]=q3readfloat() : qt\lmp[2]=q3readfloat() : qt\lmp[3]=q3readfloat()	
	;Local lmba[3] : Local lmbb[3] : 
	qt\lmba[1]=q3readfloat() : qt\lmba[2]=q3readfloat() : qt\lmba[3]=q3readfloat() : qt\lmbb[1]=q3readfloat() : qt\lmbb[2]=q3readfloat() : qt\lmbb[3]=q3readfloat()	
	qt\NX#=q3readfloat() : qt\ny#=q3readfloat() : qt\nz#=q3readfloat() : qt\sizea=q3ReadInt() : qt\sizeb=q3ReadInt()	
	WriteLine logf,qt\TEXID+" eff:"+qt\effect+" TYPE:"+qt\typ+" V Num:"+qt\nver+" MV num:"+qt\mver+","+qt\lmap
	PokeInt(q3\tristex,(a*8),qt\texid)
	PokeInt(q3\tristex,(a*8)+4,qt\lmap)


	PokeInt(q3\tris,(a*12),qt\vin)	
	PokeInt(q3\tris,(a*12)+4,qt\nver)
		PokeInt(q3\tris,(a*12)+8,qt\typ)	
Next
End Function

Function readq3tex(q3.bglq3bsp,sz)
DebugLog sz
For a=0 To sz-1
If BankSize(q3\tex)=1
q3\tex=CreateBank(8)
Else
	ResizeBank(q3\tex,BankSize(q3\tex)+8)
EndIf
t$=q3ReadString(64)


If FileType(t+".tga")=1 tex=bglLoadTexture(t+".tga",1) : DebugLog T+".tga"+" "+tex

If FileType(t+".jpg")=1 tex=bglLoadTexture(t+".jpg",1) : DebugLog T+".jpg"+" "+tex
If FileType(t+".bmp")=1 tex=bglLoadTexture(t+".bmp",1) : DebugLog T+".bmp"+" "+tex


PokeInt(q3\tex,a*8,tex)
q3ReadInt()
q3ReadInt()

Next
End Function
Function readq3light(q3.bglq3bsp,sz)
DebugLog sz
For a=0 To sz-1
	image=CreateImage(128,128)
	SetBuffer ImageBuffer(image)
	For x=0 To 127
	For y=0 To 127
		R=q3ReadByte()
		G=q3ReadByte()
		B=q3ReadByte()
	;	If R<90 R=r+90
	;	If B<90 B=b+90
	;	If G<90 G=g+90				
		Color R,G,B
		Plot y,x
	Next
	Next

	SaveImage(image,"Lighmap"+a+".bmp")
	lm=bglLoadTexture("Lighmap"+a+".bmp",1)
	DebugLog lm
	PokeInt(q3\tex,(a*8)+4,lm)
	DeleteFile "Lighmap"+a+".bmp"
	Next
End Function

Function readq3planes(q3.bglq3bsp,sz)
DebugLog sz
For a=0 To sz-1
If BankSize(q3\planes)=1
q3\planes=CreateBank(16)
Else
	ResizeBank(q3\planes,BankSize(q3\planes)+16)
EndIf

	Local n#[2]
	For b=0 To 2
	n[b]=q3ReadFloat()
	Next
	d#=q3ReadFloat()
	PokeFloat(q3\planes,(a*16),n[0])
	PokeFloat(q3\planes,(a*16)+4,n[2])
	PokeFloat(q3\planes,(a*16)+8,-n[1])
	PokeFloat(q3\planes,(a*16)+12,D#)
	;DebugLog n[0]+" "+n[1]+" "+n[2]+" "+q3readfloat()
Next
End Function

Function readq3leafs(q3.bglq3bsp,sz)
DebugLog sz
q3\leafs=CreateBank(sz*48)
DebugLog BankSize(q3\leafs)
fp=FilePos(q3_file)
ReadBytes(q3\leafs,q3_file,0,sz*48)
SeekFile(q3_file,fp)
For a=0 To (sz*48)-1
If Not q3Readbyte()=PeekByte(q3\leafs,a) RuntimeError "Error in File"
Next

;For a=0 To sz-1

;hnd=Handle(ql)
;If BankSize(q3\leafs)=1
;q3\leafs=CreateBank(48)
;Else
;	ResizeBank(q3\leafs,BankSize(q3\leafs)+48)
;EndIf
;PokeInt(q3\leafs,a,hnd)
;cluster=q3ReadInt()
;area=q3readint()

;For p=0 To 2
;mins1=q3readint()
;mins2
;Next
;For p=0 To 2
;ql\maxs[p]=q3readint()
;Next
;ql\leafface=q3readint()
;ql\numofleaffaces=q3readint()
;ql\leafbrush=q3readint()
;ql\numofleafbrushes=q3readint()
;WriteLine logf,"MAX X:"+ql\mins[0]+" Y:"+ql\mins[1]+" Z:"+ql\mins[2]
;WriteLine logf,"MAX X:"+ql\maxs[0]+" Y:"+ql\maxs[1]+" Z:"+ql\maxs[2]
;WriteLine logf, "LEAFFACE:"+ql\leafface+" Number:"+ql\numofleaffaces
;Next

;struct tBSPLeaf
;{
;    field cluster; 0           ; The visibility cluster 
;    field area;     4          ; The area portal 
;    field mins[3];  8,12,16    ; The bounding box min position 
;    field maxs[3];  20,24,28   ; The bounding box max position 
;    field leafface; 32         ; The first index fieldo the face array 
;    field numOfLeafFaces;36    ; The number of faces for this leaf 
;    field leafBrush;   40      ; The first index for fieldo the brushes 
;    field numOfLeafBrushes; 44 ; The number of brushes for this leaf 
;}; 
End Function
Function readq3leaffaces(q3.bglq3bsp,sz)
q3\leafface=CreateBank(sz*4)
DebugLog "*"+ sz
;For a=0 To sz-1
fp=FilePos(q3_file)
ReadBytes(q3\leafface,q3_file,0,sz*4)
SeekFile(q3_file,fp)
For a=0 To sz-1
If Not q3ReadInt()=PeekInt(q3\leafface,a*4) RuntimeError "Error in File"
Next
End Function
Function readq3leafbrushes(q3.bglq3bsp,sz)
End Function

Function readq3brushes(q3.bglq3bsp,sz)
End Function
Function readq3nodes(q3.bglq3bsp,sz)
DebugLog sz
For a=0 To sz-1
If BankSize(q3\nodes)=1
q3\nodes=CreateBank(36)
Else
	ResizeBank(q3\nodes,BankSize(q3\nodes)+36)
EndIf
	PokeInt(q3\nodes,(a*36),q3readint())
	PokeInt(q3\nodes,(a*36)+4,q3readint())
	PokeInt(q3\nodes,(a*36)+8,q3readint())
	
	PokeInt(q3\nodes,(a*36)+12,q3readint())
	PokeInt(q3\nodes,(a*36)+16,q3readint())
	PokeInt(q3\nodes,(a*36)+20,q3readint())

	PokeInt(q3\nodes,(a*36)+24,q3readint())
	PokeInt(q3\nodes,(a*36)+28,q3readint())
	PokeInt(q3\nodes,(a*36)+32,q3readint())


Next
;    Int plane;					; The index into the planes array 
;    Int front;					; The child index for the front node 
;    Int back;					; The child index for the back node 
;    tVector3i min;				; The bounding box min position. 
;    tVector3i max;				; The bounding box max position. 


End Function
Function readq3brushsides(q3.bglq3bsp,sz)
End Function
Function readq3vertslist(q3.bglq3bsp,sz)
End Function

Function readq3vislist(q3.bglq3bsp,sz)
vecnum=q3readint()
vecsize=q3readint()
q3\visdata=CreateBank(vecnum*vecsize)
ReadBytes(q3\visdata,q3_file,0,(vecnum*vecsize))
q3\bpc=vecsize
q3\clusters=vecnum
End Function
; quickread commands.
	
	
	Function q3Readbyte()
	Return ReadByte( q3_file )
End Function

Function q3ReadInt()
	Return ReadInt( q3_file )
End Function

Function q3ReadFloat#()
	Return ReadFloat( q3_file )
End Function

Function q3ReadString$(leng)

ch$=""
For l=1 To leng
dta=ReadByte(q3_file)
If dta=0 And done=0

ch2$=ch$;+" "
done=1
Else If done=1

Else
ch$=ch$+Chr(dta)
EndIf
Next
Return ch$
End Function

Function q3readshort()
Return ReadShort(q3_file)
End Function
Function q3ReadSShort()
t=q3ReadShort()
		If t>32767
		 r=t-65535
		Else
		r=t
		EndIf
		Return R
End Function



Function bglDrawBSP(q3.bglq3bsp,leaf)
	glDisable(gl_texture_2d)
	q3\facedrawn=CreateBank(q3\numfaces+1)
	glNormalPointer(gl_float,0,q3\normals)
	glVertexPointer(3,GL_float,0,q3\vertices)
	glClientActiveTextureARB(GL_TEXTURE0_ARB);
	glTexCoordPointer(2,GL_FLOAT,0,q3\uv[0])
	glClientActiveTextureARB(GL_TEXTURE1_ARB);
	glTexCoordPointer(2,GL_FLOAT,0,q3\uv[1])
	glEnableClientState(GL_TEXTURE_COORD_ARRAY);
	If tex1=1
		glClientActiveTextureARB(GL_TEXTURE0_ARB);
		glEnableClientState(GL_TEXTURE_COORD_ARRAY);
	EndIf
	If tex2=1
		glClientActiveTextureARB(GL_TEXTURE1_ARB);
		glEnableClientState(GL_TEXTURE_COORD_ARRAY);
	EndIf
;	DebugLog (BankSize(q3\tris)/8)-1
	offd=(leaf*48)
	cluster=PeekInt(q3\leafs,offd)
	startface=PeekInt(q3\leafs,offd+32)
	numfaces=PeekInt(q3\leafs,offd+36)
	;DebugLog cluster+" "+startface+" "+numfaces
;	For qt=
;For qt=0 To (BankSize(q3\tris)/12)-1
	For clust=q3\numleafs-1 To 0 Step -1
	offy=(clust*48)
	tst=PeekInt(q3\leafs,offy)
	
	
	If Not IsClusterVisible(q3,cluster,tst) Goto cont1
	nf=PeekInt(q3\leafs,offy+36)
	Local bbmin[3]
	Local bbmax[3]
	
	bbmin[0]=PeekInt(q3\leafs,offy+8)
	bbmin[1]=PeekInt(q3\leafs,offy+16)		
	bbmin[2]=-PeekInt(q3\leafs,offy+12)
	bbmax[0]=PeekInt(q3\leafs,offy+20)
	bbmax[1]=PeekInt(q3\leafs,offy+28)		
	bbmax[2]=-PeekInt(q3\leafs,offy+24)
	If Not boxinfrustum(fru,bbmin[0],bbmin[1],bbmin[2],bbmax[0],bbmax[1],bbmax[2]) Goto cont1
	;lef=PeekInt(q3\leafs,+32)
	For q=nf-1 To 0 Step -1
	
;Print qt
	;nf=PeekInt(q3\leafface,(q*8)+4)	
	;For qt=sf To sf+nf
	lef=PeekInt(q3\leafs,offy+32)
;	Print lef+" "+Q+" "+nf
	qt=PeekInt(q3\leafface,((lef+q)*4))
	;Print qt
	off=(qt*12)
	off2=(qt*8)
	;	If PeekInt(q3\facedrawn,qt)=0
		vin=PeekInt(q3\tris,off)
		nver=PeekInt(q3\tris,off+4)
		typ=PeekInt(q3\tris,off+8)		
		texID=PeekInt(q3\tristex,off2)
		LMAP=PeekInt(q3\tristex,off2+4)
		If tex1=1
			glActiveTextureARB(GL_TEXTURE0_ARB);
			glEnable(GL_texture_2d)
			glBindTexture(GL_TEXTURE_2D,(PeekInt(q3\tex,(texid*8))))
		EndIf
		If tex2=1
			glActiveTextureARB(GL_TEXTURE1_ARB);
			glEnable(GL_texture_2d)
			glBindTexture(GL_TEXTURE_2D,(PeekInt(q3\tex,(Lmap*8)+4)))
		EndIf
		If tex2=0 And tex1=0
			glEnable(GL_LIGHTING)
		Else
			glDisable(GL_LIGHTING)
		EndIf
		If typ=1
			glDrawArrays(GL_TRIANGLE_FAN,vin,nver)
		Else typ=2
			glDrawArrays(GL_POLYGON,vin,nver)
		EndIf
	;		PokeInt(q3\facedrawn,qt,1)
	;	EndIf
	;.cont2
	Next
	.cont1
	Next
End Function


Function FindLeaf(q3.bglq3bsp,c.camera)
	Distance#=0

	; This Function takes in our camera position, Then goes And walks
	; through the BSP nodes, starting at the root node, finding the leaf node
	; that our camera resides in.  This is done by checking To see If
	; the camera is in front Or back of Each node's splitting plane.
	; If the camera is in front of the camera, Then we want To check
	; the node in front of the node just tested.  If the camera is behind
	; the current node, we check that nodes back node.  Eventually, this
	; will find where the camera is according To the BSP tree.  Once a
	; node index (i) is found To be a negative number, that tells us that
	; that index is a leaf node, Not another BSP node.  We can either calculate
	; the leaf node index from -(i + 1) Or ~1.  This is because the starting
	; leaf index is 0, And you can't have a negative 0.  It's important
	; For us To know which leaf our camera is in so that we know which cluster
	; we are in.  That way we can test If other clusters are seen from our cluster.
	
	; Continue looping Until we find a negative index
	While(i >= 0)
	
		; Get the current node, Then find the slitter plane from that
		; node's plane index.  Notice that we use a constant reference
		; To store the plane And node so we get some optimization.
		
	;	Const tBSPNode&  node = m_pNodes[i];
		nodeoff=i*36
		planeoff=PeekInt(q3\nodes,nodeoff)*16
	;	Const tBSPPlane& plane = m_pPlanes[node.plane];

		; Use the Plane Equation (Ax + by + Cz + D = 0) To find If the
		; camera is in front of Or behind the current splitter plane.
;       distance =	plane.vNormal.x * vPos.x + 
;					plane.vNormal.y * vPos.y + 
;					plane.vNormal.z * vPos.z - plane.d;
	
		planeX#=PeekFloat(q3\planes,(planeoff))
		planeY#=PeekFloat(q3\planes,(planeoff)+4)
		planeZ#=PeekFloat(q3\planes,(planeoff)+8)
		planeD#=PeekFloat(q3\planes,(planeoff)+12)						
		distance= (planeX*c\PX)+(planey*c\Py)+(planeZ*c\Pz)-planeD

		; If the camera is in front of the plane
        If(distance >= 0)	
			; Assign the current node To the node in front of itself
            i = PeekInt(q3\nodes,nodeoff+4)
		; Else If the camera is behind the plane
        Else		
		
		;	 Assign the current node To the node behind itself
       i = PeekInt(q3\nodes,nodeoff+8);node.back;
       EndIf 
    Wend

	; Return the leaf index (same thing as saying:  Return -(i + 1)).
    Return ~i;  ; Binary operation
End Function


;;;;;;;;;;;;;; IS CLUSTER VISIBLE 
;;
;;	This tells us If the "current" cluster can see the "test" cluster
;;
;;;;;;;;;;;;;; IS CLUSTER VISIBLE 

Function IsClusterVisible(q3.bglq3bsp,current,test)

	; This Function is used To test the "current" cluster against
	; the "test" cluster.  If the "test" cluster is seen from the
	; "current" cluster, we can Then draw it's associated faces, assuming
	; they aren't frustum culled of course.  Each cluster has their own
	; bitset containing a bit For Each other cluster.  For instance, If there
	; is 10 clusters in the whole level (a tiny level), Then Each cluster
	; would have a bitset of 10 bits that store a 1 (visible) Or a 0 (Not visible) 
	; For Each other cluster.  Bitsets are used because it's faster And saves
	; memory, instead of creating a huge array of booleans.  It seems that
	; people tend To call the bitsets "vectors", so keep that in mind too.

	; Make sure we have valid memory And that the current cluster is > 0.
	; If we don't have any memory Or a negative cluster, Return a visibility (1).
	 If(current < 0) Return 0;

	; Use binary math To get the 8 bit visibility set For the current cluster
	off=((current*q3\bpc)+(test/8))
	visSet = PeekByte(q3\visdata,off);

	; Now that we have our vector (bitset), do some bit shifting To find If
	; the "test" cluster is visible from the "current" cluster, according To the bitset.
;	Print Bin$(visset)
;	t3= (test And 7)
;	bs= 1 Shl t3
;	result = visSet And bs ;

	Return ( visset And (1 Shl (test And 7)) );
End Function