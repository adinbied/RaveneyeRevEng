package dji.common.flightcontroller.flyzone;

public enum FlyZoneDatabaseState
{
  private final int value;
  
  static
  {
    FlyZoneDatabaseState localFlyZoneDatabaseState = new FlyZoneDatabaseState("UNKNOWN", 4, 255);
    UNKNOWN = localFlyZoneDatabaseState;
    $VALUES = new FlyZoneDatabaseState[] { INITIALIZING, NO_INTERNET_CONNECTION, OUT_OF_DATE, UP_TO_DATE, localFlyZoneDatabaseState };
  }
  
  private FlyZoneDatabaseState(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static FlyZoneDatabaseState find(int paramInt)
  {
    FlyZoneDatabaseState localFlyZoneDatabaseState = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localFlyZoneDatabaseState;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\flyzone\FlyZoneDatabaseState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */