package dji.common.airlink;

public enum LightbridgeSecondaryVideoDisplayMode
{
  private int value;
  
  static
  {
    SOURCE_1_MAIN = new LightbridgeSecondaryVideoDisplayMode("SOURCE_1_MAIN", 2, 2);
    SOURCE_2_MAIN = new LightbridgeSecondaryVideoDisplayMode("SOURCE_2_MAIN", 3, 3);
    LightbridgeSecondaryVideoDisplayMode localLightbridgeSecondaryVideoDisplayMode = new LightbridgeSecondaryVideoDisplayMode("UNKNOWN", 4, 4);
    UNKNOWN = localLightbridgeSecondaryVideoDisplayMode;
    $VALUES = new LightbridgeSecondaryVideoDisplayMode[] { SOURCE_1_ONLY, SOURCE_2_ONLY, SOURCE_1_MAIN, SOURCE_2_MAIN, localLightbridgeSecondaryVideoDisplayMode };
  }
  
  private LightbridgeSecondaryVideoDisplayMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static LightbridgeSecondaryVideoDisplayMode find(int paramInt)
  {
    LightbridgeSecondaryVideoDisplayMode localLightbridgeSecondaryVideoDisplayMode = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localLightbridgeSecondaryVideoDisplayMode;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\LightbridgeSecondaryVideoDisplayMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */