package dji.midware.ar.min3d.vos;

import dji.midware.ar.min3d.interfaces.IDirtyParent;

public class ShadeModelManaged
  extends AbstractDirtyManaged
{
  private ShadeModel _shadeModel;
  
  public ShadeModelManaged(IDirtyParent paramIDirtyParent)
  {
    super(paramIDirtyParent);
    set(ShadeModel.SMOOTH);
  }
  
  public ShadeModel get()
  {
    return this._shadeModel;
  }
  
  public void set(ShadeModel paramShadeModel)
  {
    this._shadeModel = paramShadeModel;
    this._dirty = true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\ShadeModelManaged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */