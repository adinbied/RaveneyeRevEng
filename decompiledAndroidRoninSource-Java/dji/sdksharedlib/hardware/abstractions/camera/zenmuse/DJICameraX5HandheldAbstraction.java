package dji.sdksharedlib.hardware.abstractions.camera.zenmuse;

import dji.midware.data.model.P3.DataCameraSetOpticsZoomMode.ZoomSpeed;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;

public class DJICameraX5HandheldAbstraction
  extends DJICameraX5BaseAbstraction
{
  private DataCameraSetOpticsZoomMode.ZoomSpeed speedCache = null;
  
  /* Error */
  protected void doSetOpticalZoomFocalLength(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  protected String getDisplayName()
  {
    return "Zenmuse X5";
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isAFSupported()
  {
    return true;
  }
  
  protected boolean isAudioRecordSupported()
  {
    return true;
  }
  
  protected boolean isHDRPhotoSupported()
  {
    return false;
  }
  
  protected boolean isHandHeldProduct()
  {
    return true;
  }
  
  protected boolean isMFSupported()
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
    return false;
  }
  
  protected boolean isTimeLapseSupported()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\zenmuse\DJICameraX5HandheldAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */