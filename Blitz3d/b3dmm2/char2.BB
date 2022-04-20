;XLnt-GUI CODE
Include "XLNT-GUI_V1.84.BB"
Graphics 800,600,0,1
GUI_GFXSETUP()
 
;Edit Window GUI DATA
charwin.WINDOW=GUI_WINDOW(296,98,290,323,"Edit Window",0,0,0,0,0)
;Gadgets....
cmd_.GADGET=GUI_BUTTUN(charwin,20,292,40,"Button",1,"")
cmd_.GADGET=GUI_BUTTUN(charwin,68,292,40,"Button",1,"")
cmd_.GADGET=GUI_BUTTUN(charwin,228,292,40,"Button",1,"")
cmd_.GADGET=GUI_BUTTUN(charwin,180,292,40,"Button",1,"")
cmd_.GADGET=GUI_BUTTUN(charwin,124,292,16,"<<",1,"")
cmd_.GADGET=GUI_BUTTUN(charwin,148,292,16,">>",1,"")
frm_.GADGET=GUI_FRAME(charwin,12,284,264,32,"",0,"")
tab_cchar.GADGET=GUI_TAB(charwin,4,52,72,"Character",1,"")
tab_2.GADGET=GUI_TAB(charwin,76,52,55,"Statistics",2,"")
tab_citems.GADGET=GUI_TAB(charwin,132,52,40,"Items",3,"")
tab_cspells.GADGET=GUI_TAB(charwin,172,52,38,"Spells",4,"")
frm_.GADGET=GUI_FRAME(charwin,4,68,280,208,"",4,"")
Name:.GADGET=GUI_TXTINPUT(charwin,16,28,88,"","Name:",50,1,"")
sel_ctype.GADGET=GUI_CYCLE(charwin,196,28,106,"Character#Hireling#",0,0,"")
sel_.GADGET=GUI_CYCLE(charwin,20,84,72,"One#Two#Three#",0,1,"")
sel_.GADGET=GUI_CYCLE(charwin,156,84,72,"One#Two#Three#",0,1,"")
int_.GADGET=GUI_INTEGER(charwin,100,84,"",0,0,100,1,"")
int_.GADGET=GUI_INTEGER(charwin,236,84,"",0,0,100,1,"")
frm_.GADGET=GUI_FRAME(charwin,12,68,128,192,"Equiped",0,"")
frm_.GADGET=GUI_FRAME(charwin,148,68,128,192,"Backpack",0,"")
 