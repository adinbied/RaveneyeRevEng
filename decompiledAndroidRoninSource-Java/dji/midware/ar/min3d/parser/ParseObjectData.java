package dji.midware.ar.min3d.parser;

import dji.midware.ar.min3d.animation.AnimationObject3d;
import dji.midware.ar.min3d.animation.KeyFrame;
import dji.midware.ar.min3d.core.Object3d;
import dji.midware.ar.min3d.vos.Number3d;
import dji.midware.ar.min3d.vos.Uv;
import java.util.ArrayList;
import java.util.HashMap;

public class ParseObjectData
{
  protected ArrayList<ParseObjectFace> faces;
  public String name;
  protected ArrayList<Number3d> normals;
  protected int numFaces = 0;
  protected ArrayList<Uv> texCoords;
  protected ArrayList<Number3d> vertices;
  
  public ParseObjectData()
  {
    this.vertices = new ArrayList();
    this.texCoords = new ArrayList();
    this.normals = new ArrayList();
    this.name = "";
    this.faces = new ArrayList();
  }
  
  public ParseObjectData(ArrayList<Number3d> paramArrayList1, ArrayList<Uv> paramArrayList, ArrayList<Number3d> paramArrayList2)
  {
    this.vertices = paramArrayList1;
    this.texCoords = paramArrayList;
    this.normals = paramArrayList2;
    this.name = "";
    this.faces = new ArrayList();
  }
  
  /* Error */
  private void parseObject(Object3d arg1, HashMap<String, AParser.Material> arg2, AParser.TextureAtlas arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void calculateFaceNormal(ParseObjectFace arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void cleanup()
  {
    this.faces.clear();
  }
  
  public AnimationObject3d getParsedObject(AParser.TextureAtlas paramTextureAtlas, HashMap<String, AParser.Material> paramHashMap, KeyFrame[] paramArrayOfKeyFrame)
  {
    return null;
  }
  
  public Object3d getParsedObject(HashMap<String, AParser.Material> paramHashMap, AParser.TextureAtlas paramTextureAtlas)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\parser\ParseObjectData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */