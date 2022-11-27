package dji.sdksharedlib.hardware.abstractions.remotecontroller;

import dji.common.remotecontroller.HardwareState;
import dji.common.remotecontroller.HardwareState.Button;
import dji.common.remotecontroller.HardwareState.RightWheel;
import dji.common.remotecontroller.HardwareState.TransformationSwitch;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;

public class DJIRCInspire1Abstraction
  extends DJIRCAbstraction
{
  public DJIRCInspire1Abstraction()
  {
    this.supportMasterSlaveMode = true;
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
  
  protected String getComponentDisplayName()
  {
    return "Inspire 1 Remote Controller";
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\remotecontroller\DJIRCInspire1Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */