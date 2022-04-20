Dim mode16(24),mode32(24)

Function start()
Gfx.WINDOW=GUI_WINDOW(0,-20,242,82,"Choose GFX Mode",0,0,0,0,0)
;Gadets....
gfx_Res.GADGET=GUI_SELECTOR(gfx,12,28,65,"One#Two#Three#",1,"")
gfx_dpth.GADGET=GUI_SELECTOR(gfx,100,28,38,"16#32#",1,"")
gfx_fs.GADGET=GUI_TICK(gfx,156,28,"FullScreen",1,0,1,"")
gfx_frm.GADGET=GUI_FRAME(gfx,4,20,232,32,"",0,"")
gfx_start.GADGET=GUI_BUTTUN(gfx,140,60,40,"Start",1,"")
gfx_quit.GADGET=GUI_BUTTUN(gfx,188,60,40,"Quit",1,"")
GUI_OPENWIN(gfx)
done=False
mode_cnt=CountGfxModes3D()
	If Not mode_cnt RuntimeError "Can't find any 3D graphics modes"
	b=1
	c=1
For a=1 To CountGfxModes3D()
	If GfxModeDepth(a)=16
	a16$=a16$+b+":"+GfxModeWidth(a)+"x"+GfxModeHeight(a)+"#"
	mode16(b)=a
	b=b+1
	Else
	a32$=a32$+c+":"+GfxModeWidth(a)+"x"+GfxModeHeight(a)+"#"
	mode32(c)=a
	c=c+1
	EndIf
Next
gui_settext(gfx_res,a16$)
sdepth$="16"
gfxfs=2

Repeat
	Flip:SetBuffer BackBuffer():Cls
UpdateWorld

GUI()
	Select EVENT$
		Case "GUI_GADHIT"		;GADGET CLICKED
			Select True
			Case GUI_GADHIT=gfx_quit
			gui_End()
			End
			Case GUI_GADHIT=gfx_start
			done=True
				cshn$=gui_gadtext(gfx_res)
				DebugLog cshn$
			For a=1 To Len(cshn$)
			lch$=lch$+ch$
			ch$=Mid(cshn$,a,1)

			If ch$=":" 
			DebugLog lch
			Exit
			End If
			Next

			Case gui_gadhit=gfx_fs
			fs=gui_gadval(gfx_fs)
			If fs=0
				gfxfs=1
				DebugLog "full"
			Else
				gfxfs=2
			EndIf
			
			Case gui_gadhit=gfx_dpth
			sdepth$=gui_gadtext(gfx_dpth)
			If Int(sdepth$)=16
			gui_settext(gfx_res,a16$)
			Else
			gui_settext(gfx_res,a32$)
			EndIf
			
			End Select
	End Select
Until done=True
gui_freewin(gfx)
If Int(sdepth$)=16
	DebugLog "16"
	gfxw=GfxModeWidth(mode16(Int(lch$)))
	gfxh=GfxModeHeight(mode16(Int(lch$)))
	gfxd=16
Else
	DebugLog "32"
	gfxw=GfxModeWidth(mode32(Int(lch$)))
	gfxh=GfxModeHeight(mode32(Int(lch$)))
	gfxd=32

EndIf
Graphics3D gfxw,gfxh,gfxd,gfxfs
End Function