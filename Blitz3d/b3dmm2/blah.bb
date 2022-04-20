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



Function load_item(file$)
id=0
filein=ReadFile(file$)
fo=WriteFile("items.txt")
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
;item\bonus[0]=hex2int(Mid(temp$,7,1))
;item\bonus[1]=hex2int(Right(temp$,1))
temp$=Hex(ReadByte(filein))
;item\effect[0]=hex2int(Mid(temp$,7,1))
;item\effect[1]=hex2int(Right(temp$,1))
;DebugLog "bonus: "+item\Bonus[0]+","+item\bonus[1]
;DebugLog "Effect: "+item\effect[0]+","+item\effect[1]
item\damage=ReadByte(filein)
ReadByte(filein)
item\value=ReadShort(filein)
WriteLine (fo,item\ID+": "+item\name$)
Next
Flip:SetBuffer BackBuffer():Cls
;gui_settext(sel_item,as$)
;fill_values(0)
CloseFile(filein)
End Function

