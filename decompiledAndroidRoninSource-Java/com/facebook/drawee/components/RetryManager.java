package com.facebook.drawee.components;

public class RetryManager
{
  private static final int MAX_TAP_TO_RETRY_ATTEMPTS = 4;
  private int mMaxTapToRetryAttempts;
  private int mTapToRetryAttempts;
  private boolean mTapToRetryEnabled;
  
  public RetryManager()
  {
    init();
  }
  
  public static RetryManager newInstance()
  {
    return new RetryManager();
  }
  
  public void init()
  {
    this.mTapToRetryEnabled = false;
    this.mMaxTapToRetryAttempts = 4;
    reset();
  }
  
  public boolean isTapToRetryEnabled()
  {
    return this.mTapToRetryEnabled;
  }
  
  public void notifyTapToRetry()
  {
    this.mTapToRetryAttempts += 1;
  }
  
  public void reset()
  {
    this.mTapToRetryAttempts = 0;
  }
  
  public void setMaxTapToRetryAttemps(int paramInt)
  {
    this.mMaxTapToRetryAttempts = paramInt;
  }
  
  public void setTapToRetryEnabled(boolean paramBoolean)
  {
    this.mTapToRetryEnabled = paramBoolean;
  }
  
  public boolean shouldRetryOnTap()
  {
    return (this.mTapToRetryEnabled) && (this.mTapToRetryAttempts < this.mMaxTapToRetryAttempts);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\components\RetryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */