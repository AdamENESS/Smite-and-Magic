Type clerical
Field Level
Field Spell
Field Name$
Field Effect
Field Damage[2]
Field Cost[2]
Field Desc$[10]
Field combat
End Type

Type Sorceror
Field Level
Field Spell
Field Name$
Field Effect ; 0 is all
Field Damage[2]
Field Cost[2]
Field Desc$[10]
Field combat
End Type


create_clerical()
create_sorceror()
For cleric.clerical=Each clerical
Cls
Text 0,0, "Clerical Spell Level:"+cleric\level
Text 0,12,"Spell Number:"+cleric\spell
Text 0,24,"Name:"+cleric\name
Text 0,36,"Cost:"+cleric\cost[1]+" Gems:"+cleric\cost[2]
Select cleric\combat
	Case 0
		Text 0,48,"Non-combat"
	Case 1
		Text 0,48,"Combat"
	Case 2
		Text 0,48,"Anywhere"
	Case 3
		Text 0,48,"Combat Non hand to hand"
End Select
Text 0,60,"Description:"
Text 0,72,cleric\desc[0]
Text 0,84,cleric\desc[1]
Text 0,96,cleric\desc[2]
Text 0,108,cleric\desc[3]
Text 0,120,cleric\desc[4]
WaitKey
Next

For sorc.sorceror=Each sorceror
Cls
Text 0,0, "Sorceror Spell Level:"+sorc\level
Text 0,12,"Spell Number:"+sorc\spell
Text 0,24,"Name:"+sorc\name
Text 0,36,"Cost:"+sorc\cost[1]+" Gems:"+sorc\cost[2]
Select sorc\combat
	Case 0
		Text 0,48,"Non-combat"
	Case 1
		Text 0,48,"Combat"
	Case 2
		Text 0,48,"Anywhere"
	Case 3
		Text 0,48,"Combat Non hand to hand"
End Select
Text 0,60,"Description:"
Text 0,72,sorc\desc[0]
Text 0,84,sorc\desc[1]
Text 0,96,sorc\desc[2]
Text 0,108,sorc\desc[3]
Text 0,120,sorc\desc[4]
WaitKey
Next

;effects
;1=Damage (set cost)
;2=Damage (perlevel cost/damage)
;3=heal 
;4=heal (per level)
;5=cure posion
;6=cure disease
;7=cure all
;8=cure stone
;9=raise dead
;10=turn undead
;11=bless
;12=awaken
;13=fear
;14=light
;15=prot elements
;16=silence
;17=createfood
;18=
;19=
;20=
;21=
;22=
;23=
;24=
;25=
;26=
;27=
;28=
;29=
;30=
;31=
;32=
;33=
;34=
;35=
;36=
Function Create_clerical()
;Cleric
; level 1 spells
; Spell 1 Apparition
cleric.clerical=New clerical
cleric\level=1
cleric\Spell=1
cleric\effect=10 
cleric\cost[1]=1
cleric\cost[2]=0
cleric\combat=1
cleric\name$="Apparition"
cleric\desc$[0]="Creates a Frightening Apparition"
cleric\desc$[1]="in the monsters memory causing"
cleric\desc$[2]="them To be afriad. 
cleric\desc$[3]="Reducing their chance To hit."
;1-2
cleric.clerical=New clerical
cleric\level=1
cleric\Spell=2
cleric\effect=0
cleric\cost[1]=1
cleric\cost[2]=0
cleric\combat=2
cleric\name$="Awaken"
cleric\desc$[0]="Awakens all Sleeping Party"
cleric\desc$[1]="Memebers, instantaneously"
cleric\desc$[2]="Cancelling the Sleep Condidtion"
cleric\desc$[3]="May be critical if the party"
cleric\desc$[4]="is attacked during rest."
;1-3
cleric.clerical=New clerical
cleric\level=1
cleric\Spell=4
cleric\effect=0 
cleric\cost[1]=1
cleric\cost[2]=0
cleric\combat=1
cleric\name$="Bless"
cleric\desc$[0]="Increases the accuracy with which "
cleric\desc$[1]="all characters fight, For the"
cleric\desc$[2]="duration of combat. 


cleric.clerical=New clerical
cleric\level=1
cleric\Spell=4
cleric\effect=1 
cleric\cost[1]=1
cleric\cost[2]=0
cleric\damage[1]=8
cleric\damage[2]=8
cleric\combat=2
cleric\name$="First Aid"
cleric\desc$[0]="Heals minor battle wounds,
cleric\desc$[1]="restoring 8 Hit Points To that"
cleric\desc$[2]="character."


cleric.clerical=New clerical
cleric\level=1
cleric\Spell=5
cleric\effect=0
cleric\combat=0 
cleric\cost[1]=1
cleric\cost[2]=0
cleric\name$="Light"
cleric\desc$[0]="Gives the party 1 light factor,
cleric\desc$[1]="which is sufficient to light up"
cleric\desc$[2]="1 dark area. Multiple light spells" 
cleric\desc$[3]="can be cast To accumulate"
cleric\desc$[4]="multiple light factors"

cleric.clerical=New clerical
cleric\level=1
cleric\Spell=6
cleric\effect=1
cleric\cost[1]=1
cleric\cost[2]=1
cleric\combat=2
cleric\damage[1]=1
cleric\damage[1]=10
cleric\name$="Power Cure"
cleric\desc$[0]="Restores character's health"
cleric\desc$[1]="and 1-10 Hit Points per"
cleric\desc$[2]="experience level of caster"



cleric.clerical=New clerical
cleric\level=1
cleric\Spell=7
cleric\effect=0 ; must be undead 
cleric\cost[1]=1
cleric\cost[2]=0
cleric\combat=1
cleric\name$="Turn Undead"
cleric\desc$[0]="Destroys some or all undead monsters,
 
cleric\desc$[1]="depending on caster's experience"
cleric\desc$[2]="evel and monster's power level."

;SPELL LEVEL 2
cleric.clerical=New clerical
cleric\level=2
cleric\Spell=1
cleric\effect=1
cleric\cost[1]=2
cleric\cost[2]=0
cleric\damage[1]=15
cleric\damage[2]=15
cleric\combat=2
cleric\name$="Cure Wounds
cleric\desc$[0]="Cures more serious wounds, restoring"
cleric\desc$[1]="15 Hit Points to the character."

cleric.clerical=New clerical
cleric\level=2
cleric\Spell=2
cleric\effect=1 ; must be undead 
cleric\cost[1]=2
cleric\cost[2]=1
cleric\damage[1]=6
cleric\damage[2]=6
cleric\name$="Heroism"
cleric\desc$[0]="Temporarily elevates a character 6 levels"
cleric\desc$[1]="of experience."
cleric\desc$[2]="Spell lasts for the duration of combat."
cleric\combat=1

cleric.clerical=New clerical
cleric\level=2
cleric\Spell=3
cleric\effect=0 ; must be undead 
cleric\cost[1]=2
cleric\cost[2]=0
cleric\name$="Natures Gate"
cleric\desc$[0]="Using the forces of nature, opens"
cleric\desc$[1]="a portal between two locations"
cleric\desc$[2]="in the land of Cron. These locations" 
cleric\desc$[3]="vary with time (days/years)."
cleric\combat=0



cleric.clerical=New clerical
cleric\level=2
cleric\Spell=4
cleric\effect=0 ; must be undead 
cleric\cost[1]=2
cleric\cost[2]=0
cleric\damage[1]=2
cleric\damage[2]=16
cleric\name$="Pain"
cleric\desc$[0]="Cripples monster with pain,"
cleric\desc$[1]="inflicting 2-16 damage points"
cleric\desc$[2]="unless the monster is immune to pain." 
cleric\combat=1

cleric.clerical=New clerical
cleric\level=2
cleric\Spell=5
cleric\effect=0 ; must be undead 
cleric\cost[1]=2
cleric\cost[2]=1
cleric\name$="Protection from Elements"
cleric\desc$[0]=" Increases all character's resistance to "
cleric\desc$[1]="fear, cold, fire, poison, acid and 
cleric\desc$[2]="and electricity. Amount of the increase 
cleric\desc$[3]="depends on the caster's experience level."
cleric\desc$[4]="Spell lasts 1 day."
cleric\combat=2

cleric.clerical=New clerical
cleric\level=2
cleric\Spell=6
cleric\effect=4 ; plus 1 per level
cleric\cost[1]=2
cleric\cost[2]=0
cleric\name$="Silence"
cleric\desc$[0]="Attacks with a ray of intensive cold
cleric\desc$[1]="for the duration of combat,"
cleric\desc$[2]="or until they overcome the spell.
cleric\combat=2

cleric.clerical=New clerical
cleric\level=2
cleric\Spell=7
cleric\effect=10
cleric\cost[1]=2
cleric\cost[2]=1
cleric\name$="Weaken"
cleric\desc$[0]="Weakens all monsters affected,"
cleric\desc$[1]="reducing their physical damage"
cleric\desc$[2]=" by half until the spell is overcome."
cleric\combat=2

;spell level 3
cleric.clerical=New clerical
cleric\level=3
cleric\Spell=1
cleric\effect=5 ; must be undead 
cleric\cost[1]=3
cleric\cost[2]=2
cleric\damage[1]=25
cleric\damage[2]=25
cleric\name$="Cold Ray"
cleric\desc$[0]="Creates a Frightening Apparition"
cleric\desc$[1]="in the monsters memory causing"
cleric\desc$[2]="them To be afried. 
cleric\desc$[3]="Reducing their chance To hit."
cleric\combat=1


cleric.clerical=New clerical
cleric\level=3
cleric\Spell=2
cleric\effect=0 ; must be undead 
cleric\cost[1]=3
cleric\cost[2]=2
cleric\damage[1]=8
cleric\damage[2]=8
cleric\name$="Create Food"
cleric\desc$[0]="Creates a Frightening Apparition"
cleric\desc$[1]="in the monsters memory causing"
cleric\desc$[2]="them To be afried. 
cleric\desc$[3]="Reducing their chance To hit."
cleric\combat=2

cleric.clerical=New clerical
cleric\level=3
cleric\Spell=3
cleric\effect=0 ; must be undead 
cleric\cost[1]=3
cleric\cost[2]=0
cleric\name$="Cure Poison"
cleric\desc$[0]="Creates a Frightening Apparition"
cleric\desc$[1]="in the monsters memory causing"
cleric\desc$[2]="them To be afried. 
cleric\desc$[3]="Reducing their chance To hit."
cleric\combat=2

cleric.clerical=New clerical
cleric\level=3
cleric\Spell=4
cleric\effect=5 ; must be undead 
cleric\cost[1]=3
cleric\cost[2]=0
cleric\name$="Immobilize"
cleric\desc$[0]="Creates a Frightening Apparition"
cleric\desc$[1]="in the monsters memory causing"
cleric\desc$[2]="them To be afried. 
cleric\desc$[3]="Reducing their chance To hit."
cleric\combat=1

cleric.clerical=New clerical
cleric\level=3
cleric\Spell=5
cleric\effect=0 ; must be undead 
cleric\cost[1]=3
cleric\cost[2]=0
cleric\name$="Lasting Light"
cleric\desc$[0]="Creates a Frightening Apparition"
cleric\desc$[1]="in the monsters memory causing"
cleric\desc$[2]="them To be afried. 
cleric\desc$[3]="Reducing their chance To hit."
cleric\combat=2

cleric.clerical=New clerical
cleric\level=3
cleric\Spell=6
cleric\effect=0 ; must be undead 
cleric\cost[1]=3
cleric\cost[2]=2
cleric\name$="Walk on Water"
cleric\desc$[0]="Creates a Frightening Apparition"
cleric\desc$[1]="in the monsters memory causing"
cleric\desc$[2]="them To be afried. 
cleric\desc$[3]="Reducing their chance To hit."
cleric\combat=0

End Function

Function create_sorceror()
;sorc
; level 1 spells
; Spell 1 Apparition
sorc.sorceror=New sorceror
sorc\level=1
sorc\Spell=1
sorc\effect=10 
sorc\cost[1]=1
sorc\cost[2]=0
sorc\combat=2
sorc\name$="Awaken"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."
;1-2
sorc.sorceror=New sorceror
sorc\level=1
sorc\Spell=2
sorc\effect=0
sorc\cost[1]=1
sorc\cost[2]=0
sorc\combat=0
sorc\name$="Detect Magic"
sorc\desc$[0]="Awakens all Sleeping Party"
sorc\desc$[1]="Memebers, instantaneously"
sorc\desc$[2]="Cancelling the Sleep Condidtion"
sorc\desc$[3]="May be critical if the party"
sorc\desc$[4]="is attacked during rest."
;1-3
sorc.sorceror=New sorceror
sorc\level=1
sorc\Spell=4
sorc\effect=1
sorc\cost[1]=1
sorc\cost[2]=1
sorc\damage[1]=1
sorc\damage[2]=6
sorc\combat=1
sorc\name$="Energy Blast"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."

sorc.sorceror=New sorceror
sorc\level=1
sorc\Spell=4
sorc\effect=1 
sorc\cost[1]=1
sorc\cost[2]=0
sorc\damage[1]=2
sorc\damage[2]=8
sorc\combat=1
sorc\name$="Flame Arrow"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."

sorc.sorceror=New sorceror
sorc\level=1
sorc\Spell=5
sorc\effect=0
sorc\combat=0 
sorc\cost[1]=1
sorc\cost[2]=0
sorc\name$="Light"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."

sorc.sorceror=New sorceror
sorc\level=1
sorc\Spell=6
sorc\effect=1
sorc\cost[1]=1
sorc\cost[2]=0
sorc\combat=0
sorc\damage[1]=1
sorc\damage[1]=10
sorc\name$="Location"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."

sorc.sorceror=New sorceror
sorc\level=1
sorc\Spell=7
sorc\effect=4
sorc\cost[1]=1
sorc\cost[2]=0
sorc\combat=1
sorc\name$="Sleep"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."
;SPELL LEVEL 2
sorc.sorceror=New sorceror
sorc\level=2
sorc\Spell=1
sorc\effect=1
sorc\cost[1]=2
sorc\cost[2]=0
sorc\damage[1]=5
sorc\damage[2]=5
sorc\combat=0
sorc\name$="Eagle Eye"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."

sorc.sorceror=New sorceror
sorc\level=2
sorc\Spell=2
sorc\effect=1 ; must be undead 
sorc\cost[1]=2
sorc\cost[2]=0
sorc\damage[1]=4
sorc\damage[2]=16
sorc\name$="Electric Arrow"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."
sorc\combat=1

sorc.sorceror=New sorceror
sorc\level=2
sorc\Spell=3
sorc\effect=1 ; must be undead 
sorc\cost[1]=2
sorc\cost[2]=1
sorc\name$="Identerfy Monster"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."
sorc\combat=1

sorc.sorceror=New sorceror
sorc\level=2
sorc\Spell=4
sorc\effect=0 ; must be undead 
sorc\cost[1]=2
sorc\cost[2]=1
sorc\name$="Jump"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."
sorc\combat=0

sorc.sorceror=New sorceror
sorc\level=2
sorc\Spell=5
sorc\effect=0 ; must be undead 
sorc\cost[1]=2
sorc\cost[2]=0
sorc\damage[1]=2
sorc\damage[2]=16
sorc\name$="Levitate"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."
sorc\combat=1

sorc.sorceror=New sorceror
sorc\level=2
sorc\Spell=6
sorc\effect=4 ; plus 1 per level
sorc\cost[1]=2
sorc\cost[2]=0
sorc\name$="Lloyd's Beacon"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."
sorc\combat=2

sorc.sorceror=New sorceror
sorc\level=2
sorc\Spell=7
sorc\effect=10
sorc\cost[1]=1
sorc\cost[2]=1
sorc\name$="Protection from Magic"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."
sorc\combat=2

;spell level 3
sorc.sorceror=New sorceror
sorc\level=3
sorc\Spell=1
sorc\effect=1 ; must be undead 
sorc\cost[1]=1
sorc\cost[2]=2
sorc\damage[1]=2
sorc\damage[2]=8
sorc\name$="Acid Stream"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."
sorc\combat=1


sorc.sorceror=New sorceror
sorc\level=3
sorc\Spell=2
sorc\effect=0 ; must be undead 
sorc\cost[1]=3
sorc\cost[2]=0
sorc\damage[1]=8
sorc\damage[2]=8
sorc\name$="Fly"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."
sorc\combat=0

sorc.sorceror=New sorceror
sorc\level=3
sorc\Spell=3
sorc\effect=0 ; must be undead 
sorc\cost[1]=3
sorc\cost[2]=0
sorc\name$="Invisiblility"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."
sorc\combat=1

sorc.sorceror=New sorceror
sorc\level=3
sorc\Spell=4
sorc\effect=4 ; must be undead 
sorc\cost[1]=1
sorc\cost[2]=2
sorc\name$="Lightning Bolt"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."
sorc\combat=1

sorc.sorceror=New sorceror
sorc\level=3
sorc\Spell=5
sorc\effect=4 ; must be undead 
sorc\cost[1]=3
sorc\cost[2]=2
sorc\name$="Web"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."
sorc\combat=3

sorc.sorceror=New sorceror
sorc\level=3
sorc\Spell=6
sorc\effect=0 ; must be undead 
sorc\cost[1]=3
sorc\cost[2]=2
sorc\name$="Wizards Eye"
sorc\desc$[0]="Creates a Frightening Apparition"
sorc\desc$[1]="in the monsters memory causing"
sorc\desc$[2]="them To be afried. 
sorc\desc$[3]="Reducing their chance To hit."
sorc\combat=0


End Function