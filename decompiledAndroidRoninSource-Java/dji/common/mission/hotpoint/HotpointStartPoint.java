package dji.common.mission.hotpoint;

public enum HotpointStartPoint
{
  private int value;
  
  static
  {
    EAST = new HotpointStartPoint("EAST", 3, 3);
    HotpointStartPoint localHotpointStartPoint = new HotpointStartPoint("NEAREST", 4, 4);
    NEAREST = localHotpointStartPoint;
    $VALUES = new HotpointStartPoint[] { NORTH, SOUTH, WEST, EAST, localHotpointStartPoint };
  }
  
  private HotpointStartPoint(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static HotpointStartPoint find(int paramInt)
  {
    HotpointStartPoint localHotpointStartPoint = NORTH;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localHotpointStartPoint;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\hotpoint\HotpointStartPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */