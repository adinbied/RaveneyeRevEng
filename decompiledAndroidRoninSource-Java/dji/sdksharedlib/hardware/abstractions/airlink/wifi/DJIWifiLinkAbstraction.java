package dji.sdksharedlib.hardware.abstractions.airlink.wifi;

import dji.common.airlink.WiFiFrequencyBand;
import dji.sdksharedlib.hardware.abstractions.Action;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.DJISubComponentHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.Getter;
import dji.sdksharedlib.hardware.abstractions.Setter;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import org.greenrobot.eventbus.EventBus;

public abstract class DJIWifiLinkAbstraction
  extends DJISubComponentHWAbstraction
{
  private static final String TAG = "DJISDKCacheWifiLinkSeriesAbstraction";
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Getter("FrequencyBand")
  public abstract void getFrequencyBand(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("Password")
  public abstract void getPassword(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("SSID")
  public abstract void getSSID(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  public void init(String paramString1, int paramInt1, String paramString2, int paramInt2, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString1, paramInt1, paramString2, paramInt2, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
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
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataOsdGetPushSignalQuality arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataWifiGetPushElecSignal arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataWifiGetPushSignal arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Action("Reboot")
  public abstract void reboot(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("FrequencyBand")
  public abstract void setFrequencyBand(WiFiFrequencyBand paramWiFiFrequencyBand, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("Password")
  public abstract void setPassword(String paramString, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("SSID")
  public abstract void setSSID(String paramString, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  /* Error */
  public void syncPushDataFromMidware()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\airlink\wifi\DJIWifiLinkAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */