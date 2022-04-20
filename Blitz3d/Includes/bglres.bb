; GL res selecter.
Type reso
Field width,height,depth,freq,ID
End Type
Global winmode
Global main_window
Global load$

Global winwid,winhgt
mode=0
bob=1
While bob=1
res.reso=New reso
bob=bglCheckRes(res,mode)

If (res\depth=8 Or res\depth=4); And res\freq<>60
Delete res
Else If res\freq<>60
Delete res
EndIf
mode=mode+1
Wend

Global Win1
Global Combo1
Global Label1
Global TextField1
Global Button1
Global Button2
Global Button3
Function bglSelectRes(bgl_winname$,bgltye=0,typ$="")
CreateWin1(bgl_winname$)
timer=CreateTimer(100)
While WaitEvent()
	Select EventID()
		Case $803
		End
	End Select
	Select EventSource()
		Case button3
		End
		Case button1
			Select bgltye
			Case 0
			load$=RequestFile$("Choose a "+typ$+" To load",Typ$)
			SetGadgetText textfield1,load$
			Case 1
				load$=RequestDir$("Choose a "+typ$+" Directory")
				SetGadgetText textfield1,load$
		End Select
		Case button2
		If load$="" 
						Select bgltye
			Case 0
			load$=RequestFile$("Choose a "+typ$+" To load",Typ$)
			SetGadgetText textfield1,load$
			Case 1
				load$=RequestDir$("Choose a "+typ$+" Directory")
				SetGadgetText textfield1,load$
		End Select
		EndIf
;load$=RequestFile$("Choose a "+typ+" To load",typ$)
		Exit
		Case combo1
		selected=SelectedGadgetItem(combo1)
		winmode=selected
		For res.reso=Each reso
		If selected=res\ID

;		DebugLog res\width+"x"+res\height+":"+res\depth
		winwid=res\width
		winhgt=res\height
		windph=res\depth
		winfreq=res\freq	
		EndIf
		Next
	End Select


; Do Something

;winwid=640 : winhgt=480

;main_Window=CreateWindow("BlitzGL B3D Demo",(ClientWidth(Desktop())/2)-winwid/2,(ClientHeight(Desktop())/2)-winhgt/2,winwid,winhgt,0,%1011)
;main_Window=CreateWindow("BlitzGL B3D Demo",0,0,winwid,winhgt,0,%1011)

Wend



If winmode=0
winwid=640 : winhgt=480
main_Window=CreateWindow(bgl_winname$,(ClientWidth(Desktop())/2)-winwid/2,(ClientHeight(Desktop())/2)-winhgt/2,winwid,winhgt,0,%1011)
Else
main_Window=CreateWindow(bgl_winname$,0,0,winwid,winhgt,0,0)
CreateGLWindow("",winwid,winhgt,windph,winfreq,1)
EndIf

bglGetBlitzWindow(windph,bgl_winname$)
;oglwindow=bp_createfullscreen("BOB",1)
bglFindChild(10,10)
bglSetupGL()
;oglwindow=bp_createfullscreen("BOB",0)
ReSizeProjection(winwid,winhgt)



FreeGadget win1

End Function
; ----Function Begins----
Function CreateWin1(bgl_winname$)
Win1 = CreateWindow(bgl_winname$+" Launcher",50,150,321,153,Desktop(),3)
Combo1 = CreateComboBox(85,8,200,100,Win1,0)
id=1
AddGadgetItem combo1,"Windowed (640x480)"
For res.reso=Each reso
name$=res\width+"x"+res\height+":"+res\depth;+" "+res\freq+"Hz"
AddGadgetItem combo1,name$
res\ID=ID
id=id+1
Next

SelectGadgetItem Combo1,0
SetGadgetLayout Combo1,1,0,1,0
Label1 = CreateLabel("Resolution",19,11,50,20,Win1,0)
SetGadgetLayout Label1,1,0,1,0
TextField1 = CreateTextField(85,37,200,20,Win1,0)
SetGadgetText TextField1," "
SetGadgetLayout TextField1,1,0,1,0
Button1 = CreateButton("Model",49,37,30,20,Win1,0)
SetGadgetLayout Button1,1,0,1,0
Button2 = CreateButton("Launch",165,97,60,20,Win1,0)
SetGadgetLayout Button2,1,0,1,0
Button3 = CreateButton("Quit",232,97,60,20,Win1,0)
SetGadgetLayout Button3,1,0,1,0
End Function