Global fo=WriteFile("mm2.Log")
Global cmap=0, envion=0
Global oarea=0
Global texture[20]
Global texminimap[30]
Global font
Global base
Global direction=2
Dim drch$(4)
drch(0)="N"
drch(1)="E"
drch(2)="S"
drch(3)="W"

Dim AreamodX(20)
Dim areamody(20)
Restore amod
For a=0 To 19

Read areamodX(a)

Read areamody(a)
DebugLog areamodX(a)+" "+areamodY(a)
Next

Include "includes/BLITZGL.bb"
Include "includes/GLcamera.bb"

Include "init.bb"
init()
	fullscreen=Confirm("Do you wish to run in Fullscreen mode?")
	gltitle$="Might and Magic II"
	; Create Our OpenGL Window
	Global winwid=1024 : Global winhgt=768; these vars hold the window width and height.
	If Not Fullscreen
		GLWindow=CreateWindow(GLtitle$,(ClientWidth(Desktop())/2)-winwid/2,(ClientHeight(Desktop())/2)-winhgt/2,winwid,winhgt,0,%0011)
	Else
		GLWindow=CreateWindow(GLtitle$,0,0,winwid,winhgt,0,0)
		fswindow=CreateGLWindow("",winwid,winhgt,16,60,1)
	EndIf
	; for more info about the next 4 lines look at the "How This Works" section in the Documentation
	bglGetBlitzWindow(16,GLtitle$) ; this grabs the Blitz, and sets it up to the required standard, 
	bglFindChild(10,10)				   ; finds the child part of the screen, this is what is used for the GL canvas.
	bglSetupGL()					   ; makes OpenGL work on that Canvas
	


initGL()
fillcollision(cmap)
fillevent(cmap)
timer=CreateTimer(100)

	done=False
	While Not Done

		WaitEvent()									; waits for a event this could be anything.
		walk()
Select EventID()
		Case Event_Key_stroke									;
			If KeyHit(1)	done=True
			Case Event_Window_size
			ReSizeglscene(EventX(),EventY())

		Case Event_Window_close
			done=True	

		Case $4001
			DrawGLScene()
	curTime = MilliSecs()
	If curTime > checkTime Then
		checkTime = curTime + 1000
		curFPS = fpscounter
	 	fpscounter = 0
	Else
 		fpscounter = fpscounter + 1
	 End If
			Flip		
	End Select
	SetStatusText glwindow,curfps
	Wend
	If fswindow<>0
		KillGLWindow()
	EndIf
	End
	






Function walk()
	keyboard()									; do keyboard stuff
End Function
Function keyboard()

		If KeyHit(30) Or KeyHit(203) Or JoyDown(16) 
		;bglstrafeCamera(camera,-.01)
		RotateCamera(camera,90,0,1,0)
		direction=direction-1
		If direction<0 direction=3
	EndIf
	If KeyHit(205) Or KeyHit(32)	Or JoyDown(14)
; right
		RotateCamera(camera,90,0,-1,0)
				direction=direction+1
		If direction>3 direction=0
	EndIf
	If KeyHit(200)	Or KeyHit(17)	Or JoyDown(13)
; up
	If Not checkcollision(Int(Floor(camera\PX/1.50))-areamodX(oarea),Int(Floor(-(camera\Pz/1.50)))+areamodY(oarea),direction)
				lastPX#=camera\PX : lastVX#=camera\vx

				lastPZ#=camera\Pz : lastVZ#=camera\vZ
			bglMoveCamera(camera,1.5,1)
			If envion<3
				If Int(Floor(-(camera\Pz/1.50)))<0	
					camera\PZ=lastPZ
					camera\VZ=lastVZ
				EndIf
				If Int(Floor(camera\PX/1.50))<0 
					camera\px=lastPX
					camera\Vx=lastVX					
				EndIf
				If Int(Floor(-(camera\Pz/1.50)))>15
					camera\PZ=lastPZ
					camera\VZ=lastVZ
				EndIf
				If Int(Floor(camera\PX/1.50))>15
					camera\px=lastPX
					camera\Vx=lastVX					
				EndIf
							Else
				If Int(Floor(-(camera\Pz/1.50)))<-48	
					camera\PZ=lastPZ
					camera\VZ=lastVZ
				EndIf
				If Int(Floor(camera\PX/1.50))<0
					camera\px=lastPX
					camera\Vx=lastVX					
				EndIf
				If Int(Floor(-(camera\Pz/1.50)))>15
					camera\PZ=lastPZ
					camera\VZ=lastVZ
				EndIf
				If Int(Floor(camera\PX/1.50))>79
					camera\px=lastPX
					camera\Vx=lastVX				
			EndIf
		EndIf
	EndIf
	
	If KeyHit(208)	Or KeyHit(31)	Or JoyDown(15) 
; down
	If direction=0 bd=2
	If direction=1 bd=3
	If direction=2 bd=0
	If direction=3 bd=1
		If Not checkcollision(Int(Floor(camera\PX/1.50))-areamodX(oarea),Int(Floor(-(camera\Pz/1.50)))+areamodY(oarea),bd)

				lastPX#=camera\PX : lastVX#=camera\vx
;		lastPY#=camera\PY
				lastPZ#=camera\Pz : lastVZ#=camera\vZ

				bglMoveCamera(camera,-1.5,1)
		If envion<3
				If Int(Floor(-(camera\Pz/1.50)))<0	
					camera\PZ=lastPZ
					camera\VZ=lastVZ
				EndIf
				If Int(Floor(camera\PX/1.50))<0 
					camera\px=lastPX
					camera\Vx=lastVX					
				EndIf
				If Int(Floor(-(camera\Pz/1.50)))>15
					camera\PZ=lastPZ
					camera\VZ=lastVZ
				EndIf
				If Int(Floor(camera\PX/1.50))>15
					camera\px=lastPX
					camera\Vx=lastVX					
				EndIf

			Else
				If Int(Floor(-(camera\Pz/1.50)))<-48	
					camera\PZ=lastPZ
					camera\VZ=lastVZ
				EndIf
				If Int(Floor(camera\PX/1.50))<0
					camera\px=lastPX
					camera\Vx=lastVX					
				EndIf
				If Int(Floor(-(camera\Pz/1.50)))>15
					camera\PZ=lastPZ
					camera\VZ=lastVZ
				EndIf
				If Int(Floor(camera\PX/1.50))>79
					camera\px=lastPX
					camera\Vx=lastVX					
				EndIf
				EndIf
			EndIf
		EndIf
	EndIf
	If KeyDown(50)
		drawfullmap()
	EndIf
	If KeyHit(12)
		cmap=cmap-1
		If cmap<0 cmap=60
		checkcmap(0)
		fillcollision(cmap)
		fillevent(cmap)
	EndIf
	If KeyHit(13)
		cmap=cmap+1
		If cmap>60 cmap=0
		checkcmap(1)
		fillcollision(cmap)
		fillevent(cmap)
	EndIf
		
End Function

Function checkcmap(dir)

Select cmap
Case 5,6,7,8,9,10,11,12,13,14,15,16
	If dir=1 
		cmap=17
	Else
	cmap=4
	EndIf
Case 33,34,35,36,37,38,39,40
	If dir=1 
		cmap=41
	Else
	cmap=32
	EndIf
Default

If cmap=60 
 cmap=5

EndIf
End Select
	oaera=0
End Function
.amod
Data 0,0  ; a1
Data 16,0 ; b1
Data 32,0 ; c1
Data 48,0 ; d1
Data 64,0 ; e1

Data 0,16  ; a2
Data 16,16 ; b2
Data 32,16 ; c2
Data 48,16 ; d2
Data 64,16 ; e2

Data 0,32  ; a3
Data 16,32 ; b3
Data 32,32 ; c3
Data 48,32 ; d3
Data 64,32 ; e3

Data 0,48  ; a4
Data 16,48 ; b4
Data 32,48 ; c4
Data 48,48 ; d4
Data 64,48 ; e4