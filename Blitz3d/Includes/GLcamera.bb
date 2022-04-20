

Function bglMoveCamera(camera.camera,Speed#,noy=0)
	camera\x=(camera\VX-camera\PX)
	camera\Y=(camera\VY-camera\PY)
	camera\Z=(camera\Vz-camera\PZ)	
	mang#=Sqr((camera\X*camera\X)+(camera\Y*camera\Y)+(camera\z*camera\Z))
	camera\x=camera\x/mang
	camera\y=camera\y/mang
	camera\z=camera\z/mang		
	camera\PX#=camera\px#+(camera\X#*speed#)
	
	camera\Pz#=camera\Pz#+(camera\z#*speed#)		
	camera\vX#=camera\vx#+(camera\X#*speed#)

	camera\vz#=camera\vz#+(camera\z#*speed#)	
	If noy=0
		camera\Py#=camera\py#+(camera\y#*speed#)
		camera\vy#=camera\vy#+(camera\y#*speed#)
	EndIf
	
End Function


Function bglstrafeCamera(camera.camera,Speed#)
		tX#=camera\VX-camera\pX
		ty#=camera\Vy-camera\py
		tz#=camera\Vz-camera\pz
	camera\x=((ty*camera\UZ)-(tz*camera\UY))
	camera\y=((tz*camera\Ux)-(tx*camera\Uz))
	camera\z=((tx*camera\Uy)-(ty*camera\Ux))
	mang#=Sqr((camera\X*camera\X)+(camera\Y*camera\Y)+(camera\z*camera\Z));
	camera\x=camera\x/mang
	camera\y=camera\y/mang
	camera\z=camera\z/mang	
	camera\PX#=camera\px#+(camera\X#*speed#)
;	camera\Py#=camera\py#+(camera\y#*speed#)
	camera\Pz#=camera\Pz#+(camera\z#*speed#)		
	camera\vX#=camera\vx#+(camera\X#*speed#)
;	camera\vy#=camera\vy#+(camera\y#*speed#)
	camera\vz#=camera\vz#+(camera\z#*speed#)	
End Function



; Thanks to Floyd for this one. His comments:
; This should convert all ordinary floats correctly. 
; The extreme cases +Infinity, -Infinity, NaN would require special handling. 
Function SngToDbl( x#, bank )

Local s, e, m, Lo, Hi, n


	PokeFloat bank, 0, x

	n = PeekInt( bank, 0 )  ; raw bits of x

	s = n And %10000000000000000000000000000000  ; sign bit
	e = n And %01111111100000000000000000000000  ; 8-bit exponent
	e = (e Shr 3) + %00111000000000000000000000000000  ; 11-bit exponent
	m = n And %00000000011111111111111111111111  ; 23-bit mantissa
	Lo = m Shl 29  ; final three bits of mantissa
	Hi = s Or e Or (m Shr 3 ) ; sign, exponent, first twenty bits of m

	PokeInt bank, 0, Lo

	PokeInt bank, 4, Hi


End Function



Function RotateCamera(camera.camera,angle#,X#,Y#,Z#)

	camera\x=(camera\VX-camera\PX)
	camera\Y=(camera\VY-camera\PY)
	camera\Z=(camera\Vz-camera\PZ)
	costheta#=Cos(angle)
	sintheta#=Sin(angle)	
	nx#=(costheta+(1-costheta)*x*x) * camera\x
	nx=nx+((1-costheta)*x*y-z*sintheta) * camera\y
	nx=nx+((1-costheta)*x*z+y*sintheta) * camera\z

	ny#=((1-costheta)*X*Y+z*sintheta) * camera\x
	ny=ny+(costheta+(1-costheta)*y*y) * camera\y
	ny=ny+((1-costheta)*y*z-x*sintheta) * camera\z
	
	nz#=((1-costheta)*X*z-y*sintheta) * camera\x
	nz=nz+((1-costheta)*y*z+x*sintheta) * camera\y
	nz=nz+(costheta+(1-costheta)*z*z) * camera\z

	camera\VX=camera\PX+nx#
	camera\Vy=camera\Py+ny#
	camera\Vz=camera\Pz+nz#


End Function

;void CCamera::RotateView(Float angle, Float x, Float y, Float z)
;{;
;	CVector3 vNewView;
;
;	// Get the view vector (The direction we are facing)
;	CVector3 vView = m_vView - m_vPosition;		
;
;	// Calculate the sine And cosine of the angle once
;	Float cosTheta = (Float)Cos(angle);
;	Float sinTheta = (Float)Sin(angle);
;
;	// Find the New x position For the New rotated point
;	vNewView.x  = (cosTheta + (1 - cosTheta) * x * x)		* vView.x;
;	vNewView.x += ((1 - cosTheta) * x * y - z * sinTheta)	* vView.y;
;	vNewView.x += ((1 - cosTheta) * x * z + y * sinTheta)	* vView.z;
;
;	// Find the New y position For the New rotated point
;	vNewView.y  = ((1 - cosTheta) * x * y + z * sinTheta)	* vView.x;
;	vNewView.y += (cosTheta + (1 - cosTheta) * y * y)		* vView.y;
;	vNewView.y += ((1 - cosTheta) * y * z - x * sinTheta)	* vView.z;
;
;	// Find the New z position For the New rotated point
;	vNewView.z  = ((1 - cosTheta) * x * z - y * sinTheta)	* vView.x;
;	vNewView.z += ((1 - cosTheta) * y * z + x * sinTheta)	* vView.y;
;	vNewView.z += (cosTheta + (1 - cosTheta) * z * z)		* vView.z;
;
;	// Now we just add the newly rotated vector To our position To set
;	// our New rotated view of our camera.
;	m_vView = m_vPosition + vNewView;
;}


Function mousemove(camera.camera)
	;db "MOUSEMOVE"
	MX=MouseX() : 	My=MouseY()

	If winmode=0
	midX=winwid/2
	midy=winhgt/2
	Else
	midX=winwid/2
	midy=winhgt/2
	EndIf
	angY#=0
	angZ#=0
	curX#=0
	If mX=midX And my=midY Return		
		
	MoveMouse midx,midy
	
	angy=(midX-mx)/500.
	angz=(midy-my)/500.
	
	curX=-angZ
	If curX>1.0
		curX=1.0
	ElseIf curX<-1.0
		curX=-1
	Else
		tX#=camera\VX-camera\pX
		ty#=camera\Vy-camera\py
		tz#=camera\Vz-camera\pz
		camera\x=((ty*camera\UZ)-(tz*camera\UY))
		camera\y=((tz*camera\Ux)-(tx*camera\Uz))
		camera\z=((tx*camera\Uy)-(ty*camera\Ux))
		mang#=Sqr((camera\X*camera\X)+(camera\Y*camera\Y)+(camera\z*camera\Z));
		camera\x=camera\x/mang
		camera\y=camera\y/mang
		camera\z=camera\z/mang	
		rotatecamera(camera,angZ*50,camera\x,camera\y,camera\z)
		rotatecamera(camera,angY*50,0,1,0)
		

	EndIf
	

	

End Function


;void CCamera::SetViewByMouse()
;{
;	POINT mousePos;									// This is a window structure that holds an X and Y
;	Int middleX = SCREEN_WIDTH  >> 1;				// This is a binary shift to get half the width
;	Int middleY = SCREEN_HEIGHT >> 1;				// This is a binary shift to get half the height
;	Float angleY = 0.0f;							// This is the direction for looking up or down
;	Float angleZ = 0.0f;							// This will be the value we need to rotate around the Y axis (Left and Right)
;	static Float currentRotX = 0.0f;
;	
;	// Get the mouse's current X,Y position
;	GetCursorPos(&mousePos);						
;	
;	// If our cursor is still in the middle, we never moved... so don't update the screen
;	If( (mousePos.x == middleX) && (mousePos.y == middleY) ) Return;
;
;	// Set the mouse position To the middle of our window
;	SetCursorPos(middleX, middleY);							
;
;	// Get the direction the mouse moved in, but bring the number down To a reasonable amount
;	angleY = (Float)( (middleX - mousePos.x) ) / 1000.0f;		
;	angleZ = (Float)( (middleY - mousePos.y) ) / 1000.0f;		
;
;	// Here we keep track of the current rotation (For up And down) so that
;	// we can restrict the camera from doing a full 360 loop.
;	currentRotX -= angleZ;  
;
;	// If the current rotation (in radians) is greater than 1.0, we want To cap it.
;	If(currentRotX > 1.0f)
;		currentRotX = 1.0f;
;;	// Check If the rotation is below -1.0, If so we want To make sure it doesn't continue
;	Else If(currentRotX < -1.0f)
;		currentRotX = -1.0f;
;	// Otherwise, we can rotate the view around our position
;	Else
;	{
;		// To find the axis we need To rotate around For up And down
;		// movements, we need To get a perpendicular vector from the
;		// camera's view vector And up vector.  This will be the axis.
;		CVector3 vAxis = Cross(m_vView - m_vPosition, m_vUpVector);
;		vAxis = Normalize(vAxis);
;
;		// Rotate around our perpendicular axis And along the y-axis
;		RotateView(angleZ, vAxis.x, vAxis.y, vAxis.z);
;		RotateView(angleY, 0, 1, 0);
;	}
;}

;CVector3 Cross(CVector3 vVector1, CVector3 vVector2)
;{
;	CVector3 vNormal;	
;
;	// Calculate the cross product with the non communitive equation
;	vNormal.x = ((vVector1.y * vVector2.z) - (vVector1.z * vVector2.y));
;	vNormal.y = ((vVector1.z * vVector2.x) - (vVector1.x * vVector2.z));
;	vNormal.z = ((vVector1.x * vVector2.y) - (vVector1.y * vVector2.x));
;
;	// Return the cross product
;	Return vNormal;										 
;}

Function joymove(camera.camera,sensivity)
	;db "MOUSEMOVE"
	angY#=0
	angZ#=0
	curX#=0
	curX=-angZ
	
	angy=(-JoyRoll()/180)/(10*sensivity)
	angz=(JoyZ())/(10*sensivity)
	If curX>1.0
		curX=1.0
	Else If curX<-1.0
		curX=-1.0
	Else
		tX#=camera\VX-camera\pX
		ty#=camera\Vy-camera\py
		tz#=camera\Vz-camera\pz
		camera\x=((ty*camera\UZ)-(tz*camera\UY))
		camera\y=((tz*camera\Ux)-(tx*camera\Uz))
		camera\z=((tx*camera\Uy)-(ty*camera\Ux))
		mang#=Sqr((camera\X*camera\X)+(camera\Y*camera\Y)+(camera\z*camera\Z));
		camera\x=camera\x/mang
		camera\y=camera\y/mang
		camera\z=camera\z/mang	
		rotatecamera(camera,angZ*50,camera\x,camera\y,camera\z)
		rotatecamera(camera,angY*50,0,1,0)
		

	EndIf
	

	

End Function