package dji.sdksharedlib.hardware.abstractions.airlink.wifi;

import dji.common.error.DJIError;
import dji.midware.data.model.P3.DataWifiGetWifiCurCodeRate;
import dji.midware.data.model.P3.DataWifiGetWifiFreqMode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.airlink.lb.subscription.WifiFoldingDroneRSSISubscription;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.store.DJISDKCacheParamValue;

public class DJIWifiLinkFoldingDroneAbstraction
  extends DJIWifiLinkGroundAbstraction
{
  private RSSIEventHandler rssiEventHandler;
  private WifiFoldingDroneRSSISubscription subscription;
  
  private Integer[] concat(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return null;
  }
  
  private Integer[] getAvailableChannelNumbers()
  {
    return null;
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("AvailableChannelNumbers")
  public void getAvailableChannelNumbers(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("ChannelNumber")
  public void getChannel(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("DataRate")
  public void getDataRate(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getFrequencyBand(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("ChannelInterference")
  public void getFrequencyPointRSSI(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void init(String arg1, int arg2, String arg3, int arg4, dji.sdksharedlib.store.DJISDKCacheStoreLayer arg5, dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener arg6)
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
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataWifiGetPushSignal arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ChannelNumber")
  public void setChannel(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("DataRate")
  public void setDataRate(dji.common.airlink.WifiDataRate arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setFrequencyBand(dji.common.airlink.WiFiFrequencyBand arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
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
  
  public class RSSIEventHandler
  {
    public RSSIEventHandler() {}
    
    /* Error */
    @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
    public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataWifiGetPushSweepFrequency arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\airlink\wifi\DJIWifiLinkFoldingDroneAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */