package dji.common.camera;

public class SystemState
{
  private int currentVideoRecordingTimeInSeconds;
  private boolean hasError;
  private boolean isOverHeating;
  private boolean isPhotoStoring;
  private boolean isRecording;
  private boolean isShootingBurstPhoto;
  private boolean isShootingIntervalPhoto;
  private boolean isShootingRAWBurstPhoto;
  private boolean isShootingRawPhoto;
  private boolean isShootingSinglePhoto;
  private SettingsDefinitions.CameraMode mode;
  
  private SystemState(Builder paramBuilder)
  {
    this.isPhotoStoring = paramBuilder.isPhotoStoring;
    this.currentVideoRecordingTimeInSeconds = paramBuilder.currentVideoRecordingTimeInSeconds;
    this.mode = paramBuilder.mode;
    this.isShootingIntervalPhoto = paramBuilder.isShootingIntervalPhoto;
    this.isShootingBurstPhoto = paramBuilder.isShootingBurstPhoto;
    this.isShootingSinglePhoto = paramBuilder.isShootingSinglePhoto;
    this.isShootingRawPhoto = paramBuilder.isShootingRawPhoto;
    this.isRecording = paramBuilder.isRecording;
    this.isOverHeating = paramBuilder.isOverHeating;
    this.hasError = paramBuilder.hasError;
    this.isShootingRAWBurstPhoto = paramBuilder.isShootingRAWBurstPhoto;
  }
  
  public int getCurrentVideoRecordingTimeInSeconds()
  {
    return this.currentVideoRecordingTimeInSeconds;
  }
  
  public SettingsDefinitions.CameraMode getMode()
  {
    return this.mode;
  }
  
  public boolean hasError()
  {
    return this.hasError;
  }
  
  public boolean isOverheating()
  {
    return this.isOverHeating;
  }
  
  public boolean isRecording()
  {
    return this.isRecording;
  }
  
  public boolean isShootingBurstPhoto()
  {
    return this.isShootingBurstPhoto;
  }
  
  public boolean isShootingIntervalPhoto()
  {
    return this.isShootingIntervalPhoto;
  }
  
  public boolean isShootingRAWBurstPhoto()
  {
    return this.isShootingRAWBurstPhoto;
  }
  
  public boolean isShootingSinglePhoto()
  {
    return this.isShootingSinglePhoto;
  }
  
  public boolean isShootingSinglePhotoInRAWFormat()
  {
    return this.isShootingRawPhoto;
  }
  
  public boolean isStoringPhoto()
  {
    return this.isPhotoStoring;
  }
  
  public static final class Builder
  {
    private int currentVideoRecordingTimeInSeconds;
    private boolean hasError;
    private boolean isOverHeating;
    private boolean isPhotoStoring;
    private boolean isRecording;
    private boolean isShootingBurstPhoto;
    private boolean isShootingIntervalPhoto;
    private boolean isShootingRAWBurstPhoto;
    private boolean isShootingRawPhoto;
    private boolean isShootingSinglePhoto;
    private SettingsDefinitions.CameraMode mode;
    
    public SystemState build()
    {
      return new SystemState(this, null);
    }
    
    public Builder currentVideoRecordingTimeInSeconds(int paramInt)
    {
      this.currentVideoRecordingTimeInSeconds = paramInt;
      return this;
    }
    
    public Builder hasError(boolean paramBoolean)
    {
      this.hasError = paramBoolean;
      return this;
    }
    
    public Builder isOverHeating(boolean paramBoolean)
    {
      this.isOverHeating = paramBoolean;
      return this;
    }
    
    public Builder isPhotoStoring(boolean paramBoolean)
    {
      this.isPhotoStoring = paramBoolean;
      return this;
    }
    
    public Builder isRecording(boolean paramBoolean)
    {
      this.isRecording = paramBoolean;
      return this;
    }
    
    public Builder isShootingBurstPhoto(boolean paramBoolean)
    {
      this.isShootingBurstPhoto = paramBoolean;
      return this;
    }
    
    public Builder isShootingIntervalPhoto(boolean paramBoolean)
    {
      this.isShootingIntervalPhoto = paramBoolean;
      return this;
    }
    
    public Builder isShootingRAWBurstPhoto(boolean paramBoolean)
    {
      this.isShootingRAWBurstPhoto = paramBoolean;
      return this;
    }
    
    public Builder isShootingRawPhoto(boolean paramBoolean)
    {
      this.isShootingRawPhoto = paramBoolean;
      return this;
    }
    
    public Builder isShootingSinglePhoto(boolean paramBoolean)
    {
      this.isShootingSinglePhoto = paramBoolean;
      return this;
    }
    
    public Builder mode(SettingsDefinitions.CameraMode paramCameraMode)
    {
      this.mode = paramCameraMode;
      return this;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(SystemState paramSystemState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\SystemState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */