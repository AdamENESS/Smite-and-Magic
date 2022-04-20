; character.bp for mm2
; there are 48 charaters 24 are hirelings, there are 6 defaults and 18 blank (ie can be made by the player)
Type character
Field Hireling
Field ID
Field town
Field Name$
Field sex,Race,Class,Allignment[2]
Field HP[2],SP[2],SpellLevel,Age[2]
Field Might[2],Intellect[2],Personallity[2],Endurance[2],Speed[2],Accuracy[2],Luck[2],Level[2]
Field AC,Gold,Gems,Food,Experience,condition,Thievery
Field Skills[2],plus,spell[48]
Field Backpack[6],Equiped[6]
Field Backplus[6],Equiplus[6]
Field Backmisc[6],Equimisc[6]
End Type

Type party
Field Hireling
Field ID
Field town
Field Name$
Field sex,Race,Class,Allignment[2]
Field HP[2],SP[2],SpellLevel,Age[2]
Field Might[2],Intellect[2],Personallity[2],Endurance[2],Speed[2],Accuracy[2],Luck[2],Level[2]
Field AC,Gold,Gems,Food,Experience,condition,Thievery
Field Skills[2],plus,spell[48]
Field Backpack[6],Equiped[6]
Field Backplus[6],Equiplus[6]
Field Backmisc[6],Equimisc[6]

End Type

Function addparty(chid)
For c.character = Each character
If c\id=chid
Return 
End If
Next

End Function
Function loadroster()
roster=OpenFile("roster.dat")

For a=1 To 48
	char.character=New character
	If a<25
	char\hireling=0
	Else 
	char\hireling=1

	EndIf
	;debuglog "character:"+a
	char\ID=a
	For c=0 To 9
		ch$=Chr(ReadByte(roster))
		char\name$=char\name$+ch
	Next
	ReadByte(roster)
	char\town=ReadByte(roster)
	char\sex=ReadByte(roster)
	char\allignment[1]=ReadByte(roster)
	char\allignment[0]=char\allignment[1]
	char\race=ReadByte(roster)
	char\class=ReadByte(roster)
	char\Might[1]=ReadByte(roster)	
	char\intellect[1]=ReadByte(roster)	
	char\PERsonallity[1]=ReadByte(roster)
	crloc=FilePos(roster)
	SeekFile(roster,(((a-1)*130)+39))
	char\Endurance[1]=ReadByte(roster)	
	SeekFile(roster,crloc)	
	char\Speed[1]=ReadByte(roster)	
	char\ACCuracy[1]=ReadByte(roster)	
	char\LuCK[1]=ReadByte(roster)	
	DebugLog "NAME:"+char\name	
	SeekFile(roster,(((a-1)*130)+30))
	char\thievery=ReadByte(roster)
		;debuglog "Thievery: "+char\thv
		char\level[0]=ReadByte(roster)
		char\level[1]=ReadByte(roster)
		;debuglog "Level: "+char\lvl
		char\age[1]=ReadByte(roster)
		;debuglog "Age: "+char\age
		char\age[0]=ReadByte(roster)
		;debuglog "Days old: "+char\day
		char\sPellLeVeL=ReadByte(roster)
		;debuglog "Spell Level:"+char\splvl
		char\food=ReadByte(roster)
		char\food=ReadByte(roster)
		ReadByte(roster)	
		ReadByte(roster)	
		For eq=0 To 5
			char\equiped[eq]=ReadByte(roster)		
		Next
		For eq=0 To 5
			char\equiplus[eq]=ReadByte(roster)		
		Next
		For eq=0 To 5
			char\equimisc[eq]=ReadByte(roster)		
		Next
		For eq=0 To 5
			char\backpack[eq]=ReadByte(roster)		
		Next
		For eq=0 To 5
			char\backplus[eq]=ReadByte(roster)		
		Next
		For eq=0 To 5
			char\backmisc[eq]=ReadByte(roster)		
		Next
		SeekFile(roster,((a-1)*130)+80)
		temp$=Hex(ReadByte(roster))
		char\skills[0]=hex2int(Mid(Right(temp$,2),1,1))
		char\skills[1]=hex2int(Right(temp$,1))
		stemp1$=Bin(ReadByte(roster))
		stemp2$=Bin(ReadByte(roster))
		stemp3$=Bin(ReadByte(roster))
		stemp4$=Bin(ReadByte(roster))
		stemp5$=Bin(ReadByte(roster))
		stemp6$=Bin(ReadByte(roster))
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
		SeekFile(roster,((a-1)*130)+88)
		char\SP[0]=ReadShort(roster)
		char\SP[1]=ReadShort(roster)
		temp1=ReadByte(roster)
		temp2=ReadByte(roster)
		char\GEMS=temp1+(temp2*256)
		char\HP[0]=ReadShort(roster)
		char\HP[1]=ReadShort(roster)
		DebugLog "HIT POINTS "+char\Hp[0]+"/"+char\Hp[1]
		DebugLog "SPELL POINTS "+char\sp[0]+"/"+char\sp[1]

		temp1=ReadByte(roster)
		temp2=ReadByte(roster)
		temp3=ReadByte(roster)
		temp4=ReadByte(roster)
		char\experience=temp1+(temp2*256)+(temp3*65536)+(temp4*16777216)
		temp1=ReadByte(roster)
		temp2=ReadByte(roster)
		temp3=ReadByte(roster)
		char\GOLD=temp1+(temp2*256)+(temp3*65536)

		DebugLog "Experience:"+char\experience
		DebugLog "Gold:"+char\gold		
		DebugLog "Gems:"+char\gems
		SeekFile(roster,((a-1)*130)+121)
		char\plus=ReadByte(roster)
		DebugLog "Has Plus:"+Right(Bin(char\plus),8)
		SeekFile(roster,((a)*130))
Next

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