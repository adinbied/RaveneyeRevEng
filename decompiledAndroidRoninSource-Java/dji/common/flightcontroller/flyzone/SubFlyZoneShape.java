package dji.common.flightcontroller.flyzone;

public enum SubFlyZoneShape
{
  private final int data;
  
  static
  {
    SubFlyZoneShape localSubFlyZoneShape = new SubFlyZoneShape("UNKNOWN", 2, 255);
    UNKNOWN = localSubFlyZoneShape;
    $VALUES = new SubFlyZoneShape[] { CYLINDER, POLYGON, localSubFlyZoneShape };
  }
  
  private SubFlyZoneShape(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static SubFlyZoneShape find(int paramInt)
  {
    SubFlyZoneShape localSubFlyZoneShape = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i].value() == paramInt) {
        return values()[i];
      }
      i += 1;
    }
    return localSubFlyZoneShape;
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\flyzone\SubFlyZoneShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */