package dji.midware.ar.min3d.animation;

import dji.midware.ar.min3d.vos.Number3d;

public class KeyFrame
{
  private int[] indices;
  private String name;
  private float[] normals;
  private float[] vertices;
  
  public KeyFrame(String paramString, float[] paramArrayOfFloat)
  {
    this.name = paramString;
    this.vertices = paramArrayOfFloat;
  }
  
  public KeyFrame(String paramString, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this(paramString, paramArrayOfFloat1);
    this.normals = paramArrayOfFloat2;
  }
  
  public Number3d calculateFaceNormal(Number3d paramNumber3d1, Number3d paramNumber3d2, Number3d paramNumber3d3)
  {
    return null;
  }
  
  public KeyFrame clone()
  {
    return null;
  }
  
  public int[] getIndices()
  {
    return this.indices;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public float[] getNormals()
  {
    return this.normals;
  }
  
  public float[] getVertices()
  {
    return this.vertices;
  }
  
  /* Error */
  public void setIndices(int[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\animation\KeyFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */