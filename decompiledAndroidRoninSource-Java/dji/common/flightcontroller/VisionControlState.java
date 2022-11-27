package dji.common.flightcontroller;

public class VisionControlState
{
  private boolean ascentLimitedByObstacle = false;
  private boolean avoidingActiveObstacleCollision = false;
  private boolean isBraking = false;
  private boolean landingPrecisely = false;
  private VisionLandingProtectionState landingProtectionState = VisionLandingProtectionState.NONE;
  
  public VisionControlState(VisionLandingProtectionState paramVisionLandingProtectionState, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.landingProtectionState = paramVisionLandingProtectionState;
    this.landingPrecisely = paramBoolean1;
    this.isBraking = paramBoolean2;
    this.ascentLimitedByObstacle = paramBoolean3;
    this.avoidingActiveObstacleCollision = paramBoolean4;
  }
  
  public boolean isAscentLimitedByObstacle()
  {
    return this.ascentLimitedByObstacle;
  }
  
  public boolean isAvoidingActiveObstacleCollision()
  {
    return this.avoidingActiveObstacleCollision;
  }
  
  public boolean isBraking()
  {
    return this.isBraking;
  }
  
  public boolean isPerformingPrecisionLanding()
  {
    return this.landingPrecisely;
  }
  
  public VisionLandingProtectionState landingProtectionState()
  {
    return this.landingProtectionState;
  }
  
  public void setAscentLimitedByObstacle(boolean paramBoolean)
  {
    this.ascentLimitedByObstacle = paramBoolean;
  }
  
  public void setAvoidingActiveObstacleCollision(boolean paramBoolean)
  {
    this.avoidingActiveObstacleCollision = paramBoolean;
  }
  
  public void setBraking(boolean paramBoolean)
  {
    this.isBraking = paramBoolean;
  }
  
  public void setLandingProtectionState(VisionLandingProtectionState paramVisionLandingProtectionState)
  {
    this.landingProtectionState = paramVisionLandingProtectionState;
  }
  
  public void setPerformingPrecisionLanding(boolean paramBoolean)
  {
    this.landingPrecisely = paramBoolean;
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(VisionControlState paramVisionControlState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\VisionControlState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */