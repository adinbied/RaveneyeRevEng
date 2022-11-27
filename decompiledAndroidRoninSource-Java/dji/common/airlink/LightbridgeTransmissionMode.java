package dji.common.airlink;

public enum LightbridgeTransmissionMode
{
  private int value;
  
  static
  {
    LightbridgeTransmissionMode localLightbridgeTransmissionMode = new LightbridgeTransmissionMode("UNKNOWN", 2, 255);
    UNKNOWN = localLightbridgeTransmissionMode;
    $VALUES = new LightbridgeTransmissionMode[] { HIGH_QUALITY, LOW_LATENCY, localLightbridgeTransmissionMode };
  }
  
  private LightbridgeTransmissionMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static LightbridgeTransmissionMode find(int paramInt)
  {
    LightbridgeTransmissionMode localLightbridgeTransmissionMode = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localLightbridgeTransmissionMode;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\LightbridgeTransmissionMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */