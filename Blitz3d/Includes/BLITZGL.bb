Global glred#=1,glgreen#=1, glblue#=1


Include "includes\openglConst.bb"
Include "includes\Event_const.bb"

Type Camera
	Field PX#=0,PY#=100,Pz#=0
	Field Roll#,pitch#,yaw#
	Field Quater#[4]
	Field VX#=0,VY#=100,VZ#=-100
	Field UX#,UY#,UZ#
	Field X#,y#,z#
End Type






Function Graphics3D(width,height,depth,fullscreen)
Graphics width,height,depth,fullscreen
bglGetBlitzWindow(depth,"")
ReSizeProjection(width,height)
End Function

Function Flip()
glflip()
End Function




Function createVector(a#=0,b#=0,c#=0,d#=0)
	bank=CreateBank(16)
	PokeFloat(bank,0,a#)
	PokeFloat(bank,4,b#)
	PokeFloat(bank,8,c#)
	PokeFloat(bank,12,d)
	Return bank
End Function

Function createDoubleVector(a#,b#,c#,d#)
	bank=CreateBank(32)
	PokeFloat(bank,4,a#)
	PokeFloat(bank,12,b#)
	PokeFloat(bank,20,c#)
	PokeFloat(bank,28,d#)
	Return bank
End Function

Function fetch#(bank,location)
value#= PeekFloat(bank,location*4)
Return value#
End Function

Function shove(bank,location,value#)
	PokeFloat(bank,location*4,value#)
End Function

; primitive object creation code
Function windowRect(aspect#)
	
	; Quick and dirty window rect.
	
	glLoadIdentity
	
	
	glTranslatef 0.0,0.0,-2.43	
	
	glDisable GL_TEXTURE_2D	
	glColor3f 1.0,1.0,1.0
	glBegin GL_LINE_LOOP 
		glVertex3f -1.0*aspect, 1.0, 0.0          ; Top Left
		glVertex3f  1.0*aspect, 1.0, 0.0          ; Top Right
        glVertex3f  1.0*aspect,-1.0, 0.0          ; Bottom Right
        glVertex3f -1.0*aspect,-1.0, 0.0          ; Bottom Left
   glEnd     	
	
End Function

Function RAD2DEG#(radian#)
	Return radian*(180/Pi)
End Function
Function DEG2rad#(Degree#)
	Return (degree/180)*Pi
End Function

Function dText(x#,y#,txt$,cx=0,cy=0)

	glPushMatrix()							; push the stack..
	glLoadIdentity();									; Reset The Current Modelview Matrix
	glTranslatef(0.0,0.0,-0.9);						; Move One Unit Into The Screen
	; set the text color...
	glColor3f(glred#,glblue#,glgreen#)
	; Position The Text On The Screen
	;lRasterPos2f( (((640/2.)-640)/320.)+x,(((480/2.)-480)/240.)+y)
	sx#=(-0.51)+x/640.
	glRasterPos2f(sx#,0.30)
	tex=CreateBank((Len(txt)))
	For loop=0 To Len(txt$)-1
		PokeByte(tex,loop,Asc(Mid(txt,loop+1,1)))
	Next			
	glPushAttrib(GL_LIST_BIT)
	glListBase(base-32)
	glCallLists(Len(txt),GL_UNSIGNED_byte, tex);		// Write The Text To The Screen
	glPopAttrib()

	glPopMatrix()							; pop the stack
End Function


Function createstring(txt$)
tex=CreateBank((Len(txt)))
	DebugLog tex+" "+txt
	For loop=0 To Len(txt$)-1
	;DebugLog loop
		PokeByte(tex,loop,Asc(Mid(txt,loop+1,1)))
	Next	
	Return tex		
End Function
Function sText(x#,y#,txt$,cx=0,cy=0)
	glDisable(GL_DEPTH_TEST);							// Disables Depth Testing
	glMatrixMode(GL_PROJECTION);						// Select The Projection Matrix
	glPushMatrix();										// Store The Projection Matrix
	glLoadIdentity();									// Reset The Projection Matrix
	glOrtho(0,640,480,0,-1,1);							// Set Up An Ortho Screen
	glMatrixMode(GL_MODELVIEW);							// Select The Modelview Matrix
	glPushMatrix();										// Store The Modelview Matrix
	glLoadIdentity();									// Reset The Modelview Matrix
	glTranslatef(x,y,0);								// Position The Text (0,0 - Top Left)
		tex=CreateBank((Len(txt)))
	For loop=0 To Len(txt$)-1
		PokeByte(tex,loop,Asc(Mid(txt,loop+1,1)))
	Next			
	glPushAttrib(GL_LIST_BIT)
	glListBase(base-32)
	glCallLists(Len(txt),GL_UNSIGNED_byte, tex);		// Write The Text To The Screen
	glPopAttrib()

	glMatrixMode(GL_PROJECTION);						// Select The Projection Matrix
	glPopMatrix();										// Restore The Old Projection Matrix
	glMatrixMode(GL_MODELVIEW);							// Select The Modelview Matrix
	glPopMatrix();										// Restore The Old Projection Matrix
	glEnable(GL_DEPTH_TEST);							// Enables Depth Testing
End Function

Function rCos#(radian#)
	
	Return Cos(rad2deg(radian))
End Function

Function rSin#(radian#)
	Return Sin(rad2deg(radian))
End Function

Function rTan#(radian#)
	Return Tan(rad2deg(radian))
End Function

Function GetWord$(I$, n, S$=" ")
	For CL = 1 To Len(I$)
		TC$ = Mid$(I$, CL, 1)
		If Instr(S, TC, 1)	
			If FW
				WF = WF + 1
				If WF=n
					Return W$
				Else
					W$ = ""
					FW = False
				EndIf
			EndIf
		Else
			FW = True
			W$ = W$ + TC$
		EndIf
	Next
	If (WF+1) = n
		Return W$
	Else
		Return ""
	EndIf
End Function			