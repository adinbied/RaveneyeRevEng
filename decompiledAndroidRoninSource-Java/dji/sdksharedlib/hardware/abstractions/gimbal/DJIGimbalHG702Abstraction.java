package dji.sdksharedlib.hardware.abstractions.gimbal;

import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;

public class DJIGimbalHG702Abstraction
  extends DJIGimbalRonin2Abstraction
{
  private static final String TAG = DJIGimbalHG702Abstraction.class.getSimpleName();
  
  /* Error */
  public void initGimbalCapability()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataCommonGetPushUpgradeStatus arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataGimbalFocusControl arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataGimbalGetPushCalibrationStatus arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataGimbalGetPushCheckStatus arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("StartAutoTune")
  public void startAutoTune(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void syncPushDataFromMidware()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\gimbal\DJIGimbalHG702Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */