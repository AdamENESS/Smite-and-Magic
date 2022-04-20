fi=OpenFile("34.anm")
fo=WriteFile("anim.log")
Repeat 
temp=ReadByte(fi)
WriteLine fo,temp +" "+Right(Hex(temp),2)+" "+Chr(temp)
Until Eof(fi)
