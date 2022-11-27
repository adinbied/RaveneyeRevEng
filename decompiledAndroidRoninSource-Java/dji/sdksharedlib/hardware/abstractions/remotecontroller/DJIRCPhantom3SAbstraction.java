package dji.sdksharedlib.hardware.abstractions.remotecontroller;

import dji.common.remotecontroller.HardwareState;
import dji.common.remotecontroller.HardwareState.Button;
import dji.common.remotecontroller.HardwareState.RightWheel;
import dji.common.remotecontroller.HardwareState.TransformationSwitch;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;

public class DJIRCPhantom3SAbstraction
  extends DJIRCAbstraction
{
  public DJIRCPhantom3SAbstraction()
  {
    this.hardwareState.getC1Button().setPresent(false);
    this.hardwareState.getC2Button().setPresent(false);
    this.hardwareState.getGoHomeButton().setPresent(false);
    this.hardwareState.getPlaybackButton().setPresent(false);
    this.hardwareState.getRecordButton().setPresent(false);
    this.hardwareState.getRightWheel().setPresent(false);
    this.hardwareState.getShutterButton().setPresent(false);
    this.hardwareState.getTransformationSwitch().setPresent(false);
  }
  
  protected String getComponentDisplayName()
  {
    return "Phantom 3S Remote Controller";
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\remotecontroller\DJIRCPhantom3SAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */