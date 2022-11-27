package dji.common.gimbal;

public class MovementSettings
{
  int pitchControllerSmoothingFactor;
  int pitchControllerSpeedCoefficient;
  int pitchSmoothTrackAcceleration;
  int pitchSmoothTrackDeadband;
  boolean pitchSmoothTrackEnable;
  int pitchSmoothTrackSpeed;
  MovementSettingsProfile profile;
  int yawControllerSmoothingFactor;
  int yawControllerSpeedCoefficient;
  int yawSmoothTrackAcceleration;
  int yawSmoothTrackDeadband;
  boolean yawSmoothTrackEnable;
  int yawSmoothTrackSpeed;
  
  public MovementSettings(MovementSettingsProfile paramMovementSettingsProfile, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    this.profile = paramMovementSettingsProfile;
    this.yawSmoothTrackEnable = paramBoolean1;
    this.pitchSmoothTrackEnable = paramBoolean2;
    this.yawSmoothTrackSpeed = paramInt1;
    this.pitchSmoothTrackSpeed = paramInt2;
    this.yawSmoothTrackDeadband = paramInt3;
    this.pitchSmoothTrackDeadband = paramInt4;
    this.yawSmoothTrackAcceleration = paramInt5;
    this.pitchSmoothTrackAcceleration = paramInt6;
    this.yawControllerSmoothingFactor = paramInt7;
    this.pitchControllerSmoothingFactor = paramInt8;
    this.yawControllerSpeedCoefficient = paramInt9;
    this.pitchControllerSpeedCoefficient = paramInt10;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int getPitchControllerSmoothingFactor()
  {
    return this.pitchControllerSmoothingFactor;
  }
  
  public int getPitchControllerSpeedCoefficient()
  {
    return this.pitchControllerSpeedCoefficient;
  }
  
  public int getPitchSmoothTrackAcceleration()
  {
    return this.pitchSmoothTrackAcceleration;
  }
  
  public int getPitchSmoothTrackDeadband()
  {
    return this.pitchSmoothTrackDeadband;
  }
  
  public int getPitchSmoothTrackSpeed()
  {
    return this.pitchSmoothTrackSpeed;
  }
  
  public MovementSettingsProfile getProfile()
  {
    return this.profile;
  }
  
  public int getYawControllerSmoothingFactor()
  {
    return this.yawControllerSmoothingFactor;
  }
  
  public int getYawControllerSpeedCoefficient()
  {
    return this.yawControllerSpeedCoefficient;
  }
  
  public int getYawSmoothTrackAcceleration()
  {
    return this.yawSmoothTrackAcceleration;
  }
  
  public int getYawSmoothTrackDeadband()
  {
    return this.yawSmoothTrackDeadband;
  }
  
  public int getYawSmoothTrackSpeed()
  {
    return this.yawSmoothTrackSpeed;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isPitchSmoothTrackEnabled()
  {
    return this.pitchSmoothTrackEnable;
  }
  
  public boolean isYawSmoothTrackEnabled()
  {
    return this.yawSmoothTrackEnable;
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(MovementSettings paramMovementSettings);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\MovementSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */