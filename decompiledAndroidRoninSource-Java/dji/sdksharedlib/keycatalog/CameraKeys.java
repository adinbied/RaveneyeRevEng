package dji.sdksharedlib.keycatalog;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import dji.common.camera.CameraRecordingState;
import dji.common.camera.CameraSSDVideoLicense;
import dji.common.camera.CameraTapZoomTargetPoint;
import dji.common.camera.ExposureSettings;
import dji.common.camera.FocusAssistantSettings;
import dji.common.camera.PhotoTimeLapseSettings;
import dji.common.camera.ResolutionAndFrameRate;
import dji.common.camera.SSDCapacity;
import dji.common.camera.SSDOperationState;
import dji.common.camera.SettingsDefinitions.AntiFlickerFrequency;
import dji.common.camera.SettingsDefinitions.Aperture;
import dji.common.camera.SettingsDefinitions.CameraMode;
import dji.common.camera.SettingsDefinitions.CameraPhotoQuality;
import dji.common.camera.SettingsDefinitions.CustomSettingsProfile;
import dji.common.camera.SettingsDefinitions.DigitalFilter;
import dji.common.camera.SettingsDefinitions.ExposureCompensation;
import dji.common.camera.SettingsDefinitions.ExposureMode;
import dji.common.camera.SettingsDefinitions.FileIndexMode;
import dji.common.camera.SettingsDefinitions.FocusMode;
import dji.common.camera.SettingsDefinitions.FocusStatus;
import dji.common.camera.SettingsDefinitions.ISO;
import dji.common.camera.SettingsDefinitions.MeteringMode;
import dji.common.camera.SettingsDefinitions.OpticalZoomSpec;
import dji.common.camera.SettingsDefinitions.Orientation;
import dji.common.camera.SettingsDefinitions.PhotoAEBCount;
import dji.common.camera.SettingsDefinitions.PhotoAspectRatio;
import dji.common.camera.SettingsDefinitions.PhotoBurstCount;
import dji.common.camera.SettingsDefinitions.PhotoFileFormat;
import dji.common.camera.SettingsDefinitions.PhotoTimeIntervalSettings;
import dji.common.camera.SettingsDefinitions.PictureStylePreset;
import dji.common.camera.SettingsDefinitions.SSDVideoDigitalFilter;
import dji.common.camera.SettingsDefinitions.ShootPhotoMode;
import dji.common.camera.SettingsDefinitions.ShutterSpeed;
import dji.common.camera.SettingsDefinitions.StreamQuality;
import dji.common.camera.SettingsDefinitions.ThermalCustomExternalSceneSettingsProfile;
import dji.common.camera.SettingsDefinitions.ThermalDigitalZoomFactor;
import dji.common.camera.SettingsDefinitions.ThermalFFCMode;
import dji.common.camera.SettingsDefinitions.ThermalGainMode;
import dji.common.camera.SettingsDefinitions.ThermalIsothermUnit;
import dji.common.camera.SettingsDefinitions.ThermalPalette;
import dji.common.camera.SettingsDefinitions.ThermalProfile;
import dji.common.camera.SettingsDefinitions.ThermalROI;
import dji.common.camera.SettingsDefinitions.ThermalScene;
import dji.common.camera.SettingsDefinitions.VideoFileCompressionStandard;
import dji.common.camera.SettingsDefinitions.VideoFileFormat;
import dji.common.camera.SettingsDefinitions.VideoResolution;
import dji.common.camera.SettingsDefinitions.VideoStandard;
import dji.common.camera.SettingsDefinitions.WhiteBalancePreset;
import dji.common.camera.SettingsDefinitions.ZoomDirection;
import dji.common.camera.SettingsDefinitions.ZoomSpeed;
import dji.common.camera.ThermalAreaTemperatureAggregations;
import dji.common.camera.ThermalMeasurementMode;
import dji.common.camera.WhiteBalance;
import dji.common.flightcontroller.DJIMultiLEDControlMode;
import dji.internal.camera.SSDRawMode;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo.CameraType;
import dji.midware.data.model.P3.DataCameraSetVOutParams.LCDFormat;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.hardware.abstractions.camera.FoldingDrone.DJICameraFoldingDroneSAbstraction;
import dji.sdksharedlib.hardware.abstractions.camera.FoldingDrone.DJICameraFoldingDroneXAbstraction;
import dji.sdksharedlib.hardware.abstractions.camera.GD600.DJICameraGD600Abstraction;
import dji.sdksharedlib.hardware.abstractions.camera.phantom.DJICameraPhantom4PAbstraction;
import dji.sdksharedlib.hardware.abstractions.camera.zenmuse.DJICameraTau336Abstraction;
import dji.sdksharedlib.hardware.abstractions.camera.zenmuse.DJICameraTau640Abstraction;
import dji.sdksharedlib.hardware.abstractions.camera.zenmuse.DJICameraX3HandheldAbstraction;
import dji.sdksharedlib.hardware.abstractions.camera.zenmuse.DJICameraX4SAbstraction;
import dji.sdksharedlib.hardware.abstractions.camera.zenmuse.DJICameraX5Abstraction;
import dji.sdksharedlib.hardware.abstractions.camera.zenmuse.DJICameraX5BaseAbstraction;
import dji.sdksharedlib.hardware.abstractions.camera.zenmuse.DJICameraX5HandheldAbstraction;
import dji.sdksharedlib.hardware.abstractions.camera.zenmuse.DJICameraX5RAbstraction;
import dji.sdksharedlib.hardware.abstractions.camera.zenmuse.DJICameraX5RHandheldAbstraction;
import dji.sdksharedlib.hardware.abstractions.camera.zenmuse.DJICameraX5SAbstraction;
import dji.sdksharedlib.hardware.abstractions.camera.zenmuse.DJICameraZ3Abstraction;
import dji.sdksharedlib.hardware.abstractions.camera.zenmuse.DJICameraZ3HandheldAbstraction;
import dji.sdksharedlib.keycatalog.extension.IAbstractionGroup;
import dji.sdksharedlib.keycatalog.extension.Key;

public class CameraKeys
  extends DJISDKCacheKeys
{
  @Key(accessType=6, includedAbstractions={DJICameraX5SAbstraction.class}, type=CameraSSDVideoLicense.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String ACTIVATE_SSD_VIDEO_LICENSE = "ActivateSSDVideoLicense";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Boolean.class)
  public static final String AE_LOCK = "AELock";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.AntiFlickerFrequency.class)
  public static final String ANTI_FLICKER_FREQUENCY = "AntiFlickerFrequency";
  @Key(accessType=4, type=SettingsDefinitions.AntiFlickerFrequency[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String ANTI_FLICKER_RANGE = "CameraAntiFlickerRange";
  @Key(accessType=6, includedAbstractions={DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraGD600Abstraction.class, DJICameraX5SAbstraction.class, DJICameraX4SAbstraction.class, DJICameraPhantom4PAbstraction.class}, type=SettingsDefinitions.Aperture.class)
  public static final String APERTURE = "Aperture";
  @Key(accessType=4, includedAbstractions={DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class}, type=SettingsDefinitions.Aperture[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String APERTURE_RANGE = "ApertureRange";
  @Key(accessType=3, includedAbstractions={DJICameraX3HandheldAbstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraZ3HandheldAbstraction.class}, type=Integer.class)
  public static final String AUDIO_GAIN = "AudioGain";
  @Key(accessType=3, includedAbstractions={DJICameraX5HandheldAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraX3HandheldAbstraction.class, DJICameraZ3HandheldAbstraction.class}, type=Boolean.class)
  public static final String AUDIO_RECORDING_ENABLED = "AudioRecordingEnabled";
  @Key(accessType=6, includedAbstractions={DJICameraPhantom4PAbstraction.class, DJICameraX5SAbstraction.class, DJICameraX4SAbstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String AUTO_AE_UNLOCK_ENABLED = "AutoAEUnlockEnabled";
  @Key(accessType=4, type=DataCameraGetPushStateInfo.CameraType.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String CAMERA_TYPE = "CameraType";
  public static final String COMPONENT_KEY = "Camera";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Integer.class)
  public static final String CONTRAST = "Contrast";
  @Key(accessType=4, type=Integer.class)
  public static final String CURRENT_VIDEO_RECORDING_TIME_IN_SECONDS = "CurrentVideoRecordingTimeInSeconds";
  @Key(accessType=3, includedAbstractions={DJICameraGD600Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String DEFOG_ENABLED = "DefogEnabled";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.DigitalFilter.class)
  public static final String DIGITAL_FILTER = "DigitalFilter";
  @Key(accessType=4, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.DigitalFilter[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String DIGITAL_FILTER_RANGE = "DigitalFilterRange";
  @Key(accessType=3, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class, DJICameraX5SAbstraction.class, DJICameraX4SAbstraction.class}, type=Float.class)
  public static final String DIGITAL_ZOOM_FACTOR = "DigitalZoomFactor";
  @Key(accessType=7, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Float.class)
  public static final String DIGITAL_ZOOM_SCALE = "DigitalZoomScale";
  @Key(accessType=4, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String DISPLAY_NAME = "DisplayName";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ExposureCompensation.class)
  public static final String EXPOSURE_COMPENSATION = "ExposureCompensation";
  @Key(accessType=4, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ExposureCompensation[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String EXPOSURE_COMPENSATION_RANGE = "ExposureCompensationRange";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ExposureMode.class)
  public static final String EXPOSURE_MODE = "ExposureMode";
  @Key(accessType=4, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ExposureMode[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String EXPOSURE_MODE_RANGE = "ExposureModeRange";
  @Key(accessType=4, type=ExposureSettings.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String EXPOSURE_SETTINGS = "ExposureSettings";
  @Key(accessType=3, type=SettingsDefinitions.FileIndexMode.class)
  public static final String FILE_INDEX_MODE = "FileIndexMode";
  @Key(accessType=1, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FIRMWARE_VERSION = "FirmwareVersion";
  @Key(accessType=6, includedAbstractions={DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraZ3Abstraction.class, DJICameraZ3HandheldAbstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class, DJICameraPhantom4PAbstraction.class}, type=FocusAssistantSettings.class)
  public static final String FOCUS_ASSISTANT_SETTINGS = "FocusAssistantSettings";
  @Key(accessType=6, includedAbstractions={DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraZ3Abstraction.class, DJICameraZ3HandheldAbstraction.class, DJICameraGD600Abstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class, DJICameraPhantom4PAbstraction.class, DJICameraFoldingDroneXAbstraction.class}, type=SettingsDefinitions.FocusMode.class)
  public static final String FOCUS_MODE = "FocusMode";
  @Key(accessType=6, includedAbstractions={DJICameraZ3Abstraction.class, DJICameraZ3HandheldAbstraction.class, DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class, DJICameraPhantom4PAbstraction.class}, type=Integer.class)
  public static final String FOCUS_RING_VALUE = "FocusRingValue";
  @Key(accessType=1, includedAbstractions={DJICameraZ3Abstraction.class, DJICameraZ3HandheldAbstraction.class, DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class, DJICameraPhantom4PAbstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FOCUS_RING_VALUE_UPPER_BOUND = "FocusRingValueUpperBound";
  @Key(accessType=4, includedAbstractions={DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraZ3Abstraction.class, DJICameraZ3HandheldAbstraction.class, DJICameraGD600Abstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class}, type=SettingsDefinitions.FocusStatus.class)
  public static final String FOCUS_STATUS = "FocusStatus";
  @Key(accessType=6, includedAbstractions={DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraZ3Abstraction.class, DJICameraZ3HandheldAbstraction.class, DJICameraFoldingDroneSAbstraction.class, DJICameraFoldingDroneXAbstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class, DJICameraPhantom4PAbstraction.class}, type=PointF.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FOCUS_TARGET = "FocusTarget";
  @Key(accessType=8)
  public static final String FORMAT_SD_CARD = "FormatSDCard";
  @Key(accessType=8, includedAbstractions={DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FORMAT_SSD = "FormatSSD";
  @Key(accessType=1, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FULL_SERIAL_NUMBER_HASH = "FullSerialNumber";
  @Key(accessType=4, type=Boolean.class)
  public static final String HAS_ERROR = "HasError";
  @Key(accessType=3, includedAbstractions={DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class, DJICameraFoldingDroneXAbstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  @Deprecated
  public static final String HD_LIVE_VIEW_ENABLED = "HDLiveViewEnabled";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String HISTOGRAM_ENABLED = "HistogramEnabled";
  @Key(accessType=3, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Integer.class)
  public static final String HUE = "Hue";
  @Key(accessType=4, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Integer.class)
  public static final String INTERVAL_SHOOT_COUNTDOWN = "IntervalShootCountdown";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ISO.class)
  public static final String ISO = "ISO";
  @Key(accessType=4, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ISO[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String ISO_RANGE = "ISORange";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_ADJUSTABLE_APERTURE_SUPPORTED = "IsAdjustableApertureSupported";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_ADJUSTABLE_FOCAL_POINT_SUPPORTED = "IsAdjustableFocalPointSupported";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_AUDIO_RECORDING_SUPPORTED = "IsAudioRecordingSupported";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_DIGITAL_ZOOM_SUPPORTED = "IsDigitalZoomSupported";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_DOWNLOAD_BOKEH = "IsDownloadBokeh";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_INTERCHANGEABLE_LENS_SUPPORTED = "IsInterchangeableLensSupported";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_MEDIA_DOWNLOAD_MODE_SUPPORTED = "IsMediaDownloadModeSupported";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_MEDIA_DOWN_MODE_MAP_VALUE_2 = "isMediaDownModeMapValue2";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_OPTICAL_ZOOM_SUPPORTED = "IsOpticalZoomSupported";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_OVERHEATING = "isOverheating";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_PHOTO_QUICK_VIEW_SUPPORTED = "IsPhotoQuickViewSupported";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_PLAYBACK_SUPPORTED = "isPlaybackSupported";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_PSEUDO_CAMERA_SHOOTING = "IsPseudoCameraShooting";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_RECORDING = "IsRecording";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_SHOOTING_BURST_PHOTO = "IsShootingBurstPhoto";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_SHOOTING_INTERVAL_PHOTO = "IsShootingIntervalPhoto";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_SHOOTING_PHOTO = "IsShootingPhoto";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_SHOOTING_PHOTO_ENABLED = "IsShootPhotoEnabled";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_SHOOTING_RAWBURST_PHOTO = "IsShootingRawBurstPhoto";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_SHOOTING_RAW_BURST_PHOTO = "IsShootingRawBurstPhoto";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_SHOOTING_SINGLE_PHOTO = "IsShootingSinglePhoto";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_SHOOTING_SINGLE_PHOTO_IN_RAW_FORMAT = "IsShootingSinglePhotoInRAWFormat";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_SHOOT_ENABLED = "IsShootEnabled";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_SSD_SUPPORTED = "IsSSDSupported";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_STORING_PHOTO = "IsStoringPhoto";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_TAP_ZOOM_SUPPORTED = "isTapZoomSupported";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_THERMAL_CAMERA = "IsThermalCamera";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_TIME_LAPSE_SUPPORTED = "IsTimeLapseSupported";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_VIDEO_PLAYBACK_SUPPORTED = "isVideoPlaybackSupported";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String LAST_FILE_CREATE_TIME = "LastFileCreateTime";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String LAST_FILE_INDEX = "LastFileIndex";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String LAST_FILE_SUBINDEX = "LastFileSubIndex";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String LAST_FILE_TYPE = "LastFileType";
  @Key(accessType=6, includedAbstractions={DJICameraFoldingDroneSAbstraction.class, DJICameraFoldingDroneXAbstraction.class, DJICameraPhantom4PAbstraction.class, DJICameraX5SAbstraction.class, DJICameraX4SAbstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String LED_AUTO_TURN_OFF_ENABLED = "LEDAutoTurnOffEnabled";
  @Key(accessType=1, includedAbstractions={DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraGD600Abstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class}, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String LENS_INFORMATION = "LensInformation";
  @Key(accessType=4, includedAbstractions={DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class}, type=Boolean.class)
  public static final String LENS_IS_AF_SWITCH_ON = "LensIsAFSwitchOn";
  @Key(accessType=4, includedAbstractions={DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraZ3Abstraction.class, DJICameraZ3HandheldAbstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class, DJICameraPhantom4PAbstraction.class}, type=Boolean.class)
  public static final String LENS_IS_FOCUS_ASSISTANT_WORKING = "LensIsFocusAssistantWorking";
  @Key(accessType=4, includedAbstractions={DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class}, type=Boolean.class)
  public static final String LENS_IS_INSTALLED = "LensIsInstalled";
  @Key(accessType=3, includedAbstractions={DJICameraFoldingDroneSAbstraction.class, DJICameraFoldingDroneXAbstraction.class}, type=DataCameraSetVOutParams.LCDFormat.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String LIVE_VIEW_OUTPUT_MODE = "LiveViewOutputMode";
  @Key(accessType=8, types={SettingsDefinitions.CustomSettingsProfile.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String LOAD_SETTINGS_FROM_PROFILE = "LoadSettingsFromProfile";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.MeteringMode.class)
  public static final String METERING_MODE = "MeteringMode";
  @Key(accessType=6, type=SettingsDefinitions.CameraMode.class)
  public static final String MODE = "Mode";
  @Key(accessType=4, type=SettingsDefinitions.CameraMode[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String MODE_RANGE = "CameraModeRange";
  @Key(accessType=3, type=DJIMultiLEDControlMode.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String MULTI_LEDS_AUTO_ENABLED = "MultiLEDsAutoEnabled";
  @Key(accessType=8, includedAbstractions={DJICameraGD600Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String ONE_KEY_ZOOM = "OneKeyZoom";
  @Key(accessType=6, includedAbstractions={DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraZ3Abstraction.class, DJICameraZ3HandheldAbstraction.class, DJICameraGD600Abstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class, DJICameraPhantom4PAbstraction.class}, type=Integer.class)
  public static final String OPTICAL_ZOOM_FOCAL_LENGTH = "OpticalZoomFocalLength";
  @Key(accessType=4, includedAbstractions={DJICameraGD600Abstraction.class}, type=Float.class)
  public static final String OPTICAL_ZOOM_SCALE = "OpticalZoomScale";
  @Key(accessType=1, includedAbstractions={DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraZ3Abstraction.class, DJICameraZ3HandheldAbstraction.class, DJICameraGD600Abstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class, DJICameraPhantom4PAbstraction.class}, type=SettingsDefinitions.OpticalZoomSpec.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String OPTICAL_ZOOM_SPEC = "OpticalZoomSpec";
  @Key(accessType=3, type=SettingsDefinitions.Orientation.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String ORIENTATION = "Orientation";
  @Key(accessType=4, type=SettingsDefinitions.Orientation[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String ORIENTATION_RANGE = "CameraOrientationRange";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class, DJICameraGD600Abstraction.class}, type=SettingsDefinitions.PhotoAEBCount.class)
  public static final String PHOTO_AEB_COUNT = "PhotoAEBCount";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.PhotoAspectRatio.class)
  public static final String PHOTO_ASPECT_RATIO = "PhotoAspectRatio";
  @Key(accessType=4, type=SettingsDefinitions.PhotoAspectRatio[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PHOTO_ASPECT_RATIO_RANGE = "PhotoAspectRatioRange";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.PhotoBurstCount.class)
  public static final String PHOTO_BURST_COUNT = "PhotoBurstCount";
  @Key(accessType=6, type=SettingsDefinitions.PhotoFileFormat.class)
  public static final String PHOTO_FILE_FORMAT = "PhotoFileFormat";
  @Key(accessType=4, type=SettingsDefinitions.PhotoFileFormat[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PHOTO_FILE_FORMAT_RANGE = "PhotoFileFormatRange";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class, DJICameraGD600Abstraction.class}, type=SettingsDefinitions.CameraPhotoQuality.class)
  public static final String PHOTO_QUALITY = "PhotoQuality";
  @Key(accessType=3, type=Integer.class)
  public static final String PHOTO_QUICK_VIEW_DURATION = "PhotoQuickViewDuration";
  @Key(accessType=6, includedAbstractions={DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class}, type=SettingsDefinitions.PhotoBurstCount.class)
  public static final String PHOTO_RAW_BURST_COUNT = "PhotoRAWBurstCount";
  @Key(accessType=6, type=SettingsDefinitions.PhotoTimeIntervalSettings.class)
  public static final String PHOTO_TIME_INTERVAL_SETTINGS = "PhotoTimeIntervalSettings";
  @Key(accessType=3, includedAbstractions={DJICameraX5RHandheldAbstraction.class, DJICameraX3HandheldAbstraction.class, DJICameraZ3HandheldAbstraction.class}, type=PhotoTimeLapseSettings.class)
  public static final String PHOTO_TIME_LAPSE_SETTINGS = "PhotoTimeLapseSettings";
  @Key(accessType=6, type=SettingsDefinitions.PictureStylePreset.class)
  public static final String PICTURE_STYLE_PRESET = "PictureStylePreset";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String PROTOCOL_VERSION = "ProtocolVersion";
  @Key(accessType=4, type=Integer.class)
  public static final String RAWBURST_SHOOTING_COUNT = "RawBurstShootingCount";
  @Key(accessType=4, type=Integer.class)
  public static final String RAWBURST_SHOOT_NUMBER = "RawBurstShootNumber";
  @Key(accessType=4, includedAbstractions={DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class}, type=Integer.class)
  public static final String RAW_PHOTO_BURST_COUNT = "RAWPhotoBurstCount";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ShutterSpeed.class)
  public static final String REAL_SHUTTER_SPEED = "RealShutterSpeed";
  @Key(accessType=4, type=CameraRecordingState.class)
  public static final String RECORDING_STATE = "RecordingState";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class, DJICameraGD600Abstraction.class}, type=ResolutionAndFrameRate.class)
  public static final String RESOLUTION_FRAME_RATE = "ResolutionFrameRate";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RESTORE_FACTORY_SETTINGS = "restoreFactorySettings";
  @Key(accessType=3, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Integer.class)
  public static final String SATURATION = "Saturation";
  @Key(accessType=8, types={SettingsDefinitions.CustomSettingsProfile.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SAVE_SETTINGS_TO_PROFILE = "SaveSettingsToProfile";
  @Key(accessType=4, type=Long.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SDCARD_AVAILABLE_CAPTURE_COUNT = "SDCardAvailableCaptureCount";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SDCARD_AVAILABLE_RECORDING_TIME_IN_SECONDS = "SDCardAvailableRecordingTimeInSeconds";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SDCARD_HAS_ERROR = "SDCardHasError";
  public static final String SDCARD_IS_BUSY = "SDCardIsBusy";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SDCARD_IS_FORMATTED = "SDCardIsFormatted";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SDCARD_IS_FORMATTING = "SDCardIsFormatting";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SDCARD_IS_FULL = "SDCardIsFull";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SDCARD_IS_INITIALIZING = "SDCardIsInitializing";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SDCARD_IS_INSERTED = "SDCardIsInserted";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SDCARD_IS_INVALID_FORMAT = "SDCardIsInvalidFormat";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SDCARD_IS_READ_ONLY = "SDCardIsReadOnly";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SDCARD_IS_VERIFIED = "SDCardIsVerified";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SDCARD_REMAINING_SPACE_IN_MB = "SDCardRemainingSpaceInMB";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SDCARD_TOTAL_SPACE_IN_MB = "SDCardTotalSpaceInMB";
  @Key(accessType=1, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SERIAL_NUMBER = "SerialNumber";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Integer.class)
  public static final String SHARPNESS = "Sharpness";
  @Key(accessType=8, types={SettingsDefinitions.ShootPhotoMode.class, String.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SHOOT_PHOTO_BY_CACHING = "ShootPhotoByCaching";
  @Key(accessType=6, type=SettingsDefinitions.ShootPhotoMode.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SHOOT_PHOTO_MODE = "ShootPhotoMode";
  @Key(accessType=4, type=int[][].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SHOOT_PHOTO_MODE_CHILD_RANGE = "ShootPhotoChildRange";
  @Key(accessType=4, type=SettingsDefinitions.ShootPhotoMode[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SHOOT_PHOTO_MODE_RANGE = "ShootPhotoModeRange";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ShutterSpeed.class)
  public static final String SHUTTER_SPEED = "ShutterSpeed";
  @Key(accessType=4, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ShutterSpeed[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SHUTTER_SPEED_RANGE = "ShutterSpeedRange";
  @Key(accessType=3, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Point.class)
  public static final String SPOT_METERING_TARGET = "SpotMeteringTarget";
  @Key(accessType=4, includedAbstractions={DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class}, type=Integer.class)
  public static final String SSD_AVAILABLE_RECORDING_TIME_IN_SECONDS = "SSDAvailableRecordingTimeInSeconds";
  @Key(accessType=4, includedAbstractions={DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class}, type=Boolean.class)
  public static final String SSD_IS_CONNECTED = "SSDIsConnected";
  @Key(accessType=4, includedAbstractions={DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class}, type=SSDOperationState.class)
  public static final String SSD_OPERATION_STATE = "SSDOperationState";
  @Key(accessType=4, includedAbstractions={DJICameraX5BaseAbstraction.class}, type=SSDRawMode.class)
  public static final String SSD_RAW_MODE = "ssdRawMode";
  @Key(accessType=4, includedAbstractions={DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class}, type=Long.class)
  public static final String SSD_REMAINING_SPACE_IN_MB = "SSDRemainingSpaceInMB";
  @Key(accessType=4, includedAbstractions={DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class}, type=SSDCapacity.class)
  public static final String SSD_TOTAL_SPACE = "SSDTotalSpace";
  @Key(accessType=6, includedAbstractions={DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class}, type=SettingsDefinitions.SSDVideoDigitalFilter.class)
  public static final String SSD_VIDEO_DIGITAL_FILTER = "SSDVideoDigitalFilter";
  @Key(accessType=4, includedAbstractions={DJICameraX5Abstraction.class}, type=CameraSSDVideoLicense[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SSD_VIDEO_LICENSES = "SSDVideoLicenses";
  @Key(accessType=6, includedAbstractions={DJICameraX5SAbstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SSD_VIDEO_RECORDING_ENABLED = "SSDVideoRecordingEnabled";
  @Key(accessType=6, includedAbstractions={DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraX5SAbstraction.class}, type=ResolutionAndFrameRate.class)
  public static final String SSD_VIDEO_RESOLUTION_AND_FRAME_RATE = "SSDVideoResolutionAndFrameRate";
  @Key(accessType=4, type=SettingsDefinitions.VideoResolution[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SSD_VIDEO_RESOLUTION_RANGE = "SSDVideoResolutionRange";
  @Key(accessType=8, includedAbstractions={DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraZ3Abstraction.class, DJICameraZ3HandheldAbstraction.class, DJICameraGD600Abstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class}, types={SettingsDefinitions.ZoomDirection.class, SettingsDefinitions.ZoomSpeed.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String START_CONTINUOUS_OPTICAL_ZOOM = "StartContinuousOpticalZoom";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String START_RECORD_VIDEO = "StartRecordVideo";
  @Key(accessType=8, types={Boolean.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String START_RECORD_VIDEO_IN_CACHE = "StartRecordVideoInCache";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String START_SHOOT_PHOTO = "StartShootPhoto";
  @Key(accessType=8, includedAbstractions={DJICameraX5Abstraction.class, DJICameraX5HandheldAbstraction.class, DJICameraX5RAbstraction.class, DJICameraX5RHandheldAbstraction.class, DJICameraZ3Abstraction.class, DJICameraZ3HandheldAbstraction.class, DJICameraGD600Abstraction.class, DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String STOP_CONTINUOUS_OPTICAL_ZOOM = "StopContinuousOpticalZoom";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String STOP_RECORD_VIDEO = "StopRecordVideo";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String STOP_RECORD_VIDEO_IN_CACHE = "StopRecordVideoInCache";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String STOP_SHOOT_PHOTO = "StopShootPhoto";
  @Key(accessType=3, includedAbstractions={DJICameraX4SAbstraction.class, DJICameraX5SAbstraction.class}, type=SettingsDefinitions.StreamQuality.class)
  public static final String STREAM_QUALITY = "StreamQuality";
  @Key(accessType=2, includedAbstractions={DJICameraGD600Abstraction.class}, type=PointF.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String TAP_ZOOM_AT_TARGET = "TapZoomAtTarget";
  @Key(accessType=3, includedAbstractions={DJICameraGD600Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String TAP_ZOOM_ENABLED = "TapZoomEnabled";
  @Key(accessType=3, includedAbstractions={DJICameraGD600Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String TAP_ZOOM_MULTIPLIER = "TapZoomMultiplier";
  @Key(accessType=2, includedAbstractions={DJICameraGD600Abstraction.class}, type=CameraTapZoomTargetPoint.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String TAP_ZOOM_TARGET = "TapZoomTarget";
  @Key(accessType=4, includedAbstractions={DJICameraGD600Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String TAP_ZOOM_WORKING = "TapZoomWorking";
  @Key(accessType=3, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Integer.class)
  public static final String THERMAL_ACE = "ThermalACE";
  @Key(accessType=4, type=ThermalAreaTemperatureAggregations.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_AREA_TEMPERATURE_AGGREGATIONS = "ThermalAreaTemperatureAggregations";
  @Key(accessType=2, type=Short.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_ATMOSPHERIC_TEMPERATURE = "ThermalAtmosphericTemperature";
  @Key(accessType=2, type=Short.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_ATMOSPHERIC_TRANSMISSION_COEFFICIENT = "ThermalAtmosphericTransmissionCoefficient";
  @Key(accessType=2, type=Short.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_BACKGROUND_TEMPERATURE = "ThermalBackgroundTemperature";
  @Key(accessType=3, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Integer.class)
  public static final String THERMAL_BRIGHTNESS = "ThermalBrightness";
  @Key(accessType=3, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Integer.class)
  public static final String THERMAL_CONTRAST = "ThermalContrast";
  @Key(accessType=6, type=SettingsDefinitions.ThermalCustomExternalSceneSettingsProfile.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_CUSTOM_EXTERNAL_SCENE_SETTINGS_PROFILE = "ThermalCustomExternalSceneSettingsProfile";
  @Key(accessType=3, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Integer.class)
  public static final String THERMAL_DDE = "ThermalDDE";
  @Key(accessType=6, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ThermalDigitalZoomFactor.class)
  public static final String THERMAL_DIGITAL_ZOOM_FACTOR = "ThermalDigitalZoomFactor";
  @Key(accessType=6, type=SettingsDefinitions.ThermalFFCMode.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_FFC_MODE = "ThermalFFCMode";
  @Key(accessType=6, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ThermalGainMode.class)
  public static final String THERMAL_GAIN_MODE = "ThermalGainMode";
  @Key(accessType=6, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Boolean.class)
  public static final String THERMAL_ISOTHERM_ENABLED = "ThermalIsothermEnabled";
  @Key(accessType=6, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Integer.class)
  public static final String THERMAL_ISOTHERM_LOWER_VALUE = "ThermalIsothermLowerValue";
  @Key(accessType=6, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Integer.class)
  public static final String THERMAL_ISOTHERM_MIDDLE_VALUE = "ThermalIsothermMiddleValue";
  @Key(accessType=6, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ThermalIsothermUnit.class)
  public static final String THERMAL_ISOTHERM_UNIT = "ThermalIsothermUnit";
  @Key(accessType=6, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Integer.class)
  public static final String THERMAL_ISOTHERM_UPPER_VALUE = "ThermalIsothermUpperValue";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_IS_FFC_MODE_SUPPORTED = "ThermalIsFFCModeSupported";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_IS_OVERALL_TEMPERATURE_METER_SUPPORTED = "ThermalIsOverallTemperatureMeterSupported";
  @Key(accessType=3, type=ThermalMeasurementMode.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_MEASUREMENT_MODE = "ThermalMeasurementMode";
  @Key(accessType=6, type=RectF.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_METERING_AREA = "ThermalMeteringArea";
  @Key(accessType=6, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ThermalPalette.class)
  public static final String THERMAL_PALETTE = "ThermalPalette";
  @Key(accessType=4, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ThermalProfile.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String THERMAL_PROFILE = "ThermalProfile";
  @Key(accessType=6, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ThermalROI.class)
  public static final String THERMAL_ROI = "ThermalROI";
  @Key(accessType=6, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.ThermalScene.class)
  public static final String THERMAL_SCENE = "ThermalScene";
  @Key(accessType=2, type=Short.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_SCENE_EMISSIVITY = "ThermalSceneEmissivity";
  @Key(accessType=6, type=PointF.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_SPOT_METERING_TARGET_POINT = "ThermalSpotMeteringTargetPoint";
  @Key(accessType=3, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Integer.class)
  public static final String THERMAL_SSO = "ThermalSSO";
  @Key(accessType=5, includedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=Float.class)
  public static final String THERMAL_TEMPERATURE_DATA = "ThermalTemperatureData";
  @Key(accessType=2, type=Short.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_WINDOW_REFLECTED_TEMPERATURE = "ThermalWindowReflectedTemperature";
  @Key(accessType=2, type=Short.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_WINDOW_REFLECTION = "ThermalWindowReflection";
  @Key(accessType=2, type=Short.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_WINDOW_TEMPERATURE = "ThermalWindowTemperature";
  @Key(accessType=2, type=Short.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String THERMAL_WINDOW_TRANSMISSION_COEFFICIENT = "ThermalWindowTransmissionCoefficient";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String TRACKING_MODE = "CameraTrackingMode";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String TRIGGER_THERMAL_FFC = "TriggerThermalFFC";
  @Key(accessType=3, includedAbstractions={DJICameraX3HandheldAbstraction.class, DJICameraZ3HandheldAbstraction.class}, type=Boolean.class)
  public static final String TURN_OFF_FAN_WHEN_POSSIBLE = "TurnOffFanWhenPossible";
  @Key(accessType=3, type=Boolean.class)
  public static final String VIDEO_CAPTION_ENABLED = "VideoCaptionEnabled";
  @Key(accessType=6, includedAbstractions={DJICameraPhantom4PAbstraction.class, DJICameraX5SAbstraction.class, DJICameraX4SAbstraction.class}, type=SettingsDefinitions.VideoFileCompressionStandard.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String VIDEO_FILE_COMPRESSION_STANDARD = "VideoFileCompressionStandard";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=SettingsDefinitions.VideoFileFormat.class)
  public static final String VIDEO_FILE_FORMAT = "VideoFileFormat";
  @Key(accessType=4, type=SettingsDefinitions.VideoFileFormat[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String VIDEO_FILE_FORMAT_RANGE = "VideoFileFormatRange";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=ResolutionAndFrameRate[].class)
  public static final String VIDEO_RESOLUTION_FRAME_RATE_RANGE = "VideoResolutionFrameRateRange";
  @Key(accessType=6, type=SettingsDefinitions.VideoStandard.class)
  public static final String VIDEO_STANDARD = "VideoStandard";
  @Key(accessType=6, excludedAbstractions={DJICameraTau336Abstraction.class, DJICameraTau640Abstraction.class}, type=WhiteBalance.class)
  public static final String WHITE_BALANCE = "WhiteBalance";
  @Key(accessType=4, type=int[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String WHITE_BALANCE_CUSTOM_COLOR_TEMPERATURE_RANGE = "WhiteBalanceCustomColorTemperatureRange";
  @Key(accessType=4, type=SettingsDefinitions.WhiteBalancePreset[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String WHITE_BALANCE_PRESENT_RANGE = "WhiteBalancePresentRange";
  
  public CameraKeys(String paramString)
  {
    super(paramString);
  }
  
  protected String getDefaultAbstractionName()
  {
    return "Camera";
  }
  
  private static class DSLRGroup
    implements IAbstractionGroup
  {
    public Class[] getAbstractions()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\CameraKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */