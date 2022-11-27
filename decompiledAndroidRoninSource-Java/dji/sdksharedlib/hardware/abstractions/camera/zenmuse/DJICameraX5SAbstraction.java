package dji.sdksharedlib.hardware.abstractions.camera.zenmuse;

import dji.common.camera.ResolutionAndFrameRate;
import dji.common.camera.SettingsDefinitions.VideoResolution;
import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataCameraGetPushRawParams;
import dji.midware.data.model.P3.DataCameraGetPushRawParams.RawMode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import java.util.ArrayList;

public class DJICameraX5SAbstraction
  extends DJICameraInspire2Abstraction
{
  private static final String TAG = "X5SCamera";
  
  private ResolutionAndFrameRate getSDCardResolutionAndFrameRate()
  {
    return null;
  }
  
  private boolean isSSDInserted()
  {
    return false;
  }
  
  private boolean isSSDRAWRecordingEnabled()
  {
    return false;
  }
  
  private ArrayList<SettingsDefinitions.VideoResolution> rangeWithCameraType(DataCameraGetPushRawParams.RawMode paramRawMode, int paramInt)
  {
    return null;
  }
  
  /* Error */
  private void setSSDRawResolutionAndFrameRateProtocol(int arg1, int arg2, int arg3, int arg4, int arg5, DJISDKCacheHWAbstraction.InnerCallback arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore 6
    //   3: goto -3 -> 0
  }
  
  protected String getDisplayName()
  {
    return "Zenmuse X5S";
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    onEvent3BackgroundThread(DataCameraGetPushRawParams.getInstance());
  }
  
  protected boolean isAFSupported()
  {
    return true;
  }
  
  protected boolean isMFSupported()
  {
    return true;
  }
  
  protected boolean isSSDSupported()
  {
    return true;
  }
  
  protected boolean isShootPhotoRawBurstSupported()
  {
    return true;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraGetPushRawParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ActivateSSDVideoLicense")
  public void setSSDRAWLicense(dji.common.camera.CameraSSDVideoLicense arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("SSDVideoRecordingEnabled")
  public void setSSDRAWRecordingEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("SSDVideoResolutionAndFrameRate")
  public void setSSDRawVideoResolutionAndFrameRate(ResolutionAndFrameRate arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\zenmuse\DJICameraX5SAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */