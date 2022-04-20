;XLnt-GUI CODE
Include "XLNT-GUI_V1.84.BB"
Graphics 800,600,0,1
GUI_GFXSETUP()
 
;Character Editor GUI DATA
Charwin.WINDOW=GUI_WINDOW(296,98,290,323,"Character Editor",0,0,0,0,0)
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
txt_cname.GADGET=GUI_TXTINPUT(Charwin,16,28,88,"","Name:",50,1,"")
sel_ctype.GADGET=GUI_CYCLE(Charwin,196,28,74,"Character#Hireling#",0,0,"")
sel_.GADGET=GUI_CYCLE(Charwin,36,84,88,"NONE#Middlegate#Atlantium#Tundra#Volcania#Sandsobar#",0,1,"")
sel_.GADGET=GUI_CYCLE(Charwin,44,108,72,"Male#Female#",0,1,"")
sel_.GADGET=GUI_CYCLE(Charwin,44,132,72,"Good#Neutral#Evil#",0,1,"")
sel_.GADGET=GUI_CYCLE(Charwin,44,180,72,"Human#Elf#Dwarf#Gnome#Half-Orc#",0,1,"")
sel_.GADGET=GUI_CYCLE(Charwin,36,156,88,"Knight#Paladin#Archer#Cleric#Sorcerer#Robber#Ninja#Barbarian#",0,1,"")
bol_.GADGET=GUI_TICK(Charwin,180,156,"Has Plus '+'",1,0,1,"")
sel_.GADGET=GUI_CYCLE(Charwin,36,220,93,"............#Arms Master#",0,1,"")
frm_.GADGET=GUI_FRAME(Charwin,20,68,120,128,"Frame",0,"")
sel_.GADGET=GUI_CYCLE(Charwin,52,244,53,"One#Two#Three#",0,1,"")
frm_.GADGET=GUI_FRAME(Charwin,20,212,120,56,"",3,"")
int_.GADGET=GUI_INTEGER(Charwin,180,132,"Food",0,0,40,1,"")
txt_.GADGET=GUI_TXTINPUT(Charwin,160,108,56,"","Gems",50,1,"")
txt_.GADGET=GUI_TXTINPUT(Charwin,153,84,88,"","Gold",50,1,"")
bol_.GADGET=GUI_TICK(Charwin,180,172,"Green Crown",0,0,1,"")
 