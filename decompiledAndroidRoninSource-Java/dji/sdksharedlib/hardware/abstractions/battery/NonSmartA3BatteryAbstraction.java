package dji.sdksharedlib.hardware.abstractions.battery;

import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import java.util.concurrent.CountDownLatch;
import org.greenrobot.eventbus.EventBus;

public class NonSmartA3BatteryAbstraction
  extends NonSmartBatteryAbstraction
{
  public static final String PARAM_NAME_CELL_NUM = "g_config.voltage.battery_cell_0";
  private static final String PARAM_NAME_CRITICAL_VOTAGE_OPERATION = "g_config.voltage.level_2_protect_type_0";
  private static final String PARAM_NAME_CRITICAL_VOTAGE_THRESHOLD = "g_config.voltage.level_2_protect_0";
  private static final String PARAM_NAME_VOTAGE_OPERATION = "g_config.voltage.level_1_protect_type_0";
  private static final String PARAM_NAME_VOTAGE_THRESHOLD = "g_config.voltage.level_1_protect_0";
  private static final String TAG = "DJINonSmartA3BatteryAbstraction";
  private int level1Threshold = 0;
  private int level2Threshold = 0;
  
  public NonSmartA3BatteryAbstraction()
  {
    this.isSmartBattery = false;
  }
  
  /* Error */
  private void initThresholds(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
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
  @dji.sdksharedlib.hardware.abstractions.Getter("Level1CellVoltageBehavior")
  public void getLevel1CellVoltageBehavior(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("Level1CellVoltageThreshold")
  public void getLevel1CellVoltageThreshold(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("Level2CellVoltageBehavior")
  public void getLevel2CellVoltageBehavior(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("Level2CellVoltageThreshold")
  public void getLevel2CellVoltageThreshold(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Getter("NumberOfCells")
  public void getNumberOfCells(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("Level1CellVoltageBehavior")
  public void setLevel1CellVoltageBehavior(dji.common.battery.LowVoltageBehavior arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("Level1CellVoltageThreshold")
  public void setLevel1CellVoltageThreshold(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("Level2CellVoltageBehavior")
  public void setLevel2CellVoltageBehavior(dji.common.battery.LowVoltageBehavior arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("Level2CellVoltageThreshold")
  public void setLevel2CellVoltageThreshold(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("NumberOfCells")
  public void setNumberOfCells(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\battery\NonSmartA3BatteryAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */