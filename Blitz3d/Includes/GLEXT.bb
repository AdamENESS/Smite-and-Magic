Const GL_GLEXT_VERSION= 16

;#ifndef GL_VERSION_1_2
Const GL_UNSIGNED_BYTE_3_3_2            =$8032
Const GL_UNSIGNED_SHORT_4_4_4_4         =$8033
Const GL_UNSIGNED_SHORT_5_5_5_1         =$8034
Const GL_UNSIGNED_INT_8_8_8_8           =$8035
Const GL_UNSIGNED_INT_10_10_10_2        =$8036
Const GL_RESCALE_NORMAL                 =$803A
Const GL_UNSIGNED_BYTE_2_3_3_REV        =$8362
Const GL_UNSIGNED_SHORT_5_6_5           =$8363
Const GL_UNSIGNED_SHORT_5_6_5_REV       =$8364
Const GL_UNSIGNED_SHORT_4_4_4_4_REV     =$8365
Const GL_UNSIGNED_SHORT_1_5_5_5_REV     =$8366
Const GL_UNSIGNED_INT_8_8_8_8_REV       =$8367
Const GL_UNSIGNED_INT_2_10_10_10_REV    =$8368
Const GL_BGR                            =$80E0
Const GL_BGRA                           =$80E1
Const GL_MAX_ELEMENTS_VERTICES          =$80E8
Const GL_MAX_ELEMENTS_INDICES           =$80E9
Const GL_CLAMP_TO_EDGE                  =$812F
Const GL_TEXTURE_MIN_LOD                =$813A
Const GL_TEXTURE_MAX_LOD                =$813B
Const GL_TEXTURE_BASE_LEVEL             =$813C
Const GL_TEXTURE_MAX_LEVEL              =$813D
Const GL_LIGHT_MODEL_COLOR_CONTROL      =$81F8
Const GL_SINGLE_COLOR                   =$81F9
Const GL_SEPARATE_SPECULAR_COLOR        =$81FA
Const GL_SMOOTH_POINT_SIZE_RANGE        =$0B12
Const GL_SMOOTH_POINT_SIZE_GRANULARITY  =$0B13
Const GL_SMOOTH_LINE_WIDTH_RANGE        =$0B22
Const GL_SMOOTH_LINE_WIDTH_GRANULARITY  =$0B23
Const GL_ALIASED_POINT_SIZE_RANGE       =$846D
Const GL_ALIASED_LINE_WIDTH_RANGE       =$846E
;#EndIf

;#ifndef GL_ARB_imaging
Const GL_CONSTANT_COLOR                 =$8001
Const GL_ONE_MINUS_CONSTANT_COLOR       =$8002
Const GL_CONSTANT_ALPHA                 =$8003
Const GL_ONE_MINUS_CONSTANT_ALPHA       =$8004
Const GL_BLEND_COLOR                    =$8005
Const GL_FUNC_ADD                       =$8006
Const GL_MIN                            =$8007
Const GL_MAX                            =$8008
Const GL_BLEND_EQUATION                 =$8009
Const GL_FUNC_SUBTRACT                  =$800A
Const GL_FUNC_REVERSE_SUBTRACT          =$800B
Const GL_CONVOLUTION_1D                 =$8010
Const GL_CONVOLUTION_2D                 =$8011
Const GL_SEPARABLE_2D                   =$8012
Const GL_CONVOLUTION_BORDER_MODE        =$8013
Const GL_CONVOLUTION_FILTER_SCALE       =$8014
Const GL_CONVOLUTION_FILTER_BIAS        =$8015
Const GL_REDUCE                         =$8016
Const GL_CONVOLUTION_FORMAT             =$8017
Const GL_CONVOLUTION_WIDTH              =$8018
Const GL_CONVOLUTION_HEIGHT             =$8019
Const GL_MAX_CONVOLUTION_WIDTH          =$801A
Const GL_MAX_CONVOLUTION_HEIGHT         =$801B
Const GL_POST_CONVOLUTION_RED_SCALE     =$801C
Const GL_POST_CONVOLUTION_GREEN_SCALE   =$801D
Const GL_POST_CONVOLUTION_BLUE_SCALE    =$801E
Const GL_POST_CONVOLUTION_ALPHA_SCALE   =$801F
Const GL_POST_CONVOLUTION_RED_BIAS      =$8020
Const GL_POST_CONVOLUTION_GREEN_BIAS    =$8021
Const GL_POST_CONVOLUTION_BLUE_BIAS     =$8022
Const GL_POST_CONVOLUTION_ALPHA_BIAS    =$8023
Const GL_HISTOGRAM                      =$8024
Const GL_PROXY_HISTOGRAM                =$8025
Const GL_HISTOGRAM_WIDTH                =$8026
Const GL_HISTOGRAM_FORMAT               =$8027
Const GL_HISTOGRAM_RED_SIZE             =$8028
Const GL_HISTOGRAM_GREEN_SIZE           =$8029
Const GL_HISTOGRAM_BLUE_SIZE            =$802A
Const GL_HISTOGRAM_ALPHA_SIZE           =$802B
Const GL_HISTOGRAM_LUMINANCE_SIZE       =$802C
Const GL_HISTOGRAM_SINK                 =$802D
Const GL_MINMAX                         =$802E
Const GL_MINMAX_FORMAT                  =$802F
Const GL_MINMAX_SINK                    =$8030
Const GL_TABLE_TOO_LARGE                =$8031
Const GL_COLOR_MATRIX                   =$80B1
Const GL_COLOR_MATRIX_STACK_DEPTH       =$80B2
Const GL_MAX_COLOR_MATRIX_STACK_DEPTH   =$80B3
Const GL_POST_COLOR_MATRIX_RED_SCALE    =$80B4
Const GL_POST_COLOR_MATRIX_GREEN_SCALE  =$80B5
Const GL_POST_COLOR_MATRIX_BLUE_SCALE   =$80B6
Const GL_POST_COLOR_MATRIX_ALPHA_SCALE  =$80B7
Const GL_POST_COLOR_MATRIX_RED_BIAS     =$80B8
Const GL_POST_COLOR_MATRIX_GREEN_BIAS   =$80B9
Const GL_POST_COLOR_MATRIX_BLUE_BIAS    =$80BA
Const GL_POST_COLOR_MATIX_ALPHA_BIAS    =$80BB
Const GL_COLOR_TABLE                    =$80D0
Const GL_POST_CONVOLUTION_COLOR_TABLE   =$80D1
Const GL_POST_COLOR_MATRIX_COLOR_TABLE  =$80D2
Const GL_PROXY_COLOR_TABLE              =$80D3
Const GL_PROXY_POST_CONVOLUTION_COLOR_TABLE =$80D4
Const GL_PROXY_POST_COLOR_MATRIX_COLOR_TABLE =$80D5
Const GL_COLOR_TABLE_SCALE              =$80D6
Const GL_COLOR_TABLE_BIAS               =$80D7
Const GL_COLOR_TABLE_FORMAT             =$80D8
Const GL_COLOR_TABLE_WIDTH              =$80D9
Const GL_COLOR_TABLE_RED_SIZE           =$80DA
Const GL_COLOR_TABLE_GREEN_SIZE         =$80DB
Const GL_COLOR_TABLE_BLUE_SIZE          =$80DC
Const GL_COLOR_TABLE_ALPHA_SIZE         =$80DD
Const GL_COLOR_TABLE_LUMINANCE_SIZE     =$80DE
Const GL_COLOR_TABLE_INTENSITY_SIZE     =$80DF
Const GL_IGNORE_BORDER                  =$8150
Const GL_CONSTANT_BORDER                =$8151
Const GL_WRAP_BORDER                    =$8152
Const GL_REPLICATE_BORDER               =$8153
Const GL_CONVOLUTION_BORDER_COLOR       =$8154
;#EndIf

;#ifndef GL_VERSION_1_3
Const GL_TEXTURE0                       =$84C0
Const GL_TEXTURE1                       =$84C1
Const GL_TEXTURE2                       =$84C2
Const GL_TEXTURE3                       =$84C3
Const GL_TEXTURE4                       =$84C4
Const GL_TEXTURE5                       =$84C5
Const GL_TEXTURE6                       =$84C6
Const GL_TEXTURE7                       =$84C7
Const GL_TEXTURE8                       =$84C8
Const GL_TEXTURE9                       =$84C9
Const GL_TEXTURE10                      =$84CA
Const GL_TEXTURE11                      =$84CB
Const GL_TEXTURE12                      =$84CC
Const GL_TEXTURE13                      =$84CD
Const GL_TEXTURE14                      =$84CE
Const GL_TEXTURE15                      =$84CF
Const GL_TEXTURE16                      =$84D0
Const GL_TEXTURE17                      =$84D1
Const GL_TEXTURE18                      =$84D2
Const GL_TEXTURE19                      =$84D3
Const GL_TEXTURE20                      =$84D4
Const GL_TEXTURE21                      =$84D5
Const GL_TEXTURE22                      =$84D6
Const GL_TEXTURE23                      =$84D7
Const GL_TEXTURE24                      =$84D8
Const GL_TEXTURE25                      =$84D9
Const GL_TEXTURE26                      =$84DA
Const GL_TEXTURE27                      =$84DB
Const GL_TEXTURE28                      =$84DC
Const GL_TEXTURE29                      =$84DD
Const GL_TEXTURE30                      =$84DE
Const GL_TEXTURE31                      =$84DF
Const GL_ACTIVE_TEXTURE                 =$84E0
Const GL_CLIENT_ACTIVE_TEXTURE          =$84E1
Const GL_MAX_TEXTURE_UNITS              =$84E2
Const GL_TRANSPOSE_MODELVIEW_MATRIX     =$84E3
Const GL_TRANSPOSE_PROJECTION_MATRIX    =$84E4
Const GL_TRANSPOSE_TEXTURE_MATRIX       =$84E5
Const GL_TRANSPOSE_COLOR_MATRIX         =$84E6
Const GL_MULTISAMPLE                    =$809D
Const GL_SAMPLE_ALPHA_TO_COVERAGE       =$809E
Const GL_SAMPLE_ALPHA_TO_ONE            =$809F
Const GL_SAMPLE_COVERAGE                =$80A0
Const GL_SAMPLE_BUFFERS                 =$80A8
Const GL_SAMPLES                        =$80A9
Const GL_SAMPLE_COVERAGE_VALUE          =$80AA
Const GL_SAMPLE_COVERAGE_INVERT         =$80AB
Const GL_MULTISAMPLE_BIT                =$20000000
Const GL_NORMAL_MAP                     =$8511
Const GL_REFLECTION_MAP                 =$8512
Const GL_TEXTURE_CUBE_MAP               =$8513
Const GL_TEXTURE_BINDING_CUBE_MAP       =$8514
Const GL_TEXTURE_CUBE_MAP_POSITIVE_X    =$8515
Const GL_TEXTURE_CUBE_MAP_NEGATIVE_X    =$8516
Const GL_TEXTURE_CUBE_MAP_POSITIVE_Y    =$8517
Const GL_TEXTURE_CUBE_MAP_NEGATIVE_Y    =$8518
Const GL_TEXTURE_CUBE_MAP_POSITIVE_Z    =$8519
Const GL_TEXTURE_CUBE_MAP_NEGATIVE_Z    =$851A
Const GL_PROXY_TEXTURE_CUBE_MAP         =$851B
Const GL_MAX_CUBE_MAP_TEXTURE_SIZE      =$851C
Const GL_COMPRESSED_ALPHA               =$84E9
Const GL_COMPRESSED_LUMINANCE           =$84EA
Const GL_COMPRESSED_LUMINANCE_ALPHA     =$84EB
Const GL_COMPRESSED_INTENSITY           =$84EC
Const GL_COMPRESSED_RGB                 =$84ED
Const GL_COMPRESSED_RGBA                =$84EE
Const GL_TEXTURE_COMPRESSION_HINT       =$84EF
Const GL_TEXTURE_COMPRESSED_IMAGE_SIZE  =$86A0
Const GL_TEXTURE_COMPRESSED             =$86A1
Const GL_NUM_COMPRESSED_TEXTURE_FORMATS =$86A2
Const GL_COMPRESSED_TEXTURE_FORMATS     =$86A3
Const GL_CLAMP_TO_BORDER                =$812D
Const GL_CLAMP_TO_BORDER_SGIS           =$812D
Const GL_COMBINE                        =$8570
Const GL_COMBINE_RGB                    =$8571
Const GL_COMBINE_ALPHA                  =$8572
Const GL_SOURCE0_RGB                    =$8580
Const GL_SOURCE1_RGB                    =$8581
Const GL_SOURCE2_RGB                    =$8582
Const GL_SOURCE0_ALPHA                  =$8588
Const GL_SOURCE1_ALPHA                  =$8589
Const GL_SOURCE2_ALPHA                  =$858A
Const GL_OPERAND0_RGB                   =$8590
Const GL_OPERAND1_RGB                   =$8591
Const GL_OPERAND2_RGB                   =$8592
Const GL_OPERAND0_ALPHA                 =$8598
Const GL_OPERAND1_ALPHA                 =$8599
Const GL_OPERAND2_ALPHA                 =$859A
Const GL_RGB_SCALE                      =$8573
Const GL_ADD_SIGNED                     =$8574
Const GL_INTERPOLATE                    =$8575
Const GL_SUBTRACT                       =$84E7
Const GL_CONSTANT                       =$8576
Const GL_PRIMARY_COLOR                  =$8577
Const GL_PREVIOUS                       =$8578
Const GL_DOT3_RGB                       =$86AE
Const GL_DOT3_RGBA                      =$86AF
;#EndIf

;#ifndef GL_ARB_multitexture
Const GL_TEXTURE0_ARB                   =$84C0
Const GL_TEXTURE1_ARB                   =$84C1
Const GL_TEXTURE2_ARB                   =$84C2
Const GL_TEXTURE3_ARB                   =$84C3
Const GL_TEXTURE4_ARB                   =$84C4
Const GL_TEXTURE5_ARB                   =$84C5
Const GL_TEXTURE6_ARB                   =$84C6
Const GL_TEXTURE7_ARB                   =$84C7
Const GL_TEXTURE8_ARB                   =$84C8
Const GL_TEXTURE9_ARB                   =$84C9
Const GL_TEXTURE10_ARB                  =$84CA
Const GL_TEXTURE11_ARB                  =$84CB
Const GL_TEXTURE12_ARB                  =$84CC
Const GL_TEXTURE13_ARB                  =$84CD
Const GL_TEXTURE14_ARB                  =$84CE
Const GL_TEXTURE15_ARB                  =$84CF
Const GL_TEXTURE16_ARB                  =$84D0
Const GL_TEXTURE17_ARB                  =$84D1
Const GL_TEXTURE18_ARB                  =$84D2
Const GL_TEXTURE19_ARB                  =$84D3
Const GL_TEXTURE20_ARB                  =$84D4
Const GL_TEXTURE21_ARB                  =$84D5
Const GL_TEXTURE22_ARB                  =$84D6
Const GL_TEXTURE23_ARB                  =$84D7
Const GL_TEXTURE24_ARB                  =$84D8
Const GL_TEXTURE25_ARB                  =$84D9
Const GL_TEXTURE26_ARB                  =$84DA
Const GL_TEXTURE27_ARB                  =$84DB
Const GL_TEXTURE28_ARB                  =$84DC
Const GL_TEXTURE29_ARB                  =$84DD
Const GL_TEXTURE30_ARB                  =$84DE
Const GL_TEXTURE31_ARB                  =$84DF
Const GL_ACTIVE_TEXTURE_ARB             =$84E0
Const GL_CLIENT_ACTIVE_TEXTURE_ARB      =$84E1
Const GL_MAX_TEXTURE_UNITS_ARB          =$84E2
;#EndIf

;#ifndef GL_ARB_transpose_matrix
Const GL_TRANSPOSE_MODELVIEW_MATRIX_ARB =$84E3
Const GL_TRANSPOSE_PROJECTION_MATRIX_ARB =$84E4
Const GL_TRANSPOSE_TEXTURE_MATRIX_ARB   =$84E5
Const GL_TRANSPOSE_COLOR_MATRIX_ARB     =$84E6
;#EndIf

;#ifndef GL_ARB_multisample
Const GL_MULTISAMPLE_ARB                =$809D
Const GL_SAMPLE_ALPHA_TO_COVERAGE_ARB   =$809E
Const GL_SAMPLE_ALPHA_TO_ONE_ARB        =$809F
Const GL_SAMPLE_COVERAGE_ARB            =$80A0
Const GL_SAMPLE_BUFFERS_ARB             =$80A8
Const GL_SAMPLES_ARB                    =$80A9
Const GL_SAMPLE_COVERAGE_VALUE_ARB      =$80AA
Const GL_SAMPLE_COVERAGE_INVERT_ARB     =$80AB
Const GL_MULTISAMPLE_BIT_ARB            =$20000000
;#EndIf

;#ifndef GL_ARB_texture_env_add
;#EndIf

;#ifndef GL_ARB_texture_cube_map
Const GL_NORMAL_MAP_ARB                 =$8511
Const GL_REFLECTION_MAP_ARB             =$8512
Const GL_TEXTURE_CUBE_MAP_ARB           =$8513
Const GL_TEXTURE_BINDING_CUBE_MAP_ARB   =$8514
Const GL_TEXTURE_CUBE_MAP_POSITIVE_X_ARB =$8515
Const GL_TEXTURE_CUBE_MAP_NEGATIVE_X_ARB =$8516
Const GL_TEXTURE_CUBE_MAP_POSITIVE_Y_ARB =$8517
Const GL_TEXTURE_CUBE_MAP_NEGATIVE_Y_ARB =$8518
Const GL_TEXTURE_CUBE_MAP_POSITIVE_Z_ARB =$8519
Const GL_TEXTURE_CUBE_MAP_NEGATIVE_Z_ARB =$851A
Const GL_PROXY_TEXTURE_CUBE_MAP_ARB     =$851B
Const GL_MAX_CUBE_MAP_TEXTURE_SIZE_ARB  =$851C
;#EndIf

;#ifndef GL_ARB_texture_compression
Const GL_COMPRESSED_ALPHA_ARB           =$84E9
Const GL_COMPRESSED_LUMINANCE_ARB       =$84EA
Const GL_COMPRESSED_LUMINANCE_ALPHA_ARB =$84EB
Const GL_COMPRESSED_INTENSITY_ARB       =$84EC
Const GL_COMPRESSED_RGB_ARB             =$84ED
Const GL_COMPRESSED_RGBA_ARB            =$84EE
Const GL_TEXTURE_COMPRESSION_HINT_ARB   =$84EF
Const GL_TEXTURE_COMPRESSED_IMAGE_SIZE_ARB =$86A0
Const GL_TEXTURE_COMPRESSED_ARB         =$86A1
Const GL_NUM_COMPRESSED_TEXTURE_FORMATS_ARB =$86A2
Const GL_COMPRESSED_TEXTURE_FORMATS_ARB =$86A3
;#EndIf

;#ifndef GL_ARB_texture_border_clamp
Const GL_CLAMP_TO_BORDER_ARB            =$812D
;#EndIf

;#ifndef GL_ARB_point_parameters
Const GL_POINT_SIZE_MIN_ARB             =$8126
Const GL_POINT_SIZE_MIN_EXT             =$8126
Const GL_POINT_SIZE_MIN_SGIS            =$8126
Const GL_POINT_SIZE_MAX_ARB             =$8127
Const GL_POINT_SIZE_MAX_EXT             =$8127
Const GL_POINT_SIZE_MAX_SGIS            =$8127
Const GL_POINT_FADE_THRESHOLD_SIZE_ARB  =$8128
Const GL_POINT_FADE_THRESHOLD_SIZE_EXT  =$8128
Const GL_POINT_FADE_THRESHOLD_SIZE_SGIS =$8128
Const GL_POINT_DISTANCE_ATTENUATION_ARB =$8129
Const GL_DISTANCE_ATTENUATION_EXT       =$8129
Const GL_DISTANCE_ATTENUATION_SGIS      =$8129
;#EndIf

;#ifndef GL_ARB_vertex_blend
Const GL_MAX_VERTEX_UNITS_ARB           =$86A4
Const GL_ACTIVE_VERTEX_UNITS_ARB        =$86A5
Const GL_WEIGHT_SUM_UNITY_ARB           =$86A6
Const GL_VERTEX_BLEND_ARB               =$86A7
Const GL_CURRENT_WEIGHT_ARB             =$86A8
Const GL_WEIGHT_ARRAY_TYPE_ARB          =$86A9
Const GL_WEIGHT_ARRAY_STRIDE_ARB        =$86AA
Const GL_WEIGHT_ARRAY_SIZE_ARB          =$86AB
Const GL_WEIGHT_ARRAY_POINTER_ARB       =$86AC
Const GL_WEIGHT_ARRAY_ARB               =$86AD
Const GL_MODELVIEW0_ARB                 =$1700
Const GL_MODELVIEW1_ARB                 =$850A
Const GL_MODELVIEW2_ARB                 =$8722
Const GL_MODELVIEW3_ARB                 =$8723
Const GL_MODELVIEW4_ARB                 =$8724
Const GL_MODELVIEW5_ARB                 =$8725
Const GL_MODELVIEW6_ARB                 =$8726
Const GL_MODELVIEW7_ARB                 =$8727
Const GL_MODELVIEW8_ARB                 =$8728
Const GL_MODELVIEW9_ARB                 =$8729
Const GL_MODELVIEW10_ARB                =$872A
Const GL_MODELVIEW11_ARB                =$872B
Const GL_MODELVIEW12_ARB                =$872C
Const GL_MODELVIEW13_ARB                =$872D
Const GL_MODELVIEW14_ARB                =$872E
Const GL_MODELVIEW15_ARB                =$872F
Const GL_MODELVIEW16_ARB                =$8730
Const GL_MODELVIEW17_ARB                =$8731
Const GL_MODELVIEW18_ARB                =$8732
Const GL_MODELVIEW19_ARB                =$8733
Const GL_MODELVIEW20_ARB                =$8734
Const GL_MODELVIEW21_ARB                =$8735
Const GL_MODELVIEW22_ARB                =$8736
Const GL_MODELVIEW23_ARB                =$8737
Const GL_MODELVIEW24_ARB                =$8738
Const GL_MODELVIEW25_ARB                =$8739
Const GL_MODELVIEW26_ARB                =$873A
Const GL_MODELVIEW27_ARB                =$873B
Const GL_MODELVIEW28_ARB                =$873C
Const GL_MODELVIEW29_ARB                =$873D
Const GL_MODELVIEW30_ARB                =$873E
Const GL_MODELVIEW31_ARB                =$873F
;#EndIf

;#ifndef GL_ARB_matrix_palette
Const GL_MATRIX_PALETTE_ARB             =$8840
Const GL_MAX_MATRIX_PALETTE_STACK_DEPTH_ARB =$8841
Const GL_MAX_PALETTE_MATRICES_ARB       =$8842
Const GL_CURRENT_PALETTE_MATRIX_ARB     =$8843
Const GL_MATRIX_INDEX_ARRAY_ARB         =$8844
Const GL_CURRENT_MATRIX_INDEX_ARB       =$8845
Const GL_MATRIX_INDEX_ARRAY_SIZE_ARB    =$8846
Const GL_MATRIX_INDEX_ARRAY_TYPE_ARB    =$8847
Const GL_MATRIX_INDEX_ARRAY_STRIDE_ARB  =$8848
Const GL_MATRIX_INDEX_ARRAY_POINTER_ARB =$8849
;#EndIf

;#ifndef GL_ARB_texture_env_combine
Const GL_COMBINE_ARB                    =$8570
Const GL_COMBINE_RGB_ARB                =$8571
Const GL_COMBINE_ALPHA_ARB              =$8572
Const GL_SOURCE0_RGB_ARB                =$8580
Const GL_SOURCE1_RGB_ARB                =$8581
Const GL_SOURCE2_RGB_ARB                =$8582
Const GL_SOURCE0_ALPHA_ARB              =$8588
Const GL_SOURCE1_ALPHA_ARB              =$8589
Const GL_SOURCE2_ALPHA_ARB              =$858A
Const GL_OPERAND0_RGB_ARB               =$8590
Const GL_OPERAND1_RGB_ARB               =$8591
Const GL_OPERAND2_RGB_ARB               =$8592
Const GL_OPERAND0_ALPHA_ARB             =$8598
Const GL_OPERAND1_ALPHA_ARB             =$8599
Const GL_OPERAND2_ALPHA_ARB             =$859A
Const GL_RGB_SCALE_ARB                  =$8573
Const GL_ADD_SIGNED_ARB                 =$8574
Const GL_INTERPOLATE_ARB                =$8575
Const GL_SUBTRACT_ARB                   =$84E7
Const GL_CONSTANT_ARB                   =$8576
Const GL_PRIMARY_COLOR_ARB              =$8577
Const GL_PREVIOUS_ARB                   =$8578
;#EndIf

;#ifndef GL_ARB_texture_env_crossbar
;#EndIf

;#ifndef GL_ARB_texture_env_dot3
Const GL_DOT3_RGB_ARB                   =$86AE
Const GL_DOT3_RGBA_ARB                  =$86AF
;#EndIf

;#ifndef GL_ARB_texture_mirrored_repeat
Const GL_MIRRORED_REPEAT_ARB            =$8370
;#EndIf

;#ifndef GL_ARB_depth_texture
Const GL_DEPTH_COMPONENT16_ARB          =$81A5
Const GL_DEPTH_COMPONENT24_ARB          =$81A6
Const GL_DEPTH_COMPONENT32_ARB          =$81A7
Const GL_TEXTURE_DEPTH_SIZE_ARB         =$884A
Const GL_DEPTH_TEXTURE_MODE_ARB         =$884B
;#EndIf

;#ifndef GL_ARB_shadow
Const GL_TEXTURE_COMPARE_MODE_ARB       =$884C
Const GL_TEXTURE_COMPARE_FUNC_ARB       =$884D
Const GL_COMPARE_R_TO_TEXTURE_ARB       =$884E
;#EndIf

;#ifndef GL_ARB_shadow_ambient
Const GL_TEXTURE_COMPARE_FAIL_VALUE_ARB =$80BF
;#EndIf

;#ifndef GL_ARB_window_pos
;#EndIf

;#ifndef GL_EXT_abgr
Const GL_ABGR_EXT                       =$8000
;#EndIf

;#ifndef GL_EXT_blend_color
Const GL_CONSTANT_COLOR_EXT             =$8001
Const GL_ONE_MINUS_CONSTANT_COLOR_EXT   =$8002
Const GL_CONSTANT_ALPHA_EXT             =$8003
Const GL_ONE_MINUS_CONSTANT_ALPHA_EXT   =$8004
Const GL_BLEND_COLOR_EXT                =$8005
;#EndIf

;#ifndef GL_EXT_polygon_offset
Const GL_POLYGON_OFFSET_EXT             =$8037
Const GL_POLYGON_OFFSET_FACTOR_EXT      =$8038
Const GL_POLYGON_OFFSET_BIAS_EXT        =$8039
;#EndIf

;#ifndef GL_EXT_texture
Const GL_ALPHA4_EXT                     =$803B
Const GL_ALPHA8_EXT                     =$803C
Const GL_ALPHA12_EXT                    =$803D
Const GL_ALPHA16_EXT                    =$803E
Const GL_LUMINANCE4_EXT                 =$803F
Const GL_LUMINANCE8_EXT                 =$8040
Const GL_LUMINANCE12_EXT                =$8041
Const GL_LUMINANCE16_EXT                =$8042
Const GL_LUMINANCE4_ALPHA4_EXT          =$8043
Const GL_LUMINANCE6_ALPHA2_EXT          =$8044
Const GL_LUMINANCE8_ALPHA8_EXT          =$8045
Const GL_LUMINANCE12_ALPHA4_EXT         =$8046
Const GL_LUMINANCE12_ALPHA12_EXT        =$8047
Const GL_LUMINANCE16_ALPHA16_EXT        =$8048
Const GL_INTENSITY_EXT                  =$8049
Const GL_INTENSITY4_EXT                 =$804A
Const GL_INTENSITY8_EXT                 =$804B
Const GL_INTENSITY12_EXT                =$804C
Const GL_INTENSITY16_EXT                =$804D
Const GL_RGB2_EXT                       =$804E
Const GL_RGB4_EXT                       =$804F
Const GL_RGB5_EXT                       =$8050
Const GL_RGB8_EXT                       =$8051
Const GL_RGB10_EXT                      =$8052
Const GL_RGB12_EXT                      =$8053
Const GL_RGB16_EXT                      =$8054
Const GL_RGBA2_EXT                      =$8055
Const GL_RGBA4_EXT                      =$8056
Const GL_RGB5_A1_EXT                    =$8057
Const GL_RGBA8_EXT                      =$8058
Const GL_RGB10_A2_EXT                   =$8059
Const GL_RGBA12_EXT                     =$805A
Const GL_RGBA16_EXT                     =$805B
Const GL_TEXTURE_RED_SIZE_EXT           =$805C
Const GL_TEXTURE_GREEN_SIZE_EXT         =$805D
Const GL_TEXTURE_BLUE_SIZE_EXT          =$805E
Const GL_TEXTURE_ALPHA_SIZE_EXT         =$805F
Const GL_TEXTURE_LUMINANCE_SIZE_EXT     =$8060
Const GL_TEXTURE_INTENSITY_SIZE_EXT     =$8061
Const GL_REPLACE_EXT                    =$8062
Const GL_PROXY_TEXTURE_1D_EXT           =$8063
Const GL_PROXY_TEXTURE_2D_EXT           =$8064
Const GL_TEXTURE_TOO_LARGE_EXT          =$8065
;#EndIf

;#ifndef GL_EXT_texture3D
Const GL_PACK_SKIP_IMAGES               =$806B
Const GL_PACK_SKIP_IMAGES_EXT           =$806B
Const GL_PACK_IMAGE_HEIGHT              =$806C
Const GL_PACK_IMAGE_HEIGHT_EXT          =$806C
Const GL_UNPACK_SKIP_IMAGES             =$806D
Const GL_UNPACK_SKIP_IMAGES_EXT         =$806D
Const GL_UNPACK_IMAGE_HEIGHT            =$806E
Const GL_UNPACK_IMAGE_HEIGHT_EXT        =$806E
Const GL_TEXTURE_3D                     =$806F
Const GL_TEXTURE_3D_EXT                 =$806F
Const GL_PROXY_TEXTURE_3D               =$8070
Const GL_PROXY_TEXTURE_3D_EXT           =$8070
Const GL_TEXTURE_DEPTH                  =$8071
Const GL_TEXTURE_DEPTH_EXT              =$8071
Const GL_TEXTURE_WRAP_R                 =$8072
Const GL_TEXTURE_WRAP_R_EXT             =$8072
Const GL_MAX_3D_TEXTURE_SIZE            =$8073
Const GL_MAX_3D_TEXTURE_SIZE_EXT        =$8073
;#EndIf

;#ifndef GL_SGIS_texture_filter4
Const GL_FILTER4_SGIS                   =$8146
Const GL_TEXTURE_FILTER4_SIZE_SGIS      =$8147
;#EndIf

;#ifndef GL_EXT_subtexture
;#EndIf

;#ifndef GL_EXT_copy_texture
;#EndIf

;#ifndef GL_EXT_histogram
Const GL_HISTOGRAM_EXT                  =$8024
Const GL_PROXY_HISTOGRAM_EXT            =$8025
Const GL_HISTOGRAM_WIDTH_EXT            =$8026
Const GL_HISTOGRAM_FORMAT_EXT           =$8027
Const GL_HISTOGRAM_RED_SIZE_EXT         =$8028
Const GL_HISTOGRAM_GREEN_SIZE_EXT       =$8029
Const GL_HISTOGRAM_BLUE_SIZE_EXT        =$802A
Const GL_HISTOGRAM_ALPHA_SIZE_EXT       =$802B
Const GL_HISTOGRAM_LUMINANCE_SIZE_EXT   =$802C
Const GL_HISTOGRAM_SINK_EXT             =$802D
Const GL_MINMAX_EXT                     =$802E
Const GL_MINMAX_FORMAT_EXT              =$802F
Const GL_MINMAX_SINK_EXT                =$8030
Const GL_TABLE_TOO_LARGE_EXT            =$8031
;#EndIf

;#ifndef GL_EXT_convolution
Const GL_CONVOLUTION_1D_EXT             =$8010
Const GL_CONVOLUTION_2D_EXT             =$8011
Const GL_SEPARABLE_2D_EXT               =$8012
Const GL_CONVOLUTION_BORDER_MODE_EXT    =$8013
Const GL_CONVOLUTION_FILTER_SCALE_EXT   =$8014
Const GL_CONVOLUTION_FILTER_BIAS_EXT    =$8015
Const GL_REDUCE_EXT                     =$8016
Const GL_CONVOLUTION_FORMAT_EXT         =$8017
Const GL_CONVOLUTION_WIDTH_EXT          =$8018
Const GL_CONVOLUTION_HEIGHT_EXT         =$8019
Const GL_MAX_CONVOLUTION_WIDTH_EXT      =$801A
Const GL_MAX_CONVOLUTION_HEIGHT_EXT     =$801B
Const GL_POST_CONVOLUTION_RED_SCALE_EXT =$801C
Const GL_POST_CONVOLUTION_GREEN_SCALE_EXT =$801D
Const GL_POST_CONVOLUTION_BLUE_SCALE_EXT =$801E
Const GL_POST_CONVOLUTION_ALPHA_SCALE_EXT =$801F
Const GL_POST_CONVOLUTION_RED_BIAS_EXT  =$8020
Const GL_POST_CONVOLUTION_GREEN_BIAS_EXT =$8021
Const GL_POST_CONVOLUTION_BLUE_BIAS_EXT =$8022
Const GL_POST_CONVOLUTION_ALPHA_BIAS_EXT =$8023
;#EndIf

;#ifndef GL_SGI_color_matrix
Const GL_COLOR_MATRIX_SGI               =$80B1
Const GL_COLOR_MATRIX_STACK_DEPTH_SGI   =$80B2
Const GL_MAX_COLOR_MATRIX_STACK_DEPTH_SGI =$80B3
Const GL_POST_COLOR_MATRIX_RED_SCALE_SGI =$80B4
Const GL_POST_COLOR_MATRIX_GREEN_SCALE_SGI =$80B5
Const GL_POST_COLOR_MATRIX_BLUE_SCALE_SGI =$80B6
Const GL_POST_COLOR_MATRIX_ALPHA_SCALE_SGI =$80B7
Const GL_POST_COLOR_MATRIX_RED_BIAS_SGI =$80B8
Const GL_POST_COLOR_MATRIX_GREEN_BIAS_SGI =$80B9
Const GL_POST_COLOR_MATRIX_BLUE_BIAS_SGI =$80BA
Const GL_POST_COLOR_MATRIX_ALPHA_BIAS_SGI =$80BB
;#EndIf

;#ifndef GL_SGI_color_table
Const GL_COLOR_TABLE_SGI                =$80D0
Const GL_POST_CONVOLUTION_COLOR_TABLE_SGI =$80D1
Const GL_POST_COLOR_MATRIX_COLOR_TABLE_SGI =$80D2
Const GL_PROXY_COLOR_TABLE_SGI          =$80D3
Const GL_PROXY_POST_CONVOLUTION_COLOR_TABLE_SGI =$80D4
Const GL_PROXY_POST_COLOR_MATRIX_COLOR_TABLE_SGI =$80D5
Const GL_COLOR_TABLE_SCALE_SGI          =$80D6
Const GL_COLOR_TABLE_BIAS_SGI           =$80D7
Const GL_COLOR_TABLE_FORMAT_SGI         =$80D8
Const GL_COLOR_TABLE_WIDTH_SGI          =$80D9
Const GL_COLOR_TABLE_RED_SIZE_SGI       =$80DA
Const GL_COLOR_TABLE_GREEN_SIZE_SGI     =$80DB
Const GL_COLOR_TABLE_BLUE_SIZE_SGI      =$80DC
Const GL_COLOR_TABLE_ALPHA_SIZE_SGI     =$80DD
Const GL_COLOR_TABLE_LUMINANCE_SIZE_SGI =$80DE
Const GL_COLOR_TABLE_INTENSITY_SIZE_SGI =$80DF
;#EndIf

;#ifndef GL_SGIS_pixel_texture
Const GL_PIXEL_TEXTURE_SGIS             =$8353
Const GL_PIXEL_FRAGMENT_RGB_SOURCE_SGIS =$8354
Const GL_PIXEL_FRAGMENT_ALPHA_SOURCE_SGIS =$8355
Const GL_PIXEL_GROUP_COLOR_SGIS         =$8356
;#EndIf

;#ifndef GL_SGIX_pixel_texture
Const GL_PIXEL_TEX_GEN_SGIX             =$8139
Const GL_PIXEL_TEX_GEN_MODE_SGIX        =$832B
;#EndIf

;#ifndef GL_SGIS_texture4D
Const GL_PACK_SKIP_VOLUMES_SGIS         =$8130
Const GL_PACK_IMAGE_DEPTH_SGIS          =$8131
Const GL_UNPACK_SKIP_VOLUMES_SGIS       =$8132
Const GL_UNPACK_IMAGE_DEPTH_SGIS        =$8133
Const GL_TEXTURE_4D_SGIS                =$8134
Const GL_PROXY_TEXTURE_4D_SGIS          =$8135
Const GL_TEXTURE_4DSIZE_SGIS            =$8136
Const GL_TEXTURE_WRAP_Q_SGIS            =$8137
Const GL_MAX_4D_TEXTURE_SIZE_SGIS       =$8138
Const GL_TEXTURE_4D_BINDING_SGIS        =$814F
;#EndIf

;#ifndef GL_SGI_texture_color_table
Const GL_TEXTURE_COLOR_TABLE_SGI        =$80BC
Const GL_PROXY_TEXTURE_COLOR_TABLE_SGI  =$80BD
;#EndIf

;#ifndef GL_EXT_cmyka
Const GL_CMYK_EXT                       =$800C
Const GL_CMYKA_EXT                      =$800D
Const GL_PACK_CMYK_HINT_EXT             =$800E
Const GL_UNPACK_CMYK_HINT_EXT           =$800F
;#EndIf

;#ifndef GL_EXT_texture_object
Const GL_TEXTURE_PRIORITY_EXT           =$8066
Const GL_TEXTURE_RESIDENT_EXT           =$8067
Const GL_TEXTURE_1D_BINDING_EXT         =$8068
Const GL_TEXTURE_2D_BINDING_EXT         =$8069
Const GL_TEXTURE_3D_BINDING_EXT         =$806A
;#EndIf

;#ifndef GL_SGIS_detail_texture
Const GL_DETAIL_TEXTURE_2D_SGIS         =$8095
Const GL_DETAIL_TEXTURE_2D_BINDING_SGIS =$8096
Const GL_LINEAR_DETAIL_SGIS             =$8097
Const GL_LINEAR_DETAIL_ALPHA_SGIS       =$8098
Const GL_LINEAR_DETAIL_COLOR_SGIS       =$8099
Const GL_DETAIL_TEXTURE_LEVEL_SGIS      =$809A
Const GL_DETAIL_TEXTURE_MODE_SGIS       =$809B
Const GL_DETAIL_TEXTURE_FUNC_POINTS_SGIS =$809C
;#EndIf

;#ifndef GL_SGIS_sharpen_texture
Const GL_LINEAR_SHARPEN_SGIS            =$80AD
Const GL_LINEAR_SHARPEN_ALPHA_SGIS      =$80AE
Const GL_LINEAR_SHARPEN_COLOR_SGIS      =$80AF
Const GL_SHARPEN_TEXTURE_FUNC_POINTS_SGIS =$80B0
;#EndIf

;#ifndef GL_EXT_packed_pixels
Const GL_UNSIGNED_BYTE_3_3_2_EXT        =$8032
Const GL_UNSIGNED_SHORT_4_4_4_4_EXT     =$8033
Const GL_UNSIGNED_SHORT_5_5_5_1_EXT     =$8034
Const GL_UNSIGNED_INT_8_8_8_8_EXT       =$8035
Const GL_UNSIGNED_INT_10_10_10_2_EXT    =$8036
;#EndIf

;#ifndef GL_SGIS_texture_lod
Const GL_TEXTURE_MIN_LOD_SGIS           =$813A
Const GL_TEXTURE_MAX_LOD_SGIS           =$813B
Const GL_TEXTURE_BASE_LEVEL_SGIS        =$813C
Const GL_TEXTURE_MAX_LEVEL_SGIS         =$813D
;#EndIf

;#ifndef GL_SGIS_multisample
Const GL_MULTISAMPLE_SGIS               =$809D
Const GL_SAMPLE_ALPHA_TO_MASK_SGIS      =$809E
Const GL_SAMPLE_ALPHA_TO_ONE_SGIS       =$809F
Const GL_SAMPLE_MASK_SGIS               =$80A0
Const GL_1PASS_SGIS                     =$80A1
Const GL_2PASS_0_SGIS                   =$80A2
Const GL_2PASS_1_SGIS                   =$80A3
Const GL_4PASS_0_SGIS                   =$80A4
Const GL_4PASS_1_SGIS                   =$80A5
Const GL_4PASS_2_SGIS                   =$80A6
Const GL_4PASS_3_SGIS                   =$80A7
Const GL_SAMPLE_BUFFERS_SGIS            =$80A8
Const GL_SAMPLES_SGIS                   =$80A9
Const GL_SAMPLE_MASK_VALUE_SGIS         =$80AA
Const GL_SAMPLE_MASK_INVERT_SGIS        =$80AB
Const GL_SAMPLE_PATTERN_SGIS            =$80AC
;#EndIf

;#ifndef GL_EXT_rescale_normal
Const GL_RESCALE_NORMAL_EXT             =$803A
;#EndIf

;#ifndef GL_EXT_vertex_array
;Const GL_VERTEX_ARRAY_EXT               =$8074
;Const GL_NORMAL_ARRAY_EXT               =$8075
;Const GL_COLOR_ARRAY_EXT                =$8076
;Const GL_INDEX_ARRAY_EXT                =$8077
;Const GL_TEXTURE_COORD_ARRAY_EXT        =$8078
;Const GL_EDGE_FLAG_ARRAY_EXT            =$8079
;Const GL_VERTEX_ARRAY_SIZE_EXT          =$807A
;Const GL_VERTEX_ARRAY_TYPE_EXT          =$807B
;onst GL_VERTEX_ARRAY_STRIDE_EXT        =$807C
;Const GL_VERTEX_ARRAY_COUNT_EXT         =$807D
;Const GL_NORMAL_ARRAY_TYPE_EXT          =$807E
;Const GL_NORMAL_ARRAY_STRIDE_EXT        =$807F
;Const GL_NORMAL_ARRAY_COUNT_EXT         =$8080
;Const GL_COLOR_ARRAY_SIZE_EXT           =$8081
;Const GL_COLOR_ARRAY_TYPE_EXT           =$8082
;Const GL_COLOR_ARRAY_STRIDE_EXT         =$8083
;Const GL_COLOR_ARRAY_COUNT_EXT          =$8084
;Const GL_INDEX_ARRAY_TYPE_EXT           =$8085
;Const GL_INDEX_ARRAY_STRIDE_EXT         =$8086
;Const GL_INDEX_ARRAY_COUNT_EXT          =$8087
;Const GL_TEXTURE_COORD_ARRAY_SIZE_EXT   =$8088
;Const GL_TEXTURE_COORD_ARRAY_TYPE_EXT   =$8089
;Const GL_TEXTURE_COORD_ARRAY_STRIDE_EXT =$808A
;Const GL_TEXTURE_COORD_ARRAY_COUNT_EXT  =$808B
;Const GL_EDGE_FLAG_ARRAY_STRIDE_EXT     =$808C
;Const GL_EDGE_FLAG_ARRAY_COUNT_EXT      =$808D
;Const GL_VERTEX_ARRAY_POINTER_EXT       =$808E
;Const GL_NORMAL_ARRAY_POINTER_EXT       =$808F
;Const GL_COLOR_ARRAY_POINTER_EXT        =$8090
;Const GL_INDEX_ARRAY_POINTER_EXT        =$8091
;Const GL_TEXTURE_COORD_ARRAY_POINTER_EXT =$8092
;Const GL_EDGE_FLAG_ARRAY_POINTER_EXT    =$8093
;#EndIf

;#ifndef GL_EXT_misc_attribute
;#EndIf

;#ifndef GL_SGIS_generate_mipmap
Const GL_GENERATE_MIPMAP_SGIS           =$8191
Const GL_GENERATE_MIPMAP_HINT_SGIS      =$8192
;#EndIf

;#ifndef GL_SGIX_clipmap
Const GL_LINEAR_CLIPMAP_LINEAR_SGIX     =$8170
Const GL_TEXTURE_CLIPMAP_CENTER_SGIX    =$8171
Const GL_TEXTURE_CLIPMAP_FRAME_SGIX     =$8172
Const GL_TEXTURE_CLIPMAP_OFFSET_SGIX    =$8173
Const GL_TEXTURE_CLIPMAP_VIRTUAL_DEPTH_SGIX =$8174
Const GL_TEXTURE_CLIPMAP_LOD_OFFSET_SGIX =$8175
Const GL_TEXTURE_CLIPMAP_DEPTH_SGIX     =$8176
Const GL_MAX_CLIPMAP_DEPTH_SGIX         =$8177
Const GL_MAX_CLIPMAP_VIRTUAL_DEPTH_SGIX =$8178
Const GL_NEAREST_CLIPMAP_NEAREST_SGIX   =$844D
Const GL_NEAREST_CLIPMAP_LINEAR_SGIX    =$844E
Const GL_LINEAR_CLIPMAP_NEAREST_SGIX    =$844F
;#EndIf

;#ifndef GL_SGIX_shadow
Const GL_TEXTURE_COMPARE_SGIX           =$819A
Const GL_TEXTURE_COMPARE_OPERATOR_SGIX  =$819B
Const GL_TEXTURE_LEQUAL_R_SGIX          =$819C
Const GL_TEXTURE_GEQUAL_R_SGIX          =$819D
;#EndIf

;#ifndef GL_SGIS_texture_edge_clamp
Const GL_CLAMP_TO_EDGE_SGIS             =$812F
;#EndIf

;#ifndef GL_EXT_blend_minmax
Const GL_FUNC_ADD_EXT                   =$8006
Const GL_MIN_EXT                        =$8007
Const GL_MAX_EXT                        =$8008
Const GL_BLEND_EQUATION_EXT             =$8009
;#EndIf

;#ifndef GL_EXT_blend_subtract
Const GL_FUNC_SUBTRACT_EXT              =$800A
Const GL_FUNC_REVERSE_SUBTRACT_EXT      =$800B
;#EndIf

;#ifndef GL_EXT_blend_logic_op
;#EndIf

;#ifndef GL_SGIX_interlace
Const GL_INTERLACE_SGIX                 =$8094
;#EndIf

;#ifndef GL_SGIX_pixel_tiles
Const GL_PIXEL_TILE_BEST_ALIGNMENT_SGIX =$813E
Const GL_PIXEL_TILE_CACHE_INCREMENT_SGIX =$813F
Const GL_PIXEL_TILE_WIDTH_SGIX          =$8140
Const GL_PIXEL_TILE_HEIGHT_SGIX         =$8141
Const GL_PIXEL_TILE_GRID_WIDTH_SGIX     =$8142
Const GL_PIXEL_TILE_GRID_HEIGHT_SGIX    =$8143
Const GL_PIXEL_TILE_GRID_DEPTH_SGIX     =$8144
Const GL_PIXEL_TILE_CACHE_SIZE_SGIX     =$8145
;#EndIf

;#ifndef GL_SGIS_texture_select
Const GL_DUAL_ALPHA4_SGIS               =$8110
Const GL_DUAL_ALPHA8_SGIS               =$8111
Const GL_DUAL_ALPHA12_SGIS              =$8112
Const GL_DUAL_ALPHA16_SGIS              =$8113
Const GL_DUAL_LUMINANCE4_SGIS           =$8114
Const GL_DUAL_LUMINANCE8_SGIS           =$8115
Const GL_DUAL_LUMINANCE12_SGIS          =$8116
Const GL_DUAL_LUMINANCE16_SGIS          =$8117
Const GL_DUAL_INTENSITY4_SGIS           =$8118
Const GL_DUAL_INTENSITY8_SGIS           =$8119
Const GL_DUAL_INTENSITY12_SGIS          =$811A
Const GL_DUAL_INTENSITY16_SGIS          =$811B
Const GL_DUAL_LUMINANCE_ALPHA4_SGIS     =$811C
Const GL_DUAL_LUMINANCE_ALPHA8_SGIS     =$811D
Const GL_QUAD_ALPHA4_SGIS               =$811E
Const GL_QUAD_ALPHA8_SGIS               =$811F
Const GL_QUAD_LUMINANCE4_SGIS           =$8120
Const GL_QUAD_LUMINANCE8_SGIS           =$8121
Const GL_QUAD_INTENSITY4_SGIS           =$8122
Const GL_QUAD_INTENSITY8_SGIS           =$8123
Const GL_DUAL_TEXTURE_SELECT_SGIS       =$8124
Const GL_QUAD_TEXTURE_SELECT_SGIS       =$8125
;#EndIf

;#ifndef GL_SGIX_sprite
Const GL_SPRITE_SGIX                    =$8148
Const GL_SPRITE_MODE_SGIX               =$8149
Const GL_SPRITE_AXIS_SGIX               =$814A
Const GL_SPRITE_TRANSLATION_SGIX        =$814B
Const GL_SPRITE_AXIAL_SGIX              =$814C
Const GL_SPRITE_OBJECT_ALIGNED_SGIX     =$814D
Const GL_SPRITE_EYE_ALIGNED_SGIX        =$814E
;#EndIf

;#ifndef GL_SGIX_texture_multi_buffer
Const GL_TEXTURE_MULTI_BUFFER_HINT_SGIX =$812E
;#EndIf

;#ifndef GL_SGIX_instruments
Const GL_INSTRUMENT_BUFFER_POINTER_SGIX =$8180
Const GL_INSTRUMENT_MEASUREMENTS_SGIX   =$8181
;#EndIf

;#ifndef GL_SGIX_texture_scale_bias
Const GL_POST_TEXTURE_FILTER_BIAS_SGIX  =$8179
Const GL_POST_TEXTURE_FILTER_SCALE_SGIX =$817A
Const GL_POST_TEXTURE_FILTER_BIAS_RANGE_SGIX =$817B
Const GL_POST_TEXTURE_FILTER_SCALE_RANGE_SGIX =$817C
;#EndIf

;#ifndef GL_SGIX_framezoom
Const GL_FRAMEZOOM_SGIX                 =$818B
Const GL_FRAMEZOOM_FACTOR_SGIX          =$818C
Const GL_MAX_FRAMEZOOM_FACTOR_SGIX      =$818D
;#EndIf

;#ifndef GL_SGIX_tag_sample_buffer
;#EndIf

;#ifndef GL_FfdMaskSGIX
Const GL_TEXTURE_DEFORMATION_BIT_SGIX   =$00000001
Const GL_GEOMETRY_DEFORMATION_BIT_SGIX  =$00000002
;#EndIf

;#ifndef GL_SGIX_polynomial_ffd
Const GL_GEOMETRY_DEFORMATION_SGIX      =$8194
Const GL_TEXTURE_DEFORMATION_SGIX       =$8195
Const GL_DEFORMATIONS_MASK_SGIX         =$8196
Const GL_MAX_DEFORMATION_ORDER_SGIX     =$8197
;#EndIf

;#ifndef GL_SGIX_reference_plane
Const GL_REFERENCE_PLANE_SGIX           =$817D
Const GL_REFERENCE_PLANE_EQUATION_SGIX  =$817E
;#EndIf

;#ifndef GL_SGIX_flush_raster
;#EndIf

;#ifndef GL_SGIX_depth_texture
Const GL_DEPTH_COMPONENT16_SGIX         =$81A5
Const GL_DEPTH_COMPONENT24_SGIX         =$81A6
Const GL_DEPTH_COMPONENT32_SGIX         =$81A7
;#EndIf

;#ifndef GL_SGIS_fog_function
Const GL_FOG_FUNC_SGIS                  =$812A
Const GL_FOG_FUNC_POINTS_SGIS           =$812B
Const GL_MAX_FOG_FUNC_POINTS_SGIS       =$812C
;#EndIf

;#ifndef GL_SGIX_fog_offset
Const GL_FOG_OFFSET_SGIX                =$8198
Const GL_FOG_OFFSET_VALUE_SGIX          =$8199
;#EndIf

;#ifndef GL_HP_image_transform
Const GL_IMAGE_SCALE_X_HP               =$8155
Const GL_IMAGE_SCALE_Y_HP               =$8156
Const GL_IMAGE_TRANSLATE_X_HP           =$8157
Const GL_IMAGE_TRANSLATE_Y_HP           =$8158
Const GL_IMAGE_ROTATE_ANGLE_HP          =$8159
Const GL_IMAGE_ROTATE_ORIGIN_X_HP       =$815A
Const GL_IMAGE_ROTATE_ORIGIN_Y_HP       =$815B
Const GL_IMAGE_MAG_FILTER_HP            =$815C
Const GL_IMAGE_MIN_FILTER_HP            =$815D
Const GL_IMAGE_CUBIC_WEIGHT_HP          =$815E
Const GL_CUBIC_HP                       =$815F
Const GL_AVERAGE_HP                     =$8160
Const GL_IMAGE_TRANSFORM_2D_HP          =$8161
Const GL_POST_IMAGE_TRANSFORM_COLOR_TABLE_HP =$8162
Const GL_PROXY_POST_IMAGE_TRANSFORM_COLOR_TABLE_HP =$8163
;#EndIf

;#ifndef GL_HP_convolution_border_modes
Const GL_IGNORE_BORDER_HP               =$8150
Const GL_CONSTANT_BORDER_HP             =$8151
Const GL_REPLICATE_BORDER_HP            =$8153
Const GL_CONVOLUTION_BORDER_COLOR_HP    =$8154
;#EndIf

;#ifndef GL_INGR_palette_buffer
;#EndIf

;#ifndef GL_SGIX_texture_add_env
Const GL_TEXTURE_ENV_BIAS_SGIX          =$80BE
;#EndIf

;#ifndef GL_EXT_color_subtable
;#EndIf

;#ifndef GL_PGI_vertex_hints
Const GL_VERTEX_DATA_HINT_PGI           =$1A22A
Const GL_VERTEX_CONSISTENT_HINT_PGI     =$1A22B
Const GL_MATERIAL_SIDE_HINT_PGI         =$1A22C
Const GL_MAX_VERTEX_HINT_PGI            =$1A22D
Const GL_COLOR3_BIT_PGI                 =$00010000
Const GL_COLOR4_BIT_PGI                 =$00020000
Const GL_EDGEFLAG_BIT_PGI               =$00040000
Const GL_INDEX_BIT_PGI                  =$00080000
Const GL_MAT_AMBIENT_BIT_PGI            =$00100000
Const GL_MAT_AMBIENT_AND_DIFFUSE_BIT_PGI =$00200000
Const GL_MAT_DIFFUSE_BIT_PGI            =$00400000
Const GL_MAT_EMISSION_BIT_PGI           =$00800000
Const GL_MAT_COLOR_INDEXES_BIT_PGI      =$01000000
Const GL_MAT_SHININESS_BIT_PGI          =$02000000
Const GL_MAT_SPECULAR_BIT_PGI           =$04000000
Const GL_NORMAL_BIT_PGI                 =$08000000
Const GL_TEXCOORD1_BIT_PGI              =$10000000
Const GL_TEXCOORD2_BIT_PGI              =$20000000
Const GL_TEXCOORD3_BIT_PGI              =$40000000
Const GL_TEXCOORD4_BIT_PGI              =$80000000
Const GL_VERTEX23_BIT_PGI               =$00000004
Const GL_VERTEX4_BIT_PGI                =$00000008
;#EndIf

;#ifndef GL_PGI_misc_hints
Const GL_PREFER_DOUBLEBUFFER_HINT_PGI   =$1A1F8
Const GL_CONSERVE_MEMORY_HINT_PGI       =$1A1FD
Const GL_RECLAIM_MEMORY_HINT_PGI        =$1A1FE
Const GL_NATIVE_GRAPHICS_HANDLE_PGI     =$1A202
Const GL_NATIVE_GRAPHICS_BEGIN_HINT_PGI =$1A203
Const GL_NATIVE_GRAPHICS_END_HINT_PGI   =$1A204
Const GL_ALWAYS_FAST_HINT_PGI           =$1A20C
Const GL_ALWAYS_SOFT_HINT_PGI           =$1A20D
Const GL_ALLOW_DRAW_OBJ_HINT_PGI        =$1A20E
Const GL_ALLOW_DRAW_WIN_HINT_PGI        =$1A20F
Const GL_ALLOW_DRAW_FRG_HINT_PGI        =$1A210
Const GL_ALLOW_DRAW_MEM_HINT_PGI        =$1A211
Const GL_STRICT_DEPTHFUNC_HINT_PGI      =$1A216
Const GL_STRICT_LIGHTING_HINT_PGI       =$1A217
Const GL_STRICT_SCISSOR_HINT_PGI        =$1A218
Const GL_FULL_STIPPLE_HINT_PGI          =$1A219
Const GL_CLIP_NEAR_HINT_PGI             =$1A220
Const GL_CLIP_FAR_HINT_PGI              =$1A221
Const GL_WIDE_LINE_HINT_PGI             =$1A222
Const GL_BACK_NORMALS_HINT_PGI          =$1A223
;#EndIf

;#ifndef GL_EXT_paletted_texture
;Const GL_COLOR_INDEX1_EXT               =$80E2
;Const GL_COLOR_INDEX2_EXT               =$80E3
;Const GL_COLOR_INDEX4_EXT               =$80E4
;Const GL_COLOR_INDEX8_EXT               =$80E5
;Const GL_COLOR_INDEX12_EXT              =$80E6
;Const GL_COLOR_INDEX16_EXT              =$80E7
;Const GL_TEXTURE_INDEX_SIZE_EXT         =$80ED
;#EndIf

;#ifndef GL_EXT_clip_volume_hint
Const GL_CLIP_VOLUME_CLIPPING_HINT_EXT  =$80F0
;#EndIf

;#ifndef GL_SGIX_list_priority
Const GL_LIST_PRIORITY_SGIX             =$8182
;#EndIf

;#ifndef GL_SGIX_ir_instrument1
Const GL_IR_INSTRUMENT1_SGIX            =$817F
;#EndIf

;#ifndef GL_SGIX_calligraphic_fragment
Const GL_CALLIGRAPHIC_FRAGMENT_SGIX     =$8183
;#EndIf

;#ifndef GL_SGIX_texture_lod_bias
Const GL_TEXTURE_LOD_BIAS_S_SGIX        =$818E
Const GL_TEXTURE_LOD_BIAS_T_SGIX        =$818F
Const GL_TEXTURE_LOD_BIAS_R_SGIX        =$8190
;#EndIf

;#ifndef GL_SGIX_shadow_ambient
Const GL_SHADOW_AMBIENT_SGIX            =$80BF
;#EndIf

;#ifndef GL_EXT_index_texture
;#EndIf

;#ifndef GL_EXT_index_material
Const GL_INDEX_MATERIAL_EXT             =$81B8
Const GL_INDEX_MATERIAL_PARAMETER_EXT   =$81B9
Const GL_INDEX_MATERIAL_FACE_EXT        =$81BA
;#EndIf

;#ifndef GL_EXT_index_func
Const GL_INDEX_TEST_EXT                 =$81B5
Const GL_INDEX_TEST_FUNC_EXT            =$81B6
Const GL_INDEX_TEST_REF_EXT             =$81B7
;#EndIf

;#ifndef GL_EXT_index_array_formats
Const GL_IUI_V2F_EXT                    =$81AD
Const GL_IUI_V3F_EXT                    =$81AE
Const GL_IUI_N3F_V2F_EXT                =$81AF
Const GL_IUI_N3F_V3F_EXT                =$81B0
Const GL_T2F_IUI_V2F_EXT                =$81B1
Const GL_T2F_IUI_V3F_EXT                =$81B2
Const GL_T2F_IUI_N3F_V2F_EXT            =$81B3
Const GL_T2F_IUI_N3F_V3F_EXT            =$81B4
;#EndIf

;#ifndef GL_EXT_compiled_vertex_array
Const GL_ARRAY_ELEMENT_LOCK_FIRST_EXT   =$81A8
Const GL_ARRAY_ELEMENT_LOCK_COUNT_EXT   =$81A9
;#EndIf

;#ifndef GL_EXT_cull_vertex
Const GL_CULL_VERTEX_EXT                =$81AA
Const GL_CULL_VERTEX_EYE_POSITION_EXT   =$81AB
Const GL_CULL_VERTEX_OBJECT_POSITION_EXT =$81AC
;#EndIf

;#ifndef GL_SGIX_ycrcb
Const GL_YCRCB_422_SGIX                 =$81BB
Const GL_YCRCB_444_SGIX                 =$81BC
;#EndIf

;#ifndef GL_SGIX_fragment_lighting
Const GL_FRAGMENT_LIGHTING_SGIX         =$8400
Const GL_FRAGMENT_COLOR_MATERIAL_SGIX   =$8401
Const GL_FRAGMENT_COLOR_MATERIAL_FACE_SGIX =$8402
Const GL_FRAGMENT_COLOR_MATERIAL_PARAMETER_SGIX =$8403
Const GL_MAX_FRAGMENT_LIGHTS_SGIX       =$8404
Const GL_MAX_ACTIVE_LIGHTS_SGIX         =$8405
Const GL_CURRENT_RASTER_NORMAL_SGIX     =$8406
Const GL_LIGHT_ENV_MODE_SGIX            =$8407
Const GL_FRAGMENT_LIGHT_MODEL_LOCAL_VIEWER_SGIX =$8408
Const GL_FRAGMENT_LIGHT_MODEL_TWO_SIDE_SGIX =$8409
Const GL_FRAGMENT_LIGHT_MODEL_AMBIENT_SGIX =$840A
Const GL_FRAGMENT_LIGHT_MODEL_NORMAL_INTERPOLATION_SGIX =$840B
Const GL_FRAGMENT_LIGHT0_SGIX           =$840C
Const GL_FRAGMENT_LIGHT1_SGIX           =$840D
Const GL_FRAGMENT_LIGHT2_SGIX           =$840E
Const GL_FRAGMENT_LIGHT3_SGIX           =$840F
Const GL_FRAGMENT_LIGHT4_SGIX           =$8410
Const GL_FRAGMENT_LIGHT5_SGIX           =$8411
Const GL_FRAGMENT_LIGHT6_SGIX           =$8412
Const GL_FRAGMENT_LIGHT7_SGIX           =$8413
;#EndIf

;#ifndef GL_IBM_rasterpos_clip
Const GL_RASTER_POSITION_UNCLIPPED_IBM  =$19262
;#EndIf

;#ifndef GL_HP_texture_lighting
Const GL_TEXTURE_LIGHTING_MODE_HP       =$8167
Const GL_TEXTURE_POST_SPECULAR_HP       =$8168
Const GL_TEXTURE_PRE_SPECULAR_HP        =$8169
;#EndIf

;#ifndef GL_EXT_draw_range_elements
Const GL_MAX_ELEMENTS_VERTICES_EXT      =$80E8
Const GL_MAX_ELEMENTS_INDICES_EXT       =$80E9
;#EndIf

;#ifndef GL_WIN_phong_shading
;Const GL_PHONG_WIN                      =$80EA
;Const GL_PHONG_HINT_WIN                 =$80EB
;#EndIf

;#ifndef GL_WIN_specular_fog
;pConst GL_FOG_SPECULAR_TEXTURE_WIN       =$80EC
;#EndIf

;#ifndef GL_EXT_light_texture
Const GL_FRAGMENT_MATERIAL_EXT          =$8349
Const GL_FRAGMENT_NORMAL_EXT            =$834A
Const GL_FRAGMENT_COLOR_EXT             =$834C
Const GL_ATTENUATION_EXT                =$834D
Const GL_SHADOW_ATTENUATION_EXT         =$834E
Const GL_TEXTURE_APPLICATION_MODE_EXT   =$834F
Const GL_TEXTURE_LIGHT_EXT              =$8350
Const GL_TEXTURE_MATERIAL_FACE_EXT      =$8351
Const GL_TEXTURE_MATERIAL_PARAMETER_EXT =$8352
;#EndIf

;#ifndef GL_SGIX_blend_alpha_minmax
Const GL_ALPHA_MIN_SGIX                 =$8320
Const GL_ALPHA_MAX_SGIX                 =$8321
;#EndIf

;#ifndef GL_SGIX_impact_pixel_texture
Const GL_PIXEL_TEX_GEN_Q_CEILING_SGIX   =$8184
Const GL_PIXEL_TEX_GEN_Q_ROUND_SGIX     =$8185
Const GL_PIXEL_TEX_GEN_Q_FLOOR_SGIX     =$8186
Const GL_PIXEL_TEX_GEN_ALPHA_REPLACE_SGIX =$8187
Const GL_PIXEL_TEX_GEN_ALPHA_NO_REPLACE_SGIX =$8188
Const GL_PIXEL_TEX_GEN_ALPHA_LS_SGIX    =$8189
Const GL_PIXEL_TEX_GEN_ALPHA_MS_SGIX    =$818A
;#EndIf

;#ifndef GL_EXT_bgra
;Const GL_BGR_EXT                        =$80E0
;Const GL_BGRA_EXT                       =$80E1
;#EndIf

;#ifndef GL_SGIX_async
Const GL_ASYNC_MARKER_SGIX              =$8329
;#EndIf

;#ifndef GL_SGIX_async_pixel
Const GL_ASYNC_TEX_IMAGE_SGIX           =$835C
Const GL_ASYNC_DRAW_PIXELS_SGIX         =$835D
Const GL_ASYNC_READ_PIXELS_SGIX         =$835E
Const GL_MAX_ASYNC_TEX_IMAGE_SGIX       =$835F
Const GL_MAX_ASYNC_DRAW_PIXELS_SGIX     =$8360
Const GL_MAX_ASYNC_READ_PIXELS_SGIX     =$8361
;#EndIf

;#ifndef GL_SGIX_async_histogram
Const GL_ASYNC_HISTOGRAM_SGIX           =$832C
Const GL_MAX_ASYNC_HISTOGRAM_SGIX       =$832D
;#EndIf

;#ifndef GL_INTEL_texture_scissor
;#EndIf

;#ifndef GL_INTEL_parallel_arrays
Const GL_PARALLEL_ARRAYS_INTEL          =$83F4
Const GL_VERTEX_ARRAY_PARALLEL_POINTERS_INTEL =$83F5
Const GL_NORMAL_ARRAY_PARALLEL_POINTERS_INTEL =$83F6
Const GL_COLOR_ARRAY_PARALLEL_POINTERS_INTEL =$83F7
Const GL_TEXTURE_COORD_ARRAY_PARALLEL_POINTERS_INTEL =$83F8
;#EndIf

;#ifndef GL_HP_occlusion_test
Const GL_OCCLUSION_TEST_HP              =$8165
Const GL_OCCLUSION_TEST_RESULT_HP       =$8166
;#EndIf

;#ifndef GL_EXT_pixel_transform
Const GL_PIXEL_TRANSFORM_2D_EXT         =$8330
Const GL_PIXEL_MAG_FILTER_EXT           =$8331
Const GL_PIXEL_MIN_FILTER_EXT           =$8332
Const GL_PIXEL_CUBIC_WEIGHT_EXT         =$8333
Const GL_CUBIC_EXT                      =$8334
Const GL_AVERAGE_EXT                    =$8335
Const GL_PIXEL_TRANSFORM_2D_STACK_DEPTH_EXT =$8336
Const GL_MAX_PIXEL_TRANSFORM_2D_STACK_DEPTH_EXT =$8337
Const GL_PIXEL_TRANSFORM_2D_MATRIX_EXT  =$8338
;#EndIf

;#ifndef GL_EXT_pixel_transform_color_table
;#EndIf

;#ifndef GL_EXT_shared_texture_palette
Const GL_SHARED_TEXTURE_PALETTE_EXT     =$81FB
;#EndIf

;#ifndef GL_EXT_separate_specular_color
Const GL_LIGHT_MODEL_COLOR_CONTROL_EXT  =$81F8
Const GL_SINGLE_COLOR_EXT               =$81F9
Const GL_SEPARATE_SPECULAR_COLOR_EXT    =$81FA
;#EndIf

;#ifndef GL_EXT_secondary_color
Const GL_COLOR_SUM_EXT                  =$8458
Const GL_CURRENT_SECONDARY_COLOR_EXT    =$8459
Const GL_SECONDARY_COLOR_ARRAY_SIZE_EXT =$845A
Const GL_SECONDARY_COLOR_ARRAY_TYPE_EXT =$845B
Const GL_SECONDARY_COLOR_ARRAY_STRIDE_EXT =$845C
Const GL_SECONDARY_COLOR_ARRAY_POINTER_EXT =$845D
Const GL_SECONDARY_COLOR_ARRAY_EXT      =$845E
;#EndIf

;#ifndef GL_EXT_texture_perturb_normal
Const GL_PERTURB_EXT                    =$85AE
Const GL_TEXTURE_NORMAL_EXT             =$85AF
;#EndIf

;#ifndef GL_EXT_multi_draw_arrays
;#EndIf

;#ifndef GL_EXT_fog_coord
Const GL_FOG_COORDINATE_SOURCE_EXT      =$8450
Const GL_FOG_COORDINATE_EXT             =$8451
Const GL_FRAGMENT_DEPTH_EXT             =$8452
Const GL_CURRENT_FOG_COORDINATE_EXT     =$8453
Const GL_FOG_COORDINATE_ARRAY_TYPE_EXT  =$8454
Const GL_FOG_COORDINATE_ARRAY_STRIDE_EXT =$8455
Const GL_FOG_COORDINATE_ARRAY_POINTER_EXT =$8456
Const GL_FOG_COORDINATE_ARRAY_EXT       =$8457
;#EndIf

;#ifndef GL_REND_screen_coordinates
Const GL_SCREEN_COORDINATES_REND        =$8490
Const GL_INVERTED_SCREEN_W_REND         =$8491
;#EndIf

;#ifndef GL_EXT_coordinate_frame
Const GL_TANGENT_ARRAY_EXT              =$8439
Const GL_BINORMAL_ARRAY_EXT             =$843A
Const GL_CURRENT_TANGENT_EXT            =$843B
Const GL_CURRENT_BINORMAL_EXT           =$843C
Const GL_TANGENT_ARRAY_TYPE_EXT         =$843E
Const GL_TANGENT_ARRAY_STRIDE_EXT       =$843F
Const GL_BINORMAL_ARRAY_TYPE_EXT        =$8440
Const GL_BINORMAL_ARRAY_STRIDE_EXT      =$8441
Const GL_TANGENT_ARRAY_POINTER_EXT      =$8442
Const GL_BINORMAL_ARRAY_POINTER_EXT     =$8443
Const GL_MAP1_TANGENT_EXT               =$8444
Const GL_MAP2_TANGENT_EXT               =$8445
Const GL_MAP1_BINORMAL_EXT              =$8446
Const GL_MAP2_BINORMAL_EXT              =$8447
;#EndIf

;#ifndef GL_EXT_texture_env_combine
Const GL_COMBINE_EXT                    =$8570
Const GL_COMBINE_RGB_EXT                =$8571
Const GL_COMBINE_ALPHA_EXT              =$8572
Const GL_RGB_SCALE_EXT                  =$8573
Const GL_ADD_SIGNED_EXT                 =$8574
Const GL_INTERPOLATE_EXT                =$8575
Const GL_CONSTANT_EXT                   =$8576
Const GL_PRIMARY_COLOR_EXT              =$8577
Const GL_PREVIOUS_EXT                   =$8578
Const GL_SOURCE0_RGB_EXT                =$8580
Const GL_SOURCE1_RGB_EXT                =$8581
Const GL_SOURCE2_RGB_EXT                =$8582
Const GL_SOURCE0_ALPHA_EXT              =$8588
Const GL_SOURCE1_ALPHA_EXT              =$8589
Const GL_SOURCE2_ALPHA_EXT              =$858A
Const GL_OPERAND0_RGB_EXT               =$8590
Const GL_OPERAND1_RGB_EXT               =$8591
Const GL_OPERAND2_RGB_EXT               =$8592
Const GL_OPERAND0_ALPHA_EXT             =$8598
Const GL_OPERAND1_ALPHA_EXT             =$8599
Const GL_OPERAND2_ALPHA_EXT             =$859A
;#EndIf

;#ifndef GL_APPLE_specular_vector
Const GL_LIGHT_MODEL_SPECULAR_VECTOR_APPLE =$85B0
;#EndIf

;#ifndef GL_APPLE_transform_hint
Const GL_TRANSFORM_HINT_APPLE           =$85B1
;#EndIf

;#ifndef GL_SGIX_fog_scale
Const GL_FOG_SCALE_SGIX                 =$81FC
Const GL_FOG_SCALE_VALUE_SGIX           =$81FD
;#EndIf

;#ifndef GL_SUNX_constant_data
Const GL_UNPACK_CONSTANT_DATA_SUNX      =$81D5
Const GL_TEXTURE_CONSTANT_DATA_SUNX     =$81D6
;#EndIf

;#ifndef GL_SUN_global_alpha
Const GL_GLOBAL_ALPHA_SUN               =$81D9
Const GL_GLOBAL_ALPHA_FACTOR_SUN        =$81DA
;#EndIf

;#ifndef GL_SUN_triangle_list
Const GL_RESTART_SUN                    =$0001
Const GL_REPLACE_MIDDLE_SUN             =$0002
Const GL_REPLACE_OLDEST_SUN             =$0003
Const GL_TRIANGLE_LIST_SUN              =$81D7
Const GL_REPLACEMENT_CODE_SUN           =$81D8
Const GL_REPLACEMENT_CODE_ARRAY_SUN     =$85C0
Const GL_REPLACEMENT_CODE_ARRAY_TYPE_SUN =$85C1
Const GL_REPLACEMENT_CODE_ARRAY_STRIDE_SUN =$85C2
Const GL_REPLACEMENT_CODE_ARRAY_POINTER_SUN =$85C3
Const GL_R1UI_V3F_SUN                   =$85C4
Const GL_R1UI_C4UB_V3F_SUN              =$85C5
Const GL_R1UI_C3F_V3F_SUN               =$85C6
Const GL_R1UI_N3F_V3F_SUN               =$85C7
Const GL_R1UI_C4F_N3F_V3F_SUN           =$85C8
Const GL_R1UI_T2F_V3F_SUN               =$85C9
Const GL_R1UI_T2F_N3F_V3F_SUN           =$85CA
Const GL_R1UI_T2F_C4F_N3F_V3F_SUN       =$85CB
;#EndIf

;#ifndef GL_SUN_vertex
;#EndIf

;#ifndef GL_EXT_blend_func_separate
Const GL_BLEND_DST_RGB_EXT              =$80C8
Const GL_BLEND_SRC_RGB_EXT              =$80C9
Const GL_BLEND_DST_ALPHA_EXT            =$80CA
Const GL_BLEND_SRC_ALPHA_EXT            =$80CB
;#EndIf

;#ifndef GL_INGR_color_clamp
Const GL_RED_MIN_CLAMP_INGR             =$8560
Const GL_GREEN_MIN_CLAMP_INGR           =$8561
Const GL_BLUE_MIN_CLAMP_INGR            =$8562
Const GL_ALPHA_MIN_CLAMP_INGR           =$8563
Const GL_RED_MAX_CLAMP_INGR             =$8564
Const GL_GREEN_MAX_CLAMP_INGR           =$8565
Const GL_BLUE_MAX_CLAMP_INGR            =$8566
Const GL_ALPHA_MAX_CLAMP_INGR           =$8567
;#EndIf

;#ifndef GL_INGR_interlace_read
Const GL_INTERLACE_READ_INGR            =$8568
;#EndIf

;#ifndef GL_EXT_stencil_wrap
Const GL_INCR_WRAP_EXT                  =$8507
Const GL_DECR_WRAP_EXT                  =$8508
;#EndIf

;#ifndef GL_EXT_422_pixels
Const GL_422_EXT                        =$80CC
Const GL_422_REV_EXT                    =$80CD
Const GL_422_AVERAGE_EXT                =$80CE
Const GL_422_REV_AVERAGE_EXT            =$80CF
;#EndIf

;#ifndef GL_NV_texgen_reflection
Const GL_NORMAL_MAP_NV                  =$8511
Const GL_REFLECTION_MAP_NV              =$8512
;#EndIf

;#ifndef GL_EXT_texture_cube_map
Const GL_NORMAL_MAP_EXT                 =$8511
Const GL_REFLECTION_MAP_EXT             =$8512
Const GL_TEXTURE_CUBE_MAP_EXT           =$8513
Const GL_TEXTURE_BINDING_CUBE_MAP_EXT   =$8514
Const GL_TEXTURE_CUBE_MAP_POSITIVE_X_EXT =$8515
Const GL_TEXTURE_CUBE_MAP_NEGATIVE_X_EXT =$8516
Const GL_TEXTURE_CUBE_MAP_POSITIVE_Y_EXT =$8517
Const GL_TEXTURE_CUBE_MAP_NEGATIVE_Y_EXT =$8518
Const GL_TEXTURE_CUBE_MAP_POSITIVE_Z_EXT =$8519
Const GL_TEXTURE_CUBE_MAP_NEGATIVE_Z_EXT =$851A
Const GL_PROXY_TEXTURE_CUBE_MAP_EXT     =$851B
Const GL_MAX_CUBE_MAP_TEXTURE_SIZE_EXT  =$851C
;#EndIf

;#ifndef GL_SUN_convolution_border_modes
Const GL_WRAP_BORDER_SUN                =$81D4
;#EndIf

;#ifndef GL_EXT_texture_env_add
;#EndIf

;#ifndef GL_EXT_texture_lod_bias
Const GL_MAX_TEXTURE_LOD_BIAS_EXT       =$84FD
Const GL_TEXTURE_FILTER_CONTROL_EXT     =$8500
Const GL_TEXTURE_LOD_BIAS_EXT           =$8501
;#EndIf

;#ifndef GL_EXT_texture_filter_anisotropic
Const GL_TEXTURE_MAX_ANISOTROPY_EXT     =$84FE
Const GL_MAX_TEXTURE_MAX_ANISOTROPY_EXT =$84FF
;#EndIf

;#ifndef GL_EXT_vertex_weighting
Const GL_MODELVIEW0_STACK_DEPTH_EXT     =GL_MODELVIEW_STACK_DEPTH
Const GL_MODELVIEW1_STACK_DEPTH_EXT     =$8502
Const GL_MODELVIEW0_MATRIX_EXT          =GL_MODELVIEW_MATRIX
Const GL_MODELVIEW1_MATRIX_EXT          =$8506
Const GL_VERTEX_WEIGHTING_EXT           =$8509
Const GL_MODELVIEW0_EXT                 =GL_MODELVIEW
Const GL_MODELVIEW1_EXT                 =$850A
Const GL_CURRENT_VERTEX_WEIGHT_EXT      =$850B
Const GL_VERTEX_WEIGHT_ARRAY_EXT        =$850C
Const GL_VERTEX_WEIGHT_ARRAY_SIZE_EXT   =$850D
Const GL_VERTEX_WEIGHT_ARRAY_TYPE_EXT   =$850E
Const GL_VERTEX_WEIGHT_ARRAY_STRIDE_EXT =$850F
Const GL_VERTEX_WEIGHT_ARRAY_POINTER_EXT =$8510
;#EndIf

;#ifndef GL_NV_light_max_exponent
Const GL_MAX_SHININESS_NV               =$8504
Const GL_MAX_SPOT_EXPONENT_NV           =$8505
;#EndIf

;#ifndef GL_NV_vertex_array_range
Const GL_VERTEX_ARRAY_RANGE_NV          =$851D
Const GL_VERTEX_ARRAY_RANGE_LENGTH_NV   =$851E
Const GL_VERTEX_ARRAY_RANGE_VALID_NV    =$851F
Const GL_MAX_VERTEX_ARRAY_RANGE_ELEMENT_NV =$8520
Const GL_VERTEX_ARRAY_RANGE_POINTER_NV  =$8521
;#EndIf

;#ifndef GL_NV_register_combiners
Const GL_REGISTER_COMBINERS_NV          =$8522
Const GL_VARIABLE_A_NV                  =$8523
Const GL_VARIABLE_B_NV                  =$8524
Const GL_VARIABLE_C_NV                  =$8525
Const GL_VARIABLE_D_NV                  =$8526
Const GL_VARIABLE_E_NV                  =$8527
Const GL_VARIABLE_F_NV                  =$8528
Const GL_VARIABLE_G_NV                  =$8529
Const GL_CONSTANT_COLOR0_NV             =$852A
Const GL_CONSTANT_COLOR1_NV             =$852B
Const GL_PRIMARY_COLOR_NV               =$852C
Const GL_SECONDARY_COLOR_NV             =$852D
Const GL_SPARE0_NV                      =$852E
Const GL_SPARE1_NV                      =$852F
Const GL_DISCARD_NV                     =$8530
Const GL_E_TIMES_F_NV                   =$8531
Const GL_SPARE0_PLUS_SECONDARY_COLOR_NV =$8532
Const GL_UNSIGNED_IDENTITY_NV           =$8536
Const GL_UNSIGNED_INVERT_NV             =$8537
Const GL_EXPAND_NORMAL_NV               =$8538
Const GL_EXPAND_NEGATE_NV               =$8539
Const GL_HALF_BIAS_NORMAL_NV            =$853A
Const GL_HALF_BIAS_NEGATE_NV            =$853B
Const GL_SIGNED_IDENTITY_NV             =$853C
Const GL_SIGNED_NEGATE_NV               =$853D
Const GL_SCALE_BY_TWO_NV                =$853E
Const GL_SCALE_BY_FOUR_NV               =$853F
Const GL_SCALE_BY_ONE_HALF_NV           =$8540
Const GL_BIAS_BY_NEGATIVE_ONE_HALF_NV   =$8541
Const GL_COMBINER_INPUT_NV              =$8542
Const GL_COMBINER_MAPPING_NV            =$8543
Const GL_COMBINER_COMPONENT_USAGE_NV    =$8544
Const GL_COMBINER_AB_DOT_PRODUCT_NV     =$8545
Const GL_COMBINER_CD_DOT_PRODUCT_NV     =$8546
Const GL_COMBINER_MUX_SUM_NV            =$8547
Const GL_COMBINER_SCALE_NV              =$8548
Const GL_COMBINER_BIAS_NV               =$8549
Const GL_COMBINER_AB_OUTPUT_NV          =$854A
Const GL_COMBINER_CD_OUTPUT_NV          =$854B
Const GL_COMBINER_SUM_OUTPUT_NV         =$854C
Const GL_MAX_GENERAL_COMBINERS_NV       =$854D
Const GL_NUM_GENERAL_COMBINERS_NV       =$854E
Const GL_COLOR_SUM_CLAMP_NV             =$854F
Const GL_COMBINER0_NV                   =$8550
Const GL_COMBINER1_NV                   =$8551
Const GL_COMBINER2_NV                   =$8552
Const GL_COMBINER3_NV                   =$8553
Const GL_COMBINER4_NV                   =$8554
Const GL_COMBINER5_NV                   =$8555
Const GL_COMBINER6_NV                   =$8556
Const GL_COMBINER7_NV                   =$8557
; /* reuse GL_TEXTURE0_ARB */
; /* reuse GL_TEXTURE1_ARB */
; /* reuse GL_ZERO */
; /* reuse GL_NONE */
; /* reuse GL_FOG */
;#EndIf

;#ifndef GL_NV_fog_distance
Const GL_FOG_DISTANCE_MODE_NV           =$855A
Const GL_EYE_RADIAL_NV                  =$855B
Const GL_EYE_PLANE_ABSOLUTE_NV          =$855C
; /* reuse GL_EYE_PLANE */
;#EndIf

;#ifndef GL_NV_texgen_emboss
Const GL_EMBOSS_LIGHT_NV                =$855D
Const GL_EMBOSS_CONSTANT_NV             =$855E
Const GL_EMBOSS_MAP_NV                  =$855F
;#EndIf

;#ifndef GL_NV_blend_square
;#EndIf

;#ifndef GL_NV_texture_env_combine4
Const GL_COMBINE4_NV                    =$8503
Const GL_SOURCE3_RGB_NV                 =$8583
Const GL_SOURCE3_ALPHA_NV               =$858B
Const GL_OPERAND3_RGB_NV                =$8593
Const GL_OPERAND3_ALPHA_NV              =$859B
;#EndIf

;#ifndef GL_MESA_resize_buffers
;#EndIf

;#ifndef GL_MESA_window_pos
;#EndIf

;#ifndef GL_EXT_texture_compression_s3tc
Const GL_COMPRESSED_RGB_S3TC_DXT1_EXT   =$83F0
Const GL_COMPRESSED_RGBA_S3TC_DXT1_EXT  =$83F1
Const GL_COMPRESSED_RGBA_S3TC_DXT3_EXT  =$83F2
Const GL_COMPRESSED_RGBA_S3TC_DXT5_EXT  =$83F3
;#EndIf

;#ifndef GL_IBM_cull_vertex
Const GL_CULL_VERTEX_IBM                =103050
;#EndIf

;#ifndef GL_IBM_multimode_draw_arrays
;#EndIf

;#ifndef GL_IBM_vertex_array_lists
Const GL_VERTEX_ARRAY_LIST_IBM          =103070
Const GL_NORMAL_ARRAY_LIST_IBM          =103071
Const GL_COLOR_ARRAY_LIST_IBM           =103072
Const GL_INDEX_ARRAY_LIST_IBM           =103073
Const GL_TEXTURE_COORD_ARRAY_LIST_IBM   =103074
Const GL_EDGE_FLAG_ARRAY_LIST_IBM       =103075
Const GL_FOG_COORDINATE_ARRAY_LIST_IBM  =103076
Const GL_SECONDARY_COLOR_ARRAY_LIST_IBM =103077
Const GL_VERTEX_ARRAY_LIST_STRIDE_IBM   =103080
Const GL_NORMAL_ARRAY_LIST_STRIDE_IBM   =103081
Const GL_COLOR_ARRAY_LIST_STRIDE_IBM    =103082
Const GL_INDEX_ARRAY_LIST_STRIDE_IBM    =103083
Const GL_TEXTURE_COORD_ARRAY_LIST_STRIDE_IBM =103084
Const GL_EDGE_FLAG_ARRAY_LIST_STRIDE_IBM =103085
Const GL_FOG_COORDINATE_ARRAY_LIST_STRIDE_IBM =103086
Const GL_SECONDARY_COLOR_ARRAY_LIST_STRIDE_IBM =103087
;#EndIf

;#ifndef GL_SGIX_subsample
Const GL_PACK_SUBSAMPLE_RATE_SGIX       =$85A0
Const GL_UNPACK_SUBSAMPLE_RATE_SGIX     =$85A1
Const GL_PIXEL_SUBSAMPLE_4444_SGIX      =$85A2
Const GL_PIXEL_SUBSAMPLE_2424_SGIX      =$85A3
Const GL_PIXEL_SUBSAMPLE_4242_SGIX      =$85A4
;#EndIf

;#ifndef GL_SGIX_ycrcb_subsample
;#EndIf

;#ifndef GL_SGIX_ycrcba
Const GL_YCRCB_SGIX                     =$8318
Const GL_YCRCBA_SGIX                    =$8319
;#EndIf

;#ifndef GL_SGI_depth_pass_instrument
Const GL_DEPTH_PASS_INSTRUMENT_SGIX     =$8310
Const GL_DEPTH_PASS_INSTRUMENT_COUNTERS_SGIX =$8311
Const GL_DEPTH_PASS_INSTRUMENT_MAX_SGIX =$8312
;#EndIf

;#ifndef GL_3DFX_texture_compression_FXT1
Const GL_COMPRESSED_RGB_FXT1_3DFX       =$86B0
Const GL_COMPRESSED_RGBA_FXT1_3DFX      =$86B1
;#EndIf

;#ifndef GL_3DFX_multisample
Const GL_MULTISAMPLE_3DFX               =$86B2
Const GL_SAMPLE_BUFFERS_3DFX            =$86B3
Const GL_SAMPLES_3DFX                   =$86B4
Const GL_MULTISAMPLE_BIT_3DFX           =$20000000
;#EndIf

;#ifndef GL_3DFX_tbuffer
;#EndIf

;#ifndef GL_EXT_multisample
Const GL_MULTISAMPLE_EXT                =$809D
Const GL_SAMPLE_ALPHA_TO_MASK_EXT       =$809E
Const GL_SAMPLE_ALPHA_TO_ONE_EXT        =$809F
Const GL_SAMPLE_MASK_EXT                =$80A0
Const GL_1PASS_EXT                      =$80A1
Const GL_2PASS_0_EXT                    =$80A2
Const GL_2PASS_1_EXT                    =$80A3
Const GL_4PASS_0_EXT                    =$80A4
Const GL_4PASS_1_EXT                    =$80A5
Const GL_4PASS_2_EXT                    =$80A6
Const GL_4PASS_3_EXT                    =$80A7
Const GL_SAMPLE_BUFFERS_EXT             =$80A8
Const GL_SAMPLES_EXT                    =$80A9
Const GL_SAMPLE_MASK_VALUE_EXT          =$80AA
Const GL_SAMPLE_MASK_INVERT_EXT         =$80AB
Const GL_SAMPLE_PATTERN_EXT             =$80AC
Const GL_MULTISAMPLE_BIT_EXT            =$20000000
;#EndIf

;#ifndef GL_SGIX_vertex_preclip
Const GL_VERTEX_PRECLIP_SGIX            =$83EE
Const GL_VERTEX_PRECLIP_HINT_SGIX       =$83EF
;#EndIf

;#ifndef GL_SGIX_convolution_accuracy
Const GL_CONVOLUTION_HINT_SGIX          =$8316
;#EndIf

;#ifndef GL_SGIX_resample
Const GL_PACK_RESAMPLE_SGIX             =$842C
Const GL_UNPACK_RESAMPLE_SGIX           =$842D
Const GL_RESAMPLE_REPLICATE_SGIX        =$842E
Const GL_RESAMPLE_ZERO_FILL_SGIX        =$842F
Const GL_RESAMPLE_DECIMATE_SGIX         =$8430
;#EndIf

;#ifndef GL_SGIS_point_line_texgen
Const GL_EYE_DISTANCE_TO_POINT_SGIS     =$81F0
Const GL_OBJECT_DISTANCE_TO_POINT_SGIS  =$81F1
Const GL_EYE_DISTANCE_TO_LINE_SGIS      =$81F2
Const GL_OBJECT_DISTANCE_TO_LINE_SGIS   =$81F3
Const GL_EYE_POINT_SGIS                 =$81F4
Const GL_OBJECT_POINT_SGIS              =$81F5
Const GL_EYE_LINE_SGIS                  =$81F6
Const GL_OBJECT_LINE_SGIS               =$81F7
;#EndIf

;#ifndef GL_SGIS_texture_color_mask
Const GL_TEXTURE_COLOR_WRITEMASK_SGIS   =$81EF
;#EndIf

;#ifndef GL_EXT_texture_env_dot3
Const GL_DOT3_RGB_EXT                   =$8740
Const GL_DOT3_RGBA_EXT                  =$8741
;#EndIf

;#ifndef GL_ATI_texture_mirror_once
Const GL_MIRROR_CLAMP_ATI               =$8742
Const GL_MIRROR_CLAMP_TO_EDGE_ATI       =$8743
;#EndIf

;#ifndef GL_NV_fence
Const GL_ALL_COMPLETED_NV               =$84F2
Const GL_FENCE_STATUS_NV                =$84F3
Const GL_FENCE_CONDITION_NV             =$84F4
;#EndIf

;#ifndef GL_IBM_texture_mirrored_repeat
Const GL_MIRRORED_REPEAT_IBM            =$8370
;#EndIf

;#ifndef GL_NV_evaluators
Const GL_EVAL_2D_NV                     =$86C0
Const GL_EVAL_TRIANGULAR_2D_NV          =$86C1
Const GL_MAP_TESSELLATION_NV            =$86C2
Const GL_MAP_ATTRIB_U_ORDER_NV          =$86C3
Const GL_MAP_ATTRIB_V_ORDER_NV          =$86C4
Const GL_EVAL_FRACTIONAL_TESSELLATION_NV =$86C5
Const GL_EVAL_VERTEX_ATTRIB0_NV         =$86C6
Const GL_EVAL_VERTEX_ATTRIB1_NV         =$86C7
Const GL_EVAL_VERTEX_ATTRIB2_NV         =$86C8
Const GL_EVAL_VERTEX_ATTRIB3_NV         =$86C9
Const GL_EVAL_VERTEX_ATTRIB4_NV         =$86CA
Const GL_EVAL_VERTEX_ATTRIB5_NV         =$86CB
Const GL_EVAL_VERTEX_ATTRIB6_NV         =$86CC
Const GL_EVAL_VERTEX_ATTRIB7_NV         =$86CD
Const GL_EVAL_VERTEX_ATTRIB8_NV         =$86CE
Const GL_EVAL_VERTEX_ATTRIB9_NV         =$86CF
Const GL_EVAL_VERTEX_ATTRIB10_NV        =$86D0
Const GL_EVAL_VERTEX_ATTRIB11_NV        =$86D1
Const GL_EVAL_VERTEX_ATTRIB12_NV        =$86D2
Const GL_EVAL_VERTEX_ATTRIB13_NV        =$86D3
Const GL_EVAL_VERTEX_ATTRIB14_NV        =$86D4
Const GL_EVAL_VERTEX_ATTRIB15_NV        =$86D5
Const GL_MAX_MAP_TESSELLATION_NV        =$86D6
Const GL_MAX_RATIONAL_EVAL_ORDER_NV     =$86D7
;#EndIf

;#ifndef GL_NV_packed_depth_stencil
Const GL_DEPTH_STENCIL_NV               =$84F9
Const GL_UNSIGNED_INT_24_8_NV           =$84FA
;#EndIf

;#ifndef GL_NV_register_combiners2
Const GL_PER_STAGE_CONSTANTS_NV         =$8535
;#EndIf

;#ifndef GL_NV_texture_compression_vtc
;#EndIf

;#ifndef GL_NV_texture_rectangle
Const GL_TEXTURE_RECTANGLE_NV           =$84F5
Const GL_TEXTURE_BINDING_RECTANGLE_NV   =$84F6
Const GL_PROXY_TEXTURE_RECTANGLE_NV     =$84F7
Const GL_MAX_RECTANGLE_TEXTURE_SIZE_NV  =$84F8
;#EndIf

;#ifndef GL_NV_texture_shader
Const GL_OFFSET_TEXTURE_RECTANGLE_NV    =$864C
Const GL_OFFSET_TEXTURE_RECTANGLE_SCALE_NV =$864D
Const GL_DOT_PRODUCT_TEXTURE_RECTANGLE_NV =$864E
Const GL_RGBA_UNSIGNED_DOT_PRODUCT_MAPPING_NV =$86D9
Const GL_UNSIGNED_INT_S8_S8_8_8_NV      =$86DA
Const GL_UNSIGNED_INT_8_8_S8_S8_REV_NV  =$86DB
Const GL_DSDT_MAG_INTENSITY_NV          =$86DC
Const GL_SHADER_CONSISTENT_NV           =$86DD
Const GL_TEXTURE_SHADER_NV              =$86DE
Const GL_SHADER_OPERATION_NV            =$86DF
Const GL_CULL_MODES_NV                  =$86E0
Const GL_OFFSET_TEXTURE_MATRIX_NV       =$86E1
Const GL_OFFSET_TEXTURE_SCALE_NV        =$86E2
Const GL_OFFSET_TEXTURE_BIAS_NV         =$86E3
Const GL_OFFSET_TEXTURE_2D_MATRIX_NV    =GL_OFFSET_TEXTURE_MATRIX_NV
Const GL_OFFSET_TEXTURE_2D_SCALE_NV     =GL_OFFSET_TEXTURE_SCALE_NV
Const GL_OFFSET_TEXTURE_2D_BIAS_NV      =GL_OFFSET_TEXTURE_BIAS_NV
Const GL_PREVIOUS_TEXTURE_INPUT_NV      =$86E4
Const GL_CONST_EYE_NV                   =$86E5
Const GL_PASS_THROUGH_NV                =$86E6
Const GL_CULL_FRAGMENT_NV               =$86E7
Const GL_OFFSET_TEXTURE_2D_NV           =$86E8
Const GL_DEPENDENT_AR_TEXTURE_2D_NV     =$86E9
Const GL_DEPENDENT_GB_TEXTURE_2D_NV     =$86EA
Const GL_DOT_PRODUCT_NV                 =$86EC
Const GL_DOT_PRODUCT_DEPTH_REPLACE_NV   =$86ED
Const GL_DOT_PRODUCT_TEXTURE_2D_NV      =$86EE
Const GL_DOT_PRODUCT_TEXTURE_CUBE_MAP_NV =$86F0
Const GL_DOT_PRODUCT_DIFFUSE_CUBE_MAP_NV =$86F1
Const GL_DOT_PRODUCT_REFLECT_CUBE_MAP_NV =$86F2
Const GL_DOT_PRODUCT_CONST_EYE_REFLECT_CUBE_MAP_NV =$86F3
Const GL_HILO_NV                        =$86F4
Const GL_DSDT_NV                        =$86F5
Const GL_DSDT_MAG_NV                    =$86F6
Const GL_DSDT_MAG_VIB_NV                =$86F7
Const GL_HILO16_NV                      =$86F8
Const GL_SIGNED_HILO_NV                 =$86F9
Const GL_SIGNED_HILO16_NV               =$86FA
Const GL_SIGNED_RGBA_NV                 =$86FB
Const GL_SIGNED_RGBA8_NV                =$86FC
Const GL_SIGNED_RGB_NV                  =$86FE
Const GL_SIGNED_RGB8_NV                 =$86FF
Const GL_SIGNED_LUMINANCE_NV            =$8701
Const GL_SIGNED_LUMINANCE8_NV           =$8702
Const GL_SIGNED_LUMINANCE_ALPHA_NV      =$8703
Const GL_SIGNED_LUMINANCE8_ALPHA8_NV    =$8704
Const GL_SIGNED_ALPHA_NV                =$8705
Const GL_SIGNED_ALPHA8_NV               =$8706
Const GL_SIGNED_INTENSITY_NV            =$8707
Const GL_SIGNED_INTENSITY8_NV           =$8708
Const GL_DSDT8_NV                       =$8709
Const GL_DSDT8_MAG8_NV                  =$870A
Const GL_DSDT8_MAG8_INTENSITY8_NV       =$870B
Const GL_SIGNED_RGB_UNSIGNED_ALPHA_NV   =$870C
Const GL_SIGNED_RGB8_UNSIGNED_ALPHA8_NV =$870D
Const GL_HI_SCALE_NV                    =$870E
Const GL_LO_SCALE_NV                    =$870F
Const GL_DS_SCALE_NV                    =$8710
Const GL_DT_SCALE_NV                    =$8711
Const GL_MAGNITUDE_SCALE_NV             =$8712
Const GL_VIBRANCE_SCALE_NV              =$8713
Const GL_HI_BIAS_NV                     =$8714
Const GL_LO_BIAS_NV                     =$8715
Const GL_DS_BIAS_NV                     =$8716
Const GL_DT_BIAS_NV                     =$8717
Const GL_MAGNITUDE_BIAS_NV              =$8718
Const GL_VIBRANCE_BIAS_NV               =$8719
Const GL_TEXTURE_BORDER_VALUES_NV       =$871A
Const GL_TEXTURE_HI_SIZE_NV             =$871B
Const GL_TEXTURE_LO_SIZE_NV             =$871C
Const GL_TEXTURE_DS_SIZE_NV             =$871D
Const GL_TEXTURE_DT_SIZE_NV             =$871E
Const GL_TEXTURE_MAG_SIZE_NV            =$871F
;#EndIf

;#ifndef GL_NV_texture_shader2
Const GL_DOT_PRODUCT_TEXTURE_3D_NV      =$86EF
;#EndIf

;#ifndef GL_NV_vertex_array_range2
Const GL_VERTEX_ARRAY_RANGE_WITHOUT_FLUSH_NV =$8533
;#EndIf

;#ifndef GL_NV_vertex_program
Const GL_VERTEX_PROGRAM_NV              =$8620
Const GL_VERTEX_STATE_PROGRAM_NV        =$8621
Const GL_ATTRIB_ARRAY_SIZE_NV           =$8623
Const GL_ATTRIB_ARRAY_STRIDE_NV         =$8624
Const GL_ATTRIB_ARRAY_TYPE_NV           =$8625
Const GL_CURRENT_ATTRIB_NV              =$8626
Const GL_PROGRAM_LENGTH_NV              =$8627
Const GL_PROGRAM_STRING_NV              =$8628
Const GL_MODELVIEW_PROJECTION_NV        =$8629
Const GL_IDENTITY_NV                    =$862A
Const GL_INVERSE_NV                     =$862B
Const GL_TRANSPOSE_NV                   =$862C
Const GL_INVERSE_TRANSPOSE_NV           =$862D
Const GL_MAX_TRACK_MATRIX_STACK_DEPTH_NV =$862E
Const GL_MAX_TRACK_MATRICES_NV          =$862F
Const GL_MATRIX0_NV                     =$8630
Const GL_MATRIX1_NV                     =$8631
Const GL_MATRIX2_NV                     =$8632
Const GL_MATRIX3_NV                     =$8633
Const GL_MATRIX4_NV                     =$8634
Const GL_MATRIX5_NV                     =$8635
Const GL_MATRIX6_NV                     =$8636
Const GL_MATRIX7_NV                     =$8637
Const GL_CURRENT_MATRIX_STACK_DEPTH_NV  =$8640
Const GL_CURRENT_MATRIX_NV              =$8641
Const GL_VERTEX_PROGRAM_POINT_SIZE_NV   =$8642
Const GL_VERTEX_PROGRAM_TWO_SIDE_NV     =$8643
Const GL_PROGRAM_PARAMETER_NV           =$8644
Const GL_ATTRIB_ARRAY_POINTER_NV        =$8645
Const GL_PROGRAM_TARGET_NV              =$8646
Const GL_PROGRAM_RESIDENT_NV            =$8647
Const GL_TRACK_MATRIX_NV                =$8648
Const GL_TRACK_MATRIX_TRANSFORM_NV      =$8649
Const GL_VERTEX_PROGRAM_BINDING_NV      =$864A
Const GL_PROGRAM_ERROR_POSITION_NV      =$864B
Const GL_VERTEX_ATTRIB_ARRAY0_NV        =$8650
Const GL_VERTEX_ATTRIB_ARRAY1_NV        =$8651
Const GL_VERTEX_ATTRIB_ARRAY2_NV        =$8652
Const GL_VERTEX_ATTRIB_ARRAY3_NV        =$8653
Const GL_VERTEX_ATTRIB_ARRAY4_NV        =$8654
Const GL_VERTEX_ATTRIB_ARRAY5_NV        =$8655
Const GL_VERTEX_ATTRIB_ARRAY6_NV        =$8656
Const GL_VERTEX_ATTRIB_ARRAY7_NV        =$8657
Const GL_VERTEX_ATTRIB_ARRAY8_NV        =$8658
Const GL_VERTEX_ATTRIB_ARRAY9_NV        =$8659
Const GL_VERTEX_ATTRIB_ARRAY10_NV       =$865A
Const GL_VERTEX_ATTRIB_ARRAY11_NV       =$865B
Const GL_VERTEX_ATTRIB_ARRAY12_NV       =$865C
Const GL_VERTEX_ATTRIB_ARRAY13_NV       =$865D
Const GL_VERTEX_ATTRIB_ARRAY14_NV       =$865E
Const GL_VERTEX_ATTRIB_ARRAY15_NV       =$865F
Const GL_MAP1_VERTEX_ATTRIB0_4_NV       =$8660
Const GL_MAP1_VERTEX_ATTRIB1_4_NV       =$8661
Const GL_MAP1_VERTEX_ATTRIB2_4_NV       =$8662
Const GL_MAP1_VERTEX_ATTRIB3_4_NV       =$8663
Const GL_MAP1_VERTEX_ATTRIB4_4_NV       =$8664
Const GL_MAP1_VERTEX_ATTRIB5_4_NV       =$8665
Const GL_MAP1_VERTEX_ATTRIB6_4_NV       =$8666
Const GL_MAP1_VERTEX_ATTRIB7_4_NV       =$8667
Const GL_MAP1_VERTEX_ATTRIB8_4_NV       =$8668
Const GL_MAP1_VERTEX_ATTRIB9_4_NV       =$8669
Const GL_MAP1_VERTEX_ATTRIB10_4_NV      =$866A
Const GL_MAP1_VERTEX_ATTRIB11_4_NV      =$866B
Const GL_MAP1_VERTEX_ATTRIB12_4_NV      =$866C
Const GL_MAP1_VERTEX_ATTRIB13_4_NV      =$866D
Const GL_MAP1_VERTEX_ATTRIB14_4_NV      =$866E
Const GL_MAP1_VERTEX_ATTRIB15_4_NV      =$866F
Const GL_MAP2_VERTEX_ATTRIB0_4_NV       =$8670
Const GL_MAP2_VERTEX_ATTRIB1_4_NV       =$8671
Const GL_MAP2_VERTEX_ATTRIB2_4_NV       =$8672
Const GL_MAP2_VERTEX_ATTRIB3_4_NV       =$8673
Const GL_MAP2_VERTEX_ATTRIB4_4_NV       =$8674
Const GL_MAP2_VERTEX_ATTRIB5_4_NV       =$8675
Const GL_MAP2_VERTEX_ATTRIB6_4_NV       =$8676
Const GL_MAP2_VERTEX_ATTRIB7_4_NV       =$8677
Const GL_MAP2_VERTEX_ATTRIB8_4_NV       =$8678
Const GL_MAP2_VERTEX_ATTRIB9_4_NV       =$8679
Const GL_MAP2_VERTEX_ATTRIB10_4_NV      =$867A
Const GL_MAP2_VERTEX_ATTRIB11_4_NV      =$867B
Const GL_MAP2_VERTEX_ATTRIB12_4_NV      =$867C
Const GL_MAP2_VERTEX_ATTRIB13_4_NV      =$867D
Const GL_MAP2_VERTEX_ATTRIB14_4_NV      =$867E
Const GL_MAP2_VERTEX_ATTRIB15_4_NV      =$867F
;#EndIf

;#ifndef GL_SGIX_texture_coordinate_clamp
Const GL_TEXTURE_MAX_CLAMP_S_SGIX       =$8369
Const GL_TEXTURE_MAX_CLAMP_T_SGIX       =$836A
Const GL_TEXTURE_MAX_CLAMP_R_SGIX       =$836B
;#EndIf

;#ifndef GL_SGIX_scalebias_hint
Const GL_SCALEBIAS_HINT_SGIX            =$8322
;#EndIf

;#ifndef GL_OML_interlace
Const GL_INTERLACE_OML                  =$8980
Const GL_INTERLACE_READ_OML             =$8981
;#EndIf

;#ifndef GL_OML_subsample
Const GL_FORMAT_SUBSAMPLE_24_24_OML     =$8982
Const GL_FORMAT_SUBSAMPLE_244_244_OML   =$8983
;#EndIf

;#ifndef GL_OML_resample
Const GL_PACK_RESAMPLE_OML              =$8984
Const GL_UNPACK_RESAMPLE_OML            =$8985
Const GL_RESAMPLE_REPLICATE_OML         =$8986
Const GL_RESAMPLE_ZERO_FILL_OML         =$8987
Const GL_RESAMPLE_AVERAGE_OML           =$8988
Const GL_RESAMPLE_DECIMATE_OML          =$8989
;#EndIf

;#ifndef GL_NV_copy_depth_to_color
Const GL_DEPTH_STENCIL_TO_RGBA_NV       =$886E
Const GL_DEPTH_STENCIL_TO_BGRA_NV       =$886F
;#EndIf

;#ifndef GL_ATI_envmap_bumpmap
Const GL_BUMP_ROT_MATRIX_ATI            =$8775
Const GL_BUMP_ROT_MATRIX_SIZE_ATI       =$8776
Const GL_BUMP_NUM_TEX_UNITS_ATI         =$8777
Const GL_BUMP_TEX_UNITS_ATI             =$8778
Const GL_DUDV_ATI                       =$8779
Const GL_DU8DV8_ATI                     =$877A
Const GL_BUMP_ENVMAP_ATI                =$877B
Const GL_BUMP_TARGET_ATI                =$877C
;#EndIf

;#ifndef GL_ATI_fragment_shader
Const GL_FRAGMENT_SHADER_ATI            =$8920
Const GL_REG_0_ATI                      =$8921
Const GL_REG_1_ATI                      =$8922
Const GL_REG_2_ATI                      =$8923
Const GL_REG_3_ATI                      =$8924
Const GL_REG_4_ATI                      =$8925
Const GL_REG_5_ATI                      =$8926
Const GL_REG_6_ATI                      =$8927
Const GL_REG_7_ATI                      =$8928
Const GL_REG_8_ATI                      =$8929
Const GL_REG_9_ATI                      =$892A
Const GL_REG_10_ATI                     =$892B
Const GL_REG_11_ATI                     =$892C
Const GL_REG_12_ATI                     =$892D
Const GL_REG_13_ATI                     =$892E
Const GL_REG_14_ATI                     =$892F
Const GL_REG_15_ATI                     =$8930
Const GL_REG_16_ATI                     =$8931
Const GL_REG_17_ATI                     =$8932
Const GL_REG_18_ATI                     =$8933
Const GL_REG_19_ATI                     =$8934
Const GL_REG_20_ATI                     =$8935
Const GL_REG_21_ATI                     =$8936
Const GL_REG_22_ATI                     =$8937
Const GL_REG_23_ATI                     =$8938
Const GL_REG_24_ATI                     =$8939
Const GL_REG_25_ATI                     =$893A
Const GL_REG_26_ATI                     =$893B
Const GL_REG_27_ATI                     =$893C
Const GL_REG_28_ATI                     =$893D
Const GL_REG_29_ATI                     =$893E
Const GL_REG_30_ATI                     =$893F
Const GL_REG_31_ATI                     =$8940
Const GL_CON_0_ATI                      =$8941
Const GL_CON_1_ATI                      =$8942
Const GL_CON_2_ATI                      =$8943
Const GL_CON_3_ATI                      =$8944
Const GL_CON_4_ATI                      =$8945
Const GL_CON_5_ATI                      =$8946
Const GL_CON_6_ATI                      =$8947
Const GL_CON_7_ATI                      =$8948
Const GL_CON_8_ATI                      =$8949
Const GL_CON_9_ATI                      =$894A
Const GL_CON_10_ATI                     =$894B
Const GL_CON_11_ATI                     =$894C
Const GL_CON_12_ATI                     =$894D
Const GL_CON_13_ATI                     =$894E
Const GL_CON_14_ATI                     =$894F
Const GL_CON_15_ATI                     =$8950
Const GL_CON_16_ATI                     =$8951
Const GL_CON_17_ATI                     =$8952
Const GL_CON_18_ATI                     =$8953
Const GL_CON_19_ATI                     =$8954
Const GL_CON_20_ATI                     =$8955
Const GL_CON_21_ATI                     =$8956
Const GL_CON_22_ATI                     =$8957
Const GL_CON_23_ATI                     =$8958
Const GL_CON_24_ATI                     =$8959
Const GL_CON_25_ATI                     =$895A
Const GL_CON_26_ATI                     =$895B
Const GL_CON_27_ATI                     =$895C
Const GL_CON_28_ATI                     =$895D
Const GL_CON_29_ATI                     =$895E
Const GL_CON_30_ATI                     =$895F
Const GL_CON_31_ATI                     =$8960
Const GL_MOV_ATI                        =$8961
Const GL_ADD_ATI                        =$8963
Const GL_MUL_ATI                        =$8964
Const GL_SUB_ATI                        =$8965
Const GL_DOT3_ATI                       =$8966
Const GL_DOT4_ATI                       =$8967
Const GL_MAD_ATI                        =$8968
Const GL_LERP_ATI                       =$8969
Const GL_CND_ATI                        =$896A
Const GL_CND0_ATI                       =$896B
Const GL_DOT2_ADD_ATI                   =$896C
Const GL_SECONDARY_INTERPOLATOR_ATI     =$896D
Const GL_NUM_FRAGMENT_REGISTERS_ATI     =$896E
Const GL_NUM_FRAGMENT_CONSTANTS_ATI     =$896F
Const GL_NUM_PASSES_ATI                 =$8970
Const GL_NUM_INSTRUCTIONS_PER_PASS_ATI  =$8971
Const GL_NUM_INSTRUCTIONS_TOTAL_ATI     =$8972
Const GL_NUM_INPUT_INTERPOLATOR_COMPONENTS_ATI =$8973
Const GL_NUM_LOOPBACK_COMPONENTS_ATI    =$8974
Const GL_COLOR_ALPHA_PAIRING_ATI        =$8975
Const GL_SWIZZLE_STR_ATI                =$8976
Const GL_SWIZZLE_STQ_ATI                =$8977
Const GL_SWIZZLE_STR_DR_ATI             =$8978
Const GL_SWIZZLE_STQ_DQ_ATI             =$8979
Const GL_SWIZZLE_STRQ_ATI               =$897A
Const GL_SWIZZLE_STRQ_DQ_ATI            =$897B
Const GL_RED_BIT_ATI                    =$00000001
Const GL_GREEN_BIT_ATI                  =$00000002
Const GL_BLUE_BIT_ATI                   =$00000004
Const GL_2X_BIT_ATI                     =$00000001
Const GL_4X_BIT_ATI                     =$00000002
Const GL_8X_BIT_ATI                     =$00000004
Const GL_HALF_BIT_ATI                   =$00000008
Const GL_QUARTER_BIT_ATI                =$00000010
Const GL_EIGHTH_BIT_ATI                 =$00000020
Const GL_SATURATE_BIT_ATI               =$00000040
Const GL_COMP_BIT_ATI                   =$00000002
Const GL_NEGATE_BIT_ATI                 =$00000004
Const GL_BIAS_BIT_ATI                   =$00000008
;#EndIf

;#ifndef GL_ATI_pn_triangles
Const GL_PN_TRIANGLES_ATI               =$87F0
Const GL_MAX_PN_TRIANGLES_TESSELATION_LEVEL_ATI =$87F1
Const GL_PN_TRIANGLES_POINT_MODE_ATI    =$87F2
Const GL_PN_TRIANGLES_NORMAL_MODE_ATI   =$87F3
Const GL_PN_TRIANGLES_TESSELATION_LEVEL_ATI =$87F4
Const GL_PN_TRIANGLES_POINT_MODE_LINEAR_ATI =$87F5
Const GL_PN_TRIANGLES_POINT_MODE_CUBIC_ATI =$87F6
Const GL_PN_TRIANGLES_NORMAL_MODE_LINEAR_ATI =$87F7
Const GL_PN_TRIANGLES_NORMAL_MODE_QUADRATIC_ATI =$87F8
;#EndIf

;#ifndef GL_ATI_vertex_array_object
Const GL_STATIC_ATI                     =$8760
Const GL_DYNAMIC_ATI                    =$8761
Const GL_PRESERVE_ATI                   =$8762
Const GL_DISCARD_ATI                    =$8763
Const GL_OBJECT_BUFFER_SIZE_ATI         =$8764
Const GL_OBJECT_BUFFER_USAGE_ATI        =$8765
Const GL_ARRAY_OBJECT_BUFFER_ATI        =$8766
Const GL_ARRAY_OBJECT_OFFSET_ATI        =$8767
;#EndIf

;#ifndef GL_EXT_vertex_shader
Const GL_VERTEX_SHADER_EXT              =$8780
Const GL_VERTEX_SHADER_BINDING_EXT      =$8781
Const GL_OP_INDEX_EXT                   =$8782
Const GL_OP_NEGATE_EXT                  =$8783
Const GL_OP_DOT3_EXT                    =$8784
Const GL_OP_DOT4_EXT                    =$8785
Const GL_OP_MUL_EXT                     =$8786
Const GL_OP_ADD_EXT                     =$8787
Const GL_OP_MADD_EXT                    =$8788
Const GL_OP_FRAC_EXT                    =$8789
Const GL_OP_MAX_EXT                     =$878A
Const GL_OP_MIN_EXT                     =$878B
Const GL_OP_SET_GE_EXT                  =$878C
Const GL_OP_SET_LT_EXT                  =$878D
Const GL_OP_CLAMP_EXT                   =$878E
Const GL_OP_FLOOR_EXT                   =$878F
Const GL_OP_ROUND_EXT                   =$8790
Const GL_OP_EXP_BASE_2_EXT              =$8791
Const GL_OP_LOG_BASE_2_EXT              =$8792
Const GL_OP_POWER_EXT                   =$8793
Const GL_OP_RECIP_EXT                   =$8794
Const GL_OP_RECIP_SQRT_EXT              =$8795
Const GL_OP_SUB_EXT                     =$8796
Const GL_OP_CROSS_PRODUCT_EXT           =$8797
Const GL_OP_MULTIPLY_MATRIX_EXT         =$8798
Const GL_OP_MOV_EXT                     =$8799
Const GL_OUTPUT_VERTEX_EXT              =$879A
Const GL_OUTPUT_COLOR0_EXT              =$879B
Const GL_OUTPUT_COLOR1_EXT              =$879C
Const GL_OUTPUT_TEXTURE_COORD0_EXT      =$879D
Const GL_OUTPUT_TEXTURE_COORD1_EXT      =$879E
Const GL_OUTPUT_TEXTURE_COORD2_EXT      =$879F
Const GL_OUTPUT_TEXTURE_COORD3_EXT      =$87A0
Const GL_OUTPUT_TEXTURE_COORD4_EXT      =$87A1
Const GL_OUTPUT_TEXTURE_COORD5_EXT      =$87A2
Const GL_OUTPUT_TEXTURE_COORD6_EXT      =$87A3
Const GL_OUTPUT_TEXTURE_COORD7_EXT      =$87A4
Const GL_OUTPUT_TEXTURE_COORD8_EXT      =$87A5
Const GL_OUTPUT_TEXTURE_COORD9_EXT      =$87A6
Const GL_OUTPUT_TEXTURE_COORD10_EXT     =$87A7
Const GL_OUTPUT_TEXTURE_COORD11_EXT     =$87A8
Const GL_OUTPUT_TEXTURE_COORD12_EXT     =$87A9
Const GL_OUTPUT_TEXTURE_COORD13_EXT     =$87AA
Const GL_OUTPUT_TEXTURE_COORD14_EXT     =$87AB
Const GL_OUTPUT_TEXTURE_COORD15_EXT     =$87AC
Const GL_OUTPUT_TEXTURE_COORD16_EXT     =$87AD
Const GL_OUTPUT_TEXTURE_COORD17_EXT     =$87AE
Const GL_OUTPUT_TEXTURE_COORD18_EXT     =$87AF
Const GL_OUTPUT_TEXTURE_COORD19_EXT     =$87B0
Const GL_OUTPUT_TEXTURE_COORD20_EXT     =$87B1
Const GL_OUTPUT_TEXTURE_COORD21_EXT     =$87B2
Const GL_OUTPUT_TEXTURE_COORD22_EXT     =$87B3
Const GL_OUTPUT_TEXTURE_COORD23_EXT     =$87B4
Const GL_OUTPUT_TEXTURE_COORD24_EXT     =$87B5
Const GL_OUTPUT_TEXTURE_COORD25_EXT     =$87B6
Const GL_OUTPUT_TEXTURE_COORD26_EXT     =$87B7
Const GL_OUTPUT_TEXTURE_COORD27_EXT     =$87B8
Const GL_OUTPUT_TEXTURE_COORD28_EXT     =$87B9
Const GL_OUTPUT_TEXTURE_COORD29_EXT     =$87BA
Const GL_OUTPUT_TEXTURE_COORD30_EXT     =$87BB
Const GL_OUTPUT_TEXTURE_COORD31_EXT     =$87BC
Const GL_OUTPUT_FOG_EXT                 =$87BD
Const GL_SCALAR_EXT                     =$87BE
Const GL_VECTOR_EXT                     =$87BF
Const GL_MATRIX_EXT                     =$87C0
Const GL_VARIANT_EXT                    =$87C1
Const GL_INVARIANT_EXT                  =$87C2
Const GL_LOCAL_CONSTANT_EXT             =$87C3
Const GL_LOCAL_EXT                      =$87C4
Const GL_MAX_VERTEX_SHADER_INSTRUCTIONS_EXT =$87C5
Const GL_MAX_VERTEX_SHADER_VARIANTS_EXT =$87C6
Const GL_MAX_VERTEX_SHADER_INVARIANTS_EXT =$87C7
Const GL_MAX_VERTEX_SHADER_LOCAL_CONSTANTS_EXT =$87C8
Const GL_MAX_VERTEX_SHADER_LOCALS_EXT   =$87C9
Const GL_MAX_OPTIMIZED_VERTEX_SHADER_INSTRUCTIONS_EXT =$87CA
Const GL_MAX_OPTIMIZED_VERTEX_SHADER_VARIANTS_EXT =$87CB
Const GL_MAX_OPTIMIZED_VERTEX_SHADER_LOCAL_CONSTANTS_EXT =$87CC
Const GL_MAX_OPTIMIZED_VERTEX_SHADER_INARIANTS_EXT =$87CD
Const GL_MAX_OPTIMIZED_VERTEX_SHADER_LOCALS_EXT =$87CE
Const GL_VERTEX_SHADER_INSTRUCTIONS_EXT =$87CF
Const GL_VERTEX_SHADER_VARIANTS_EXT     =$87D0
Const GL_VERTEX_SHADER_INVARIANTS_EXT   =$87D1
Const GL_VERTEX_SHADER_LOCAL_CONSTANTS_EXT =$87D2
Const GL_VERTEX_SHADER_LOCALS_EXT       =$87D3
Const GL_VERTEX_SHADER_OPTIMIZED_EXT    =$87D4
Const GL_X_EXT                          =$87D5
Const GL_Y_EXT                          =$87D6
Const GL_Z_EXT                          =$87D7
Const GL_W_EXT                          =$87D8
Const GL_NEGATIVE_X_EXT                 =$87D9
Const GL_NEGATIVE_Y_EXT                 =$87DA
Const GL_NEGATIVE_Z_EXT                 =$87DB
Const GL_NEGATIVE_W_EXT                 =$87DC
Const GL_ZERO_EXT                       =$87DD
Const GL_ONE_EXT                        =$87DE
Const GL_NEGATIVE_ONE_EXT               =$87DF
Const GL_NORMALIZED_RANGE_EXT           =$87E0
Const GL_FULL_RANGE_EXT                 =$87E1
Const GL_CURRENT_VERTEX_EXT             =$87E2
Const GL_MVP_MATRIX_EXT                 =$87E3
Const GL_VARIANT_VALUE_EXT              =$87E4
Const GL_VARIANT_DATATYPE_EXT           =$87E5
Const GL_VARIANT_ARRAY_STRIDE_EXT       =$87E6
Const GL_VARIANT_ARRAY_TYPE_EXT         =$87E7
Const GL_VARIANT_ARRAY_EXT              =$87E8
Const GL_VARIANT_ARRAY_POINTER_EXT      =$87E9
Const GL_INVARIANT_VALUE_EXT            =$87EA
Const GL_INVARIANT_DATATYPE_EXT         =$87EB
Const GL_LOCAL_CONSTANT_VALUE_EXT       =$87EC
Const GL_LOCAL_CONSTANT_DATATYPE_EXT    =$87ED
;#EndIf

;#ifndef GL_ATI_vertex_streams
Const GL_MAX_VERTEX_STREAMS_ATI         =$876B
Const GL_VERTEX_STREAM0_ATI             =$876C
Const GL_VERTEX_STREAM1_ATI             =$876D
Const GL_VERTEX_STREAM2_ATI             =$876E
Const GL_VERTEX_STREAM3_ATI             =$876F
Const GL_VERTEX_STREAM4_ATI             =$8770
Const GL_VERTEX_STREAM5_ATI             =$8771
Const GL_VERTEX_STREAM6_ATI             =$8772
Const GL_VERTEX_STREAM7_ATI             =$8773
Const GL_VERTEX_SOURCE_ATI              =$8774
;#EndIf

;#ifndef GL_ATI_element_array
Const GL_ELEMENT_ARRAY_ATI              =$8768
Const GL_ELEMENT_ARRAY_TYPE_ATI         =$8769
Const GL_ELEMENT_ARRAY_POINTER_ATI      =$876A
;#EndIf

;#ifndef GL_SUN_mesh_array
Const GL_QUAD_MESH_SUN                  =$8614
Const GL_TRIANGLE_MESH_SUN              =$8615
;#EndIf

;#ifndef GL_SUN_slice_accum
Const GL_SLICE_ACCUM_SUN                =$85CC
;#EndIf

;#ifndef GL_NV_multisample_filter_hint
Const GL_MULTISAMPLE_FILTER_HINT_NV     =$8534
;#EndIf

;#ifndef GL_NV_depth_clamp
Const GL_DEPTH_CLAMP_NV                 =$864F
;#EndIf

;#ifndef GL_NV_occlusion_query
Const GL_PIXEL_COUNTER_BITS_NV          =$8864
Const GL_CURRENT_OCCLUSION_QUERY_ID_NV  =$8865
Const GL_PIXEL_COUNT_NV                 =$8866
Const GL_PIXEL_COUNT_AVAILABLE_NV       =$8867
;#EndIf

;#ifndef GL_NV_point_sprite
Const GL_POINT_SPRITE_NV                =$8861
Const GL_COORD_REPLACE_NV               =$8862
Const GL_POINT_SPRITE_R_MODE_NV         =$8863
;#EndIf

;#ifndef GL_NV_texture_shader3
Const GL_OFFSET_PROJECTIVE_TEXTURE_2D_NV =$8850
Const GL_OFFSET_PROJECTIVE_TEXTURE_2D_SCALE_NV =$8851
Const GL_OFFSET_PROJECTIVE_TEXTURE_RECTANGLE_NV =$8852
Const GL_OFFSET_PROJECTIVE_TEXTURE_RECTANGLE_SCALE_NV =$8853
Const GL_OFFSET_HILO_TEXTURE_2D_NV      =$8854
Const GL_OFFSET_HILO_TEXTURE_RECTANGLE_NV =$8855
Const GL_OFFSET_HILO_PROJECTIVE_TEXTURE_2D_NV =$8856
Const GL_OFFSET_HILO_PROJECTIVE_TEXTURE_RECTANGLE_NV =$8857
Const GL_DEPENDENT_HILO_TEXTURE_2D_NV   =$8858
Const GL_DEPENDENT_RGB_TEXTURE_3D_NV    =$8859
Const GL_DEPENDENT_RGB_TEXTURE_CUBE_MAP_NV =$885A
Const GL_DOT_PRODUCT_PASS_THROUGH_NV    =$885B
Const GL_DOT_PRODUCT_TEXTURE_1D_NV      =$885C
Const GL_DOT_PRODUCT_AFFINE_DEPTH_REPLACE_NV =$885D
Const GL_HILO8_NV                       =$885E
Const GL_SIGNED_HILO8_NV                =$885F
Const GL_FORCE_BLUE_TO_ONE_NV           =$8860
;#EndIf

;#ifndef GL_NV_vertex_program1_1
;#EndIf

;#ifndef GL_EXT_shadow_funcs
;#EndIf

;#ifndef GL_EXT_stencil_two_side
Const GL_STENCIL_TEST_TWO_SIDE_EXT      =$8910
Const GL_ACTIVE_STENCIL_FACE_EXT        =$8911
;#EndIf



Const GL_COLOR_SUM_ARB                  =$8458
Const GL_VERTEX_PROGRAM_ARB             =$8620
Const GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB =$8622
Const GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB   =$8623
Const GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB =$8624
Const GL_VERTEX_ATTRIB_ARRAY_TYPE_ARB   =$8625
Const GL_CURRENT_VERTEX_ATTRIB_ARB      =$8626
Const GL_PROGRAM_LENGTH_ARB             =$8627
Const GL_PROGRAM_STRING_ARB             =$8628
Const GL_MAX_PROGRAM_MATRIX_STACK_DEPTH_ARB =$862E
Const GL_MAX_PROGRAM_MATRICES_ARB       =$862F
Const GL_CURRENT_MATRIX_STACK_DEPTH_ARB =$8640
Const GL_CURRENT_MATRIX_ARB             =$8641
Const GL_VERTEX_PROGRAM_POINT_SIZE_ARB  =$8642
Const GL_VERTEX_PROGRAM_TWO_SIDE_ARB    =$8643
Const GL_VERTEX_ATTRIB_ARRAY_POINTER_ARB =$8645
Const GL_PROGRAM_ERROR_POSITION_ARB     =$864B
Const GL_PROGRAM_BINDING_ARB            =$8677
Const GL_MAX_VERTEX_ATTRIBS_ARB         =$8869
Const GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB =$886A
Const GL_PROGRAM_ERROR_STRING_ARB       =$8874
Const GL_PROGRAM_FORMAT_ASCII_ARB       =$8875
Const GL_PROGRAM_FORMAT_ARB             =$8876
Const GL_PROGRAM_INSTRUCTIONS_ARB       =$88A0
Const GL_MAX_PROGRAM_INSTRUCTIONS_ARB   =$88A1
Const GL_PROGRAM_NATIVE_INSTRUCTIONS_ARB =$88A2
Const GL_MAX_PROGRAM_NATIVE_INSTRUCTIONS_ARB =$88A3
Const GL_PROGRAM_TEMPORARIES_ARB        =$88A4
Const GL_MAX_PROGRAM_TEMPORARIES_ARB    =$88A5
Const GL_PROGRAM_NATIVE_TEMPORARIES_ARB =$88A6
Const GL_MAX_PROGRAM_NATIVE_TEMPORARIES_ARB =$88A7
Const GL_PROGRAM_PARAMETERS_ARB         =$88A8
Const GL_MAX_PROGRAM_PARAMETERS_ARB     =$88A9
Const GL_PROGRAM_NATIVE_PARAMETERS_ARB  =$88AA
Const GL_MAX_PROGRAM_NATIVE_PARAMETERS_ARB =$88AB
Const GL_PROGRAM_ATTRIBS_ARB            =$88AC
Const GL_MAX_PROGRAM_ATTRIBS_ARB        =$88AD
Const GL_PROGRAM_NATIVE_ATTRIBS_ARB     =$88AE
Const GL_MAX_PROGRAM_NATIVE_ATTRIBS_ARB =$88AF
Const GL_PROGRAM_ADDRESS_REGISTERS_ARB  =$88B0
Const GL_MAX_PROGRAM_ADDRESS_REGISTERS_ARB =$88B1
Const GL_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB =$88B2
Const GL_MAX_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB =$88B3
Const GL_MAX_PROGRAM_LOCAL_PARAMETERS_ARB =$88B4
Const GL_MAX_PROGRAM_ENV_PARAMETERS_ARB =$88B5
Const GL_PROGRAM_UNDER_NATIVE_LIMITS_ARB =$88B6
Const GL_TRANSPOSE_CURRENT_MATRIX_ARB   =$88B7
Const GL_MATRIX0_ARB                    =$88C0
Const GL_MATRIX1_ARB                    =$88C1
Const GL_MATRIX2_ARB                    =$88C2
Const GL_MATRIX3_ARB                    =$88C3
Const GL_MATRIX4_ARB                    =$88C4
Const GL_MATRIX5_ARB                    =$88C5
Const GL_MATRIX6_ARB                    =$88C6
Const GL_MATRIX7_ARB                    =$88C7
Const GL_MATRIX8_ARB                    =$88C8
Const GL_MATRIX9_ARB                    =$88C9
Const GL_MATRIX10_ARB                   =$88CA
Const GL_MATRIX11_ARB                   =$88CB
Const GL_MATRIX12_ARB                   =$88CC
Const GL_MATRIX13_ARB                   =$88CD
Const GL_MATRIX14_ARB                   =$88CE
Const GL_MATRIX15_ARB                   =$88CF
Const GL_MATRIX16_ARB                   =$88D0
Const GL_MATRIX17_ARB                   =$88D1
Const GL_MATRIX18_ARB                   =$88D2
Const GL_MATRIX19_ARB                   =$88D3
Const GL_MATRIX20_ARB                   =$88D4
Const GL_MATRIX21_ARB                   =$88D5
Const GL_MATRIX22_ARB                   =$88D6
Const GL_MATRIX23_ARB                   =$88D7
Const GL_MATRIX24_ARB                   =$88D8
Const GL_MATRIX25_ARB                   =$88D9
Const GL_MATRIX26_ARB                   =$88DA
Const GL_MATRIX27_ARB                   =$88DB
Const GL_MATRIX28_ARB                   =$88DC
Const GL_MATRIX29_ARB                   =$88DD
Const GL_MATRIX30_ARB                   =$88DE
Const GL_MATRIX31_ARB                   =$88DF
