package dji.common.gimbal;

public class GimbalState
{
  private Attitude attitudeInDegrees = null;
  private BalanceState balanceState;
  private int calibrationProgress = 0;
  private GimbalMode gimbalMode = null;
  private boolean isAttitudeReset = false;
  private boolean isBalanceTesting = false;
  private boolean isCalibrating = false;
  private boolean isCalibrationSuccessful = false;
  private boolean isGimbalOnTop = false;
  private boolean isMobileDeviceMounted;
  private boolean isMotorOverloaded;
  private boolean isPitchAtStop = false;
  private boolean isRollAtStop = false;
  private boolean isYawAtStop = false;
  private BalanceTestResult pitchTestResult;
  private float rollFineTuneInDegrees = -1.0F;
  private BalanceTestResult rollTestResult;
  private float yawRelativeToAircraftHeading;
  
  private GimbalState(Builder paramBuilder)
  {
    this.attitudeInDegrees = paramBuilder.attitudeInDegrees;
    this.rollFineTuneInDegrees = paramBuilder.rollFineTuneInDegrees;
    this.gimbalMode = paramBuilder.gimbalMode;
    this.isAttitudeReset = paramBuilder.isAttitudeReset;
    this.isCalibrating = paramBuilder.isCalibrating;
    this.isPitchAtStop = paramBuilder.isPitchAtStop;
    this.isRollAtStop = paramBuilder.isRollAtStop;
    this.isCalibrationSuccessful = paramBuilder.isCalibrationSuccessful;
    this.calibrationProgress = paramBuilder.calibrationProgress;
    this.isYawAtStop = paramBuilder.isYawAtStop;
    this.isGimbalOnTop = paramBuilder.isGimbalOnTop;
    this.isBalanceTesting = paramBuilder.isBalanceTesting;
    this.pitchTestResult = paramBuilder.pitchTestResult;
    this.rollTestResult = paramBuilder.rollTestResult;
    this.isMobileDeviceMounted = paramBuilder.isMobileDeviceMounted;
    this.isMotorOverloaded = paramBuilder.isMotorOverloaded;
    this.balanceState = paramBuilder.balanceState;
    this.yawRelativeToAircraftHeading = paramBuilder.yawRelativeAicraftHeading;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public Attitude getAttitudeInDegrees()
  {
    return this.attitudeInDegrees;
  }
  
  public BalanceState getBalanceState()
  {
    return this.balanceState;
  }
  
  public int getCalibrationProgress()
  {
    return this.calibrationProgress;
  }
  
  public GimbalMode getMode()
  {
    return this.gimbalMode;
  }
  
  public BalanceTestResult getPitchBalanceTestResult()
  {
    return this.pitchTestResult;
  }
  
  public BalanceTestResult getRollBalanceTestResult()
  {
    return this.rollTestResult;
  }
  
  public float getRollFineTuneInDegrees()
  {
    return this.rollFineTuneInDegrees;
  }
  
  public float getYawRelativeToAircraftHeading()
  {
    return this.yawRelativeToAircraftHeading;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isAttitudeReset()
  {
    return this.isAttitudeReset;
  }
  
  public boolean isBalanceTesting()
  {
    return this.isBalanceTesting;
  }
  
  public boolean isCalibrating()
  {
    return this.isCalibrating;
  }
  
  public boolean isCalibrationSuccessful()
  {
    return this.isCalibrationSuccessful;
  }
  
  public boolean isGimbalOnTop()
  {
    return this.isGimbalOnTop;
  }
  
  public boolean isMobileDeviceMounted()
  {
    return this.isMobileDeviceMounted;
  }
  
  public boolean isMotorOverloaded()
  {
    return this.isMotorOverloaded;
  }
  
  public boolean isPitchAtStop()
  {
    return this.isPitchAtStop;
  }
  
  public boolean isRollAtStop()
  {
    return this.isRollAtStop;
  }
  
  public boolean isYawAtStop()
  {
    return this.isYawAtStop;
  }
  
  public static final class Builder
  {
    private Attitude attitudeInDegrees = null;
    private BalanceState balanceState = BalanceState.UNKNOWN;
    private int calibrationProgress = 0;
    private GimbalMode gimbalMode = null;
    private boolean isAttitudeReset = false;
    private boolean isBalanceTesting = false;
    private boolean isCalibrating = false;
    private boolean isCalibrationSuccessful = false;
    private boolean isGimbalOnTop = false;
    private boolean isMobileDeviceMounted = false;
    private boolean isMotorOverloaded = false;
    private boolean isPitchAtStop = false;
    private boolean isRollAtStop = false;
    private boolean isYawAtStop = false;
    private BalanceTestResult pitchTestResult = BalanceTestResult.UNKNOWN;
    private float rollFineTuneInDegrees = -1.0F;
    private BalanceTestResult rollTestResult = BalanceTestResult.UNKNOWN;
    private float yawRelativeAicraftHeading;
    
    public Builder attitudeInDegrees(Attitude paramAttitude)
    {
      this.attitudeInDegrees = paramAttitude;
      return this;
    }
    
    public Builder balanceState(BalanceState paramBalanceState)
    {
      this.balanceState = paramBalanceState;
      return this;
    }
    
    public GimbalState build()
    {
      return new GimbalState(this, null);
    }
    
    public Builder calibrationProgress(int paramInt)
    {
      this.calibrationProgress = paramInt;
      return this;
    }
    
    public Builder isAttitudeReset(boolean paramBoolean)
    {
      this.isAttitudeReset = paramBoolean;
      return this;
    }
    
    public Builder isBalanceTesting(boolean paramBoolean)
    {
      this.isBalanceTesting = paramBoolean;
      return this;
    }
    
    public Builder isCalibrating(boolean paramBoolean)
    {
      this.isCalibrating = paramBoolean;
      return this;
    }
    
    public Builder isCalibrationSuccessful(boolean paramBoolean)
    {
      this.isCalibrationSuccessful = paramBoolean;
      return this;
    }
    
    public Builder isGimbalOnTop(boolean paramBoolean)
    {
      this.isGimbalOnTop = paramBoolean;
      return this;
    }
    
    public Builder isMobileDeviceMounted(boolean paramBoolean)
    {
      this.isMobileDeviceMounted = paramBoolean;
      return this;
    }
    
    public Builder isMotorOverloaded(boolean paramBoolean)
    {
      this.isMotorOverloaded = paramBoolean;
      return this;
    }
    
    public Builder isPitchAtStop(boolean paramBoolean)
    {
      this.isPitchAtStop = paramBoolean;
      return this;
    }
    
    public Builder isRollAtStop(boolean paramBoolean)
    {
      this.isRollAtStop = paramBoolean;
      return this;
    }
    
    public Builder isYawAtStop(boolean paramBoolean)
    {
      this.isYawAtStop = paramBoolean;
      return this;
    }
    
    public Builder mode(GimbalMode paramGimbalMode)
    {
      this.gimbalMode = paramGimbalMode;
      return this;
    }
    
    public Builder pitchTestResult(BalanceTestResult paramBalanceTestResult)
    {
      this.pitchTestResult = paramBalanceTestResult;
      return this;
    }
    
    public Builder rollFineTuneInDegrees(float paramFloat)
    {
      this.rollFineTuneInDegrees = paramFloat;
      return this;
    }
    
    public Builder rollTestResult(BalanceTestResult paramBalanceTestResult)
    {
      this.rollTestResult = paramBalanceTestResult;
      return this;
    }
    
    public Builder yawRelativeAicraftHeading(float paramFloat)
    {
      this.yawRelativeAicraftHeading = paramFloat;
      return this;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(GimbalState paramGimbalState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\GimbalState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */