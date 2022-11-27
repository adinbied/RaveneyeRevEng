package dji.common.airlink;

public enum LightbridgeUnit
{
  private int value;
  
  static
  {
    LightbridgeUnit localLightbridgeUnit = new LightbridgeUnit("UNKNOWN", 2, 255);
    UNKNOWN = localLightbridgeUnit;
    $VALUES = new LightbridgeUnit[] { IMPERIAL, METRIC, localLightbridgeUnit };
  }
  
  private LightbridgeUnit(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static LightbridgeUnit find(int paramInt)
  {
    LightbridgeUnit localLightbridgeUnit = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localLightbridgeUnit;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\LightbridgeUnit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */