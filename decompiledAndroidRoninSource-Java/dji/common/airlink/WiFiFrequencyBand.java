package dji.common.airlink;

public enum WiFiFrequencyBand
{
  private int value;
  
  static
  {
    FREQUENCY_BAND_2_DOT_4_GHZ = new WiFiFrequencyBand("FREQUENCY_BAND_2_DOT_4_GHZ", 1, 0);
    FREQUENCY_BAND_5_GHZ = new WiFiFrequencyBand("FREQUENCY_BAND_5_GHZ", 2, 1);
    FREQUENCY_BAND_DUAL = new WiFiFrequencyBand("FREQUENCY_BAND_DUAL", 3, 2);
    WiFiFrequencyBand localWiFiFrequencyBand = new WiFiFrequencyBand("UNKNOWN", 4, 255);
    UNKNOWN = localWiFiFrequencyBand;
    $VALUES = new WiFiFrequencyBand[] { FrequencyBandOnly2Dot4, FREQUENCY_BAND_2_DOT_4_GHZ, FREQUENCY_BAND_5_GHZ, FREQUENCY_BAND_DUAL, localWiFiFrequencyBand };
  }
  
  private WiFiFrequencyBand(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static WiFiFrequencyBand find(int paramInt)
  {
    WiFiFrequencyBand localWiFiFrequencyBand = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localWiFiFrequencyBand;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\WiFiFrequencyBand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */