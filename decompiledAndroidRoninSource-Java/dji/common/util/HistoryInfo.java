package dji.common.util;

import dji.midware.data.model.P3.DataCenterGetPushBatteryCommon.ConnStatus;

public class HistoryInfo
{
  private static final int FLAG_DISCHARGE = 131072;
  private static final long FLAG_DISCHARGE_NEW = 2097152L;
  private static final int FLAG_FIRSTLEVEL_CURRENT = 1;
  private static final long FLAG_FIRSTLEVEL_CURRENT_NEW = 1L;
  private static final int FLAG_FIRSTLEVEL_LOWTEMP = 16;
  private static final long FLAG_FIRSTLEVEL_LOWTEMP_NEW = 16L;
  private static final int FLAG_FIRSTLEVEL_OVERTEMP = 4;
  private static final long FLAG_FIRSTLEVEL_OVERTEMP_NEW = 4L;
  private static final int FLAG_INVALID = 7168;
  private static final long FLAG_INVALID_NEW = 126976L;
  private static final int FLAG_REPLACE = 57344;
  private static final int FLAG_SECONDLEVEL_CURRENT = 2;
  private static final long FLAG_SECONDLEVEL_CURRENT_NEW = 2L;
  private static final int FLAG_SECONDLEVEL_LOWTEMP = 32;
  private static final long FLAG_SECONDLEVEL_LOWTEMP_NEW = 32L;
  private static final int FLAG_SECONDLEVEL_OVERTEMP = 8;
  private static final long FLAG_SECONDLEVEL_OVERTEMP_NEW = 8L;
  private static final int FLAG_SHORT_CIRCUIT = 64;
  private static final long FLAG_SHORT_CIRCUIT_NEW = 64L;
  private static final int FLAG_UNDER_VOLTAGE = 896;
  private static final long FLAG_UNDER_VOLTAGE_NEW = 3968L;
  private static final int FLAG_WATCHDOG_RESET = 65536;
  private static final long FLAG_WATCHDOG_RESET_NEW = 1048576L;
  public static final byte VALUE_ALREADY_REPLACE = 1;
  public static final byte VALUE_NO_REPLACE = 0;
  private DataCenterGetPushBatteryCommon.ConnStatus connStatus = DataCenterGetPushBatteryCommon.ConnStatus.NORMAL;
  private boolean dischargeFlag = false;
  private boolean firstLevelCurrent = false;
  private boolean firstLevelLowTemp = false;
  private boolean firstLevelOverTemp = false;
  private byte invalidNum = 0;
  private int originalError = 0;
  private long originalNewError = 0L;
  private byte replaceFlag = 0;
  private boolean secondLevelCurrent = false;
  private boolean secondLevelLowTemp = false;
  private boolean secondLevelOverTemp = false;
  private boolean shortCircuit = false;
  private byte underVoltageNum = 0;
  private boolean watchDogReset = false;
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public DataCenterGetPushBatteryCommon.ConnStatus getConnStatus()
  {
    return this.connStatus;
  }
  
  public byte getInvalidNum()
  {
    return this.invalidNum;
  }
  
  public byte getReplaceFlag()
  {
    return this.replaceFlag;
  }
  
  public byte getUnderVoltageNum()
  {
    return this.underVoltageNum;
  }
  
  public boolean hasConnError()
  {
    return false;
  }
  
  public boolean hasDischargeSelf()
  {
    return this.dischargeFlag;
  }
  
  public boolean hasError()
  {
    return false;
  }
  
  public boolean hasFirstLevelCurrent()
  {
    return this.firstLevelCurrent;
  }
  
  public boolean hasFirstLevelLowTemp()
  {
    return this.firstLevelLowTemp;
  }
  
  public boolean hasFirstLevelOverTemp()
  {
    return this.firstLevelOverTemp;
  }
  
  public boolean hasSecondLevelCurrent()
  {
    return this.secondLevelCurrent;
  }
  
  public boolean hasSecondLevelLowTemp()
  {
    return this.secondLevelLowTemp;
  }
  
  public boolean hasSecondLevelOverTemp()
  {
    return this.secondLevelOverTemp;
  }
  
  public boolean hasShortCircuit()
  {
    return this.shortCircuit;
  }
  
  public boolean hasWatchDogReset()
  {
    return this.watchDogReset;
  }
  
  public int hashCode()
  {
    return this.originalError;
  }
  
  /* Error */
  public void parse(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void parse(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void parseSimple(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void resetSimple()
  {
    this.underVoltageNum = 0;
    this.invalidNum = 0;
  }
  
  public String toString()
  {
    return Integer.toBinaryString(this.originalError);
  }
  
  public void updateConnStatus(DataCenterGetPushBatteryCommon.ConnStatus paramConnStatus)
  {
    this.connStatus = paramConnStatus;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\commo\\util\HistoryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */