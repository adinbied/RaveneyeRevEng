package dji.sdksharedlib.hardware.abstractions.flightcontroller;

import dji.common.util.CallbackUtils;
import dji.midware.data.model.P3.DataFlycGetPushParamsByHash;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class FlightControllerPhantom3Abstraction
  extends FlightControllerAbstraction
{
  private boolean hasStartedCalibration = false;
  
  protected boolean isNewProgressOfActivation()
  {
    return false;
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataFlycGetPushParamsByHash paramDataFlycGetPushParamsByHash)
  {
    updateIMUState(paramDataFlycGetPushParamsByHash);
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
  protected void updateIMUState(DataFlycGetPushParamsByHash arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\flightcontroller\FlightControllerPhantom3Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */