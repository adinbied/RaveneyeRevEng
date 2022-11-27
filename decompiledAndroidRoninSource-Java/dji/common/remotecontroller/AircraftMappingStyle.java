package dji.common.remotecontroller;

public enum AircraftMappingStyle
{
  private int value;
  
  static
  {
    AircraftMappingStyle localAircraftMappingStyle = new AircraftMappingStyle("UNKNOWN", 4, 255);
    UNKNOWN = localAircraftMappingStyle;
    $VALUES = new AircraftMappingStyle[] { STYLE_1, STYLE_2, STYLE_3, STYLE_CUSTOM, localAircraftMappingStyle };
  }
  
  private AircraftMappingStyle(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static AircraftMappingStyle find(int paramInt)
  {
    AircraftMappingStyle localAircraftMappingStyle = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localAircraftMappingStyle;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\AircraftMappingStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */