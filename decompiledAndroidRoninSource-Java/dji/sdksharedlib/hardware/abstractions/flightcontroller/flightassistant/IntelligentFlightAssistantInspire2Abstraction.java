package dji.sdksharedlib.hardware.abstractions.flightcontroller.flightassistant;

import dji.common.mission.activetrack.ActiveTrackMode;
import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataSingleVisualParam.TrackingMode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;

public class IntelligentFlightAssistantInspire2Abstraction
  extends IntelligentFlightAssistant1860Abstraction
{
  protected DataSingleVisualParam.TrackingMode convertModeToTrackingMode(ActiveTrackMode paramActiveTrackMode)
  {
    return null;
  }
  
  protected ActiveTrackMode convertTrackingModeToMode(DataSingleVisualParam.TrackingMode paramTrackingMode)
  {
    return null;
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("stabilization")
  public void enableStabilization(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataEyeGetPushTrackStatus arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("setActiveTrackCamera")
  public void setActiveTrackCamera(dji.midware.data.model.P3.DataCameraGetPushStateInfo.CameraType arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setActiveTrackMode(ActiveTrackMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\flightcontroller\flightassistant\IntelligentFlightAssistantInspire2Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */