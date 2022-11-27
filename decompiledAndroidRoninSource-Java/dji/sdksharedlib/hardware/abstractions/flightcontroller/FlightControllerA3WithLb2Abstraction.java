package dji.sdksharedlib.hardware.abstractions.flightcontroller;

import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;

public class FlightControllerA3WithLb2Abstraction
  extends FlightControllerA3Abstraction
{
  private static final String PARAM_NAME_FMODE_CONFIG = "g_config.control.control_mode[0]_0";
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("ControlMode")
  public void getControlMode(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ControlMode")
  public void setControlMode(dji.common.flightcontroller.ControlMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\flightcontroller\FlightControllerA3WithLb2Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */