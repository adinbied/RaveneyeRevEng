package dji.midware.ar.min3d.vos;

public enum ShadeModel
{
  private final int _glConstant;
  
  static
  {
    ShadeModel localShadeModel = new ShadeModel("FLAT", 1, 7424);
    FLAT = localShadeModel;
    $VALUES = new ShadeModel[] { SMOOTH, localShadeModel };
  }
  
  private ShadeModel(int paramInt)
  {
    this._glConstant = paramInt;
  }
  
  public int glConstant()
  {
    return this._glConstant;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\ShadeModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */