package dji.sdksharedlib.hardware.abstractions.battery;

import dji.common.error.DJIBatteryError;
import dji.midware.data.config.P3.Ccode;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.Setter;

public class BatteryHandheldAbstraction
  extends BatteryAbstraction
{
  public BatteryHandheldAbstraction()
  {
    this.isSmartBattery = false;
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("LatestWarningRecord")
  public void getLatestWarningRecord(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
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
  protected void getSerialNumber(DJISDKCacheHWAbstraction.InnerCallback arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("FirmwareVersion")
  public void getVersion(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isWarningInformationRecordsSupported()
  {
    return false;
  }
  
  @Setter("SelfDischargeInDays")
  public void setSelfDischargeInDays(Integer paramInteger, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIBatteryError.getDJIError(Ccode.NOT_SUPPORT_CURRENT_STATE));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\battery\BatteryHandheldAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */