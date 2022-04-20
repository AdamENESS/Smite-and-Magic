;XLnt-GUI CODE
Include "XLNT-GUI_V1.84.BB"
Graphics 800,600,0,1
GUI_GFXSETUP()
 
;Edit Window GUI DATA
Charwin.WINDOW=GUI_WINDOW(296,98,290,323,"Edit Window",0,0,0,0,0)
;Gadgets....
cmd_.GADGET=GUI_BUTTUN(Charwin,20,292,40,"Button",1,"")
cmd_.GADGET=GUI_BUTTUN(Charwin,68,292,40,"Button",1,"")
cmd_.GADGET=GUI_BUTTUN(Charwin,228,292,40,"Button",1,"")
cmd_.GADGET=GUI_BUTTUN(Charwin,180,292,40,"Button",1,"")
cmd_.GADGET=GUI_BUTTUN(Charwin,124,292,16,"<<",1,"")
cmd_.GADGET=GUI_BUTTUN(Charwin,148,292,16,">>",1,"")
frm_.GADGET=GUI_FRAME(Charwin,12,284,264,32,"",0,"")
tab_cchar.GADGET=GUI_TAB(Charwin,4,52,72,"Character",1,"")
tab_2.GADGET=GUI_TAB(Charwin,76,52,55,"Statistics",2,"")
tab_citems.GADGET=GUI_TAB(Charwin,132,52,40,"Items",3,"")
tab_cspells.GADGET=GUI_TAB(Charwin,172,52,38,"Spells",4,"")
frm_.GADGET=GUI_FRAME(Charwin,4,68,280,208,"",4,"")
Name:.GADGET=GUI_TXTINPUT(Charwin,16,28,88,"","Name:",50,1,"")
sel_ctype.GADGET=GUI_CYCLE(Charwin,196,28,106,"Character#Hireling#",0,0,"")
int_.GADGET=GUI_INTEGER(Charwin,20,76,"Level",0,0,255,1,"")
txt_.GADGET=GUI_TXTINPUT(Charwin,101,76,72,"","HP",50,1,"")
txt_.GADGET=GUI_TXTINPUT(Charwin,198,76,72,"","/",50,1,"")
txt_.GADGET=GUI_TXTINPUT(Charwin,102,100,50,"","Input",50,1,"")
txt_.GADGET=GUI_TXTINPUT(Charwin,101,124,112,"","Experience",50,1,"")
int_.GADGET=GUI_INTEGER(Charwin,108,148,"Age",0,0,255,1,"")
int_.GADGET=GUI_INTEGER(Charwin,220,148,"AC",0,0,255,1,"")
int_.GADGET=GUI_INTEGER(Charwin,220,172,"SL",0,0,255,1,"")
int_.GADGET=GUI_INTEGER(Charwin,108,172,"Thievery",0,0,255,1,"")
 