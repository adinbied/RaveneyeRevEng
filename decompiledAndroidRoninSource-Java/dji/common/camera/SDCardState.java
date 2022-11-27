package dji.common.camera;

public class SDCardState
{
  private long availableCaptureCount;
  private int availableRecordingTime;
  private boolean hasError;
  private boolean isFormatted;
  private boolean isFormatting;
  private boolean isFull;
  private boolean isInitializing;
  private boolean isInserted;
  private boolean isInvalidFormat;
  private boolean isReadOnly;
  private boolean isVerified;
  private int remainingSpace;
  private int totalSpace;
  
  private SDCardState(Builder paramBuilder)
  {
    this.isInitializing = paramBuilder.isInitializing;
    this.hasError = paramBuilder.hasError;
    this.isReadOnly = paramBuilder.isReadOnly;
    this.isInvalidFormat = paramBuilder.isInvalidFormat;
    this.isFormatting = paramBuilder.isFormatting;
    this.isFormatted = paramBuilder.isFormatted;
    this.isFull = paramBuilder.isFull;
    this.availableCaptureCount = paramBuilder.availableCaptureCount;
    this.isVerified = paramBuilder.isVerified;
    this.isInserted = paramBuilder.isInserted;
    this.totalSpace = paramBuilder.totalSpace;
    this.availableRecordingTime = paramBuilder.availableRecordingTime;
    this.remainingSpace = paramBuilder.remainingSpace;
  }
  
  public long getAvailableCaptureCount()
  {
    return this.availableCaptureCount;
  }
  
  public int getAvailableRecordingTimeInSeconds()
  {
    return this.availableRecordingTime;
  }
  
  public int getRemainingSpaceInMB()
  {
    return this.remainingSpace;
  }
  
  public int getTotalSpaceInMB()
  {
    return this.totalSpace;
  }
  
  public boolean hasError()
  {
    return this.hasError;
  }
  
  public boolean isFormatted()
  {
    return this.isFormatted;
  }
  
  public boolean isFormatting()
  {
    return this.isFormatting;
  }
  
  public boolean isFull()
  {
    return this.isFull;
  }
  
  public boolean isInitializing()
  {
    return this.isInitializing;
  }
  
  public boolean isInserted()
  {
    return this.isInserted;
  }
  
  public boolean isInvalidFormat()
  {
    return this.isInvalidFormat;
  }
  
  public boolean isReadOnly()
  {
    return this.isReadOnly;
  }
  
  public boolean isVerified()
  {
    return this.isVerified;
  }
  
  public void remainingSpaceInMB(int paramInt)
  {
    this.remainingSpace = paramInt;
  }
  
  public void totalSpaceInMB(int paramInt)
  {
    this.totalSpace = paramInt;
  }
  
  public static final class Builder
  {
    private long availableCaptureCount;
    private int availableRecordingTime;
    private boolean hasError;
    private boolean isFormatted;
    private boolean isFormatting;
    private boolean isFull;
    private boolean isInitializing;
    private boolean isInserted;
    private boolean isInvalidFormat;
    private boolean isReadOnly;
    private boolean isVerified;
    private int remainingSpace;
    private int totalSpace;
    
    public Builder availableCaptureCount(long paramLong)
    {
      this.availableCaptureCount = paramLong;
      return this;
    }
    
    public Builder availableRecordingTime(int paramInt)
    {
      this.availableRecordingTime = paramInt;
      return this;
    }
    
    public SDCardState build()
    {
      return new SDCardState(this, null);
    }
    
    public Builder hasError(boolean paramBoolean)
    {
      this.hasError = paramBoolean;
      return this;
    }
    
    public Builder isFormatted(boolean paramBoolean)
    {
      this.isFormatted = paramBoolean;
      return this;
    }
    
    public Builder isFormatting(boolean paramBoolean)
    {
      this.isFormatting = paramBoolean;
      return this;
    }
    
    public Builder isFull(boolean paramBoolean)
    {
      this.isFull = paramBoolean;
      return this;
    }
    
    public Builder isInitializing(boolean paramBoolean)
    {
      this.isInitializing = paramBoolean;
      return this;
    }
    
    public Builder isInserted(boolean paramBoolean)
    {
      this.isInserted = paramBoolean;
      return this;
    }
    
    public Builder isInvalidFormat(boolean paramBoolean)
    {
      this.isInvalidFormat = paramBoolean;
      return this;
    }
    
    public Builder isReadOnly(boolean paramBoolean)
    {
      this.isReadOnly = paramBoolean;
      return this;
    }
    
    public Builder isVerified(boolean paramBoolean)
    {
      this.isVerified = paramBoolean;
      return this;
    }
    
    public Builder remainingSpace(int paramInt)
    {
      this.remainingSpace = paramInt;
      return this;
    }
    
    public Builder totalSpace(int paramInt)
    {
      this.totalSpace = paramInt;
      return this;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(SDCardState paramSDCardState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\SDCardState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */