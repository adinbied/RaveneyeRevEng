package dji.common.mission.waypoint;

public enum WaypointTurnMode
{
  private int value;
  
  static
  {
    WaypointTurnMode localWaypointTurnMode = new WaypointTurnMode("COUNTER_CLOCKWISE", 1, 1);
    COUNTER_CLOCKWISE = localWaypointTurnMode;
    $VALUES = new WaypointTurnMode[] { CLOCKWISE, localWaypointTurnMode };
  }
  
  private WaypointTurnMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static WaypointTurnMode find(int paramInt)
  {
    WaypointTurnMode localWaypointTurnMode = CLOCKWISE;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localWaypointTurnMode;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointTurnMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */