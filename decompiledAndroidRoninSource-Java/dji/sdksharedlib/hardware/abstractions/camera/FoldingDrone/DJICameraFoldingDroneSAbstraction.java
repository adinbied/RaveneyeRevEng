package dji.sdksharedlib.hardware.abstractions.camera.FoldingDrone;

import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.camera.DJICameraBaseAbstraction;

public class DJICameraFoldingDroneSAbstraction
  extends DJICameraBaseAbstraction
{
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("Orientation")
  public void getOrientation(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isDigitalZoomScaleSupported()
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
  
  protected boolean isVideoPlaybackSupported()
  {
    return true;
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("Orientation")
  public void setOrientation(dji.common.camera.SettingsDefinitions.Orientation arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\FoldingDrone\DJICameraFoldingDroneSAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */