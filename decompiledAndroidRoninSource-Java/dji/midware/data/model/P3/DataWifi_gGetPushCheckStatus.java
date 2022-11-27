package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataWifi_gGetPushCheckStatus
  extends DataBase
{
  private static DataWifi_gGetPushCheckStatus instance;
  
  public static DataWifi_gGetPushCheckStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataWifi_gGetPushCheckStatus();
      }
      DataWifi_gGetPushCheckStatus localDataWifi_gGetPushCheckStatus = instance;
      return localDataWifi_gGetPushCheckStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean isOK()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifi_gGetPushCheckStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */