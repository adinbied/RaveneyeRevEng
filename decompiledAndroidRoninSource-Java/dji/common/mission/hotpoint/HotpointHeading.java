package dji.common.mission.hotpoint;

public enum HotpointHeading
{
  private int value;
  
  static
  {
    ALONG_CIRCLE_LOOKING_BACKWARDS = new HotpointHeading("ALONG_CIRCLE_LOOKING_BACKWARDS", 1, 5);
    TOWARDS_HOT_POINT = new HotpointHeading("TOWARDS_HOT_POINT", 2, 1);
    AWAY_FROM_HOT_POINT = new HotpointHeading("AWAY_FROM_HOT_POINT", 3, 2);
    CONTROLLED_BY_REMOTE_CONTROLLER = new HotpointHeading("CONTROLLED_BY_REMOTE_CONTROLLER", 4, 3);
    HotpointHeading localHotpointHeading = new HotpointHeading("USING_INITIAL_HEADING", 5, 4);
    USING_INITIAL_HEADING = localHotpointHeading;
    $VALUES = new HotpointHeading[] { ALONG_CIRCLE_LOOKING_FORWARDS, ALONG_CIRCLE_LOOKING_BACKWARDS, TOWARDS_HOT_POINT, AWAY_FROM_HOT_POINT, CONTROLLED_BY_REMOTE_CONTROLLER, localHotpointHeading };
  }
  
  private HotpointHeading(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static HotpointHeading find(int paramInt)
  {
    HotpointHeading localHotpointHeading = ALONG_CIRCLE_LOOKING_FORWARDS;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localHotpointHeading;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\hotpoint\HotpointHeading.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */