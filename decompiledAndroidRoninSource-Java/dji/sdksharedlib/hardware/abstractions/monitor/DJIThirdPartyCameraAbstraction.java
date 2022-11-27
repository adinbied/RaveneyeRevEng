package dji.sdksharedlib.hardware.abstractions.monitor;

import dji.midware.data.model.P3.DataThirdPartyGetFrame;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.util.DJIEventBusUtil;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;

public class DJIThirdPartyCameraAbstraction
  extends DJISDKCacheHWAbstraction
{
  private static final String TAG = "TPCameraAbstraction";
  
  public void destroy()
  {
    DJIEventBusUtil.unRegister(this);
    super.destroy();
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("GetTable")
  public void getCameraParamTable(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("GetFrameInfo")
  public void getFrameInfo(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    DJIEventBusUtil.register(this);
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
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataThirdPartyCameraParamPush arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("SetParam")
  public void setCameraParam(DJISDKCacheHWAbstraction.InnerCallback arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("SetFrame")
  public void setFrame(DJISDKCacheHWAbstraction.InnerCallback arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("Subscribe")
  public void subscribeParamPush(DJISDKCacheHWAbstraction.InnerCallback arg1, dji.midware.data.model.hg702.CameraParamType arg2)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\monitor\DJIThirdPartyCameraAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */