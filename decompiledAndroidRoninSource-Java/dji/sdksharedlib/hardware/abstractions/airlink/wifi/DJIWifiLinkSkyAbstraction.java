package dji.sdksharedlib.hardware.abstractions.airlink.wifi;

import dji.common.airlink.WiFiFrequencyBand;
import dji.common.error.DJIError;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;

public class DJIWifiLinkSkyAbstraction
  extends DJIWifiLinkAbstraction
{
  public void getFrequencyBand(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  /* Error */
  public void getPassword(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getSSID(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void reboot(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setFrequencyBand(WiFiFrequencyBand paramWiFiFrequencyBand, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  /* Error */
  public void setPassword(String arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setSSID(String arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\airlink\wifi\DJIWifiLinkSkyAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */