package dji.sdksharedlib.hardware.abstractions.battery;

import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import org.greenrobot.eventbus.EventBus;

public class NonSmartBatteryAbstraction
  extends BatteryAbstraction
{
  public NonSmartBatteryAbstraction()
  {
    this.isSmartBattery = false;
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataFlycGetPushSmartBattery arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\battery\NonSmartBatteryAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */