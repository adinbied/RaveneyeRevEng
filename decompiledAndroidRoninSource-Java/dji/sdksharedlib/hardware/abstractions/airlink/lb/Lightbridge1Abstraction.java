package dji.sdksharedlib.hardware.abstractions.airlink.lb;

import dji.common.LightbridgePIPPosition;
import dji.common.LightbridgeSecondaryVideoFormat;
import dji.common.VideoDataChannel;
import dji.common.airlink.LightbridgeSecondaryVideoDisplayMode;
import dji.common.airlink.LightbridgeSecondaryVideoOutputPort;
import dji.common.airlink.LightbridgeTransmissionMode;
import dji.common.airlink.LightbridgeUnit;
import dji.common.error.DJIAirLinkError;
import dji.common.error.DJIError;
import dji.common.util.CallbackUtils;
import dji.midware.data.model.P3.DataDm368GetGParams;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;

public class Lightbridge1Abstraction
  extends LightbridgeAbstraction
{
  private static final int CHANNEL_OFFSET_2Dot4G = 12;
  private static final String TAG = "DJISDKCacheLightBridge1AirLinkAbstraction";
  
  public void getBandwidthAllocationForHDMIVideoInputPort(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  /* Error */
  public void getChannel(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("ChannelRange")
  public void getChannelRange(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getChannelSelectionMode(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getDataRate(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getDisplayOSDEnabled(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void getEXTVideoInputPortEnabled(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void getFPVVideoBandwidthPercent(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void getHDMIOutputFormat(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void getOSDBottomMargin(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void getOSDLeftMargin(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void getOSDRightMargin(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void getOSDTopMargin(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void getOSDUnit(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void getPIPDisplay(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void getPIPPosition(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void getSDIOutputFormat(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  /* Error */
  public void getSecondaryVideoOutputEnabled(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void getSecondaryVideoOutputPort(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("SupportedFrequencyBands")
  public void getSupportedFrequencyBands(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void getTransmissionMode(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void getVideoDataChannel(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("WorkingFrequency")
  public void getWorkingFrequency(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init(String paramString1, int paramInt1, String paramString2, int paramInt2, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString1, paramInt1, paramString2, paramInt2, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
  }
  
  public boolean isSecondaryVideoOutputSupported()
  {
    return false;
  }
  
  public void setBandwidthAllocationForHDMIVideoInputPort(float paramFloat, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  /* Error */
  public void setChannel(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setChannelSelectionMode(dji.common.airlink.ChannelSelectionMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setDataRate(dji.common.airlink.LightbridgeDataRate arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setDisplayOSDEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setEXTVideoInputPortEnabled(boolean paramBoolean, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void setFPVVideoBandwidthPercent(float paramFloat, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void setHDMIOutputFormat(LightbridgeSecondaryVideoFormat paramLightbridgeSecondaryVideoFormat, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void setMainCameraBandwidthPercent(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    CallbackUtils.onFailure(paramInnerCallback, DJIAirLinkError.COMMON_UNSUPPORTED);
  }
  
  public void setOSDBottomMargin(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void setOSDLeftMargin(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void setOSDRightMargin(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void setOSDTopMargin(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void setOSDUnit(LightbridgeUnit paramLightbridgeUnit, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void setPIPDisplay(LightbridgeSecondaryVideoDisplayMode paramLightbridgeSecondaryVideoDisplayMode, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void setPIPPosition(LightbridgePIPPosition paramLightbridgePIPPosition, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void setSDIOutputFormat(LightbridgeSecondaryVideoFormat paramLightbridgeSecondaryVideoFormat, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  /* Error */
  public void setSecondaryVideoOutputEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setSecondaryVideoOutputPort(LightbridgeSecondaryVideoOutputPort paramLightbridgeSecondaryVideoOutputPort, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void setTransmissionMode(LightbridgeTransmissionMode paramLightbridgeTransmissionMode, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void setVideoDataChannel(VideoDataChannel paramVideoDataChannel, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("WorkingFrequency")
  public void setWorkingFrequency(dji.common.airlink.WorkingFrequency arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\airlink\lb\Lightbridge1Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */