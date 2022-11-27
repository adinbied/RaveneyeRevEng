package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataGimbalPushBatteryInfo
  extends DataBase
{
  private static DataGimbalPushBatteryInfo instance;
  
  public static DataGimbalPushBatteryInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalPushBatteryInfo();
      }
      DataGimbalPushBatteryInfo localDataGimbalPushBatteryInfo = instance;
      return localDataGimbalPushBatteryInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getCapacityPercentage()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalPushBatteryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */