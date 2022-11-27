package dji.midware.ar.min3d.objectPrimitives;

import dji.midware.ar.min3d.core.Object3dContainer;
import dji.midware.ar.min3d.vos.Color4;

public class Box
  extends Object3dContainer
{
  private Color4[] _cols;
  private float _depth;
  private float _height;
  private float _width;
  
  public Box(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(paramFloat1, paramFloat2, paramFloat3, null, localBoolean, localBoolean, localBoolean);
  }
  
  public Box(float paramFloat1, float paramFloat2, float paramFloat3, Color4 paramColor4)
  {
    this(paramFloat1, paramFloat2, paramFloat3, new Color4[] { paramColor4, paramColor4, paramColor4, paramColor4, paramColor4, paramColor4 }, localBoolean, localBoolean, localBoolean);
  }
  
  public Box(float paramFloat1, float paramFloat2, float paramFloat3, Color4[] paramArrayOfColor4)
  {
    this(paramFloat1, paramFloat2, paramFloat3, paramArrayOfColor4, localBoolean, localBoolean, localBoolean);
  }
  
  public Box(float paramFloat1, float paramFloat2, float paramFloat3, Color4[] paramArrayOfColor4, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3)
  {
    super(24, 12, paramBoolean1, paramBoolean2, paramBoolean3);
    this._width = paramFloat1;
    this._height = paramFloat2;
    this._depth = paramFloat3;
    if (paramArrayOfColor4 != null)
    {
      this._cols = paramArrayOfColor4;
    }
    else
    {
      paramArrayOfColor4 = new Color4[6];
      this._cols = paramArrayOfColor4;
      paramArrayOfColor4[0] = new Color4(255, 0, 0, 255);
      this._cols[1] = new Color4(0, 255, 0, 255);
      this._cols[2] = new Color4(0, 0, 255, 255);
      this._cols[3] = new Color4(255, 255, 0, 255);
      this._cols[4] = new Color4(0, 255, 255, 255);
      this._cols[5] = new Color4(255, 0, 255, 255);
    }
    make();
  }
  
  /* Error */
  private void make()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\objectPrimitives\Box.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */