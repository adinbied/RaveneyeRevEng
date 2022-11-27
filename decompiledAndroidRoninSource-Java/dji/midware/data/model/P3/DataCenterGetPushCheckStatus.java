package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataCenterGetPushCheckStatus
  extends DataBase
{
  private static DataCenterGetPushCheckStatus instance;
  
  public static DataCenterGetPushCheckStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCenterGetPushCheckStatus();
      }
      DataCenterGetPushCheckStatus localDataCenterGetPushCheckStatus = instance;
      return localDataCenterGetPushCheckStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean getBatteryConnectStatus()
  {
    return false;
  }
  
  public boolean getGpsConnectStatus()
  {
    return false;
  }
  
  public boolean getMcConnectStatus()
  {
    return false;
  }
  
  public boolean isOK()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCenterGetPushCheckStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */