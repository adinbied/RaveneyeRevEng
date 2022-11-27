package dji.sdksharedlib.hardware.abstractions.battery;

import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;

public class DJIBatteryRoninsAbstraction
  extends BatterySmartAbstraction
{
  public static final int RECEIVER_ID = 7;
  private static final int SENDER_TYPE_CENTER = 5;
  private static final int SENDER_TYPE_OFDM = 9;
  private static final String TAG = "BatteryRoninsAbstraction";
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onCenterBatteryPushEvent(dji.midware.data.model.P3.DataCenterGetPushBatteryCommon arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataSmartBatteryGetPushDynamicData arg1)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\battery\DJIBatteryRoninsAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */