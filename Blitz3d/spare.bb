
CX=Int(Floor(camera\PX/1.50))
	cY=Int(Floor(-(camera\Pz/1.50)))
	x2=0:y2=0
	For x=cx+2 To cx-2 Step-1
	y2=0
	
	
	For y=cy-2 To cy+2
	If y<0 Or x<0 Or x>15 Or y>15
	Else
		a=(y*15)+x
		cwall$=Right(Bin(PeekByte(m\mapdata,a)),8)
			WriteLine fo,cwall$
			Select GetWall(cwall,0)
			Case 1
			glColor4f(1.0,1.0,1.0,1)
			glBegin(GL_LINES)
				x3=(x2*24)+507
				y3=(y2*24)+20	
				glVertex2i(x3,y3)
				glVertex2i(x3+20,y3)
			glEnd()
			Case 2
				glColor4f(1.0,0.0,1.0,1)
				glBegin(GL_LINES)
				x3=(x2*24)+507
				y3=(y2*24)+20	
				glVertex2i(x3,y3)
				glVertex2i(x3+20,y3)
				;glVertex2i(x3+10,y3+10)
				;glVertex2i(x3,y3)
				
			glEnd()
			Case 3
			glColor4f(1.0,1.0,0.0,1)
			glBegin(GL_LINES)
				x3=(x2*24)+507
				y3=(y2*24)+20	
				glVertex2i(x3,y3)
				glVertex2i(x3+20,y3)
			glEnd()
			End Select

			
			
			
			
	EndIf
	DebugLog x2+" "+y2
	y2=y2+1
	Next
	x2=x2+1
	Next
	
	
;;;;;	




Select GetWall(cwall,1)
			Case 1
			glColor4f(1.0,1.0,1.0,1)
			glBegin(GL_LINES)
				x3=(x2*24)+507
				y3=(y2*24)+20	
				glVertex2i(x3,y3)
				glVertex2i(x3,y3+20)
			glEnd()
			Case 2
				glColor4f(1.0,0.0,1.0,1)
				glBegin(GL_LINES)
				x3=(x2*24)+507
				y3=(y2*24)+20	
				glVertex2i(x3+20,y3)
				glVertex2i(x3+20,y3+20)
				
			glEnd()
			Case 3
			glColor4f(1.0,1.0,0.0,1)
			glBegin(GL_LINES)
				x3=(x2*24)+507
				y3=(y2*24)+20	
				glVertex2i(x3+20,y3)
				glVertex2i(x3+20,y3+20)
			glEnd()
			End Select
			
			
			
			Select GetWall(cwall,2)
			Case 1
			glColor4f(1.0,1.0,1.0,1)
			glBegin(GL_LINES)
				x3=(x2*24)+507
				y3=(y2*24)+20	
				glVertex2i(x3,y3)
				glVertex2i(x3,y3+20)
			glEnd()
			Case 2
				glColor4f(1.0,0.0,1.0,1)
				glBegin(GL_LINES)
				x3=(x2*24)+507
				y3=(y2*24)+20	
				glVertex2i(x3+20,y3)
				glVertex2i(x3+20,y3+20)
				
			glEnd()
			Case 3
			glColor4f(1.0,1.0,0.0,1)
			glBegin(GL_LINES)
				x3=(x2*24)+507
				y3=(y2*24)+20	
				glVertex2i(x3+20,y3)
				glVertex2i(x3+20,y3+20)
			glEnd()
			End Select
			
			
			
			Select GetWall(cwall,3)
			Case 1
			glColor4f(1.0,1.0,1.0,1)
			glBegin(GL_LINES)
				x3=(x2*24)+507
				y3=(y2*24)+20	
				glVertex2i(x3,y3)
				glVertex2i(x3,y3+20)
			glEnd()
			Case 2
				glColor4f(1.0,0.0,1.0,1)
				glBegin(GL_LINES)
				x3=(x2*24)+507
				y3=(y2*24)+20	
				glVertex2i(x3+20,y3)
				glVertex2i(x3+20,y3+20)
				
			glEnd()
			Case 3
			glColor4f(1.0,1.0,0.0,1)
			glBegin(GL_LINES)
				x3=(x2*24)+507
				y3=(y2*24)+20	
				glVertex2i(x3+20,y3)
				glVertex2i(x3+20,y3+20)
			glEnd()
			End Select