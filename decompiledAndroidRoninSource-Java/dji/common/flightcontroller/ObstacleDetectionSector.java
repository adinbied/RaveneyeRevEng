package dji.common.flightcontroller;

public class ObstacleDetectionSector
{
  private float obstacleDistanceInMeters = 0.0F;
  private ObstacleDetectionSectorWarning warningLevel = ObstacleDetectionSectorWarning.UNKNOWN;
  
  public ObstacleDetectionSector(ObstacleDetectionSectorWarning paramObstacleDetectionSectorWarning, float paramFloat)
  {
    this.warningLevel = paramObstacleDetectionSectorWarning;
    this.obstacleDistanceInMeters = paramFloat;
  }
  
  public float getObstacleDistanceInMeters()
  {
    return this.obstacleDistanceInMeters;
  }
  
  public ObstacleDetectionSectorWarning getWarningLevel()
  {
    return this.warningLevel;
  }
  
  public void setObstacleDistanceInMeters(float paramFloat)
  {
    this.obstacleDistanceInMeters = paramFloat;
  }
  
  public void setWarningLevel(ObstacleDetectionSectorWarning paramObstacleDetectionSectorWarning)
  {
    this.warningLevel = paramObstacleDetectionSectorWarning;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\ObstacleDetectionSector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */