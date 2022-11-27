package dji.midware.ar.min3d.vos;

public enum LightType
{
  private final float _glValue;
  
  static
  {
    LightType localLightType = new LightType("POSITIONAL", 1, 1.0F);
    POSITIONAL = localLightType;
    $VALUES = new LightType[] { DIRECTIONAL, localLightType };
  }
  
  private LightType(float paramFloat)
  {
    this._glValue = paramFloat;
  }
  
  public float glValue()
  {
    return this._glValue;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\LightType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */