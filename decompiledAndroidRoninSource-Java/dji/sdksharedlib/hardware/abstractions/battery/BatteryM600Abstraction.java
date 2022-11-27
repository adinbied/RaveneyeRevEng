package dji.sdksharedlib.hardware.abstractions.battery;

import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.battery.merge.M600MergeGetDynamicData;
import dji.sdksharedlib.hardware.abstractions.battery.merge.M600MergeGetSingleStaticData;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;

public class BatteryM600Abstraction
  extends BatterySmartAbstraction
{
  private static String TAG = "DJISDKCacheM600BatteryAbstraction";
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    this.index = paramInt;
    this.numberOfCell = 6;
    this.isSmartBattery = true;
    this.mergeGetDynamicData = new M600MergeGetDynamicData(paramInt);
    this.mergeGetSingleStaticData = new M600MergeGetSingleStaticData(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\battery\BatteryM600Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */