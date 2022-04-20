; RPG toolkit Battle engine.

include "proto.bb"
dim battle(12)
graphics3d 800,600,32,2
setbuffer backbuffer()
init_battle()

waitkey
function Init_Battle()
	SeedRnd MilliSecs()
	able=Rnd(5)+1
	; choose a random amount of monsters
	mon_no=(Rnd(5)+5)
	for a=0 to mon_no
		m.monster=object.monster((I_MONSTER(Rnd(231)+1)))
		bat.monster=new monster
			bat\name$=m\name$
			bat\HP=m\hp
			bat\ohp=m\ohp
			bat\SP=m\sp
			bat\AC=m\ac
			bat\Pabil=m\pabil
			bat\SAbil=m\sabil
			bat\Oabil=m\oabil
			bat\Abil1=m\abil1
			bat\Abil2=m\abil2
			bat\Exper=m\exper
			bat\oexp=m\oexp
			bat\Gold=m\gold
			bat\gems=m\gems
			bat\MRes=m\mres
			bat\damage=m\damage
			bat\Picture=m\picture
			bat\Undead=m\undead
			bat\Archer=m\archer
			bat\flee=m\flee
			bat\speed=m\speed
		Battle(a)=handle(bat)
		print a+" Name:"+bat\name$+" HP:"+bat\hp+" Handle:"+battle(A)
	next
end function

