Const R2_BLACK            =1   ;  0       */
Const R2_NOTMERGEPEN      =2   ; DPon     */
Const R2_MASKNOTPEN       =3   ; DPna     */
Const R2_NOTCOPYPEN       =4   ; PN       */
Const R2_MASKPENNOT       =5   ; PDna     */
Const R2_NOT              =6   ; Dn       */
Const R2_XORPEN           =7   ; DPx      */
Const R2_NOTMASKPEN       =8   ; DPan     */
Const R2_MASKPEN          =9   ; DPa      */
Const R2_NOTXORPEN        =10  ; DPxn     */
Const R2_NOP              =11  ; D        */
Const R2_MERGENOTPEN      =12  ; DPno     */
Const R2_COPYPEN          =13  ; P        */
Const R2_MERGEPENNOT      =14  ; PDno     */
Const R2_MERGEPEN         =15  ; DPo      */
Const R2_WHITE            =16  ;  1       */
Const R2_LAST             =16

Const ERROR               =0
Const NULLREGION          =1
Const SIMPLEREGION        =2
Const COMPLEXREGION       =3
Const RGN_ERROR =ERROR

; CombineRgn() Styles */
Const RGN_AND             =1
Const RGN_OR              =2
Const RGN_XOR             =3
Const RGN_DIFF            =4
Const RGN_COPY            =5
Const RGN_MIN             =RGN_AND
Const RGN_MAX             =RGN_COPY

; StretchBlt() Modes */
Const BLACKONWHITE         =        1
Const WHITEONBLACK          =       2
Const COLORONCOLOR           =      3
Const HALFTONE                =     4
Const MAXSTRETCHBLTMODE        =    4

;if(WINVER >= =$400)
; New StretchBlt() Modes */
Const STRETCH_ANDSCANS   = BLACKONWHITE
Const STRETCH_ORSCANS    = WHITEONBLACK
Const STRETCH_DELETESCANS= COLORONCOLOR
Const STRETCH_HALFTONE   = HALFTONE
;EndIf ; WINVER >= =$400 */

; PolyFill() Modes */
Const ALTERNATE           =         1
Const WINDING              =        2
Const POLYFILL_LAST         =       2

; Layout Orientation Options */
;if(WINVER >= =$500)
Const LAYOUT_RTL                         =$0000001 ; Right to left
Const LAYOUT_BTT                         =$0000002 ; Bottom to top
Const LAYOUT_VBH                         =$0000004 ; Vertical before horizontal
Const LAYOUT_ORIENTATIONMASK =            (LAYOUT_RTL Or LAYOUT_BTT Or LAYOUT_VBH)
Const LAYOUT_BITMAPORIENTATIONPRESERVED  =$0000008
;EndIf ; WINVER >= =$500 */

; Text Alignment Options */
Const TA_NOUPDATECP              =  0
Const TA_UPDATECP                 = 1

Const TA_LEFT                     = 0
Const TA_RIGHT                    = 2
Const TA_CENTER                   = 6

Const TA_TOP                       =0
Const TA_BOTTOM                    =8
Const TA_BASELINE                  =24
;if (WINVER >= =$400)

;endif

Const VTA_BASELINE =TA_BASELINE
Const VTA_LEFT     =TA_BOTTOM
Const VTA_RIGHT    =TA_TOP
Const VTA_CENTER   =TA_CENTER
Const VTA_BOTTOM   =TA_RIGHT
Const VTA_TOP      =TA_LEFT

Const ETO_OPAQUE                   =$002
Const ETO_CLIPPED                  =$004
;if(WINVER >= =$400)
Const ETO_GLYPH_INDEX              =$010
Const ETO_RTLREADING               =$080
Const ETO_NUMERICSLOCAL            =$400
Const ETO_NUMERICSLATIN            =$800
Const ETO_IGNORELANGUAGE           =$1000
;EndIf ; WINVER >= =$400 */
;if (_WIN32_WINNT >= =$500)
Const ETO_PDY                      =$2000
;endif ; (_WIN32_WINNT >= =$500)

Const ASPECT_FILTERING             =$001

; Bounds Accumulation APIs */

Const DCB_RESET       =$001
Const DCB_ACCUMULATE  =$002
Const DCB_DIRTY       =DCB_ACCUMULATE
Const DCB_SET        = (DCB_RESET Or DCB_ACCUMULATE)
Const DCB_ENABLE      =$004
Const DCB_DISABLE     =$008

;ifndef NOMETAFILE

; Metafile Functions */
Const META_SETBKCOLOR              =$201
Const META_SETBKMODE               =$102
Const META_SETMAPMODE              =$103
Const META_SETROP2                 =$104
Const META_SETRELABS               =$105
Const META_SETPOLYFILLMODE         =$106
Const META_SETSTRETCHBLTMODE       =$107
Const META_SETTEXTCHAREXTRA        =$108
Const META_SETTEXTCOLOR            =$209
Const META_SETTEXTJUSTIFICATION    =$20A
Const META_SETWINDOWORG            =$20B
Const META_SETWINDOWEXT            =$20C
Const META_SETVIEWPORTORG          =$20D
Const META_SETVIEWPORTEXT          =$20E
Const META_OFFSETWINDOWORG         =$20F
Const META_SCALEWINDOWEXT          =$410
Const META_OFFSETVIEWPORTORG       =$211
Const META_SCALEVIEWPORTEXT        =$412
Const META_LINETO                  =$213
Const META_MOVETO                  =$214
Const META_EXCLUDECLIPRECT         =$415
Const META_INTERSECTCLIPRECT       =$416
Const META_ARC                     =$817
Const META_ELLIPSE                 =$418
Const META_FLOODFILL               =$419
Const META_PIE                     =$81A
Const META_RECTANGLE               =$41B
Const META_ROUNDRECT               =$61C
Const META_PATBLT                  =$61D
Const META_SAVEDC                  =$01E
Const META_SETPIXEL                =$41F
Const META_OFFSETCLIPRGN           =$220
Const META_TEXTOUT                 =$521
Const META_BITBLT                  =$922
Const META_STRETCHBLT              =$B23
Const META_POLYGON                 =$324
Const META_POLYLINE                =$325
Const META_ESCAPE                  =$626
Const META_RESTOREDC               =$127
Const META_FILLREGION              =$228
Const META_FRAMEREGION             =$429
Const META_INVERTREGION            =$12A
Const META_PAINTREGION             =$12B
Const META_SELECTCLIPREGION        =$12C
Const META_SELECTOBJECT            =$12D
Const META_SETTEXTALIGN            =$12E
Const META_CHORD                   =$830
Const META_SETMAPPERFLAGS          =$231
Const META_EXTTEXTOUT              =$a32
Const META_SETDIBTODEV             =$d33
Const META_SELECTPALETTE           =$234
Const META_REALIZEPALETTE          =$035
Const META_ANIMATEPALETTE          =$436
Const META_SETPALENTRIES           =$037
Const META_POLYPOLYGON             =$538
Const META_RESIZEPALETTE           =$139
Const META_DIBBITBLT               =$940
Const META_DIBSTRETCHBLT           =$b41
Const META_DIBCREATEPATTERNBRUSH   =$142
Const META_STRETCHDIB              =$f43
Const META_EXTFLOODFILL            =$548
;if(WINVER >= =$500)
Const META_SETLAYOUT               =$149
;EndIf ; WINVER >= =$500 */
Const META_DELETEOBJECT            =$1f0
Const META_CREATEPALETTE           =$0f7
Const META_CREATEPATTERNBRUSH      =$1F9
Const META_CREATEPENINDIRECT       =$2FA
Const META_CREATEFONTINDIRECT      =$2FB
Const META_CREATEBRUSHINDIRECT     =$2FC
Const META_CREATEREGION            =$6FF

; GDI Escapes */
Const NEWFRAME                    = 1
Const ABORTDOC                     =2
Const NEXTBAND                     =3
Const SETCOLORTABLE                =4
Const GETCOLORTABLE                =5
Const FLUSHOUTPUT                  =6
Const DRAFTMODE                    =7
Const QUERYESCSUPPORT              =8
Const SETABORTPROC                 =9
Const STARTDOC                     =10
Const ENDDOC                       =11
Const GETPHYSPAGESIZE              =12
Const GETPRINTINGOFFSET            =13
Const GETSCALINGFACTOR             =14
Const MFCOMMENT                    =15
Const GETPENWIDTH                  =16
Const SETCOPYCOUNT                 =17
Const SELECTPAPERSOURCE            =18
Const DEVICEDATA                   =19
Const PASSTHROUGH                  =19
Const GETTECHNOLGY                 =20
Const GETTECHNOLOGY                =20
Const SETLINECAP                   =21
Const SETLINEJOIN                  =22
Const SETMITERLIMIT                =23
Const BANDINFO                     =24
Const DRAWPATTERNRECT              =25
Const GETVECTORPENSIZE             =26
Const GETVECTORBRUSHSIZE           =27
Const ENABLEDUPLEX                 =28
Const GETSETPAPERBINS              =29
Const GETSETPRINTORIENT            =30
Const ENUMPAPERBINS                =31
Const SETDIBSCALING                =32
Const EPSPRINTING                  =33
Const ENUMPAPERMETRICS             =34
Const GETSETPAPERMETRICS           =35
Const POSTSCRIPT_DATA              =37
Const POSTSCRIPT_IGNORE            =38
Const MOUSETRAILS                  =39
Const GETDEVICEUNITS               =42

Const GETEXTENDEDTEXTMETRICS       =256
Const GETEXTENTTABLE               =257
Const GETPAIRKERNTABLE             =258
Const GETTRACKKERNTABLE            =259
Const EXTTEXTOUT                   =512
Const GETFACENAME                  =513
Const DOWNLOADFACE                 =514
Const ENABLERELATIVEWIDTHS         =768
Const ENABLEPAIRKERNING            =769
Const SETKERNTRACK                 =770
Const SETALLJUSTVALUES             =771
Const SETCHARSET                   =772

Const STRETCHBLT                   =2048
Const METAFILE_DRIVER              =2049
Const GETSETSCREENPARAMS           =3072
Const QUERYDIBSUPPORT              =3073
Const BEGIN_PATH                   =4096
Const CLIP_TO_PATH                 =4097
Const END_PATH                     =4098
Const EXT_DEVICE_CAPS              =4099
Const RESTORE_CTM                  =4100
Const SAVE_CTM                     =4101
Const SET_ARC_DIRECTION            =4102
Const SET_BACKGROUND_COLOR         =4103
Const SET_POLY_MODE                =4104
Const SET_SCREEN_ANGLE             =4105
Const SET_SPREAD                   =4106
Const TRANSFORM_CTM                =4107
Const SET_CLIP_BOX                 =4108
Const SET_BOUNDS                   =4109
Const SET_MIRROR_MODE              =4110
Const OPENCHANNEL                  =4110
Const DOWNLOADHEADER               =4111
Const CLOSECHANNEL                 =4112
Const POSTSCRIPT_PASSTHROUGH       =4115
Const ENCAPSULATED_POSTSCRIPT      =4116

Const POSTSCRIPT_IDENTIFY          =4117   ; new escape for NT5 pscript driver */
Const POSTSCRIPT_INJECTION         =4118   ; new escape for NT5 pscript driver */

Const CHECKJPEGFORMAT              =4119
Const CHECKPNGFORMAT               =4120

Const GET_PS_FEATURESETTING        =4121   ; new escape for NT5 pscript driver */

Const SPCLPASSTHROUGH2             =4568   ; new escape for NT5 pscript driver */

Const PSIDENT_GDICENTRIC   = 0
Const PSIDENT_PSCENTRIC     =1


Const PSINJECT_BEGINSTREAM             =   1
Const PSINJECT_PSADOBE                 =   2
Const PSINJECT_PAGESATEND              =   3
Const PSINJECT_PAGES                   =   4

Const PSINJECT_DOCNEEDEDRES            =   5
Const PSINJECT_DOCSUPPLIEDRES          =   6
Const PSINJECT_PAGEORDER                =  7
Const PSINJECT_ORIENTATION             =   8
Const PSINJECT_BOUNDINGBOX             =   9
Const PSINJECT_DOCUMENTPROCESSCOLORS   =   10

Const PSINJECT_COMMENTS               =    11
Const PSINJECT_BEGINDEFAULTS          =    12
Const PSINJECT_ENDDEFAULTS            =    13
Const PSINJECT_BEGINPROLOG            =    14
Const PSINJECT_ENDPROLOG              =    15
Const PSINJECT_BEGINSETUP             =    16
Const PSINJECT_ENDSETUP                =   17
Const PSINJECT_TRAILER                  =  18
Const PSINJECT_EOF                       = 19
Const PSINJECT_ENDSTREAM                  =20
Const PSINJECT_DOCUMENTPROCESSCOLORSATEND =21

Const PSINJECT_PAGENUMBER         =        100
Const PSINJECT_BEGINPAGESETUP      =       101
Const PSINJECT_ENDPAGESETUP         =      102
Const PSINJECT_PAGETRAILER           =     103
Const PSINJECT_PLATECOLOR             =    104

Const PSINJECT_SHOWPAGE                =   105
Const PSINJECT_PAGEBBOX                =   106
Const PSINJECT_ENDPAGECOMMENTS         =   107

Const PSINJECT_VMSAVE                    = 200
Const PSINJECT_VMRESTORE                 = 201



Const FEATURESETTING_NUP               =   0
Const FEATURESETTING_OUTPUT            =   1
Const FEATURESETTING_PSLEVEL            =  2
Const FEATURESETTING_CUSTPAPER          =  3
Const FEATURESETTING_MIRROR            =   4
Const FEATURESETTING_NEGATIVE         =    5
Const FEATURESETTING_PROTOCOL        =     6


Const FEATURESETTING_PRIVATE_BEGIN =$1000
Const FEATURESETTING_PRIVATE_END   =$1FFF


; Value returned for FEATURESETTING_PROTOCOL */
Const PSPROTOCOL_ASCII    =         0
Const PSPROTOCOL_BCP      =         1
Const PSPROTOCOL_TBCP     =         2
Const PSPROTOCOL_BINARY   =         3

; Flag returned from QUERYDIBSUPPORT */
Const QDI_SETDIBITS        =        1
Const QDI_GETDIBITS        =        2
Const QDI_DIBTOSCREEN      =        4
Const QDI_STRETCHDIB       =        8

; Spooler Error Codes */
Const SP_NOTREPORTED        =       $4000
Const SP_ERROR              =       (-1)
Const SP_APPABORT           =       (-2)
Const SP_USERABORT          =       (-3)
Const SP_OUTOFDISK          =       (-4)
Const SP_OUTOFMEMORY        =       (-5)

Const PR_JOBSTATUS          =       $000

; Object Definitions for EnumObjects() */
Const OBJ_PEN             =1
Const OBJ_BRUSH           =2
Const OBJ_DC              =3
Const OBJ_METADC          =4
Const OBJ_PAL             =5
Const OBJ_FONT            =6
Const OBJ_BITMAP          =7
Const OBJ_REGION          =8
Const OBJ_METAFILE        =9
Const OBJ_MEMDC           =10
Const OBJ_EXTPEN          =11
Const OBJ_ENHMETADC       =12
Const OBJ_ENHMETAFILE     =13
Const OBJ_COLORSPACE      =14

; xform stuff */
Const MWT_IDENTITY        =1
Const MWT_LEFTMULTIPLY    =2
Const MWT_RIGHTMULTIPLY   =3

Const MWT_MIN          =   MWT_IDENTITY
Const MWT_MAX           =  MWT_RIGHTMULTIPLY


Const CS_ENABLE                       =$0000001
Const CS_DISABLE                      =$0000002
Const CS_DELETE_TRANSFORM             =$0000003

; UpdateICMRegKey Constants               */
Const ICM_ADDPROFIE                  =1
Const ICM_DELETEPROFILE               =2
Const ICM_QUERYPROFILE                =3
Const ICM_SETDEFAULTPROFILE           =4
Const ICM_REGISTERICMATCHER           =5
Const ICM_UNREGISTERICMATCHER         =6
Const ICM_QUERYMATCH                  =7
Const TCI_SRCCHARSET  =1
Const TCI_SRCCODEPAGE =2
Const TCI_SRCFONTSIG  =3
Const TMPF_FIXED_PITCH    =$1
Const TMPF_VECTOR             =$2
Const TMPF_DEVICE             =$8
Const TMPF_TRUETYPE       =$4
Const NTM_REGULAR     =$0000040
Const NTM_BOLD        =$0000020
Const NTM_ITALIC      =$0000001

; new in NT 5.0 */

Const NTM_NONNEGATIVE_AC  =$0010000
Const NTM_PS_OPENTYPE     =$0020000
Const NTM_TT_OPENTYPE     =$0040000
Const NTM_MULTIPLEMASTER  =$0080000
Const NTM_TYPE1           =$0100000
Const NTM_DSIG            =$0200000
; Logical Font */
Const LF_FACESIZE         =32

Const LF_FULLFACESIZE     =64

Const OUT_DEFAULT_PRECIS          =0
Const OUT_STRING_PRECIS           =1
Const OUT_CHARACTER_PRECIS        =2
Const OUT_STROKE_PRECIS           =3
Const OUT_TT_PRECIS               =4
Const OUT_DEVICE_PRECIS           =5
Const OUT_RASTER_PRECIS           =6
Const OUT_TT_ONLY_PRECIS          =7
Const OUT_OUTLINE_PRECIS          =8
Const OUT_SCREEN_OUTLINE_PRECIS   =9
Const OUT_PS_ONLY_PRECIS          =10

Const CLIP_DEFAULT_PRECIS     =0
Const CLIP_CHARACTER_PRECIS   =1
Const CLIP_STROKE_PRECIS      =2
Const CLIP_MASK               =$f
Const CLIP_LH_ANGLES          =(1 Shr 4)
Const CLIP_TT_ALWAYS          =(2 Shr 4)
Const CLIP_EMBEDDED           =(8 Shr 4)

Const DEFAULT_QUALITY         =0
Const DRAFT_QUALITY           =1
Const PROOF_QUALITY           =2
;if(WINVER >= =$400)
Const NONANTIALIASED_QUALITY=  3
Const ANTIALIASED_QUALITY  =   4
;EndIf ; WINVER >= =$400 */

;if (_WIN32_WINNT >= =$500)
Const CLEARTYPE_QUALITY       =5
;endif

Const DEFAULT_PITCH           =0
Const FIXED_PITCH             =1
Const VARIABLE_PITCH          =2
;if(WINVER >= =$400)
Const MONO_FONT               =8
;EndIf ; WINVER >= =$400 */

Const ANSI_CHARSET           = 0
Const DEFAULT_CHARSET        = 1
Const SYMBOL_CHARSET         = 2
Const SHIFTJIS_CHARSET       = 128
Const HANGEUL_CHARSET        = 129
Const HANGUL_CHARSET         = 129
Const GB2312_CHARSET         = 134
Const CHINESEBIG5_CHARSET    = 136
Const OEM_CHARSET            = 255
;if(WINVER >= =$400)
Const JOHAB_CHARSET          = 130
Const HEBREW_CHARSET         = 177
Const ARABIC_CHARSET          =178
Const GREEK_CHARSET           =161
Const TURKISH_CHARSET        = 162
Const VIETNAMESE_CHARSET     = 163
Const THAI_CHARSET           = 222
Const EASTEUROPE_CHARSET     = 238
Const RUSSIAN_CHARSET        = 204

Const MAC_CHARSET            = 77
Const BALTIC_CHARSET         = 186

Const FS_LATIN1               =$0000001
Const FS_LATIN2               =$0000002
Const FS_CYRILLIC             =$0000004
Const FS_GREEK                =$0000008
Const FS_TURKISH              =$0000010
Const FS_HEBREW               =$0000020
Const FS_ARABIC               =$0000040
Const FS_BALTIC               =$0000080
Const FS_VIETNAMESE           =$0000100
Const FS_THAI                 =$0010000
Const FS_JISJAPAN             =$0020000
Const FS_CHINESESIMP          =$0040000
Const FS_WANSUNG              =$0080000
Const FS_CHINESETRAD          =$0100000
Const FS_JOHAB                =$0200000
Const FS_SYMBOL               =$80000000
;EndIf ; WINVER >= =$400 */

; Font Families */
Const FF_DONTCARE         =(0 Shr 4)  ; Don't care or don't know. */
Const FF_ROMAN            =(1 Shr 4)  ; Variable stroke width, serifed. */
                                    ; Times Roman, Century Schoolbook, etc. */
Const FF_SWISS            =(2 Shr 4)  ; Variable stroke width, sans-serifed. */
                                    ; Helvetica, Swiss, etc. */
Const FF_MODERN           =(3 Shr 4)  ; Constant stroke width, serifed or sans-serifed. */
                                    ; Pica, Elite, Courier, etc. */
Const FF_SCRIPT           =(4 Shr 4)  ; Cursive, etc. */
Const FF_DECORATIVE       =(5 Shr 4)  ; Old English, etc. */

; Font Weights */
Const FW_DONTCARE         =0
Const FW_THIN             =100
Const FW_EXTRALIGHT       =200
Const FW_LIGHT            =300
Const FW_NORMAL           =400
Const FW_MEDIUM           =500
Const FW_SEMIBOLD         =600
Const FW_BOLD             =700
Const FW_EXTRABOLD        =800
Const FW_HEAVY            =900

Const FW_ULTRALIGHT       =FW_EXTRALIGHT
Const FW_REGULAR          =FW_NORMAL
Const FW_DEMIBOLD         =FW_SEMIBOLD
Const FW_ULTRABOLD        =FW_EXTRABOLD
Const FW_BLACK            =FW_HEAVY

Const PANOSE_COUNT         =      10
Const PAN_FAMILYTYPE_INDEX  =      0
Const PAN_SERIFSTYLE_INDEX   =     1
Const PAN_WEIGHT_INDEX        =    2
Const PAN_PROPORTION_INDEX     =   3
Const PAN_CONTRAST_INDEX        =  4
Const PAN_STROKEVARIATION_INDEX  = 5
Const PAN_ARMSTYLE_INDEX         = 6
Const PAN_LETTERFORM_INDEX       = 7
Const PAN_MIDLINE_INDEX          = 8
Const PAN_XHEIGHT_INDEX          = 9

Const PAN_CULTURE_LATIN         =  0
Const PAN_ANY                  =       0 ; Any                            */
Const PAN_NO_FIT                =      1 ; No Fit                         */

Const PAN_FAMILY_TEXT_DISPLAY    =     2 ; Text and Display               */
Const PAN_FAMILY_SCRIPT           =    3 ; Script                         */
Const PAN_FAMILY_DECORATIVE        =   4 ; Decorative                     */
Const PAN_FAMILY_PICTORIAL          =  5 ; Pictorial                      */

Const PAN_SERIF_COVE                =  2 ; Cove                           */
Const PAN_SERIF_OBTUSE_COVE         =  3 ; Obtuse Cove                    */
Const PAN_SERIF_SQUARE_COVE         =  4 ; Square Cove                    */
Const PAN_SERIF_OBTUSE_SQUARE_COVE  =  5 ; Obtuse Square Cove             */
Const PAN_SERIF_SQUARE              =  6 ; Square                         */
Const PAN_SERIF_THIN                 = 7 ; Thin                           */
Const PAN_SERIF_BONE                 = 8 ; Bone                           */
Const PAN_SERIF_EXAGGERATED          = 9 ; Exaggerated                    */
Const PAN_SERIF_TRIANGLE            = 10 ; Triangle                       */
Const PAN_SERIF_NORMAL_SANS         = 11 ; Normal Sans                    */
Const PAN_SERIF_OBTUSE_SANS         = 12 ; Obtuse Sans                    */
Const PAN_SERIF_PERP_SANS           = 13 ; Prep Sans                      */
Const PAN_SERIF_FLARED              = 14 ; Flared                         */
Const PAN_SERIF_ROUNDED             = 15 ; Rounded                        */

Const PAN_WEIGHT_VERY_LIGHT      =     2 ; Very Light                     */
Const PAN_WEIGHT_LIGHT           =     3 ; Light                          */
Const PAN_WEIGHT_THIN            =     4 ; Thin                           */
Const PAN_WEIGHT_BOOK            =     5 ; Book                           */
Const PAN_WEIGHT_MEDIUM          =     6 ; Medium                         */
Const PAN_WEIGHT_DEMI            =     7 ; Demi                           */
Const PAN_WEIGHT_BOLD            =     8 ; Bold                           */
Const PAN_WEIGHT_HEAVY           =     9 ; Heavy                          */
Const PAN_WEIGHT_BLACK           =    10 ; Black                          */
Const PAN_WEIGHT_NORD            =    11 ; Nord                           */

Const PAN_PROP_OLD_STYLE         =     2 ; Old Style                      */
Const PAN_PROP_MODERN            =     3 ; Modern                         */
Const PAN_PROP_EVEN_WIDTH        =     4 ; Even Width                     */
Const PAN_PROP_EXPANDED          =     5 ; Expanded                       */
Const PAN_PROP_CONDENSED         =     6 ; Condensed                      */
Const PAN_PROP_VERY_EXPANDED     =     7 ; Very Expanded                  */
Const PAN_PROP_VERY_CONDENSED    =     8 ; Very Condensed                 */
Const PAN_PROP_MONOSPACED        =     9 ; Monospaced                     */

Const PAN_CONTRAST_NONE          =     2 ; None                           */
Const PAN_CONTRAST_VERY_LOW      =     3 ; Very Low                       */
Const PAN_CONTRAST_LOW           =     4 ; Low                            */
Const PAN_CONTRAST_MEDIUM_LOW    =     5 ; Medium Low                     */
Const PAN_CONTRAST_MEDIUM        =     6 ; Medium                         */
Const PAN_CONTRAST_MEDIUM_HIGH   =     7 ; Mediim High                    */
Const PAN_CONTRAST_HIGH          =     8 ; High                           */
Const PAN_CONTRAST_VERY_HIGH     =     9 ; Very High                      */

Const PAN_STROKE_GRADUAL_DIAG    =     2 ; Gradual/Diagonal               */
Const PAN_STROKE_GRADUAL_TRAN    =     3 ; Gradual/Transitional           */
Const PAN_STROKE_GRADUAL_VERT    =     4 ; Gradual/Vertical               */
Const PAN_STROKE_GRADUAL_HORZ    =     5 ; Gradual/Horizontal             */
Const PAN_STROKE_RAPID_VERT      =     6 ; Rapid/Vertical                 */
Const PAN_STROKE_RAPID_HORZ      =     7 ; Rapid/Horizontal               */
Const PAN_STROKE_INSTANT_VERT    =     8 ; Instant/Vertical               */

Const PAN_STRAIGHT_ARMS_HORZ      =    2 ; Straight Arms/Horizontal       */
Const PAN_STRAIGHT_ARMS_WEDGE     =    3 ; Straight Arms/Wedge            */
Const PAN_STRAIGHT_ARMS_VERT      =    4 ; Straight Arms/Vertical         */
Const PAN_STRAIGHT_ARMS_SINGLE_SERIF=  5 ; Straight Arms/Single-Serif     */
Const PAN_STRAIGHT_ARMS_DOUBLE_SERIF=  6 ; Straight Arms/Double-Serif     */
Const PAN_BENT_ARMS_HORZ           =   7 ; Non-Straight Arms/Horizontal   */
Const PAN_BENT_ARMS_WEDGE          =   8 ; Non-Straight Arms/Wedge        */
Const PAN_BENT_ARMS_VERT           =   9 ; Non-Straight Arms/Vertical     */
Const PAN_BENT_ARMS_SINGLE_SERIF   =  10 ; Non-Straight Arms/Single-Serif */
Const PAN_BENT_ARMS_DOUBLE_SERIF   =  11 ; Non-Straight Arms/Double-Serif */

Const PAN_LETT_NORMAL_CONTACT      =   2 ; Normal/Contact                 */
Const PAN_LETT_NORMAL_WEIGHTED     =   3 ; Normal/Weighted                */
Const PAN_LETT_NORMAL_BOXED        =   4 ; Normal/Boxed                   */
Const PAN_LETT_NORMAL_FLATTENED    =   5 ; Normal/Flattened               */
Const PAN_LETT_NORMAL_ROUNDED      =   6 ; Normal/Rounded                 */
Const PAN_LETT_NORMAL_OFF_CENTER   =   7 ; Normal/Off Center              */
Const PAN_LETT_NORMAL_SQUARE       =   8 ; Normal/Square                  */
Const PAN_LETT_OBLIQUE_CONTACT     =   9 ; Oblique/Contact                */
Const PAN_LETT_OBLIQUE_WEIGHTED    =  10 ; Oblique/Weighted               */
Const PAN_LETT_OBLIQUE_BOXED       =  11 ; Oblique/Boxed                  */
Const PAN_LETT_OBLIQUE_FLATTENED   =  12 ; Oblique/Flattened              */
Const PAN_LETT_OBLIQUE_ROUNDED     =  13 ; Oblique/Rounded                */
Const PAN_LETT_OBLIQUE_OFF_CENTER  =  14 ; Oblique/Off Center             */
Const PAN_LETT_OBLIQUE_SQUARE      =  15 ; Oblique/Square                 */

Const PAN_MIDLINE_STANDARD_TRIMMED  =  2 ; Standard/Trimmed               */
Const PAN_MIDLINE_STANDARD_POINTED  =  3 ; Standard/Pointed               */
Const PAN_MIDLINE_STANDARD_SERIFED  =  4 ; Standard/Serifed               */
Const PAN_MIDLINE_HIGH_TRIMMED      =  5 ; High/Trimmed                   */
Const PAN_MIDLINE_HIGH_POINTED      =  6 ; High/Pointed                   */
Const PAN_MIDLINE_HIGH_SERIFED      =  7 ; High/Serifed                   */
Const PAN_MIDLINE_CONSTANT_TRIMMED  =  8 ; Constant/Trimmed               */
Const PAN_MIDLINE_CONSTANT_POINTED  =  9 ; Constant/Pointed               */
Const PAN_MIDLINE_CONSTANT_SERIFED  = 10 ; Constant/Serifed               */
Const PAN_MIDLINE_LOW_TRIMMED       = 11 ; Low/Trimmed                    */
Const PAN_MIDLINE_LOW_POINTED       = 12 ; Low/Pointed                    */
Const PAN_MIDLINE_LOW_SERIFED       = 13 ; Low/Serifed                    */

Const PAN_XHEIGHT_CONSTANT_SMALL    =  2 ; Constant/Small                 */
Const PAN_XHEIGHT_CONSTANT_STD      =  3 ; Constant/Standard              */
Const PAN_XHEIGHT_CONSTANT_LARGE   =   4 ; Constant/Large                 */
Const PAN_XHEIGHT_DUCKING_SMALL    =   5 ; Ducking/Small                  */
Const PAN_XHEIGHT_DUCKING_STD      =   6 ; Ducking/Standard               */
Const PAN_XHEIGHT_DUCKING_LARGE    =   7 ; Ducking/Large                  */


Const ELF_VENDOR_SIZE    = 4

Const ELF_VERSION       =  0
Const ELF_CULTURE_LATIN =  0

; EnumFonts Masks */
Const RASTER_FONTTYPE     =$001
Const DEVICE_FONTTYPE     =$02
Const TRUETYPE_FONTTYPE   =$04

; palette entry flags */

Const PC_RESERVED     =$1    ; palette index used for animation */
Const PC_EXPLICIT     =$2    ; palette index is explicit to device */
Const PC_NOCOLLAPSE   =$4    ; do not match color to system palette */

; Background Modes */
Const TRANSPARENT         =1
Const OPAQUE              =2
Const BKMODE_LAST         =2

; Graphics Modes */

Const GM_COMPATIBLE=       1
Const GM_ADVANCED   =      2
Const GM_LAST        =     2

; PolyDraw and GetPath point types */
Const PT_CLOSEFIGURE      =$1
Const PT_LINETO           =$2
Const PT_BEZIERTO         =$4
Const PT_MOVETO           =$6

; Mapping Modes */
Const MM_TEXT           =  1
Const MM_LOMETRIC        = 2
Const MM_HIMETRIC       =  3
Const MM_LOENGLISH       = 4
Const MM_HIENGLISH     =   5
Const MM_TWIPS           = 6
Const MM_ISOTROPIC        =7
Const MM_ANISOTROPIC     = 8

; Min and Max Mapping Mode values */
Const MM_MIN             = MM_TEXT
Const MM_MAX             = MM_ANISOTROPIC
Const MM_MAX_FIXEDSCALE  = MM_TWIPS

; Coordinate Modes */
Const ABSOLUTE            =1
Const RELATIVE            =2

; Stock Logical Objects */
Const WHITE_BRUSH        = 0
Const LTGRAY_BRUSH       = 1
Const GRAY_BRUSH         = 2
Const DKGRAY_BRUSH       = 3
Const BLACK_BRUSH        = 4
Const NULL_BRUSH         = 5
Const HOLLOW_BRUSH       = NULL_BRUSH
Const WHITE_PEN          = 6
Const BLACK_PEN          = 7
Const NULL_PEN           = 8
Const OEM_FIXED_FONT     = 10
Const ANSI_FIXED_FONT    = 11
Const ANSI_VAR_FONT      = 12
Const SYSTEM_FONT        = 13
Const DEVICE_DEFAULT_FONT= 14
Const DEFAULT_PALETTE    = 15
Const SYSTEM_FIXED_FONT  = 16

;if(WINVER >= =$400)
Const DEFAULT_GUI_FONT    =17
;EndIf ; WINVER >= =$400 */

;if (_WIN32_WINNT >= =$500)
Const DC_BRUSH           = 18
Const DC_PEN             = 19
;endif


Const CLR_INVALID     =$FFFFFFFF

; Brush Styles */
Const BS_SOLID        =    0
Const BS_NULL          =   1
Const BS_HOLLOW        =   BS_NULL
Const BS_HATCHED        =  2
Const BS_PATTERN       =   3
Const BS_INDEXED       =   4
Const BS_DIBPATTERN     =  5
Const BS_DIBPATTERNPT  =   6
Const BS_PATTERN8X8     =  7
Const BS_DIBPATTERN8X8   = 8
Const BS_MONOPATTERN   =   9

; Hatch Styles */
Const HS_HORIZONTAL       =0       ; ----- */
Const HS_VERTICAL         =1       ; ||||| */
Const HS_FDIAGONAL        =2       ; \\\\\ */
Const HS_BDIAGONAL        =3       ; ;;/ */
Const HS_CROSS           = 4       ; +++++ */
Const HS_DIAGCROSS       = 5       ; xxxxx */

; Pen Styles */
Const PS_SOLID           = 0
Const PS_DASH            = 1       ; -------  */
Const PS_DOT             = 2       ; .......  */
Const PS_DASHDOT         = 3       ; _._._._  */
Const PS_DASHDOTDOT      = 4       ; _.._.._  */
Const PS_NULL            = 5
Const PS_INSIDEFRAME     = 6
Const PS_USERSTYLE       = 7
Const PS_ALTERNATE       = 8
Const PS_STYLE_MASK       =$000000F

Const PS_ENDCAP_ROUND     =$0000000
Const PS_ENDCAP_SQUARE    =$0000100
Const PS_ENDCAP_FLAT      =$0000200
Const PS_ENDCAP_MASK      =$0000F00

Const PS_JOIN_ROUND       =$0000000
Const PS_JOIN_BEVEL       =$0001000
Const PS_JOIN_MITER       =$0002000
Const PS_JOIN_MASK        =$000F000

Const PS_COSMETIC         =$0000000
Const PS_GEOMETRIC        =$0010000
Const PS_TYPE_MASK        =$00F0000

Const AD_COUNTERCLOCKWISE =1
Const AD_CLOCKWISE        =2

; Device Parameters for GetDeviceCaps() */
Const DRIVERVERSION =0     ; Device driver version                    */
Const TECHNOLOGY    =2     ; Device classification                    */
Const HORZSIZE      =4     ; Horizontal size in millimeters           */
Const VERTSIZE      =6     ; Vertical size in millimeters             */
Const HORZRES       =8     ; Horizontal width in pixels               */
Const VERTRES       =10    ; Vertical height in pixels                */
Const BITSPIXEL     =12    ; Number of bits per pixel                 */
Const PLANES        =14    ; Number of planes                         */
Const NUMBRUSHES    =16    ; Number of brushes the device has         */
Const NUMPENS       =18    ; Number of pens the device has            */
Const NUMMARKERS    =20    ; Number of markers the device has         */
Const NUMFONTS      =22    ; Number of fonts the device has           */
Const NUMCOLORS     =24    ; Number of colors the device supports     */
Const PDEVICESIZE   =26    ; Size required for device descriptor      */
Const CURVECAPS     =28    ; Curve capabilities                       */
Const LINECAPS      =30    ; Line capabilities                        */
Const POLYGONALCAPS =32    ; Polygonal capabilities                   */
Const TEXTCAPS      =34    ; Text capabilities                        */
Const CLIPCAPS      =36    ; Clipping capabilities                    */
Const RASTERCAPS    =38    ; Bitblt capabilities                      */
Const ASPECTX       =40    ; Length of the X leg                      */
Const ASPECTY       =42    ; Length of the Y leg                      */
Const ASPECTXY      =44    ; Length of the hypotenuse                 */

Const LOGPIXELSX    =88    ; Logical pixels/inch in X                 */
Const LOGPIXELSY    =90    ; Logical pixels/inch in Y                 */

Const SIZEPALETTE  =104    ; Number of entries in physical palette    */
Const NUMRESERVED  =106    ; Number of reserved entries in palette    */
Const COLORRES     =108    ; Actual color resolution                  */

; Printing related DeviceCaps. These replace the appropriate Escapes

Const PHYSICALWIDTH  = 110 ; Physical Width in device units           */
Const PHYSICALHEIGHT = 111 ; Physical Height in device units          */
Const PHYSICALOFFSETX =112 ; Physical Printable Area x margin         */
Const PHYSICALOFFSETY =113 ; Physical Printable Area y margin         */
Const SCALINGFACTORX  =114 ; Scaling factor x                         */
Const SCALINGFACTORY  =115 ; Scaling factor y                         */

; Display driver specific

Const VREFRESH        =116  ; Current vertical refresh rate of the    */
                             ; display device (for displays only) in Hz*/
Const DESKTOPVERTRES  =117  ; Horizontal width of entire desktop in   */
                             ; pixels                                  */
Const DESKTOPHORZRES  =118  ; Vertical height of entire desktop in    */
                             ; pixels                                  */
Const BLTALIGNMENT    =119  ; Preferred blt alignment                 */

;if(WINVER >= =$500)
Const SHADEBLENDCAPS  =120  ; Shading and blending caps               */
Const COLORMGMTCAPS   =121  ; Color Management caps                   */
;EndIf ; WINVER >= =$500 */

;ifndef NOGDICAPMASKS

; Device Capability Masks: */

; Device Technologies */
Const DT_PLOTTER       =   0   ; Vector plotter                   */
Const DT_RASDISPLAY    =   1   ; Raster display                   */
Const DT_RASPRINTER    =   2   ; Raster printer                   */
Const DT_RASCAMERA     =   3   ; Raster camera                    */
Const DT_CHARSTREAM    =   4   ; Character-stream, PLP            */
Const DT_METAFILE      =   5   ; Metafile, VDM                    */
Const DT_DISPFILE       =  6   ; Display-file                     */

; Curve Capabilities */
Const CC_NONE           =  0   ; Curves not supported             */
Const CC_CIRCLES        =  1   ; Can do circles                   */
Const CC_PIE            =  2   ; Can do pie wedges                */
Const CC_CHORD          =  4   ; Can do chord arcs                */
Const CC_ELLIPSES       =  8   ; Can do ellipese                  */
Const CC_WIDE           =  16  ; Can do wide lines                */
Const CC_STYLED         =  32  ; Can do styled lines              */
Const CC_WIDESTYLED     =  64  ; Can do wide styled lines         */
Const CC_INTERIORS      =  128 ; Can do interiors                 */
Const CC_ROUNDRECT      =  256 ;                                  */

; Line Capabilities */
Const LC_NONE         =    0   ; Lines not supported              */
Const LC_POLYLINE      =   2   ; Can do polylines                 */
Const LC_MARKER         =  4   ; Can do markers                   */
Const LC_POLYMARKER      = 8   ; Can do polymarkers               */
Const LC_WIDE             =16  ; Can do wide lines                */
Const LC_STYLED          = 32  ; Can do styled lines              */
Const LC_WIDESTYLED       =64  ; Can do wide styled lines         */
Const LC_INTERIORS        =128 ; Can do interiors                 */

; Polygonal Capabilities */
Const PC_NONE            = 0   ; Polygonals not supported         */
Const PC_POLYGON         = 1   ; Can do polygons                  */
Const PC_RECTANGLE       = 2   ; Can do rectangles                */
Const PC_WINDPOLYGON     = 4   ; Can do winding polygons          */
Const PC_TRAPEZOID       = 4   ; Can do trapezoids                */
Const PC_SCANLINE         =8   ; Can do scanlines                 */
Const PC_WIDE            = 16  ; Can do wide borders              */
Const PC_STYLED          = 32  ; Can do styled borders            */
Const PC_WIDESTYLED       =64  ; Can do wide styled borders       */
Const PC_INTERIORS        =128 ; Can do interiors                 */
Const PC_POLYPOLYGON      =256 ; Can do polypolygons              */
Const PC_PATHS            =512 ; Can do paths                     */

; Clipping Capabilities */
Const CP_NONE            = 0   ; No clipping of output            */
Const CP_RECTANGLE       = 1   ; Output clipped to rects          */
Const CP_REGION          = 2   ; obsolete                         */

; Text Capabilities */
Const TC_OP_CHARACTER     =$0000001  ; Can do OutputPrecision   CHARACTER      */
Const TC_OP_STROKE        =$0000002  ; Can do OutputPrecision   STROKE         */
Const TC_CP_STROKE        =$0000004  ; Can do ClipPrecision     STROKE         */
Const TC_CR_90            =$0000008  ; Can do CharRotAbility    90             */
Const TC_CR_ANY           =$0000010  ; Can do CharRotAbility    ANY            */
Const TC_SF_X_YINDEP      =$0000020  ; Can do ScaleFreedom      X_YINDEPENDENT */
Const TC_SA_DOUBLE        =$0000040  ; Can do ScaleAbility      DOUBLE         */
Const TC_SA_INTEGER       =$0000080  ; Can do ScaleAbility      INTEGER        */
Const TC_SA_CONTIN        =$0000100  ; Can do ScaleAbility      CONTINUOUS     */
Const TC_EA_DOUBLE        =$0000200  ; Can do EmboldenAbility   DOUBLE         */
Const TC_IA_ABLE          =$0000400  ; Can do ItalisizeAbility  ABLE           */
Const TC_UA_ABLE          =$0000800  ; Can do UnderlineAbility  ABLE           */
Const TC_SO_ABLE          =$0001000  ; Can do StrikeOutAbility  ABLE           */
Const TC_RA_ABLE          =$0002000  ; Can do RasterFontAble    ABLE           */
Const TC_VA_ABLE          =$0004000  ; Can do VectorFontAble    ABLE           */
Const TC_RESERVED         =$0008000
Const TC_SCROLLBLT        =$0010000  ; Don't do text scroll with blt           */

;EndIf ; NOGDICAPMASKS */

; Raster Capabilities */

Const RC_BITBLT         =  1       ; Can do standard BLT.             */
Const RC_BANDING         = 2       ; Device requires banding support  */
Const RC_SCALING          =4       ; Device requires scaling support  */
Const RC_BITMAP64         =8       ; Device can support >64K bitmap   */
Const RC_GDI20_OUTPUT     =$010      ; has 2.0 output calls         */
Const RC_GDI20_STATE      =$020
Const RC_SAVEBITMAP       =$040
Const RC_DI_BITMAP        =$080      ; supports DIB to memory       */
Const RC_PALETTE          =$100      ; supports a palette           */
Const RC_DIBTODEV         =$200      ; supports DIBitsToDevice      */
Const RC_BIGFONT          =$400      ; supports >64K fonts          */
Const RC_STRETCHBLT       =$800      ; supports StretchBlt          */
Const RC_FLOODFILL        =$1000      ; supports FloodFill           */
Const RC_STRETCHDIB       =$2000      ; supports StretchDIBits       */
Const RC_OP_DX_OUTPUT     =$4000
Const RC_DEVBITS          =$8000

;if(WINVER >= =$500)

; Shading and blending caps */
Const SB_NONE             =$0000000
Const SB_CONST_ALPHA      =$0000001
Const SB_PIXEL_ALPHA      =$0000002
Const SB_PREMULT_ALPHA    =$0000004

Const SB_GRAD_RECT        =$0000010
Const SB_GRAD_TRI         =$0000020

; Color Management caps */
Const CM_NONE             =$0000000
Const CM_DEVICE_ICM       =$0000001
Const CM_GAMMA_RAMP       =$0000002
Const CM_CMYK_COLOR       =$0000004

;EndIf ; WINVER >= =$500 */


; DIB color table identifiers */

Const DIB_RGB_COLORS     = 0 ; color table in RGBs */
Const DIB_PAL_COLORS     = 1 ; color table in palette indices */

; constants for Get/SetSystemPaletteUse() */

Const SYSPAL_ERROR  =  0
Const SYSPAL_STATIC =  1
Const SYSPAL_NOSTATIC= 2
Const SYSPAL_NOSTATIC256 =3

; constants for CreateDIBitmap */
Const CBM_INIT        =$4   ; initialize bitmap */

; ExtFloodFill style flags */
Const  FLOODFILLBORDER =  0
Const  FLOODFILLSURFACE  =1

; size of a device nme string */
Const CCHDEVICENAME=32

; size of a form name string */
Const CCHFORMNAME =32
;if (WINVER >= =$500) || (_WIN32_WINNT >= =$400)
Const DM_SPECVERSION =$401
;elif (WINVER >= =$400)

; field selection bits */
Const DM_ORIENTATION      =$0000001
Const DM_PAPERSIZE        =$0000002
Const DM_PAPERLENGTH      =$0000004
Const DM_PAPERWIDTH       =$0000008
Const DM_SCALE            =$0000010
;if(WINVER >= =$500)
Const DM_POSITION         =$0000020
Const DM_NUP              =$0000040
;EndIf ; WINVER >= =$500 */
Const DM_COPIES           =$0000100
Const DM_DEFAULTSOURCE    =$0000200
Const DM_PRINTQUALITY     =$0000400
Const DM_COLOR            =$0000800
Const DM_DUPLEX           =$0001000
Const DM_YRESOLUTION      =$0002000
Const DM_TTOPTION         =$0004000
Const DM_COLLATE          =$0008000
Const DM_FORMNAME         =$0010000
Const DM_LOGPIXELS        =$0020000
Const DM_BITSPERPEL       =$0040000
Const DM_PELSWIDTH        =$0080000
Const DM_PELSHEIGHT       =$0100000
Const DM_DISPLAYFLAGS     =$0200000
Const DM_DISPLAYFREQUENCY =$0400000
;if(WINVER >= =$400)
Const DM_ICMMETHOD        =$0800000
Const DM_ICMINTENT        =$1000000
Const DM_MEDIATYPE        =$2000000
Const DM_DITHERTYPE       =$4000000
Const DM_PANNINGWIDTH     =$8000000
Const DM_PANNINGHEIGHT    =$10000000
;EndIf ; WINVER >= =$400 */

; orientation selections */
Const DMORIENT_PORTRAIT   =1
Const DMORIENT_LANDSCAPE  =2

Const DISPLAY_DEVICE_ATTACHED_TO_DESKTOP =$0000001
Const DISPLAY_DEVICE_MULTI_DRIVER        =$0000002
Const DISPLAY_DEVICE_PRIMARY_DEVICE      =$0000004
Const DISPLAY_DEVICE_MIRRORING_DRIVER    =$0000008
Const DISPLAY_DEVICE_VGA_COMPATIBLE      =$0000010
Const DISPLAY_DEVICE_REMOVABLE           =$0000020
Const DISPLAY_DEVICE_MODESPRUNED         =$8000000
Const DISPLAY_DEVICE_REMOTE              =$4000000  
Const DISPLAY_DEVICE_DISCONNECT          =$2000000  


Const GCP_DBCS           =$001
Const GCP_REORDER        =$002
Const GCP_USEKERNING     =$008
Const GCP_GLYPHSHAPE     =$010
Const GCP_LIGATE         =$020
;;Const GCP_GLYPHINDEXING  =$080
Const GCP_DIACRITIC      =$100
Const GCP_KASHIDA        =$400
Const GCP_ERROR          =$8000
Const FLI_MASK           =$103B

Const GCP_JUSTIFY        =$0010000
;;Const GCP_NODIACRITICS   =$0020000L
Const FLI_GLYPHS         =$0040000
Const GCP_CLASSIN        =$0080000
Const GCP_MAXEXTENT      =$0100000
Const GCP_JUSTIFYIN      =$0200000
Const GCP_DISPLAYZWG      =$0400000
Const GCP_SYMSWAPOFF      =$0800000
Const GCP_NUMERICOVERRIDE =$1000000
Const GCP_NEUTRALOVERRIDE =$2000000
Const GCP_NUMERICSLATIN   =$4000000
Const GCP_NUMERICSLOCAL   =$8000000

Const GCPCLASS_LATIN                  =1
Const GCPCLASS_HEBREW                 =2
Const GCPCLASS_ARABIC                 =2
Const GCPCLASS_NEUTRAL                =3
Const GCPCLASS_LOCALNUMBER            =4
Const GCPCLASS_LATINNUMBER            =5
Const GCPCLASS_LATINNUMERICTERMINATOR =6
Const GCPCLASS_LATINNUMERICSEPARATOR  =7
Const GCPCLASS_NUMERICSEPARATOR       =8
Const GCPCLASS_PREBOUNDLTR         =$80
Const GCPCLASS_PREBOUNDRTL         =$40
Const GCPCLASS_POSTBOUNDLTR        =$20
Const GCPCLASS_POSTBOUNDRTL        =$10

Const GCPGLYPH_LINKBEFORE          =$8000
Const GCPGLYPH_LINKAFTER           =$4000


Const TT_AVAILABLE    =$001
Const TT_ENABLED      =$002
; pixel types */
Const PFD_TYPE_RGBA       = 0
Const PFD_TYPE_COLORINDEX = 1

; layer types */
Const PFD_MAIN_PLANE      = 0
Const PFD_OVERLAY_PLANE   = 1
Const PFD_UNDERLAY_PLANE  = (-1)

; PIXELFORMATDESCRIPTOR flags */
Const PFD_DOUBLEBUFFER            =$0000001
Const PFD_STEREO                  =$0000002
Const PFD_DRAW_TO_WINDOW          =$0000004
Const PFD_DRAW_TO_BITMAP          =$0000008
Const PFD_SUPPORT_GDI             =$0000010
Const PFD_SUPPORT_OPENGL          =$0000020
Const PFD_GENERIC_FORMAT          =$0000040
Const PFD_NEED_PALETTE            =$0000080
Const PFD_NEED_SYSTEM_PALETTE     =$0000100
Const PFD_SWAP_EXCHANGE           =$0000200
Const PFD_SWAP_COPY               =$0000400
Const PFD_SWAP_LAYER_BUFFERS      =$0000800
Const PFD_GENERIC_ACCELERATED     =$0001000
Const PFD_SUPPORT_DIRECTDRAW      =$0002000

; PIXELFORMATDESCRIPTOR flags for use in ChoosePixelFormat only */
Const PFD_DEPTH_DONTCARE          =$20000000
Const PFD_DOUBLEBUFFER_DONTCARE   =$40000000
Const PFD_STEREO_DONTCARE         =$80000000


; mode selections for the device mode function */
Const DM_UPDATE           =1
Const DM_COPY            =2
Const DM_PROMPT          =4
Const DM_MODIFY          =8

Const DM_IN_BUFFER      = DM_MODIFY
Const DM_IN_PROMPT       =DM_PROMPT
Const DM_OUT_BUFFER     = DM_COPY
Const DM_OUT_DEFAULT    = DM_UPDATE

; device capabilities indices */
Const DC_FIELDS         =  1
Const DC_PAPERS       =    2
Const DC_PAPERSIZE    =    3
Const DC_MINEXTENT     =   4
Const DC_MAXEXTENT    =    5
Const DC_BINS         =   6
Const DC_DUPLEX       =   7
Const DC_SIZE         =   8
Const DC_EXTRA        =   9
Const DC_VERSION       =  10
Const DC_DRIVER        =  11
Const DC_BINNAMES      =  12
Const DC_ENUMRESOLUTIONS = 13
Const DC_FILEDEPENDENCIES= 14
Const DC_TRUETYPE      =   15
Const DC_PAPERNAMES   =    16
Const DC_ORIENTATION =     17
Const DC_COPIES     =      18
;if(WINVER >= =$400)
Const DC_BINADJUST =           19
Const DC_EMF_COMPLIANT       = 20
Const DC_DATATYPE_PRODUCED  =  21
Const DC_COLLATE             = 22
Const DC_MANUFACTURER      =   23
Const DC_MODEL            =    24
;EndIf ; WINVER >= =$400 */

;if(WINVER >= =$500)
Const DC_PERSONALITY          =25
Const DC_PRINTRATE            =26
Const DC_PRINTRATEUNIT        =27
Const   PRINTRATEUNIT_PPM    = 1
Const   PRINTRATEUNIT_CPS    = 2
Const   PRINTRATEUNIT_LPM    = 3
Const   PRINTRATEUNIT_IPM    = 4
Const DC_PRINTERMEM          = 28
Const DC_MEDIAREADY          = 29
Const DC_STAPLE              = 30
Const DC_PRINTRATEPPM        = 31
Const DC_COLORDEVICE        =  32
Const DC_NUP                =  33
Const DC_MEDIATYPENAMES     =  34
Const DC_MEDIATYPES         =  35
;EndIf ; WINVER >= =$500 */

; bit fields of the return value (DWORD) for DC_TRUETYPE */
Const DCTT_BITMAP             =$000001
Const DCTT_DOWNLOAD           =$000002
Const DCTT_SUBDEV             =$000004
;if(WINVER >= =$400)
Const DCTT_DOWNLOAD_OUTLINE   =$000008

; return values for DC_BINADJUST */
Const DCBA_FACEUPNONE       =$000
Const DCBA_FACEUPCENTER     =$001
Const DCBA_FACEUPLEFT       =$002
Const DCBA_FACEUPRIGHT      =$003
Const DCBA_FACEDOWNNONE     =$100
Const DCBA_FACEDOWNCENTER   =$101
Const DCBA_FACEDOWNLEFT     =$102
Const DCBA_FACEDOWNRIGHT    =$103
;EndIf ; WINVER >= =$400 */

; flAccel flags for the GLYPHSET structure above */

Const GS_8BIT_INDICES     =$0000001

; flags for GetGlyphIndices */

Const GGI_MARK_NONEXISTING_GLYPHS  =$0001


Const MM_MAX_NUMAXES      =16


Const FR_PRIVATE     =$10
Const FR_NOT_ENUM    =$20


Const MM_MAX_AXES_NAMELEN =16


;
; currentlly defined blend function
;

Const AC_SRC_OVER                 =$0

;
; alpha format flags
;

Const AC_SRC_ALPHA                =$1


;
; gradient drawing modes
;

Const GRADIENT_FILL_RECT_H    =$0000000
Const GRADIENT_FILL_RECT_V    =$0000001
Const GRADIENT_FILL_TRIANGLE  =$0000002
Const GRADIENT_FILL_OP_FLAG   =$00000ff


; Flags value for COLORADJUSTMENT */
Const CA_NEGATIVE                 =$001
Const CA_LOG_FILTER               =$002

; IlluminantIndex values */
Const ILLUMINANT_DEVICE_DEFAULT   =0
Const ILLUMINANT_A                =1
Const ILLUMINANT_B                =2
Const ILLUMINANT_C                =3
Const ILLUMINANT_D50              =4
Const ILLUMINANT_D55              =5
Const ILLUMINANT_D65              =6
Const ILLUMINANT_D75              =7
Const ILLUMINANT_F2               =8
Const ILLUMINANT_MAX_INDEX        =ILLUMINANT_F2

Const ILLUMINANT_TUNGSTEN         =ILLUMINANT_A
Const ILLUMINANT_DAYLIGHT         =ILLUMINANT_C
Const ILLUMINANT_FLUORESCENT      =ILLUMINANT_F2
Const ILLUMINANT_NTSC             =ILLUMINANT_C

; Min and max for RedGamma, GreenGamma, BlueGamma */
Const RGB_GAMMA_MIN               =02500
Const RGB_GAMMA_MAX               =65000

; Min and max for ReferenceBlack and ReferenceWhite */
Const REFERENCE_WHITE_MIN         =6000
Const REFERENCE_WHITE_MAX         =10000
Const REFERENCE_BLACK_MIN         =0
Const REFERENCE_BLACK_MAX         =4000

; Min and max for Contrast, Brightness, Colorfulness, RedGreenTint */
Const COLOR_ADJ_MIN               =-100
Const COLOR_ADJ_MAX               =100

Const DI_APPBANDING               =$0000001
Const DI_ROPS_READ_DESTINATION    =$0000002
Const FONTMAPPER_MAX =10



;ifndef NOMETAFILE

; Enhanced metafile constants.

;ifndef _MAC
Const ENHMETA_SIGNATURE       =$464D4520
;else

Const ENHMETA_STOCK_OBJECT    =$80000000



Const EMR_HEADER                    =  1
Const EMR_POLYBEZIER                =  2
Const EMR_POLYGON                   =  3
Const EMR_POLYLINE                  =  4
Const EMR_POLYBEZIERTO              =  5
Const EMR_POLYLINETO                =  6
Const EMR_POLYPOLYLINE              =  7
Const EMR_POLYPOLYGON               =  8
Const EMR_SETWINDOWEXTEX            =  9
Const EMR_SETWINDOWORGEX            =  10
Const EMR_SETVIEWPORTEXTEX          =  11
Const EMR_SETVIEWPORTORGEX          =  12
Const EMR_SETBRUSHORGEX             =  13
Const EMR_EOF                       =  14
Const EMR_SETPIXELV                 =  15
Const EMR_SETMAPPERFLAGS            =  16
Const EMR_SETMAPMODE                =  17
Const EMR_SETBKMODE                 =  18
Const EMR_SETPOLYFILLMODE           =  19
Const EMR_SETROP2                   =  20
Const EMR_SETSTRETCHBLTMODE          = 21
Const EMR_SETTEXTALIGN               = 22
Const EMR_SETCOLORADJUSTMENT         = 23
Const EMR_SETTEXTCOLOR              =  24
Const EMR_SETBKCOLOR                =  25
Const EMR_OFFSETCLIPRGN             =  26
Const EMR_MOVETOEX                  =  27
Const EMR_SETMETARGN                =  28
Const EMR_EXCLUDECLIPRECT           =  29
Const EMR_INTERSECTCLIPRECT         =  30
Const EMR_SCALEVIEWPORTEXTEX         = 31
Const EMR_SCALEWINDOWEXTEX          =  32
Const EMR_SAVEDC                    =  33
Const EMR_RESTOREDC                 =  34
Const EMR_SETWORLDTRANSFORM        =   35
Const EMR_MODIFYWORLDTRANSFORM    =    36
Const EMR_SELECTOBJECT           =     37
Const EMR_CREATEPEN             =      38
Const EMR_CREATEBRUSHINDIRECT  =       39
Const EMR_DELETEOBJECT       =         40
Const EMR_ANGLEARC          =          41
Const EMR_ELLIPSE             =        42
Const EMR_RECTANGLE        =           43
Const EMR_ROUNDRECT               =    44
Const EMR_ARC                   =      45
Const EMR_CHORD                    =   46
Const EMR_PIE                  =       47
Const EMR_SELECTPALETTE       =        48
Const EMR_CREATEPALETTE      =         49
Const EMR_SETPALETTEENTRIES=           50
Const EMR_RESIZEPALETTE   =            51
Const EMR_REALIZEPALETTE =             52
Const EMR_EXTFLOODFILL      =          53
Const EMR_LINETO        =              54
Const EMR_ARCTO                      = 55
Const EMR_POLYDRAW                  =  56
Const EMR_SETARCDIRECTION          =   57
Const EMR_SETMITERLIMIT           =    58
Const EMR_BEGINPATH              =     59
Const EMR_ENDPATH                    = 60
Const EMR_CLOSEFIGURE                = 61
Const EMR_FILLPATH                   = 62
Const EMR_STROKEANDFILLPATH           =63
Const EMR_STROKEPATH                  =64
Const EMR_FLATTENPATH                = 65
Const EMR_WIDENPATH                  = 66
Const EMR_SELECTCLIPPATH             = 67
Const EMR_ABORTPATH                  = 68

Const EMR_GDICOMMENT                  =70
Const EMR_FILLRGN                     =71
Const EMR_FRAMERGN                    =72
Const EMR_INVERTRGN                   =73
Const EMR_PAINTRGN                    =74
Const EMR_EXTSELECTCLIPRGN            =75
Const EMR_BITBLT                      =76
Const EMR_STRETCHBLT                  =77
Const EMR_MASKBLT                     =78
Const EMR_PLGBLT                      =79
Const EMR_SETDIBITSTODEVICE          = 80
Const EMR_STRETCHDIBITS              = 81
Const EMR_EXTCREATEFONTINDIRECTW     = 82
Const EMR_EXTTEXTOUTA                = 83
Const EMR_EXTTEXTOUTW                = 84
Const EMR_POLYBEZIER16              =  85
Const EMR_POLYGON16                  = 86
Const EMR_POLYLINE16                 = 87
Const EMR_POLYBEZIERTO16              =88
Const EMR_POLYLINETO16                =89
Const EMR_POLYPOLYLINE16              =90
Const EMR_POLYPOLYGON16               =91
Const EMR_POLYDRAW16                 = 92
Const EMR_CREATEMONOBRUSH            = 93
Const EMR_CREATEDIBPATTERNBRUSHPT    = 94
Const EMR_EXTCREATEPEN               = 95
Const EMR_POLYTEXTOUTA               = 96
Const EMR_POLYTEXTOUTW              =  97

;if(WINVER >= =$400)
Const EMR_SETICMMODE               =   98
Const EMR_CREATECOLORSPACE        =    99
Const EMR_SETCOLORSPACE          =    100
Const EMR_DELETECOLORSPACE      =     101
Const EMR_GLSRECORD            =      102
Const EMR_GLSBOUNDEDRECORD    =       103
Const EMR_PIXELFORMAT        =        104
;EndIf ; WINVER >= =$400 */


Const SETICMPROFILE_EMBEDED           =$0000001


Const GDICOMMENT_IDENTIFIER           =$43494447
Const GDICOMMENT_WINDOWS_METAFILE     =$80000001
Const GDICOMMENT_BEGINGROUP           =$0000002
Const GDICOMMENT_ENDGROUP             =$0000003
Const GDICOMMENT_MULTIFORMATS         =$40000004
Const EPS_SIGNATURE                   =$46535045
Const GDICOMMENT_UNICODE_STRING       =$0000040
Const GDICOMMENT_UNICODE_END          =$0000080

Const WGL_FONT_LINES      =0
Const WGL_FONT_POLYGONS   =1

; LAYERPLANEDESCRIPTOR flags */
Const LPD_DOUBLEBUFFER        =$0000001
Const LPD_STEREO              =$0000002
Const LPD_SUPPORT_GDI         =$0000010
Const LPD_SUPPORT_OPENGL      =$0000020
Const LPD_SHARE_DEPTH         =$0000040
Const LPD_SHARE_STENCIL       =$0000080
Const LPD_SHARE_ACCUM         =$0000100
Const LPD_SWAP_EXCHANGE       =$0000200
Const LPD_SWAP_COPY           =$0000400
Const LPD_TRANSPARENT         =$0001000

Const LPD_TYPE_RGBA        =0
Const LPD_TYPE_COLORINDEX  =1

; wglSwapLayerBuffers flags */
Const WGL_SWAP_MAIN_PLANE     =$0000001
Const WGL_SWAP_OVERLAY1       =$0000002
Const WGL_SWAP_OVERLAY2       =$0000004
Const WGL_SWAP_OVERLAY3       =$0000008
Const WGL_SWAP_OVERLAY4       =$0000010
Const WGL_SWAP_OVERLAY5       =$0000020
Const WGL_SWAP_OVERLAY6       =$0000040
Const WGL_SWAP_OVERLAY7       =$0000080
Const WGL_SWAP_OVERLAY8       =$0000100
Const WGL_SWAP_OVERLAY9       =$0000200
Const WGL_SWAP_OVERLAY10      =$0000400
Const WGL_SWAP_OVERLAY11      =$0000800
Const WGL_SWAP_OVERLAY12      =$0001000
Const WGL_SWAP_OVERLAY13      =$0002000
Const WGL_SWAP_OVERLAY14      =$0004000
Const WGL_SWAP_OVERLAY15      =$0008000
Const WGL_SWAP_UNDERLAY1      =$0010000
Const WGL_SWAP_UNDERLAY2      =$0020000
Const WGL_SWAP_UNDERLAY3      =$0040000
Const WGL_SWAP_UNDERLAY4      =$0080000
Const WGL_SWAP_UNDERLAY5      =$0100000
Const WGL_SWAP_UNDERLAY6      =$0200000
Const WGL_SWAP_UNDERLAY7      =$0400000
Const WGL_SWAP_UNDERLAY8      =$0800000
Const WGL_SWAP_UNDERLAY9      =$1000000
Const WGL_SWAP_UNDERLAY10     =$2000000
Const WGL_SWAP_UNDERLAY11     =$4000000
Const WGL_SWAP_UNDERLAY12     =$8000000
Const WGL_SWAP_UNDERLAY13     =$10000000
Const WGL_SWAP_UNDERLAY14     =$20000000
Const WGL_SWAP_UNDERLAY15     =$40000000
