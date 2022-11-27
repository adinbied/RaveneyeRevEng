package dji.sdksharedlib.hardware.abstractions.camera;

import android.graphics.Bitmap;
import android.os.Handler;
import dji.common.camera.CameraUtils;
import dji.common.camera.PhotoTimeLapseSettings;
import dji.common.camera.ResolutionAndFrameRate;
import dji.common.camera.SettingsDefinitions.Aperture;
import dji.common.camera.SettingsDefinitions.CameraMode;
import dji.common.camera.SettingsDefinitions.DigitalFilter;
import dji.common.camera.SettingsDefinitions.FocusMode;
import dji.common.camera.SettingsDefinitions.Orientation;
import dji.common.camera.SettingsDefinitions.PhotoTimeIntervalSettings;
import dji.common.camera.SettingsDefinitions.ShootPhotoMode;
import dji.common.camera.SettingsDefinitions.VideoFrameRate;
import dji.common.camera.SettingsDefinitions.VideoResolution;
import dji.common.camera.SettingsDefinitions.VideoStandard;
import dji.common.camera.SettingsDefinitions.WhiteBalancePreset;
import dji.common.camera.SettingsDefinitions.ZoomSpeed;
import dji.common.error.DJICameraError;
import dji.common.error.DJIError;
import dji.common.util.CallbackUtils;
import dji.common.util.DJICameraEnumMappingUtil;
import dji.common.util.DJILensFeatureUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataBaseCameraGetting;
import dji.midware.data.model.P3.DataCameraGetAudio;
import dji.midware.data.model.P3.DataCameraGetForeArmLed;
import dji.midware.data.model.P3.DataCameraGetPushShotInfo;
import dji.midware.data.model.P3.DataCameraGetRecordFan;
import dji.midware.data.model.P3.DataCameraGetShotInfo;
import dji.midware.data.model.P3.DataCameraGetVOutParams;
import dji.midware.data.model.P3.DataCameraGetVideoCaption;
import dji.midware.data.model.P3.DataCameraSetOpticsZoomMode.ZoomSpeed;
import dji.midware.data.model.P3.DataCameraSetPhoto.TYPE;
import dji.midware.data.model.P3.DataCommonGetVersion;
import dji.midware.data.model.P3.DataOsdGetMicGain;
import dji.midware.data.model.P3.DataSingleSendAppStateForStabilization;
import dji.midware.data.model.P3.DataSingleSendAppStateForStabilization.CameraState;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.media.record.RecorderManager;
import dji.midware.media.record.RecorderManager.BufferMode;
import dji.midware.media.record.RecorderManager.Service_Action;
import dji.sdksharedlib.extension.CacheHelper;
import dji.sdksharedlib.hardware.abstractions.Action;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.Getter;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import dji.sdksharedlib.util.DJISDKCacheThreadManager;
import java.io.File;
import java.util.EnumMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.greenrobot.eventbus.EventBus;

public class DJICameraBaseAbstraction
  extends DJICameraAbstraction
  implements DJIParamAccessListener
{
  private static final int INVALID_EXPOSURE_OFFSET = 255;
  private static final String PHOTO_THUMB_SCREEN = "CACHE_IMAGE";
  private static final String TAG = "DJISDKCacheBaseCameraAbstraction";
  protected EnumMap<SettingsDefinitions.Aperture, Short> apertureMap = null;
  private SettingsDefinitions.DigitalFilter[] currentDigitalFilterRange;
  Handler handler = new Handler(DJISDKCacheThreadManager.getSingletonBackgroundLooper());
  private AtomicBoolean isShootingPhoto = new AtomicBoolean(false);
  private AtomicBoolean isWaitingForShootPhotoFeedback = new AtomicBoolean(false);
  protected DJILensFeatureUtils lensFeatureUtils = null;
  protected DJICameraEnumMappingUtil mappingUtil = null;
  protected int maxAperture = -1;
  protected int maxFocalDistance = -1;
  protected int minAperture = -1;
  protected int minFocalDistance = -1;
  private CountDownLatch recordInCacheCdl;
  protected DataCameraSetOpticsZoomMode.ZoomSpeed speedCache = null;
  private SettingsDefinitions.PhotoTimeIntervalSettings timeIntervalSettings;
  private PhotoTimeLapseSettings timeLapseSettings;
  
  private SettingsDefinitions.ShootPhotoMode convertPhotoTypeToPhotoMode(DataCameraSetPhoto.TYPE paramTYPE)
  {
    return null;
  }
  
  /* Error */
  private void getSerialNumber(DJISDKCacheHWAbstraction.InnerCallback arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isHDLiveViewAvailable()
  {
    return false;
  }
  
  private int mapDigitalFilterToProtocol(SettingsDefinitions.DigitalFilter paramDigitalFilter)
  {
    return 0;
  }
  
  private int ordinalValueTransformHelper(int paramInt)
  {
    return 0;
  }
  
  private void recordInCacheCdlCountDown()
  {
    CountDownLatch localCountDownLatch = this.recordInCacheCdl;
    if (localCountDownLatch != null) {
      localCountDownLatch.countDown();
    }
  }
  
  private void recordInCacheCdlInit(int paramInt)
  {
    this.recordInCacheCdl = new CountDownLatch(paramInt);
  }
  
  /* Error */
  private void recordInCacheCdlWait(int arg1, TimeUnit arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  private void save(Bitmap arg1, DJISDKCacheHWAbstraction.InnerCallback arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private ResolutionAndFrameRate wrapResolutionAndFrameRate(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  protected boolean cantShutterAdjust()
  {
    return false;
  }
  
  protected boolean checkApertureValid(SettingsDefinitions.Aperture paramAperture)
  {
    return false;
  }
  
  protected boolean checkCapabilityForWorkMode(SettingsDefinitions.CameraMode paramCameraMode)
  {
    return false;
  }
  
  protected int checkColIndex(int paramInt)
  {
    return paramInt;
  }
  
  protected void checkIfNeedWaitForPauseTheStabilization(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback, DataSingleSendAppStateForStabilization.CameraState paramCameraState)
  {
    new DataSingleSendAppStateForStabilization().setCameraState(paramCameraState).start();
  }
  
  protected boolean checkIfSupported(SettingsDefinitions.VideoResolution paramVideoResolution, SettingsDefinitions.VideoFrameRate paramVideoFrameRate)
  {
    return ((paramVideoFrameRate != SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS) && (paramVideoFrameRate != SettingsDefinitions.VideoFrameRate.FRAME_RATE_96_FPS)) || (isSlowMotionSupported()) || (getDisplayName().equals("Zenmuse X4S")) || (getDisplayName().equals("Zenmuse X5S")) || (getDisplayName().equals("Phantom 4 Professional Camera"));
  }
  
  protected boolean checkOpticalFocalLengthValue(int paramInt)
  {
    return false;
  }
  
  protected boolean checkOpticalZoomCondition()
  {
    return this.speedCache != null;
  }
  
  protected boolean checkOpticalZoomSupported()
  {
    return false;
  }
  
  protected boolean checkPhotoShootMode(SettingsDefinitions.ShootPhotoMode paramShootPhotoMode)
  {
    return false;
  }
  
  protected boolean checkPortraitDigitalFilterSupported()
  {
    return false;
  }
  
  public DJIError checkPrerequisiteForSetDigitalZoomScale()
  {
    return null;
  }
  
  protected boolean checkTrueColorDigitalFilterSupported()
  {
    return false;
  }
  
  protected boolean checkWhiteBaLanceValid(SettingsDefinitions.WhiteBalancePreset paramWhiteBalancePreset, int paramInt)
  {
    return false;
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
  protected void doSetOpticalZoomFocalLength(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("FormatSDCard")
  public void formatSDCard(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("FormatSSD")
  public void formatSSD(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("AudioGain")
  public void getAudioGain(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("AudioRecordingEnabled")
  public void getAudioRecordEnabled(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("DigitalZoomFactor")
  public void getDigitalZoomScale(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("FileIndexMode")
  public void getFileIndexMode(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("FirmwareVersion")
  public void getFirmwareVersion(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("Hue")
  public void getHue(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("FocusRingValueUpperBound")
  public void getLensFocusRingValueUpperBound(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("LensInformation")
  public void getLensInformation(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("HDLiveViewEnabled")
  public void getLiveViewHDEnable(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("LiveViewOutputMode")
  public void getLiveViewOutputMode(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("MultiLEDsAutoEnabled")
  public void getMultiLEDsAutoEnabled(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("OpticalZoomSpec")
  public void getOpticalZoomSpec(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("PhotoAEBCount")
  @Deprecated
  public void getPhotoAEBCount(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("PhotoQuickViewDuration")
  public void getPhotoQuickViewDuration(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("PhotoTimeLapseSettings")
  public void getPhotoTimeLapseSettings(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Getter("SerialNumber")
  public void getSerialNumber(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    getSerialNumber(paramInnerCallback, 0);
  }
  
  /* Error */
  @Getter("SpotMeteringTarget")
  public void getSpotMeteringAreaRowIndexAndColIndex(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("StreamQuality")
  public void getStreamQuality(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("TurnOffFanWhenPossible")
  public void getTurnOffFanWhenPossible(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("VideoCaptionEnabled")
  public void getVideoCaptionEnabled(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void init(String arg1, int arg2, dji.sdksharedlib.store.DJISDKCacheStoreLayer arg3, dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isAudioRecordSupported()
  {
    return false;
  }
  
  protected boolean isNewProcessOfActivation()
  {
    return false;
  }
  
  protected boolean isOpticalZoomSupported()
  {
    return false;
  }
  
  protected boolean isOrangeFC550()
  {
    return false;
  }
  
  protected boolean isPhotoIntervalParamValid(int paramInt)
  {
    return true;
  }
  
  protected boolean isPhotoQuickViewSupported()
  {
    return true;
  }
  
  /* Error */
  @Action("restoreFactorySettings")
  public void loadFactorySettings(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("LoadSettingsFromProfile")
  public void loadSettingsFrom(DJISDKCacheHWAbstraction.InnerCallback arg1, dji.common.camera.SettingsDefinitions.CustomSettingsProfile arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected int mapMediaDownloadModeToProtocolValue(SettingsDefinitions.CameraMode paramCameraMode)
  {
    return 0;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraGetPushShotInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  public void onEvent3BackgroundThread(dji.midware.media.record.RecorderBase.RecorderStatus arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onValueChange(DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue paramDJISDKCacheParamValue1, DJISDKCacheParamValue paramDJISDKCacheParamValue2)
  {
    if ((paramDJISDKCacheParamValue2 != null) && (paramDJISDKCacheParamValue2.getData() != null))
    {
      this.timeIntervalSettings = ((SettingsDefinitions.PhotoTimeIntervalSettings)CacheHelper.getCamera(this.index, "PhotoTimeIntervalSettings"));
      this.timeLapseSettings = ((PhotoTimeLapseSettings)CacheHelper.getCamera(this.index, "PhotoTimeLapseSettings"));
      this.currentDigitalFilterRange = ((SettingsDefinitions.DigitalFilter[])CacheHelper.getCamera(this.index, "DigitalFilterRange"));
      if ((this.isWaitingForShootPhotoFeedback.get()) && (CameraUtils.isShootingPhoto(this.index))) {
        this.isShootingPhoto.set(true);
      }
    }
  }
  
  public File saveBitmap(Bitmap paramBitmap, String paramString)
  {
    return null;
  }
  
  /* Error */
  @Action("SaveSettingsToProfile")
  public void saveSettingsTo(DJISDKCacheHWAbstraction.InnerCallback arg1, dji.common.camera.SettingsDefinitions.CustomSettingsProfile arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("AELock")
  public void setAELock(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("AntiFlickerFrequency")
  public void setAntiFlicker(dji.common.camera.SettingsDefinitions.AntiFlickerFrequency arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("Aperture")
  public void setAperture(SettingsDefinitions.Aperture arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("AudioGain")
  public void setAudioGain(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("AudioRecordingEnabled")
  public void setAudioRecordEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("AutoAEUnlockEnabled")
  public void setAutoUnlockAELockEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
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
  
  /* Error */
  protected void setCameraModeProtocol(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("Contrast")
  public void setContrast(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("DigitalFilter")
  public void setDigitalFilter(SettingsDefinitions.DigitalFilter arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("DigitalZoomFactor")
  public void setDigitalZoomScale(float arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ExposureCompensation")
  public void setExposureCompensation(dji.common.camera.SettingsDefinitions.ExposureCompensation arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ExposureMode")
  public void setExposureMode(dji.common.camera.SettingsDefinitions.ExposureMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("FileIndexMode")
  public void setFileIndexMode(dji.common.camera.SettingsDefinitions.FileIndexMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("Hue")
  public void setHue(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ISO")
  public void setISO(dji.common.camera.SettingsDefinitions.ISO arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("FocusAssistantSettings")
  public void setLensFocusAssistantEnabled(dji.common.camera.FocusAssistantSettings arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("FocusMode")
  public void setLensFocusMode(SettingsDefinitions.FocusMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("FocusRingValue")
  public void setLensFocusRingValue(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("FocusTarget")
  public void setLensFocusTarget(android.graphics.PointF arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("LiveViewOutputMode")
  public void setLiveViewOutputMode(dji.midware.data.model.P3.DataCameraSetVOutParams.LCDFormat arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("HDLiveViewEnabled")
  public void setLiveViewOutputMode(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("MeteringMode")
  public void setMeteringMode(dji.common.camera.SettingsDefinitions.MeteringMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("MultiLEDsAutoEnabled")
  public void setMultiLEDsAutoEnabled(dji.common.flightcontroller.DJIMultiLEDControlMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("OpticalZoomFocalLength")
  public void setOpticalZoomFocalLength(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("PhotoAEBCount")
  public void setPhotoAEBCount(dji.common.camera.SettingsDefinitions.PhotoAEBCount arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("PhotoBurstCount")
  public void setPhotoBurstCount(dji.common.camera.SettingsDefinitions.PhotoBurstCount arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("PhotoFileFormat")
  public void setPhotoFileFormat(dji.common.camera.SettingsDefinitions.PhotoFileFormat arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("PhotoTimeIntervalSettings")
  public void setPhotoIntervalParam(SettingsDefinitions.PhotoTimeIntervalSettings arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("PhotoQuickViewDuration")
  public void setPhotoQuickViewDuration(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("PhotoAspectRatio")
  public void setPhotoRatio(dji.common.camera.SettingsDefinitions.PhotoAspectRatio arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("PhotoTimeLapseSettings")
  public void setPhotoTimeLapseSettings(PhotoTimeLapseSettings arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("PictureStylePreset")
  public void setPictureStylePreset(dji.common.camera.SettingsDefinitions.PictureStylePreset arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("SSDVideoResolutionAndFrameRate")
  public void setSSDRawVideoResolutionAndFrameRate(ResolutionAndFrameRate arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("Saturation")
  public void setSaturation(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("Sharpness")
  public void setSharpness(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ShootPhotoMode")
  public void setShootPhotoMode(SettingsDefinitions.ShootPhotoMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ShutterSpeed")
  public void setShutterSpeed(dji.common.camera.SettingsDefinitions.ShutterSpeed arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("SpotMeteringTarget")
  public void setSpotMeteringAreaRowIndexAndColIndex(android.graphics.Point arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("StreamQuality")
  public void setStreamQuality(dji.common.camera.SettingsDefinitions.StreamQuality arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("TurnOffFanWhenPossible")
  public void setTurnOffFanWhenPossible(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("LEDAutoTurnOffEnabled")
  public void setTurnOffLEDDuringShootPhotoEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("VideoCaptionEnabled")
  public void setVideoCaptionEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("VideoFileCompressionStandard")
  public void setVideoFileCompressionStandard(dji.common.camera.SettingsDefinitions.VideoFileCompressionStandard arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("VideoFileFormat")
  public void setVideoFileFormat(dji.common.camera.SettingsDefinitions.VideoFileFormat arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ResolutionFrameRate")
  public void setVideoResolutionAndFrameRate(ResolutionAndFrameRate arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("VideoStandard")
  public void setVideoStandard(SettingsDefinitions.VideoStandard arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("WhiteBalance")
  public void setWhiteBalanceAndColorTemperature(dji.common.camera.WhiteBalance arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("ShootPhotoByCaching")
  public void shootPhotoByCaching(DJISDKCacheHWAbstraction.InnerCallback arg1, SettingsDefinitions.ShootPhotoMode arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("StartContinuousOpticalZoom")
  public void startContinuousOpticalZoom(DJISDKCacheHWAbstraction.InnerCallback arg1, dji.common.camera.SettingsDefinitions.ZoomDirection arg2, SettingsDefinitions.ZoomSpeed arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("StartRecordVideo")
  public void startRecordVideo(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Action("StartRecordVideoInCache")
  public void startRecordVideoInCache(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback, Boolean paramBoolean)
  {
    RecorderManager.start(RecorderManager.BufferMode.GDR_ONLINE);
    RecorderManager.setBufferAutoClean(paramBoolean.booleanValue());
    EventBus.getDefault().post(RecorderManager.Service_Action.START_RECORD);
    recordInCacheCdlInit(1);
    recordInCacheCdlWait(1, TimeUnit.SECONDS);
    startRecordTimeTimer();
  }
  
  /* Error */
  @Action("StartShootPhoto")
  protected void startShootPhoto(DJISDKCacheHWAbstraction.InnerCallback arg1, SettingsDefinitions.ShootPhotoMode arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("StopContinuousOpticalZoom")
  public void stopContinuousOpticalZoom(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("StopRecordVideo")
  public void stopRecordVideo(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("StopRecordVideoInCache")
  public void stopRecordVideoInCache(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("StopShootPhoto")
  public void stopShootPhoto(DJISDKCacheHWAbstraction.InnerCallback arg1)
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
  
  protected SettingsDefinitions.FocusMode updateCameraLensFocusMode(DataCameraGetPushShotInfo paramDataCameraGetPushShotInfo)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\DJICameraBaseAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */