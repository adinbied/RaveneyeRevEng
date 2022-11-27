package dji.midware.ar.min3d.vos;

import dji.midware.ar.min3d.interfaces.IDirtyManaged;
import dji.midware.ar.min3d.interfaces.IDirtyParent;

public abstract class AbstractDirtyManaged
  implements IDirtyManaged
{
  protected boolean _dirty;
  protected IDirtyParent _parent;
  
  public AbstractDirtyManaged(IDirtyParent paramIDirtyParent)
  {
    this._parent = paramIDirtyParent;
  }
  
  public void clearDirtyFlag()
  {
    this._dirty = false;
  }
  
  public boolean isDirty()
  {
    return this._dirty;
  }
  
  /* Error */
  public void setDirtyFlag()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\AbstractDirtyManaged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */