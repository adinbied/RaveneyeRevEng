package dji.common.flightcontroller.flyzone;

public enum FlyZoneShape
{
  private int data;
  
  static
  {
    CONE = new FlyZoneShape("CONE", 1, 1);
    FlyZoneShape localFlyZoneShape = new FlyZoneShape("UNKNOWN", 2, 255);
    UNKNOWN = localFlyZoneShape;
    $VALUES = new FlyZoneShape[] { CYLINDER, CONE, localFlyZoneShape };
  }
  
  private FlyZoneShape(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static FlyZoneShape find(int paramInt)
  {
    FlyZoneShape localFlyZoneShape = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localFlyZoneShape;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\flyzone\FlyZoneShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */