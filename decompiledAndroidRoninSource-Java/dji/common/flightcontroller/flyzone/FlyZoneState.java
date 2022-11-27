package dji.common.flightcontroller.flyzone;

public enum FlyZoneState
{
  private int data;
  
  static
  {
    IN_WARNING_ZONE_WITH_HEIGHT_LIMITATION = new FlyZoneState("IN_WARNING_ZONE_WITH_HEIGHT_LIMITATION", 2, 3);
    IN_WARNING_ZONE = new FlyZoneState("IN_WARNING_ZONE", 3, 4);
    IN_RESTRICTED_ZONE = new FlyZoneState("IN_RESTRICTED_ZONE", 4, 5);
    FlyZoneState localFlyZoneState = new FlyZoneState("UNKNOWN", 5, 255);
    UNKNOWN = localFlyZoneState;
    $VALUES = new FlyZoneState[] { CLEAR, NEAR_RESTRICTED_ZONE, IN_WARNING_ZONE_WITH_HEIGHT_LIMITATION, IN_WARNING_ZONE, IN_RESTRICTED_ZONE, localFlyZoneState };
  }
  
  private FlyZoneState(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static FlyZoneState find(int paramInt)
  {
    FlyZoneState localFlyZoneState = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localFlyZoneState;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public int value()
  {
    return this.data;
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(FlyZoneState paramFlyZoneState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\flyzone\FlyZoneState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */