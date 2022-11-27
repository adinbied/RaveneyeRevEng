package dji.common.flightcontroller.flyzone;

public enum FlyZoneType
{
  static
  {
    GEO = new FlyZoneType("GEO", 1);
    POLY = new FlyZoneType("POLY", 2);
    FlyZoneType localFlyZoneType = new FlyZoneType("UNKNOWN", 3);
    UNKNOWN = localFlyZoneType;
    $VALUES = new FlyZoneType[] { NFZ, GEO, POLY, localFlyZoneType };
  }
  
  private FlyZoneType() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\flyzone\FlyZoneType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */