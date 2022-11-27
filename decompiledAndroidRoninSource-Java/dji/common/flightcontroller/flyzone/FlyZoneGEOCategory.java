package dji.common.flightcontroller.flyzone;

public enum FlyZoneGEOCategory
{
  private int data;
  
  static
  {
    ENHANCED_WARNING = new FlyZoneGEOCategory("ENHANCED_WARNING", 1, 3);
    AUTHORIZATION = new FlyZoneGEOCategory("AUTHORIZATION", 2, 1);
    RESTRICTED = new FlyZoneGEOCategory("RESTRICTED", 3, 2);
    FlyZoneGEOCategory localFlyZoneGEOCategory = new FlyZoneGEOCategory("UNKNOWN", 4, 255);
    UNKNOWN = localFlyZoneGEOCategory;
    $VALUES = new FlyZoneGEOCategory[] { WARNING, ENHANCED_WARNING, AUTHORIZATION, RESTRICTED, localFlyZoneGEOCategory };
  }
  
  private FlyZoneGEOCategory(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static FlyZoneGEOCategory find(int paramInt)
  {
    FlyZoneGEOCategory localFlyZoneGEOCategory = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localFlyZoneGEOCategory;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\flyzone\FlyZoneGEOCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */