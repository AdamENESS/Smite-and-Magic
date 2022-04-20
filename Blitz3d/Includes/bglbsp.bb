
Global bgl_winname$="BSP Level Demo"
typ$="bsp"
Include "bglres.bb"
Global texthigh=1
Const distsize=1200
;load$=RequestFile$("Choose a Quake BSP MAP","bsp");"maps/e1m1.bsp"
;If load="" RuntimeError("You Didn't choose a valid MAP")
;Global fi=OpenFile(load$)
;If ReadInt(fi)<25 RuntimeError("You Didn't choose a valid MAP")
;CloseFile(fi)
HidePointer()


Type Dentry
Field offset,size
Field count,id
End Type
Type BSP
Field Faces,Verts,Entities,planes,textures,vis,nodes,texinfo,light,clip,leafs,marked,edges,surf,models
Field mesh,num_textures,version
End Type
Type leaf
	Field mesh,ID,size
	Field typeID
	Field vislist,bbmin[4],bbmax[4],lfaceID,lfacenum,sound[4]
End Type
Type Texture
	Field image[4],offset[4],gl
	Field name$
	Field width%
	Field height%
	Field surf[128]
	Field numsurf
	Field anim
End Type

Type animimage
Field name$
Field image[9]
Field frame,cframe
End Type

Dim face(16),vs#(4),vt#(4)
Dim dsize(15),lumpname$(15)
lumpname$(0)="LUMP_ENTITIES"
lumpname$(1)="LUMP_PLANES"
lumpname$(2)="LUMP_TEXTURES"
lumpname$(3)="LUMP_VERTEXES"
lumpname$(4)="LUMP_VISABILITY"
lumpname$(5)="LUMP_NODES"
lumpname$(6)="LUMP_TEXINFO"
lumpname$(7)="LUMP_FACES"
lumpname$(8)="LUMP_LIGHTING"
lumpname$(9)="LUMP_CLIPNODES"
lumpname$(10)="LUMP_LEAFS"
lumpname$(11)="LUMP_MARKSURFACES"
lumpname$(12)="LUMP_EDGES"
lumpname$(13)="LUMP_LISTEDGES"
lumpname$(14)="LUMP_MODELS"
Dim pal(256,3)
Restore .pallete
For a=0 To 255
Read pal(a,0)
Read pal(a,1)
Read pal(a,2)
Next



Include "OpenGLLIB.BB"
Include "GLcamera.bb"
Include "bglFrustum.bb"
Global Fru.frustum=New frustum
Global camera.camera=New camera
camera\vx#=480
camera\vy#=100
camera\vz#=100
camera\px#=480
camera\py#=100
camera\pz#=400
camera\uX=0
camera\uy=1
camera\uz=0


;Global oglwindow,main_window
;Global Desk_Width=ClientWidth(Desktop())
;Global Desk_Height=ClientHeight(Desktop())
;winwid=ClientWidth(Desktop());640
;winhgt=ClientHeight(Desktop());480
Global texture=1,wire=False,xrot,yrot
; check map version
;Global mainwin=CreateWindow("Quake Map Viewer")


;glWindow=


;delay 1000

; *******************************************************************

;If winmode=0
;winwid=640 : winhgt=480
;main_Window=CreateWindow("Blitz QuakeGL",(ClientWidth(Desktop())/2)-winwid/2,(ClientHeight(Desktop())/2)-winhgt/2,winwid,winhgt,0,%1011)
;Else
;main_Window=CreateWindow("Blitz QuakeGL",0,0,winwid,winhgt,0,0)
;CreateGLWindow("",winwid,winhgt,windph,winfreq,1)
;EndIf

; *****************************************************************
;pPanel1=CreatePanel(0,0,590,490,oglWindow,0)  

;SetGadgetLayout pPanel1,1,0,1,0

;raphics winwid,winhgt,32,0
;canvas=CreateCanvas(0,0,winwid,winhgt,0)
;bglGetBlitzWindow(16,"blitzcc")
;bglGetBlitzWindow(windph,"Blitz QuakeGL")
;oglwindow=bp_createfullscreen("BOB",1)
;bglFindChild(10,10)
;bglSetupGL()
;oglwindow=bp_createfullscreen("BOB",0)
;ReSizeProjection(winwid,winhgt)
glinit()


	Local proj=CreateBank(16*4)
	Local modl=CreateBank(16*4)
	Local clip[16]
	
	glGetFloatv(GL_PROJECTION_MATRIX, proj)
	glGetFloatv(GL_MODELVIEW_MATRIX, modl)
	
For a=0 To 15
	DebugLog  PeekFloat(modl,a*4)
Next

map1=bglloadbsp(load$)
;DebugLog "MAP ID:"+map1
;For t.dentry=Each dentry
;Delete t
;Next

;map2=bglloadbsp("dod_overlord.bsp")
;DebugLog "MAP ID:"+map2
camera\y=-100
timer=CreateTimer(100)
While Not KeyHit(1)
	WaitEvent()

	MOUSEMOVE(CAMERA)
	joymove(camera,3)
	If JoyX()<-.000016 Or JoyX>-.000014
		bglstrafeCamera(camera,JoyX()*10)
	EndIf
	If JoyY()<-.000016 Or JoyY>-.000014
		bglmoveCamera(camera,-JoyY()*10)
	EndIf
	If KeyDown(30) Or KeyDown(203)
		bglstrafeCamera(camera,-10)
	EndIf
	If KeyDown(205) Or KeyDown(32)	; right
			bglstrafeCamera(camera,10)
	EndIf
	If KeyDown(200)	Or KeyDown(17)	; up
			bglMoveCamera(camera,10)
	EndIf
	If KeyDown(208)	Or KeyDown(31)	; down
				bglMoveCamera(camera,-10)
	EndIf
	If KeyDown(2)
;	glPolygonMode(GL_FRONT_AND_BACK,GL_LINE)
;				bglMoveCamera(camera,0,10,0)

	EndIf
	If KeyDown(3)
;				bglMoveCamera(camera,0,-10,0)

;'	glPolygonMode(GL_FRONT_AND_BACK,GL_FILL)
	EndIf

	Select EventID()
		Case $103
		End
		Case $803
		End
		Case $4001
			display()
	End Select
		glFrontFace(gl_ccw)
	Flip
	glFrontFace(gl_cw)
;glswapbuffers()

Wend
End


Function glinit()
	glEnable(gl_TEXTURE_2D):							; Enable Texture Mapping
	glShadeModel(GL_SMOOTH):							; Enable Smooth Shading
	glClearColor(0.1, 0.1, 0.1, 0.1):					; grey Background
	;glClearDepth(1)
;	glDepthRange(1.0,0.0)
	glDepthFunc(GL_LEQUAL):								; The Type Of Depth Testing To Do
	glEnable(GL_DEPTH_TEST):							; Enables Depth Testing
;
	
	glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST):	; Really Nice Perspective Calculations
;	;
	
	glFrontFace(GL_CW)
;	glbackface
;glPolygonMode(GL_FRONT_AND_BACK,GL_LINE)
;	glCullFace(GL_Front)
	glEnable(GL_CULL_Face)
	; sets up the banks that holds the vectors for lighting.
	

	; Sets up the lights
	lightambient=createvector(1.52,1.52,1.52,1.52)
	glLightfv(GL_LIGHT0, GL_AMBIENT, lightambient):
;	glLightfv(GL_LIGHT0, GL_DIFFUSE, LightDiffuse):
;	glLightfv(GL_LIGHT0, GL_POSITION, Lightposition):
;	lightspec=createvector(10,10,10,10)
;	glLightfv(GL_LIGHT0, GL_SPECULAR, Lightspec):
	glEnable(GL_LIGHT0)
	;glPolygonMode(GL_FRONT,GL_POLY)
	;	glPolygonMode(GL_front,gl_Line)
	
;	glColor4f(1.0, 1.0, 1.0, 0.5):					; Full Brightness.  50% Alpha
	glBlendFunc(GL_SRC_ALPHA,GL_ONE):					; Set The Blending Function For Translucency
	glEnable(GL_lighting)
	;bglPositionCamera(0, -1500, 0)

	glDisable(GL_BLEND);
	glDisable(GL_ALPHA_TEST);
	;glEnable(GL_DEPTH_TEST);
;	glFogi(GL_FOG_MODE, GL_EXP );			// Fog Mode
;	fogcolor=createvector(0.5,0.5,0.5,1.0)
;	glFogfv(GL_FOG_COLOR, fogColor);					// Set Fog Color
;	glFogf(GL_FOG_DENSITY, 0.35);						// How Dense Will The Fog Be
	;glHint(GL_FOG_HINT, GL_DONT_CARE);					// Fog Hint Value
	;glFogf(GL_FOG_START, 1.0);							// Fog Start Depth
	;glFogf(GL_FOG_END, 5.0);							// Fog End Depth
	;glEnable(GL_FOG);									// Enables GL_FOG

End Function

Function display()

	glClear(GL_COLOR_BUFFER_BIT Or GL_DEPTH_BUFFER_BIT); Clear Screen And Depth Buffer
glLoadIdentity():									; Reset The Current Modelview Matri2
	glulookat(camera\PX,camera\PY,camera\PZ,camera\VX,camera\VY,camera\VZ,camera\uX,camera\uY,camera\uZ)
	bglcalculatefrustum(fru)
	
	glDisable(GL_Blend)
	b.bsp=Object.bsp(1)

	;glRotatef(90,1,0,0)
	;For lf.leaf=Each leaf
	;glCallList(lf\mesh)
	;Next
	;makebsp(b)
	drawbsp(b)
	glEnable(GL_TEXTURE_2D)
	glEnable(GL_BLEND)
	
	End Function
	
Function drawBSP(b.bsp)
	glFrontFace(GL_CW)


	glEnable(gl_lighting)

	glRotatef(90,1,0,0)

		For lf.leaf=Each leaf
		total=total+lf\lfacenum

		in=0
		ceX#=(lf\bbmin[0]+lf\bbmax[0])/2

		ceZ#=(lf\bbmin[1]+lf\bbmax[1])/2
;	size#=(sizex+sizey+sizez)/3
	distX=camera\PX-cex#
;	distX=Abs(distX)
;	db distX
	distz=(camera\Pz*-1)-cez#
;	distz=Abs(distz)
	If distx<distsize And distX>-distsize		
		If distZ<distsize And distZ>-distsize			
			in=1
		EndIf
	EndIf
	
	If (distx<distsize/2 And distX>-distsize/2)  
		If (distz<distsize/2 And distz>-distsize/2)
			ceY#=(lf\bbmin[2]+lf\bbmax[2])/2
	
		in=cubeInFrustum(fru,ceX,cey,-cez,lf\size)
	EndIf
	EndIf

			
			If in
				dtotal=dtotal+lf\lfacenum
				glCallList(lf\mesh)
			EndIf


;	AppTitle "bob"

Next
		glFrontFace(GL_CCW)
		SetStatusText main_window,"Polygons Drawn:"+dtotal+" out of "+total
	;db numfaces;+" "+camera\Px +" "+camera\Py+" "+camera\Pz
End Function	

Function bglLoadBSP%(filename$)
fi=OpenFile(filename$)
b.bsp=New bsp
Hand=Handle(b)
version=ReadInt(fi)
DebugLog "Version:"+version
For i=0 To 14
t.dentry=New dentry
t\id=i
t\offset=ReadInt(fi)
t\size=ReadInt(fi)
DebugLog lumpname$(i)+": offset:"+t\offset+" Size:"+t\size
;t\count=t\size/dsize(i)
Next
readplanes(fi,b)
readTextures(fi,b)
Readtexinfo(fi,b)
readVerts(fi,b)
readVisList(fi,b)
readedges(fi,b)
readFaces(fi,b)
readnode(fi,b)
readleaf(fi,b)
readlightmap(fi,b)
	makebsp(b)
Return hand
End Function
Function readverts(fi,b.bsp)

For t.dentry=Each dentry
If t\id=3
db "Vertices:"
db t\size

SeekFile(fi,t\offset)
b\verts=CreateBank(t\size)
t\count=(t\size/12)

db t\count
For i=0 To t\count-1
off=12*i

X=ReadFloat(fi)
Y=-ReadFloat(fi)
Z=-ReadFloat(fi)
PokeInt(b\verts,off,X)
PokeInt(b\verts,off+4,y)
PokeInt(b\verts,off+8,z)
;debuglog X+" "+Y+" "+Z+" "+(i*12)+"/"+t\size
Next
EndIf
Next
End Function

Function ReadEdges(fi,b.bsp)

For t.dentry=Each dentry
If t\id=12
db "Edges:"
SeekFile(fi,t\offset)
b\edges=CreateBank(t\size)
t\count=t\size/4
db t\count
For i=0 To t\count-1
off=4*i
e1=ReadShort(fi)
e2=ReadShort(fi)
;db e1+" "+e2
PokeShort(b\edges,off,e1)
PokeShort(b\edges,off+2,e2)
Next
Else If t\id=13
SeekFile(fi,t\offset)
db "List of Edges:"
b\surf=CreateBank((t\size))
	t\count=t\size/4
	db t\count
	b\surf=CreateBank(t\size)
	For i=0 To t\count-1
	;=ReadSShort(fi)
	;l;ReadShort(fi)
	ls=ReadInt(fi)
;Stop
;If i=189 db ls+" dfgdfg"

	PokeInt(b\surf,i*4,ls)
	Next
EndIf

Next
End Function


Function readfaces(fi,b.bsp)
For t.dentry=Each dentry
If t\id=7
db "FACES:"
SeekFile(fi,t\offset)
b\faces=CreateBank(t\size+200)
t\count=t\size/20
db t\count
For i=0 To t\count-1
off=i*20
plane=ReadShort(fi)
side=ReadShort(fi)
ledgeid=ReadInt(fi)
num=ReadShort(fi)
texinfo=ReadShort(fi)
l_type=ReadByte(fi)
l_base=ReadByte(fi)
light1=ReadByte(fi)
light2=ReadByte(fi)
lightmap=ReadInt(fi)
PokeShort(b\faces,off,plane)
PokeShort(b\faces,off+2,Side)
PokeInt(b\faces,off+4,ledgeid)
PokeShort(b\faces,off+8,num)
PokeShort(b\faces,off+10,texinfo)
PokeByte(b\faces,off+12,l_type)
PokeByte(b\faces,off+13,l_base)
PokeByte(b\faces,off+14,light1)
PokeByte(b\faces,off+15,light2)
PokeInt(b\faces,off+16,lightmap)
;db ledgeid+ " "+num+" "+texinfo
If num=3
; db "TRIAN;glE"
ElseIf num=4
; db "QUAD"
Else
; db "POLY of "+num+" Sides"
EndIf



Next

End If
Next
End Function



Function ReadPlanes(fi,b.bsp)
	For t.dentry=Each dentry
		If t\ID=1
			db "PLANES:"
			SeekFile(fi,t\offset)
			b\Planes=CreateBank(t\size)
			t\count=t\size/20
			db t\count
			For i=0 To t\count-1
			off=i*20
				nx#=ReadFloat(fi)
				ny#=ReadFloat(fi)
				nz#=ReadFloat(fi)
				dist=ReadFloat(fi)
				typ=ReadInt(fi)
				PokeFloat(b\planes,off,nx)
				PokeFloat(b\planes,off+4,ny)
				PokeFloat(b\planes,off+8,nz)
				PokeFloat(b\planes,off+12,dist)
				PokeInt(b\planes,off+16,typ)
			;	db NX+" "+NY+" "+NZ+" "+dist+" "+typ
			Next
		End If
	Next
End Function

Function db(s$)
;DebugLog s$
;Print s$
End Function

Function readlightmap(fi,b.bsp)
For t.dentry=Each dentry
		If t\ID=8
			db "LightMap Details"
			SeekFile(fi,t\offset)
			b\light=CreateBank(t\size)
			db t\size
			For a=0 To t\size-1
			Next
		EndIf
	Next
End Function

Function ReadTexInfo(fi,b.bsp)
	For t.dentry=Each dentry
		If t\ID=6
			db "Texture Info for Tmapping:"
			SeekFile(fi,t\offset)
			b\texinfo=CreateBank(t\size)
			t\count=t\size/40
			db t\count
			For a=0 To t\count-1
			off=a*40
			sx#=ReadFloat(fi)
			sy#=ReadFloat(fi)
			sz#=ReadFloat(fi)
			sd#=ReadFloat(fi)
			tx#=ReadFloat(fi)
			ty#=ReadFloat(fi)
			tz#=ReadFloat(fi)
			td#=ReadFloat(fi)
			tID=ReadInt(fi)
			anim=ReadInt(fi)
			PokeFloat(b\texinfo,off,sx#)
			PokeFloat(b\texinfo,off+4,sy#)
			PokeFloat(b\texinfo,off+8,sz#)
			PokeFloat(b\texinfo,off+12,sd#)
			PokeFloat(b\texinfo,off+16,tx#)
			PokeFloat(b\texinfo,off+20,ty#)
			PokeFloat(b\texinfo,off+24,tz#)
			PokeFloat(b\texinfo,off+28,td#)
			PokeInt(b\texinfo,off+32,tID)
			PokeInt(b\texinfo,off+36,anim)
			Next
		End If
	Next
End Function

Function ReadVisList(fi,b.bsp)
	For t.dentry=Each dentry
		If t\ID=4
			db "VIS LISTS:"
			SeekFile(fi,t\offset)
			b\VIS=CreateBank(t\size)
			t\count=t\size
			db t\count
			For a=0 To t\count-1
			PokeByte(b\vis,a,ReadByte(fi))
			
			Next
			
		EndIf
	Next
End Function


Function ReadNODE(fi,b.bsp)
	For t.dentry=Each dentry
	Local bbmin[3]
	Local bbmax[3]
		If t\ID=5
			db "BSP NODE"
			SeekFile(fi,t\offset)
			b\nodes=CreateBank(t\size)
			t\count=t\size/24
			db t\count
			For a=0 To t\count-1
			
				planeID=ReadInt(fi)
				fnt=ReadsShort(fi)
				bck=ReadsShort(fi)
				bbmin[0]=ReadShort(fi)
				bbmin[1]=ReadShort(fi)
				bbmin[2]=ReadShort(fi)
				bbmax[0]=ReadShort(fi)
				bbmax[1]=ReadShort(fi)
				bbmax[2]=ReadShort(fi)
				fface=ReadsShort(fi)
				num=ReadShort(fi)
				PokeInt(b\nodes,off,planeID)
				PokeShort(b\nodes,off+4,fnt)
				PokeShort(b\nodes,off+6,bck)
				PokeShort(b\nodes,off+8,bbmin[0])
				PokeShort(b\nodes,off+10,bbmin[1])
				PokeShort(b\nodes,off+12,bbmin[2])
				PokeShort(b\nodes,off+14,bbmax[0])
				PokeShort(b\nodes,off+16,bbmax[1])
				PokeShort(b\nodes,off+18,bbmax[2])				
				PokeShort(b\nodes,off+20,fface)	
				PokeShort(b\nodes,off+22,num)							
				;db planeID+" "+fnt+" "+bck+" "+fface+" "+num
				;db bbmin[0]+" "+bbmax[0]+" "+bbmin[1]+" "+bbmax[1]+" "+bbmin[2]+" "+bbmax[2]
			;	Print planeID
			Next
		EndIf
	Next
End Function

Function readleaf(fi,b.bsp)
	For t.dentry=Each dentry
	Local bbmin[3]
	Local bbmax[3]
		If t\ID=10
			db "BSP Leaf"
			SeekFile(fi,t\offset)
			b\leafs=CreateBank(t\size)
			t\count=t\size/28
			db t\count
			
			For a=0 To t\count-1
			lf.leaf=New leaf
				lf\ID=a
				lf\typeID=ReadInt(fi)
				lf\vislist=ReadInt(fi)				
				lf\bbmin[0]=ReadsShort(fi)
				lf\bbmin[1]=ReadsShort(fi)
				lf\bbmin[2]=ReadsShort(fi)
				lf\bbmax[0]=ReadsShort(fi)
				lf\bbmax[1]=ReadsShort(fi)
				lf\bbmax[2]=ReadsShort(fi)
				lf\lfaceID=ReadShort(fi)
				lf\lfacenum=ReadShort(fi)
				lf\sound[0]=ReadByte(fi)
				lf\sound[1]=ReadByte(fi)
				lf\sound[2]=ReadByte(fi)
				lf\sound[3]=ReadByte(fi)
			;	db lf\lfaceID
			;	db lf\bbmin[0]+" "+lf\bbmin[1]+" "+lf\bbmin[2]
			;	db lf\bbmax[0]+" "+lf\bbmax[1]+" "+lf\bbmax[2]
			sizex#=(lf\bbmin[0]+lf\bbmax[0])/2
			sizey#=(lf\bbmin[2]+lf\bbmax[2])/2		
			sizez#=(lf\bbmin[1]+lf\bbmax[1])/2
			If sizeZ>sizex And sizeZ>sizeY
				size#=sizez
			ElseIf sizey>sizeX And sizeY>sizeZ
				size#=sizey
			Else
				size#=sizeX
			EndIf
			lf\size#=size#
			Next
		End If
		If t\ID=11
			db "FACE LIST"
			SeekFile(fi,t\offset)

			t\count=t\size/2
			db t\count
			b\marked=CreateBank(t\size)
			For a=0 To t\count-1
			
			PokeShort(b\marked,a*2,ReadShort(fi))
			Next
		EndIf
	Next
End Function

Function Readtextures(fi,b.bsp)
	For t.dentry=Each dentry
		If t\ID=2
			db "Mip Mapped Textures:"
			SeekFile(fi,t\offset)
			b\num_textures=ReadInt(fi)
			db b\num_textures
			b\textures=CreateBank(b\num_textures*4)
			For i=0 To b\num_textures-1
				offset=ReadInt(fi)
				
				tx.texture=New texture
				h=Handle(tx)
			;	db "OFFSET:"+offset
				PokeInt(b\textures,I*4,h)
				lp=FilePos(fi)
				SeekFile(fi,(t\offset)+offset)
				tx\name=ReadString(fi,16)
				tx\width=ReadInt(fi)
				tx\height=ReadInt(fi)
				db tx\name+": W:"+tx\width+" H:"+tx\height
				tx\offset[0]=ReadInt(fi)
				tx\offset[1]=ReadInt(fi)
				tx\offset[2]=ReadInt(fi)
				tx\offset[3]=ReadInt(fi)
			;	db " Image 1:1 :"+tx\offset[0]
				If texthigh=1 tx\image[0]=LoadImage(Mid(tx\name,1,Len(tx\name)-1)+".jpg")
				;db tx\image[0]
				If tx\image[0]=0

				SeekFile(fi,((t\offset)+offset)+tx\offset[0])
				tx\image[0]=CreateImage(tx\width,tx\height)
				SetBuffer ImageBuffer(tx\image[0])
				For x=0 To tx\height-1
					For y=0 To tx\width-1
						col=ReadByte(fi)
						Color pal(col,0),pal(col,1),pal(col,2)
						Plot y,x
					Next
				Next
				EndIf
			SaveImage(tx\image[0],tx\name$+".bmp")
				
				SeekFile(fi,lp)
				tx\gl=bglLoadTexture(tx\name$+".bmp")
			db "TEXTURE:"+tx\gl+" "+tx\name$
			DeleteFile tx\name$+".bmp"
			Next
		EndIf
	Next
End Function


Function ReadString$(fi,leng)
ch$=""
For l=1 To leng
dta=ReadByte(fi)
If dta=0 And done=0

ch$=ch$+" "
done=1
Else If done=1

Else
ch$=ch$+Chr(dta)
EndIf
Next
Return ch$
End Function

Function ReadSShort(fi)
t=ReadShort(fi)
		If t>32767
		 r=t-65535
		Else
		r=t
		EndIf
		Return R
End Function


Function PeekSShort(bank,offset)
If offset<0 Return 0
t=PeekShort(bank,offset)
		If t>32767
		 r=t-65535
		Else
		r=t
		EndIf
		Return R
End Function









Function makeBSP(b.bsp)
;b\mesh=CreateMesh()
	;EntityFX b\mesh,32+2
	Local edge[32]
	For lf.leaf=Each leaf
;	Repeat

;		db lf\lfacenum-1
		lf\mesh=glGenLists(1);CreateMesh();b\mesh)
				glNewList(lf\mesh,GL_COMPILE);
				db lf\mesh
				For a=0 To lf\lfacenum-1
				fface=PeekShort(b\marked,(a+lf\lfaceID)*2)
				off=20*fface
;				db fface
				
			;	db a+" "+lf\typeID
				plane=PeekShort(b\faces,off)
				side=PeekShort(b\faces,off+2)
				ledgeid=PeekInt(b\faces,off+4)
				num=PeekShort(b\faces,off+8)
				texid=PeekShort(b\faces,off+10)
				NX#=PeekFloat(b\planes,(plane*20)+0)
				NY#=PeekFloat(b\planes,(plane*20)+4)
				NZ#=PeekFloat(b\planes,(plane*20)+8)
				fce=PeekInt(b\planes,(plane*20)+16)
				If (side=0 And fce=1) Or (fce=2 And side=0)
				nx#=nx#*-1
				ny#=ny#*-1
				nz#=nz#*-1								
				EndIf	
				If side=1 And fce=0
				nx#=nx#*-1
				ny#=ny#*-1
				nz#=nz#*-1								
				EndIf
				If side=0 And fce=2
;				nx#=nx#*-1
;				ny#=ny#*-1
;				nz#=nz#*-1								
				EndIf

				off2=(texid*40)
			vs#(0)=PeekFloat(b\texinfo,off2)
			vs#(1)=PeekFloat(b\texinfo,off2+4)
			vs#(2)=PeekFloat(b\texinfo,off2+8)
			vs#(3)=PeekFloat(b\texinfo,off2+12)
			vt#(0)=PeekFloat(b\texinfo,off2+16)
			vt#(1)=PeekFloat(b\texinfo,off2+20)
			vt#(2)=PeekFloat(b\texinfo,off2+24)
			vt#(3)=PeekFloat(b\texinfo,off2+28)
			TID=PeekInt(b\texinfo,off2+32)
			hand=PeekInt(b\textures,TID*4)
			tx.texture=Object.texture(hand)
		;	db tx\name
			glBindTexture(gl_TEXTURE_2d,tx\gl)
;			PokeInt(b\texinfo,off2+36,anim)
			;	db i
				Select num
				Case 3
					glBegin(GL_TRIANGLES)
					For j=0 To num-1
						
						edge[j]=PeekInt(b\surf,(ledgeid+j)*4)
						If edge[j]<0
						
;							e=PeeksShort(b\edges,(-(edge[j])*4))
							e=PeeksShort(b\edges,((-(edge[j])*4)+2))
							X#=PeekInt(b\verts,(e*12))
							y#=PeekInt(b\verts,(e*12)+4)
							z#=PeekInt(b\verts,(e*12)+8)
							ds#=dotproduct(x,y,z,vS#(0),vS#(1),vS#(2))+vs#(3)
							dt#=dotproduct(x,y,z,vt#(0),vt#(1),vt#(2))+vt#(3)
							u#=1-(ds#)*(1.0/tx\width)
							v#=1-(dt#)*(1.0/tx\height)
						;	db u#+" "+V#
							glNormal3f( NX#, NY#, NZ):

							glTexCoord2f(-u#,v#)
							glVertex3i(x,y,z)
						Else
							e=PeeksShort(b\edges,(((edge[j])*4)+0))
							X#=PeekInt(b\verts,(e*12))
							y#=PeekInt(b\verts,(e*12)+4)
							z#=PeekInt(b\verts,(e*12)+8)
							ds#=dotproduct(x,y,z,vS#(0),vS#(1),vS#(2))+vs#(3)
							dt#=dotproduct(x,y,z,vt#(0),vt#(1),vt#(2))+vt#(3)
							u#=(ds#*(1.0/tx\width))
							v#=(dt#*(1.0/tx\height))
						;	db u#+" "+V#
							glNormal3f( NX#, NY#, NZ):

							glTexCoord2f(-u#,v#)
							glVertex3i(x,y,z)
						EndIf
						
					Next
					glEnd()
				Case 4	
					glBegin(GL_QUADS)	
					For j=0 To num-1					
						edge[j]=PeekInt(b\surf,(ledgeid+j)*4)
						If edge[j]<0
						
;							e=PeeksShort(b\edges,(-(edge[j])*4))
							e=PeeksShort(b\edges,((-(edge[j])*4)+2))
							X=PeekInt(b\verts,(e*12))
							y=PeekInt(b\verts,(e*12)+4)
							z=PeekInt(b\verts,(e*12)+8)
												ds#=dotproduct(x,y,z,vS#(0),vS#(1),vS#(2))+vs#(3)
							dt#=dotproduct(x,y,z,vt#(0),vt#(1),vt#(2))+vt#(3)
							u#=(ds#)*(1.0/tx\width)
							v#=(dt#)*(1.0/tx\height)
;							db u#+" "+V#
glNormal3f( NX#, NY#, NZ):

							glTexCoord2f(-u#,v#)	
							glVertex3i(x,y,z)
						Else
							e=PeeksShort(b\edges,(((edge[j])*4)+0))
							X=PeekInt(b\verts,(e*12))
							y=PeekInt(b\verts,(e*12)+4)
							z=PeekInt(b\verts,(e*12)+8)
										ds#=dotproduct(x,y,z,vS#(0),vS#(1),vS#(2))+vs#(3)
							dt#=dotproduct(x,y,z,vt#(0),vt#(1),vt#(2))+vt#(3)
							u#=(ds#)*(1.0/tx\width)
							v#=(dt#)*(1.0/tx\height)
;							db u#+" "+V#
glNormal3f( NX#, NY#, NZ):

							glTexCoord2f(-u#,v#)			
							glVertex3i(x,y,z)
						EndIf
						edge[j]=peeksshort(b\surf,(ledgeid+j)*2)
						
					Next
					glEnd()
				Default
				glBegin(GL_POLYGON)
					For j=0 To num-1
						
											edge[j]=PeekInt(b\surf,(ledgeid+j)*4)
						If edge[j]<0
						
;							e=PeeksShort(b\edges,(-(edge[j])*4))
							e=PeeksShort(b\edges,((-(edge[j])*4)+2))
							X=PeekInt(b\verts,(e*12))
							y=PeekInt(b\verts,(e*12)+4)
							z=PeekInt(b\verts,(e*12)+8)
						
							ds#=dotproduct(x,y,z,vS#(0),vS#(1),vS#(2))+vs#(3)
							dt#=dotproduct(x,y,z,vt#(0),vt#(1),vt#(2))+vt#(3)
							u#=(ds#)*(1.0/tx\width)
							v#=(dt#)*(1.0/tx\height)

						glNormal3f( NX#, NY#, NZ):

							glTexCoord2f(-u#,v#)		
							glVertex3i(x,y,z)
						Else
							e=PeeksShort(b\edges,(((edge[j])*4)+0))
							X=PeekInt(b\verts,(e*12))
							y=PeekInt(b\verts,(e*12)+4)
							z=PeekInt(b\verts,(e*12)+8)
						
							ds#=dotproduct(x,y,z,vS#(0),vS#(1),vS#(2))+vs#(3)
							dt#=dotproduct(x,y,z,vt#(0),vt#(1),vt#(2))+vt#(3)
							u#=(ds#)*(1.0/tx\width)
							v#=(dt#)*(1.0/tx\height)
glNormal3f( NX#, NY#, NZ):

							glTexCoord2f(-u#,v#)	
							glVertex3i(x,y,z)
						EndIf
						edge[j]=peeksshort(b\surf,(ledgeid+j)*2)
						
					Next
					glEnd()			
				End Select
				;Stop
			Next
		;EndIf
		;glRotatef(90,1,0,0)
		glEndList()

;		lf=Before lf
;		db lf\ID
	Next
;Until lf\ID=1
End Function
			
				
				






Function makebspold(B.bsp)
For t.dentry=Each dentry
If t\id=7
db "FACES:"

For i=0 To t\count-1
off=i*20
plane=PeekShort(b\faces,off)
side=PeekShort(b\faces,off+2)
ledgeid=PeekInt(b\faces,off+4)
num=PeekShort(b\faces,off+8)
Select num
Case 3
		For a=0 To num-1
		glBegin(gl_TRIANGLES)
			face(a)=PeeksShort(b\surf,(ledgeid+a)*2)
			If face(a)>0		
				e1=PeekShort(b\edges,(face(a)*4))
				
				X=PeekInt(b\verts,(e1*12))
				y=PeekInt(b\verts,(e1*12)+4)
				z=PeekInt(b\verts,(e1*12)+8)						
				glVertex3f(X,Y,Z)
				e2=PeekShort(b\edges,(face(a)*4)+2)
			;	glEdgeFlag(GL_FALSE)
				X=PeekInt(b\verts,(e2*12))
				y=PeekInt(b\verts,(e2*12)+4)
				z=PeekInt(b\verts,(e2*12)+8)						
			;	glVertex3f(X,Y,Z)
				glEdgeFlag(GL_TRUE)
			Else
			face(a)=face(a)*-1
				e1=PeekShort(b\edges,(face(a)*4))
				e2=PeekShort(b\edges,(face(a)*4)+2)
				X=PeekInt(b\verts,(e2*12))
				y=PeekInt(b\verts,(e2*12)+4)
				z=PeekInt(b\verts,(e2*12)+8)						
				glVertex3f(X,Y,Z)
			;	glEdgeFlag(GL_False)
				X=PeekInt(b\verts,(e1*12))
				y=PeekInt(b\verts,(e1*12)+4)
				z=PeekInt(b\verts,(e1*12)+8)						
			;	glVertex3f(X,Y,Z)
				glEdgeFlag(GL_true)
			End If
		Next
		glEnd()
	Case 4
		For a=0 To num-1
		glBegin(gl_QUADS)
			face(a)=PeeksShort(b\surf,(ledgeid+a)*2)
			If face(a)>0		
				e1=PeekShort(b\edges,(face(a)*4))		
				X=PeekInt(b\verts,(e1*12))
				y=PeekInt(b\verts,(e1*12)+4)
				z=PeekInt(b\verts,(e1*12)+8)						
				glVertex3f(X,Y,Z)
				e2=PeekShort(b\edges,(face(a)*4)+2)
				;glEdgeFlag(GL_FALSE)
				X=PeekInt(b\verts,(e2*12))
				y=PeekInt(b\verts,(e2*12)+4)
				z=PeekInt(b\verts,(e2*12)+8)						
				;glVertex3f(X,Y,Z)
				glEdgeFlag(GL_TRUE)
			Else
				face(a)=face(a)*-1
				e1=PeekShort(b\edges,(face(a)*4))
				e2=PeekShort(b\edges,(face(a)*4)+2)
				X=PeekInt(b\verts,(e2*12))
				y=PeekInt(b\verts,(e2*12)+4)
				z=PeekInt(b\verts,(e2*12)+8)						
				glVertex3f(X,Y,Z)
				;glEdgeFlag(GL_False)
				X=PeekInt(b\verts,(e1*12))
				y=PeekInt(b\verts,(e1*12)+4)
				z=PeekInt(b\verts,(e1*12)+8)						
			;	glVertex3f(X,Y,Z)
				glEdgeFlag(GL_true)
			End If

		Next	
				glEnd()
		Default
		For a=0 To num-1

		glBegin(gl_POLYGON)
			face(a)=PeeksShort(b\surf,(ledgeid+a)*2)
			If face(a)>0		
				e1=PeekShort(b\edges,(face(a)*4))	
				X=PeekInt(b\verts,(e1*12))
				y=PeekInt(b\verts,(e1*12)+4)
				z=PeekInt(b\verts,(e1*12)+8)						
				glVertex3f(X,Y,Z)
				e2=PeekShort(b\edges,(face(a)*4)+2)
			;	glEdgeFlag(GL_FALSE)
				X=PeekInt(b\verts,(e2*12))
				y=PeekInt(b\verts,(e2*12)+4)
				z=PeekInt(b\verts,(e2*12)+8)						
			;	glVertex3f(X,Y,Z)
				glEdgeFlag(GL_TRUE)
			Else
				face(a)=face(a)*-1
				e1=PeekShort(b\edges,(face(a)*4))
				e2=PeekShort(b\edges,(face(a)*4)+2)
				X=PeekInt(b\verts,(e2*12))
				y=PeekInt(b\verts,(e2*12)+4)
				z=PeekInt(b\verts,(e2*12)+8)						
				glVertex3f(X,Y,Z)
			;	glEdgeFlag(GL_False)
				X=PeekInt(b\verts,(e1*12))
				y=PeekInt(b\verts,(e1*12)+4)
				z=PeekInt(b\verts,(e1*12)+8)						
			;	glVertex3f(X,Y,Z)
				glEdgeFlag(GL_true)
			End If
	
		Next
				glEnd()	
		
		;db ta
		
End Select

Next

End If
Next
End Function
Function linemode(b.bsp)
For t.dentry=Each dentry
	If t\id=12
	;db "Edges:"
	glBegin(GL_lines)
	For i=0 To t\count-1
	off=4*i
		e1=PeekShort(b\edges,off)
		e2=PeekShort(b\edges,off+2)
		X#=PeekInt(b\verts,(e1*12))
		y#=PeekInt(b\verts,(e1*12)+4)
		z#=PeekInt(b\verts,(e1*12)+8)						
		glVertex3f(X,Y,Z)
		X#=PeekInt(b\verts,(e2*12))
		y#=PeekInt(b\verts,(e2*12)+4)
		z#=PeekInt(b\verts,(e2*12)+8)						
		glVertex3f(X,Y,Z)		
		
Next
glEnd()
EndIf
Next


End Function


Function DotProduct#(x1#,y1#,z1#,x2#,y2#,z2#)
	Return x1*x2+y1*y2+z1*z2
End Function


;vec_t _DotProduct (vec3_t v1, vec3_t v2)
;{
;	Return v1[0]*v2[0] + v1[1]*v2[1] + v1[2]*v2[2];
;}

.palette
Data 0,0,0,15,15,15,31,31,31,47,47,47,63,63,63,75,75,75
Data 91,91,91,107,107,107,123,123,123,139,139,139,155,155,155,171,171,171
Data 187,187,187,203,203,203,219,219,219,235,235,235,15,11,7,23,15,11
Data 31,23,11,39,27,15,47,35,19,55,43,23,63,47,23,75,55,27,83,59,27,91,67,31,99,75,31,107,83,31,115,87,31,123,95,35
Data 131,103,35,143,111,35,11,11,15,19,19,27,27,27,39,39,39,51
Data 47,47,63,55,55,75,63,63,87,71,71,103,79,79,115,91,91,127
Data 99,99,139,107,107,151,115,115,163,123,123,175,131,131,187,139,139,203
Data 0,0,0,7,7,0,11,11,0,19,19,0,27,27,0,35,35,0,43,43,7,47,47,7,55,55,7,63,63,7,71,71,7,75,75,11,83,83,11,91,91,11
Data 99,99,11,107,107,15,7,0,0,15,0,0,23,0,0,31,0,0,39,0,0,47,0,0,55,0,0,63,0,0,71,0,0
Data 79,0,0,87,0,0,95,0,0,103,0,0,111,0,0,119,0,0,127,0,0,19,19,0,27,27,0,35,35,0,47,43,0
Data 55,47,0,67,55,0,75,59,7,87,67,7,95,71,7,107,75,11,119,83,15,131,87,19,139,91,19,151,95,27
Data 163,99,31,175,103,35,35,19,7,47,23,11,59,31,15,75,35,19,87,43,23,99,47,31,115,55,35,127,59,43
Data 143,67,51,159,79,51,175,99,47,191,119,47,207,143,43,223,171,39,239,203,31,255,243,27,11,7,0,27,19,0
Data 43,35,15,55,43,19,71,51,27,83,55,35,99,63,43,111,71,51,127,83,63,139,95,71,155,107,83,167,123,95
Data 183,135,107,195,147,123,211,163,139,227,179,151,171,139,163,159,127,151,147,115,135,139,103,123,127,91,111
Data 119,83,99,107,75,87,95,63,75,87,55,67,75,47,55,67,39,47,55,31,35,43,23,27,35,19,19,23,11,11,15,7,7,187,115,159
Data 175,107,143,163,95,131,151,87,119,139,79,107,127,75,95,115,67,83,107,59,75,95,51,63,83,43,55,71,35,43,59,31,35
Data 47,23,27,35,19,19,23,11,11,15,7,7,219,195,187,203,179,167,191,163,155,175,151,139,163,135,123,151,123,111
Data 135,111,95,123,99,83,107,87,71,95,75,59,83,63,51,67,51,39,55,43,31,39,31,23,27,19,15
Data 15,11,7,111,131,123,103,123,111,95,115,103,87,107,95,79,99,87,71,91,79,63,83,71,55,75,63,47,67,55
Data 43,59,47,35,51,39,31,43,31,23,35,23,15,27,19,11,19,11,7,11,7,255,243,27,239,223,23,219,203,19,203,183,15
Data 187,167,15,171,151,11,155,131,7,139,115,7,123,99,7,107,83,0,91,71,0,75,55,0,59,43,0,43,31,0,27,15,0,11,7,0
Data 0,0,255,11,11,239,19,19,223,27,27,207,35,35,191,43,43,175,47,47,159,47,47,143
Data 47,47,127,47,47,111,47,47,95,43,43,79,35,35,63,27,27,47,19,19,31,11,11,15,43,0,0,59,0,0,75,7,0,95,7,0,111,15,0
Data 127,23,7,147,31,7,163,39,11,183,51,15,195,75,27,207,99,43,219,127,59,227,151,79,231,171,95,239,191,119
Data 247,211,139,167,123,59,183,155,55,199,195,55,231,227,87,127,191,255,171,231,255,215,255,255
Data 103,0,0,139,0,0,179,0,0,215,0,0,255,0,0,255,243,147,255,247,199,255,255,255,159,91,83


Function bp_createfullscreen(title$,style=0,ortho=0)
Desk_Width=ClientWidth(Desktop())
Desk_Height=ClientHeight(Desktop())
winwid=desk_width
winhgt=Desk_height
SeedRnd MilliSecs()
;lobal main_Window=CreateWindow("",90,100,120,100,0,0)
oglWindow=CreateWindow(Title$,0,0,winwid,winhgt,0,style)
bglGetBlitzWindow(32,title$)
bglSetupGL()
If ortho=1
ReSizeOrtho(winwid,winhgt)   ; set up an ortho screen.
Else
ReSizeProjection(winwid,winhgt)


EndIf

Return oglwindow
End Function