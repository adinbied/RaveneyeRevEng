package dji.sdksharedlib.keycatalog;

import dji.common.battery.AggregationState;
import dji.common.battery.BatteryCellVoltageLevel;
import dji.common.battery.BatteryConnectionState;
import dji.common.battery.BatteryOverview;
import dji.common.battery.LowVoltageBehavior;
import dji.common.battery.PairingState;
import dji.common.battery.WarningRecord;
import dji.midware.data.model.P3.DataSmartBatteryGetPushCellVoltage;
import dji.midware.data.model.P3.DataSmartBatteryGetPushDynamicData;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.hardware.abstractions.battery.BatteryBaseAggregationAbstraction;
import dji.sdksharedlib.hardware.abstractions.battery.BatteryHandheldAbstraction;
import dji.sdksharedlib.hardware.abstractions.battery.BatteryHandheldHG300Abstraction;
import dji.sdksharedlib.hardware.abstractions.battery.BatteryInspire2Abstraction;
import dji.sdksharedlib.hardware.abstractions.battery.NonSmartA3BatteryAbstraction;
import dji.sdksharedlib.hardware.abstractions.battery.NonSmartBatteryAbstraction;
import dji.sdksharedlib.keycatalog.extension.ComplexKey;
import dji.sdksharedlib.keycatalog.extension.Key;

public class BatteryKeys
  extends DJISDKCacheKeys
{
  @Key(accessType=1, includedAbstractions={BatteryBaseAggregationAbstraction.class}, type=AggregationState.class)
  public static final String AGGREGATION_STATE = "AggregationState";
  @Key(accessType=1, type=DataSmartBatteryGetPushCellVoltage.class)
  public static final String BATTERY_CELL_VOLTAGE_FOR_FLIGHTRECORD = "BatteryCellVoltageForFR";
  @Key(accessType=1, type=DataSmartBatteryGetPushDynamicData.class)
  public static final String BATTERY_DYNAMIC_INFO_FOR_FLIGHTRECORD = "BatteryDynamicInfoForFR";
  @Key(accessType=1, excludedAbstractions={NonSmartA3BatteryAbstraction.class}, type=Integer[].class)
  public static final String CELL_VOLTAGES = "CellVoltages";
  @Key(accessType=4, includedAbstractions={NonSmartA3BatteryAbstraction.class}, type=BatteryCellVoltageLevel.class)
  public static final String CELL_VOLTAGE_LEVEL = "CellVoltageLevel";
  @ComplexKey({@Key(accessType=4, excludedAbstractions={NonSmartA3BatteryAbstraction.class}, type=Integer.class), @Key(accessType=1, includedAbstractions={dji.sdksharedlib.keycatalog.group.SmartBatteryGroup.class}, type=Integer.class)})
  public static final String CHARGE_REMAINING = "ChargeRemaining";
  @ComplexKey({@Key(accessType=4, excludedAbstractions={NonSmartA3BatteryAbstraction.class}, type=Integer.class), @Key(accessType=1, includedAbstractions={dji.sdksharedlib.keycatalog.group.SmartBatteryGroup.class}, type=Integer.class)})
  public static final String CHARGE_REMAINING_IN_PERCENT = "ChargeRemainingInPercent";
  public static final String COMPONENT_KEY = "Battery";
  @Key(accessType=4, type=BatteryConnectionState.class)
  public static final String CONNECTION_STATE = "ConnectionState";
  @ComplexKey({@Key(accessType=4, excludedAbstractions={NonSmartA3BatteryAbstraction.class}, type=Integer.class), @Key(accessType=1, includedAbstractions={dji.sdksharedlib.keycatalog.group.SmartBatteryGroup.class}, type=Integer.class)})
  public static final String CURRENT = "Current";
  @ComplexKey({@Key(accessType=4, excludedAbstractions={NonSmartA3BatteryAbstraction.class}, type=Integer.class), @Key(accessType=1, includedAbstractions={dji.sdksharedlib.keycatalog.group.SmartBatteryGroup.class}, type=Integer.class)})
  public static final String FULL_CHARGE_CAPACITY = "FullChargeCapacity";
  @Key(accessType=1, includedAbstractions={BatteryBaseAggregationAbstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String HIGHEST_TEMPERATURE = "HighestTemperature";
  @Key(accessType=1, excludedAbstractions={BatteryHandheldAbstraction.class, BatteryHandheldHG300Abstraction.class}, type=WarningRecord[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String HISTORICAL_WARNING_RECORDS = "HistoricalWarningRecords";
  @Key(accessType=1, excludedAbstractions={NonSmartBatteryAbstraction.class}, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String INTERNAL_SERIAL_NUMBER = "InternalSerialNumber";
  @Key(accessType=1, includedAbstractions={BatteryBaseAggregationAbstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_ANY_BATTERY_DISCONNECTED = "IsAnyBatteryDisconnected";
  @ComplexKey({@Key(accessType=4, excludedAbstractions={NonSmartBatteryAbstraction.class}, type=Boolean.class), @Key(accessType=1, includedAbstractions={dji.sdksharedlib.keycatalog.group.SmartBatteryGroup.class}, type=Boolean.class)})
  public static final String IS_BATTERY_HEATING = "IsBatteryHeating";
  @Key(accessType=4, includedAbstractions={BatteryHandheldHG300Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_BEING_CHARGED = "IsBeingCharged";
  @Key(accessType=1, includedAbstractions={BatteryBaseAggregationAbstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_CELL_DAMAGED = "IsCellDamaged";
  @Key(accessType=1, includedAbstractions={BatteryBaseAggregationAbstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_FIRMWARE_DIFFERENCE_DETECTED = "IsFirmwareDifferenceDetected";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_IN_SINGLE_BATTERY_MODE = "isInSingleBatteryMode";
  @Key(accessType=1, includedAbstractions={BatteryBaseAggregationAbstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_LOW_CELL_VOLTAGE_DETECTED = "IsLowCellVoltageDetected";
  @ComplexKey({@Key(accessType=4, excludedAbstractions={NonSmartA3BatteryAbstraction.class}, type=Integer.class), @Key(accessType=1, includedAbstractions={dji.sdksharedlib.keycatalog.group.SmartBatteryGroup.class}, type=Integer.class)})
  public static final String IS_MONITOR_BATTERY_CHARGING = "IsMonitorBatteryCharging";
  @Key(accessType=1, excludedAbstractions={NonSmartA3BatteryAbstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_SMART_BATTERY = "isSmartBattery";
  @Key(accessType=1, includedAbstractions={BatteryBaseAggregationAbstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_VOLTAGE_DIFFERENCE_DETECTED = "IsVoltageDifferenceDetected";
  @Key(accessType=1, excludedAbstractions={NonSmartA3BatteryAbstraction.class}, type=WarningRecord.class)
  public static final String LATEST_WARNING_RECORD = "LatestWarningRecord";
  @Key(accessType=3, includedAbstractions={NonSmartA3BatteryAbstraction.class}, type=LowVoltageBehavior.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String LEVEL_1_CELL_VOLTAGE_BEHAVIOR = "Level1CellVoltageBehavior";
  @Key(accessType=3, includedAbstractions={NonSmartA3BatteryAbstraction.class}, type=Integer.class)
  public static final String LEVEL_1_CELL_VOLTAGE_THRESHOLD = "Level1CellVoltageThreshold";
  @Key(accessType=3, includedAbstractions={NonSmartA3BatteryAbstraction.class}, type=LowVoltageBehavior.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String LEVEL_2_CELL_VOLTAGE_BEHAVIOR = "Level2CellVoltageBehavior";
  @Key(accessType=3, includedAbstractions={NonSmartA3BatteryAbstraction.class}, type=Integer.class)
  public static final String LEVEL_2_CELL_VOLTAGE_THRESHOLD = "Level2CellVoltageThreshold";
  @ComplexKey({@Key(accessType=4, excludedAbstractions={NonSmartA3BatteryAbstraction.class}, type=Integer.class), @Key(accessType=1, includedAbstractions={dji.sdksharedlib.hardware.abstractions.battery.BatteryFoldingDroneAbstraction.class, BatteryInspire2Abstraction.class, dji.sdksharedlib.hardware.abstractions.battery.BatteryM600Abstraction.class}, type=Integer.class)})
  public static final String LIFETIME_REMAINING = "LifetimeRemaining";
  @ComplexKey({@Key(accessType=4, excludedAbstractions={NonSmartA3BatteryAbstraction.class}, type=Integer.class), @Key(accessType=1, includedAbstractions={dji.sdksharedlib.keycatalog.group.SmartBatteryGroup.class}, type=Integer.class)})
  public static final String MONITOR_CHARGE_REMAINING_IN_PERCENT = "MonitorChargeRemainingInPercent";
  @ComplexKey({@Key(accessType=1, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN), @Key(accessType=3, includedAbstractions={NonSmartA3BatteryAbstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)})
  public static final String NUMBER_OF_CELLS = "NumberOfCells";
  @ComplexKey({@Key(accessType=1, includedAbstractions={BatteryBaseAggregationAbstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC), @Key(accessType=4, includedAbstractions={dji.sdksharedlib.hardware.abstractions.battery.DJIBatteryRonin2Abstraction.class}, type=Integer.class)})
  public static final String NUMBER_OF_CONNECTED_BATTERIES = "NumberOfConnectedBatteries";
  @ComplexKey({@Key(accessType=4, excludedAbstractions={NonSmartA3BatteryAbstraction.class}, type=Integer.class), @Key(accessType=1, includedAbstractions={dji.sdksharedlib.keycatalog.group.SmartBatteryGroup.class}, type=Integer.class)})
  public static final String NUMBER_OF_DISCHARGES = "NumberOfDischarges";
  @Key(accessType=1, includedAbstractions={BatteryBaseAggregationAbstraction.class}, type=BatteryOverview[].class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String OVERVIEWS = "Overviews";
  @Key(accessType=1, includedAbstractions={BatteryInspire2Abstraction.class}, type=PairingState.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PAIRING_STATE = "PairingState";
  @Key(accessType=8, includedAbstractions={BatteryInspire2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PAIR_BATTERIES = "PairBatteries";
  @Key(accessType=3, excludedAbstractions={NonSmartA3BatteryAbstraction.class}, type=Integer.class)
  public static final String SELF_DISCHARGE_IN_DAYS = "SelfDischargeInDays";
  @ComplexKey({@Key(accessType=4, excludedAbstractions={NonSmartA3BatteryAbstraction.class}, type=Float.class), @Key(accessType=1, includedAbstractions={dji.sdksharedlib.keycatalog.group.SmartBatteryGroup.class}, type=Float.class)})
  public static final String TEMPERATURE = "Temperature";
  @ComplexKey({@Key(accessType=4, type=Integer.class), @Key(accessType=1, includedAbstractions={dji.sdksharedlib.keycatalog.group.SmartBatteryGroup.class}, type=Integer.class)})
  public static final String VOLTAGE = "Voltage";
  
  public BatteryKeys(String paramString)
  {
    super(paramString);
  }
  
  protected String getDefaultAbstractionName()
  {
    return "Battery";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\BatteryKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */