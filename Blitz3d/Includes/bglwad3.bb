;  Half Life Wad3 format reader for blitzGL.
; version 0.1
Global fileout=WriteFile("wad3.Log")

Global wad3_file
;Global fs=FileSize("../bspmaps/overlord.wad")

;DebugLog readwad3("../bspmaps/overlord.wad","c0wgrass")

Function readwad3(file$,Textu$)
	;DebugLog textu
	;If FileType(file$)=1
	wad3_file=OpenFile(file$)
	fs=FileSize(file$)
	file2=""
	timer=CreateTimer(1000)
	Local pala[256],palb[256],palc[256]
	Local header$=wad3readstring(4)
	If header<>"WAD3"
	Return 0
	EndIf
	lumps=wad3ReadInt()
	offset=wad3ReadInt()
	db "NO. Lumps:"+lumps+" OFFSET:"+offset
	cpos=FilePos(wad3_file)
	SeekFile(wad3_file,offset)
	For a=0 To lumps-1
	;WaitEvent()
	;if EventID()=$803 End; And EventSource()=winmain End
	cc=Int(FilePos(wad3_file))
	fis=fs
	per#=(cc/100.)/(fs/100.)

	db "Lump "+a
	offset=wad3ReadInt()
	db "OFFSET "+offset

	db "DISKSIZE "+wad3ReadInt()
	db "SIZE "+wad3ReadInt()	
	typ=wad3Readbyte()
	db "TYPE "+typ
	db "COMPRESED "+wad3Readbyte()
	db "PADDING"+wad3Readshort()
	tname$=wad3ReadString(16)
	db "NAME:"+ tname$
	cpos2=FilePos(wad3_file)
	Db tname$+" TYPE:"+typ
	;If Typ=67 And tname$=textu$
	If Lower(tname$)=Lower(textu)
;	DebugLog 
	SeekFile(wad3_file,offset)
	per#=(FilePos(wad3_file)/100.)/(fs/100.)
;DebugLog Int(FilePos(wad3_file))+" "+fs+" "+per
	;UpdateProgBar(bob,per)
	db "TEXTURE INFO"
	fname$=wad3readstring(16)
	width=wad3ReadInt()
	height=wad3ReadInt()
	Local toffset[4]
	Local image[4]
	db fname$+" "+width+" "+height
	For l=0 To 3
	toffset[l]=wad3readint()
	db "offset "+l+" "+toffset[l]
	Next
;	For l=0 To 3
	pos3=FilePos(wad3_file)
				For x=0 To height-1
					For y=0 To width-1
						col=wad3ReadByte()
					Next
				Next
				
	;		SaveImage(image[0],fname$+".bmp")
				For x=0 To (height/2)-1
					For y=0 To (width/2)-1
						col=wad3ReadByte()
	;					Color col,col,col
	;					Plot y,x
					Next
				Next
				
				For x=0 To (height/4)-1
					For y=0 To (width/4)-1
						col=wad3ReadByte()
	;					Color col,col,col
	;					Plot y,x
					Next
				Next
				
				For x=0 To (height/8)-1
					For y=0 To (width/8)-1
						col=wad3ReadByte()
	;					Color col,col,col
	;					Plot y,x
					Next
				Next
				
	pallsize=wad3Readshort()
	db "PALette size:"+pallsize
	For s=0 To pallsize-1
		pala[s]=wad3ReadByte()
		palb[s]=wad3ReadByte()
		palc[s]=wad3ReadByte()		
	Next 
	SeekFile(wad3_File,pos3)	
		image[0]=CreateImage(width,height)
				SetBuffer ImageBuffer(image[0])
				For x=0 To height-1
					For y=0 To width-1
						col=wad3ReadByte()
						Color pala[col],palb[col],palc[col]
						Plot y,x
					Next
				Next
				
;	SaveImage(image[0],"textures/"+fname$+".bmp")
	SaveImage(image[0],fname$+".bmp")
	Return 1
	;SetStatusText(winmain,"image:"+fname)
	EndIf
	SeekFile(wad3_File,cpos2)
	Next
;	EndIf
	Return 0
End Function

Function wad3Readbyte()
	Return ReadByte( wad3_file )
End Function

Function wad3ReadInt()
	Return ReadInt( wad3_file )
End Function

Function wad3ReadFloat#()
	Return ReadFloat( wad3_file )
End Function

Function wad3ReadString$(leng)

ch$=""
For l=1 To leng
dta=ReadByte(wad3_file)
If dta=0 And done=0

ch2$=ch$;+" "
done=1
Else If done=1

Else
ch$=ch$+Chr(dta)
EndIf
Next
Return ch$
End Function

Function wad3readshort()
Return ReadShort(wad3_file)
End Function
Function wad3ReadSShort()
t=wad3ReadShort()
		If t>32767
		 r=t-65535
		Else
		r=t
		EndIf
		Return R
End Function



Function db(s$)
;DebugLog s$
;WriteLine(fileout,s$)
End Function