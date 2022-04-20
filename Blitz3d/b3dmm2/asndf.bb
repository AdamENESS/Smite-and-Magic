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
Dim partydec$(34)
Dim ent_battle(9)
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
fin=ReadFile("monsters.dat")
;fileout=WriteFile("monsters(special).log")
;For a=0 To 255
;Print a
;WriteLine(fileout,"{")
;WriteLine(fileout,"	monster"+A)
;name$=""
;For n=0 To 13
	;c$=Chr((ReadByte(fin)+20))
	;DebugLog c$
;	temp=ReadByte(fin)
;	ch$=Chr(temp-128)
;	name$=name$+ch$
;	Next 
;riteLine(fileout,"	name:"+name$)

;For b=0 To 11
;temp=ReadByte(fin)
;If b=3 And temp>0
;WriteLine(fileout,"{")
;WriteLine(fileout,"	monster"+A)
;WriteLine(fileout,"	name:"+name$)
;WriteLine(fileout,"	"+b+": "+Right(Bin(temp),8)+","+Right(Hex(temp),2)+","+Chr(temp))
;WriteLine(fileout,"}")

;EndIf
;Next

;Next
;End

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
	
	If Mid(Right(Hex(mon\pabil),2),1,1)>0
	DebugLog mon\ID+":"
	DebugLog mon\name$+" HP:"+(mon\hp)+"("+temp+") Exp:"+mon\exper+"("+tempe+") gold:"+Mid(Right(Hex(mon\gold),2),1,1)+" Gems:"+Right(Hex(mon\gold),1)+" MAX damage: "+Mon\damage
	DebugLog "Undead: "+mon\undead+" Archer: "+mon\Archer+" Can't Run: "+mon\flee+" Picture:"+mon\picture+" AC:"+mon\ac+" SP: "+mon\sp+" MRES:"+mon\mres
	DebugLog "single ability "+mon\abil1+":"+adesc$(mon\abil1)
	
		DebugLog "Party  ability "+mon\abil2+":"+partydec$(mon\abil2)
	EndIf
	mon\Colour=clr
	clr=clr+1
	If clr=3
	clr=0
	EndIf
		
Next
CloseFile(fin)



;attrib2
;information
;bit 4=0
; 0=Spray Poison
; 1=Spray Acid
; 2=Curses (opisite of bless)
; 3=breaths Fire
; 4=breaths Lightning
; 5=breaths Frost
; 6=breaths Energy
; 7=breaths gas
; 8=breaths Acid
; 9=Explodes
; a=Gazes (stones)
; b=Drains magic (effects all)
; c=Drains Spell Level
; d=Vaporise Valubles
; e=Juggle Party
; f=cast Energy blast

;bit 4=1
; 0=Sleep
; 1=lightning boltz
; 2 Fireballs
; 3=fingers of death
; 4=Disintergrate
; 5=Super shock
; 6=Dancing Sword
; 7=incinerate
; 8=Invokes power (50%) of life as damage,
; 9=Implosion 500 or 1000 damage
; a=Inferno
; b=Pain
; c=Silence
; d=Frenzy
; e=Paralyze
; f=Swarms

;
;
;
;
;
;