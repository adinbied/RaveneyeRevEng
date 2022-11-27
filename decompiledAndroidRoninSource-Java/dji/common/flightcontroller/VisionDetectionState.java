package dji.common.flightcontroller;

public final class VisionDetectionState
{
  private final VisionSystemWarning SystemWarning;
  private final ObstacleDetectionSector[] detectionSectors;
  private final double obstacleDistanceInMeters;
  private final VisionSensorPosition position;
  private final boolean sensorBeingUsed;
  
  private VisionDetectionState(boolean paramBoolean, double paramDouble, VisionSystemWarning paramVisionSystemWarning, ObstacleDetectionSector[] paramArrayOfObstacleDetectionSector, VisionSensorPosition paramVisionSensorPosition)
  {
    this.sensorBeingUsed = paramBoolean;
    this.obstacleDistanceInMeters = paramDouble;
    this.SystemWarning = paramVisionSystemWarning;
    this.detectionSectors = paramArrayOfObstacleDetectionSector;
    this.position = paramVisionSensorPosition;
  }
  
  public static VisionDetectionState createInstance(boolean paramBoolean, double paramDouble, VisionSystemWarning paramVisionSystemWarning, ObstacleDetectionSector[] paramArrayOfObstacleDetectionSector, VisionSensorPosition paramVisionSensorPosition)
  {
    return new VisionDetectionState(paramBoolean, paramDouble, paramVisionSystemWarning, paramArrayOfObstacleDetectionSector, paramVisionSensorPosition);
  }
  
  public ObstacleDetectionSector[] getDetectionSectors()
  {
    return this.detectionSectors;
  }
  
  public double getObstacleDistanceInMeters()
  {
    return this.obstacleDistanceInMeters;
  }
  
  public VisionSensorPosition getPosition()
  {
    return this.position;
  }
  
  public VisionSystemWarning getSystemWarning()
  {
    return this.SystemWarning;
  }
  
  public boolean isSensorBeingUsed()
  {
    return this.sensorBeingUsed;
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(VisionDetectionState paramVisionDetectionState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\VisionDetectionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */