				If Int(Floor(-(camera\Pz/1.50)))<0	
					camera\PZ=lastPZ
					camera\VZ=lastVZ

				EndIf
				If Int(Floor(camera\PX/1.50))<0 
					camera\px=lastPX
					camera\Vx=lastVX					
				EndIf
				If Int(Floor(-(camera\Pz/1.50)))>15
					camera\PZ=lastPZ
					camera\VZ=lastVZ

				EndIf
				If Int(Floor(camera\PX/1.50))>15
					camera\px=lastPX
					camera\Vx=lastVX					
				EndIf
