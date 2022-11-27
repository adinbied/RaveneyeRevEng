package dji.midware.ar.min3d.vos;

import dji.midware.ar.min3d.interfaces.IDirtyParent;
import java.nio.FloatBuffer;

public class Number3dManaged
  extends AbstractDirtyManaged
{
  private FloatBuffer _fb;
  private float _x;
  private float _y;
  private float _z;
  
  public Number3dManaged(float paramFloat1, float paramFloat2, float paramFloat3, IDirtyParent paramIDirtyParent)
  {
    super(paramIDirtyParent);
    this._x = paramFloat1;
    this._y = paramFloat2;
    this._z = paramFloat3;
    this._fb = toFloatBuffer();
    setDirtyFlag();
  }
  
  public Number3dManaged(IDirtyParent paramIDirtyParent)
  {
    super(paramIDirtyParent);
    this._x = 0.0F;
    this._y = 0.0F;
    this._z = 0.0F;
    this._fb = toFloatBuffer();
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
  
  public float getX()
  {
    return this._x;
  }
  
  public float getY()
  {
    return this._y;
  }
  
  public float getZ()
  {
    return this._z;
  }
  
  public void setAll(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this._x = paramFloat1;
    this._y = paramFloat2;
    this._z = paramFloat3;
    setDirtyFlag();
  }
  
  /* Error */
  public void setAllFrom(Number3d arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setAllFrom(Number3dManaged arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setX(float paramFloat)
  {
    this._x = paramFloat;
    setDirtyFlag();
  }
  
  public void setY(float paramFloat)
  {
    this._y = paramFloat;
    setDirtyFlag();
  }
  
  public void setZ(float paramFloat)
  {
    this._z = paramFloat;
    setDirtyFlag();
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
  
  public Number3d toNumber3d()
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\Number3dManaged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */