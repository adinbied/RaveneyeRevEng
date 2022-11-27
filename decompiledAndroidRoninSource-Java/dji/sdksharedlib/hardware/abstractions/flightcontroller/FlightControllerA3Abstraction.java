package dji.sdksharedlib.hardware.abstractions.flightcontroller;

import dji.common.error.DJIError;
import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataFlycGetPushParamsByHash;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;

public class FlightControllerA3Abstraction
  extends FlightControllerAbstraction
{
  private final String[] IMU_CALC_STAT_CONFIG = { "g_status.acc_gyro[0].state_0", "g_status.acc_gyro[1].state_0", "g_status.acc_gyro[2].state_0", "g_status.acc_gyro[0].cali_cnt_0", "g_status.acc_gyro[1].cali_cnt_0", "g_status.acc_gyro[2].cali_cnt_0", "g_status.acc_gyro[0].temp_ready_0", "g_status.acc_gyro[1].temp_ready_0", "g_status.acc_gyro[2].temp_ready_0" };
  
  private DJIError getRtkErrorFromErrorCode(int paramInt)
  {
    return null;
  }
  
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
  
  protected boolean isNewProgressOfActivation()
  {
    return true;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataRTKPushStatus arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("StartIMUCalibrationWithID")
  public void startImuCalibrationWithID(DJISDKCacheHWAbstraction.InnerCallback arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void updateIMUState(DataFlycGetPushParamsByHash arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\flightcontroller\FlightControllerA3Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */