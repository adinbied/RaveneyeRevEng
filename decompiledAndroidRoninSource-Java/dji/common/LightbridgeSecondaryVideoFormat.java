package dji.common;

public enum LightbridgeSecondaryVideoFormat
{
  private int value;
  
  static
  {
    RESOLUTION_720P_50FPS = new LightbridgeSecondaryVideoFormat("RESOLUTION_720P_50FPS", 1, 1);
    RESOLUTION_1080I_60FPS = new LightbridgeSecondaryVideoFormat("RESOLUTION_1080I_60FPS", 2, 2);
    RESOLUTION_1080I_50FPS = new LightbridgeSecondaryVideoFormat("RESOLUTION_1080I_50FPS", 3, 3);
    RESOLUTION_1080P_60FPS = new LightbridgeSecondaryVideoFormat("RESOLUTION_1080P_60FPS", 4, 4);
    RESOLUTION_1080P_50FPS = new LightbridgeSecondaryVideoFormat("RESOLUTION_1080P_50FPS", 5, 5);
    RESOLUTION_1080P_30FPS = new LightbridgeSecondaryVideoFormat("RESOLUTION_1080P_30FPS", 6, 6);
    RESOLUTION_1080P_24FPS = new LightbridgeSecondaryVideoFormat("RESOLUTION_1080P_24FPS", 7, 7);
    RESOLUTION_1080P_25FPS = new LightbridgeSecondaryVideoFormat("RESOLUTION_1080P_25FPS", 8, 8);
    RESOLUTION_720P_30FPS = new LightbridgeSecondaryVideoFormat("RESOLUTION_720P_30FPS", 9, 9);
    RESOLUTION_720P_25FPS = new LightbridgeSecondaryVideoFormat("RESOLUTION_720P_25FPS", 10, 10);
    RESOLUTION_720P_24FPS = new LightbridgeSecondaryVideoFormat("RESOLUTION_720P_24FPS", 11, 11);
    LightbridgeSecondaryVideoFormat localLightbridgeSecondaryVideoFormat = new LightbridgeSecondaryVideoFormat("UNKNOWN", 12, 255);
    UNKNOWN = localLightbridgeSecondaryVideoFormat;
    $VALUES = new LightbridgeSecondaryVideoFormat[] { RESOLUTION_720P_60FPS, RESOLUTION_720P_50FPS, RESOLUTION_1080I_60FPS, RESOLUTION_1080I_50FPS, RESOLUTION_1080P_60FPS, RESOLUTION_1080P_50FPS, RESOLUTION_1080P_30FPS, RESOLUTION_1080P_24FPS, RESOLUTION_1080P_25FPS, RESOLUTION_720P_30FPS, RESOLUTION_720P_25FPS, RESOLUTION_720P_24FPS, localLightbridgeSecondaryVideoFormat };
  }
  
  private LightbridgeSecondaryVideoFormat(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static LightbridgeSecondaryVideoFormat find(int paramInt)
  {
    LightbridgeSecondaryVideoFormat localLightbridgeSecondaryVideoFormat = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localLightbridgeSecondaryVideoFormat;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\LightbridgeSecondaryVideoFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */