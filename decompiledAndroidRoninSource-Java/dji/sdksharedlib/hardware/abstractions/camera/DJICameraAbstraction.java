package dji.sdksharedlib.hardware.abstractions.camera;

import dji.common.camera.CameraParamRangeManager;
import dji.common.camera.SettingsDefinitions.ShootPhotoMode;
import dji.common.error.DJICameraError;
import dji.common.util.CallbackUtils;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo.CameraType;
import dji.midware.data.model.P3.DataCameraSetPhotoMode;
import dji.midware.data.model.P3.DataCommonGetVersion;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.util.DoubleCameraSupportUtil;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;

public class DJICameraAbstraction
  extends DJISDKCacheHWAbstraction
{
  public static final String DisplayNameMavicProCamera = "Mavic Pro Camera";
  public static final String DisplayNamePhantom34KCamera = "Phantom 3 4K Camera";
  public static final String DisplayNamePhantom3AdvancedCamera = "Phantom 3 Advanced Camera";
  public static final String DisplayNamePhantom3ProfessionalCamera = "Phantom 3 Professional Camera";
  public static final String DisplayNamePhantom3StandardCamera = "Phantom 3 Standard Camera";
  public static final String DisplayNamePhantom4Camera = "Phantom 4 Camera";
  public static final String DisplayNameX3 = "Zenmuse X3";
  public static final String DisplayNameX4S = "Zenmuse X4S";
  public static final String DisplayNameX5 = "Zenmuse X5";
  public static final String DisplayNameX5R = "Zenmuse X5R";
  public static final String DisplayNameX5S = "Zenmuse X5S";
  public static final String DisplayNameXT336 = "Zenmuse XT";
  public static final String DisplayNameXT640 = "Zenmuse XT";
  public static final String DisplayNameZ3 = "Zenmuse Z3";
  public static final String DisplayNameZ30 = "Zenmuse Z30";
  public static final String DisplaynamePhantom4ProCamera = "Phantom 4 Professional Camera";
  private static final String TAG = "DJISDKCacheCameraAbstraction";
  private CameraParamRangeManager cameraParamRangeManager;
  protected DataCameraGetPushStateInfo.CameraType cameraType = DataCameraGetPushStateInfo.CameraType.OTHER;
  protected int index = 0;
  protected int recordTimeInSec = 0;
  protected Timer recordTimeTimer;
  
  private boolean checkNeedUpdate()
  {
    return false;
  }
  
  private boolean checkValueInArray(int[] paramArrayOfInt, int paramInt)
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
  @dji.sdksharedlib.hardware.abstractions.Action("FormatSDCard")
  public void formatSDCard(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected String getDisplayName()
  {
    return "";
  }
  
  protected int getExpectedSenderIdByIndex()
  {
    return DoubleCameraSupportUtil.getCameraIdInProtocol(this.index);
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("FirmwareVersion")
  public void getFirmwareVersion(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected int getReceiverIdByIndex()
  {
    return DoubleCameraSupportUtil.getCameraIdInProtocol(this.index);
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    this.index = paramInt;
    this.cameraParamRangeManager = new CameraParamRangeManager(paramOnValueChangeListener, this.defaultKeyPath);
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
  protected void initializeCustomizedKey()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isAFSupported()
  {
    return false;
  }
  
  protected boolean isAFTargetSupported()
  {
    return false;
  }
  
  protected boolean isAdjustableApertureSupported()
  {
    return false;
  }
  
  protected boolean isAdjustableFocalPointSupported()
  {
    return false;
  }
  
  protected boolean isAudioRecordSupported()
  {
    return false;
  }
  
  protected boolean isBroadcastModeSupported()
  {
    return false;
  }
  
  protected boolean isChangeableLensSupported()
  {
    return false;
  }
  
  protected boolean isDigitalZoomScaleSupported()
  {
    return false;
  }
  
  protected boolean isHDRPhotoSupported()
  {
    return true;
  }
  
  protected boolean isHandHeldProduct()
  {
    return false;
  }
  
  protected boolean isMFSupported()
  {
    return false;
  }
  
  protected boolean isMediaDownModeMapValue2()
  {
    return false;
  }
  
  protected boolean isMediaDownloadModeSupported()
  {
    return false;
  }
  
  protected boolean isOpticalZoomScaleSupported()
  {
    return false;
  }
  
  protected boolean isOpticalZoomSupported()
  {
    return false;
  }
  
  protected boolean isOverallTemperatureMeterSupported()
  {
    return false;
  }
  
  protected boolean isPhotoQuickViewSupported()
  {
    return true;
  }
  
  protected boolean isPlaybackSupported()
  {
    return false;
  }
  
  protected boolean isSSDSupported()
  {
    return false;
  }
  
  protected boolean isShootPhotoRawBurstSupported()
  {
    return false;
  }
  
  protected boolean isSlowMotionSupported()
  {
    return false;
  }
  
  protected boolean isTapZoomSupported()
  {
    return false;
  }
  
  protected boolean isTau336Camera()
  {
    return false;
  }
  
  protected boolean isTau640Camera()
  {
    return false;
  }
  
  protected boolean isThermalFFCModeSupported()
  {
    return false;
  }
  
  public boolean isThermalImagingCamera()
  {
    return false;
  }
  
  protected boolean isTimeLapseSupported()
  {
    return false;
  }
  
  protected boolean isTurnOffFanSupported()
  {
    return false;
  }
  
  protected boolean isValidSender(int paramInt)
  {
    return false;
  }
  
  protected boolean isVideoPlaybackSupported()
  {
    return false;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.internal.version.DJIVersionCamera arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataCameraGetPushRecordingName arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataCameraGetPushStateInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataEyeGetPushPseudoCameraParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.media.event.BokehEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected DataCameraSetPhotoMode prepareShootPhotoMode(SettingsDefinitions.ShootPhotoMode paramShootPhotoMode)
  {
    return null;
  }
  
  /* Error */
  protected void startRecordTimeTimer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("StartShootPhoto")
  public void startShootPhoto(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void startShootPhoto(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback, SettingsDefinitions.ShootPhotoMode paramShootPhotoMode)
  {
    CallbackUtils.onFailure(paramInnerCallback, DJICameraError.COMMON_UNSUPPORTED);
  }
  
  /* Error */
  protected void stopRecordTimeTimer()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\DJICameraAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */