package dji.common.camera;

public class SSDState
{
  private int burstPhotoShootCount;
  private SSDCapacity capacity;
  private boolean isConnected;
  private long remainingSpaceInMB;
  private int remainingTime;
  private SSDOperationState ssdState;
  private SettingsDefinitions.VideoFrameRate videoFrameRate;
  private SettingsDefinitions.VideoResolution videoResolution;
  
  private SSDState(Builder paramBuilder)
  {
    this.ssdState = paramBuilder.ssdState;
    this.isConnected = paramBuilder.isConnected;
    this.capacity = paramBuilder.capacity;
    this.remainingTime = paramBuilder.remainingTime;
    this.remainingSpaceInMB = paramBuilder.remainingSpaceInMB;
    this.videoResolution = paramBuilder.videoResolution;
    this.videoFrameRate = paramBuilder.videoFrameRate;
    this.burstPhotoShootCount = paramBuilder.burstPhotoShootCount;
  }
  
  public int getAvailableRecordingTimeInSeconds()
  {
    return this.remainingTime;
  }
  
  public SSDCapacity getCapacity()
  {
    return this.capacity;
  }
  
  public int getRAWPhotoBurstCount()
  {
    return this.burstPhotoShootCount;
  }
  
  public long getRemainingSpaceInMB()
  {
    return this.remainingSpaceInMB;
  }
  
  public SSDOperationState getSSDOperationState()
  {
    return this.ssdState;
  }
  
  public SettingsDefinitions.VideoFrameRate getVideoFrameRate()
  {
    return this.videoFrameRate;
  }
  
  public SettingsDefinitions.VideoResolution getVideoResolution()
  {
    return this.videoResolution;
  }
  
  public boolean isConnected()
  {
    return this.isConnected;
  }
  
  public static final class Builder
  {
    private int burstPhotoShootCount;
    private SSDCapacity capacity;
    private boolean isConnected;
    private long remainingSpaceInMB;
    private int remainingTime;
    private SSDOperationState ssdState;
    private SettingsDefinitions.VideoFrameRate videoFrameRate;
    private SettingsDefinitions.VideoResolution videoResolution;
    
    public SSDState build()
    {
      return new SSDState(this, null);
    }
    
    public Builder burstPhotoShootCount(int paramInt)
    {
      this.burstPhotoShootCount = paramInt;
      return this;
    }
    
    public Builder capacity(SSDCapacity paramSSDCapacity)
    {
      this.capacity = paramSSDCapacity;
      return this;
    }
    
    public Builder isConnected(boolean paramBoolean)
    {
      this.isConnected = paramBoolean;
      return this;
    }
    
    public Builder remainingSpaceInMB(long paramLong)
    {
      this.remainingSpaceInMB = paramLong;
      return this;
    }
    
    public Builder remainingTime(int paramInt)
    {
      this.remainingTime = paramInt;
      return this;
    }
    
    public Builder ssdState(SSDOperationState paramSSDOperationState)
    {
      this.ssdState = paramSSDOperationState;
      return this;
    }
    
    public Builder videoFrameRate(SettingsDefinitions.VideoFrameRate paramVideoFrameRate)
    {
      this.videoFrameRate = paramVideoFrameRate;
      return this;
    }
    
    public Builder videoResolution(SettingsDefinitions.VideoResolution paramVideoResolution)
    {
      this.videoResolution = paramVideoResolution;
      return this;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(SSDState paramSSDState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\SSDState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */