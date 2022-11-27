package dji.midware.ar.min3d.objectPrimitives;

import dji.midware.ar.min3d.core.Object3dContainer;
import dji.midware.ar.min3d.vos.Color4;

public class Sphere
  extends Object3dContainer
{
  private int _cols;
  private float _radius;
  private int _rows;
  
  public Sphere(float paramFloat, int paramInt1, int paramInt2)
  {
    super((paramInt1 + 1) * (paramInt2 + 1), paramInt1 * paramInt2 * 2, localBoolean, localBoolean, localBoolean);
    this._cols = paramInt1;
    this._rows = paramInt2;
    this._radius = paramFloat;
    build();
  }
  
  public Sphere(float paramFloat, int paramInt1, int paramInt2, Color4 paramColor4)
  {
    super((paramInt1 + 1) * (paramInt2 + 1), paramInt1 * paramInt2 * 2, localBoolean, localBoolean, localBoolean);
    defaultColor(paramColor4);
    this._cols = paramInt1;
    this._rows = paramInt2;
    this._radius = paramFloat;
    build();
  }
  
  public Sphere(float paramFloat, int paramInt1, int paramInt2, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3)
  {
    super((paramInt1 + 1) * (paramInt2 + 1), paramInt1 * paramInt2 * 2, paramBoolean1, paramBoolean2, paramBoolean3);
    this._cols = paramInt1;
    this._rows = paramInt2;
    this._radius = paramFloat;
    build();
  }
  
  /* Error */
  private void build()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\objectPrimitives\Sphere.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */