package dji.sdksharedlib.hardware.abstractions.battery;

import dji.midware.data.model.P3.DataCenterGetSelfDischarge;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;

public class BatteryPhantom3Abstraction
  extends BatteryAbstraction
{
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("SelfDischargeInDays")
  public void getSelfDischargeInDays(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("SelfDischargeInDays")
  public void setSelfDischargeInDays(Integer arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\battery\BatteryPhantom3Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */