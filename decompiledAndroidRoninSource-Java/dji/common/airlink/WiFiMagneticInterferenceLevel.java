package dji.common.airlink;

public enum WiFiMagneticInterferenceLevel
{
  private int value;
  
  static
  {
    HIGH = new WiFiMagneticInterferenceLevel("HIGH", 2, 2);
    WiFiMagneticInterferenceLevel localWiFiMagneticInterferenceLevel = new WiFiMagneticInterferenceLevel("UNKNOWN", 3, 100);
    UNKNOWN = localWiFiMagneticInterferenceLevel;
    $VALUES = new WiFiMagneticInterferenceLevel[] { LOW, MEDIUM, HIGH, localWiFiMagneticInterferenceLevel };
  }
  
  private WiFiMagneticInterferenceLevel(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static WiFiMagneticInterferenceLevel find(int paramInt)
  {
    WiFiMagneticInterferenceLevel localWiFiMagneticInterferenceLevel = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localWiFiMagneticInterferenceLevel;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\WiFiMagneticInterferenceLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */