package dji.common.battery;

import dji.midware.data.model.P3.DataCenterGetPushBatteryCommon.ConnStatus;

public enum BatteryConnectionState
{
  private DataCenterGetPushBatteryCommon.ConnStatus connStatus;
  
  static
  {
    INVALID = new BatteryConnectionState("INVALID", 1, DataCenterGetPushBatteryCommon.ConnStatus.INVALID);
    EXCEPTION = new BatteryConnectionState("EXCEPTION", 2, DataCenterGetPushBatteryCommon.ConnStatus.EXCEPTION);
    BatteryConnectionState localBatteryConnectionState = new BatteryConnectionState("UNKNOWN", 3, DataCenterGetPushBatteryCommon.ConnStatus.OTHER);
    UNKNOWN = localBatteryConnectionState;
    $VALUES = new BatteryConnectionState[] { NORMAL, INVALID, EXCEPTION, localBatteryConnectionState };
  }
  
  private BatteryConnectionState(DataCenterGetPushBatteryCommon.ConnStatus paramConnStatus)
  {
    this.connStatus = paramConnStatus;
  }
  
  private boolean belongsTo(DataCenterGetPushBatteryCommon.ConnStatus paramConnStatus)
  {
    return this.connStatus == paramConnStatus;
  }
  
  public static BatteryConnectionState find(DataCenterGetPushBatteryCommon.ConnStatus paramConnStatus)
  {
    BatteryConnectionState[] arrayOfBatteryConnectionState = values();
    int j = arrayOfBatteryConnectionState.length;
    int i = 0;
    while (i < j)
    {
      BatteryConnectionState localBatteryConnectionState = arrayOfBatteryConnectionState[i];
      if (localBatteryConnectionState.belongsTo(paramConnStatus)) {
        return localBatteryConnectionState;
      }
      i += 1;
    }
    return UNKNOWN;
  }
  
  public int value()
  {
    return this.connStatus.value();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\battery\BatteryConnectionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */