package dji.common.flightcontroller;

public final class GoHomeAssessment
{
  private final boolean aircraftRequestingToGoHome;
  private final int batteryPercentageNeededToGoHome;
  private final int batteryPercentageNeededToLandFromCurrentHeight;
  private final float maxRadiusAircraftCanFlyAndGoHome;
  private final int remainingFlightTime;
  private final int timeNeededToGoHome;
  private final int timeNeededToLandFromCurrentHeight;
  
  private GoHomeAssessment(Builder paramBuilder)
  {
    this.remainingFlightTime = paramBuilder.remainingFlightTime;
    this.timeNeededToGoHome = paramBuilder.timeNeededToGoHome;
    this.timeNeededToLandFromCurrentHeight = paramBuilder.timeNeededToLandFromCurrentHeight;
    this.batteryPercentageNeededToGoHome = paramBuilder.batteryPercentageNeededToGoHome;
    this.maxRadiusAircraftCanFlyAndGoHome = paramBuilder.maxRadiusAircraftCanFlyAndGoHome;
    this.aircraftRequestingToGoHome = paramBuilder.aircraftRequestingToGoHome;
    this.batteryPercentageNeededToLandFromCurrentHeight = paramBuilder.batteryPercentageNeededToLandFromCurrentHeight;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int getBatteryPercentageNeededToGoHome()
  {
    return this.batteryPercentageNeededToGoHome;
  }
  
  public int getBatteryPercentageNeededToLandFromCurrentHeight()
  {
    return this.batteryPercentageNeededToLandFromCurrentHeight;
  }
  
  public float getMaxRadiusAircraftCanFlyAndGoHome()
  {
    return this.maxRadiusAircraftCanFlyAndGoHome;
  }
  
  public int getRemainingFlightTime()
  {
    return this.remainingFlightTime;
  }
  
  public int getTimeNeededToGoHome()
  {
    return this.timeNeededToGoHome;
  }
  
  public int getTimeNeededToLandFromCurrentHeight()
  {
    return this.timeNeededToLandFromCurrentHeight;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isAircraftRequestingToGoHome()
  {
    return this.aircraftRequestingToGoHome;
  }
  
  public static final class Builder
  {
    private boolean aircraftRequestingToGoHome;
    private int batteryPercentageNeededToGoHome;
    private int batteryPercentageNeededToLandFromCurrentHeight;
    private float maxRadiusAircraftCanFlyAndGoHome;
    private int remainingFlightTime;
    private int timeNeededToGoHome;
    private int timeNeededToLandFromCurrentHeight;
    
    public Builder aircraftRequestingToGoHome(boolean paramBoolean)
    {
      this.aircraftRequestingToGoHome = paramBoolean;
      return this;
    }
    
    public Builder batteryPercentageNeededToGoHome(int paramInt)
    {
      this.batteryPercentageNeededToGoHome = paramInt;
      return this;
    }
    
    public Builder batteryPercentageNeededToLandFromCurrentHeight(int paramInt)
    {
      this.batteryPercentageNeededToLandFromCurrentHeight = paramInt;
      return this;
    }
    
    public GoHomeAssessment build()
    {
      return new GoHomeAssessment(this, null);
    }
    
    public Builder maxRadiusAircraftCanFlyAndGoHome(float paramFloat)
    {
      this.maxRadiusAircraftCanFlyAndGoHome = paramFloat;
      return this;
    }
    
    public Builder remainingFlightTime(int paramInt)
    {
      this.remainingFlightTime = paramInt;
      return this;
    }
    
    public Builder timeNeededToGoHome(int paramInt)
    {
      this.timeNeededToGoHome = paramInt;
      return this;
    }
    
    public Builder timeNeededToLandFromCurrentHeight(int paramInt)
    {
      this.timeNeededToLandFromCurrentHeight = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\GoHomeAssessment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */