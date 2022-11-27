package dji.common.airlink;

public enum LightbridgeSecondaryVideoOutputPort
{
  private int value;
  
  static
  {
    LightbridgeSecondaryVideoOutputPort localLightbridgeSecondaryVideoOutputPort = new LightbridgeSecondaryVideoOutputPort("Unknown", 2, 255);
    Unknown = localLightbridgeSecondaryVideoOutputPort;
    $VALUES = new LightbridgeSecondaryVideoOutputPort[] { HDMI, SDI, localLightbridgeSecondaryVideoOutputPort };
  }
  
  private LightbridgeSecondaryVideoOutputPort(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static LightbridgeSecondaryVideoOutputPort find(int paramInt)
  {
    LightbridgeSecondaryVideoOutputPort localLightbridgeSecondaryVideoOutputPort = Unknown;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localLightbridgeSecondaryVideoOutputPort;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\LightbridgeSecondaryVideoOutputPort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */