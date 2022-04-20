;experemental file matrix
Dim lkjhgfdsa(100)
Global asdfghjkl=0


Type file
Field name$
Field namelength
Field size
Field offset
Field fData
Field temp
End Type

Global fpos,files
Global mf
writedata()
Function writedata()
mf=WriteFile("data.mpf")
addfile("data\attrib.dat")
addfile("data\event.dat")
addfile("data\items.dat")
addfile("data\map.dat")
addfile("data\monsters.dat")
encrypt
writeheader()
writetoc()
writefiles()
End Function 
Function writeheader()
WriteByte(mf,1+Asc("M"))
WriteByte(mf,2+Asc("M"))
WriteByte(mf,3+Asc("2"))
WriteByte(mf,1+Asc("W"))
WriteByte(mf,2+Asc("A"))
WriteByte(mf,3+Asc("D"))
WriteInt(mf,1)
End Function

Function readheader()
ch$=Chr(-1+ReadByte(mf))
ch$=ch+Chr(-2+ReadByte(mf))
ch$=ch+Chr(-3+ReadByte(mf))
ch$=ch+Chr(-1+ReadByte(mf))
ch$=ch+Chr(-2+ReadByte(mf))
ch$=ch+Chr(-3+ReadByte(mf))
;debuglog ch
ver=ReadInt(mf)
End Function



Function Writetoc()
WriteInt(mf,files)

For f.file=Each file
	mWriteString(f\name$)
	WriteInt(mf,f\size)
	f\temp=FilePos(mf)
	;debuglog f\temp
	WriteInt(mf,offset)
Next
dfdf=FilePos(mf)
For f.file=Each file
;debuglog dfdf
f\offset=dfdf
	SeekFile mf,f\temp
	;debuglog FilePos(mf)
	WriteInt mf,(f\offset)
	dfdf=dfdf+f\size
Next

End Function

Function readtoc()
times=ReadInt(mf)
;debuglog times
;WaitKey
For a=1 To times
f.file=New file
	f\name$=mreadString()
	f\size=ReadInt(mf)
	;f\temp=FilePos(mf)
	f\offset=ReadInt(mf)
	;debuglog f\name$+" "+f\size+" "+f\offset
;	WriteInt(mf,offset)
	Next
End Function

Function encrypt()
For f.file=Each file

nl=Len(f\name)
nl2=0
For a=0 To BankSize(f\fdata)-1
f\temp=PeekByte(f\fData,a)
f\temp=f\temp+nl2
nl2=nl2+1
If nl2>nl nl2=0
PokeByte(f\fData,a,f\temp)
Next
Next
End Function

Function decrypt()
For f.file=Each file

nl=Len(f\name)
nl2=0
For a=0 To BankSize(f\fdata)-1
f\temp=PeekByte(f\fData,a)
f\temp=f\temp-nl2
nl2=nl2+1
If nl2>nl nl2=0
PokeByte(f\fData,a,f\temp)
Next
Next
End Function
Function getfile(name$,dfile$)
mf=OpenFile(dfile)
readheader
readtoc
For f.file=Each file
	If f\name=name$
		SeekFile(mf,f\offset)
		f\fdata=CreateBank(f\size)
		ReadBytes(f\fdata,mf,0,f\size)
		bank=f\fdata
		nl=Len(f\name)
nl2=0
For a=0 To BankSize(f\fdata)-1
f\temp=PeekByte(f\fData,a)
f\temp=f\temp-nl2
nl2=nl2+1
If nl2>nl nl2=0
PokeByte(f\fData,a,f\temp)
Next

		; print bank
	EndIf
Next
;decrypt()
For f.file=Each file
	Delete f
Next
CloseFile mf
Return bank
End Function

Function WriteFiles()
For f.file=Each file
SeekFile mf,f\offset
WriteBytes(f\fdata,mf,0,f\size)
Next

End Function
Function addfile(filename$)
f.file=New file
f\name=filename$
f\namelength=Len(f\name)
f\size=FileSize(filename$)
f\fdata=CreateBank(f\size)
;debuglog files+" "+f\name+" "+f\size
temp=OpenFile(f\name$)
ReadBytes(f\fdata,temp,0,f\size)
files=files+1
CloseFile temp
End Function


Function pushfile(file,offy=-1)
	lkjhgfdsa(asdfghjkl)=FilePos(file)
	asdfghjkl=asdfghjkl+1
	If offy>-1 SeekFile(file,offy)
End Function

Function popfile(file)
	asdfghjkl=asdfghjkl-1
	SeekFile(file,lkjhgfdsa(asdfghjkl))
End Function

Function mwritestring(s$)
WriteShort(mf,Len(s$))
For a=1 To Len(s$)
WriteByte mf,Asc(Mid(s,a,1))
Next
End Function

Function mreadstring$()
length=ReadShort(mf)
ch$=""
For a=1 To length
ch$=ch$+Chr(ReadByte(mf))
Next
Return ch$
End Function