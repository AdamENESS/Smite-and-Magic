Type monster
	Field id
	Field name$
	Field HP
	Field SP
	Field AC
	Field Abils
	Field Abils2
	Field Abils3		
	Field Exper
	Field Gold
	Field MRes
	Field damage
	Field Picture
	Field Undead
	Field Archer
	Field flee
End Type
Dim tempa(8)
Dim tempb(8)
Dim tempc(8)
Dim adesc$(32)
	f=ReadFile("adesc.log")
	For a=0 To 31
		adesc$(a)=ReadLine(f)
	Next
	CloseFile(f)
	
	
fin=ReadFile("D:\Adams\Blitz3d\mm2\monsters.dat")
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
	;mon\hp=ReadByte(fin)
	temp=ReadByte(fin)
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
	mon\gold=ReadByte(fin)
	mon\damage=ReadByte(fin)
	mon\abils=ReadByte(fin)
	mon\abils2=ReadByte(fin)
	DebugLog ReadByte(fin)
	mon\picture=ReadByte(fin)
	mon\AC=ReadByte(fin)
	mon\abils3=ReadByte(fin)
	mon\SP=ReadByte(fin)
	mon\MRES=ReadByte(fin)
	

	For ab=1 To 8
	tempa(ab-1)=Mid(Right(Bin(mon\abils),8),ab,1)
	tempb(ab-1)=Mid(Right(Bin(mon\abils2),8),ab,1)
	tempc(ab-1)=Mid(Right(Bin(mon\abils3),8),ab,1)

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
	
	DebugLog mon\ID+":"
	DebugLog mon\name$+" HP:"+(mon\hp)+"("+temp+") Exp:"+mon\exper+"("+tempe+") gold:"+Mid(Right(Hex(mon\gold),2),1,1)+" Gems:"+Right(Hex(mon\gold),1)+" MAX damage: "+Mon\damage
	DebugLog "Undead: "+mon\undead+" Archer: "+mon\Archer+" Can't Run: "+mon\flee+" Picture:"+mon\picture+" AC:"+mon\ac+" SP: "+mon\sp+" MRES:"+mon\mres
	DebugLog "ability "+tempo+":"+adesc$(tempo)
	
		
Next
CloseFile(fin)
End