package dji.common.flightcontroller.flyzone;

public enum FlyZoneReason
{
  private int data;
  
  static
  {
    MILITARY = new FlyZoneReason("MILITARY", 2, 2);
    COMMERCIAL_AIRPORTS = new FlyZoneReason("COMMERCIAL_AIRPORTS", 3, 11);
    PRIVATE_COMMERCIAL_AIRPORTS = new FlyZoneReason("PRIVATE_COMMERCIAL_AIRPORTS", 4, 12);
    RECREATIONAL_AIRPORTS = new FlyZoneReason("RECREATIONAL_AIRPORTS", 5, 13);
    NATIONAL_PARKS = new FlyZoneReason("NATIONAL_PARKS", 6, 20);
    NOAA = new FlyZoneReason("NOAA", 7, 21);
    PARCEL = new FlyZoneReason("PARCEL", 8, 22);
    POWER_PLANT = new FlyZoneReason("POWER_PLANT", 9, 23);
    PRISON = new FlyZoneReason("PRISON", 10, 24);
    SCHOOL = new FlyZoneReason("SCHOOL", 11, 25);
    STADIUM = new FlyZoneReason("STADIUM", 12, 26);
    PROHIBITED_SPECIAL_USE = new FlyZoneReason("PROHIBITED_SPECIAL_USE", 13, 27);
    RESTRICTED_SPECIAL_USE = new FlyZoneReason("RESTRICTED_SPECIAL_USE", 14, 28);
    TEMPORARY_FLIGHT_RESTRICTIONS = new FlyZoneReason("TEMPORARY_FLIGHT_RESTRICTIONS", 15, 29);
    CLASS_B_AIR_SPACE = new FlyZoneReason("CLASS_B_AIR_SPACE", 16, 15);
    CLASS_C_AIR_SPACE = new FlyZoneReason("CLASS_C_AIR_SPACE", 17, 16);
    CLASS_D_AIR_SPACE = new FlyZoneReason("CLASS_D_AIR_SPACE", 18, 17);
    CLASS_E_AIR_SPACE = new FlyZoneReason("CLASS_E_AIR_SPACE", 19, 18);
    UNPAVED_AIRPORT = new FlyZoneReason("UNPAVED_AIRPORT", 20, 31);
    HELIPORT = new FlyZoneReason("HELIPORT", 21, 19);
    FlyZoneReason localFlyZoneReason = new FlyZoneReason("UNKNOWN", 22, 255);
    UNKNOWN = localFlyZoneReason;
    $VALUES = new FlyZoneReason[] { AIRPORT, SPECIAL, MILITARY, COMMERCIAL_AIRPORTS, PRIVATE_COMMERCIAL_AIRPORTS, RECREATIONAL_AIRPORTS, NATIONAL_PARKS, NOAA, PARCEL, POWER_PLANT, PRISON, SCHOOL, STADIUM, PROHIBITED_SPECIAL_USE, RESTRICTED_SPECIAL_USE, TEMPORARY_FLIGHT_RESTRICTIONS, CLASS_B_AIR_SPACE, CLASS_C_AIR_SPACE, CLASS_D_AIR_SPACE, CLASS_E_AIR_SPACE, UNPAVED_AIRPORT, HELIPORT, localFlyZoneReason };
  }
  
  private FlyZoneReason(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static FlyZoneReason find(int paramInt)
  {
    FlyZoneReason localFlyZoneReason = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localFlyZoneReason;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\flyzone\FlyZoneReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */