Type monster
	Field id
	Field name$
	Field HP
	Field SP
	Field AC
	Field Abils
	Field Exper
	Field Gold
	Field MRes
	Field damage
	Field Picture
End Type


Include "XLNT-GUI_V1.84.BB"

Graphics 800,600,0,2
GUI_GFXSETUP()
 ;About
About.WINDOW=GUI_WINDOW(237,180,250,100,"About",1,0,1,0,0)
;Gadets....
face$="tiles.jpg"
img_frame.GADGET=GUI_IMAGEBOX(ABOUT,20,28,56,56,Face$,100,0,"")
cmd_Ok.GADGET=GUI_BUTTUN(ABOUT,196,52,40,"OK",1,"")
msg_a1.GADGET=GUI_TEXT(ABOUT,92,20,100,100,"Might and Magic II - Item Editor","")
msg_a2.GADGET=GUI_TEXT(ABOUT,92,42,100,100,"®2002 Adam Templeton","")
msg_a3.GADGET=GUI_TEXT(ABOUT,92,74,100,100,"Version 1.0 ","")

;Edit Window GUI DATA
MYWIN.WINDOW=GUI_WINDOW(234,74,449,308,"Might and Magic II - Monster Editor",1,0,1,0,0)
;Gadets....
Global txt_name.GADGET=GUI_TXTINPUT(MYWIN,3,36,80,"","Name",50,1,"")
Global sld_HP.GADGET=GUI_SLIDER(MYWIN,180,36,50,0,0,255,1,1,"Hit Points")
Global sld_SP.GADGET=GUI_SLIDER(MYWIN,180,52,50,0,0,255,1,1,"Spell Points")
Global msg_info.GADGET=GUI_TXTBOX(MYWIN,284,44,128,182,"info About Monsters",1,"")
Global msg_1.GADGET=GUI_TEXT(MYWIN,140,36,58,10,"HP","Hit Points")
Global msg_2.GADGET=GUI_TEXT(MYWIN,140,52,58,10,"SP","Hit Points")
Global msg_3.GADGET=GUI_TEXT(MYWIN,140,68,58,10,"AC","Hit Points")
Global msg_4.GADGET=GUI_TEXT(MYWIN,140,84,58,10,"MRES","Hit Points")
Global msg_5.GADGET=GUI_TEXT(MYWIN,140,100,58,10,"EXP","Hit Points")
Global msg_6.GADGET=GUI_TEXT(MYWIN,140,116,58,10,"GOLD","Hit Points")
Global msg_7.GADGET=GUI_TEXT(MYWIN,140,132,58,10,"DMG","Hit Points")
Global sld_AC.GADGET=GUI_SLIDER(MYWIN,180,68,50,0,0,255,1,1,"Armor Class")
Global sld_EXP.GADGET=GUI_SLIDER(MYWIN,180,100,50,0,0,255,1,1,"Experiance Gained by Party")
Global sel_PIC.GADGET=GUI_IMAGE_SELECTOR(MYWIN,4,60,100,100,20,20,True,"Picture")
Global frm_abils.GADGET=GUI_FRAME(MYWIN,20,180,232,72,"Abilities",0,"")
Global sld_MRES.GADGET=GUI_SLIDER(MYWIN,180,84,50,0,0,255,1,1,"Magic Resistance")
Global sld_Damage.GADGET=GUI_SLIDER(MYWIN,180,132,50,0,0,255,1,1,"Damage caused")
Global sld_GOLD.GADGET=GUI_SLIDER(MYWIN,180,116,50,0,0,255,1,1,"Gold Gained by Party")

Global cmd_Load.GADGET=GUI_BUTTUN(MYWIN,28,276,40,"Load",1,"")
Global cmd_save.GADGET=GUI_BUTTUN(MYWIN,76,276,40,"Save",1,"")
Global cmd_about.GADGET=GUI_BUTTUN(MYWIN,332,276,40,"About",1,"")
Global frm_2.GADGET=GUI_FRAME(MYWIN,124,28,144,144,"",1,"")
Global frm_3.GADGET=GUI_FRAME(MYWIN,276,36,160,200,"",2,"")
Global cmd_quit.GADGET=GUI_BUTTUN(MYWIN,380,276,40,"Quit",1,"")
Global frm_4.GADGET=GUI_FRAME(MYWIN,20,260,408,32,"Frame",0,"")
Global prg.GADGET=GUI_PROG(MYWIN,172,276,0,255,"")
Global cmd_Next.GADGET=GUI_BUTTUN(MYWIN,128,276,40,"< Prev",1,"")
Global cmd_Prev.GADGET=GUI_BUTTUN(MYWIN,278,276,40,"Next >",1,"")

Global bol_a.GADGET=GUI_TICK(MYWIN,36,202,"A",0,0,1,"")
Global bol_b.GADGET=GUI_TICK(MYWIN,36,218,"B",0,0,1,"")
Global bol_c.GADGET=GUI_TICK(MYWIN,36,234,"C",0,0,1,"")
Global bol_d.GADGET=GUI_TICK(MYWIN,108,202,"D",0,0,1,"")
Global bol_e.GADGET=GUI_TICK(MYWIN,108,218,"E",0,0,1,"")
Global bol_f.GADGET=GUI_TICK(MYWIN,108,234,"F",0,0,1,"")
Global bol_g.GADGET=GUI_TICK(MYWIN,180,210,"G",0,0,1,"")
Global bol_h.GADGET=GUI_TICK(MYWIN,180,226,"H",0,0,1,"") 
gui_openwin(about)
gui_hidewin(about)
GUI_OPENWIN(MYWIN)

 
Repeat
	Flip:SetBuffer BackBuffer():Cls
GUI()
	Select EVENT$
		Case "GUI_GADHIT"		;GADGET CLICKED
			Select True
 Case GUI_GADHIT=cmd_load
 					fn$=GUI_FILEREQUEST$("Choose Monster Data to Load",".dat#All Files#")
					If fn$<>"NONE"
					gui_winactive(mywin,1)
					load_monster(fn$)
				;	gui_refresh(mywin)
					
					EndIf
				Case GUI_GADHIT=cmd_save
 					fn$=GUI_FILEREQUEST$("Choose Monster Data to Save as",".dat#All Files#")
				; 	unfill_values(Int(tm$))
				;	SAVE_item(fn$)					
				Case GUI_GADHIT=cmd_about
				
				gui_showwin(about)
				gui_winfront(About)
				gui_activewin=about
				Repeat
					Flip:SetBuffer BackBuffer():Cls
					GUI()
					Select EVENT$
					Case "GUI_GADHIT"		;GADGET CLICKED
						Select True
							Case gui_gadhit=cmd_ok
							Exit
						End Select
					End Select
					Forever
 					gui_hidewin(about)
					gui_activewin=mywin

				Case GUI_GADHIT=cmd_quit
 				quit=True

			End Select
		Case "MENU"		;MENU HIT
			Select GUI_MENUHIT
 
			End Select
		Case "QMENU"		;QMENU HIT
			Select GUI_QMENUHIT
 
			End Select
		Case "KILLWIN"		;CLOSE WINDOW
			QUIT=True
	End Select
Until QUIT=True
GUI_END()
End

Function load_monster(file$)
fin=ReadFile(file$)
For a=0 To 255
	mon.monster=New monster
	mon\id=a
	
	; update progress bar :)
;	gui_setval(prg,a)
;	Flip:SetBuffer BackBuffer():Cls
;	GUI()
	; read name and convert to standard letters ie: add 20 to the value read in :)
	For n=0 To 13
	;c$=Chr((ReadByte(fin)+20))
	;DebugLog c$
	temp=ReadByte(fin)
	ch$=Chr(temp-128)
	mon\name$=mon\name$+ch$
	Next 
	;DebugLog	mon\ID+":"+mon\name$
	For c=0 To 11
	temp=ReadByte(fin)
	Next
		DebugLog	mon\ID+":"+mon\name$+"("+temp+")"
Next

CloseFile(fin)
End
End Function