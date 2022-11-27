package dji.common.flightcontroller.virtualstick;

public enum FlightCoordinateSystem
{
  private int data;
  
  static
  {
    FlightCoordinateSystem localFlightCoordinateSystem = new FlightCoordinateSystem("BODY", 1, 1);
    BODY = localFlightCoordinateSystem;
    $VALUES = new FlightCoordinateSystem[] { GROUND, localFlightCoordinateSystem };
  }
  
  private FlightCoordinateSystem(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static FlightCoordinateSystem find(int paramInt)
  {
    FlightCoordinateSystem localFlightCoordinateSystem = GROUND;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localFlightCoordinateSystem;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\virtualstick\FlightCoordinateSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */