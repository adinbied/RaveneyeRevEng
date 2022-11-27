package dji.sdksharedlib.hardware.abstractions.camera.phantom;

import dji.common.camera.SettingsDefinitions.CameraMode;
import dji.sdksharedlib.hardware.abstractions.camera.DJICameraBaseAbstraction;

public class DJICameraPhantom4PAbstraction
  extends DJICameraBaseAbstraction
{
  protected String getDisplayName()
  {
    return "Phantom 4 Professional Camera";
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
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
  
  protected boolean isAdjustableFocalPointSupported()
  {
    return true;
  }
  
  protected boolean isHDRPhotoSupported()
  {
    return false;
  }
  
  protected boolean isMediaDownModeMapValue2()
  {
    return true;
  }
  
  protected boolean isMediaDownloadModeSupported()
  {
    return true;
  }
  
  protected boolean isNewProcessOfActivation()
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
  
  protected boolean isVideoPlaybackSupported()
  {
    return true;
  }
  
  protected int mapMediaDownloadModeToProtocolValue(SettingsDefinitions.CameraMode paramCameraMode)
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\phantom\DJICameraPhantom4PAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */