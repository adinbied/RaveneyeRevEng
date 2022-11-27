package dji.internal.mock.abstractions;

import dji.common.airlink.WifiDataRate;
import dji.common.error.DJIAirLinkError;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.Getter;
import dji.sdksharedlib.hardware.abstractions.Setter;
import dji.sdksharedlib.hardware.abstractions.airlink.wifi.DJIWifiLinkFoldingDroneAbstraction;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.functions.Func1;

public class MockWifiLinkFoldingDroneAbstraction
  extends DJIWifiLinkFoldingDroneAbstraction
{
  private int channel;
  private WifiDataRate dataRate;
  private boolean goingUp = true;
  private int signalQuality = 0;
  
  public MockWifiLinkFoldingDroneAbstraction()
  {
    generateFakeData();
  }
  
  /* Error */
  private void generateFakeData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("ChannelNumber")
  public void getChannel(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Getter("DataRate")
  public void getDataRate(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onSuccess(this.dataRate);
    }
  }
  
  @Setter("ChannelNumber")
  public void setChannel(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInt > 0)
    {
      this.channel = paramInt;
      if (paramInnerCallback != null) {
        paramInnerCallback.onSuccess(null);
      }
    }
    else if (paramInnerCallback != null)
    {
      paramInnerCallback.onFails(DJIAirLinkError.COMMON_PARAM_ILLEGAL);
    }
  }
  
  /* Error */
  @Setter("DataRate")
  public void setDataRate(WifiDataRate arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\abstractions\MockWifiLinkFoldingDroneAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */