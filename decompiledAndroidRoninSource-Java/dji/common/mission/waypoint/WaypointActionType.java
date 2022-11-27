package dji.common.mission.waypoint;

public enum WaypointActionType
{
  private int value;
  
  static
  {
    START_TAKE_PHOTO = new WaypointActionType("START_TAKE_PHOTO", 1, 1);
    START_RECORD = new WaypointActionType("START_RECORD", 2, 2);
    STOP_RECORD = new WaypointActionType("STOP_RECORD", 3, 3);
    ROTATE_AIRCRAFT = new WaypointActionType("ROTATE_AIRCRAFT", 4, 4);
    WaypointActionType localWaypointActionType = new WaypointActionType("GIMBAL_PITCH", 5, 5);
    GIMBAL_PITCH = localWaypointActionType;
    $VALUES = new WaypointActionType[] { STAY, START_TAKE_PHOTO, START_RECORD, STOP_RECORD, ROTATE_AIRCRAFT, localWaypointActionType };
  }
  
  private WaypointActionType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static WaypointActionType find(int paramInt)
  {
    WaypointActionType localWaypointActionType = STAY;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localWaypointActionType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointActionType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */