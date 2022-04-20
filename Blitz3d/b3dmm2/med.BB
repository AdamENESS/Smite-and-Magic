;XLnt-GUI CODE
Include "XLNT-GUI_V1.84.BB"
Graphics 800,600,0,1
GUI_GFXSETUP()
 
;Edit Window GUI DATA
MONST.WINDOW=GUI_WINDOW(233,200,300,200,"Edit Window",0,0,0,0,0)
;Gadgets....
cmd_msave.GADGET=GUI_BUTTUN(MONST,68,172,40,"Save",1,"")
cmd_mload.GADGET=GUI_BUTTUN(MONST,20,172,40,"Load",1,"")
cmd_mabout.GADGET=GUI_BUTTUN(MONST,188,172,40,"About",1,"")
cmd_mback.GADGET=GUI_BUTTUN(MONST,236,172,40,"Back",1,"")
tab_mmain.GADGET=GUI_TAB(MONST,12,20,30,"Main",1,"")
frm_m2.GADGET=GUI_FRAME(MONST,4,164,288,32,"",0,"")
cmd_Prev.GADGET=GUI_BUTTUN(MONST,116,172,16,"<<",1,"")
cmd_mnext.GADGET=GUI_BUTTUN(MONST,164,172,16,">>",1,"")
tab_attrib.GADGET=GUI_TAB(MONST,44,20,60,"Attributes",2,"")
frm_.GADGET=GUI_FRAME(MONST,4,36,288,120,"",0,"")
bol_mundead.GADGET=GUI_TICK(MONST,20,52,"Undead",0,0,1,"")
bol_Marcher.GADGET=GUI_TICK(MONST,20,68,"Archer",0,0,1,"")
frm_m5.GADGET=GUI_FRAME(MONST,12,44,272,40,"",0,"")
sel_.GADGET=GUI_SELECTOR(MONST,84,60,165,"One#Two#Three#",1,"")
bol_mflee.GADGET=GUI_TICK(MONST,20,100,"Can Flee",1,0,1,"")
sel_.GADGET=GUI_CYCLE(MONST,124,124,80,"One#Two#Three#",0,1,"Ability used on Whole Party Frequency")
sel_.GADGET=GUI_CYCLE(MONST,92,100,168,"One#Two#Three#",0,1,"Ability used on Whole Party")
frm_.GADGET=GUI_FRAME(MONST,12,92,272,56,"",0,"Ability used on Whole Party")
bol_.GADGET=GUI_TICK(MONST,20,124,"Adds Friends",0,0,1,"Ability used on Whole Party")
 
