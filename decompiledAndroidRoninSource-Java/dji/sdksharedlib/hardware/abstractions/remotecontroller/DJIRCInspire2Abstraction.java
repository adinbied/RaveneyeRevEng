package dji.sdksharedlib.hardware.abstractions.remotecontroller;

import dji.common.remotecontroller.AuthorizationInfo;
import dji.common.remotecontroller.HardwareState;
import dji.common.remotecontroller.HardwareState.Button;
import dji.common.remotecontroller.HardwareState.RightWheel;
import dji.common.remotecontroller.HardwareState.TransformationSwitch;
import dji.midware.data.model.P3.DataRcMasterSlaveId;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import java.util.List;

public class DJIRCInspire2Abstraction
  extends DJIRCAbstraction
{
  public DJIRCInspire2Abstraction()
  {
    this.supportMasterSlaveModeV2 = true;
    this.remoteFocusCheckingSupported = true;
    this.hardwareState.getC1Button().setPresent(true);
    this.hardwareState.getC2Button().setPresent(true);
    this.hardwareState.getGoHomeButton().setPresent(true);
    this.hardwareState.getPlaybackButton().setPresent(true);
    this.hardwareState.getRecordButton().setPresent(true);
    this.hardwareState.getRightWheel().setPresent(true);
    this.hardwareState.getShutterButton().setPresent(true);
    this.hardwareState.getTransformationSwitch().setPresent(true);
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("GetMasterAuthCode")
  public void getAuthCodeFromMaster(DJISDKCacheHWAbstraction.InnerCallback arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getChargeMobileMode(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("MasterList")
  public void getMasterList(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("MasterSlaveID")
  public void getMasterSlaveId(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("connectToMasterWithID")
  public void joinMasterWithID(DJISDKCacheHWAbstraction.InnerCallback arg1, AuthorizationInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataWifiGetPushMasterSlaveStatus arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("SetMasterAuthCode")
  public void setMasterAuthCode(String arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("MasterSlaveID")
  public void setMasterSlaveId(String arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\remotecontroller\DJIRCInspire2Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */