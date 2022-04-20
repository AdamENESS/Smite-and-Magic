Type quat
	Field X#
	Field Y#
	Field Z#
	Field W#
End Type

;;;;;;;;;;;;;;; CREATE MATRIX \\\\\\\\\\\\\\\\\\\\\\\\\\\\\*
;;/
;;/	This Function converts a quaternion To a rotation matrix
;;/
;;;;;;;;;;;;;;; CREATE MATRIX \\\\\\\\\\\\\\\\\\\\\\\\\\\\\*	

Function CreateMatrix(W#,X#,Y#,Z#)
	bank=CreateBank(64)
	Local pMatrix#[15]
	; Fill in the rows of the 4x4 matrix, according To the quaternion To matrix equations

	; First row
	pMatrix[ 0] = 1.0 - 2.0 * ( y * y + z * z );  
	pMatrix[ 1] = 2.0 * ( x * y - w * z );  
	pMatrix[ 2] = 2.0 * ( x * z + w * y );  
	pMatrix[ 3] = 0.0;  

	; Second row
	pMatrix[ 4] = 2.0 * ( x * y + w * z );  
	pMatrix[ 5] = 1.0 - 2.0 * ( x * x + z * z );  
	pMatrix[ 6] = 2.0 * ( y * z - w * x );  
	pMatrix[ 7] = 0.0;  

	; Third row
	pMatrix[ 8] = 2.0 * ( x * z - w * y );  
	pMatrix[ 9] = 2.0 * ( y * z + w * x );  
	pMatrix[10] = 1.0 - 2.0 * ( x * x + y * y );  
	pMatrix[11] = 0.0;  

	; Fourth row
	pMatrix[12] = 0;  
	pMatrix[13] = 0;  
	pMatrix[14] = 0;  
	pMatrix[15] = 1.0;
	For a=0 To 15
	PokeFloat(bank,a*4,pMatrix[a])
	Next
	Return bank

	; Now pMatrix[] is a 4x4 homogeneous matrix that can be applied To an OpenGL Matrix
End Function


;;;;;;;;;;;;;;;;/ CREATE FROM MATRIX \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\*
;;/
;;/	This creates a quaternion from a 3x3 Or a 4x4 matrix, depending on rowColumnCount
;;/
;;;;;;;;;;;;;;;;/ CREATE FROM MATRIX \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\*

Function CreateFromMatrix.quat(Mat)
	Local Matrix#[8],X#,y#,z#,w#
	For a=0 To 8
	matrix[a]=PeekFloat(mat,a*4)
	;DebugLog matrix[a]
	Next


	; This Function is used To take in a 3x3 Or 4x4 matrix And convert the matrix
	; To a quaternion.  If rowColumnCount is a 3, Then we need To convert the 3x3
	; matrix passed in To a 4x4 matrix, otherwise we just leave the matrix how it is.
	; Since we want To apply a matrix To an OpenGL matrix, we need it To be 4x4.

	

	; Create a 4x4 matrix To convert a 3x3 matrix To a 4x4 matrix (If rowColumnCount == 3)
	Local pMatrix#[16]

		; Set the 9 top Left indices of the 4x4 matrix To the 9 indices in the 3x3 matrix.
		; It would be a good idea To actually draw this out so you can visualize it.
		pMatrix[0]  = Matrix[0]:	pMatrix[1]  = Matrix[1]:	pMatrix[2]  = Matrix[2];
		pMatrix[4]  = Matrix[3]:	pMatrix[5]  = Matrix[4]:	pMatrix[6]  = Matrix[5];
		pMatrix[8]  = Matrix[6]:	pMatrix[9]  = Matrix[7]:	pMatrix[10] = Matrix[8];

		; Since the bottom And far Right indices are zero, set the bottom Right corner To 1.
		; This is so that it follows the standard diagonal Line of 1's in the identity matrix.
		pMatrix[3] = 0;
		pMatrix[7] = 0;
		pMatrix[11] = 0;
		pMatrix[15] = 1;
	For a=0 To 15
	;	DebugLog "A:"+a+"-"+pmatrix[a]
	Next
	; The Next Step, once we made sure we are dealing with a 4x4 matrix, is To check the
	; diagonal of the matrix.  This means that we add up all of the indices that comprise
	; the standard 1's in the identity matrix.  If you draw out the identity matrix of a
	; 4x4 matrix, you will see that they 1's form a diagonal Line.  Notice we just assume
	; that the Last index (15) is 1 because it is Not effected in the 3x3 rotation matrix.

	; Find the diagonal of the matrix by adding up it's diagonal indices.
	; This is also known as the "trace", but I will call the variable diagonal.
	Diagonal# = pMatrix[0] + pMatrix[5] + pMatrix[10] + 1;
;	DebugLog Diagonal
	scale# = 0.0;

	; Below we check If the diagonal is greater than zero.  To avoid accidents with
	; floating point numbers, we substitute 0 with 0.00000001.  If the diagonal is
	; great than zero, we can perform an "instant" calculation, otherwise we will need
	; To identify which diagonal element has the greatest value.  Note, that it appears
	; that %99 of the time, the diagonal IS greater than 0 so the rest is rarely used.

	; If the diagonal is greater than zero
	If(diagonal > 0.00000001)
	
		; Calculate the scale of the diagonal
		scale = Sqr(diagonal ) * 2;
	;	DebugLog "SC:"+scale
		; Calculate the x, y, x And w of the quaternion through the respective equation
		x = ( pMatrix[9] - pMatrix[6] ) / scale;
		y = ( pMatrix[2] - pMatrix[8] ) / scale;
		z = ( pMatrix[4] - pMatrix[1] ) / scale;
		w = 0.25 * scale;
	;	DebugLog "W:"+w+" x:"+X+" y:"+Y+" z:"+Z
	Else 
	
		; If the First element of the diagonal is the greatest value
		If ( pMatrix[0] > pMatrix[5] ) And ( pMatrix[0] > pMatrix[10] )  
			
			; Find the scale according To the First element, And double that value
			scale  = Sqr( 1.0 + pMatrix[0] - pMatrix[5] - pMatrix[10] ) * 2.0;

			; Calculate the x, y, x And w of the quaternion through the respective equation
			x = 0.25 * scale;
			y = (pMatrix[4] + pMatrix[1] ) / scale;
			z = (pMatrix[2] + pMatrix[8] ) / scale;
			w = (pMatrix[9] - pMatrix[6] ) / scale;	

		; Else If the second element of the diagonal is the greatest value
		Else If ( pMatrix[5] > pMatrix[10] ) 
		
			; Find the scale according To the second element, And double that value
			scale  = Sqr( 1.0 + pMatrix[5] - pMatrix[0] - pMatrix[10] ) * 2.0;
			
			; Calculate the x, y, x And w of the quaternion through the respective equation
			x = (pMatrix[4] + pMatrix[1] ) / scale;
			y = 0.25 * scale;
			z = (pMatrix[9] + pMatrix[6] ) / scale;
			w = (pMatrix[2] - pMatrix[8] ) / scale;
		 
		; Else the third element of the diagonal is the greatest value
		Else 
			
			; Find the scale according To the third element, And double that value
			scale  = Sqr( 1.0 + pMatrix[10] - pMatrix[0] - pMatrix[5] ) * 2.0;

			; Calculate the x, y, x And w of the quaternion through the respective equation
			x = (pMatrix[2] + pMatrix[8] ) / scale;
			y = (pMatrix[9] + pMatrix[6] ) / scale;
			z = 0.25 * scale;
			w = (pMatrix[4] - pMatrix[1] ) / scale;
		EndIf
	EndIf
	q.quat=New quat
	q\w=w
	q\x=x
	q\y=y
	q\z=z
	Return q
End Function


;;;;;;;;;;;;;;;;;;;/ SLERP \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\*
;;/
;;/	Returns a spherical linear interpolated quaternion between q1 And q2, with respect To t
;;/
;;;;;;;;;;;;;;;;;;;/ SLERP \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\*

Function Slerp.quat(q1.quat,q2.quat, t#)

	; Create a Local quaternion To store the interpolated quaternion
	qi.quat=New quat

	; This Function is the milk And honey of our quaternion code, the rest of
	; the functions are an appendage To what is done here.  Everyone understands
	; the terms, "matrix to quaternion", "quaternion to matrix", "create quaternion matrix",
	; "quaternion multiplication", etc.. but "SLERP" is the stumbling block, even a little 
	; bit After hearing what it stands For, "Spherical Linear Interpolation".  What that
	; means is that we have 2 quaternions (Or rotations) And we want To interpolate between 
	; them.  The reason what it's called "spherical" is that quaternions deal with a sphere.  
	; Linear interpolation just deals with 2 points primarily, where when dealing with angles
	; And rotations, we need To use Sin() And Cos() For interpolation.  If we wanted To use
	; quaternions For camera rotations, which have much more instant And jerky changes in 
	; rotations, we would use Spherical-Cubic Interpolation.  The equation For SLERP is this:
	;
	; q = (((b.a)^-1)^t)a
	;
	; Go here For an a detailed explanation And proofs of this equation:
	;
	; http:;www.magic-software.com/Documentation/quat.pdf
	;
	; Now, Let's code it

	; Here we do a check To make sure the 2 quaternions aren't the same, Return q1 If they are
	If(q1\x = q2\x And q1\y = q2\y And q1\z = q2\z And q1\w = q2\w) 
		Return q1;
	EndIf

	; Following the (b.a) part of the equation, we do a dot product between q1 And q2\
	; We can do a dot product because the same math applied For a 3D vector as a 4D vector.
 	result# = (q1\x * q2\x) + (q1\y * q2\y) + (q1\z * q2\z) + (q1\w * q2\w);

	; If the dot product is less than 0, the angle is greater than 90 degrees
	If(result < 0.0)
	
		; Negate the second quaternion And the result of the dot product
		q2\x=-q2\x : q2\y=-q2\y : q2\z=-q2\z : q2\w=-q2\w
		result = -result;
	EndIf

	; Set the First And second scale For the interpolation
	scale0# = 1 - t : scale1# = t;

	; Next, we want To actually calculate the spherical interpolation.  Since this
	; calculation is quite computationally expensive, we want To only perform it
	; If the angle between the 2 quaternions is large enough To warrant it.  If the
	; angle is fairly small, we can actually just do a simpler linear interpolation
	; of the 2 quaternions, And skip all the complex math.  We create a "delta" value
	; of 0.1 To say that If the cosine of the angle (result of the dot product) between
	; the 2 quaternions is smaller than 0.1, Then we do Not want To perform the full on 
	; interpolation using.  This is because you won't really notice the difference.

	; Check If the angle between the 2 quaternions was big enough To warrant such calculations
	If(1 - result > 0.1)
	
		; Get the angle between the 2 quaternions, And Then store the Sin() of that angle
		theta# = ACos(result);
		sinTheta# = Sin(theta);

		; Calculate the scale For q1 And q2, according To the angle And it's sine value
		scale0 = Sin( ( 1 - t ) * theta) / sinTheta;
		scale1 = Sin( ( t * theta) ) / sinTheta;
	EndIf	

	; Calculate the x, y, z And w values For the quaternion by using a special
	; form of linear interpolation For quaternions.
	qI\x = (scale0 * q1\x) + (scale1 * q2\x);
	qI\y = (scale0 * q1\y) + (scale1 * q2\y);
	qI\z = (scale0 * q1\z) + (scale1 * q2\z);
	qI\w = (scale0 * q1\w) + (scale1 * q2\w);

	; Return the interpolated quaternion
	Return qI
End Function
