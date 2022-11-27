package dji.sdksharedlib.hardware.abstractions.camera.zenmuse;

import dji.common.camera.SettingsDefinitions.CameraMode;
import dji.common.camera.SettingsDefinitions.PhotoFileFormat;
import dji.common.camera.SettingsDefinitions.PhotoTimeIntervalSettings;
import dji.common.camera.SettingsDefinitions.ShootPhotoMode;
import dji.common.camera.SettingsDefinitions.ThermalDigitalZoomFactor;
import dji.common.camera.SettingsDefinitions.ThermalProfile;
import dji.common.camera.SettingsDefinitions.ThermalProfile.Builder;
import dji.common.camera.SettingsDefinitions.VideoStandard;
import dji.common.error.DJIError;
import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo.RecordType;
import dji.midware.data.model.P3.DataCameraGetStateInfo.PhotoState;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.camera.DJICameraAbstraction;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DJICameraXTBaseAbstraction
  extends DJICameraAbstraction
{
  private static float AREA_MULTIPLIER = 10000.0F;
  private static int EXTERNAL_SCENE_PARAMETER_MULTIPLIER = 100;
  private static final int TAU_JPEG = 1;
  private static final int TAU_RADIOMETRIC = 7;
  private static final int TAU_RADIOMETRIC_HIGH = 9;
  private static final int TAU_RADIOMETRIC_LOW = 8;
  private static final int TAU_RAW = 0;
  private static final int TAU_RAW_JPEG = 2;
  private static final int TAU_TIFF14BIT = 4;
  private static final int TAU_TIFF8BIT = 3;
  private static final int TAU_TIFF_TLINEAR_HIGH = 6;
  private static final int TAU_TIFF_TLINEAR_LOW = 5;
  private float centerTemperature;
  private DataCameraGetPushStateInfo.RecordType lastRecordVideoState = DataCameraGetPushStateInfo.RecordType.NO;
  private DataCameraGetStateInfo.PhotoState lastShootPhotoState = DataCameraGetStateInfo.PhotoState.NO;
  protected VideoRecordingState recordVideoFSM = VideoRecordingState.generate(this.index);
  protected PhotoShootingState shootPhotoFSM = PhotoShootingState.generate(this.index);
  
  private SettingsDefinitions.CameraMode checkCameraMode(int paramInt)
  {
    return null;
  }
  
  private boolean checkCapabilityForPhotoFileFormat(SettingsDefinitions.PhotoFileFormat paramPhotoFileFormat)
  {
    return false;
  }
  
  private SettingsDefinitions.ThermalDigitalZoomFactor checkDigitalZoomScale(int paramInt)
  {
    return null;
  }
  
  private DJIError checkPrerequisiteForStartRecordVideo()
  {
    return null;
  }
  
  private DJIError checkPrerequisiteForStartShootPhoto()
  {
    return null;
  }
  
  private DJIError checkPrerequisiteForStopRecordVideo()
  {
    return null;
  }
  
  private DJIError checkPrerequisiteForStopShootPhoto()
  {
    return null;
  }
  
  /* Error */
  private void checkRecordVideoStatus()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private DJIError checkSDCardStatus()
  {
    return null;
  }
  
  /* Error */
  private void checkShootPhotoStatus()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private SettingsDefinitions.VideoStandard checkVideoStandard(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  private int convertPhotoFileFormatToProtocol(SettingsDefinitions.PhotoFileFormat paramPhotoFileFormat)
  {
    return 0;
  }
  
  private SettingsDefinitions.PhotoFileFormat convertPhotoFileFormatToSDK(int paramInt)
  {
    return null;
  }
  
  private boolean isThermometricValid()
  {
    return false;
  }
  
  private SettingsDefinitions.PhotoTimeIntervalSettings wrapPhotoIntervalParam(int paramInt)
  {
    return new SettingsDefinitions.PhotoTimeIntervalSettings(255, paramInt);
  }
  
  private SettingsDefinitions.ThermalProfile wrapThermalProfile(SettingsDefinitions.ThermalProfile.Builder paramBuilder, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  protected boolean checkPhotoShootMode(SettingsDefinitions.ShootPhotoMode paramShootPhotoMode)
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
  @dji.sdksharedlib.hardware.abstractions.Getter("ThermalACE")
  public void getThermalACE(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("ThermalBrightness")
  public void getThermalBrightness(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("ThermalContrast")
  public void getThermalContrast(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("ThermalDDE")
  public void getThermalDDE(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("ThermalMeasurementMode")
  public void getThermalMeasurementMode(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("ThermalSSO")
  public void getThermalSSO(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
  }
  
  /* Error */
  protected void initializeCustomizedKey()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isMediaDownModeMapValue2()
  {
    return true;
  }
  
  protected boolean isMediaDownloadModeSupported()
  {
    return true;
  }
  
  protected boolean isOverallTemperatureMeterSupported()
  {
    return false;
  }
  
  protected boolean isThermalFFCModeSupported()
  {
    return false;
  }
  
  public boolean isThermalImagingCamera()
  {
    return true;
  }
  
  protected boolean isVideoPlaybackSupported()
  {
    return true;
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("restoreFactorySettings")
  public void loadFactorySettings(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataCameraGetPushShotParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraGetPushStateInfo paramDataCameraGetPushStateInfo)
  {
    super.onEvent3BackgroundThread(paramDataCameraGetPushStateInfo);
    if (!isValidSender(paramDataCameraGetPushStateInfo.getSenderId())) {
      return;
    }
    checkShootPhotoStatus();
    checkRecordVideoStatus();
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataCameraGetPushTauParam arg1)
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
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("PhotoFileFormat")
  public void setPhotoFileFormat(SettingsDefinitions.PhotoFileFormat arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("PhotoTimeIntervalSettings")
  public void setPhotoTimeIntervalSettings(SettingsDefinitions.PhotoTimeIntervalSettings arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
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
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalACE")
  public void setThermalACE(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalAtmosphericTemperature")
  public void setThermalAtmosphericTemperature(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalAtmosphericTransmissionCoefficient")
  public void setThermalAtmosphericTransmissionCoefficient(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalBackgroundTemperature")
  public void setThermalBackgroundTemperature(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalBrightness")
  public void setThermalBrightness(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalContrast")
  public void setThermalContrast(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalCustomExternalSceneSettingsProfile")
  public void setThermalCustomExternalSceneSettingsProfile(dji.common.camera.SettingsDefinitions.ThermalCustomExternalSceneSettingsProfile arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalDDE")
  public void setThermalDDE(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalDigitalZoomFactor")
  public void setThermalDigitalZoomScale(SettingsDefinitions.ThermalDigitalZoomFactor arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalFFCMode")
  public void setThermalFFCMode(dji.common.camera.SettingsDefinitions.ThermalFFCMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalGainMode")
  public void setThermalGainMode(dji.common.camera.SettingsDefinitions.ThermalGainMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalIsothermEnabled")
  public void setThermalIsothermEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalIsothermLowerValue")
  public void setThermalIsothermLowerValue(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalIsothermMiddleValue")
  public void setThermalIsothermMiddleValue(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalIsothermUnit")
  public void setThermalIsothermUnit(dji.common.camera.SettingsDefinitions.ThermalIsothermUnit arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalIsothermUpperValue")
  public void setThermalIsothermUpperValue(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalMeasurementMode")
  public void setThermalMeasurementMode(dji.common.camera.ThermalMeasurementMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalPalette")
  public void setThermalPalette(dji.common.camera.SettingsDefinitions.ThermalPalette arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalROI")
  public void setThermalROI(dji.common.camera.SettingsDefinitions.ThermalROI arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalSSO")
  public void setThermalSSO(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalScene")
  public void setThermalScene(dji.common.camera.SettingsDefinitions.ThermalScene arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalSceneEmissivity")
  public void setThermalSceneEmissivity(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalMeteringArea")
  public void setThermalSpotMeteringArea(android.graphics.RectF arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalSpotMeteringTargetPoint")
  public void setThermalSpotMeteringTargetPoint(android.graphics.PointF arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalWindowReflectedTemperature")
  public void setThermalWindowReflectedTemperature(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalWindowReflection")
  public void setThermalWindowReflection(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalWindowTemperature")
  public void setThermalWindowTemperature(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("ThermalWindowTransmissionCoefficient")
  public void setThermalWindowTransmissionCoefficient(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
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
  @dji.sdksharedlib.hardware.abstractions.Action("StartRecordVideo")
  public void startRecordVideo(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void startShootPhoto(DJISDKCacheHWAbstraction.InnerCallback arg1, SettingsDefinitions.ShootPhotoMode arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("StopRecordVideo")
  public void stopRecordVideo(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("StopShootPhoto")
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
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("TriggerThermalFFC")
  public void triggerFFC(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static enum InternalState
  {
    static
    {
      InternalState localInternalState = new InternalState("Working", 1);
      Working = localInternalState;
      $VALUES = new InternalState[] { Idle, localInternalState };
    }
    
    private InternalState() {}
  }
  
  private static class PhotoShootingState
  {
    private int index;
    private boolean initFlag = false;
    private DJICameraXTBaseAbstraction.InternalState state;
    
    public static PhotoShootingState generate(int paramInt)
    {
      PhotoShootingState localPhotoShootingState = new PhotoShootingState();
      if (!localPhotoShootingState.initFlag)
      {
        localPhotoShootingState.state = DJICameraXTBaseAbstraction.InternalState.Idle;
        localPhotoShootingState.initFlag = true;
        localPhotoShootingState.index = paramInt;
      }
      return localPhotoShootingState;
    }
    
    /* Error */
    public void setIdleToWorking()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void setWorkingToIdle()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private static class VideoRecordingState
  {
    private int index = 0;
    private boolean initFlag = false;
    private DJICameraXTBaseAbstraction.InternalState state;
    
    public static VideoRecordingState generate(int paramInt)
    {
      VideoRecordingState localVideoRecordingState = new VideoRecordingState();
      if (!localVideoRecordingState.initFlag)
      {
        localVideoRecordingState.state = DJICameraXTBaseAbstraction.InternalState.Idle;
        localVideoRecordingState.initFlag = true;
        localVideoRecordingState.index = paramInt;
      }
      return localVideoRecordingState;
    }
    
    /* Error */
    public void setIdleToWorking()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void setWorkingToIdle()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\zenmuse\DJICameraXTBaseAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */