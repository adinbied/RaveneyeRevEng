package dji.common.flightcontroller;

public enum FlightOrientationMode
{
  private int data;
  
  static
  {
    FlightOrientationMode localFlightOrientationMode = new FlightOrientationMode("HOME_LOCK", 2, 2);
    HOME_LOCK = localFlightOrientationMode;
    $VALUES = new FlightOrientationMode[] { AIRCRAFT_HEADING, COURSE_LOCK, localFlightOrientationMode };
  }
  
  private FlightOrientationMode(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static FlightOrientationMode find(int paramInt)
  {
    FlightOrientationMode localFlightOrientationMode = AIRCRAFT_HEADING;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localFlightOrientationMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\FlightOrientationMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */