package dji.sdksharedlib.hardware.abstractions.battery;

import dji.midware.data.model.P3.DataCommonGetVersion;
import dji.midware.data.model.P3.DataSmartBatteryGetHistory;
import dji.midware.data.model.P3.DataSmartBatteryGetPushCellVoltage;
import dji.midware.data.model.P3.DataSmartBatteryGetPushDynamicData;
import dji.midware.data.model.P3.DataSmartBatteryGetSetSelfDischargeDays;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.battery.merge.M600DynamicDataCallback;
import dji.sdksharedlib.hardware.abstractions.battery.merge.M600MergeGetDynamicData;
import dji.sdksharedlib.hardware.abstractions.battery.merge.M600MergeGetSingleStaticData;
import dji.sdksharedlib.hardware.abstractions.battery.merge.M600SingleStaticDataCallback;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;

public class BatterySmartAbstraction
  extends BatteryAbstraction
{
  public final String TAG = "DJISDKCacheSmartBatteryAbstraction";
  protected int index = 0;
  protected M600MergeGetDynamicData mergeGetDynamicData;
  protected M600MergeGetSingleStaticData mergeGetSingleStaticData;
  
  public void destroy()
  {
    super.destroy();
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("BatteryCellVoltageForFR")
  public void getAggregationBatteryCellVoltageForFR(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("BatteryDynamicInfoForFR")
  public void getAggregationBatteryDynamicInfoForFR(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("CellVoltages")
  public void getCellVoltages(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("ChargeRemaining")
  public void getChargeRemaining(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("ChargeRemainingInPercent")
  public void getChargeRemainingInPercent(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("Current")
  public void getCurrent(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("FullChargeCapacity")
  public void getFullChargeCapacity(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("IsBatteryHeating")
  public void getIsBatteryHeating(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("LatestWarningRecord")
  public void getLatestWarningRecord(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("LifetimeRemaining")
  public void getLifetimeRemaining(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("NumberOfDischarges")
  public void getNumberOfDischarges(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("SelfDischargeInDays")
  public void getSelfDischargeInDays(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getSerialNumber(DJISDKCacheHWAbstraction.InnerCallback arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("Temperature")
  public void getTemperature(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("FirmwareVersion")
  public void getVersion(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("Voltage")
  public void getVoltage(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("HistoricalWarningRecords")
  public void getWarningRecords(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean hasMultiBatteries()
  {
    return true;
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    this.mergeGetDynamicData = new M600MergeGetDynamicData(paramInt);
    this.mergeGetSingleStaticData = new M600MergeGetSingleStaticData(paramInt);
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("SelfDischargeInDays")
  public void setSelfDischargeInDays(Integer arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\battery\BatterySmartAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */