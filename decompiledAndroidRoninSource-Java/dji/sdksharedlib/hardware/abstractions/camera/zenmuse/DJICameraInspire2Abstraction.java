package dji.sdksharedlib.hardware.abstractions.camera.zenmuse;

import dji.common.camera.SettingsDefinitions.CameraMode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;

public class DJICameraInspire2Abstraction
  extends DJICameraX5BaseAbstraction
{
  /* Error */
  public void getLiveViewOutputMode(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isAdjustableApertureSupported()
  {
    return true;
  }
  
  protected boolean isBroadcastModeSupported()
  {
    return true;
  }
  
  protected boolean isHDRPhotoSupported()
  {
    return false;
  }
  
  protected boolean isMediaDownloadModeSupported()
  {
    return true;
  }
  
  protected boolean isNewProcessOfActivation()
  {
    return true;
  }
  
  protected boolean isPhotoIntervalParamValid(int paramInt)
  {
    return false;
  }
  
  protected boolean isPlaybackSupported()
  {
    return false;
  }
  
  protected boolean isSlowMotionSupported()
  {
    return false;
  }
  
  protected boolean isVideoPlaybackSupported()
  {
    return true;
  }
  
  protected int mapMediaDownloadModeToProtocolValue(SettingsDefinitions.CameraMode paramCameraMode)
  {
    return 0;
  }
  
  /* Error */
  public void setLiveViewOutputMode(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("PhotoRAWBurstCount")
  public void setPhotoRawBurstCount(dji.common.camera.SettingsDefinitions.PhotoBurstCount arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("SSDVideoDigitalFilter")
  public void setSSDRawVideoDigitalFilter(dji.common.camera.SettingsDefinitions.SSDVideoDigitalFilter arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\zenmuse\DJICameraInspire2Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */