package dji.common.flightcontroller;

public enum FlightMode
{
  private int data;
  
  static
  {
    ATTI = new FlightMode("ATTI", 1, 1);
    ATTI_COURSE_LOCK = new FlightMode("ATTI_COURSE_LOCK", 2, 2);
    ATTI_HOVER = new FlightMode("ATTI_HOVER", 3, 3);
    HOVER = new FlightMode("HOVER", 4, 4);
    GPS_BLAKE = new FlightMode("GPS_BLAKE", 5, 5);
    GPS_ATTI = new FlightMode("GPS_ATTI", 6, 6);
    GPS_COURSE_LOCK = new FlightMode("GPS_COURSE_LOCK", 7, 7);
    GPS_HOME_LOCK = new FlightMode("GPS_HOME_LOCK", 8, 8);
    GPS_HOT_POINT = new FlightMode("GPS_HOT_POINT", 9, 9);
    ASSISTED_TAKEOFF = new FlightMode("ASSISTED_TAKEOFF", 10, 10);
    AUTO_TAKEOFF = new FlightMode("AUTO_TAKEOFF", 11, 11);
    AUTO_LANDING = new FlightMode("AUTO_LANDING", 12, 12);
    ATTI_LANDING = new FlightMode("ATTI_LANDING", 13, 13);
    GPS_WAYPOINT = new FlightMode("GPS_WAYPOINT", 14, 14);
    GO_HOME = new FlightMode("GO_HOME", 15, 15);
    CLICK_GO = new FlightMode("CLICK_GO", 16, 16);
    JOYSTICK = new FlightMode("JOYSTICK", 17, 17);
    GPS_ATTI_WRISTBAND = new FlightMode("GPS_ATTI_WRISTBAND", 18, 18);
    CINEMATIC = new FlightMode("CINEMATIC", 19, 19);
    ATTI_LIMITED = new FlightMode("ATTI_LIMITED", 20, 23);
    DRAW = new FlightMode("DRAW", 21, 24);
    GPS_FOLLOW_ME = new FlightMode("GPS_FOLLOW_ME", 22, 25);
    ACTIVE_TRACK = new FlightMode("ACTIVE_TRACK", 23, 26);
    TAP_FLY = new FlightMode("TAP_FLY", 24, 27);
    PANO = new FlightMode("PANO", 25, 28);
    FARMING = new FlightMode("FARMING", 26, 29);
    FPV = new FlightMode("FPV", 27, 30);
    GPS_SPORT = new FlightMode("GPS_SPORT", 28, 31);
    GPS_NOVICE = new FlightMode("GPS_NOVICE", 29, 32);
    CONFIRM_LANDING = new FlightMode("CONFIRM_LANDING", 30, 33);
    TERRAIN_FOLLOW = new FlightMode("TERRAIN_FOLLOW", 31, 35);
    PALM_CONTROL = new FlightMode("PALM_CONTROL", 32, 36);
    QUICK_SHOT = new FlightMode("QUICK_SHOT", 33, 37);
    TRIPOD = new FlightMode("TRIPOD", 34, 38);
    TRACK_SPOTLIGHT = new FlightMode("TRACK_SPOTLIGHT", 35, 39);
    MOTORS_JUST_STARTED = new FlightMode("MOTORS_JUST_STARTED", 36, 41);
    GPS_GENTLE = new FlightMode("GPS_GENTLE", 37, 43);
    FlightMode localFlightMode = new FlightMode("UNKNOWN", 38, 255);
    UNKNOWN = localFlightMode;
    $VALUES = new FlightMode[] { MANUAL, ATTI, ATTI_COURSE_LOCK, ATTI_HOVER, HOVER, GPS_BLAKE, GPS_ATTI, GPS_COURSE_LOCK, GPS_HOME_LOCK, GPS_HOT_POINT, ASSISTED_TAKEOFF, AUTO_TAKEOFF, AUTO_LANDING, ATTI_LANDING, GPS_WAYPOINT, GO_HOME, CLICK_GO, JOYSTICK, GPS_ATTI_WRISTBAND, CINEMATIC, ATTI_LIMITED, DRAW, GPS_FOLLOW_ME, ACTIVE_TRACK, TAP_FLY, PANO, FARMING, FPV, GPS_SPORT, GPS_NOVICE, CONFIRM_LANDING, TERRAIN_FOLLOW, PALM_CONTROL, QUICK_SHOT, TRIPOD, TRACK_SPOTLIGHT, MOTORS_JUST_STARTED, GPS_GENTLE, localFlightMode };
  }
  
  private FlightMode(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static FlightMode find(int paramInt)
  {
    FlightMode localFlightMode = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localFlightMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\FlightMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */