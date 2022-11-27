package dji.sdksharedlib.hardware.abstractions.camera.zenmuse;

import dji.common.error.DJIError;
import dji.common.util.CallbackUtils;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.camera.DJICameraBaseAbstraction;

public class DJICameraX3HandheldAbstraction
  extends DJICameraBaseAbstraction
{
  protected boolean checkPortraitDigitalFilterSupported()
  {
    return true;
  }
  
  public DJIError checkPrerequisiteForSetDigitalZoomScale()
  {
    return null;
  }
  
  protected String getDisplayName()
  {
    return "Zenmuse X3";
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isAudioRecordSupported()
  {
    return true;
  }
  
  protected boolean isDigitalZoomScaleSupported()
  {
    return true;
  }
  
  protected boolean isHandHeldProduct()
  {
    return true;
  }
  
  protected boolean isMediaDownloadModeSupported()
  {
    return true;
  }
  
  protected boolean isPlaybackSupported()
  {
    return false;
  }
  
  protected boolean isSlowMotionSupported()
  {
    return true;
  }
  
  protected boolean isTimeLapseSupported()
  {
    return true;
  }
  
  protected boolean isTurnOffFanSupported()
  {
    return true;
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("VideoResolutionAndFrameRate")
  public void setVideoResolutionAndFrameRate(dji.common.camera.ResolutionAndFrameRate arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\zenmuse\DJICameraX3HandheldAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */