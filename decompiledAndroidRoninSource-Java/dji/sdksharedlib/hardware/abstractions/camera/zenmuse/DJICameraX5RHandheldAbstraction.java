package dji.sdksharedlib.hardware.abstractions.camera.zenmuse;

import dji.common.camera.ResolutionAndFrameRate;
import dji.common.error.DJIError;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;

public class DJICameraX5RHandheldAbstraction
  extends DJICameraX5BaseAbstraction
{
  private static String TAG = "X5RHandHeldCamera";
  
  private boolean isResolutionAndFrameRateValid(ResolutionAndFrameRate paramResolutionAndFrameRate)
  {
    return false;
  }
  
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
    return "Zenmuse X5R";
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
    return true;
  }
  
  protected boolean isSSDSupported()
  {
    return true;
  }
  
  /* Error */
  public void setVideoResolutionAndFrameRate(ResolutionAndFrameRate arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\zenmuse\DJICameraX5RHandheldAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */