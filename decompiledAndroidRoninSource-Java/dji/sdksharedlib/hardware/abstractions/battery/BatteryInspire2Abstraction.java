package dji.sdksharedlib.hardware.abstractions.battery;

import dji.common.error.DJIBatteryError;
import dji.common.error.DJIError;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataSmartBatteryGetBarCode;
import dji.midware.data.model.P3.DataSmartBatteryGetPair;
import dji.midware.util.MultipleDataBase.Callback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;

public class BatteryInspire2Abstraction
  extends BatteryM600Abstraction
{
  public final String TAG = "DJISDKCacheInspire2BatteryAbstraction";
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("PairingState")
  public void getPairingState(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("PairBatteries")
  public void pairBatteries(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\battery\BatteryInspire2Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */