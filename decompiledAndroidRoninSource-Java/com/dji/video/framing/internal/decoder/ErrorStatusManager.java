package com.dji.video.framing.internal.decoder;

public class ErrorStatusManager
{
  private static final int SEND_ERR_STATUS_INTERVAL = 300;
  private static final String TAG = "ErrorStatusManager";
  private boolean mCurrentErrorStatus = false;
  private FrameCheckerCallback mFrameCheckerCallback;
  private long mLastSendErrorStatusTime = 0L;
  
  public static ErrorStatusManager getInstance()
  {
    return SingletonHolder.INSTANCE;
  }
  
  public boolean getErrorStatus()
  {
    return this.mCurrentErrorStatus;
  }
  
  public boolean isDemandI()
  {
    return false;
  }
  
  public boolean needCheckFrame()
  {
    return false;
  }
  
  /* Error */
  public void onErrorStatusChange(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setFrameCheckerCallback(FrameCheckerCallback paramFrameCheckerCallback)
  {
    this.mFrameCheckerCallback = paramFrameCheckerCallback;
  }
  
  public static abstract interface FrameCheckerCallback
  {
    public abstract boolean getErrorStatus();
    
    public abstract boolean isDemandI();
    
    public abstract boolean needCheckFrame();
    
    public abstract void onErrorStatusChange(boolean paramBoolean);
    
    public abstract boolean supportHevcTransfer();
  }
  
  private static class SingletonHolder
  {
    private static final ErrorStatusManager INSTANCE = new ErrorStatusManager();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\decoder\ErrorStatusManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */