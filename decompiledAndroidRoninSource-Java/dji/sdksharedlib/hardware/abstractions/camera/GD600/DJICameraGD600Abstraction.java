package dji.sdksharedlib.hardware.abstractions.camera.GD600;

import dji.common.camera.CameraUtils;
import dji.common.camera.SettingsDefinitions.Aperture;
import dji.common.camera.SettingsDefinitions.CameraMode;
import dji.common.camera.SettingsDefinitions.PhotoAspectRatio;
import dji.common.camera.SettingsDefinitions.PhotoFileFormat;
import dji.common.camera.SettingsDefinitions.ShootPhotoMode;
import dji.common.camera.SettingsDefinitions.WhiteBalancePreset;
import dji.common.error.DJICameraError;
import dji.common.error.DJIError;
import dji.common.util.CallbackUtils;
import dji.common.util.DJILensFeatureUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.extension.CacheHelper;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.camera.zenmuse.DJICameraZ3Abstraction;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import org.greenrobot.eventbus.EventBus;

public class DJICameraGD600Abstraction
  extends DJICameraZ3Abstraction
  implements DJIParamAccessListener
{
  private boolean currentTapZoomEnabled = false;
  
  protected boolean checkApertureValid(SettingsDefinitions.Aperture paramAperture)
  {
    return true;
  }
  
  protected boolean checkPhotoShootMode(SettingsDefinitions.ShootPhotoMode paramShootPhotoMode)
  {
    return false;
  }
  
  protected boolean checkWhiteBaLanceValid(SettingsDefinitions.WhiteBalancePreset paramWhiteBalancePreset, int paramInt)
  {
    return false;
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("OneKeyZoom")
  public void doOneKeyZoom(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("DefogEnabled")
  public void getDefogEnabled(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected String getDisplayName()
  {
    return "Zenmuse Z30";
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("OpticalZoomScale")
  public void getOpticalZoomScale(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("TapZoomEnabled")
  public void getTapZoomEnabled(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("TapZoomMultiplier")
  public void getTapZoomMultiplier(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    this.apertureMap = CameraUtils.buildApertureMap();
    this.lensFeatureUtils = new DJILensFeatureUtils();
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
    CacheHelper.addCameraListener(this, paramInt, new String[] { "TapZoomEnabled" });
  }
  
  protected boolean isAFSupported()
  {
    return true;
  }
  
  protected boolean isAFTargetSupported()
  {
    return true;
  }
  
  protected boolean isAdjustableApertureSupported()
  {
    return true;
  }
  
  protected boolean isDigitalZoomScaleSupported()
  {
    return true;
  }
  
  protected boolean isMFSupported()
  {
    return true;
  }
  
  protected boolean isMediaDownModeMapValue2()
  {
    return true;
  }
  
  protected boolean isMediaDownloadModeSupported()
  {
    return true;
  }
  
  protected boolean isOpticalZoomScaleSupported()
  {
    return true;
  }
  
  protected boolean isOpticalZoomSupported()
  {
    return true;
  }
  
  protected boolean isPlaybackSupported()
  {
    return false;
  }
  
  protected boolean isTapZoomSupported()
  {
    return true;
  }
  
  protected boolean isVideoPlaybackSupported()
  {
    return true;
  }
  
  protected int mapMediaDownloadModeToProtocolValue(SettingsDefinitions.CameraMode paramCameraMode)
  {
    return 0;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataCameraGetPushShotParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataCameraGetPushTapZoomStateInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onValueChange(DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue paramDJISDKCacheParamValue1, DJISDKCacheParamValue paramDJISDKCacheParamValue2)
  {
    if (!CacheHelper.isDataValid(paramDJISDKCacheKey, paramDJISDKCacheParamValue2)) {
      return;
    }
    if ((paramDJISDKCacheParamValue2 != null) && (paramDJISDKCacheParamValue2.getData() != null) && (paramDJISDKCacheKey.getParamKey().equals("TapZoomEnabled"))) {
      this.currentTapZoomEnabled = ((Boolean)paramDJISDKCacheParamValue2.getData()).booleanValue();
    }
  }
  
  /* Error */
  public void setAntiFlicker(dji.common.camera.SettingsDefinitions.AntiFlickerFrequency arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("Mode")
  public void setCameraMode(SettingsDefinitions.CameraMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setContrast(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    CallbackUtils.onFailure(paramInnerCallback, DJICameraError.COMMON_UNSUPPORTED);
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("DefogEnabled")
  public void setDefogEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setDigitalFilter(dji.common.camera.SettingsDefinitions.DigitalFilter arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setHue(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  /* Error */
  public void setPhotoBurstCount(dji.common.camera.SettingsDefinitions.PhotoBurstCount arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setPhotoFileFormat(SettingsDefinitions.PhotoFileFormat paramPhotoFileFormat, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  /* Error */
  public void setPhotoIntervalParam(dji.common.camera.SettingsDefinitions.PhotoTimeIntervalSettings arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setPhotoRatio(SettingsDefinitions.PhotoAspectRatio paramPhotoAspectRatio, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void setSaturation(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void setSharpness(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    CallbackUtils.onFailure(paramInnerCallback, DJICameraError.COMMON_UNSUPPORTED);
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("TapZoomEnabled")
  public void setTapZoomEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("TapZoomMultiplier")
  public void setTapZoomMultiplier(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("TapZoomAtTarget")
  public void setTapZoomTarget(android.graphics.PointF arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("TapZoomTarget")
  public void setTapZoomTarget(dji.common.camera.CameraTapZoomTargetPoint arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setVideoFileFormat(dji.common.camera.SettingsDefinitions.VideoFileFormat arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setVideoResolutionAndFrameRate(dji.common.camera.ResolutionAndFrameRate arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\GD600\DJICameraGD600Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */