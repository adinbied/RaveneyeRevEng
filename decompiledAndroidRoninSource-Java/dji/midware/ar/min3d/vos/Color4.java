package dji.midware.ar.min3d.vos;

import java.nio.FloatBuffer;

public class Color4
{
  public short a;
  public short b;
  public short g;
  public short r;
  
  public Color4()
  {
    this.r = 255;
    this.g = 255;
    this.b = 255;
    this.a = 255;
  }
  
  public Color4(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.r = ((short)(int)paramFloat1);
    this.g = ((short)(int)paramFloat2);
    this.b = ((short)(int)paramFloat3);
    this.a = ((short)(int)paramFloat4);
  }
  
  public Color4(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.r = ((short)paramInt1);
    this.g = ((short)paramInt2);
    this.b = ((short)paramInt3);
    this.a = ((short)paramInt4);
  }
  
  public Color4(short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    this.r = paramShort1;
    this.g = paramShort2;
    this.b = paramShort3;
    this.a = paramShort4;
  }
  
  /* Error */
  public void setAll(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void setAll(short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    this.r = paramShort1;
    this.g = paramShort2;
    this.b = paramShort3;
    this.a = paramShort4;
  }
  
  public FloatBuffer toFloatBuffer()
  {
    return null;
  }
  
  /* Error */
  public void toFloatBuffer(FloatBuffer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\Color4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */