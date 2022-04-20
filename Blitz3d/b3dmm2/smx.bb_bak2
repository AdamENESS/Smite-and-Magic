Function SaveMeshX(mesh,file$) 
;single surface at the moment 
cnt=CountSurfaces(mesh) 
If cnt=0 Then Return 

;TODO Multi surface support 
surfa=GetSurface(mesh,1) 

out=WriteFile(file$) 
WriteLine out,"xof 0302txt 0064" 
WriteLine out,"" 
WriteLine out,"Header {" 
WriteLine out," 1;" 
WriteLine out," 0;" 
WriteLine out," 1;" 
WriteLine out,"}" 
WriteLine out,"" 
WriteLine out,"Frame frm_Scene_Root {" 
WriteLine out," FrameTransformMatrix {" 
WriteLine out," 1.000000,0.000000,0.000000,0.000000," 
WriteLine out," 0.000000,1.000000,0.000000,0.000000," 
WriteLine out," 0.000000,0.000000,1.000000,0.000000," 
WriteLine out," 0.000000,0.000000,0.000000,1.000000;" 
WriteLine out,"}" 
WriteLine out,"" 
name$=EntityName$(mesh) 
If name$="" Then name$="Unknown" 
WriteLine out,"Frame frm_"+name$+" {" 
WriteLine out," FrameTransformMatrix {" 
WriteLine out," 1.000000,0.000000,0.000000,0.000000," 
WriteLine out," 0.000000,1.000000,0.000000,0.000000," 
WriteLine out," 0.000000,0.000000,1.000000,0.000000," 
WriteLine out," 0.000000,0.000000,0.000000,1.000000;" 
WriteLine out,"}" 
WriteLine out,"" 
WriteLine out," Mesh frm_"+name$+" {" 
WriteLine out,CountVertices(surfa)+";" 
For a=0 To CountVertices(surfa)-1 
WriteLine out,VertexX(surfa,a)+";"+VertexY(surfa,a)+";"+VertexZ(surfa,a)+";," 
Next 
WriteLine out,"" 
WriteLine out," "+CountTriangles(surfa)+";" 
For a=0 To CountTriangles(surfa)-1 
in1=TriangleVertex(surfa,a,0) 
in2=TriangleVertex(surfa,a,1) 
in3=TriangleVertex(surfa,a,2) 
ln$=" 3;"+in1+","+in2+","+in3+";" 
If a=CountTriangles(surfa)-1 Then ln$=ln$+";" Else ln$=ln$+"," 
WriteLine out,ln$ 
Next 
WriteLine out,"" 

WriteLine out,"MeshMaterialList {" 
WriteLine out,"1;" 
WriteLine out,"1;" 
WriteLine out,"0;;" 
WriteLine out,"" 
WriteLine out,"Material {" 

WriteLine out," 1.000000,1.000000,1.000000,1.000000;;";rgba 
WriteLine out," 1.000000;" 
WriteLine out," 0.500000,0.500000,0.500000;;" 
WriteLine out," 0.000000,0.000000,0.000000;;" 
WriteLine out,"}" 
WriteLine out,"}" 
WriteLine out,"" 
WriteLine out,"MeshNormals {" 
WriteLine out,CountVertices(surfa)+";" 
For a=0 To CountVertices(surfa)-1 
WriteLine out,VertexNX(surfa,a)+";"+VertexNY(surfa,a)+";"+VertexNZ(surfa,a)+";," 
Next 
WriteLine out," "+CountTriangles(surfa)+";" 
For a=0 To CountTriangles(surfa)-1 
in1=TriangleVertex(surfa,a,0) 
in2=TriangleVertex(surfa,a,1) 
in3=TriangleVertex(surfa,a,2) 
ln$=" 3;"+in1+","+in2+","+in3+";" 
If a=CountTriangles(surfa)-1 Then ln$=ln$+";" Else ln$=ln$+"," 
WriteLine out,ln$ 
Next 
WriteLine out,"}" 
WriteLine out,"" 

WriteLine out,"MeshTextureCoords {" 
WriteLine out,CountVertices(surfa)+";" 
For a=0 To CountVertices(surfa)-1 
ln$=VertexU(surfa,a)+";"+VertexV(surfa,a)+";" 
If a=CountVertices(surfa)-1 Then ln$=ln$+";" Else ln$=ln$+"," 
WriteLine out,ln$ 
Next 
WriteLine out," }" 
WriteLine out," }" 
WriteLine out," }" 
WriteLine out,"}" 
CloseFile out 
End Function