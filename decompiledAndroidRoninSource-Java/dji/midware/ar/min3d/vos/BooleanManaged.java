package dji.midware.ar.min3d.vos;

import dji.midware.ar.min3d.interfaces.IDirtyParent;

public class BooleanManaged
  extends AbstractDirtyManaged
{
  private boolean _b;
  
  public BooleanManaged(boolean paramBoolean, IDirtyParent paramIDirtyParent)
  {
    super(paramIDirtyParent);
    set(paramBoolean);
  }
  
  public boolean get()
  {
    return this._b;
  }
  
  public void set(boolean paramBoolean)
  {
    this._b = paramBoolean;
    setDirtyFlag();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\BooleanManaged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */