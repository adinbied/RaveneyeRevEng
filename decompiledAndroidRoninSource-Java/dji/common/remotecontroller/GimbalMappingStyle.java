package dji.common.remotecontroller;

public enum GimbalMappingStyle
{
  private int value;
  
  static
  {
    CUSTOM = new GimbalMappingStyle("CUSTOM", 1, 1);
    GimbalMappingStyle localGimbalMappingStyle = new GimbalMappingStyle("UNKNOWN", 2, 255);
    UNKNOWN = localGimbalMappingStyle;
    $VALUES = new GimbalMappingStyle[] { DEFAULT, CUSTOM, localGimbalMappingStyle };
  }
  
  private GimbalMappingStyle(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static GimbalMappingStyle find(int paramInt)
  {
    GimbalMappingStyle localGimbalMappingStyle = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localGimbalMappingStyle;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\GimbalMappingStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */