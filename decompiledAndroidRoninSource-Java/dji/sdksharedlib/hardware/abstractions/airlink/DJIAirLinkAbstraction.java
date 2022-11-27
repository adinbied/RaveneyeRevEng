package dji.sdksharedlib.hardware.abstractions.airlink;

import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.DJISubComponentHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.airlink.lb.DJIOcuSyncLinkAbstraction;
import dji.sdksharedlib.hardware.abstractions.airlink.lb.LightbridgeAbstraction;
import dji.sdksharedlib.hardware.abstractions.airlink.wifi.DJIWifiLinkAbstraction;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;

public class DJIAirLinkAbstraction
  extends DJISDKCacheHWAbstraction
{
  private static final String TAG = "DJISDKCacheAirLinkAbstraction";
  private LightbridgeAbstraction lightbridgeLink;
  private DJIOcuSyncLinkAbstraction ocuSyncLinkAbstraction;
  private DJIWifiLinkAbstraction wifiLink;
  
  public DJIAirLinkAbstraction(DJIWifiLinkAbstraction paramDJIWifiLinkAbstraction, DJISubComponentHWAbstraction paramDJISubComponentHWAbstraction)
  {
    this.wifiLink = paramDJIWifiLinkAbstraction;
    if (paramDJISubComponentHWAbstraction != null)
    {
      if ((paramDJISubComponentHWAbstraction instanceof LightbridgeAbstraction))
      {
        this.lightbridgeLink = ((LightbridgeAbstraction)paramDJISubComponentHWAbstraction);
        return;
      }
      if ((paramDJISubComponentHWAbstraction instanceof DJIOcuSyncLinkAbstraction))
      {
        this.ocuSyncLinkAbstraction = ((DJIOcuSyncLinkAbstraction)paramDJISubComponentHWAbstraction);
        return;
      }
      throw new RuntimeException("Wrong Abstraction Class");
    }
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
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
  protected void initializeSubComponents(DJISDKCacheStoreLayer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("IsLightbridgeLinkSupported")
  public void isLightbridgeLinkSupported(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("IsWiFiLinkSupported")
  public void isWiFiLinkSupported(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("CountryCode")
  public void setCountryCode(String arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\airlink\DJIAirLinkAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */