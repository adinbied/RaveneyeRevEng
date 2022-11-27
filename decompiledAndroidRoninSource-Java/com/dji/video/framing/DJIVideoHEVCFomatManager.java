package com.dji.video.framing;

public class DJIVideoHEVCFomatManager
{
  private static final String TAG = "DJIVideoHEVCFomatManager";
  private HevcChangeCallback mHevcChangeCallback;
  private boolean mIsCameraInHevc = true;
  private boolean mIsPhoneSupportHevc = false;
  private boolean mIsPlaybackStatus = false;
  
  public DJIVideoHEVCFomatManager()
  {
    checkCodecSupport();
  }
  
  /* Error */
  private void checkCodecSupport()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static DJIVideoHEVCFomatManager getInstance()
  {
    return SingletonHolder.INSTANCE;
  }
  
  public void addHevcModeChangeListener(HevcChangeCallback paramHevcChangeCallback)
  {
    this.mHevcChangeCallback = paramHevcChangeCallback;
  }
  
  public boolean checkVideoParserIsUnmatched(boolean paramBoolean)
  {
    return false;
  }
  
  public boolean isCameraInHevc()
  {
    try
    {
      boolean bool = this.mIsCameraInHevc;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isPhoneSupportHevc()
  {
    return this.mIsPhoneSupportHevc;
  }
  
  public boolean isPlaybackStatus()
  {
    try
    {
      boolean bool = this.mIsPlaybackStatus;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void removeHevcModeChangeListener()
  {
    this.mHevcChangeCallback = null;
  }
  
  /* Error */
  public void setHevcMode(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  public void setPhoneSupportHevc(boolean paramBoolean)
  {
    this.mIsPhoneSupportHevc = paramBoolean;
  }
  
  /* Error */
  public void setPlaybackStatus(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  public static abstract interface HevcChangeCallback
  {
    public abstract void onHevcModeChanged(boolean paramBoolean);
    
    public abstract void onHevcModeUnMatched(boolean paramBoolean);
  }
  
  private static class SingletonHolder
  {
    private static final DJIVideoHEVCFomatManager INSTANCE = new DJIVideoHEVCFomatManager();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\DJIVideoHEVCFomatManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */