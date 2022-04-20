;Event identifiers: 

Const Event_Key_down = $101
; Generated when the user presses a key. EventData contains the 'raw scancode' of the key. 

Const Event_Key_up = $102
;Generated when the user releases a key. EventData contains the 'raw scancode' of the key. 

Const Event_Key_stroke = $103 
;Generated when the user presses a key Or when a keystroke is automatically generated due To keyboard Repeat. EventData contains the ascii code of the key. 

Const Event_Mouse_down =$201
;Generated when the user presses a mouse button While the mouse is positioned over a canvas gadget. EventData contains the button being pressed: 1 For the Left button, 2 For the Right button Or 3 For the middle button. EventSource contains the canvas gadget Handle. 

Const Event_Mouse_up = $202
;Generated when the user releases a mouse button While the mouse is positioned over a canvas gadget. EventData contains the button be release: 1 For the Left button, 2 For the Right button Or 3 For the middle button. EventSource contains the canvas gadget Handle. 

Const Event_Mouse_move =$203
;Generated when the user moves the mouse While it is positioned over a canvas gadget. EventX And EventY contain the New mouse coordinates, And EventSource contains the canvas gadget Handle. 

Const Event_Mouse_wheel =$204
;Generated when the user spins the mouse wheel. EventData contains the number of 'clicks' the wheel has been spun. 

Const Event_Gadget_action = $401
;Generated when the user changes the state of a gadget. This can Include such actions as pressing a button, Or typing into a textfield. EventSource contains the Handle of the gadget that caused the event. 

Const Event_Window_move = $801
;Generated when the user moves a window. EventSource contains the Handle of the window gadget that has moved, And EventX And EventY contain the New location of the window. 

Const Event_Window_size = $802
;Generated when the user sizes a window. EventSource contains the Handle of the window gadget that has sized, And EventX And EventY contain the New size of the window. 

Const Event_Window_close = $803
;Generated when the user clicks a window's 'close' box. It is up To the program To actually close the window (see FreeGadget). 

Const Event_Window_activate = $804
;Generated when the user activates a window. EventSource contains the Handle of the window gadget that was activated. 

Const Event_Menu_event = $1001
;Generated when the user selects a menu. EventData contains the integer identifier of the menu selected. 

Const Event_App_suspend = $2001
;Generated when the user switches To another application. 

Const Event_App_resume = $2002
;Generated when the user switches back To your application. 

Const Event_Timer_tick = $4001
;Generated when a custom timer ticks over (see Timers). EventSource contains the Handle of the timer, And EventData contains the total number of timer ticks that have occurred.  