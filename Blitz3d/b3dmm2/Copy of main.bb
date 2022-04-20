; Might and Magic 2 Main source file, this is being rewritten to have the outside as one whole level.
; Copyright 2002 Adam Templeton.
Graphics3D 640,480,32,2
Include "smx.bb"
Const pname$="Might and Magic ][ SE ";Escape skips 2d maps, space 3d maps"
Const version=0.1
Const segs=1,width#=2,depth#=1.125
AppTitle pname$;,"Exit "+name$
Dim mapdata$(16,16,3)
Type map
	Field Area		; area number 0-59
	Field envion	; 0 town, 1=cavern, 2=castle, 3=outside
	Field Name$		; Name of area,ie A1,middlegate.
	Field Exits[4]
	Field mapdata$[256]
	Field roofdata[256] ; 0 empty, 1 roof
	Field events[256] ;=0 no event, 1=event, later the event.dat will be used to give them there proper numbers
	Field surface
	Field surfloc[2]
	Field entity[3]
	Field mesh
End Type


Global camera=CreateCamera()
;PositionEntity camera,10,25,-30
;RotateEntity camera,40,-30,0
	CameraRange camera,1,20
	light=CreateLight()
	RotateEntity light,0,0,0

loadmap()

For map.map=Each map
ShowEntity map\mesh
While Not KeyHit(1)
RenderWorld
UpdateWorld
	If KeyDown( 205 )=True Then TurnEntity camera,0,-2,0
;	If KeyDown( 205 )=True Then TurnEntity camera,0,-2,0	
	If KeyDown( 203 )=True Then TurnEntity camera,0,2,0
;	If KeyDown( 203 )=True Then TurnEntity a,0,2,0
	If KeyDown( 208 )=True Then MoveEntity camera,0,0,-0.05
	If KeyDown( 200 )=True Then MoveEntity camera,0,0,0.05
	;If KeyDown(57) Then Flip
Flip
Wend
HideEntity map\mesh
FlushKeys()
DebugLog map\area
Next
EndGraphics
End

Function loadmap()
mapd=OpenFile("map.dat")
attrib=OpenFile("attrib.dat")

For area=0 To 1
map.map=New map
map\area=area
Select area
Case 0
	map\name$="Middlegate"
Case 1
	map\name$="Atlantium"
Case 2
	map\name$="Tundra"
Case 3
	map\name$="Volcania"
Case 4
	map\name$="Sandsobar"
Case 17
	map\name$="Middlegate Cavern"
Case 18
	map\name$="Atlantium Cavern"
Case 19
	map\name$="Tundra Cavern"
Case 20
	map\name$="Volcania Cavern"
Case 21
	map\name$="Sandsobar Cavern"
Case 22
	map\name$="Coraks Cave"
Case 23
	map\name$="Square Isle"
Case 24
	map\name$="Tundra Cave"
Case 25
	map\name$="Sarkins Mine"
Case 26
	map\name$="Murry's Resort"
Case 27
	map\name$="Druids Cavern"
Case 28
	map\name$="Forbiddin Forest Cavern"
Case 29
	map\name$="Dragons Dominion"
Case 30
	map\name$="Dawns Mist Bog"
Case 31
	map\name$="Gemmakers"	
Case 32
	map\name$="Normadic Rift"	
	Case 41
	map\name$="Elemental Plain of Air"	
Case 42
	map\name$="Elemental Plain of Fire"	
Case 43
	map\name$="Elemental Plain of Earth"	
Case 44
	map\name$="Elemental Plain of Water"	
Case 45
	map\name$="dungeon Level 1"	
Case 46
	map\name$="dungeon Level 2"	
Case 47
	map\name$="dungeon Level 1"	
Case 48
	map\name$="dungeon Level 2"	
Case 49
	map\name$="dungeon Level 1"	
Case 50
	map\name$="dungeon Level 2"	
Case 51
	map\name$="Woodhaven Dungeon level 1"	
Case 52
	map\name$="Woodhaven Dungeon Level 2"	

	Case 53
	map\name$="Ancients (Good)"	
	Case 54
	map\name$="Ancients (Evil)"	
	Case 55
	map\name$="Woodhaven"
		Case 56
	map\name$="Hillstone"	
	Case 57
	map\name$="Pinehurst"	
	Case 58
	map\name$="Luxus Palace Royale"	
	Case 59
	map\name$="the One in 800"	

End Select

aloc=(area*64)
mloc=(area*512)
SeekFile( mapd,mloc)
SeekFile(attrib,aloc+4)
tmp=ReadByte(attrib)
If tmp>0
	map\envion=3
	SeekFile(attrib,aloc+21)
	map\name$="Outside Area: "+Right(Hex(ReadByte(attrib)),2)
Else
	SeekFile(attrib,aloc+3)
	tmp=ReadByte(attrib)
	Select tmp
	Case 17
		map\envion=0
	Case 18
		map\envion=1
	Case 19
		map\envion=2
	Case 20
		map\envion=2
	End Select
EndIf

DebugLog map\area+" :"+(FilePos(mapd))+" "+(FilePos(attrib))+" Envion:"+map\envion+" Name:"+map\name
For loc=0 To 255
temp$=ReadByte(mapd)
ts$=Right$(Bin$(temp$),8)
map\mapdata[loc]=ts$
Next
SeekFile(attrib,aloc+32)
For a=0 To 255 Step 8
;DebugLog "roof: "+a
roof=ReadByte(attrib)
DebugLog Right(Bin(roof),8)
map\roofdata[a]=Mid(Right(Bin(roof),8),1,1)
map\roofdata[a+1]=Mid(Right(Bin(roof),8),2,1)
map\roofdata[a+2]=Mid(Right(Bin(roof),8),3,1)
map\roofdata[a+3]=Mid(Right(Bin(roof),8),4,1)
map\roofdata[a+4]=Mid(Right(Bin(roof),8),5,1)
map\roofdata[a+5]=Mid(Right(Bin(roof),8),6,1)
map\roofdata[a+6]=Mid(Right(Bin(roof),8),7,1)
map\roofdata[a+7]=Mid(Right(Bin(roof),8),8,1)
Next
Next

				;Mid$(map\mapdata[a],5,4)=Mid$(ts$,1,4)
				;mapdata2$(x,y,loop,me,1)=Mid$(ts$,5,4)
				;mapdata$(x,y,0,loop,me)=Mid$(ts$,1,2)
				;mapdata$(x,y,1,loop,me)=Mid$(ts$,3,2)
				;mapdata$(x,y,2,loop,me)=Mid$(ts$,5,2)
				;mapdata$(x,y,3,loop,me)=Mid$(ts$,7,2)
tiles=LoadImage("Tiles.jpg")	
For map.map=Each map
UpdateWorld
RenderWorld
a=0
map\mesh=CreateMesh()
If map\envion<3

	For x=0 To 15
		For y=0 To 15
		If map\roofdata[a]=1
			createroof(map\mesh,(0-(x*width#-1)+29),(0-(y*width#-1)+28))
;			PositionMesh wall(x),1-(x*width#-1)*-1,1,0-(y*width#-1)*-1
	;		PositionMesh wall(x),0-(x*width#-1),1,(y*width#-1)
		EndIf
		ya=160-(x*10)
		xa=10+(y*10)
			If Mid$(map\mapdata[a],1,2)="00"
			Color(0,0,0)
			ElseIf Mid$(map\mapdata[a],1,2)="01"
			createwalla(1,0,map\mesh,y*width#,x*width#)
			Color(125,125,125)
			ElseIf Mid$(map\mapdata[a],1,2)="10"
			createwalla(2,0,map\mesh,y*width#,x*width#)
			Color(255,255,255)
			ElseIf Mid$(map\mapdata[a],1,2)="11"
			createwalla(3,0,map\mesh,y*width#,x*width#)
			Color(125,125,255)
			EndIf
			Line xa,ya,xa+9,ya
			If Mid$(map\mapdata[a],3,2)="00"
			Color(0,0,0)
			ElseIf Mid$(map\mapdata[a],3,2)="01"
			createwallb(1,0,map\mesh,y*width#,x*width#)
			Color(125,125,125)
			ElseIf Mid$(map\mapdata[a],3,2)="10"
				createwallb(2,0,map\mesh,y*width#,x*width#)
			Color(255,255,255)
			ElseIf Mid$(map\mapdata[a],3,2)="11"
			createwallb(3,0,map\mesh,y*width#,x*width#)
			Color(125,125,255)
			EndIf
			Line xa+9,ya+9,xa+9,ya
			If Mid$(map\mapdata[a],5,2)="00"
			Color(0,0,0)
			ElseIf Mid$(map\mapdata[a],5,2)="01"
						createwallc(1,0,map\mesh,y*width#,x*width#)
			Color(125,125,125)
				ElseIf Mid$(map\mapdata[a],5,2)="10"
							createwallc(2,0,map\mesh,y*width#,x*width#)
			Color(255,255,255)
			ElseIf Mid$(map\mapdata[a],5,2)="11"
							createwallc(3,0,map\mesh,y*width#,x*width#)
			Color(125,125,255)
			EndIf
			Line xa,ya+9,xa+9,ya+9
		
			If Mid$(map\mapdata[a],7,2)="00"

			Color(0,0,0)
			ElseIf Mid$(map\mapdata[a],7,2)="01"
						createwalld(1,0,map\mesh,y*width#,x*width#)
			Color(125,125,125)
			ElseIf Mid$(map\mapdata[a],7,2)="10"
							createwalld(2,0,map\mesh,y*width#,x*width#)
			Color(255,255,255)
			ElseIf Mid$(map\mapdata[a],7,2)="11"
							createwalld(3,0,map\mesh,y*width#,x*width#)
			Color(125,125,255)
			EndIf
		    Line xa,ya,xa,ya+9
		
			a=a+1

Next
Next
Color(255,255,255)
Text 0,0,map\area+" :"+(FilePos(mapd))+" "+(FilePos(attrib))+" Envion:"+map\envion+" Name:"+map\name

Else 
Text 0,0,map\area+" :"+(FilePos(mapd))+" "+(FilePos(attrib))+" Envion:"+map\envion+" Name:"+map\name
	For x=0 To 15
		For y=0 To 15
	xa=16-(x)

;		DebugLog Mid$(map\mapdata[a],5,4)
		If Mid$(map\mapdata[a],5,4)="0000"
			ox=0
		ElseIf Mid$(map\mapdata[a],5,4)="0001"
			ox=1
		ElseIf Mid$(map\mapdata[a],5,4)="0010"
			ox=2
		ElseIf Mid$(map\mapdata[a],5,4)="0011"
			ox=3
		ElseIf Mid$(map\mapdata[a],5,4)="0100"
			ox=4
		ElseIf Mid$(map\mapdata[a],5,4)="0101"
			ox=5
		ElseIf Mid$(map\mapdata[a],5,4)="0110"
			ox=6
		ElseIf Mid$(map\mapdata[a],5,4)="0111"
			ox=7
		ElseIf Mid$(map\mapdata[a],5,4)="1000"
			ox=8
		ElseIf Mid$(map\mapdata[a],5,4)="1001"
			ox=9
		ElseIf Mid$(map\mapdata[a],5,4)="1010"
			ox=10
		ElseIf Mid$(map\mapdata[a],5,4)="1011"
			ox=11
		ElseIf Mid$(map\mapdata[a],5,4)="1100"
			ox=12
		ElseIf Mid$(map\mapdata[a],5,4)="1101"
			ox=13
		ElseIf Mid$(map\mapdata[a],5,4)="1110"
			ox=14
		ElseIf Mid$(map\mapdata[a],5,4)="1111"
			ox=15
		EndIf
		
				If Mid$(map\mapdata[a],1,4)="0000"
			oy=15
		ElseIf Mid$(map\mapdata[a],1,4)="0001"
			oy=14
		ElseIf Mid$(map\mapdata[a],1,4)="0010"
			oy=13
		ElseIf Mid$(map\mapdata[a],1,4)="0011"
			oy=12
		ElseIf Mid$(map\mapdata[a],1,4)="0100"
			oy=11
		ElseIf Mid$(map\mapdata[a],1,4)="0101"
			oy=10
		ElseIf Mid$(map\mapdata[a],1,4)="0110"
			oy=9
		ElseIf Mid$(map\mapdata[a],1,4)="0111"
			oy=8
		ElseIf Mid$(map\mapdata[a],1,4)="1000"
			oy=7
		ElseIf Mid$(map\mapdata[a],1,4)="1001"
			oy=6
		ElseIf Mid$(map\mapdata[a],1,4)="1010"
			oy=5
		ElseIf Mid$(map\mapdata[a],1,4)="1011"
			oy=4
		ElseIf Mid$(map\mapdata[a],1,4)="1100"
			oy=3
		ElseIf Mid$(map\mapdata[a],1,4)="1101"
			oy=2
		ElseIf Mid$(map\mapdata[a],1,4)="1110"
			oy=1
		ElseIf Mid$(map\mapdata[a],1,4)="1111"
			oy=0
		EndIf
		a=a+1
		DrawBlockRect tiles,(y)*28,(xa)*22,((ox)*28),(oy)*22,28,22
Next
Next
EndIf
HideEntity map\mesh
Flip
;WaitKey
Cls
Next
End Function


Function createwalla(pict,c,mesh,px,py)
If c=1
EntityType mesh,type_wall
EntityAlpha mesh,0
EndIf
surf=CreateSurface( mesh )
;DebugLog surf
For k=0 To segs
	x#=Float(k)*width/segs-width/2
	u#=Float(k)/segs
;	DebugLog px
;	DebugLog py
;	DebugLog X#
;	DebugLog "__"
;	DebugLog px+x
;	DebugLog py+(-1)
	AddVertex surf,px+x,(width/2),py,u,0
	AddVertex surf,px+x,-(width/2),py,u,1
Next
For k=0 To segs-1
	AddTriangle surf,k*2,k*2+2,k*2+3
	AddTriangle surf,k*2,k*2+3,k*2+1	
Next
paintwall(surf,pict)
End Function

Function createwallb(pict,c,mesh,px,py)
If c=1
EntityType mesh,type_wall
EntityAlpha mesh,0
EndIf
surf=CreateSurface( mesh )
;DebugLog surf
For k=0 To segs
	x#=Float(k)*width/segs-width/2
	u#=Float(k)/segs
;	DebugLog px
;	DebugLog py
;	DebugLog X#
;	DebugLog "__"
;	DebugLog px+x
;	DebugLog py+(-1)
	AddVertex surf,px+1,(width/2),(py-x)-1,u,0
	AddVertex surf,px+1,-(width/2),(py-X)-1,u,1
	
Next
For k=0 To segs-1
	AddTriangle surf,k*2,k*2+2,k*2+3
	AddTriangle surf,k*2,k*2+3,k*2+1	
Next
paintwall(surf,pict)
End Function

Function createwallc(pict,c,mesh,px,py)
If c=1
EntityType mesh,type_wall
EntityAlpha mesh,0
EndIf
surf=CreateSurface( mesh )
;DebugLog surf
For k=0 To segs
	x#=Float(k)*width/segs-width/2
	u#=Float(k)/segs
;	DebugLog px
;	DebugLog py
;	DebugLog X#
;	DebugLog "__"
;	DebugLog px+x
;	DebugLog py+(-1)
	AddVertex surf,px-x,(width/2),py-2,u,0
	AddVertex surf,px-x,-(width/2),py-2,u,1
Next
For k=0 To segs-1
	AddTriangle surf,k*2,k*2+2,k*2+3
	AddTriangle surf,k*2,k*2+3,k*2+1	
Next
paintwall(surf,pict)
End Function
Function createwalld(pict,c,mesh,px,py)
If c=1
EntityType mesh,type_wall
EntityAlpha mesh,0
EndIf
surf=CreateSurface( mesh )
;DebugLog surf
For k=0 To segs
	x#=Float(k)*width/segs-width/2
	u#=Float(k)/segs
;	DebugLog px
;	DebugLog py
;	DebugLog X#
;	DebugLog "__"
;	DebugLog px+x
;	DebugLog py+(-1)
	AddVertex surf,px-1,(width/2),(py+x)-1,u,0
	AddVertex surf,px-1,-(width/2),(py+x)-1,u,1
Next
For k=0 To segs-1
	AddTriangle surf,k*2,k*2+2,k*2+3
	AddTriangle surf,k*2,k*2+3,k*2+1	
Next
paintwall(surf,pict)
End Function
Function paintwall(surf,pict)
		If pict=1
			b=LoadBrush( "Textures\wall.jpg",8)
		ElseIf pict=2
			b=LoadBrush( "Textures\wall2.jpg",8)
		ElseIf pict=3
			b=LoadBrush( "Textures\wall3.jpg",8)
		EndIf
;		If pict=1
;			b=LoadBrush( "Textures\dwall.jpg",8)
;		ElseIf pict=2
;			b=LoadBrush( "Textures\dwall2.jpg",8)	
;		ElseIf pict=3
;			b=LoadBrush( "Textures\dwall3.jpg",8)
;		EndIf
;		If pict=1
;			b=LoadBrush( "Textures\cwall.jpg",8)
;		ElseIf pict=2
;			b=LoadBrush( "Textures\cwall2.jpg",8)
;		ElseIf pict=3
;			b=LoadBrush( "Textures\cwall3.jpg",8)
;		EndIf
PaintSurface surf,b
Return surf
End Function

Function createroof(mesh,px,py)
surf=CreateSurface( mesh )
For k=0 To segs
	x#=Float(k)*width/segs-width/2
	u#=Float(k)/segs
	AddVertex surf,Px+x,1,py,u,0
	AddVertex surf,px+x,1,py,u,1
Next
For k=0 To segs-1
	AddTriangle surf,k*2,k*2+2,k*2+3
	AddTriangle surf,k*2,k*2+3,k*2+1	
Next
;	If blah=1
	b=LoadBrush( "Textures\road.jpg")
PaintSurface surf,b
;EndIf
End Function
