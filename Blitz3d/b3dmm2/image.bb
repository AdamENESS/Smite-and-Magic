Graphics 800,600 ;Sets graphics mode
SetBuffer BackBuffer() ;Sets buffer to the back buffer
r1=LoadImage("battle.jpg") ;Loads your rectangle
Sx#=GraphicsWidth() ; needs to be done or the scalex and sclaey values will equal 1
Sy#=GraphicsHeight() ; needs to be done or the scalex and sclaey values will equal 1
scaleX#=sx/ImageWidth(r1) ; gets the difference in screen width and the image
scaleY#=sy/ImageHeight(r1) ; gets the difference in screen height and the image
;Sets the co-ordinates of the rectangle
r1_x=0
r1_y=0
ScaleImage r1,scalex#,scaley# ; scales the image
While Not KeyDown (1) ;While the esc key isn't being pressed
Cls ;Clear the screen
DrawImage r1,r1_x,r1_y ;Draw the rectangle
Flip ;Flip buffers
Wend ;Goes back to While
End ;Easier to put instead of an If..Then statement
