package dji.midware.ar.min3d.vos;

import dji.midware.ar.min3d.interfaces.IDirtyParent;

public class FloatManaged
  extends AbstractDirtyManaged
{
  private float _f;
  
  public FloatManaged(float paramFloat, IDirtyParent paramIDirtyParent)
  {
    super(paramIDirtyParent);
    set(paramFloat);
  }
  
  public float get()
  {
    return this._f;
  }
  
  public void set(float paramFloat)
  {
    this._f = paramFloat;
    setDirtyFlag();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\FloatManaged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */