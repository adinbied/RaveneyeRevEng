package dji.sdksharedlib.hardware.abstractions.airlink.lb;

import dji.common.LightbridgePIPPosition;
import dji.common.LightbridgeSecondaryVideoFormat;
import dji.common.VideoDataChannel;
import dji.common.airlink.ChannelSelectionMode;
import dji.common.airlink.LightbridgeDataRate;
import dji.common.airlink.LightbridgeFrequencyBand;
import dji.common.airlink.LightbridgeSecondaryVideoDisplayMode;
import dji.common.airlink.LightbridgeSecondaryVideoOutputPort;
import dji.common.airlink.LightbridgeTransmissionMode;
import dji.common.airlink.LightbridgeUnit;
import dji.common.airlink.WorkingFrequency;
import dji.midware.component.DJIComponentManager.PlatformType;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.extension.CacheHelper;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.DJISubComponentHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.Getter;
import dji.sdksharedlib.hardware.abstractions.Setter;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey.Builder;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import org.greenrobot.eventbus.EventBus;

public abstract class LightbridgeAbstraction
  extends DJISubComponentHWAbstraction
  implements DJIParamAccessListener
{
  private static final int CHANNEL_OFFSET_2_DOT_4_G = 12;
  private static final int SUPPORTED_CHANNEL_COUNT_2_DOT_4_G = 8;
  private static final int SUPPORTED_CHANNEL_COUNT_5_DOT_8_G = 29;
  private static final String TAG = "DJISDKCacheLightBridgeSeriesAirLinkAbstraction";
  protected LightbridgeFrequencyBand currentFrequencyBand = null;
  protected Integer[] currentRange = null;
  protected ChannelSelectionMode mode = null;
  protected LightbridgeFrequencyBand[] supportBand = { LightbridgeFrequencyBand.UNKNOWN };
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Getter("BandwidthAllocationForHDMIVideoInputPort")
  public abstract void getBandwidthAllocationForHDMIVideoInputPort(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("Channel")
  public abstract void getChannel(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("ChannelRange")
  public abstract void getChannelRange(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("ChannelSelectionMode")
  public abstract void getChannelSelectionMode(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("DataRate")
  public abstract void getDataRate(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("SecondaryVideoOSDEnabled")
  public abstract void getDisplayOSDEnabled(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("isEXTVideoInputPortEnabled")
  public abstract void getEXTVideoInputPortEnabled(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("BandwidthAllocationForLBVideoInputPort")
  public abstract void getFPVVideoBandwidthPercent(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("HDMIOutputFormat")
  public abstract void getHDMIOutputFormat(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("SecondaryVideoOSDBottomMargin")
  public abstract void getOSDBottomMargin(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("SecondaryVideoOSDLeftMargin")
  public abstract void getOSDLeftMargin(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("SecondaryVideoOSDRightMargin")
  public abstract void getOSDRightMargin(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("SecondaryVideoOSDTopMargin")
  public abstract void getOSDTopMargin(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("SecondaryVideoOSDUnits")
  public abstract void getOSDUnit(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("SecondaryVideoDisplayMode")
  public abstract void getPIPDisplay(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("PIPPosition")
  public abstract void getPIPPosition(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("SDIOutputFormat")
  public abstract void getSDIOutputFormat(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("SecondaryVideoOutputEnabled")
  public abstract void getSecondaryVideoOutputEnabled(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("SecondaryVideoOutputPort")
  public abstract void getSecondaryVideoOutputPort(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("SupportedFrequencyBands")
  public abstract void getSupportedFrequencyBands(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("TransmissionMode")
  public abstract void getTransmissionMode(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("VideoDataChannel")
  public abstract void getVideoDataChannel(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Getter("WorkingFrequency")
  public abstract void getWorkingFrequency(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  public void init(String paramString1, int paramInt1, String paramString2, int paramInt2, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString1, paramInt1, paramString2, paramInt2, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
    new DJISDKCacheKey.Builder().component("AirLink").index(0).subComponent("LightbridgeLink").subComponentIndex(0);
    CacheHelper.addLightbridgeLinkListener(this, new String[] { "ChannelSelectionMode" });
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isDualEncodeModeSupported()
  {
    return false;
  }
  
  public abstract boolean isSecondaryVideoOutputSupported();
  
  protected boolean isUsingLightBridge2(DJIComponentManager.PlatformType paramPlatformType)
  {
    return false;
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
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataOsdGetPushSweepFrequency arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataRcGetPushParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onValueChange(DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue paramDJISDKCacheParamValue1, DJISDKCacheParamValue paramDJISDKCacheParamValue2)
  {
    if ((paramDJISDKCacheParamValue2 != null) && (paramDJISDKCacheParamValue2.getData() != null)) {
      this.mode = ((ChannelSelectionMode)CacheHelper.getLightbridgeLink("ChannelSelectionMode"));
    }
  }
  
  @Setter("BandwidthAllocationForHDMIVideoInputPort")
  public abstract void setBandwidthAllocationForHDMIVideoInputPort(float paramFloat, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("Channel")
  public abstract void setChannel(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("ChannelSelectionMode")
  public abstract void setChannelSelectionMode(ChannelSelectionMode paramChannelSelectionMode, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("DataRate")
  public abstract void setDataRate(LightbridgeDataRate paramLightbridgeDataRate, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("SecondaryVideoOSDEnabled")
  public abstract void setDisplayOSDEnabled(boolean paramBoolean, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("isEXTVideoInputPortEnabled")
  public abstract void setEXTVideoInputPortEnabled(boolean paramBoolean, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("BandwidthAllocationForLBVideoInputPort")
  public abstract void setFPVVideoBandwidthPercent(float paramFloat, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("HDMIOutputFormat")
  public abstract void setHDMIOutputFormat(LightbridgeSecondaryVideoFormat paramLightbridgeSecondaryVideoFormat, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("MainVideoBandwidthPercent")
  public abstract void setMainCameraBandwidthPercent(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("SecondaryVideoOSDBottomMargin")
  public abstract void setOSDBottomMargin(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("SecondaryVideoOSDLeftMargin")
  public abstract void setOSDLeftMargin(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("SecondaryVideoOSDRightMargin")
  public abstract void setOSDRightMargin(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("SecondaryVideoOSDTopMargin")
  public abstract void setOSDTopMargin(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("SecondaryVideoOSDUnits")
  public abstract void setOSDUnit(LightbridgeUnit paramLightbridgeUnit, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("SecondaryVideoDisplayMode")
  public abstract void setPIPDisplay(LightbridgeSecondaryVideoDisplayMode paramLightbridgeSecondaryVideoDisplayMode, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("PIPPosition")
  public abstract void setPIPPosition(LightbridgePIPPosition paramLightbridgePIPPosition, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("SDIOutputFormat")
  public abstract void setSDIOutputFormat(LightbridgeSecondaryVideoFormat paramLightbridgeSecondaryVideoFormat, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("SecondaryVideoOutputEnabled")
  public abstract void setSecondaryVideoOutputEnabled(boolean paramBoolean, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("SecondaryVideoOutputPort")
  public abstract void setSecondaryVideoOutputPort(LightbridgeSecondaryVideoOutputPort paramLightbridgeSecondaryVideoOutputPort, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("TransmissionMode")
  public abstract void setTransmissionMode(LightbridgeTransmissionMode paramLightbridgeTransmissionMode, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("VideoDataChannel")
  public abstract void setVideoDataChannel(VideoDataChannel paramVideoDataChannel, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  @Setter("WorkingFrequency")
  public abstract void setWorkingFrequency(WorkingFrequency paramWorkingFrequency, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback);
  
  /* Error */
  protected void setter(dji.midware.data.model.P3.DataDm368SetGParams.CmdId arg1, int arg2, DJISDKCacheHWAbstraction.InnerCallback arg3)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\airlink\lb\LightbridgeAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */