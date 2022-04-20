; Dragos RPG Toolkit/MM2 remake Proto file.

;types
Include "spells.bb"

Global  Dlay=100
Type clerical
Field ID
Field Level
Field Spell
Field Name$
Field Effect
Field Damage[2]
Field Cost[2]
Field Desc$[10]
Field combat
End Type

Type Sorceror
Field ID
Field Level
Field Spell
Field Name$
Field Effect ; 0 is all
Field Damage[2]
Field Cost[2]
Field Desc$[10]
Field combat
End Type

Type party
	Field Char[8]
	Field light=0
	Field protmag=0
	Field protelm=0
	Field shield=0
	Field shelter=0
	Field wizard=0
	Field eagle=0
	Field Floating=0
	Field invis=0
	Field dambonus=0
End Type

party.party=New party
Type character
	Field name$
	Field race,class,sex,allignment
	Field MGT,INTE,PER,ENDU,SPD,ACC,LCK
	

	Field HP,MHP
	Field SP,MSP
	Field AC,THV
	Field backpack[6]
	Field equiped[6]
	Field backplus[6]
	Field equiplus[6]
	Field backefft[6]
	Field equiefft[6]
	Field GOLD
	Field Exper
	Field GEMS
	Field FOOD
	Field Skill[2]
	Field SPLVL
	Field Spell[48]
	Field ID
	Field age
	Field Town
	Field LVL
	Field day
	Field plus
	Field entity
	Field battle[9]
	Field asleep
	Field dead
	Field erad
	Field posion
	Field disease
	Field stones
	Field silence
	Field paralysed
	Field tMGT,tINTE,tPER,tENDU,tSPD,tACC,tLCK ; temp effects
	Field tHP,tMHP,tSP,tMSP
End Type


Type hireling
	Field name$
	Field race,class,sex,allignment
	Field MGT,INTE,PER,ENDU,SPD,ACC,LCK
	Field HP,MHP
	Field SP,MSP
	Field AC,THV
	Field backpack[6]
	Field equiped[6]
	Field backplus[6]
	Field equiplus[6]
	Field backefft[6]
	Field equiefft[6]
	Field Cost
	Field Exper
	Field GEMS
	Field FOOD
	Field Skill[2]
	Field SPLVL
	Field Spell[48]
	Field ID
	Field age
	Field Town
	Field LVL
	Field day
	Field plus
	Field entity
	Field asleep
	Field dead
	Field erad
	Field posion
	Field disease
	Field stones
	Field paralysed
Field tMGT,tINTE,tPER,tENDU,tSPD,tACC,tLCK
	Field tHP,tMHP,tSP,tMSP
End Type
Dim race$(4),class$(7),town$(5),skill$(16)
race(0)="Human"
race(1)="Elf"
race(2)="Dward"
race(3)="Gnome"
race(4)="Half-Orc"
class(0)="Knight"
class(1)="Paladin"
class(2)="Archer"
class(3)="Cleric"
class(4)="Sorceror"
class(5)="Robber"
class(6)="Ninja"
class(7)="Barbarian"
town(0)="NONE"
town(1)="Middlegate"
town(2)="Atlantium"
town(3)="Tundra"
town(4)="Vulcania"
town(5)="Sandsobar"

skill(0)="............"
skill(1)="Arms Master"
skill(2)="Athlete"
skill(3)="Cartographer"
skill(4)="Crusader"
skill(5)="Diplomat"
skill(6)="Gambler"
skill(7)="Gladiator"
skill(8)="Hero/Heroine"
skill(9)="Linguist"
skill(10)="Merchant"
skill(11)="Mountaineer"
skill(12)="Navigator"
skill(13)="Pathfinder"
skill(14)="PickPocket"
skill(15)="Soldier"

Dim nxoffset(8),nyoffset(8)

nxoffset(1)=0: nyoffset(1)=0
nxoffset(2)=0: nyoffset(2)=1
nxoffset(3)=1: nyoffset(3)=0
nxoffset(4)=1: nyoffset(4)=1
nxoffset(5)=2: nyoffset(5)=0
nxoffset(6)=2: nyoffset(6)=1
nxoffset(7)=3: nyoffset(7)=0
nxoffset(8)=3: nyoffset(8)=1
dim I_item(256)
dim I_Monster(256)

Global mon_no=0
Type monster
	Field id
	Field name$
	Field HP,ohp
	Field SP
	Field AC
	Field Pabil,SAbil,Oabil
	Field Abil1
	Field Abil2
	Field Exper,oexp
	Field Gold
	Field gems
	Field MRes
	Field damage
	Field Picture
	Field Undead
	Field Archer
	Field flee
	Field speed
	;temp
	Field Colour
End Type

Global ABLE=0
Dim tempa(8)
Dim tempb(8)
Dim tempc(8)
Dim adesc$(32)
Dim partydec$(32)
Dim ent_battle(9)
Global amount
f=ReadFile("adesc.log")
For a=0 To 31
	adesc$(a)=ReadLine(f)
	adec$=adec+adesc$(a)+"#"
Next
f=ReadFile("partyeffect.log")
For a=0 To 31
	partydec$(a)=ReadLine(f)
	pdec$=pdec+partydec$(a)+"#"
Next
pdec$=pdec+"NONE#"
Type battlemonst
	Field id,realID
	Field name$
	Field HP,ohp
	Field SP
	Field AC
	Field Pabil,SAbil,Oabil
	Field Abil1
	Field Abil2
	Field Exper,oexp
	Field Gold
	Field gems
	Field MRes
	Field damage
	Field Picture
	Field Undead
	Field Archer
	Field flee
	Field speed
	Field amount=1
	Field entity
	Field posX,posY
	Field status$
	Field asleep
	Field dead
	Field erad
	Field posion
	Field disease
	Field stones
	Field paralysed
	Field silence
	Field Fireencased=0
	Field waterencased=0
	Field Earthencased=0
	Field airencased=0

End Type

Type item
	Field name$
	Field Value
	Field Damage
	Field ID
	Field Usableby
	Field usa[8]
	Field effect$[2]; 0 is type 1 amount
	Field bonus$[2] ; 0 is type 1 amount
End Type



	load_item("items.dat")
	load_monster("monsters.dat")
	load_roster("roster.dat")
	create_clerical()
	create_sorceror()




Function load_item(file$)
id=0
filein=ReadFile(file$)
For a=0 To 255
item.item = New item
item\id=a
For c=0 To 11
ch$=Chr$(ReadByte(filein))
item\name$=item\name$+ch$
Next
ReadByte(filein)
as$=as$+a+": "+item\name$+"#"
item\usableby=ReadByte(filein)
temp$=Hex(ReadByte(filein))
item\bonus[0]=hex2int(Mid(temp$,7,1))
item\bonus[1]=hex2int(Right(temp$,1))
temp$=Hex(ReadByte(filein))
item\effect[0]=hex2int(Mid(temp$,7,1))
item\effect[1]=hex2int(Right(temp$,1))
item\damage=ReadByte(filein)
ReadByte(filein)
item\value=ReadShort(filein)
I_ITEM(a)=handle(item)
Next
CloseFile(filein)
End Function

Function load_monster(file$)
fin=ReadFile(file$)
For a=0 To 255

	mon.monster=New monster
	mon\id=a
	
	For n=0 To 13
	temp=ReadByte(fin)
	ch$=Chr(temp-128)
	If ch$<>" "	mon\name$=mon\name$+ch$
	Next 
	;;debuglog	mon\ID+":"+mon\name$
	;hit points, 
	temp=ReadByte(fin)
	mon\ohp=temp

	If temp<71
		mon\hp=temp+1
	Else If temp>70 And temp<134
		mon\hp=70+((temp-70)*10)
	Else If temp>133 And temp<178
		mon\hp=700+((temp-134)*100)
	Else If temp>177 
			mon\hp=64000-(255-temp)*1000
	End If
	
	; Experience similar in workings to hp but able to use bigger values.
	tempE=ReadByte(fin)
	mon\oexp=tempe
	If tempe<62
	mon\exper=60+((tempe-37)*10)
	Else If tempe<128
	mon\exper=200+((tempe-65)*100)
	Else If tempe<138
	mon\exper=1000+((tempe-128)*1000)
	Else If tempe<160
	mon\exper=10000+((tempe-137)*1000)
	Else If tempe<190
	mon\exper=10000+((tempe-160)*10000)
	Else If tempe<220
	mon\exper=0000+((tempe-191)*10000)
	Else
	mon\exper=10000+((tempe-224)*10000)

	EndIf
	; Gold.. gems.. unknown how it works atm, I think the forst hex character is gold and the second is gems.
	; experience also debates what item is given i think.
	gold=ReadByte(fin)
	;mon\gold=hex2int(Mid(Right(Hex(gold),2),1,1))
	;mon\Gems=hex2int(Right(Hex(gold),1))
	mon\Pabil=ReadByte(fin)
	mon\Sabil=ReadByte(fin)
	mon\Oabil=ReadByte(fin)
	mon\speed=ReadByte(fin)
	mon\picture=ReadByte(fin)
	mon\AC=ReadByte(fin)
	mon\damage=ReadByte(fin)
	mon\Speed=ReadByte(fin)
	mon\MRES=ReadByte(fin)
	

	For ab=1 To 8
	tempa(ab-1)=Mid(Right(Bin(mon\Sabil),8),ab,1)
	tempb(ab-1)=Mid(Right(Bin(mon\Pabil),8),ab,1)
	tempc(ab-1)=Mid(Right(Bin(mon\oAbil),8),ab,1)

	Next
	mon\undead=tempa(0)
	mon\archer=tempa(1)
	mon\Flee=tempb(1)
	tempo=0
	If tempa(7)=1	tempo=tempo+1
	If tempa(6)=1	tempo=tempo+2
	If tempa(5)=1	tempo=tempo+4
	If tempa(4)=1	tempo=tempo+8
	If tempa(3)=1	tempo=tempo+16
	mon\abil1=tempo
	tempo=0
	If tempb(7)=1	tempo=tempo+1
	If tempb(6)=1	tempo=tempo+2
	If tempb(5)=1	tempo=tempo+4
	If tempb(4)=1	tempo=tempo+8
	If tempb(3)=1	tempo=tempo+16
	mon\abil2=tempo
	;debuglog mon\ID+":"
	;debuglog mon\name$+" HP:"+(mon\hp)+"("+temp+") Exp:"+mon\exper+"("+tempe+") gold:"+Mid(Right(Hex(mon\gold),2),1,1)+" Gems:"+Right(Hex(mon\gold),1)+" MAX damage: "+Mon\damage
	;debuglog "Undead: "+mon\undead+" Archer: "+mon\Archer+" Can't Run: "+mon\flee+" Picture:"+mon\picture+" AC:"+mon\ac+" SP: "+mon\sp+" MRES:"+mon\mres
	;debuglog "single ability "+mon\abil1+":"+adesc$(mon\abil1)
;	If Mid(Right(Hex(mon\pabil),2),1,1)>0 ;debuglog "Party  ability "+mon\abil2+":"+partydec$(mon\abil2)

	mon\Colour=clr
	clr=clr+1
	If clr=3
	clr=0
	EndIf
	I_MONSTER(a)=handle(mon)	
Next
CloseFile(fin)
End Function
Function hex2int(String$)
	Select String$
	Case "0"
	temp=0
	Case "1"
	temp=1
	Case "2"
		temp=2
	Case "3"
		temp=3
	Case "4"
		temp=4
	Case "5"
		temp=5
	Case "6"
		temp=6
	Case "7"
		temp=7
	Case "8"
		temp=8
	Case "9"
		temp=9
	Case "A"
		temp=10
	Case "B"
		temp=11
	Case "C"
		temp=12
	Case "D"
		temp=13
	Case "E"
		temp=14
	Case "F"
		temp=15
End Select
Return temp
End Function


Function load_roster(file$)
fin=ReadFile(file$)
For a=1 To 24
	;;debuglog "character:"+a
	char.character=New character
	char\ID=a
	For c=0 To 9
		ch$=Chr(ReadByte(fin))
		char\name$=char\name$+ch
	Next
	
	;;debuglog "NAME:"+char\name$
	ReadByte(fin)
	char\town=ReadByte(fin)
	
	;;debuglog "Town: "+town(char\town)
	char\sex=ReadByte(fin)
	If char\sex=0
	;;debuglog "sex: Male"
	Else
	;;debuglog "sex: female"
	End If
	char\allignment=ReadByte(fin)

	Select 	char\allignment

	Case 0
	;;debuglog "Allignment: Good"
	Case 1
	;;debuglog "Allignment: Neutral"
	Case 2
		;;debuglog "Allignment: Evil"
	End Select
	char\race=ReadByte(fin)
	;;debuglog "Race: "+race(char\race)
	char\class=ReadByte(fin)
	;;debuglog "Class: "+class(char\class)
	; Statistics

	char\MGT=ReadByte(fin)	
	char\INTE=ReadByte(fin)	
	char\PER=ReadByte(fin)
	crloc=FilePos(fin)
	SeekFile(fin,(((a-1)*130)+39))
	char\ENDU=ReadByte(fin)	
	SeekFile(fin,crloc)	
	char\SPD=ReadByte(fin)	
	char\ACC=ReadByte(fin)	
	char\LCK=ReadByte(fin)	
		
	;;debuglog "Might:"+char\mgt
		;;debuglog "Intellect:"+char\inte
		;;debuglog "Personality:"+char\per
		;;debuglog "Endurance:"+char\endu
		;;debuglog "Speed:"+char\spd
		;;debuglog "Accuracy:"+char\acc
		;;debuglog "Luck:"+char\lck
		
		SeekFile(fin,(((a-1)*130)+30))
		char\thv=ReadByte(fin)
		;;debuglog "Thievery: "+char\thv
		char\lvl=ReadByte(fin)
		char\lvl=ReadByte(fin)
		;;debuglog "Level: "+char\lvl
		char\age=ReadByte(fin)
		;;debuglog "Age: "+char\age
		char\day=ReadByte(fin)
		;;debuglog "Days old: "+char\day
		char\sPLVL=ReadByte(fin)
		;;debuglog "Spell Level:"+char\splvl
		char\food=ReadByte(fin)
		char\food=ReadByte(fin)
		;;debuglog "Food:"+char\food
		ReadByte(fin)	
		ReadByte(fin)	
		For eq=0 To 5
			char\equiped[eq]=ReadByte(fin)		
		Next
		For eq=0 To 5
			char\equiplus[eq]=ReadByte(fin)		
		Next
		For eq=0 To 5
			char\equiefft[eq]=ReadByte(fin)		
		Next
	For eq=0 To 5
		For item.item=Each item
			If char\equiped[eq]=item\id
				;;debuglog "Equiped:"+item\name$+"+"+char\equiplus[eq]
			End If
		Next
	Next
			For eq=0 To 5
			char\backpack[eq]=ReadByte(fin)		
		Next
		For eq=0 To 5
			char\backplus[eq]=ReadByte(fin)		
		Next
		For eq=0 To 5
			char\backefft[eq]=ReadByte(fin)		
		Next
	For eq=0 To 5
		For item.item=Each item
			If char\backpack[eq]=item\id
				;;debuglog "Backpack:"+item\name$+"+"+char\backplus[eq]
			End If
		Next
	Next
		SeekFile(fin,((a-1)*130)+80)
		temp$=Hex(ReadByte(fin))
		
		char\skill[0]=hex2int(Mid(Right(temp$,2),1,1))
		char\skill[1]=hex2int(Right(temp$,1))

		;;debuglog "Skill 1: "+skill(char\skill[0])
		;;debuglog "Skill 2: "+skill(char\skill[1])
		stemp1$=Bin(ReadByte(fin))
		stemp2$=Bin(ReadByte(fin))
		stemp3$=Bin(ReadByte(fin))
		stemp4$=Bin(ReadByte(fin))
		stemp5$=Bin(ReadByte(fin))
		stemp6$=Bin(ReadByte(fin))
stemp1=Right(stemp1,8)
stemp2=Right(stemp2,8)
stemp3=Right(stemp3,8)
stemp4=Right(stemp4,8)
stemp5=Right(stemp5,8)
stemp6=Right(stemp6,8)
spl2=0
		For spl=8 To 1 Step -1
			char\spell[spl2]=Int(Mid(stemp1,spl,1))
			spl2=spl2+1
		Next
		For spl=16 To 9 Step -1
			char\spell[spl2]=Int(Mid(stemp2,spl-8,1))
			spl2=spl2+1
		Next
		For spl=24 To 17 Step -1
			char\spell[spl2]=Int(Mid(stemp3,spl-16,1))
						spl2=spl2+1
		Next
		For spl=32 To 25 Step -1
			char\spell[spl2]=Int(Mid(stemp4,spl-24,1))
						spl2=spl2+1
		Next
		For spl=40 To 33 Step -1
			char\spell[spl2]=Int(Mid(stemp5,spl-32,1))
						spl2=spl2+1
		Next
		For spl=48 To 41 Step -1
			char\spell[spl2]=Int(Mid(stemp6,spl-40,1))
						spl2=spl2+1
		Next
		spl2=0
		;;debuglog "Has Spells"
		as$=""
		For spl=1 To 7

		as$=as$+"1-"+Str$(spl)+"(
		as$=as$+char\spell[spl2]+") "
		spl2=spl2+1
		Next
		;;debuglog as$
	as$=""

		For spl=1 To 7
		as$=as$+"2-"+Str$(spl)+"(
		as$=as$+char\spell[spl2]+") "
		spl2=spl2+1
	
		Next
			;;debuglog as$	
	as$=""

		For spl=1 To 6
			as$=as$+"3-"+Str$(spl)+"(
			as$=as$+char\spell[spl2]+") "
			spl2=spl2+1
			
				
		Next
				;;debuglog as$
	as$=""

		For spl=1 To 6
			as$=as$+"4-"+Str$(spl)+"(
			as$=as$+char\spell[spl2]+") "
			spl2=spl2+1
			
		Next
				;;debuglog as$
	as$=""

		For spl=1 To 5
			as$=as$+"5-"+Str$(spl)+"(
			as$=as$+char\spell[spl2]+") "
			spl2=spl2+1
			
		Next
				;;debuglog as$
	as$=""

		For spl=1 To 5
			as$=as$+"6-"+Str$(spl)+"(
			as$=as$+char\spell[spl2]+") "
			spl2=spl2+1
			
		Next
				;;debuglog as$
	as$=""

		For spl=1 To 4
			as$=as$+"7-"+Str$(spl)+"(
			as$=as$+char\spell[spl2]+") "
			spl2=spl2+1
		Next
				;;debuglog as$
	as$=""

		For spl=1 To 4
			as$=as$+"8-"+Str$(spl)+"(
			as$=as$+char\spell[spl2]+") "
			spl2=spl2+1
		Next
				;;debuglog as$
	as$=""

		For spl=1 To 4
			as$=as$+"9-"+Str$(spl)+"(
			as$=as$+char\spell[spl2]+") "
			spl2=spl2+1
		Next
				;;debuglog as$
		SeekFile(fin,((a-1)*130)+88)
		char\SP=ReadShort(fin)
		char\MSP=ReadShort(fin)
		temp1=ReadByte(fin)
		temp2=ReadByte(fin)
		char\GEMS=temp1+(temp2*256)
		char\HP=ReadShort(fin)
		char\MHP=ReadShort(fin)
		;;debuglog "HIT POINTS "+char\Hp+"/"+char\MHp
		;;debuglog "SPELL POINTS "+char\sp+"/"+char\Msp

		temp1=ReadByte(fin)
		temp2=ReadByte(fin)
		temp3=ReadByte(fin)
		temp4=ReadByte(fin)
			char\exper=temp1+(temp2*256)+(temp3*65536)+(temp4*16777216)
temp1=ReadByte(fin)
		temp2=ReadByte(fin)
		temp3=ReadByte(fin)
			char\GOLD=temp1+(temp2*256)+(temp3*65536)

;		;;debuglog Right(Hex(temp1),2)+" "+Right(Hex(temp2),2)+" "+Right(Hex(temp3),2)+" "+Right(Hex(temp4),2)+" "
		;;debuglog "Experience:"+char\exper
	;;debuglog "Gold:"+char\gold		
		;;debuglog "Gems:"+char\gems
		SeekFile(fin,((a-1)*130)+121)
		char\plus=ReadByte(fin)
		;;debuglog "Has Plus:"+Right(Bin(char\plus),8)
		SeekFile(fin,((a)*130))
;	For b=0 To 107
;	temp=ReadByte(fin)
;	;;debuglog 	Chr(temp)
;	Next
	;;debuglog "End Of character:"+a
	;;debuglog ""

Next

For a=1 To 24
	;;debuglog "Hireling:"+a
	hire.hireling=New hireling
	hire\ID=a
	For c=0 To 9
		ch$=Chr(ReadByte(fin))
		hire\name$=hire\name$+ch
	Next
	
	;;debuglog "NAME:"+hire\name$
	ReadByte(fin)
	hire\town=ReadByte(fin)
	
	;;debuglog "Town: "+town(hire\town)
	hire\sex=ReadByte(fin)
	If hire\sex=0
	;;debuglog "sex: Male"
	Else
	;;debuglog "sex: female"
	End If
	hire\allignment=ReadByte(fin)

	Select 	hire\allignment

	Case 0
	;;debuglog "Allignment: Good"
	Case 1
	;;debuglog "Allignment: Neutral"
	Case 2
		;;debuglog "Allignment: Evil"
	End Select
	hire\race=ReadByte(fin)
	;;debuglog "Race: "+race(hire\race)
	hire\class=ReadByte(fin)
	;;debuglog "Class: "+class(hire\class)
	; Statistics

	hire\MGT=ReadByte(fin)	
	hire\INTE=ReadByte(fin)	
	hire\PER=ReadByte(fin)
	crloc=FilePos(fin)
	SeekFile(fin,((((a+24)-1)*130)+39))
	hire\ENDU=ReadByte(fin)	
	SeekFile(fin,crloc)	
	hire\SPD=ReadByte(fin)	
	hire\ACC=ReadByte(fin)	
	hire\LCK=ReadByte(fin)	
		
	;;debuglog "Might:"+hire\mgt
		;;debuglog "Intellect:"+hire\inte
		;;debuglog "Personality:"+hire\per
		;;debuglog "Endurance:"+hire\endu
		;;debuglog "Speed:"+hire\spd
		;;debuglog "Accuracy:"+hire\acc
		;;debuglog "Luck:"+hire\lck
		
		SeekFile(fin,((((a+24)-1)*130)+30))
		hire\thv=ReadByte(fin)
		;;debuglog "Thievery: "+hire\thv
		hire\lvl=ReadByte(fin)
		hire\lvl=ReadByte(fin)
		;;debuglog "Level: "+hire\lvl
		hire\age=ReadByte(fin)
		;;debuglog "Age: "+hire\age
		hire\day=ReadByte(fin)
		;;debuglog "Days old: "+hire\day
		hire\sPLVL=ReadByte(fin)
		;;debuglog "Spell Level:"+hire\splvl
		hire\food=ReadByte(fin)
		hire\food=ReadByte(fin)
		;;debuglog "Food:"+hire\food
		ReadByte(fin)	
		ReadByte(fin)	
		For eq=0 To 5
			hire\equiped[eq]=ReadByte(fin)		
		Next
		For eq=0 To 5
			hire\equiplus[eq]=ReadByte(fin)		
		Next
		For eq=0 To 5
			hire\equiefft[eq]=ReadByte(fin)		
		Next
	For eq=0 To 5
		For item.item=Each item
			If hire\equiped[eq]=item\id
				;;debuglog "Equiped:"+item\name$+"+"+hire\equiplus[eq]
			End If
		Next
	Next
			For eq=0 To 5
			hire\backpack[eq]=ReadByte(fin)		
		Next
		For eq=0 To 5
			hire\backplus[eq]=ReadByte(fin)		
		Next
		For eq=0 To 5
			hire\backefft[eq]=ReadByte(fin)		
		Next
	For eq=0 To 5
		For item.item=Each item
			If hire\backpack[eq]=item\id
				;;debuglog "Backpack:"+item\name$+"+"+hire\backplus[eq]
			End If
		Next
	Next
		SeekFile(fin,(((a+24)-1)*130)+80)
		temp$=Hex(ReadByte(fin))
		
		hire\skill[0]=hex2int(Mid(Right(temp$,2),1,1))
		hire\skill[1]=hex2int(Right(temp$,1))
		
				;;debuglog "OFFSET:"+FilePos(fin)
		;;debuglog "Skill 1: "+skill(hire\skill[0])
		;;debuglog "Skill 2: "+skill(hire\skill[1])
		stemp1$=Bin(ReadByte(fin))
		stemp2$=Bin(ReadByte(fin))
		stemp3$=Bin(ReadByte(fin))
		stemp4$=Bin(ReadByte(fin))
		stemp5$=Bin(ReadByte(fin))
		stemp6$=Bin(ReadByte(fin))
stemp1=Right(stemp1,8)
stemp2=Right(stemp2,8)
stemp3=Right(stemp3,8)
stemp4=Right(stemp4,8)
stemp5=Right(stemp5,8)
stemp6=Right(stemp6,8)
spl2=0
		For spl=8 To 1 Step -1
			hire\spell[spl2]=Int(Mid(stemp1,spl,1))
			spl2=spl2+1
		Next
		For spl=16 To 9 Step -1
			hire\spell[spl2]=Int(Mid(stemp2,spl-8,1))
			spl2=spl2+1
		Next
		For spl=24 To 17 Step -1
			hire\spell[spl2]=Int(Mid(stemp3,spl-16,1))
						spl2=spl2+1
		Next
		For spl=32 To 25 Step -1
			hire\spell[spl2]=Int(Mid(stemp4,spl-24,1))
						spl2=spl2+1
		Next
		For spl=40 To 33 Step -1
			hire\spell[spl2]=Int(Mid(stemp5,spl-32,1))
						spl2=spl2+1
		Next
		For spl=48 To 41 Step -1
			hire\spell[spl2]=Int(Mid(stemp6,spl-40,1))
						spl2=spl2+1
		Next
		spl2=0
		;;debuglog "Has Spells"
		as$=""
		For spl=1 To 7

		as$=as$+"1-"+Str$(spl)+"(
		as$=as$+hire\spell[spl2]+") "
		spl2=spl2+1
		Next
		;;debuglog as$
	as$=""

		For spl=1 To 7
		as$=as$+"2-"+Str$(spl)+"(
		as$=as$+hire\spell[spl2]+") "
		spl2=spl2+1
	
		Next
			;;debuglog as$	
	as$=""

		For spl=1 To 6
			as$=as$+"3-"+Str$(spl)+"(
			as$=as$+hire\spell[spl2]+") "
			spl2=spl2+1
			
				
		Next
				;;debuglog as$
	as$=""

		For spl=1 To 6
			as$=as$+"4-"+Str$(spl)+"(
			as$=as$+hire\spell[spl2]+") "
			spl2=spl2+1
			
		Next
				;;debuglog as$
	as$=""

		For spl=1 To 5
			as$=as$+"5-"+Str$(spl)+"(
			as$=as$+hire\spell[spl2]+") "
			spl2=spl2+1
			
		Next
				;;debuglog as$
	as$=""

		For spl=1 To 5
			as$=as$+"6-"+Str$(spl)+"(
			as$=as$+hire\spell[spl2]+") "
			spl2=spl2+1
			
		Next
				;;debuglog as$
	as$=""

		For spl=1 To 4
			as$=as$+"7-"+Str$(spl)+"(
			as$=as$+hire\spell[spl2]+") "
			spl2=spl2+1
		Next
				;;debuglog as$
	as$=""

		For spl=1 To 4
			as$=as$+"8-"+Str$(spl)+"(
			as$=as$+hire\spell[spl2]+") "
			spl2=spl2+1
		Next
				;;debuglog as$
	as$=""

		For spl=1 To 4
			as$=as$+"9-"+Str$(spl)+"(
			as$=as$+hire\spell[spl2]+") "
			spl2=spl2+1
		Next
				;;debuglog as$
		SeekFile(fin,(((a+24)-1)*130)+88)
		hire\SP=ReadShort(fin)
		hire\MSP=ReadShort(fin)
		temp1=ReadByte(fin)
		temp2=ReadByte(fin)
		hire\GEMS=temp1+(temp2*256)
		hire\HP=ReadShort(fin)
		hire\MHP=ReadShort(fin)
		;;debuglog "HIT POINTS "+hire\Hp+"/"+hire\MHp
		;;debuglog "SPELL POINTS "+hire\sp+"/"+hire\Msp

		temp1=ReadByte(fin)
		temp2=ReadByte(fin)
		temp3=ReadByte(fin)
		temp4=ReadByte(fin)
			hire\exper=temp1+(temp2*256)+(temp3*65536)+(temp4*16777216)
temp1=ReadByte(fin)
		temp2=ReadByte(fin)
		temp3=ReadByte(fin)
			hire\cost=temp1+(temp2*256)+(temp3*65536)

;		;;debuglog Right(Hex(temp1),2)+" "+Right(Hex(temp2),2)+" "+Right(Hex(temp3),2)+" "+Right(Hex(temp4),2)+" "
		;;debuglog "Experience:"+hire\exper
	;;debuglog "cost:"+hire\cost	
		;;debuglog "Gems:"+hire\gems
		SeekFile(fin,(((a+24)-1)*130)+121)
		hire\plus=ReadByte(fin)
		;;debuglog "Has Plus:"+Right(Bin(hire\plus),8)
		SeekFile(fin,((a+24)*130))
;	For b=0 To 107
;	temp=ReadByte(fin)
;	;;debuglog 	Chr(temp)
;	Next
	;;debuglog "End Of Hireling:"+a
	;;debuglog ""

Next




End Function

