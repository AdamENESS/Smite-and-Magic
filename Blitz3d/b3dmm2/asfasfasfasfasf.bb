Graphics 640 , 480 , 0 , 2
Const Cycles = 10^8
;------------------------------------------------------------------------------;
Function BenchPixel ()
LockBuffer FrontBuffer ()
Start = MilliSecs ()
For Iterator = 0 To Cycles
x = ReadPixel ( 0 , 0 )
x = Process ( x )
WritePixelFast 0 , 0 , x
Next
End = MilliSecs () - Start
UnlockBuffer FrontBuffer ()
Return End
End Function
Function BenchBank ()
Bank = CreateBank ( 4 )
Start = MilliSecs ()
For Iterator = 0 To Cycles
x = PeekInt ( Bank , 0 )
x = Process ( x )
PokeInt Bank , 0 , x
Next
End = MilliSecs () - Start
FreeBank Bank
Return End
End Function
Global GlobalBlitzArray[ 0 ]
Function BenchGlobalBlitzArray ()
;<-- External
;--> GlobalBlitzArray[ 0 ]
Start = MilliSecs ()
For Iterator = 0 To Cycles
x = GlobalBlitzArray[ 0 ]
x = Process ( x )
GlobalBlitzArray[ 0 ] = x
Next
End = MilliSecs () - Start
Return End
End Function
Function BenchLocalBlitzArray ()
Local LocalBlitzArray[ 0 ]
Start = MilliSecs ()
For Iterator = 0 To Cycles
x = LocalBlitzArray[ 0 ]
x = Process ( x )
LocalBlitzArray[ 0 ] = x
Next
End = MilliSecs () - Start
Return End
End Function
Dim GlobalArray( 0 )
Function BenchGlobalArray ()
;<-- External
;--> GlobalArray( 0 )
Start = MilliSecs ()
For Iterator = 0 To Cycles
x = GlobalArray( 0 )
x = Process ( x )
GlobalArray( 0 ) = x
Next
End = MilliSecs () - Start
Return End
End Function
Type GlobalObjectBlitzArrayType
Field BlitzArray[ 0 ]
End Type
Global GlobalObjectBlitzArray.GlobalObjectBlitzArrayType
Function BenchGlobalObjectBlitzArray ()
;<-- External
;--> GlobalObjectBlitzArray
GlobalObjectBlitzArray = New GlobalObjectBlitzArrayType
Start = MilliSecs ()
For Iterator = 0 To Cycles
x = GlobalObjectBlitzArray\BlitzArray[ 0 ]
x = Process ( x )
GlobalObjectBlitzArray\BlitzArray[ 0 ] = x
Next
End = MilliSecs () - Start
Delete GlobalObjectBlitzArray
Return End
End Function
Type LocalObjectBlitzArrayType
Field BlitzArray[ 0 ]
End Type
Function BenchLocalObjectBlitzArray ()
Local LocalObjectBlitzArray.LocalObjectBlitzArrayType
LocalObjectBlitzArray = New LocalObjectBlitzArrayType
Start = MilliSecs ()
For Iterator = 0 To Cycles
x = LocalObjectBlitzArray\BlitzArray[ 0 ]
x = Process ( x )
LocalObjectBlitzArray\BlitzArray[ 0 ] = x
Next
End = MilliSecs () - Start
Delete LocalObjectBlitzArray
Return End
End Function
Type GlobalObjectVariableType
Field Variable%
End Type
Global GlobalObjectVariable.GlobalObjectVariableType
Function BenchGlobalObjectVariable ()
;<-- External
;--> GlobalObjectVariable
GlobalObjectVariable = New GlobalObjectVariableType
Start = MilliSecs ()
For Iterator = 0 To Cycles
x = GlobalObjectVariable\Variable
x = Process ( x )
GlobalObjectVariable\Variable = x
Next
End = MilliSecs () - Start
Delete GlobalObjectVariable
Return End
End Function
Type LocalObjectVariableType
Field Variable%
End Type
Function BenchLocalObjectVariable ()
Local LocalObjectVariable.LocalObjectVariableType
LocalObjectVariable = New LocalObjectVariableType
Start = MilliSecs ()
For Iterator = 0 To Cycles
x = LocalObjectVariable\Variable
x = Process ( x )
LocalObjectVariable\Variable = x
Next
End = MilliSecs () - Start
Delete LocalObjectVariable
Return End
End Function
Global GlobalFunctionVariable%
Function BenchGlobalFunctionVariable ()
;<-- External
;--> GlobalFunctionVariable
Start = MilliSecs ()
For Iterator = 0 To Cycles
x = READ_GlobalFunctionVariable ()
x = Process ( x )
WRITE_GlobalFunctionVariable ( x )
Next
End = MilliSecs () - Start
Return End
End Function
Function READ_GlobalFunctionVariable% ()
Return ( GlobalFunctionVariable )
End Function
Function WRITE_GlobalFunctionVariable ( Variable% )
GlobalFunctionVariable = ( Variable )
End Function
Function BenchLocalFunctionVariable ()
Local LocalFunctionVariable%
Start = MilliSecs ()
For Iterator = 0 To Cycles
x = READ_LocalFunctionVariable ( LocalFunctionVariable )
x = Process ( x )
LocalFunctionVariable = WRITE_LocalFunctionVariable ( x )
; Caution: Blitz limitation
Next
End = MilliSecs () - Start
Return End
End Function
Function READ_LocalFunctionVariable% ( Variable% )
Return ( Variable )
End Function
Function WRITE_LocalFunctionVariable% ( Variable% )
Return ( Variable )
End Function
Global GlobalVariable%
Function BenchGlobalVariable ()
;<-- External
;--> GlobalVariable
Start = MilliSecs ()
For Iterator = 0 To Cycles
x = GlobalVariable
x = Process ( x )
GlobalVariable = x
Next
End = MilliSecs () - Start
Return End
End Function
Function BenchLocalVariable ()
Local LocalVariable%
Start = MilliSecs ()
For Iterator = 0 To Cycles
x = LocalVariable
x = Process ( x )
LocalVariable = x
Next
End = MilliSecs () - Start
Return End
End Function
Function BenchShell ()
Start = MilliSecs ()
For Iterator = 0 To Cycles
x = Process ( x )
Next
End = MilliSecs () - Start
Return End
End Function
Function Process% ( Variable% )
Return ( Variable + 1 )
End Function
;------------------------------------------------------------------------------;
PrintText " Read | Write | Dist. | Object | Type | Result (ms)"
PrintText "------------|------------|--------|--------|-------------|-------------"
PrintText " ReadPixel | WritePixel | ~ | No | FrontBuffer | \"
PrintText "too slow" ;PrintText BenchPixel ()
PrintText " PeekInt | PokeInt | Local | No | Bank | \"
PrintText BenchBank ()
PrintText " Assignment | Assignment | Global | No | BlitzArray | \"
PrintText BenchGlobalBlitzArray ()
PrintText " Assignment | Assignment | Local | No | BlitzArray | \"
PrintText BenchLocalBlitzArray ()
PrintText " Assignment | Assignment | Global | No | Array | \"
PrintText BenchGlobalArray ()
PrintText " Assignment | Assignment | Global | Yes | BlitzArray | \"
PrintText BenchGlobalObjectBlitzArray ()
PrintText " Assignment | Assignment | Local | Yes | BlitzArray | \"
PrintText BenchLocalObjectBlitzArray ()
PrintText " Assignment | Assignment | Global | Yes | Variable | \"
PrintText BenchGlobalObjectVariable ()
PrintText " Assignment | Assignment | Local | Yes | Variable | \"
PrintText BenchLocalObjectVariable ()
PrintText " Function | Function | Global | No | Variable | \"
PrintText BenchGlobalFunctionVariable ()
PrintText " Function | Function | Local | No | Variable | \"
PrintText BenchLocalFunctionVariable ()
PrintText " Assignment | Assignment | Global | No | Variable | \"
PrintText BenchGlobalVariable ()
PrintText " Assignment | Assignment | Local | No | Variable | \"
PrintText BenchLocalVariable ()
PrintText " None | None | ~ | No | N/A | \"
PrintText BenchShell ()
PrintText "------------|------------|--------|--------|-------------|-------------"
WaitKey
End
Function PrintText ( Text$ )
If Right ( Text , 1 ) = "\"
Write Left ( Text , Len ( Text ) - 1 )
DebugLog Left ( Text , Len ( Text ) - 1 )
Else
Print Text
DebugLog Text
EndIf
End Function
;-->