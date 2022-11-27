package dji.sdksharedlib.hardware.abstractions.battery;

import dji.midware.data.model.P3.DataCenterGetSelfDischarge;
import dji.midware.data.model.P3.DataCenterSelfDischarge;
import dji.midware.data.model.P3.DataCommonGetVersion;
import dji.midware.data.model.P3.DataSmartBatteryGetPushDynamicData;
import dji.midware.data.model.P3.DataSmartBatteryGetStaticData;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.Getter;
import dji.sdksharedlib.keycatalog.BatteryKeys;
import dji.sdksharedlib.keycatalog.DJISDKCacheKeys;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import org.greenrobot.eventbus.EventBus;

public class BatteryAbstraction
  extends DJISDKCacheHWAbstraction
{
  private static final String TAG = "DJISDKCacheBatteryAbstraction";
  protected static final float TEMPERATURE_K2C = 273.15F;
  Integer[] cellVotages;
  protected DataSmartBatteryGetPushDynamicData dynamicData = null;
  protected boolean isSmartBattery = true;
  protected int numberOfCell = -1;
  protected DataSmartBatteryGetStaticData staticData = null;
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("CellVoltages")
  public void getCellVoltages(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected Class<? extends DJISDKCacheKeys> getDJISDKCacheKeysClass()
  {
    return BatteryKeys.class;
  }
  
  @Getter("InternalSerialNumber")
  public void getInternalSerialNumber(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    getSerialNumber(paramInnerCallback, 3);
  }
  
  /* Error */
  @Getter("LatestWarningRecord")
  public void getLatestWarningRecord(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("NumberOfCells")
  public void getNumberOfCells(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("SelfDischargeInDays")
  public void getSelfDischargeInDays(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Getter("SerialNumber")
  public void getSerialNumber(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    getSerialNumber(paramInnerCallback, 0);
  }
  
  /* Error */
  protected void getSerialNumber(DJISDKCacheHWAbstraction.InnerCallback arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("FirmwareVersion")
  public void getVersion(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("HistoricalWarningRecords")
  public void getWarningRecords(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean hasMultiBatteries()
  {
    return false;
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    EventBus.getDefault().register(this);
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
  protected void initializeCustomizedKey()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isHG300Battery()
  {
    return false;
  }
  
  /* Error */
  @Getter("isSmartBattery")
  public void isSmartBattery(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isSmartBattery()
  {
    return this.isSmartBattery;
  }
  
  protected boolean isWarningInformationRecordsSupported()
  {
    return true;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataCenterGetPushBatteryCommon arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("SelfDischargeInDays")
  public void setSelfDischargeInDays(Integer arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\battery\BatteryAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */