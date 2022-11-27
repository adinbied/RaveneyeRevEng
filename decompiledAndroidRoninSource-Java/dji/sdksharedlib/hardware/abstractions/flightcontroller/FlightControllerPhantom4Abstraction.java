package dji.sdksharedlib.hardware.abstractions.flightcontroller;

import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;

public class FlightControllerPhantom4Abstraction
  extends FlightControllerAbstraction
{
  private final String[] IMU_CALC_STAT_CONFIG = { "g_status.acc_gyro[0].state_0", "g_status.acc_gyro[1].state_0", "g_status.acc_gyro[0].cali_cnt_0", "g_status.acc_gyro[1].cali_cnt_0" };
  
  /* Error */
  protected void initFlightControllerSupportParameter()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void initializeComponentCharacteristics()
  {
    super.initializeComponentCharacteristics();
  }
  
  /* Error */
  protected void initializeSubComponents(dji.sdksharedlib.store.DJISDKCacheStoreLayer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isNewProgressOfActivation()
  {
    return true;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataFlycGetPushAvoidParam arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("StartIMUCalibration")
  public void startImuCalibration(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void updateIMUState(dji.midware.data.model.P3.DataFlycGetPushParamsByHash arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\flightcontroller\FlightControllerPhantom4Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */