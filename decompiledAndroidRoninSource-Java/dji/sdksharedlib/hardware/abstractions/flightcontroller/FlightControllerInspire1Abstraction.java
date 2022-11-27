package dji.sdksharedlib.hardware.abstractions.flightcontroller;

import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataFlycFunctionControl.FLYC_COMMAND;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.Action;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;

public class FlightControllerInspire1Abstraction
  extends FlightControllerAbstraction
{
  private static final String PARAM_NAME_AUTO_LANDING_GEAR = "g_config.gear_cfg.auto_control_enable_0";
  
  @Action("DeployLandingGear")
  public void deployLandingGear(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    sendFlightControllerCommand(DataFlycFunctionControl.FLYC_COMMAND.DownDeform, paramInnerCallback);
  }
  
  /* Error */
  @Action("EnterTransportMode")
  public void enterTransportMode(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Action("ExitTransportMode")
  public void exitTransportMode(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    sendFlightControllerCommand(DataFlycFunctionControl.FLYC_COMMAND.UnPackMode, paramInnerCallback);
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("LandingGearAutomaticMovementEnabled")
  public void getAutomaticMovementEnabled(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void initFlightControllerSupportParameter()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void initializeComponentCharacteristics()
  {
    super.initializeComponentCharacteristics();
  }
  
  protected boolean isNewProgressOfActivation()
  {
    return false;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataFlycGetPushDeformStatus arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Action("RetractLandingGear")
  public void retractLandingGear(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    sendFlightControllerCommand(DataFlycFunctionControl.FLYC_COMMAND.UpDeform, paramInnerCallback);
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("LandingGearAutomaticMovementEnabled")
  public void setAutomaticMovementEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\flightcontroller\FlightControllerInspire1Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */