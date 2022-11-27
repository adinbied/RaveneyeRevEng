package dji.common.airlink;

public enum LightbridgeDataRate
{
  private int value;
  
  static
  {
    BANDWIDTH_10_MBPS = new LightbridgeDataRate("BANDWIDTH_10_MBPS", 3, 4);
    LightbridgeDataRate localLightbridgeDataRate = new LightbridgeDataRate("UNKNOWN", 4, 255);
    UNKNOWN = localLightbridgeDataRate;
    $VALUES = new LightbridgeDataRate[] { BANDWIDTH_4_MBPS, BANDWIDTH_6_MBPS, BANDWIDTH_8_MBPS, BANDWIDTH_10_MBPS, localLightbridgeDataRate };
  }
  
  private LightbridgeDataRate(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static LightbridgeDataRate find(int paramInt)
  {
    LightbridgeDataRate localLightbridgeDataRate = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localLightbridgeDataRate;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\LightbridgeDataRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */