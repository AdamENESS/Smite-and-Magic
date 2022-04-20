Graphics 800,600,16,2
AppTitle "The Orb by Seth"
SetBuffer BackBuffer()
SeedRnd MilliSecs()
;.choose
;an$=Input("enter an Angle(1-360)")
;If Int(an$)<1 Or Int(an$)>360 Goto choose
;ang=Int(an$)
;.choose2
;an$=Input("enter adistance(1-200)")
;If Int(an$)<1 Or Int(an$)>200 Goto choose2
;distance=Int(an$)
ang=0
distance=20
While Not KeyHit(1)
	Cls
	Color 200,255,255
		TurnOff=0
		OldX=MouseX():OldY=MouseY()
		If MouseDown(3)
			ang=ang+5
		End If
		If MouseDown(1)
			distance=distance+2
		End If
		If MouseDown(2)
			distance=distance-2
		End If



		For x=1 To distance
			Select Rand(10)
			Case 1
				turnoff=turnoff+1
			Case 2
				turnoff=turnoff-1
			End Select
			Color 0,Rnd(255),255
			Oval oldx,oldy,2,2;MouseX()+x*Sin(ang+turnoff),MouseY()-x*Cos(ang+turnoff)
			Line oldx,oldy,MouseX()+x*Sin(ang+turnoff),MouseY()-x*Cos(ang+turnoff)
			
			Oldx=MouseX()+x*Sin(ang+turnoff)
			Oldy=MouseY()-x*Cos(ang+turnoff)
		Next
	

	Color 255,255,255
	Text 400,20,"The Orb - by Seth Jeffery",True,True
	Text 400,40,"Modified by Drago :)",True,True
	Text 400,60,"left mouse changes angle",True,True
	Text 400,80,"right mouse changes distance",True,True
	Flip
Wend