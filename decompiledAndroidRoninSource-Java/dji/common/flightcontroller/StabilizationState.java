package dji.common.flightcontroller;

public class StabilizationState
{
  private boolean isActive = false;
  private boolean isPaused = false;
  private StabilizationPauseReason pauseReason = StabilizationPauseReason.OTHER;
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public StabilizationPauseReason getPauseReason()
  {
    return this.pauseReason;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isActive()
  {
    return this.isActive;
  }
  
  public boolean isPaused()
  {
    return this.isPaused;
  }
  
  public void setActive(boolean paramBoolean)
  {
    this.isActive = paramBoolean;
  }
  
  public void setPauseReason(StabilizationPauseReason paramStabilizationPauseReason)
  {
    this.pauseReason = paramStabilizationPauseReason;
  }
  
  public void setPaused(boolean paramBoolean)
  {
    this.isPaused = paramBoolean;
  }
  
  public static enum StabilizationPauseReason
  {
    private final int data;
    
    static
    {
      CAMERA_CHANGING = new StabilizationPauseReason("CAMERA_CHANGING", 1, 1);
      GIMBAL_MOVING = new StabilizationPauseReason("GIMBAL_MOVING", 2, 2);
      DRONE_MOVING = new StabilizationPauseReason("DRONE_MOVING", 3, 3);
      StabilizationPauseReason localStabilizationPauseReason = new StabilizationPauseReason("OTHER", 4, 255);
      OTHER = localStabilizationPauseReason;
      $VALUES = new StabilizationPauseReason[] { UNCHARACTERISTIC, CAMERA_CHANGING, GIMBAL_MOVING, DRONE_MOVING, localStabilizationPauseReason };
    }
    
    private StabilizationPauseReason(int paramInt)
    {
      this.data = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public static StabilizationPauseReason find(int paramInt)
    {
      StabilizationPauseReason localStabilizationPauseReason1 = OTHER;
      StabilizationPauseReason[] arrayOfStabilizationPauseReason = values();
      int j = arrayOfStabilizationPauseReason.length;
      int i = 0;
      while (i < j)
      {
        StabilizationPauseReason localStabilizationPauseReason2 = arrayOfStabilizationPauseReason[i];
        if (localStabilizationPauseReason2._equals(paramInt)) {
          return localStabilizationPauseReason2;
        }
        i += 1;
      }
      return localStabilizationPauseReason1;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\StabilizationState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */