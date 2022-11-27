package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataRcGetPushBatteryInfo
  extends DataBase
{
  private static DataRcGetPushBatteryInfo instance;
  
  public static DataRcGetPushBatteryInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetPushBatteryInfo();
      }
      DataRcGetPushBatteryInfo localDataRcGetPushBatteryInfo = instance;
      return localDataRcGetPushBatteryInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getBattery()
  {
    return 0;
  }
  
  public int getBatteryVolume()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetPushBatteryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */