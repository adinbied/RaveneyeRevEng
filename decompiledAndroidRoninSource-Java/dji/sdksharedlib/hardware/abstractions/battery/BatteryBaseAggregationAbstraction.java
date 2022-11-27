package dji.sdksharedlib.hardware.abstractions.battery;

import dji.midware.data.model.P3.DataSmartBatteryGetPushCellVoltage;
import dji.midware.data.model.P3.DataSmartBatteryGetPushDynamicData;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.DJISDKCache;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.battery.merge.M600DynamicDataCallback;
import dji.sdksharedlib.hardware.abstractions.battery.merge.M600GroupDataCallback;
import dji.sdksharedlib.hardware.abstractions.battery.merge.M600MergeGetDynamicData;
import dji.sdksharedlib.hardware.abstractions.battery.merge.M600MergeGetGroupData;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;

public class BatteryBaseAggregationAbstraction
  extends DJISDKCacheHWAbstraction
  implements DJIParamAccessListener
{
  private static final int BatteryNumber = 1;
  private static final int CommunicationStatus = 2;
  private static final int DifferentFirmware = 7;
  private static final int DifferentVoltage = 4;
  private static final int DifferentVoltageRearrange = 3;
  private static final int HasDamagedCell = 6;
  private static final int LowCellVoltage = 5;
  private static String TAG = "DJISDKCacheBaseAggregationBatteryAbstraction";
  private int index = Integer.MAX_VALUE;
  private M600MergeGetDynamicData mergeGetDynamicData;
  private M600MergeGetGroupData mergeGetGroupData;
  
  /* Error */
  private void invalidateGroupState()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static boolean isErrorBatteryStatus(long paramLong, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      break;
    case 7: 
      if ((paramLong & 0x40000000000000) != 0L) {
        return true;
      }
      break;
    case 6: 
      if ((paramLong & 0x1F000) != 0L) {
        return true;
      }
      break;
    case 5: 
      if ((paramLong & 0xF80) != 0L) {
        return true;
      }
      break;
    case 4: 
      if ((paramLong & 0x8000000000000) != 0L) {
        return true;
      }
      break;
    case 3: 
      if ((paramLong & 0x4000000000000) != 0L) {
        return true;
      }
      break;
    case 2: 
      if ((paramLong & 0x2000000000000) != 0L) {
        return true;
      }
      break;
    case 1: 
      if ((paramLong & 0x1000000000000) != 0L) {
        return true;
      }
      break;
    }
    return false;
  }
  
  public void destroy()
  {
    super.destroy();
    unregisterListener();
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
  @dji.sdksharedlib.hardware.abstractions.Getter("AggregationState")
  public void getAggregationState(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("Overviews")
  public void getBatteryOverviews(DJISDKCacheHWAbstraction.InnerCallback arg1)
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
  @dji.sdksharedlib.hardware.abstractions.Getter("HighestTemperature")
  public void getHighestTemperature(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("NumberOfConnectedBatteries")
  public void getNumberOfConnectedBatteries(DJISDKCacheHWAbstraction.InnerCallback arg1)
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
  @dji.sdksharedlib.hardware.abstractions.Getter("Voltage")
  public void getVoltage(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    this.index = paramInt;
    this.mergeGetDynamicData = new M600MergeGetDynamicData(paramInt);
    this.mergeGetGroupData = new M600MergeGetGroupData();
    invalidateGroupState();
    registerListener();
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
  @dji.sdksharedlib.hardware.abstractions.Getter("IsAnyBatteryDisconnected")
  public void isAnyBatteryDisconnected(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("IsCellDamaged")
  public void isCellDamaged(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("IsFirmwareDifferenceDetected")
  public void isFirmwareDifferenceDetected(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("IsLowCellVoltageDetected")
  public void isLowCellVoltageDetected(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("IsVoltageDifferenceDetected")
  public void isVoltageDifferenceDetected(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onValueChange(DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue paramDJISDKCacheParamValue1, DJISDKCacheParamValue paramDJISDKCacheParamValue2) {}
  
  /* Error */
  void registerListener()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void unregisterListener()
  {
    DJISDKCache.getInstance().stopListening(this);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\battery\BatteryBaseAggregationAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */