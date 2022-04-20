;bglMS3D format loader.
; version 0.1 static mesh
; Bone stuff
; Animated


Type bglB3D
	Field Name$,mipmap						; Name of the model. normally the file name
	Field nodes,numnodes					; this stores all the node info (compresed?) maybe, but atm just as a bank ;)
	Field vertex,norms,colour,uv[8]			; Uv is set to 8 since there are a max a 8 different texture levels in a b3d model.
	Field Tris[128],tcnt[128]				; limit of how many triangle sets atm, this might change.
	Field brush,bnum,numbrush				; A Bank that holds all brush info
	Field texture,texoff					; A bank that holds all Texture info.
	Field boneID=-1,animID=-1
	Field tid=-1,vid=-1,ltid=0	
End Type



Type TEXTURE
	Field ID,tex;
	Field name$;
	Field Flags,blend;
	Field xpos#,ypos#,rotation#,scaleX#,scaleY#
End Type

	; Brush Type
Type BRUSH
	Field name$, Texture[4],b_num;  
	Field Colour#[4];
	Field shine#,id
	Field blend,fx
End Type
	
	; Triangle Type
Type TRIANGLE
	Field ID,brushID,Verts[3]
End Type
	
Type VERTICE
	Field ID,flags,texcords,texsets;
	Field X#,Y#,Z#,NX#,NY#,NZ#,R#,G#,B#,A#,U#[2],V#[2];
End Type

Type NODE
	Field X#,Y#,Z#,SX#,SY#,SZ#,RW#,RX#,RY#,RZ#;
	Field name$,tos,bone,key,parent,hand;
	Field model		; handle to a b3d model.
End Type

Type Bone
	Field ID,frames,name$,mesh
	Field Verts			; bank of verts
	Field Weight		; automatically 1 atm since that is all b3d supports :)
End Type
Type anim
	Field Frame,ID,flags,name$;
	Field PX,PY,PZ,SX,SY,SZ,RW,RX,RY,RZ;
End Type
Global ms3d_file

bglloadms3d("model.ms3d")
Function bglloadms3d.bglb3d(file$)
If FileType(file$)=1
	ms3d_file=OpenFile(file$)
	ID$=ms3dreadstring(10)
	If ID$<>"MS3D000000"
		DebugLog "BLAH"
		Return Null
	EndIf
	version=ms3dReadInt()
	DebugLog ID+" Version:"+version
	numverts=ms3dReadshort()
	DebugLog "verts:"+numverts
	For a=0 To numverts-1
		flags=ms3dreadbyte()
		X#=ms3dreadfloat()
		Y#=ms3dreadfloat()
		Z#=ms3dreadfloat()
		bone=ms3dreadbyte()
		RC=ms3dreadbyte()			
		;DebugLog "FLAGS:"+ms3dreadbyte()
		;DebugLog "X:"+ms3dReadFloat()+" Y:"+ms3dReadFloat()+" Z:"+ms3dReadFloat()
		;DebugLog "bone:"+ms3dreadbyte()+" Reference Count"+ms3dreadbyte()
	Next
	numtris=ms3dReadShort()
	DebugLog "tris:"+numtris
	Local vindex[3]
	Local vnorms#[9]
	Local s#[3],t#[3]
	For a=0 To numtris-1
	flags=ms3dreadshort()
	For b=0 To 2
		vindex[b]=ms3dreadshort() 
	Next
	;DebugLog vindex[0]+" "+vindex[1]+" "+vindex[2]
	For b=0 To 8
		vnorms[b]=ms3dreadfloat()
	Next
	For b=0 To 2
		s[b]=ms3dreadfloat()
	Next
	For b=0 To 2
		t[b]=ms3dreadfloat()
	Next
	Sg=ms3dreadbyte()
	Gi=ms3dReadByte()

	Next
	numgrps=ms3dreadshort()
	DebugLog "num groups:"+numgrps
	For a=0 To numgrps-1
		DebugLog a
		ms3dreadbyte()
		DebugLog ms3dreadstring(32)
		DebugLog ms3dreadshort()
		For b=0 To numtris-1
		DebugLog ms3dreadshort()		
		Next
		DebugLog ms3dreadbyte()

	Next
		
EndIf

	Return Null
End Function


Function ms3dReadbyte()
	Return ReadByte( ms3d_file )
End Function

Function ms3dReadInt()
	Return ReadInt( ms3d_file )
End Function

Function ms3dReadFloat#()
	Return ReadFloat( ms3d_file )
End Function

Function ms3dReadString$(leng)

ch$=""
For l=1 To leng
dta=ReadByte(ms3d_file)
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

Function ms3dreadshort()
Return ReadShort(ms3d_file)
End Function

Function ms3dReadSShort()
t=ms3dReadShort()
		If t>32767
		 r=t-65535
		Else
		r=t
		EndIf
		Return R
End Function

