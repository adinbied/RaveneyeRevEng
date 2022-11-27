package dji.common;

public enum LightbridgePIPPosition
{
  private int value;
  
  static
  {
    BOTTOM_LEFT = new LightbridgePIPPosition("BOTTOM_LEFT", 2, 2);
    BOTTOM_RIGHT = new LightbridgePIPPosition("BOTTOM_RIGHT", 3, 3);
    LightbridgePIPPosition localLightbridgePIPPosition = new LightbridgePIPPosition("UNKNOWN", 4, 255);
    UNKNOWN = localLightbridgePIPPosition;
    $VALUES = new LightbridgePIPPosition[] { TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, localLightbridgePIPPosition };
  }
  
  private LightbridgePIPPosition(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static LightbridgePIPPosition find(int paramInt)
  {
    LightbridgePIPPosition localLightbridgePIPPosition = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localLightbridgePIPPosition;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\LightbridgePIPPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */