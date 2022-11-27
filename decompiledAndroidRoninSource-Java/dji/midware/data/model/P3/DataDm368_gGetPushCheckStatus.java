package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataDm368_gGetPushCheckStatus
  extends DataBase
{
  private static DataDm368_gGetPushCheckStatus instance;
  
  public static DataDm368_gGetPushCheckStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataDm368_gGetPushCheckStatus();
      }
      DataDm368_gGetPushCheckStatus localDataDm368_gGetPushCheckStatus = instance;
      return localDataDm368_gGetPushCheckStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean get68013ConnectStatus()
  {
    return false;
  }
  
  public boolean getAppConnectStatus()
  {
    return false;
  }
  
  public boolean getEncryptStatus()
  {
    return false;
  }
  
  public boolean getHDMIConnectStatus()
  {
    return false;
  }
  
  public boolean getHDMIExist()
  {
    return false;
  }
  
  public int getVideoBps()
  {
    return 0;
  }
  
  public boolean isOK()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataDm368_gGetPushCheckStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */