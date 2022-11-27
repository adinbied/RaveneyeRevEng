package dji.midware.ar.min3d.vos;

public enum FogType
{
  private final int _glValue;
  
  static
  {
    EXP = new FogType("EXP", 1, 2048);
    FogType localFogType = new FogType("EXP2", 2, 2049);
    EXP2 = localFogType;
    $VALUES = new FogType[] { LINEAR, EXP, localFogType };
  }
  
  private FogType(int paramInt)
  {
    this._glValue = paramInt;
  }
  
  public int glValue()
  {
    return this._glValue;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\FogType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */