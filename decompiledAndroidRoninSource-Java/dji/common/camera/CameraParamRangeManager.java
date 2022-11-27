package dji.common.camera;

import dji.common.util.DJICameraEnumMappingUtil;
import dji.internal.camera.SSDRawMode;
import dji.logic.manager.DJIUSBWifiSwitchManager;
import dji.midware.component.DJIComponentManager;
import dji.midware.component.DJIComponentManager.PlatformType;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo.CameraType;
import dji.sdksharedlib.DJISDKCache;
import dji.sdksharedlib.extension.KeyHelper;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class CameraParamRangeManager
{
  private static final String TAG = "CameraParamRangeManager";
  private SettingsDefinitions.AntiFlickerFrequency[] antiFlickerRange = null;
  private SettingsDefinitions.Aperture[] cameraApertureRange = null;
  private SettingsDefinitions.DigitalFilter[] cameraFilterRange = null;
  private SettingsDefinitions.ISO[] cameraISORange = null;
  private SettingsDefinitions.CameraMode[] cameraModeRange = null;
  private DJISDKCacheKey defaultKey;
  private SettingsDefinitions.ExposureCompensation[] exposureCompensationRange = null;
  private SettingsDefinitions.ExposureMode[] exposureModeRange = null;
  private ArrayList<DJIParamAccessListener> listeners;
  private DJISDKCacheHWAbstraction.OnValueChangeListener onValueChangeListener;
  private SettingsDefinitions.Orientation[] orientationRange = null;
  private SettingsDefinitions.PhotoAspectRatio[] photoAspectRatioRange = null;
  private SettingsDefinitions.PhotoFileFormat[] photoFileFormatRange = null;
  private ResolutionAndFrameRate[] resolutionAndFrameRateRange = null;
  private int[][] shootPhotoModeChildRange = (int[][])null;
  private SettingsDefinitions.ShootPhotoMode[] shootPhotoModeRange = null;
  private SettingsDefinitions.ShutterSpeed[] shutterSpeedRange = null;
  private SettingsDefinitions.VideoResolution[] ssdVideoResolutionRange = null;
  private SettingsDefinitions.VideoFileFormat[] videoFileFormatRange = null;
  private int[] whiteBalanceCustomColorTemperatureRange = null;
  private SettingsDefinitions.WhiteBalancePreset[] whiteBalancePresentRange = null;
  
  public CameraParamRangeManager(DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener, DJISDKCacheKey paramDJISDKCacheKey)
  {
    this.onValueChangeListener = paramOnValueChangeListener;
    this.defaultKey = paramDJISDKCacheKey;
    if (paramOnValueChangeListener != null)
    {
      triggerUpdateAll();
      this.listeners = new ArrayList();
      addListenersForISORange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("ExposureMode"), paramDJISDKCacheKey.clone("Mode"), paramDJISDKCacheKey.clone("CameraType") });
      addListenersForExposureCompensationRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType") });
      addListenersForExposureModeRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType") });
      addListenersForCameraModeRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType") });
      addListenersForShootPhotoModeRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType") });
      addListenersForShootPhotoModeChildRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType"), paramDJISDKCacheKey.clone("PhotoFileFormat") });
      addListenersForPhotoFileFormatRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType"), paramDJISDKCacheKey.clone("CameraTrackingMode") });
      addListenersForWhiteBalancePresentRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType") });
      addListenersForWhiteBalanceCustomColorTemperatureRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType") });
      addListenersForPhotoAspectRatioRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType"), paramDJISDKCacheKey.clone("CameraTrackingMode") });
      addListenersForVideoFileFormatRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType") });
      addListenersForAntiFlickerRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType") });
      addListenersForOrientationRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType"), paramDJISDKCacheKey.clone("CameraTrackingMode") });
      addListenersForCameraVideoResolutionAndFrameRateRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType"), paramDJISDKCacheKey.clone("VideoStandard") });
      addListenersForShutterSpeedRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("ExposureMode"), paramDJISDKCacheKey.clone("Mode"), paramDJISDKCacheKey.clone("ResolutionFrameRate") });
      addListenersForApertureRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType"), paramDJISDKCacheKey.clone("ExposureMode") });
      addListenersForCameraFilterRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType") });
      addListenersForSSDVideoResolutionRange(new DJISDKCacheKey[] { paramDJISDKCacheKey.clone("CameraType"), paramDJISDKCacheKey.clone("ssdRawMode"), paramDJISDKCacheKey.clone("ResolutionFrameRate") });
    }
  }
  
  /* Error */
  private void addListener(DJIParamAccessListener arg1, DJISDKCacheKey... arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForAntiFlickerRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForApertureRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForCameraFilterRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForCameraModeRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForCameraVideoResolutionAndFrameRateRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForExposureCompensationRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForExposureModeRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForISORange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForOrientationRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForPhotoAspectRatioRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForPhotoFileFormatRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForSSDVideoResolutionRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForShootPhotoModeChildRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForShootPhotoModeRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForShutterSpeedRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForVideoFileFormatRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForWhiteBalanceCustomColorTemperatureRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addListenersForWhiteBalancePresentRange(DJISDKCacheKey... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addOneListener(DJISDKCacheKey arg1, DJIParamAccessListener arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean areDifferent2Degrees(int[][] paramArrayOfInt1, int[][] paramArrayOfInt2)
  {
    return false;
  }
  
  private static SettingsDefinitions.ShutterSpeed[] defaultAircraftRange()
  {
    return new SettingsDefinitions.ShutterSpeed[] { SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_8000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_6400, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_5000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_4000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_3200, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_2500, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_2000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_1600, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_1250, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_1000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_800, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_640, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_500, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_400, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_320, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_240, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_200, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_160, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_120, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_100, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_80, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_60, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_50, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_40, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_30, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_25, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_20, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_15, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_12_DOT_5, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_10, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_8, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_6_DOT_25, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_5, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_4, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_3, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_2_DOT_5, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_2, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_1_DOT_67, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_1_DOT_25, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_DOT_3, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_DOT_6, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_2, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_2_DOT_5, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_3, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_3_DOT_2, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_4, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_5, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_6, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_7, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_8 };
  }
  
  private static SettingsDefinitions.ExposureCompensation[] defaultExposureCompensationList()
  {
    return new SettingsDefinitions.ExposureCompensation[] { SettingsDefinitions.ExposureCompensation.N_3_0, SettingsDefinitions.ExposureCompensation.N_2_7, SettingsDefinitions.ExposureCompensation.N_2_3, SettingsDefinitions.ExposureCompensation.N_2_0, SettingsDefinitions.ExposureCompensation.N_1_7, SettingsDefinitions.ExposureCompensation.N_1_3, SettingsDefinitions.ExposureCompensation.N_1_0, SettingsDefinitions.ExposureCompensation.N_0_7, SettingsDefinitions.ExposureCompensation.N_0_3, SettingsDefinitions.ExposureCompensation.N_0_0, SettingsDefinitions.ExposureCompensation.P_0_3, SettingsDefinitions.ExposureCompensation.P_0_7, SettingsDefinitions.ExposureCompensation.P_1_0, SettingsDefinitions.ExposureCompensation.P_1_3, SettingsDefinitions.ExposureCompensation.P_1_7, SettingsDefinitions.ExposureCompensation.P_2_0, SettingsDefinitions.ExposureCompensation.P_2_3, SettingsDefinitions.ExposureCompensation.P_2_7, SettingsDefinitions.ExposureCompensation.P_3_0 };
  }
  
  private static SettingsDefinitions.ShutterSpeed[] defaultGD600ShutterSpeedRange()
  {
    return new SettingsDefinitions.ShutterSpeed[] { SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_6000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_4000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_3000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_2000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_1500, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_1000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_725, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_500, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_350, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_250, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_180, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_125, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_100, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_90, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_60, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_30, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_15, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_8, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_4, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_2, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1 };
  }
  
  private static SettingsDefinitions.ShutterSpeed[] defaultHandheldRange()
  {
    return new SettingsDefinitions.ShutterSpeed[] { SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_8000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_6400, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_5000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_4000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_3200, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_2500, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_2000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_1600, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_1250, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_1000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_800, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_640, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_500, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_400, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_320, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_240, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_200, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_160, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_120, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_100, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_80, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_60, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_50, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_40, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_30, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_25, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_20, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_15, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_12_DOT_5, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_10, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_8, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_6_DOT_25, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_5, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_4, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_3, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_2_DOT_5, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_2, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_1_DOT_67, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_1_DOT_25, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_DOT_3, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_DOT_6, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_2, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_2_DOT_5, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_3, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_3_DOT_2, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_4, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_5, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_6, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_7, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_8, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_9, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_10, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_13, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_15, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_20, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_25, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_30 };
  }
  
  private static SettingsDefinitions.ShutterSpeed[] defaultMavicShutterSpeedRange()
  {
    return new SettingsDefinitions.ShutterSpeed[] { SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_3200, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_2500, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_1600, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_1250, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_1000, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_800, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_640, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_500, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_400, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_320, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_240, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_200, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_160, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_120, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_100, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_80, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_60, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_50, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_40, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_30, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_25, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_20, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_15, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_12_DOT_5, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_10, SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_8 };
  }
  
  public static SettingsDefinitions.Aperture[] getApertureRange(int paramInt)
  {
    boolean bool = DJIComponentManager.getInstance().isAircraftConnected();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bool)
    {
      DataCameraGetPushStateInfo.CameraType localCameraType = getCameraType(paramInt);
      if (localCameraType == null) {
        return null;
      }
      SettingsDefinitions.ExposureMode localExposureMode = getExposureMode(paramInt);
      if (localExposureMode == null) {
        return null;
      }
      if (SettingsDefinitions.ExposureMode.MANUAL != localExposureMode)
      {
        localObject1 = localObject2;
        if (SettingsDefinitions.ExposureMode.APERTURE_PRIORITY != localExposureMode) {}
      }
      else if ((localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550) && (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw) && (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6510) && (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6520))
      {
        if (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeGD600) {
          return new SettingsDefinitions.Aperture[] { SettingsDefinitions.Aperture.F_1_DOT_6, SettingsDefinitions.Aperture.F_2, SettingsDefinitions.Aperture.F_2_DOT_4, SettingsDefinitions.Aperture.F_2_DOT_8, SettingsDefinitions.Aperture.F_3_DOT_4, SettingsDefinitions.Aperture.F_4, SettingsDefinitions.Aperture.F_4_DOT_8, SettingsDefinitions.Aperture.F_5_DOT_6, SettingsDefinitions.Aperture.F_6_DOT_8, SettingsDefinitions.Aperture.F_8, SettingsDefinitions.Aperture.F_9_DOT_6, SettingsDefinitions.Aperture.F_11, SettingsDefinitions.Aperture.F_14 };
        }
        localObject1 = localObject2;
        if (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6310) {
          return new SettingsDefinitions.Aperture[] { SettingsDefinitions.Aperture.F_2_DOT_8, SettingsDefinitions.Aperture.F_3_DOT_2, SettingsDefinitions.Aperture.F_3_DOT_5, SettingsDefinitions.Aperture.F_4, SettingsDefinitions.Aperture.F_4_DOT_5, SettingsDefinitions.Aperture.F_5, SettingsDefinitions.Aperture.F_5_DOT_6, SettingsDefinitions.Aperture.F_6_DOT_3, SettingsDefinitions.Aperture.F_7_DOT_1, SettingsDefinitions.Aperture.F_8, SettingsDefinitions.Aperture.F_9, SettingsDefinitions.Aperture.F_10, SettingsDefinitions.Aperture.F_11 };
        }
      }
      else
      {
        localObject1 = new SettingsDefinitions.Aperture[21];
        localObject1[0] = SettingsDefinitions.Aperture.F_1_DOT_7;
        localObject1[1] = SettingsDefinitions.Aperture.F_1_DOT_8;
        localObject1[2] = SettingsDefinitions.Aperture.F_2;
        localObject1[3] = SettingsDefinitions.Aperture.F_2_DOT_2;
        localObject1[4] = SettingsDefinitions.Aperture.F_2_DOT_5;
        localObject1[5] = SettingsDefinitions.Aperture.F_2_DOT_8;
        localObject1[6] = SettingsDefinitions.Aperture.F_3_DOT_2;
        localObject1[7] = SettingsDefinitions.Aperture.F_3_DOT_5;
        localObject1[8] = SettingsDefinitions.Aperture.F_4;
        localObject1[9] = SettingsDefinitions.Aperture.F_4_DOT_5;
        localObject1[10] = SettingsDefinitions.Aperture.F_5;
        localObject1[11] = SettingsDefinitions.Aperture.F_5_DOT_6;
        localObject1[12] = SettingsDefinitions.Aperture.F_6_DOT_3;
        localObject1[13] = SettingsDefinitions.Aperture.F_7_DOT_1;
        localObject1[14] = SettingsDefinitions.Aperture.F_8;
        localObject1[15] = SettingsDefinitions.Aperture.F_9;
        localObject1[16] = SettingsDefinitions.Aperture.F_10;
        localObject1[17] = SettingsDefinitions.Aperture.F_11;
        localObject1[18] = SettingsDefinitions.Aperture.F_13;
        localObject1[19] = SettingsDefinitions.Aperture.F_14;
        localObject1[20] = SettingsDefinitions.Aperture.F_16;
      }
    }
    return (SettingsDefinitions.Aperture[])localObject1;
  }
  
  private static ResolutionAndFrameRate[] getCV600AndFC350ResolutionAndFrameRateArray(DJIComponentManager.PlatformType paramPlatformType, SettingsDefinitions.VideoStandard paramVideoStandard)
  {
    int i = 19.$SwitchMap$dji$midware$component$DJIComponentManager$PlatformType[paramPlatformType.ordinal()];
    if (i != 3)
    {
      if ((i != 4) && (i != 5)) {
        return null;
      }
      if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC) {
        return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS) };
      }
      return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS) };
    }
    if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC) {
      return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS) };
    }
    return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS) };
  }
  
  private static SettingsDefinitions.CameraMode getCameraMode(int paramInt)
  {
    return (SettingsDefinitions.CameraMode)getKeyAvailableValue(KeyHelper.getCameraKey(paramInt, "Mode"));
  }
  
  public static SettingsDefinitions.CameraMode[] getCameraModeRange(int paramInt)
  {
    DJIComponentManager.PlatformType localPlatformType = DJIComponentManager.getInstance().getPlatformType();
    DataCameraGetPushStateInfo.CameraType localCameraType = getCameraType(paramInt);
    if (localCameraType == null) {
      return null;
    }
    switch (19.$SwitchMap$dji$midware$data$model$P3$DataCameraGetPushStateInfo$CameraType[localCameraType.ordinal()])
    {
    default: 
      return null;
    case 16: 
    case 17: 
      return new SettingsDefinitions.CameraMode[] { SettingsDefinitions.CameraMode.SHOOT_PHOTO, SettingsDefinitions.CameraMode.RECORD_VIDEO, SettingsDefinitions.CameraMode.MEDIA_DOWNLOAD, SettingsDefinitions.CameraMode.BROADCAST };
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
      return new SettingsDefinitions.CameraMode[] { SettingsDefinitions.CameraMode.SHOOT_PHOTO, SettingsDefinitions.CameraMode.RECORD_VIDEO, SettingsDefinitions.CameraMode.MEDIA_DOWNLOAD };
    case 6: 
    case 7: 
      if (localPlatformType == DJIComponentManager.PlatformType.OSMO) {
        return new SettingsDefinitions.CameraMode[] { SettingsDefinitions.CameraMode.SHOOT_PHOTO, SettingsDefinitions.CameraMode.RECORD_VIDEO, SettingsDefinitions.CameraMode.MEDIA_DOWNLOAD };
      }
      return new SettingsDefinitions.CameraMode[] { SettingsDefinitions.CameraMode.SHOOT_PHOTO, SettingsDefinitions.CameraMode.RECORD_VIDEO, SettingsDefinitions.CameraMode.PLAYBACK, SettingsDefinitions.CameraMode.MEDIA_DOWNLOAD };
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      return new SettingsDefinitions.CameraMode[] { SettingsDefinitions.CameraMode.SHOOT_PHOTO, SettingsDefinitions.CameraMode.RECORD_VIDEO, SettingsDefinitions.CameraMode.PLAYBACK, SettingsDefinitions.CameraMode.MEDIA_DOWNLOAD };
    }
    return new SettingsDefinitions.CameraMode[] { SettingsDefinitions.CameraMode.SHOOT_PHOTO, SettingsDefinitions.CameraMode.RECORD_VIDEO, SettingsDefinitions.CameraMode.PLAYBACK };
  }
  
  private static DataCameraGetPushStateInfo.CameraType getCameraType(int paramInt)
  {
    return (DataCameraGetPushStateInfo.CameraType)getKeyAvailableValue(KeyHelper.getCameraKey(paramInt, "CameraType"));
  }
  
  private int getExpectedSenderIdByIndex()
  {
    return 0;
  }
  
  public static SettingsDefinitions.ExposureCompensation[] getExposureCompensationRange(int paramInt)
  {
    boolean bool = DJIComponentManager.getInstance().isAircraftConnected();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bool)
    {
      localObject1 = DJIComponentManager.getInstance().getPlatformType();
      DataCameraGetPushStateInfo.CameraType localCameraType = getCameraType(paramInt);
      if (localCameraType == null) {
        return null;
      }
      if (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeGD600) {
        return new SettingsDefinitions.ExposureCompensation[] { SettingsDefinitions.ExposureCompensation.N_2_3, SettingsDefinitions.ExposureCompensation.N_2_0, SettingsDefinitions.ExposureCompensation.N_1_7, SettingsDefinitions.ExposureCompensation.N_1_3, SettingsDefinitions.ExposureCompensation.N_1_0, SettingsDefinitions.ExposureCompensation.N_0_7, SettingsDefinitions.ExposureCompensation.N_0_3, SettingsDefinitions.ExposureCompensation.N_0_0, SettingsDefinitions.ExposureCompensation.P_0_3, SettingsDefinitions.ExposureCompensation.P_0_7, SettingsDefinitions.ExposureCompensation.P_1_0, SettingsDefinitions.ExposureCompensation.P_1_3, SettingsDefinitions.ExposureCompensation.P_1_7, SettingsDefinitions.ExposureCompensation.P_2_0, SettingsDefinitions.ExposureCompensation.P_2_3 };
      }
      paramInt = 19.$SwitchMap$dji$midware$component$DJIComponentManager$PlatformType[localObject1.ordinal()];
      if (paramInt != 1)
      {
        localObject1 = localObject2;
        if (paramInt != 2) {
          return defaultExposureCompensationList();
        }
      }
      else
      {
        if (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC220S) {
          return new SettingsDefinitions.ExposureCompensation[] { SettingsDefinitions.ExposureCompensation.N_1_0, SettingsDefinitions.ExposureCompensation.N_0_7, SettingsDefinitions.ExposureCompensation.N_0_3, SettingsDefinitions.ExposureCompensation.N_0_0, SettingsDefinitions.ExposureCompensation.P_0_3, SettingsDefinitions.ExposureCompensation.P_0_7, SettingsDefinitions.ExposureCompensation.P_1_0 };
        }
        localObject1 = defaultExposureCompensationList();
      }
    }
    return (SettingsDefinitions.ExposureCompensation[])localObject1;
  }
  
  private static SettingsDefinitions.ExposureMode getExposureMode(int paramInt)
  {
    return (SettingsDefinitions.ExposureMode)getKeyAvailableValue(KeyHelper.getCameraKey(paramInt, "ExposureMode"));
  }
  
  public static SettingsDefinitions.ExposureMode[] getExposureModeRange(int paramInt)
  {
    boolean bool = DJIComponentManager.getInstance().isAircraftConnected();
    Object localObject = null;
    if (bool)
    {
      localObject = getCameraType(paramInt);
      if (localObject == null) {
        return null;
      }
      if ((localObject != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw) && (localObject != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC350) && (localObject != DataCameraGetPushStateInfo.CameraType.DJICameraTypeCV600))
      {
        if ((localObject != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw) && (localObject != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550) && (localObject != DataCameraGetPushStateInfo.CameraType.DJICameraTypeGD600) && (localObject != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6310) && (localObject != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6510) && (localObject != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6520))
        {
          localObject = new SettingsDefinitions.ExposureMode[3];
          localObject[0] = SettingsDefinitions.ExposureMode.MANUAL;
          localObject[1] = SettingsDefinitions.ExposureMode.PROGRAM;
          localObject[2] = SettingsDefinitions.ExposureMode.SHUTTER_PRIORITY;
        }
        else
        {
          localObject = new SettingsDefinitions.ExposureMode[4];
          localObject[0] = SettingsDefinitions.ExposureMode.MANUAL;
          localObject[1] = SettingsDefinitions.ExposureMode.PROGRAM;
          localObject[2] = SettingsDefinitions.ExposureMode.SHUTTER_PRIORITY;
          localObject[3] = SettingsDefinitions.ExposureMode.APERTURE_PRIORITY;
        }
      }
      else
      {
        localObject = new SettingsDefinitions.ExposureMode[3];
        localObject[0] = SettingsDefinitions.ExposureMode.MANUAL;
        localObject[1] = SettingsDefinitions.ExposureMode.PROGRAM;
        localObject[2] = SettingsDefinitions.ExposureMode.SHUTTER_PRIORITY;
      }
    }
    return (SettingsDefinitions.ExposureMode[])localObject;
  }
  
  private static ResolutionAndFrameRate[] getFC220ResolutionAndFrameRateArray(SettingsDefinitions.VideoStandard paramVideoStandard)
  {
    if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC) {
      return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_96_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS) };
    }
    return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_96_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS) };
  }
  
  private static ResolutionAndFrameRate[] getFC220SResolutionAndFrameRateArray(SettingsDefinitions.VideoStandard paramVideoStandard)
  {
    if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC) {
      return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS) };
    }
    return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS) };
  }
  
  private static ResolutionAndFrameRate[] getFC260ResolutionAndFrameRateArray(SettingsDefinitions.VideoStandard paramVideoStandard)
  {
    if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC) {
      return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS) };
    }
    return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS) };
  }
  
  private static ResolutionAndFrameRate[] getFC300SResolutionAndFrameRateArray(SettingsDefinitions.VideoStandard paramVideoStandard)
  {
    if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC) {
      return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS) };
    }
    return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS) };
  }
  
  private static ResolutionAndFrameRate[] getFC300XAndFC300XWResolutionAndFrameRateArray(SettingsDefinitions.VideoStandard paramVideoStandard)
  {
    if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC) {
      return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS) };
    }
    return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS) };
  }
  
  private static ResolutionAndFrameRate[] getFC330XResolutionAndFrameRateArray(SettingsDefinitions.VideoStandard paramVideoStandard)
  {
    if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC) {
      return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS) };
    }
    return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS) };
  }
  
  private static ResolutionAndFrameRate[] getFC550AndFC550RawResolutionAndFrameRateArray(SettingsDefinitions.VideoStandard paramVideoStandard)
  {
    if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC) {
      return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS) };
    }
    return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2704x1520, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS) };
  }
  
  private static ResolutionAndFrameRate[] getFC6310ResolutionAndFrameRateArray(SettingsDefinitions.VideoStandard paramVideoStandard, SettingsDefinitions.VideoFileCompressionStandard paramVideoFileCompressionStandard)
  {
    if (paramVideoFileCompressionStandard == SettingsDefinitions.VideoFileCompressionStandard.H264)
    {
      if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC)
      {
        paramVideoStandard = new ResolutionAndFrameRate[20];
        paramVideoStandard[0] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoStandard[1] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoStandard[2] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoStandard[3] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoStandard[4] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoStandard[5] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
        paramVideoStandard[6] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
        paramVideoStandard[7] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
        paramVideoStandard[8] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
        paramVideoStandard[9] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
        paramVideoStandard[10] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoStandard[11] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoStandard[12] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoStandard[13] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoStandard[14] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoStandard[15] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS);
        paramVideoStandard[16] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS);
        paramVideoStandard[17] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS);
        paramVideoStandard[18] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS);
        paramVideoStandard[19] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS);
      }
      else
      {
        paramVideoStandard = new ResolutionAndFrameRate[20];
        paramVideoStandard[0] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoStandard[1] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoStandard[2] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoStandard[3] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoStandard[4] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoStandard[5] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
        paramVideoStandard[6] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
        paramVideoStandard[7] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
        paramVideoStandard[8] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
        paramVideoStandard[9] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
        paramVideoStandard[10] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoStandard[11] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoStandard[12] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoStandard[13] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoStandard[14] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoStandard[15] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS);
        paramVideoStandard[16] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS);
        paramVideoStandard[17] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS);
        paramVideoStandard[18] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS);
        paramVideoStandard[19] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS);
      }
    }
    else if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC)
    {
      paramVideoStandard = new ResolutionAndFrameRate[16];
      paramVideoStandard[0] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[1] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[2] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[3] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[4] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[5] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
      paramVideoStandard[6] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
      paramVideoStandard[7] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
      paramVideoStandard[8] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
      paramVideoStandard[9] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
      paramVideoStandard[10] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
      paramVideoStandard[11] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
      paramVideoStandard[12] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
      paramVideoStandard[13] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS);
      paramVideoStandard[14] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS);
      paramVideoStandard[15] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS);
    }
    else
    {
      paramVideoStandard = new ResolutionAndFrameRate[16];
      paramVideoStandard[0] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[1] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[2] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[3] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[4] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[5] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
      paramVideoStandard[6] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
      paramVideoStandard[7] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
      paramVideoStandard[8] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
      paramVideoStandard[9] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
      paramVideoStandard[10] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
      paramVideoStandard[11] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
      paramVideoStandard[12] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
      paramVideoStandard[13] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS);
      paramVideoStandard[14] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS);
      paramVideoStandard[15] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS);
    }
    paramVideoFileCompressionStandard = paramVideoStandard;
    if (DataCameraGetPushStateInfo.getInstance().getVerstion(new int[0]) >= 4)
    {
      paramVideoStandard = new LinkedList(Arrays.asList(paramVideoStandard));
      paramVideoStandard.add(new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS));
      paramVideoStandard.add(new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1280x720, SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS));
      paramVideoFileCompressionStandard = (ResolutionAndFrameRate[])paramVideoStandard.toArray(new ResolutionAndFrameRate[paramVideoStandard.size()]);
    }
    return paramVideoFileCompressionStandard;
  }
  
  private static ResolutionAndFrameRate[] getFC6510ResolutionAndFrameRateArray(SettingsDefinitions.VideoStandard paramVideoStandard, SettingsDefinitions.VideoFileCompressionStandard paramVideoFileCompressionStandard)
  {
    if (paramVideoFileCompressionStandard == SettingsDefinitions.VideoFileCompressionStandard.H264)
    {
      if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC)
      {
        paramVideoFileCompressionStandard = new ResolutionAndFrameRate[16];
        paramVideoFileCompressionStandard[0] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoFileCompressionStandard[1] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoFileCompressionStandard[2] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoFileCompressionStandard[3] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoFileCompressionStandard[4] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
        paramVideoFileCompressionStandard[5] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
        paramVideoFileCompressionStandard[6] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
        paramVideoFileCompressionStandard[7] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
        paramVideoFileCompressionStandard[8] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoFileCompressionStandard[9] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoFileCompressionStandard[10] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoFileCompressionStandard[11] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoFileCompressionStandard[12] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS);
        paramVideoFileCompressionStandard[13] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS);
        paramVideoFileCompressionStandard[14] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS);
        paramVideoFileCompressionStandard[15] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS);
        paramVideoStandard = paramVideoFileCompressionStandard;
        if (DataCameraGetPushStateInfo.getInstance().getVerstion(new int[0]) >= 4)
        {
          paramVideoStandard = new LinkedList(Arrays.asList(paramVideoFileCompressionStandard));
          paramVideoStandard.add(new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS));
          paramVideoStandard = (ResolutionAndFrameRate[])paramVideoStandard.toArray(new ResolutionAndFrameRate[paramVideoStandard.size()]);
          paramVideoStandard = paramVideoFileCompressionStandard;
        }
      }
      else
      {
        paramVideoStandard = new ResolutionAndFrameRate[16];
        paramVideoStandard[0] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoStandard[1] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoStandard[2] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoStandard[3] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
        paramVideoStandard[4] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
        paramVideoStandard[5] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
        paramVideoStandard[6] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
        paramVideoStandard[7] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
        paramVideoStandard[8] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoStandard[9] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoStandard[10] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoStandard[11] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
        paramVideoStandard[12] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS);
        paramVideoStandard[13] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS);
        paramVideoStandard[14] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS);
        paramVideoStandard[15] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS);
      }
    }
    else if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC)
    {
      paramVideoStandard = new ResolutionAndFrameRate[12];
      paramVideoStandard[0] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[1] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[2] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[3] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[4] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
      paramVideoStandard[5] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
      paramVideoStandard[6] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
      paramVideoStandard[7] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
      paramVideoStandard[8] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
      paramVideoStandard[9] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
      paramVideoStandard[10] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS);
      paramVideoStandard[11] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS);
    }
    else
    {
      paramVideoStandard = new ResolutionAndFrameRate[15];
      paramVideoStandard[0] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[1] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x1572, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[2] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[3] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[4] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS);
      paramVideoStandard[5] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
      paramVideoStandard[6] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x1572, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
      paramVideoStandard[7] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
      paramVideoStandard[8] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
      paramVideoStandard[9] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS);
      paramVideoStandard[10] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
      paramVideoStandard[11] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS);
      paramVideoStandard[12] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS);
      paramVideoStandard[13] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS);
      paramVideoStandard[14] = new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS);
    }
    paramVideoFileCompressionStandard = paramVideoStandard;
    if (DataCameraGetPushStateInfo.getInstance().getVerstion(new int[0]) >= 4)
    {
      paramVideoStandard = new LinkedList(Arrays.asList(paramVideoStandard));
      paramVideoStandard.add(new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS));
      paramVideoFileCompressionStandard = (ResolutionAndFrameRate[])paramVideoStandard.toArray(new ResolutionAndFrameRate[paramVideoStandard.size()]);
    }
    return paramVideoFileCompressionStandard;
  }
  
  private static ResolutionAndFrameRate[] getFC6520ResolutionAndFrameRateArray(SettingsDefinitions.VideoStandard paramVideoStandard, SettingsDefinitions.VideoFileCompressionStandard paramVideoFileCompressionStandard)
  {
    if (paramVideoFileCompressionStandard == SettingsDefinitions.VideoFileCompressionStandard.H264)
    {
      if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC) {
        return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x1572, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x1572, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x1572, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS) };
      }
      return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x1572, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x1572, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x1572, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS) };
    }
    if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC) {
      return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x1572, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x1572, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x1572, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_59_DOT_940_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS) };
    }
    return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x1572, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_23_DOT_976_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x1572, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x1572, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_47_DOT_950_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_2720x1530, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_50_FPS), new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_120_FPS) };
  }
  
  private static ResolutionAndFrameRate[] getGD600ResolutionAndFrameRateArray(SettingsDefinitions.VideoStandard paramVideoStandard)
  {
    if (paramVideoStandard == SettingsDefinitions.VideoStandard.NTSC) {
      return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS) };
    }
    return new ResolutionAndFrameRate[] { new ResolutionAndFrameRate(SettingsDefinitions.VideoResolution.RESOLUTION_1920x1080, SettingsDefinitions.VideoFrameRate.FRAME_RATE_25_FPS) };
  }
  
  public static SettingsDefinitions.ISO[] getISORange(int paramInt)
  {
    boolean bool = DJIComponentManager.getInstance().isAircraftConnected();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bool)
    {
      DataCameraGetPushStateInfo.CameraType localCameraType = getCameraType(paramInt);
      if (localCameraType == null) {
        return null;
      }
      SettingsDefinitions.CameraMode localCameraMode = getCameraMode(paramInt);
      if (localCameraMode == null) {
        return null;
      }
      SettingsDefinitions.ExposureMode localExposureMode = getExposureMode(paramInt);
      if (localExposureMode == null) {
        return null;
      }
      if ((localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC260) && (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC300S) && (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC300X) && (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC350) && (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC300XW) && (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC330X) && (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeCV600) && (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC220) && (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC220S))
      {
        if ((localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550) && (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw) && (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeGD600) && (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6520) && (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6510))
        {
          localObject1 = localObject2;
          if (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6310)
          {
            if (localCameraMode == SettingsDefinitions.CameraMode.RECORD_VIDEO)
            {
              if (SettingsDefinitions.ExposureMode.MANUAL == localExposureMode) {
                return new SettingsDefinitions.ISO[] { SettingsDefinitions.ISO.ISO_100, SettingsDefinitions.ISO.ISO_200, SettingsDefinitions.ISO.ISO_400, SettingsDefinitions.ISO.ISO_800, SettingsDefinitions.ISO.ISO_1600, SettingsDefinitions.ISO.ISO_3200, SettingsDefinitions.ISO.ISO_6400 };
              }
              return new SettingsDefinitions.ISO[] { SettingsDefinitions.ISO.AUTO, SettingsDefinitions.ISO.ISO_100, SettingsDefinitions.ISO.ISO_200, SettingsDefinitions.ISO.ISO_400, SettingsDefinitions.ISO.ISO_800, SettingsDefinitions.ISO.ISO_1600, SettingsDefinitions.ISO.ISO_3200, SettingsDefinitions.ISO.ISO_6400 };
            }
            if (SettingsDefinitions.ExposureMode.MANUAL == localExposureMode) {
              return new SettingsDefinitions.ISO[] { SettingsDefinitions.ISO.ISO_100, SettingsDefinitions.ISO.ISO_200, SettingsDefinitions.ISO.ISO_400, SettingsDefinitions.ISO.ISO_800, SettingsDefinitions.ISO.ISO_1600, SettingsDefinitions.ISO.ISO_3200, SettingsDefinitions.ISO.ISO_6400, SettingsDefinitions.ISO.ISO_12800 };
            }
            return new SettingsDefinitions.ISO[] { SettingsDefinitions.ISO.AUTO, SettingsDefinitions.ISO.ISO_100, SettingsDefinitions.ISO.ISO_200, SettingsDefinitions.ISO.ISO_400, SettingsDefinitions.ISO.ISO_800, SettingsDefinitions.ISO.ISO_1600, SettingsDefinitions.ISO.ISO_3200, SettingsDefinitions.ISO.ISO_6400, SettingsDefinitions.ISO.ISO_12800 };
          }
        }
        else
        {
          if (localCameraMode == SettingsDefinitions.CameraMode.RECORD_VIDEO)
          {
            if (SettingsDefinitions.ExposureMode.MANUAL == localExposureMode) {
              return new SettingsDefinitions.ISO[] { SettingsDefinitions.ISO.ISO_100, SettingsDefinitions.ISO.ISO_200, SettingsDefinitions.ISO.ISO_400, SettingsDefinitions.ISO.ISO_800, SettingsDefinitions.ISO.ISO_1600, SettingsDefinitions.ISO.ISO_3200, SettingsDefinitions.ISO.ISO_6400 };
            }
            return new SettingsDefinitions.ISO[] { SettingsDefinitions.ISO.ISO_100, SettingsDefinitions.ISO.ISO_200, SettingsDefinitions.ISO.ISO_400, SettingsDefinitions.ISO.ISO_800, SettingsDefinitions.ISO.ISO_1600, SettingsDefinitions.ISO.ISO_3200, SettingsDefinitions.ISO.ISO_6400, SettingsDefinitions.ISO.AUTO };
          }
          if (SettingsDefinitions.ExposureMode.MANUAL == localExposureMode) {
            return new SettingsDefinitions.ISO[] { SettingsDefinitions.ISO.ISO_100, SettingsDefinitions.ISO.ISO_200, SettingsDefinitions.ISO.ISO_400, SettingsDefinitions.ISO.ISO_800, SettingsDefinitions.ISO.ISO_1600, SettingsDefinitions.ISO.ISO_3200, SettingsDefinitions.ISO.ISO_6400, SettingsDefinitions.ISO.ISO_12800, SettingsDefinitions.ISO.ISO_25600 };
          }
          return new SettingsDefinitions.ISO[] { SettingsDefinitions.ISO.ISO_100, SettingsDefinitions.ISO.ISO_200, SettingsDefinitions.ISO.ISO_400, SettingsDefinitions.ISO.ISO_800, SettingsDefinitions.ISO.ISO_1600, SettingsDefinitions.ISO.ISO_3200, SettingsDefinitions.ISO.ISO_6400, SettingsDefinitions.ISO.ISO_12800, SettingsDefinitions.ISO.ISO_25600, SettingsDefinitions.ISO.AUTO };
        }
      }
      else
      {
        if (SettingsDefinitions.ExposureMode.MANUAL == localExposureMode)
        {
          if (localCameraMode == SettingsDefinitions.CameraMode.RECORD_VIDEO) {
            return new SettingsDefinitions.ISO[] { SettingsDefinitions.ISO.ISO_100, SettingsDefinitions.ISO.ISO_200, SettingsDefinitions.ISO.ISO_400, SettingsDefinitions.ISO.ISO_800, SettingsDefinitions.ISO.ISO_1600, SettingsDefinitions.ISO.ISO_3200 };
          }
          if (localCameraMode == SettingsDefinitions.CameraMode.SHOOT_PHOTO) {
            return new SettingsDefinitions.ISO[] { SettingsDefinitions.ISO.ISO_100, SettingsDefinitions.ISO.ISO_200, SettingsDefinitions.ISO.ISO_400, SettingsDefinitions.ISO.ISO_800, SettingsDefinitions.ISO.ISO_1600 };
          }
          return new SettingsDefinitions.ISO[0];
        }
        localObject1 = new SettingsDefinitions.ISO[1];
        localObject1[0] = SettingsDefinitions.ISO.AUTO;
      }
    }
    return (SettingsDefinitions.ISO[])localObject1;
  }
  
  private SettingsDefinitions.PhotoFileFormat getImageFormat(int paramInt)
  {
    return null;
  }
  
  private static Object getKeyAvailableValue(DJISDKCacheKey paramDJISDKCacheKey)
  {
    paramDJISDKCacheKey = DJISDKCache.getInstance().getAvailableValue(paramDJISDKCacheKey);
    if (paramDJISDKCacheKey == null) {
      return null;
    }
    return paramDJISDKCacheKey.getData();
  }
  
  private static ResolutionAndFrameRate getResolutionAndFrameRate(int paramInt)
  {
    return (ResolutionAndFrameRate)getKeyAvailableValue(KeyHelper.getCameraKey(paramInt, "ResolutionFrameRate"));
  }
  
  private static SSDRawMode getSSDRawMode(int paramInt)
  {
    return (SSDRawMode)getKeyAvailableValue(KeyHelper.getCameraKey(paramInt, "ssdRawMode"));
  }
  
  public static SettingsDefinitions.VideoResolution[] getSSDVideoResolutionRange(int paramInt)
  {
    DJICameraEnumMappingUtil localDJICameraEnumMappingUtil = new DJICameraEnumMappingUtil();
    boolean bool = DJIComponentManager.getInstance().isAircraftConnected();
    ResolutionAndFrameRate localResolutionAndFrameRate = null;
    Object localObject = localResolutionAndFrameRate;
    if (bool)
    {
      ArrayList localArrayList = new ArrayList();
      DataCameraGetPushStateInfo.CameraType localCameraType = getCameraType(paramInt);
      if (localCameraType == null) {
        return null;
      }
      localObject = localResolutionAndFrameRate;
      if (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6520)
      {
        localObject = getSSDRawMode(paramInt);
        localResolutionAndFrameRate = getResolutionAndFrameRate(paramInt);
        if ((localObject != null) && (localResolutionAndFrameRate != null))
        {
          paramInt = localDJICameraEnumMappingUtil.getFrameRateProtocolValue(localResolutionAndFrameRate.getFrameRate());
          int i = 19.$SwitchMap$dji$internal$camera$SSDRawMode[localObject.ordinal()];
          if (i != 1)
          {
            if (i != 2)
            {
              if ((i == 3) && ((paramInt <= localDJICameraEnumMappingUtil.getFrameRateProtocolValue(SettingsDefinitions.VideoFrameRate.FRAME_RATE_30_FPS)) || (paramInt == localDJICameraEnumMappingUtil.getFrameRateProtocolValue(SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS)) || (paramInt == localDJICameraEnumMappingUtil.getFrameRateProtocolValue(SettingsDefinitions.VideoFrameRate.FRAME_RATE_30_FPS)))) {
                localArrayList.add(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160);
              }
            }
            else if ((paramInt <= localDJICameraEnumMappingUtil.getFrameRateProtocolValue(SettingsDefinitions.VideoFrameRate.FRAME_RATE_30_FPS)) || (paramInt == localDJICameraEnumMappingUtil.getFrameRateProtocolValue(SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS)))
            {
              localArrayList.add(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160);
              localArrayList.add(SettingsDefinitions.VideoResolution.RESOLUTION_5280x2160);
            }
          }
          else if ((paramInt > localDJICameraEnumMappingUtil.getFrameRateProtocolValue(SettingsDefinitions.VideoFrameRate.FRAME_RATE_30_FPS)) && (paramInt != localDJICameraEnumMappingUtil.getFrameRateProtocolValue(SettingsDefinitions.VideoFrameRate.FRAME_RATE_24_FPS)) && (paramInt != localDJICameraEnumMappingUtil.getFrameRateProtocolValue(SettingsDefinitions.VideoFrameRate.FRAME_RATE_30_FPS)))
          {
            if ((paramInt <= localDJICameraEnumMappingUtil.getFrameRateProtocolValue(SettingsDefinitions.VideoFrameRate.FRAME_RATE_60_FPS)) || (paramInt == localDJICameraEnumMappingUtil.getFrameRateProtocolValue(SettingsDefinitions.VideoFrameRate.FRAME_RATE_48_FPS)) || (paramInt == localDJICameraEnumMappingUtil.getFrameRateProtocolValue(SettingsDefinitions.VideoFrameRate.FRAME_RATE_60_FPS)))
            {
              localArrayList.add(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160);
              localArrayList.add(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160);
            }
          }
          else
          {
            localArrayList.add(SettingsDefinitions.VideoResolution.RESOLUTION_3840x2160);
            localArrayList.add(SettingsDefinitions.VideoResolution.RESOLUTION_4096x2160);
            localArrayList.add(SettingsDefinitions.VideoResolution.RESOLUTION_MAX);
          }
        }
        localArrayList.add(SettingsDefinitions.VideoResolution.NO_SSD_VIDEO);
        localObject = (SettingsDefinitions.VideoResolution[])localArrayList.toArray(new SettingsDefinitions.VideoResolution[localArrayList.size()]);
      }
    }
    return (SettingsDefinitions.VideoResolution[])localObject;
  }
  
  public static SettingsDefinitions.ShutterSpeed[] getShutterSpeedRange(int paramInt)
  {
    SettingsDefinitions.ExposureMode localExposureMode = getExposureMode(paramInt);
    Object localObject2 = null;
    if (localExposureMode == null) {
      return null;
    }
    Object localObject3 = getCameraMode(paramInt);
    if (localObject3 == null) {
      return null;
    }
    DataCameraGetPushStateInfo.CameraType localCameraType = getCameraType(paramInt);
    DJIComponentManager.PlatformType localPlatformType = DJIComponentManager.getInstance().getPlatformType();
    Object localObject1 = localObject2;
    if (DJIComponentManager.getInstance().isAircraftConnected()) {
      if (localExposureMode != SettingsDefinitions.ExposureMode.SHUTTER_PRIORITY)
      {
        localObject1 = localObject2;
        if (localExposureMode != SettingsDefinitions.ExposureMode.MANUAL) {}
      }
      else
      {
        int i = 19.$SwitchMap$dji$midware$component$DJIComponentManager$PlatformType[localPlatformType.ordinal()];
        if ((i != 3) && (i != 6))
        {
          if (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC220S) {
            localObject1 = defaultMavicShutterSpeedRange();
          } else if (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeGD600) {
            localObject1 = defaultGD600ShutterSpeedRange();
          } else {
            localObject1 = defaultAircraftRange();
          }
        }
        else {
          localObject1 = defaultHandheldRange();
        }
        localObject2 = localObject1;
        if (localObject3 == SettingsDefinitions.CameraMode.RECORD_VIDEO)
        {
          localObject3 = getResolutionAndFrameRate(paramInt);
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            localObject1 = pruneByVideoFrameRate((SettingsDefinitions.ShutterSpeed[])localObject1, ((ResolutionAndFrameRate)localObject3).getFrameRate());
            localObject2 = (SettingsDefinitions.ShutterSpeed[])((LinkedList)localObject1).toArray(new SettingsDefinitions.ShutterSpeed[((LinkedList)localObject1).size()]);
          }
        }
        localObject1 = localObject2;
        if (getTrackingMode(paramInt).booleanValue())
        {
          localObject1 = pruneByVideoFrameRate((SettingsDefinitions.ShutterSpeed[])localObject2, SettingsDefinitions.VideoFrameRate.FRAME_RATE_29_DOT_970_FPS);
          localObject1 = (SettingsDefinitions.ShutterSpeed[])((LinkedList)localObject1).toArray(new SettingsDefinitions.ShutterSpeed[((LinkedList)localObject1).size()]);
        }
      }
    }
    return (SettingsDefinitions.ShutterSpeed[])localObject1;
  }
  
  private static Boolean getTrackingMode(int paramInt)
  {
    return (Boolean)getKeyAvailableValue(KeyHelper.getCameraKey(paramInt, "CameraTrackingMode"));
  }
  
  private static SettingsDefinitions.VideoFileCompressionStandard getVideoFileCompressionStandard(int paramInt)
  {
    SettingsDefinitions.VideoFileCompressionStandard localVideoFileCompressionStandard = SettingsDefinitions.VideoFileCompressionStandard.H264;
    Object localObject = KeyHelper.getCameraKey(paramInt, "VideoFileCompressionStandard");
    localObject = DJISDKCache.getInstance().getAvailableValue((DJISDKCacheKey)localObject);
    if (localObject != null) {
      localVideoFileCompressionStandard = (SettingsDefinitions.VideoFileCompressionStandard)((DJISDKCacheParamValue)localObject).getData();
    }
    return localVideoFileCompressionStandard;
  }
  
  public static ResolutionAndFrameRate[] getVideoResolutionAndFrameRateRange(int paramInt)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = getCameraType(paramInt);
    if (localCameraType == null) {
      return null;
    }
    SettingsDefinitions.VideoStandard localVideoStandard = getVideoStandard(paramInt);
    if (localVideoStandard == null) {
      return null;
    }
    switch (19.$SwitchMap$dji$midware$data$model$P3$DataCameraGetPushStateInfo$CameraType[localCameraType.ordinal()])
    {
    case 10: 
    case 11: 
    default: 
      return null;
    case 17: 
      return getFC6520ResolutionAndFrameRateArray(localVideoStandard, getVideoFileCompressionStandard(paramInt));
    case 16: 
      return getFC6510ResolutionAndFrameRateArray(localVideoStandard, getVideoFileCompressionStandard(paramInt));
    case 15: 
      return getGD600ResolutionAndFrameRateArray(localVideoStandard);
    case 14: 
      return getFC6310ResolutionAndFrameRateArray(localVideoStandard, getVideoFileCompressionStandard(paramInt));
    case 13: 
      return getFC220SResolutionAndFrameRateArray(localVideoStandard);
    case 12: 
      return getFC220ResolutionAndFrameRateArray(localVideoStandard);
    case 9: 
      return getFC260ResolutionAndFrameRateArray(localVideoStandard);
    case 8: 
      return getFC300SResolutionAndFrameRateArray(localVideoStandard);
    case 6: 
    case 7: 
      return getCV600AndFC350ResolutionAndFrameRateArray(DJIComponentManager.getInstance().getPlatformType(), localVideoStandard);
    case 3: 
      return getFC330XResolutionAndFrameRateArray(localVideoStandard);
    case 2: 
    case 4: 
      return getFC300XAndFC300XWResolutionAndFrameRateArray(localVideoStandard);
    }
    return getFC550AndFC550RawResolutionAndFrameRateArray(localVideoStandard);
  }
  
  private static SettingsDefinitions.VideoStandard getVideoStandard(int paramInt)
  {
    return (SettingsDefinitions.VideoStandard)getKeyAvailableValue(KeyHelper.getCameraKey(paramInt, "VideoStandard"));
  }
  
  private boolean isDifferent(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return false;
  }
  
  private boolean isH1CameraForType(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    return false;
  }
  
  private static boolean isProductOrange(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    return (localProductType == ProductType.Orange) || (localProductType == ProductType.N1) || (localProductType == ProductType.BigBanana) || (localProductType == ProductType.Olives) || (localProductType == ProductType.OrangeRAW) || (localProductType == ProductType.OrangeCV600);
  }
  
  private static LinkedList<SettingsDefinitions.ShutterSpeed> pruneByVideoFrameRate(SettingsDefinitions.ShutterSpeed[] paramArrayOfShutterSpeed, SettingsDefinitions.VideoFrameRate paramVideoFrameRate)
  {
    paramArrayOfShutterSpeed = new LinkedList(Arrays.asList(paramArrayOfShutterSpeed));
    int i;
    switch (19.$SwitchMap$dji$common$camera$SettingsDefinitions$VideoFrameRate[paramVideoFrameRate.ordinal()])
    {
    default: 
      i = -1;
      break;
    case 8: 
      i = paramArrayOfShutterSpeed.indexOf(SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_100);
      break;
    case 7: 
      i = paramArrayOfShutterSpeed.indexOf(SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_120);
      break;
    case 6: 
      i = paramArrayOfShutterSpeed.indexOf(SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_60);
      break;
    case 4: 
    case 5: 
      i = paramArrayOfShutterSpeed.indexOf(SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_50);
      break;
    case 3: 
      i = paramArrayOfShutterSpeed.indexOf(SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_30);
      break;
    case 1: 
    case 2: 
      i = paramArrayOfShutterSpeed.indexOf(SettingsDefinitions.ShutterSpeed.SHUTTER_SPEED_1_25);
    }
    if ((i >= 0) && (i < paramArrayOfShutterSpeed.size())) {
      while (paramArrayOfShutterSpeed.size() > i + 1) {
        paramArrayOfShutterSpeed.removeLast();
      }
    }
    return paramArrayOfShutterSpeed;
  }
  
  public static boolean supportCameraFocus(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    return (!DJIUSBWifiSwitchManager.getInstance().isProductWifiConnected(null)) && ((paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550) || (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw) || (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC220) || (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeCV600) || (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC220S) || (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6310));
  }
  
  /* Error */
  private void triggerUpdateAll()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void updateApertureRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateCameraAntiFlickerRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateCameraDigitalFilterRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateCameraISORange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateCameraModeRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateCameraOrientationRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateCameraPhotoAspectRatioRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateCameraPhotoFileFormatRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateCameraVideoResolutionAndFrameRateRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateCameraWhiteBalanceCustomColorTemperatureRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateCameraWhiteBalancePresentRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateExposureCompensationRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateExposureModeRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateSSDVideoResolutionRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateShootPhotoModeChildRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateShootPhotoModeRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateShutterSpeedRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateVideoFileFormatRange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDestory()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\CameraParamRangeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */