package dji.common.flightcontroller;

public enum DJIVisionTrackMode
{
  private final int data;
  
  static
  {
    FIXED_ANGLE = new DJIVisionTrackMode("FIXED_ANGLE", 2, 2);
    WATCH_TARGET = new DJIVisionTrackMode("WATCH_TARGET", 3, 3);
    HEAD_LOCK = new DJIVisionTrackMode("HEAD_LOCK", 4, 4);
    WAYPOINT = new DJIVisionTrackMode("WAYPOINT", 5, 5);
    QUICK_MOVIE = new DJIVisionTrackMode("QUICK_MOVIE", 6, 6);
    DJIVisionTrackMode localDJIVisionTrackMode = new DJIVisionTrackMode("OTHER", 7, 255);
    OTHER = localDJIVisionTrackMode;
    $VALUES = new DJIVisionTrackMode[] { HEADLESS_FOLLOW, PARALLEL_FOLLOW, FIXED_ANGLE, WATCH_TARGET, HEAD_LOCK, WAYPOINT, QUICK_MOVIE, localDJIVisionTrackMode };
  }
  
  private DJIVisionTrackMode(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static DJIVisionTrackMode find(int paramInt)
  {
    DJIVisionTrackMode localDJIVisionTrackMode1 = HEADLESS_FOLLOW;
    DJIVisionTrackMode[] arrayOfDJIVisionTrackMode = values();
    int j = arrayOfDJIVisionTrackMode.length;
    int i = 0;
    while (i < j)
    {
      DJIVisionTrackMode localDJIVisionTrackMode2 = arrayOfDJIVisionTrackMode[i];
      if (localDJIVisionTrackMode2._equals(paramInt)) {
        return localDJIVisionTrackMode2;
      }
      i += 1;
    }
    return localDJIVisionTrackMode1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\DJIVisionTrackMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */