package dji.sdksharedlib.hardware.abstractions.remotecontroller;

import dji.common.error.DJIError;
import dji.common.remotecontroller.HardwareState;
import dji.common.remotecontroller.HardwareState.Builder;
import dji.common.remotecontroller.HardwareState.Button;
import dji.common.remotecontroller.HardwareState.RightWheel;
import dji.common.remotecontroller.HardwareState.TransformationSwitch;
import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.remotecontroller.merge.CalibrationStatusMergeGet;
import dji.sdksharedlib.hardware.extension.DJISDKCacheCommonMergeCallback;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;

public class DJIRCFoldingDroneAbstraction
  extends DJIRCAbstraction
{
  private static final int CALIBRATION_INTERVAL = 500;
  private CalibrationStatusMergeGet calibrationStatusMergeGet;
  private HardwareState.Builder hardwareBuilder = new HardwareState.Builder();
  
  public DJIRCFoldingDroneAbstraction()
  {
    this.hardwareState.getC1Button().setPresent(true);
    this.hardwareState.getC2Button().setPresent(true);
    this.hardwareState.getGoHomeButton().setPresent(true);
    this.hardwareState.getPauseButton().setPresent(true);
    this.hardwareState.getPlaybackButton().setPresent(true);
    this.hardwareState.getRecordButton().setPresent(true);
    this.hardwareState.getRightWheel().setPresent(true);
    this.hardwareState.getShutterButton().setPresent(true);
    this.hardwareState.getTransformationSwitch().setPresent(false);
  }
  
  /* Error */
  private void notifyAllCallbacks(java.util.ArrayList<DJISDKCacheHWAbstraction.InnerCallback> arg1, Object arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("RemoteControllerCalibration")
  public void RemoteControllerCalibration(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void destroy()
  {
    super.destroy();
    this.calibrationStatusMergeGet = null;
  }
  
  protected String getComponentDisplayName()
  {
    return "Mavic Pro Radio Remote Controller";
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("RemoteControllerAAxisStatus")
  public void getRemoteControllerCalibrationAAxisStatus(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("RemoteControllerBAxisStatus")
  public void getRemoteControllerCalibrationBAxisStatus(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("RemoteControllerCAxisStatus")
  public void getRemoteControllerCalibrationCAxisStatus(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("RemoteControllerDAxisStatus")
  public void getRemoteControllerCalibrationDAxisStatus(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("RemoteControllerEAxisStatus")
  public void getRemoteControllerCalibrationEAxisStatus(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("RemoteControllerFAxisStatus")
  public void getRemoteControllerCalibrationFAxisStatus(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("RemoteControllerGAxisStatus")
  public void getRemoteControllerCalibrationGAxisStatus(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("RemoteControllerHAxisStatus")
  public void getRemoteControllerCalibrationHAxisStatus(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("RemoteControllerCalibrationNumberOfFragment")
  public void getRemoteControllerCalibrationSegmentNumber(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    this.calibrationStatusMergeGet = new CalibrationStatusMergeGet();
    this.hardwareState.getC1Button().setPresent(true);
    this.hardwareState.getC2Button().setPresent(true);
    this.hardwareState.getGoHomeButton().setPresent(true);
    this.hardwareState.getRecordButton().setPresent(true);
    this.hardwareState.getRightWheel().setPresent(true);
    this.hardwareState.getShutterButton().setPresent(true);
    this.hardwareState.getTransformationSwitch().setPresent(false);
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
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataRcGetFDPushConnectStatus arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataRcGetPushRcCustomButtonsStatus arg1)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\remotecontroller\DJIRCFoldingDroneAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */