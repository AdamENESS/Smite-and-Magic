Type frustum
Field A_frustum#[6]
Field B_frustum#[6]
Field C_frustum#[6]
Field D_frustum#[6]
End Type

Const F_RIGHT =0
Const F_left  =1
Const F_BOTTOM=2
Const F_TOP   =3
Const F_BACK  =4
Const F_FRONT =5

Const F_A=0
Const F_B=1
Const F_C=2
Const F_D=3

Const First_OBJECT_ID=3
Fr.frustum=New frustum
Function bglNormaliseplane(fr.frustum,side)
		mang#=Sqr((fr\A_frustum[side]*fr\A_frustum[side])+(fr\B_frustum[side]*fr\B_frustum[side])+(fr\C_frustum[side]*fr\C_frustum[side]))
		fr\A_frustum[side]=fr\A_frustum[side]/mang
		fr\B_frustum[side]=fr\B_frustum[side]/mang
		fr\C_frustum[side]=fr\C_frustum[side]/mang
		fr\D_frustum[side]=fr\D_frustum[side]/mang		
End Function

Function bglCalculateFrustum(fr.frustum)
	Local bproj=CreateBank(16*4)
	Local bmodl=CreateBank(16*4)
	Local proj#[16]
	Local modl#[16]

	Local clip#[16]
	; glGetFloatv() is used To extract information about our OpenGL world.
	; Below, we pass in GL_PROJECTION_MATRIX To abstract our projection matrix.
	; It Then stores the matrix into an array of [16].
	glGetFloatv(GL_PROJECTION_MATRIX, bproj)
	
	; By passing in GL_MODELVIEW_MATRIX, we can abstract our model view matrix.
	; This also stores it in an array of [16].
	glGetFloatv(GL_MODELVIEW_MATRIX, bmodl)
	
	; Now that we have our modelview And projection matrix, If we combine these 2 matrices,
	; it will give us our clipping planes.  To combine 2 matrices, we multiply them.
		

	bob$="Projection Matrix:"
	For a=0 To 15
	proj[a]=PeekFloat(bproj,a*4)
	bob$=bob$+" | "+proj[a]
	Next
	
	bob$="ModelView Matrix:"
	For a=0 To 15
	modl[a]=PeekFloat(bmodl,a*4)
	;db modl[a]
	bob$=bob$+" | "+modl[a]
	Next
	
	
	clip[ 0] = modl[ 0] * proj[ 0] + modl[ 1] * proj[ 4] + modl[ 2] * proj[ 8] + modl[ 3] * proj[12];
	clip[ 1] = modl[ 0] * proj[ 1] + modl[ 1] * proj[ 5] + modl[ 2] * proj[ 9] + modl[ 3] * proj[13];
	clip[ 2] = modl[ 0] * proj[ 2] + modl[ 1] * proj[ 6] + modl[ 2] * proj[10] + modl[ 3] * proj[14];
	clip[ 3] = modl[ 0] * proj[ 3] + modl[ 1] * proj[ 7] + modl[ 2] * proj[11] + modl[ 3] * proj[15];

	clip[ 4] = modl[ 4] * proj[ 0] + modl[ 5] * proj[ 4] + modl[ 6] * proj[ 8] + modl[ 7] * proj[12];
	clip[ 5] = modl[ 4] * proj[ 1] + modl[ 5] * proj[ 5] + modl[ 6] * proj[ 9] + modl[ 7] * proj[13];
	clip[ 6] = modl[ 4] * proj[ 2] + modl[ 5] * proj[ 6] + modl[ 6] * proj[10] + modl[ 7] * proj[14];
	clip[ 7] = modl[ 4] * proj[ 3] + modl[ 5] * proj[ 7] + modl[ 6] * proj[11] + modl[ 7] * proj[15];

	clip[ 8] = modl[ 8] * proj[ 0] + modl[ 9] * proj[ 4] + modl[10] * proj[ 8] + modl[11] * proj[12];
	clip[ 9] = modl[ 8] * proj[ 1] + modl[ 9] * proj[ 5] + modl[10] * proj[ 9] + modl[11] * proj[13];
	clip[10] = modl[ 8] * proj[ 2] + modl[ 9] * proj[ 6] + modl[10] * proj[10] + modl[11] * proj[14];
	clip[11] = modl[ 8] * proj[ 3] + modl[ 9] * proj[ 7] + modl[10] * proj[11] + modl[11] * proj[15];

	clip[12] = modl[12] * proj[ 0] + modl[13] * proj[ 4] + modl[14] * proj[ 8] + modl[15] * proj[12];
	clip[13] = modl[12] * proj[ 1] + modl[13] * proj[ 5] + modl[14] * proj[ 9] + modl[15] * proj[13];
	clip[14] = modl[12] * proj[ 2] + modl[13] * proj[ 6] + modl[14] * proj[10] + modl[15] * proj[14];
	clip[15] = modl[12] * proj[ 3] + modl[13] * proj[ 7] + modl[14] * proj[11] + modl[15] * proj[15];
	bob$="Clip Matrix:"
	For a=0 To 15
	;modl[a]=PeekFloat(bmodl,a*4)
	;db modl[a]
	bob$=bob$+" | "+clip[a]
	Next
	
	; Now we actually want To get the sides of the frustum.  To do this we take
	; the clipping planes we received above And extract the sides from them.

	; This will extract the Right side of the frustum
	fr\A_Frustum[F_RIGHT] = clip[ 3] - clip[ 0];
	fr\B_Frustum[F_RIGHT] = clip[ 7] - clip[ 4];
	fr\C_Frustum[F_RIGHT] = clip[11] - clip[ 8];
	fr\D_Frustum[F_RIGHT] = clip[15] - clip[12];
	; Now that we have a normal (A,B,C) And a distance (D) To the plane,
	; we want To normalize that normal And distance.

	; Normalize the Right side
	bglNormalisePlane(fr, F_RIGHT);
	
	
	; This will extract the Left side of the frustum
	fr\A_Frustum[f_left] = clip[ 3] + clip[ 0];
	fr\B_Frustum[f_left] = clip[ 7] + clip[ 4];
	fr\C_Frustum[f_left] = clip[11] + clip[ 8];
	fr\D_Frustum[f_left] = clip[15] + clip[12];

	; Normalize the f_left side
	bglNormalisePlane(fr, f_left);
	
	; This will extract the BOTTOM side of the frustum
	fr\A_Frustum[F_BOTTOM] = clip[ 3] + clip[ 1];
	fr\B_Frustum[F_BOTTOM] = clip[ 7] + clip[ 5];
	fr\C_Frustum[F_BOTTOM] = clip[11] + clip[ 9];
	fr\D_Frustum[F_BOTTOM] = clip[15] + clip[13];

	; Normalize the BOTTOM side
	bglNormalisePlane(fr, F_BOTTOM);

	; This will extract the TOP side of the frustum
	fr\A_Frustum[F_TOP] = clip[ 3] - clip[ 1];
	fr\B_Frustum[F_TOP] = clip[ 7] - clip[ 5];
	fr\C_Frustum[F_TOP] = clip[11] - clip[ 9];
	fr\D_Frustum[F_TOP] = clip[15] - clip[13];

	; Normalize the TOP side
	bglNormalisePlane(fr, F_TOP);

	; This will extract the BACK side of the frustum
	fr\A_Frustum[F_BACK] = clip[ 3] - clip[ 2];
	fr\B_Frustum[F_BACK] = clip[ 7] - clip[ 6];
	fr\C_Frustum[F_BACK] = clip[11] - clip[10];
	fr\D_Frustum[F_BACK] = clip[15] - clip[14];

	; Normalize the BACK side
	bglNormalisePlane(fr, F_BACK);

	; This will extract the FRONT side of the frustum
	fr\A_Frustum[F_FRONT] = clip[ 3] + clip[ 2];
	fr\B_Frustum[F_FRONT] = clip[ 7] + clip[ 6];
	fr\C_Frustum[F_FRONT]= clip[11] + clip[10];
	fr\D_Frustum[F_FRONT]= clip[15] + clip[14];

	; Normalize the FRONT side
	bglNormalisePlane(fr, F_FRONT);
	
	
	
	

End Function




; The code below will allow us To make checks within the frustum.  For example,
; If we want To see If a point, a sphere, Or a cube lies inside of the frustum.
; Because all of our planes point INWARDS (The normals are all pointing inside the frustum)
; we Then can assume that If a point is in FRONT of all of the planes, it's inside.

;;;;;;;;;;;;;;;;; POINT IN FRUSTUM ;;;;;;;;;;;;;;;;
;;;
;;;	This determines If a point is inside of the frustum
;;;
;;;;;;;;;;;;;;;;; POINT IN FRUSTUM ;;;;;;;;;;;;;;;;

Function PointInFrustum(fr.frustum, x#,y#,z#)
	; Go through all the sides of the frustum
	For a=0 To 5
		; Calculate the plane equation And check If the point is behind a side of the frustum
		If	((fr\a_frustum[a]*X)+(fr\b_frustum[a]*y)+(fr\c_frustum[a]*z)+(fr\d_frustum[a])) <=0
			; The point was behind a side, so it ISN'T in the frustum
			Return False;
		EndIf
	Next
	; The point was inside of the frustum (In front of ALL the sides of the frustum)
	Return True
End Function

;;;;;;;;;;;;;;;;; SPHERE IN FRUSTUM ;;;;;;;;;;;;;;;;
;;;
;;;	This determines If a sphere is inside of our frustum by it's center And radius.
;;;
;;;;;;;;;;;;;;;;; SPHERE IN FRUSTUM ;;;;;;;;;;;;;;;;

Function SphereInFrustum(fr.frustum, x#,y#,z#,radius)
	; Go through all the sides of the frustum
	For a=0 To 5
		; If the center of the sphere is farther away from the plane than the radius
		If	((fr\a_frustum[a]*X)+(fr\b_frustum[a]*y)+(fr\c_frustum[a]*z)+(fr\d_frustum[a])) <=-radius
			; The distance was greater than the radius so the sphere is outside of the frustum
			Return False;
		EndIf
	Next
	; The sphere was inside of the frustum!
	Return True
End Function

;;;;;;;;;;;;;;;;; CUBE IN FRUSTUM ;;;;;;;;;;;;;;;;
;;;
;;;	This determines If a cube is in Or around our frustum by it's center And 1/2 it's length
;;;
;;;;;;;;;;;;;;;;; CUBE IN FRUSTUM ;;;;;;;;;;;;;;;;

Function CubeInFrustum(fr.frustum,X#,Y#,Z#,Size#)
	; Basically, what is going on is, that we are given the center of the cube,
	; And half the length.  Think of it like a radius.  Then we checking Each point
	; in the cube And seeing If it is inside the frustum.  If a point is found in front
	; of a side, Then we skip To the Next side.  If we get To a plane that does Not have
	; a point in front of it, Then it will Return False.

	; *Note* - This will sometimes say that a cube is inside the frustum when it isn't.
	; This happens when all the corners of the bounding box are Not behind any one plane.
	; This is rare And shouldn't effect the overall rendering speed.
	For a=0 To 5
		b=0
		If((fr\a_frustum[a]*(X-size))+(fr\b_frustum[a]*(y-size))+(fr\c_frustum[a]*(z-size))+(fr\d_frustum[a])) >0
		b=1
		EndIf
	
		If((fr\a_frustum[a]*(X+size))+(fr\b_frustum[a]*(y-size))+(fr\c_frustum[a]*(z-size))+(fr\d_frustum[a])) >0
				b=1
		EndIf
		
		If((fr\a_frustum[a]*(X-size))+(fr\b_frustum[a]*(y+size))+(fr\c_frustum[a]*(z-size))+(fr\d_frustum[a])) >0
				b=1
		EndIf
		
		If((fr\a_frustum[a]*(X+size))+(fr\b_frustum[a]*(y+size))+(fr\c_frustum[a]*(z-size))+(fr\d_frustum[a])) >0
				b=1
		EndIf
		
		If((fr\a_frustum[a]*(X-size))+(fr\b_frustum[a]*(y-size))+(fr\c_frustum[a]*(z+size))+(fr\d_frustum[a])) >0
				b=1
		EndIf
		
		If((fr\a_frustum[a]*(X+size))+(fr\b_frustum[a]*(y-size))+(fr\c_frustum[a]*(z+size))+(fr\d_frustum[a])) >0
				b=1
		EndIf
		
		If((fr\a_frustum[a]*(X-size))+(fr\b_frustum[a]*(y+size))+(fr\c_frustum[a]*(z+size))+(fr\d_frustum[a])) >0
				b=1
		EndIf
		
		If((fr\a_frustum[a]*(X+size))+(fr\b_frustum[a]*(y+size))+(fr\c_frustum[a]*(z+size))+(fr\d_frustum[a])) >0
				b=1
		EndIf	
		If b=0
			; If we get here, it isn't in the frustum
			Return False;
		EndIf
		
	Next
	Return True;
End Function



;;;/ * ;;;;;/ * ;;;;;/ * New * ;;;/ * ;;;;;/ * ;;;;;/ *

;;;;;;;;;;;;;;;;/ BOX IN FRUSTUM \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\*
;;/
;;/	This determines If a BOX is in Or around our frustum by it's min And max points
;;/
;;;;;;;;;;;;;;;;/ BOX IN FRUSTUM \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\*

Function BoxInFrustum(fr.frustum, x#, y#, z#, x2#, y2#, z2#)

	; Go through all of the corners of the box And check Then again Each plane
	; in the frustum.  If all of them are behind one of the planes, Then it most
	; like is Not in the frustum.
	For i = 0 To 5

		If(fr\a_frustum[i] * x  + fr\b_frustum[i] * y  + fr\c_frustum[i] * z  + fr\d_frustum[i] > 0) Goto continue 
		If(fr\a_frustum[i] * x2 + fr\b_frustum[i] * y  + fr\c_frustum[i] * z  + fr\d_frustum[i] > 0) Goto continue
		If(fr\a_frustum[i] * x  + fr\b_frustum[i] * y2 + fr\c_frustum[i] * z  + fr\d_frustum[i] > 0) Goto continue
		If(fr\a_frustum[i] * x2 + fr\b_frustum[i] * y2 + fr\c_frustum[i] * z  + fr\d_frustum[i] > 0) Goto continue
		If(fr\a_frustum[i] * x  + fr\b_frustum[i] * y  + fr\c_frustum[i] * z2 + fr\d_frustum[i] > 0) Goto continue
		If(fr\a_frustum[i] * x2 + fr\b_frustum[i] * y  + fr\c_frustum[i] * z2 + fr\d_frustum[i] > 0) Goto continue
		If(fr\a_frustum[i] * x  + fr\b_frustum[i] * y2 + fr\c_frustum[i] * z2 + fr\d_frustum[i] > 0) Goto continue
		If(fr\a_frustum[i] * x2 + fr\b_frustum[i] * y2 + fr\c_frustum[i] * z2 + fr\d_frustum[i] > 0) Goto continue

		Return False;
		; If we get here, it isn't in the frustum
	
		.continue
	;	DebugLog "woot:"+A+" I:"+I
	Next

	; Return a True For the box being inside of the frustum
	Return True;
End Function