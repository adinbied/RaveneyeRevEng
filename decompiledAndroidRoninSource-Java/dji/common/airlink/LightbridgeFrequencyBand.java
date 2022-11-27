package dji.common.airlink;

public enum LightbridgeFrequencyBand
{
  private int value;
  
  static
  {
    LightbridgeFrequencyBand localLightbridgeFrequencyBand = new LightbridgeFrequencyBand("UNKNOWN", 3, 255);
    UNKNOWN = localLightbridgeFrequencyBand;
    $VALUES = new LightbridgeFrequencyBand[] { FREQUENCY_BAND_2_DOT_4_GHZ, FREQUENCY_BAND_5_DOT_7_GHZ, FREQUENCY_BAND_5_DOT_8_GHZ, localLightbridgeFrequencyBand };
  }
  
  private LightbridgeFrequencyBand(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static LightbridgeFrequencyBand find(int paramInt)
  {
    LightbridgeFrequencyBand localLightbridgeFrequencyBand = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localLightbridgeFrequencyBand;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\LightbridgeFrequencyBand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */