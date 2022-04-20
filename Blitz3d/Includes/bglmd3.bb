Include "includes\bglmatrix.bb"
Global fileout=WriteFile("md3.Log")
Dim tempbank(0,0,2)
; Md3 loader for BLitzGL.
; rewritten from scratch for blitzGL
; version 0.1

; this is the main type that is accessable for all inforamtion about a md3 for use in GL.
; The verts, UV, and norms etc are 3 seperate groups, one for the Head, Torso and Leg models.
; most information from the model will be loaded into banks for Faster Access to the data stored within.
; and less memory usage.
 
Type Bgl_MD3
 Field Name
 Field tags[3]
 Field toff[3]			; this holds the offset for the main tag for each body part for each frame.
 Field frm[3]
 Field verts[3]			; Holds all Verts
 Field anim[3]			; Holds all Verts
 Field skin[3]
 Field anrms[3]
 Field UV[3]			; Hold all UV map info
 Field Norms[3]			; holds all normal Data
; Field Colour[3]		; hold the colour data
 Field Tris[3]			; holds the triangle data.
 Field fsize[3]		; stores how many frames are in the animation
 Field objs[3]		; stores the amount of objects
 Field numverts[3], numtris[3],numframes[3]
;Field lvert,asize,ltris
End Type


; these types are used when making and loading the model, they should be deleted when finished with.


Type tempmd3stuff
	 Field		numFrames;					  This stores the number of animation frames
	 Field		numTags;					  This stores the tag count
	 Field		numMeshes;					  This stores the number of sub-objects in the mesh
	 Field		numMaxSkins;				  This stores the number of skins for the mesh
	 Field		headerSize;					  This stores the mesh header size
	 Field		tagStart;					  This stores the offset  fieldo the file for tags
	 Field		tagEnd;						  This stores the end offset  fieldo the file for tags
	Field		numMeshFrames;				; This stores the mesh aniamtion frame count
	Field		numSkins;					; This stores the mesh skin count
	Field     numVertices;				; This stores the mesh vertex count
	Field		numTriangles;				; This stores the mesh face count\
	Field lvert,asize,ltris
	

End Type

Global tmp.tempmd3stuff

; This Typeure is used To Read in the mesh Data For the .md3 models

; This is our tag Type For the .MD3 file format.  These are used link other
; models To And the rotate And transate the child models of that model.
; This stores the normals And vertex indices 

Type tmd3Animation
	Field strName$					; This stores the name of the animation (I.E. "TORSO_STAND")
	Field startFrame				; This stores the first frame number for this animation
	Field endFrame					; This stores the last frame number for this animation
	Field loopingFrames				; This stores the looping frames for this animation (not used)
	Field framesPerSecond			; This stores the frames per second that this animation runs
	Field part						; body part. 0=both, 1=upper, 2=lower.
End Type
Global md3_file

Function BglLoadMd3.bgl_md3(Dirname$,skn$="default")

If FileType(dirname$)<>2
Return Null
EndIf
ChangeDir(dirname$)
;db "Loading Md3 pak ("+dirname$+") "
;db "Starting on Lower Model..."
				cline$=dirname$
				For a=1 To Len(cline)
					If Mid(cline,a,1)="\" Or Mid(cline,a,1)="/"
						pos=a
					EndIf
				Next
				If pos=0
					nstart=Instr(cline$,Chr(34))
					bnme$=	Mid(cline,nstart+1,(Len(cline)-(nstart)))
				Else
					bnme$= Mid(cline,pos+1,(Len(cline)-(pos)))
				EndIf
;txt=bglLoadTexture(bnme$+".TGA",True)
m.bgl_md3=New bgl_md3
m\name$=dirname$
For part=0 To 2
bglmd3loadskin(m,part,skn$)
;Next
Select part
Case 0
md3_file=OpenFile("lower.md3")
Case 1
md3_file=OpenFile("upper.md3")
Case 2
md3_file=OpenFile("head.md3")
End Select
tmp.tempmd3stuff = New tempmd3stuff
valid=bgl_md3_readheader(tmp)
;db VALID
If valid=0
	Delete m
	Delete tmp.tempmd3stuff
	ChangeDir("../")
	Return Null
EndIf
For a=0 To tmp\numframes-1
bgl_loadmd3bone()
Next

;/* read tags
m\tags[part]=CreateBank((tmp\numframes*tmp\numtags)*(112))
For lp=0 To (tmp\numframes*tmp\numtags)-1
	off=lp*112
	strname$=md3ReadString$(64)
	For b=1 To 64
	PokeByte(m\tags[part],off+(b-1),Asc(Mid(strname,b,1)))
	Next
	
	Local vposition[3]
	vposition[1]=	md3readfloat() ;x
	vposition[2]=	md3readfloat() ;y
	vposition[3]=	md3readfloat() ;z
	off2=off+64

	PokeFloat(m\tags[part],off2,vposition[1])
	PokeFloat(m\tags[part],off2+4,vposition[2])
	PokeFloat(m\tags[part],off2+8,vposition[3])
	For a=0 To 8
		tm#=md3readfloat()
		PokeFloat(m\tags[part],off2+12+(a*4),tm)
	Next
	as$=""	

;****************************************
;**			  Extracts String	       **
;****************************************
;	For b=1 To 64
;	fg=PeekByte(m\tags[part],off+(b-1))
;	If fg=255 Exit
;	as$=as$+Chr(fg)
;	Next	
;****************************************
Next
;*/
m\verts[part]=CreateBank(1)
m\norms[part]=CreateBank(1)
m\tris[part]=CreateBank(1)
m\uv[part]=CreateBank(1)
m\anim[part]=CreateBank(1)
m\objs[part]=tmp\nummeshes-1
;m\numverts[part]=CreateBank((1+m\objs[part])*4)
;m\numtris[part]=CreateBank((1+m\objs[part])*4)
Dim tempbank(3,tmp\nummeshes,5)

For a=0 To tmp\nummeshes-1

tempbank(part,a,0)=CreateBank(1)
nmf=readmesh(m,part,tmp,a)
;db part+" "+obj+":"+nmf+";"+tempbank(part,a,1)
bgldragoiscoolandthisvarshoudntreallybeusedandifitisyouareafool=bgldragoiscoolandthisvarshoudntreallybeusedandifitisyouareafool+BankSize(tempbank(part,a,0))
Next
; create one easy to use vert bank if the objects are more then 1

bbs=0
m\anim[part]=CreateBank(1)
For a=0 To tmp\nummeshes-1
	If BankSize(m\anim[part])=1
		m\anim[part]=CreateBank(BankSize(tempbank(part,a,0)))
	Else
		ResizeBank(m\anim[part],BankSize(m\anim[part])+BankSize(tempbank(part,a,0)))
	EndIf
	;db BankSize(m\anim[part])+" "+BankSize(tempbank(part,a,0))+" "+bbs

Next
If m\objs[part]=0
bb=0
For a=0 To tmp\nummeshes-1
	CopyBank(tempbank(part,a,0),0,m\anim[part],bbs,BankSize(tempbank(part,a,0)))
	bbs=bbs+BankSize(tempbank(part,a,0))
Next
Else
bbs=0
For b=0 To nmf-1
For a=0 To tmp\nummeshes-1

	CopyBank(tempbank(part,a,0),((b*tempbank(part,a,1))*12),m\anim[part],bbs,tempbank(part,a,1)*12)
	bbs=bbs+tempbank(part,a,1)*12
	Next
Next
EndIf

Delete tmp.tempmd3stuff
CloseFile md3_file
;db "numverts:"+(BankSize(m\anim[part])/12)
m\toff[part]=CreateBank(nmf*4)
db "FF "+nmf

For frame=0 To nmf-1
	cnt=-1
	For lp=0 To (BankSize(m\tags[part])/112)-1
	off=lp*112
;****************************************
;**			  Extracts String	       **
;****************************************
	tn$=""

	For b=1 To 64

	fg=PeekByte(m\tags[part],off+(b-1))
	If fg=255 Exit
	tn$=tn$+Chr(fg)
	Next	

;****************************************

	Select part
	Case 0
	If tn$="tag_torso"
		
		cnt=cnt+1
		If CNT=frame 
		PokeInt(m\toff[part],frame*4,off)
		Exit
		EndIf
	EndIf
	Case 1
		If tn$="tag_head"

		cnt=cnt+1
		If CNT=frame 
		PokeInt(m\toff[part],frame*4,off)
		Exit
		EndIf
	EndIf
	Case 2
	End Select

	Next
	Next
Next
ChangeDir("../")

Return m.bgl_md3

End Function

; private functions... ( I wish blitz had these... ;)

Function readmesh(m.bgl_md3,part,tmp.tempmd3stuff,obj)
pos=FilePos(md3_file)
;db "PART"+part

db md3readstring(4)
db md3readstring(68)
nummeshframes=md3ReadInt()
m\numframes[part]=nummeshframes
m\fsize[part]=nummeshframes
numskins=md3ReadInt()


numvertices=md3ReadInt()

numtriangles=md3ReadInt()
m\numverts[part]=numvertices
m\numtris[part]=numtriangles
If m\objs[part]=0
Else
tempbank(part,obj,1)=numvertices
EndIf

;	numvertices=md3ReadInt()
;	numtriangles=md3ReadInt()
;	PokeInt(m\numtris[part],(obj*4),numvertices)
;	;db "number of verts:"+numvertices
 ;
;	PokeInt(m\numverts[part],(obj*4),tmp\asize)
;	
;End If	

tristart=md3readint()
headersize=md3readint()
uvstart=md3readint()
vertexstart=md3readint()
meshsize=md3readint()

;db nummeshframes +","+ numskins+","+numvertices+","+numtriangles
;db Tristart+","+headersize+","+uvstart+","+vertexstart+","+meshsize

; read in the face data.
	SeekFile md3_file, pos+tristart
	
	For fce=0 To numtriangles-1
	If BankSize(m\tris[part])=1
m\tris[part]=CreateBank(12)
off=0
Else
	off=BankSize(m\tris[part])
	ResizeBank(m\tris[part],BankSize(m\tris[part])+12)
EndIf
;	off=(tmp\ltris*12)+(fce*12)

	v1=md3readint()		;vert 1
	PokeInt(m\tris[part],off,v1+tmp\lvert)
	v2=md3readint()		;vert 2
	PokeInt(m\tris[part],off+4,v2+tmp\lvert)	
	v3=md3readint()		;vert 3
	PokeInt(m\tris[part],off+8,v3+tmp\lvert)
	;;db v1+" "+v2+" "+v3
	Next
	tmp\ltris=tmp\ltris+numtriangles	
	
	SeekFile md3_file,pos+uvstart
	
	For i=0 To numvertices-1
	If BankSize(m\uv[part])=1
m\uv[part]=CreateBank(8)
Else
	ResizeBank(m\uv[part],BankSize(m\uv[part])+8)
EndIf
	u#=md3readfloat() :v#=md3readfloat() 
	off=(tmp\lvert*8)+(i*8)
;	off=i*8
	PokeFloat(m\uv[part],off,u#)
	PokeFloat(m\uv[part],off+4,-v#)	
	;;db U#+" "+V#
	Next
	
	SeekFile md3_file,pos+vertexstart
	For f=0 To nummeshframes-1
	
		For i=0 To numvertices-1
			X#=md3ReadsShort()/64.
			y#=md3ReadsShort()/64.
			Z#=md3ReadSShort()/64.

			normal=md3ReadShort()
;			lat <- (normal binary-And 255) * (2 * Pi) / 255
;			lng <- ((normal -Right 8) binary-And 255) * (2 * Pi ) / 255
;			x <- Cos ( lat ) * Sin ( lng )
;			y <- Sin ( lat ) * Sin ( lng )
;			z <- Cos ( lng )
			lat#=(normal And 255)*(2*Pi)/255
			lng#=((normal Shr 8) And 255)*(2*Pi)/255
			NX#=(Cos(lat)*Sin(lng))
			NY#=(Sin(lat)*Sin(lng))
			Nz#=Cos(lng)
If f=0
If BankSize(m\verts[part])=1
	m\verts[part]=CreateBank(12)
Else
	ResizeBank(m\verts[part],BankSize(m\verts[part])+12)
EndIf
If BankSize(m\NORMs[part])=1
	m\NORMs[part]=CreateBank(12)
Else
	ResizeBank(m\NORMs[part],BankSize(m\NORMs[part])+12)
EndIf	
		OFF=(tmp\lvert*12)+(i*12)
		PokeFloat(m\verts[part],off,x#)
		PokeFloat(m\verts[part],off+4,y#)
		PokeFloat(m\verts[part],off+8,z#)
		PokeFloat(m\norms[part],off,nx#)
		PokeFloat(m\norms[part],off+4,ny#)
		PokeFloat(m\norms[part],off+8,nz#)		

EndIf

If BankSize(m\anim[part])=1
	m\anim[part]=CreateBank(12)
Else
	ResizeBank(m\anim[part],BankSize(m\anim[part])+12)
EndIf
If BankSize(m\anim[part])=1 Or m\anrms[part]=0
	m\anrms[part]=CreateBank(12)
Else
	ResizeBank(m\anrms[part],BankSize(m\anrms[part])+12)
EndIf
If BankSize(tempbank(part,obj,0))=1 
	tempbank(part,obj,0)=CreateBank(12)
Else
	ResizeBank(tempbank(part,obj,0),BankSize(tempbank(part,obj,0))+12)
EndIf

		
		OFF=(f*(numvertices)*12)+(i*12)
		PokeFloat(tempbank(part,obj,0),off,x#)
		PokeFloat(tempbank(part,obj,0),off+4,y#)
		PokeFloat(tempbank(part,obj,0),off+8,z#)
		PokeFloat(m\anrms[part],off,nx#)
		PokeFloat(m\anrms[part],off+4,ny#)
		PokeFloat(m\anrms[part],off+8,nz#)			
		
								
;			;db X+" "+Y+" "+Z
;			;db "LAT:"+lat+" LNG:"+lng			
;			;db NX+" "+NY+" "+NZ			
		Next
	Next
	tmp\asize=BankSize(m\anim[part])
;If BankSize(m\verts[part])=1
;m\verts[part]=CreateBank(12)
;Else
;	ResizeBank(m\verts[part],BankSize(m\verts[part])+12)
;EndIf
;	off=(tmp\lvert*12)+(i*12)
	
;	PokeFloat(m\verts[part],off,md3readfloat())
;	PokeFloat(m\verts[part],off+4,md3readfloat())
;	PokeFloat(m\verts[part],off+8,md3readfloat())	
;
	
	tmp\lvert=tmp\lvert+numvertices
	;db tmp\lvert
SeekFile md3_file,pos+meshsize
Return nummeshframes
End Function

Function bgl_md3_readHeader(tmp.tempmd3stuff)
ident$=md3readstring(4)
If ident$<>"IDP3"
Return 0
End If
version=md3ReadInt()
md3ReadString(68)
tmp\numframes=md3readint()
tmp\numtags=md3readint()
tmp\nummeshes=md3readint()
tmp\nummaxskins=md3readint()
tmp\headersize=md3readint()
tmp\tagstart=md3readint()
tmp\tagend=md3readint()
md3readint()

Return version
End Function

Function bgl_LoadMD3Bone()
For a=0 To 9
	md3readfloat()
Next
	md3ReadString$(16)
	; if you want to do stuff with the bones comment this, uncomment the next.
	; this makes the function return the handle of this type
	;Delete bone
	;Return Handle(bone)
End Function

Function md3Readbyte()
	Return ReadByte( md3_file )
End Function

Function md3ReadInt()
	Return ReadInt( md3_file )
End Function

Function md3ReadFloat#()
	Return ReadFloat( md3_file )
End Function

Function md3ReadString$(leng)

ch$=""
For l=1 To leng
dta=ReadByte(md3_file)
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

Function md3readshort()
Return ReadShort(md3_file)
End Function
Function md3ReadSShort()
t=md3ReadShort()
		If t>32767
		 r=t-65535
		Else
		r=t
		EndIf
		Return R
End Function


Function PeekSShort(bank,offset)
If offset<0 Return 0
;DebugLog bank+" "+offset
t=PeekShort(bank,offset)
		If t>32767
		 r=t-65535
		Else
		r=t
		EndIf
		Return R
End Function



Function db(s$)
;DebugLog s$
WriteLine(fileout,s$)
End Function


;Function setframe(m.bgl_md3,frame)
;	For a=0 To 2
;		For lp=0 To m\fsize[a]-1
;			
;		Next
;	Next
;End Function




Function bgldrawmd3(md3.bgl_md3)
Local matrix#[9]
	
	glDisable(gl_lighting)
	glPushMatrix()

	For part=0 To 2
	glBindTexture(gl_texture_2d,md3\skin[part])
	glEnable(gl_texture_2D)
	;glEnable(GL_NORMALIZE)
	glVertexPointer(3,gl_float,0,md3\verts[part])	
	glNormalPointer(GL_FLOAT,0,md3\norms[part])

	glTexCoordPointer(2,GL_FLOAT,0,md3\UV[part])
	glEnableClientState(GL_TEXTURE_COORD_ARRAY);
	glDrawElements(GL_TRIANGLES,BankSize(md3\tris[part])/4,GL_UNSIGNED_INT,md3\tris[part])		
	If part=0 Or part=1
	off=PeekInt(md3\toff[part],(md3\frm[part]/10)*4)
	frame2#=md3\frm[part]/10
	frame3#=(md3\frm[part]/10.)-frame2
	Db off
	off2=off+64

				TX#=PeekFloat(md3\tags[part],off2)
				TY#=PeekFloat(md3\tags[part],off2+4)
				TZ#=PeekFloat(md3\tags[part],off2+8)

								
				;glTranslatef(TX,TY,TZ)
				tmatrix=CreateBank(36)
				For m=0 To 8
					matrix[m]=PeekFloat(md3\tags[part],off2+12+(m*4))
				Next
				PokeFloat(tmatrix,0,matrix[0]);		a1
				PokeFloat(tmatrix,4,matrix[1]);		a2
				PokeFloat(tmatrix,8,matrix[2]);		a3
				PokeFloat(tmatrix,12,matrix[3]);		b1
				PokeFloat(tmatrix,16,matrix[4]);		b2
				PokeFloat(tmatrix,20,matrix[5]);		b3
				PokeFloat(tmatrix,24,matrix[6]);		c1
				PokeFloat(tmatrix,28,matrix[7]);		c2
				PokeFloat(tmatrix,32,matrix[8]);		c3
				q.quat=createfrommatrix(tmatrix)
			If (frame2+1)<md3\fsize[part]
				noff=PeekInt(md3\toff[part],(1+(md3\frm[part]/10))*4)
				noff2=noff+64
				For m=0 To 8
					matrix[m]=PeekFloat(md3\tags[part],noff2+12+(m*4))
				Next
				PokeFloat(tmatrix,0,matrix[0]);		a1
				PokeFloat(tmatrix,4,matrix[1]);		a2
				PokeFloat(tmatrix,8,matrix[2]);		a3
				PokeFloat(tmatrix,12,matrix[3]);		b1
				PokeFloat(tmatrix,16,matrix[4]);		b2
				PokeFloat(tmatrix,20,matrix[5]);		b3
				PokeFloat(tmatrix,24,matrix[6]);		c1
				PokeFloat(tmatrix,28,matrix[7]);		c2
				PokeFloat(tmatrix,32,matrix[8]);		c3
				NTX#=PeekFloat(md3\tags[part],noff2)
				NTY#=PeekFloat(md3\tags[part],noff2+4)
				NTZ#=PeekFloat(md3\tags[part],noff2+8)
				
				ix#=(ntx-tx)
				iy#=(nty-ty)
				iz#=(ntz-tz)
				tx#=tx+(ix*frame3)
				ty#=ty+(iy*frame3)
				tz#=tz+(iz*frame3)
				q2.quat=createfrommatrix(tmatrix)
				qi.quat=slerp(q,q2,frame3)
				tmatrix=creatematrix(qi\W,qi\x,qi\y,qi\z)
				Delete q
				Delete q2
				Delete qi
	Else
			tmatrix=creatematrix(q\W,q\x,q\y,q\z)
							Delete q
	EndIf
				PokeFloat(tmatrix,(12*4),tx)
				PokeFloat(tmatrix,(13*4),ty)
				PokeFloat(tmatrix,(14*4),tz)				
				
				glMultMatrixf(tmatrix)
		EndIf
Next
glPopMatrix()

	glEnable(gl_lighting)
End Function
Function bglmd3changeanim(m.bgl_md3,frame,part)
	frame2#=frame/10
	frame3#=(frame/10.)-frame2
;	frame3=frame3*10
	;For part=0 To 2
;	If Not part=2
;	For Sa=0 To m\numverts[part]
If Right(Int(frame),1)=0 Or (frame2+1)=>m\fsize[part]
	CopyBank(m\anim[part],(frame2*BankSize(m\verts[part])),m\verts[part],0,BankSize(m\verts[part]))
	CopyBank(m\anrms[part],(frame2*BankSize(m\verts[part])),m\norms[part],0,BankSize(m\norms[part]))		
	Else
	For a=0 To( BankSize(m\verts[part]))-1 Step 4
	;DebugLog a
	
	tempo#=PeekFloat(m\anim[part],(frame2*BankSize(m\verts[part]))+a)
	tempa#=PeekFloat(m\anim[part],(Floor(frame2+1)*BankSize(m\verts[part]))+a)
	tempc#=(tempa-tempo)
	tempo#=tempo+(tempc*(frame3))
;	If (frame2+1)=>m\fsize[part]
;		tempa#=PeekFloat(m\anim[part],((0)*BankSize(m\verts[part]))+a)
;	EndIf	
;	Else

;	EndIf
	
	PokeFloat(m\verts[part],a,tempo)	


	Next
	EndIf	
	

;	EndIf
End Function


Function bglmd3loadskin(m.bgl_md3,part,skn$="default")
Select part
Case 0
file$="Lower_"+skn$+".skin"

Case 1
	file$="upper_"+skn$+".skin"
Case 2
	file$="head_"+skn$+".skin"
End Select
;Print file$
skinfile=OpenFile(file$)
fg=1
l=0
While Not Eof( skinfile )
t$=ReadLine(skinfile)
;; print T$
;For i=1 To Len(t$)
If Len(t$)>1
	If Mid$(t$,Len(t$)-3,1)="."

	For i=1 To Len(t$)
		If Mid$(t$,i,1)="/" Or Mid$(t$,i,1)="\"
			bob$=Right(t$,Len(t$)-i)
			m\skin[part]=bglLoadTexture(bob$,True)
			;skin(l,2)=Right(t$,Len(t$)-i)
		EndIf
		If Mid$(t$,i,1)=","
		;skin(l,1)=Left(t$,i-1)
		;	m\skin[part]=Left(t$,i-1)
		EndIf
	Next

	l=l+1
	
Else
;	tagname(fg)=Mid(t$,1,Len(t$)-1)
	fg=fg+1
EndIf
	
;Next
EndIf
Wend
CloseFile skinfile
End Function