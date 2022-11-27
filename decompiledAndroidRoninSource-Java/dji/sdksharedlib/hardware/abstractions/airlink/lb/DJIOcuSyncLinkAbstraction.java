package dji.sdksharedlib.hardware.abstractions.airlink.lb;

import dji.common.airlink.ChannelSelectionMode;
import dji.common.airlink.OcuSyncBandwidth;
import dji.common.airlink.OcuSyncWarningMessage;
import dji.common.error.DJIError;
import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.DJISDKCache;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.DJISubComponentHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.airlink.lb.merge.MergeGetOcuSyncInfo;
import dji.sdksharedlib.hardware.abstractions.airlink.lb.subscription.OcuSyncRSSISubscription;
import dji.sdksharedlib.hardware.extension.DJISDKCacheCommonMergeCallback;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey.Builder;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.operators.OperatorWhileDoWhile;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;

public class DJIOcuSyncLinkAbstraction
  extends DJISubComponentHWAbstraction
  implements DJIParamAccessListener
{
  private static final float RSSI_FREQUENCY_INTERVAL = 2.0F;
  private static final float RSSI_FREQUENCY_OFFSET = 2400.0F;
  private static final long WARNING_MESSAGE_EXPIRATION_TIME = 21000L;
  protected DJISDKCacheKey.Builder builder;
  protected Map<OcuSyncWarningMessage, Long> currentWarningMessage = new ConcurrentHashMap();
  protected boolean isTimerRunning = false;
  private MergeGetOcuSyncInfo mergeGetOcuSyncInfo;
  private OcuSyncRSSISubscription ocuSyncRssiSubscription;
  private RSSIEventHandler rssiEventHandler;
  private Observable<Boolean> warningMessageTimer = Observable.create(new OperatorWhileDoWhile(Observable.just(Boolean.valueOf(true)).delay(1L, TimeUnit.SECONDS).map(new Func1()
  {
    public Boolean call(Boolean paramAnonymousBoolean)
    {
      DJIOcuSyncLinkAbstraction.this.pruneWarningMessageMapAndCheckIfShouldNotify();
      return Boolean.valueOf(true);
    }
  }), new Func0()new Func0
  {
    public Boolean call()
    {
      return null;
    }
  }, new Func0()
  {
    public Boolean call()
    {
      return null;
    }
  }));
  
  private Float[] calculateFrequencyIndexValidRangeWithBandwidth(OcuSyncBandwidth paramOcuSyncBandwidth, ChannelSelectionMode paramChannelSelectionMode)
  {
    return null;
  }
  
  private OcuSyncBandwidth getBandwidth()
  {
    return null;
  }
  
  private ChannelSelectionMode getChannelSelectionMode()
  {
    return null;
  }
  
  private Float[] getFrequencyPointIndexValidRange()
  {
    return null;
  }
  
  /* Error */
  private void getSDRFrequencyPointIndexValidRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isExpired(long paramLong1, long paramLong2)
  {
    return false;
  }
  
  private boolean pruneWarningMessageMapAndCheckIfShouldNotify()
  {
    return false;
  }
  
  /* Error */
  protected void checkAndStartTimer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  @dji.sdksharedlib.hardware.abstractions.Getter("Bandwidth")
  public void getBandwidth(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("ChannelSelectionMode")
  public void getChannelSelectionMode(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected OcuSyncWarningMessage[] getCurrentMessages()
  {
    return null;
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("FrequencyPointIndex")
  public void getFrequencyPointIndex(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("FrequencyPointIndexValidRange")
  public void getFrequencyPointIndexValidRange(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("FrequencyPointRSSIs")
  public void getFrequencyPointRSSI(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("TransmissionMode")
  public void getTransmissionMode(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init(String paramString1, int paramInt1, String paramString2, int paramInt2, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString1, paramInt1, paramString2, paramInt2, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
    paramString1 = new DJISDKCacheKey.Builder();
    this.builder = paramString1;
    paramString1.component("AirLink").index(paramInt1).subComponent("OcuSyncLink").subComponentIndex(paramInt2);
    this.ocuSyncRssiSubscription = new OcuSyncRSSISubscription();
    this.mergeGetOcuSyncInfo = new MergeGetOcuSyncInfo();
    DJISDKCache.getInstance().startListeningForUpdates(this.builder.paramKey("ChannelSelectionMode").build(), this, false);
    DJISDKCache.getInstance().startListeningForUpdates(this.builder.paramKey("Bandwidth").build(), this, false);
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isSecondaryVideoOutputSupported()
  {
    return false;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataOsdGetPushSDRNfParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataOsdGetPushSdrConfigInfo arg1)
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
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataOsdGetPushWirelessState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataOsdGetSDRPushCustomCodeRate arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onValueChange(DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue paramDJISDKCacheParamValue1, DJISDKCacheParamValue paramDJISDKCacheParamValue2)
  {
    getFrequencyPointIndexValidRange();
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("Bandwidth")
  public void setBandwidth(OcuSyncBandwidth arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ChannelSelectionMode")
  public void setChannelSelectionMode(ChannelSelectionMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("FrequencyPointIndex")
  public void setFrequencyPointIndex(Integer arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("TransmissionMode")
  public void setTransmissionMode(dji.common.airlink.LightbridgeTransmissionMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean updateWarningMessageAndCheckIfShouldNotify(OcuSyncWarningMessage paramOcuSyncWarningMessage)
  {
    return false;
  }
  
  public class RSSIEventHandler
  {
    public RSSIEventHandler() {}
    
    /* Error */
    @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
    public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataOsdGetPushSdrSweepFrequency arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\airlink\lb\DJIOcuSyncLinkAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */