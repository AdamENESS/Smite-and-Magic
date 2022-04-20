;Function readspldesc()
df=ReadFile("spells.desc")
blah=1
Dim bob$(100)
Dim bob2$(100,5)
Repeat
b$=ReadLine(df)
Print b$
If Len(b$)=0
	blah=blah+1
Else 
	bob$(blah)=bob$(blah)+" "+b$
End If
Until Eof(df)
Print blah/2
For a=1 To 96
	DebugLog bob(a)
	DebugLog " "
Next	



