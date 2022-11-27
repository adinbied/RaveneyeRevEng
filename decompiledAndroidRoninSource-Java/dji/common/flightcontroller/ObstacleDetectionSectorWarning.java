package dji.common.flightcontroller;

public enum ObstacleDetectionSectorWarning
{
  private int value;
  
  static
  {
    INVALID = new ObstacleDetectionSectorWarning("INVALID", 4, 15);
    ObstacleDetectionSectorWarning localObstacleDetectionSectorWarning = new ObstacleDetectionSectorWarning("UNKNOWN", 5, 255);
    UNKNOWN = localObstacleDetectionSectorWarning;
    $VALUES = new ObstacleDetectionSectorWarning[] { LEVEL_1, LEVEL_2, LEVEL_3, LEVEL_4, INVALID, localObstacleDetectionSectorWarning };
  }
  
  private ObstacleDetectionSectorWarning(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static ObstacleDetectionSectorWarning find(int paramInt)
  {
    ObstacleDetectionSectorWarning localObstacleDetectionSectorWarning = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localObstacleDetectionSectorWarning;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\ObstacleDetectionSectorWarning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */