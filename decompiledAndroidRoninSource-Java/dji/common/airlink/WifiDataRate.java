package dji.common.airlink;

public enum WifiDataRate
{
  private int value;
  
  static
  {
    WifiDataRate localWifiDataRate = new WifiDataRate("UNKNOWN", 3, 255);
    UNKNOWN = localWifiDataRate;
    $VALUES = new WifiDataRate[] { RATE_1_MBPS, RATE_2_MBPS, RATE_4_MBPS, localWifiDataRate };
  }
  
  private WifiDataRate(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static WifiDataRate find(int paramInt)
  {
    WifiDataRate localWifiDataRate = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localWifiDataRate;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\WifiDataRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */