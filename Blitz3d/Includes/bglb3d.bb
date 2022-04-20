
Const QuatToEulerAccuracy# = 0.001
Const QuatSlerpAccuracy#   = 0.01

Dim b3d_stack(100)
Global b3d_file,b3d_tos

Type Rotation
	Field pitch#, yaw#, roll#
End Type

Type Quat
	Field w#, x#, y#, z#
End Type

Type matrix33
	Field mat[9]
End Type

Type matrix44
	Field mat[16]
End Type

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
	Field Frame,ID,flags,name$,oframe;
	Field PX,PY,PZ,SX,SY,SZ,RW,RX,RY,RZ;
End Type



Function bglLoadb3D.bglb3d(filename$,mipmap)
	id=-1
	off=0
	
	fi=OpenFile(filename$)
	If fi=0
		Return Null
	EndIf
	cline$=filename$
	For a=1 To Len(cline)
		If Mid(cline,a,1)="\" Or Mid(cline,a,1)="/"
			pos=a
		EndIf
	Next
	If pos=0
		nstart=Instr(cline$,Chr(34))
		bnme$=	Mid(cline,nstart+1,(Len(cline)-(nstart)))
		dnme$=Right(cline,(Len(cline)-(nstart)))
	Else
		bnme$= Mid(cline,pos+1,(Len(cline)-(pos)))
		dnme$=Left(cline,(pos))

	EndIf	

	olddir$=CurrentDir()
	ChangeDir(dnme$)

	dnme$=Mid(dnme$,Len(CurrentDir())+1,Len(dnme$)-Len(CurrentDir())-1)+"/"
	;db bnme$+" / "+dnme$
	;db CurrentDir()
	b3dsetfile(fi)
	tag$=b3dreadchunk()
	db  tag$+" "+b3dchunksize()
	version=b3dreadint()
	v.vertice=New vertice
	WriteLine(fileout, "Version:"+version)
	If tag$<>"BB3D"
		Return Null
	End If
	b3d.bglb3d=New bglb3d
	b3d\mipmap=mipmap
	b3d\name$=filename
	b3d\vertex=CreateBank(1)
	b3d\Colour=CreateBank(1)
	b3d\norms=CreateBank(1)
	b3d\uv[1]=CreateBank(1)
	b3d\uv[2]=CreateBank(1)
	b3d\tris[0]=CreateBank(1)
	b3d\texture=CreateBank(1)
	b3d\brush=CreateBank(1)
	b3d\nodes=CreateBank(1)
	b3d\numnodes=-1
	b3d\boneID=-1
	b3d\animID=-1
	b3d\tid=-1
	b3d\vid=-1
	b3d\ltid=0


	Repeat
		tag$=""
		tag$=b3dreadchunk()

		Select tag$
			Case "TEXS"
			db  "TEXS"
			id=-1
			Repeat
			If BankSize(b3d\texture)=1
				b3d\texture=CreateBank(4)
			Else
				ResizeBank(b3d\texture,BankSize(b3d\texture)+4)
			EndIf
pos=0
			id=id+1
			t.texture=New texture	
				t\name$=b3dReadString()
				cline$=t\name$
				db  ":"+t\name$
				For a=1 To Len(cline)
					If Mid(cline,a,1)="\" Or Mid(cline,a,1)="/"
						pos=a
					EndIf
				Next
				If pos=0
					nstart=Instr(cline$,Chr(34))
					bnme$=Mid(cline,nstart+1,(Len(cline)-(nstart)))
				Else
					bnme$=Mid(cline,pos+1,(Len(cline)-(pos)))
				EndIf
				db  bnme$
				
				;db dnme$
				db  dnme$+bnme$
					t\tex=bglLoadTexture(dnme$+bnme$,b3d\mipmap)					
					db "texture: "+t\tex
				;	WaitKey
					t\ID=ID
					If t\ID=0
					b3d\texoff=t\tex
					EndIf
					off=((ID)*32)
					t\flags=b3dReadInt()
;					PokeInt(b3d\texture,off,tex)
;					PokeInt(b3d\texture,off+4,ID)
					t\blend=b3dReadInt()
;					PokeInt(b3d\texture,off+8,blend)
					t\xpos=b3dReadfloat()		
;					PokeFloat(b3d\texture,off+12,Xpos)		
					t\ypos=b3dReadfloat()				
;					PokeFloat(b3d\texture,off+16,ypos)		
					t\scaleX=b3dReadfloat()				
;					PokeFloat(b3d\texture,off+20,Scalex)			
					t\scaley=b3dReadfloat()			
;					PokeFloat(b3d\texture,off+24,Scaley)			
					t\rotation=b3dReadfloat()				
;					PokeFloat(b3d\texture,off+28,rotation)	
					PokeInt(b3d\texture,ID*4,Handle(t))
				Until FilePos(b3d_file)=b3d_stack(b3d_tos)
				b3dexitchunk()
				db "***************"
				db "* Textures: "+id+" *"
				db "***************"				
			Case "BRUS"
			db  "BRUS"
			id=-1
				b_num=b3dreadint()
				b3d\bnum=b_num
				Repeat
			;	Local texture[8]
				If BankSize(b3d\brush)=1
					b3d\brush=CreateBank(4)
				Else
					ResizeBank(b3d\brush,BankSize(b3d\brush)+4)
				EndIf

				b.brush=New brush
				
				id=id+1
				hnd=Handle(b)
				PokeInt(b3d\brush,id*4,hnd)
				db  hnd
				;off=(id*(32+((b_num+1)*4)))
					b3d\numbrush=id
					b\ID=id
						b\name$=b3dReadString()
						;b_num=b_num
						
						;PokeInt(b3d\brush,off,b_num)
						;PokeInt(b3d\brush,off+4,ID)
						
						b\colour[0]=b3dReadFloat()
						
;						PokeFloat(b3d\brush,off+4,color1)						
						b\colour[1]=b3dReadFloat()
;						PokeFloat(b3d\brush,off+8,color2)
						b\colour[2]=b3dReadFloat()					
;						PokeFloat(b3d\brush,off+12,color3)
						b\colour[3]=b3dReadFloat()
;						PokeFloat(b3d\brush,off+16,color4)
						b\shine=b3dReadFloat()
;						PokeFloat(b3d\brush,off+20,shine)
						b\blend=b3dReadInt()
;						PokeInt(b3d\brush,off+24,blend)					
						b\fx=b3dReadInt()					
;						PokeInt(b3d\brush,off+28,fx)					
						db  name$+" R:"+colour0+" G:"+colour1+" B:"+colour2+" A:"+colour3
						db  "Shine:"+shine+" FX:"+fx+" Blend:"+blend
;						db  off+" "+ID+" "+BankSize(b3d\brush)+" "+b_num

					For lp=1 To b_num
						b\texture[lp]=b3dReadInt()
						db  LP+" - "+b\texture[lp]
					;	WaitKey
;						PokeInt(b3d\brush,(off+32)+(4*lp-1),texture[lp])

					Next
				Until FilePos(b3d_file)=>b3d_stack(b3d_tos)					
					b3dexitchunk()
					For a=0 To ID
						b3d\tris[a]=CreateBank(1)
					Next
			Case "NODE"
							readnodeinfo(0,b3d)
			
		End Select
	Until Eof(b3d_file)
	
	Delete Each vertice
	parsenodes(b3d)
	ChangeDir(olddir$)
	Return b3d.bglb3d
End Function

Function parsenodes(b3d.bglb3d)
Local mess$[10]
For lp=0 To b3d\numnodes
For a=0 To 10
mess[a]=""
Next

	n.node=Object.node(PeekInt(b3d\nodes,lp*4))
	db  "NODE: "+n\name

	If Instr(n\name,"Type;")=1
				db  "THIS IS A QUILL3D NODE"

				c=0
				For l=1 To Len(n\name$)
					If Mid(n\name$,l,1)=";"
					;db  "["+c+"] "+mess[c]
					c=c+1

				Else
					mess[c]=mess[c]+Mid(n\name$,l,1)

				End If
				Next
				Select mess[1]
				Case 0		; light
					db  "light"
				Case 1		; model
					db  "Model"
					found =0
					For b3ds.bglb3d=Each bglb3d
						If b3ds\name=mess[7]
							found=1		
							h=Handle(b3ds)
							n\model=h
							db  "FOUND! "	+ h
							Exit
						EndIf
					Next
					If found=0
						temp.bglb3d=bglloadb3d(mess[7],0)
						h=Handle(temp)
						n\model=h
						db  "LOADED! "+h
					EndIf
				End Select
				EndIf
Next
End Function
Function readnodeinfo(hand,b3d.bglb3d)

				n.node=New node
					If BankSize(b3d\nodes)=1
					b3d\nodes=CreateBank(4)
				Else
					ResizeBank(b3d\nodes,BankSize(b3d\nodes)+4)
				EndIf
				b3d\numnodes=b3d\numnodes+1
				n\hand=Handle(n)
				PokeInt(b3d\nodes,4*(b3d\numnodes),n\hand)
				n\parent=hand
				tos=b3d_tos				
				;db  tos
				n\name$=b3dReadstring()
				db  "NODE: "+n\name
				
				db  n\Parent
				;pos
				 n\X#=b3dreadfloat()
				 n\y#=b3dreadfloat()
				 n\z#=b3dreadfloat()
				;scale
				 n\sX#=b3dreadfloat()
				 n\sy#=b3dreadfloat()
				 n\sz#=b3dreadfloat()
				;rotation
				 n\rw#=b3dreadfloat()
				 n\rX#=b3dreadfloat()
				 n\ry#=b3dreadfloat()
				 n\rz#=b3dreadfloat()
				If FilePos(b3d_file)<b3d_stack(tos)
				db n\x+" "+n\y+" "+n\z+" "+n\sx+" "+n\sy+" "+n\sz+" "+n\rw+" "+n\rx+" "+n\ry+" "+n\rz
				Repeat
				cnk$=b3dReadchunk()
				Select cnk$
				Case "NODE"
					;otos=tos
					readnodeinfo(n\hand,b3d)
				;	b3dexitchunk()					
					;tos=otos
				Case "MESH"
					db  "Mesh Node"
					meshread(b3d)
					b3dexitchunk()
				Case "BONE"
	
					db  "Bone Node"
					b.bone=New bone
					b\name$=n\name$
					n\bone=Handle(b)
					b3d\boneid=b3d\boneid+1
					b\id=b3d\boneid
;					db  (b3dchunksize())/8
					bsz=(b3dchunksize())/8

					b\verts=CreateBank(b3dchunksize())
;					b\weight=CreateBank(b3dchunksize())
;					Repeat
					WriteLine fileout,b\name$+"  "+bsz
					For lp=0 To	bsz-1
					bone=b3dReadInt()
					WriteLine (fileout,"Bone:"+b\id+" vertex:"+bone+" offset"+(lp*8)+" "+lp)
					weight#=b3dreadfloat()
					For v.vertice=Each vertice
					
					If v\ID=bone
						hand=Handle(v)
						Exit
					EndIf
					Next
					PokeInt(b\verts,(lp*8),hand)
					PokeFloat(b\verts,(lp*8)+4,weight)
;					db  bone+" "+weight
					Next
					
;					Until FilePos(b3d_file)=>b3d_stack(b3d_tos)

					b3dexitchunk()					
				Case "KEYS"
					
					b3d\animid=b3d\animid+1
					db  "KeyFrame Node"
					frame2=-1
					an.anim=New anim
					n\key=Handle(an)
					an\name$=n\name$
					an\id=b3d\animid
					an\flags=b3dreadint()
					db  an\flags
					Select an\flags
						Case 1
							sz=12
							an\PX#=CreateBank((b3dchunksize()/sz)*4)
							an\PY#=CreateBank((b3dchunksize()/sz)*4)
							an\PZ#=CreateBank((b3dchunksize()/sz)*4)
						Case 2
							sz=12		
							an\SX#=CreateBank((b3dchunksize()/sz)*4)
							an\SY#=CreateBank((b3dchunksize()/sz)*4)
							an\SZ#=CreateBank((b3dchunksize()/sz)*4)
						Case 3
							sz=24
							an\PX#=CreateBank((b3dchunksize()/sz)*4)
							an\PY#=CreateBank((b3dchunksize()/sz)*4)
							an\PZ#=CreateBank((b3dchunksize()/sz)*4)
							
							an\SX#=CreateBank((b3dchunksize()/sz)*4)
							an\SY#=CreateBank((b3dchunksize()/sz)*4)
							an\SZ#=CreateBank((b3dchunksize()/sz)*4)

						Case 4
							sz=16
							an\RW#=CreateBank((b3dchunksize()/sz)*4)
							an\RX#=CreateBank((b3dchunksize()/sz)*4)
							an\RY#=CreateBank((b3dchunksize()/sz)*4)
							an\RZ#=CreateBank((b3dchunksize()/sz)*4)

						Case 5
							sz=28
							an\PX#=CreateBank((b3dchunksize()/sz)*4)
							an\PY#=CreateBank((b3dchunksize()/sz)*4)
							an\PZ#=CreateBank((b3dchunksize()/sz)*4)
							
							an\RW#=CreateBank((b3dchunksize()/sz)*4)
							an\RX#=CreateBank((b3dchunksize()/sz)*4)
							an\RY#=CreateBank((b3dchunksize()/sz)*4)
							an\RZ#=CreateBank((b3dchunksize()/sz)*4)
							
						Case 6
							sz=28
							an\SX#=CreateBank((b3dchunksize()/sz)*4)
							an\SY#=CreateBank((b3dchunksize()/sz)*4)
							an\SZ#=CreateBank((b3dchunksize()/sz)*4)
		
							an\RW#=CreateBank((b3dchunksize()/sz)*4)
							an\RX#=CreateBank((b3dchunksize()/sz)*4)
							an\RY#=CreateBank((b3dchunksize()/sz)*4)
							an\RZ#=CreateBank((b3dchunksize()/sz)*4)
			
						Case 7
							sz=40
							an\PX#=CreateBank((b3dchunksize()/sz)*4)
							an\PY#=CreateBank((b3dchunksize()/sz)*4)
							an\PZ#=CreateBank((b3dchunksize()/sz)*4)
							
							an\SX#=CreateBank((b3dchunksize()/sz)*4)
							an\SY#=CreateBank((b3dchunksize()/sz)*4)
							an\SZ#=CreateBank((b3dchunksize()/sz)*4)
	
							an\RW#=CreateBank((b3dchunksize()/sz)*4)
							an\RX#=CreateBank((b3dchunksize()/sz)*4)
							an\RY#=CreateBank((b3dchunksize()/sz)*4)
							an\RZ#=CreateBank((b3dchunksize()/sz)*4)
					End Select																		
					Repeat
						frame=b3dReadInt()
						frame2=frame2+1
						;DebugLog frame
						;Delay 10
						an\frame=frame
;						an\oframe=frame
						
						Select an\flags
						Case 1
							value#=b3dreadfloat() : PokeFloat(an\px#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\py#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\pz#,frame2*4,value#)
						Case 2

							value#=b3dreadfloat() : PokeFloat(an\sx#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\sy#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\sz#,frame2*4,value#)
						Case 3

							value#=b3dreadfloat() : PokeFloat(an\px#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\py#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\pz#,frame2*4,value#)
									
							value#=b3dreadfloat() : PokeFloat(an\sx#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\sy#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\sz#,frame2*4,value#)										
						Case 4

							value#=b3dreadfloat() : PokeFloat(an\rw#,frame2*4,value#)							
							value#=b3dreadfloat() : PokeFloat(an\rx#,frame2*4,value#)							
							value#=b3dreadfloat() : PokeFloat(an\ry#,frame2*4,value#)							
							value#=b3dreadfloat() : PokeFloat(an\rz#,frame2*4,value#)		

						Case 5

							value#=b3dreadfloat() : PokeFloat(an\px#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\py#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\pz#,frame2*4,value#)

							
							value#=b3dreadfloat() : PokeFloat(an\rw#,frame2*4,value#)							
							value#=b3dreadfloat() : PokeFloat(an\rx#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\ry#,frame2*4,value#)							
							value#=b3dreadfloat() : PokeFloat(an\rz#,frame2*4,value#)		
						Case 6

							value#=b3dreadfloat() : PokeFloat(an\sx#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\sy#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\sz#,frame2*4,value#)
		
							value#=b3dreadfloat() : PokeFloat(an\rw#,frame2*4,value#)							
							value#=b3dreadfloat() : PokeFloat(an\rx#,frame2*4,value#)							
							value#=b3dreadfloat() : PokeFloat(an\ry#,frame2*4,value#)							
							value#=b3dreadfloat() : PokeFloat(an\rz#,frame2*4,value#)		
			
						Case 7

							value#=b3dreadfloat() : PokeFloat(an\px#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\py#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\pz#,frame2*4,value#)
							
							value#=b3dreadfloat() : PokeFloat(an\sx#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\sy#,frame2*4,value#)
							value#=b3dreadfloat() : PokeFloat(an\sz#,frame2*4,value#)
	
							value#=b3dreadfloat() : PokeFloat(an\rw#,frame2*4,value#)							
							value#=b3dreadfloat() : PokeFloat(an\rx#,frame2*4,value#)							
							value#=b3dreadfloat() : PokeFloat(an\ry#,frame2*4,value#)							
							value#=b3dreadfloat() : PokeFloat(an\rz#,frame2*4,value#)		
					End Select
					Until FilePos(b3d_file)=>b3d_stack(b3d_tos)
					db "FRAMES:"+frame
					b3dexitchunk()
				Case "ANIM"
					db  "Anim Node"
						
					b3dexitchunk()
				Default
					db  cnk$
					b3dexitchunk()
				End Select				
;				Delay 10
				Until FilePos(b3d_file)=>b3d_stack(tos)
				EndIf
				b3dexitchunk()
End Function

Function db (s$)
;	debuglog s$
	WriteLine fileout,s$
End Function

Function meshread(b3d.bglb3d)

					mtos=b3d_tos
					mbtrush=b3dreadint()
					db  "Master Brush:"+mbrush
					Repeat
					mb3d$=b3dReadchunk()
					Select mb3d$
					Case "TRIS"
						bid=b3dreadint()
						db BID
						If bid=-1 Then bid=0
						db  "TRIS BrushID:"+bid
						db  "CHUNK SIZE:"+(b3dchunksize())/12.
						If ((b3dchunksize())/12.)>1

						Repeat

;						t.triangle=New triangle
						b3d\tid=b3d\tid+1
;						t\ID=TID
;						db TID
						;t\brushID=bid
						If BankSize(b3d\tris[bid])=0
							b3d\tris[bid]=CreateBank(12)
						Else
							ResizeBank(b3d\tris[bid],BankSize(b3d\tris[bid])+12)
						EndIf
						off=b3d\tcnt[bID]*12
						Local verts[2]
						verts[0]=b3dReadInt()+b3d\ltid
						verts[1]=b3dReadInt()+b3d\ltid
						verts[2]=b3dReadInt()+b3d\ltid
						b3d\tcnt[bid]=b3d\tcnt[bid]+1
						PokeInt(b3d\tris[bid],off,verts[0])
						PokeInt(b3d\tris[bid],off+4,verts[1])
						PokeInt(b3d\tris[bID],off+8,verts[2])												
						WriteLine(fileout,brushID+" "+verts[0]+" "+verts[1]+" "+verts[2])
					;	Delay 100
						Until FilePos(b3d_file)=>b3d_stack(b3d_tos)
						EndIf
						b3dexitchunk()
	
					Case "VRTS"
						WriteLine(fileout, "VERTS")

						flags=b3dReadInt()
						texcords=b3dreadint()
						texsets=b3dreadint()
						WriteLine(fileout, flags+" "+texcords+" "+texsets)
						b3d\ltid=b3d\vid+1
						Repeat
						b3d\vid=b3d\vid+1
						;db  id
						v.vertice= First vertice
						v\id=b3d\vid
						v\X#=b3dreadfloat();*mult
						v\Y#=b3dreadfloat();*mult
						v\Z#=b3dreadfloat();*mult
						WriteLine(fileout,v\ID+" "+v\x+" "+v\y+" "+v\z)
						Select flags
						Case 1
						v\NX#=b3dreadfloat()
						v\NY#=b3dreadfloat()
						v\NZ#=b3dreadfloat()
						Case 2
						v\R=b3dreadfloat()
						v\G=b3dreadfloat()
						v\B=b3dreadfloat()
						v\A=b3dreadfloat()																		
						Case 3
						v\NX#=b3dreadfloat()
						v\NY#=b3dreadfloat()
						v\NZ#=b3dreadfloat()
						v\R=b3dreadfloat()
						v\G=b3dreadfloat()
						v\B=b3dreadfloat()
						v\A=b3dreadfloat()																								
						End Select
						For a=1 To texcords
						v\u[a]=b3dReadFloat()
						v\v[a]=b3dReadFloat()
						Next
						
						;For v.vertice=Each vertice
off=v\ID*12
off2=v\ID*8
If BankSize(b3d\vertex)=1
b3d\vertex=CreateBank(12)
Else
	ResizeBank(b3d\vertex,BankSize(b3d\vertex)+12)
EndIf

If BankSize(b3d\norms)=1
b3d\norms=CreateBank(12)
Else
	ResizeBank(b3d\norms,BankSize(b3d\norms)+12)
EndIf


If BankSize(b3d\colour)=1
b3d\colour=CreateBank(16)
Else
	ResizeBank(b3d\colour,BankSize(b3d\colour)+16)
EndIf

If BankSize(b3d\uv[1])=1
b3d\uv[1]=CreateBank(8)
Else
	ResizeBank(b3d\uv[1],BankSize(b3d\uv[1])+8)
EndIf

If BankSize(b3d\uv[2])=1
b3d\uv[2]=CreateBank(8)
Else
	ResizeBank(b3d\uv[2],BankSize(b3d\uv[2])+8)
EndIf

PokeFloat(b3d\vertex,off,v\X#)
PokeFloat(b3d\vertex,off+4,v\Y#)
PokeFloat(b3d\vertex,off+8,v\Z#)
PokeFloat(b3d\norms,off,v\NX#)
PokeFloat(b3d\norms,off+4,v\NY#)
PokeFloat(b3d\norms,off+8,v\NZ#)
PokeFloat(b3d\colour,off,v\R#)
PokeFloat(b3d\colour,off+4,v\g#)
PokeFloat(b3d\colour,off+8,v\b#)
PokeFloat(b3d\colour,off+12,v\A#)
PokeFloat(b3d\uv[1],off2,v\u[1])
PokeFloat(b3d\uv[1],off2+4,-v\v[1])
PokeFloat(b3d\uv[2],off2,v\u[2])
PokeFloat(b3d\uv[2],off2+4,-v\v[2])
;Delete v
;Next
						Until FilePos(b3d_file)=>b3d_stack(b3d_tos)

						b3dexitchunk()
					;	ltid=vid+1
						;db  mb3d$
					End Select

;					Readb yte(b3d_file)
					Until FilePos(b3d_file)=>b3d_stack(mtos)
End Function

; b3d functions

;
;b3d file utils to be included
;



Function b3dSetFile( file )
	b3d_tos=0
	b3d_file=file
End Function

;***** functions for reading from B3D files *****

Function b3dReadbyte()
	Return ReadByte( b3d_file )
End Function

Function b3dReadInt()
	Return ReadInt( b3d_file )
End Function

Function b3dReadFloat#()
	Return ReadFloat( b3d_file )
End Function

Function b3dReadString$()
	Repeat
		ch=b3dReadbyte()
		If ch=0 Return t$
		t$=t$+Chr$(ch)
	Forever
End Function

Function b3dReadChunk$()
	For k=1 To 4
		tag$=tag$+Chr$(b3dReadbyte())
	Next
	sz=ReadInt( b3d_file )
	b3d_tos=b3d_tos+1
	b3d_stack(b3d_tos)=FilePos( b3d_file )+sz
	Return tag$
End Function

Function b3dExitChunk()
	SeekFile b3d_file,b3d_stack(b3d_tos)
	b3d_tos=b3d_tos-1
End Function

Function b3dChunkSize()
	Return b3d_stack(b3d_tos)-FilePos( b3d_file )
End Function

;***** Functions for writing to B3D files *****

Function b3dWriteByte( n )
	WriteByte( b3d_file,n )
End Function

Function b3dWriteInt( n )
	WriteInt( b3d_file,n )
End Function

Function b3dWriteFloat( n# )
	WriteFloat( b3d_file,n )
End Function

Function b3dWriteString( t$ )
	For k=1 To Len( t$ )
		ch=Asc(Mid$(t$,k,1))
		b3dWriteByte(ch)
		If ch=0 Return
	Next
	b3dWriteByte( 0 )
End Function

Function b3dbeginChunk( tag$ )
	b3d_tos=b3d_tos+1
	For k=1 To 4
		b3dWriteByte(Asc(Mid$( tag$,k,1 )))
	Next
	b3dWriteInt( 0 )
	b3d_stack(b3d_tos)=FilePos( b3d_file )
End Function

Function b3dEndChunk()
	n=FilePos( b3d_file )
	SeekFile b3d_file,b3d_stack(b3d_tos)-4
	b3dWriteInt( n-b3d_stack(b3d_tos) )
	SeekFile b3d_file,n
	b3d_tos=b3d_tos-1
End Function



Function QuatToEuler(out.Rotation, src.Quat)
	Local sint#, cost#, sinv#, cosv#, sinf#, cosf#
	Local cost_temp#

	sint = (2 * src\w * src\y) - (2 * src\x * src\z)
	cost_temp = 1.0 - (sint * sint)

	If Abs(cost_temp) > QuatToEulerAccuracy
		cost = Sqr(cost_temp)
	Else
		cost = 0
	EndIf

	If Abs(cost) > QuatToEulerAccuracy
		sinv = ((2 * src\y * src\z) + (2 * src\w * src\x)) / cost
		cosv = (1 - (2 * src\x * src\x) - (2 * src\y * src\y)) / cost
		sinf = ((2 * src\x * src\y) + (2 * src\w * src\z)) / cost
		cosf = (1 - (2 * src\y * src\y) - (2 * src\z * src\z)) / cost
	Else
		sinv = (2 * src\w * src\x) - (2 * src\y * src\z)
		cosv = 1 - (2 * src\x * src\x) - (2 * src\z * src\z)
		sinf = 0
		cosf = 1
	EndIf

	; Generate the output rotation
	out\roll =- ATan2(sinv, cosv) ;  inverted due to change in handedness of coordinate system
	out\pitch = -ATan2(sint, cost)
	out\yaw = ATan2(sinf, cosf)
End Function

Function quatToMat( qa.quat,m.matrix33)
	Local q#[4]
	
	q[0]=qa\w
	q[1]=qa\x
	q[2]=qa\y
	q[3]=qa\z
	xx#=q[1]*q[1] : yy#=q[2]*q[2] : zz#=q[3]*q[3];
	xy#=q[1]*q[2] : xz#=q[1]*q[3] : yz#=q[2]*q[3];
	wx#=q[0]*q[1] : wy#=q[0]*q[2] : wz#=q[0]*q[3];

	m\mat[0]=1-2*(yy+zz) : m\mat[1]=  2*(xy-wz) : m\mat[2]=  2*(xz+wy);
	m\mat[3]=  2*(xy+wz) : m\mat[4]=1-2*(xx+zz) : m\mat[5]=  2*(yz-wx);
	m\mat[6]=  2*(xz-wy) : m\mat[7]=  2*(yz+wx) : m\mat[8]=1-2*(xx+yy);	
End Function


Function bgldrawb3d(b3d.bglb3d)

	glDisableClientState(GL_VERTEX_ARRAY)
	glDisableClientState(GL_NORMAL_ARRAY)	
	glDisableClientState(GL_COLOR_ARRAY)
	glDisableClientState(GL_TEXTURE_COORD_ARRAY);

	glEnableClientState(GL_VERTEX_ARRAY)
	glEnableClientState(GL_NORMAL_ARRAY)	
	glEnableClientState(GL_COLOR_ARRAY)

	glVertexPointer(3,gl_float,0,b3d\vertex)
	glNormalPointer(GL_FLOAT,0,b3d\norms)
	glColorpointer(4,gl_float,0,b3d\colour)
	glEnableClientState(GL_TEXTURE_COORD_ARRAY)	
	glDisable(GL_blend)
;	glDisable(gl_texture_2d)
;	glEnable(gl_texture_2d)
;	
	
	For nbid=0 To b3d\numbrush
	hnd=PeekInt(b3d\brush,nbid*4)
		br.brush=Object.brush(hnd)
		For t=0 To (BankSize(b3d\texture)/4)-1
				tx.texture=Object.texture(PeekInt(b3d\texture,t*4))
				
				For a=0 To 1
				If a=>b3d\bnum
			;	glClientActiveTextureARB(GL_TEXTURE0_ARB+a);
			;	glDisable(gl_texture_2d)
			;	glTexCoordPointer(2,GL_FLOAT,0,b3d\UV[a+1])
			;	glEnableClientState(GL_TEXTURE_COORD_ARRAY);
			
				glActiveTextureARB(GL_TEXTURE0_ARB+a);
				glDisable(gl_texture_2d)				
				Else If TX\ID=br\texture[a+1]	
					
					glClientActiveTextureARB(GL_TEXTURE0_ARB+a);
					;glDisable(gl_texture_2d)
					glTexCoordPointer(2,GL_FLOAT,0,b3d\UV[a+1])
					glEnableClientState(GL_TEXTURE_COORD_ARRAY);
					;glDisable(gl_texture_2d)
					glActiveTextureARB(GL_TEXTURE0_ARB+a);
					
					glEnable(gl_texture_2d)
					glBindTexture(GL_TEXTURE_2D,tx\tex)

				EndIf
			Next
		Next
				glDrawElements(GL_TRIANGLES,BankSize(b3d\tris[nbid])/4,GL_UNSIGNED_INT,b3d\tris[nbid])		
;				glDrawArrays(GL_TRIANGLES,0,BankSize(b3d\tris[nbid])/4)
Next
;Stop
End Function

Function drawanim(n.node,parent)

	For n2.node=Each node
		If n2\parent=n\hand
			If n2\key>0
				an.anim=Object.anim(n2\key)
				DebugLog an\frame+" "+animframe
				If an\frame=animframe
				b.bone=Object.bone(n2\bone)
				out.quat=New quat

				If an\flags=>4 			
					out\w=PeekFloat(an\rw,(animframe*4)) 
					out\x=PeekFloat(an\rx,(animframe*4)) 
					out\y=PeekFloat(an\ry,(animframe*4)) 
					out\z=PeekFloat(an\rz,(animframe*4))
					out\z=-out\z
					in.rotation=New rotation
					quattoeuler(in,out)
					Delete out
					Rp2#=in\pitch
					Ry2#=in\yaw
					Rr2#=in\roll
					Delete in	
				;	Delete out2
					glPushMatrix()
					glTranslatef(n2\x,n2\y,n2\z)
					glRotatef(ry2,0.0,0.0,1.0)		
					glRotatef(rp2,0.0,1.0,0.0)  ; rr
					glRotatef(rr2,1.0,0.0,0.0)  ; rp			
				Else
					glPushMatrix()
					glTranslatef(n2\x,n2\y,n2\z)
				EndIf
				sdf
				
				drawanim(n2.node,n2\parent)
				EndIf	
			Else
				glPushMatrix()
				glTranslatef(n2\x,n2\y,n2\z)
				
			sdf
				drawanim(n2.node,n2\parent)	


			EndIf
		EndIf
	Next
			glPopMatrix()	
	
End Function


Function ddrawanim(n.node,parent)

	For n2.node=Each node
		If n2\parent=n\hand
		;	DebugLog n\key+" "+n\name$
		;	WaitKey
		If n2\key>0
			an.anim=Object.anim(n2\key)
			b.bone=Object.bone(n2\bone)
			out.quat=New quat
			out2.quat=New quat			
			out2\w=n2\rw
			out2\x=n2\rx
			out2\y=n2\ry
			out2\z=-n2\rz
			If an\flags=>4 			
			out\w=PeekFloat(an\rw,(animframe*4)) 
			out\x=PeekFloat(an\rx,(animframe*4)) 
			out\y=PeekFloat(an\ry,(animframe*4)) 
			out\z=PeekFloat(an\rz,(animframe*4))
			out\z=-out\z
			in.rotation=New rotation
;			
			quattoeuler(in,out)
			
			Delete out
			
;		Rp#=in\roll
;		Ry#=in\pitch
;		Rr#=in\yaw  
;		quattoeuler(in,out2)
				Rp2#=in\pitch
				Ry2#=in\yaw
				Rr2#=in\roll
				Delete in	
				Delete out2
				glPushMatrix()
	
				glTranslatef(n2\x,n2\y,n2\z)
	
				glRotatef(ry2,0.0,0.0,1.0)		
				glRotatef(rp2,0.0,1.0,0.0)  ; rr
				glRotatef(rr2,1.0,0.0,0.0)  ; rp			
			Else
				glPushMatrix()
				glTranslatef(n2\x,n2\y,n2\z)
			EndIf
	;	mx#=PeekFloat(an\px,(animframe*4))
	;	MY#=PeekFloat(an\py,(animframe*4))
	;	MZ#=PeekFloat(an\pZ,(animframe*4))							

;			glBegin(gl_lines)
			


			sdf
	;		glCallList(b\mesh)

;		

			ddrawanim(n2.node,n2\parent)	




;			glEnd()
			EndIf
		EndIf
	Next
			glPopMatrix()	
	
End Function

	
Function drawnode(n.node,parent)

	For n2.node=Each node
		If n2\parent=n\hand

			out2.quat=New quat			
			out2\w=n2\rw
			out2\x=n2\rx
			out2\y=n2\ry
			out2\z=-n2\rz
			in.rotation=New rotation
			quattoeuler(in,out2)
			
			Delete out2
			
				Rp2#=in\pitch
				Ry2#=in\yaw
				Rr2#=in\roll
				Delete in	

				glPushMatrix()
	
				glTranslatef(n2\x,n2\y,n2\z)	
				glRotatef(ry2,0.0,0.0,1.0)		
				glRotatef(rp2,0.0,1.0,0.0)  ; rr
				glRotatef(rr2,1.0,0.0,0.0)  ; rp			

			sdf
			If n2\model<>0
			temp.bglb3d=Object.bglb3d(n2\model)
			glScalef(4,4,4)
			bgldrawb3d(temp)
			EndIf
			drawnode(n2.node,n2\parent)	
			EndIf			
		
	Next
			glPopMatrix()	
	
End Function