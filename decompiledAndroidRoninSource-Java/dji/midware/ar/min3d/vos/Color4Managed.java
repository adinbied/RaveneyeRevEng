package dji.midware.ar.min3d.vos;

import dji.midware.ar.min3d.interfaces.IDirtyParent;
import java.nio.FloatBuffer;

public class Color4Managed
  extends AbstractDirtyManaged
{
  private short _a;
  private short _b;
  private FloatBuffer _fb;
  private short _g;
  private short _r;
  
  public Color4Managed(int paramInt1, int paramInt2, int paramInt3, int paramInt4, IDirtyParent paramIDirtyParent)
  {
    super(paramIDirtyParent);
    this._r = ((short)paramInt1);
    this._g = ((short)paramInt2);
    this._b = ((short)paramInt3);
    this._a = ((short)paramInt4);
    this._fb = toFloatBuffer();
    setDirtyFlag();
  }
  
  public Color4Managed(IDirtyParent paramIDirtyParent)
  {
    super(paramIDirtyParent);
    this._r = 255;
    this._g = 255;
    this._b = 255;
    this._a = 255;
    this._fb = toFloatBuffer();
    setDirtyFlag();
  }
  
  public Color4Managed(short paramShort1, short paramShort2, short paramShort3, short paramShort4, IDirtyParent paramIDirtyParent)
  {
    super(paramIDirtyParent);
    this._r = paramShort1;
    this._g = paramShort2;
    this._b = paramShort3;
    this._a = paramShort4;
    this._fb = toFloatBuffer();
    setDirtyFlag();
  }
  
  public short a()
  {
    return this._a;
  }
  
  public void a(short paramShort)
  {
    this._a = paramShort;
    setDirtyFlag();
  }
  
  public short b()
  {
    return this._b;
  }
  
  public void b(short paramShort)
  {
    this._b = paramShort;
    setDirtyFlag();
  }
  
  public void commitToFloatBuffer()
  {
    toFloatBuffer(this._fb);
  }
  
  public FloatBuffer floatBuffer()
  {
    return this._fb;
  }
  
  public short g()
  {
    return this._g;
  }
  
  public void g(short paramShort)
  {
    this._g = paramShort;
    setDirtyFlag();
  }
  
  public short r()
  {
    return this._r;
  }
  
  public void r(short paramShort)
  {
    this._r = paramShort;
    setDirtyFlag();
  }
  
  public void setAll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setAll((short)paramInt1, (short)paramInt2, (short)paramInt3, (short)paramInt4);
  }
  
  /* Error */
  public void setAll(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setAll(Color4 arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setAll(short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    this._r = paramShort1;
    this._g = paramShort2;
    this._b = paramShort3;
    this._a = paramShort4;
    setDirtyFlag();
  }
  
  public Color4 toColor4()
  {
    return null;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\Color4Managed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */