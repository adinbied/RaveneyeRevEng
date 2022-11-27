package dji.common.flightcontroller;

public enum FlightControlState
{
  private int data;
  
  static
  {
    ATTI = new FlightControlState("ATTI", 1, 1);
    LANDING = new FlightControlState("LANDING", 2, 2);
    TAKE_OFF = new FlightControlState("TAKE_OFF", 3, 3);
    GO_HOME = new FlightControlState("GO_HOME", 4, 4);
    JOYSTICK = new FlightControlState("JOYSTICK", 5, 5);
    NAVI = new FlightControlState("NAVI", 6, 6);
    CLICK_GO = new FlightControlState("CLICK_GO", 7, 7);
    P_ATTI = new FlightControlState("P_ATTI", 8, 8);
    P_OPTI = new FlightControlState("P_OPTI", 9, 9);
    P_GPS = new FlightControlState("P_GPS", 10, 10);
    F_ATTI = new FlightControlState("F_ATTI", 11, 11);
    F_OPTI = new FlightControlState("F_OPTI", 12, 12);
    F_GPS = new FlightControlState("F_GPS", 13, 13);
    ACTIVE_TRACK = new FlightControlState("ACTIVE_TRACK", 14, 14);
    TAP_FLY = new FlightControlState("TAP_FLY", 15, 15);
    SPORT = new FlightControlState("SPORT", 16, 16);
    NOVICE = new FlightControlState("NOVICE", 17, 17);
    FlightControlState localFlightControlState = new FlightControlState("UNKNOWN", 18, 255);
    UNKNOWN = localFlightControlState;
    $VALUES = new FlightControlState[] { MANUAL, ATTI, LANDING, TAKE_OFF, GO_HOME, JOYSTICK, NAVI, CLICK_GO, P_ATTI, P_OPTI, P_GPS, F_ATTI, F_OPTI, F_GPS, ACTIVE_TRACK, TAP_FLY, SPORT, NOVICE, localFlightControlState };
  }
  
  private FlightControlState(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static FlightControlState find(int paramInt)
  {
    FlightControlState localFlightControlState = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localFlightControlState;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\FlightControlState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */