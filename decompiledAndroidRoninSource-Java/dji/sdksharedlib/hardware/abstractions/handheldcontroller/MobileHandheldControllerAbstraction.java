package dji.sdksharedlib.hardware.abstractions.handheldcontroller;

import dji.common.error.DJIError;
import dji.common.handheld.LEDColorPattern;
import dji.common.handheld.LEDCommand;
import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.Getter;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;

public class MobileHandheldControllerAbstraction
  extends HandheldControllerAbstraction
{
  private Timer changeButtonStatusTimer;
  private TimerTask changeButtonStatusToIdle;
  private long lastDoubleClickTime = 0L;
  private long lastSingleClickTime = 0L;
  private long lastTripleClickTime = 0L;
  
  private int getSequence(ArrayList<Boolean> paramArrayList)
  {
    return 0;
  }
  
  private boolean parseCommand(LEDColorPattern paramLEDColorPattern)
  {
    return false;
  }
  
  private boolean verifyLEDCommand(LEDCommand paramLEDCommand)
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
  @Getter("HandheldName")
  public void getHandheldName(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Getter("SerialNumber")
  public void getSerialNumber(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.COMMON_UNSUPPORTED);
    }
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
  }
  
  protected void initializeComponentCharacteristics()
  {
    super.initializeComponentCharacteristics();
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataCameraGetPushShutterCmd arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataGimbalGetPushHandheldStickState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.ASYNC)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataGimbalGetPushParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("LEDCommand")
  public void performControlLED(DJISDKCacheHWAbstraction.InnerCallback arg1, LEDCommand arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("HandheldName")
  public void setHandheldName(String arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("StickGimbalControlEnabled")
  public void setIsInternalAndExternalMicroPhonesEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\handheldcontroller\MobileHandheldControllerAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */