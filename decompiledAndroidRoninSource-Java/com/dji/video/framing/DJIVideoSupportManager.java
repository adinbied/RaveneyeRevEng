package com.dji.video.framing;

public class DJIVideoSupportManager
{
  private static final String DJI_VENDOR = "DJI";
  private static final String HEVC_MIME = "video/hevc";
  private static final int MIN_FULL_HD_ENCODER_SUPPORT = 240;
  private static final int MIN_HIGH_FPS_SUPPORT = 480;
  private static final String TAG = "DJIVideoSupportManager";
  private boolean mIsInHevcMode = false;
  private boolean mIsSupportHevcMode = false;
  private boolean mSupportFullHDEncoder = false;
  private boolean mSupportHighFpsMode = false;
  
  public DJIVideoSupportManager()
  {
    checkHevcCodecSupport();
    checkHighFpsSupport();
  }
  
  /* Error */
  private void checkHevcCodecSupport()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void checkHighFpsSupport()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static DJIVideoSupportManager getInstance()
  {
    return SingletonHolder.INSTANCE;
  }
  
  public boolean isSupportFullHDEncoder()
  {
    return this.mSupportFullHDEncoder;
  }
  
  public boolean isSupportHevcMode()
  {
    return this.mIsSupportHevcMode;
  }
  
  public boolean isSupportHighFpsMode()
  {
    return this.mSupportHighFpsMode;
  }
  
  private static class SingletonHolder
  {
    private static final DJIVideoSupportManager INSTANCE = new DJIVideoSupportManager();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\DJIVideoSupportManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */