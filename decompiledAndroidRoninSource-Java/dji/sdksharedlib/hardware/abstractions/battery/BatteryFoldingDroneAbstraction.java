package dji.sdksharedlib.hardware.abstractions.battery;

import dji.midware.data.model.P3.DataSmartBatteryGetPushCellVoltage;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.battery.merge.M600MergeGetDynamicData;
import dji.sdksharedlib.hardware.abstractions.battery.merge.M600MergeGetSingleStaticData;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;

public class BatteryFoldingDroneAbstraction
  extends BatterySmartAbstraction
{
  private static String TAG = "DJIBatteryFoldingDroneAbstraction";
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("CellVoltages")
  public void getCellVoltages(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    this.index = 0;
    this.numberOfCell = 3;
    this.isSmartBattery = true;
    this.mergeGetDynamicData = new M600MergeGetDynamicData(Integer.MAX_VALUE);
    this.mergeGetSingleStaticData = new M600MergeGetSingleStaticData(Integer.MAX_VALUE);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\battery\BatteryFoldingDroneAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */