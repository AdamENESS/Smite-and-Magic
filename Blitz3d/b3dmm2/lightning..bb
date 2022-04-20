Graphics 640,480,16,2
AppTitle "Lightning by Eikon"
SetBuffer BackBuffer()
SeedRnd(MilliSecs())
Color 255, 255, 255
PosX = 320
TextY = 230
Choice = 1
While Not KeyDown(1)
Cls
Color 255, 255, 255
Text TextX, TextY, "Lightning Demo by Eikon & Drago"
Color 255, 255, 255: Text 1, 1, "WHITE / YELLOW"
Color 255, 255, 255: Text 1, 15, " SHADES OF BLUE"
If Choice = 1 Then Color 0, 255, 255: Text 1, 1, "WHITE / YELLOW"
If Choice = 2 Then Color 0, 255, 255: Text 1, 15, " SHADES OF BLUE"
For TempX = 1 To 480
TurnLeftorRight = Rnd(1, 2) ; Turn Left or Right
BranchOff = Rnd(1, 5) ; 1 in 5 chance to branch off
;If choice = 1 Then WhiteOrYellow = Rnd(1, 2); Lightning Color
;If choice = 2 Then ShadesOfBlue = Rnd(1, 2); Lightning Color
NewPosY = NewPosY + 1; Strike Downward
If BranchOff = 3 Then
If TurnLeftorRight = 1 Then PosX = PosX - 5
If TurnLeftorRight = 2 Then PosX = PosX + 5
End If
If choice = 1 Then Color 255, 255, Rnd(255) ; Yellow
If  choice = 2 Then Color 0, Rnd(255), 255 ; Blue
Rect PosX, NewPosY, 4,4
Next
NewPosY = 1
PosX = 320
TextX = TextX + 5
If TextX > 660 Then TextX = -140
If KeyDown(200) Then Choice = 1
If KeyDown(208) Then Choice = 2
Flip
Wend