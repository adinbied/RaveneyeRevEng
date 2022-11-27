package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataDm368GetPushCheckStatus
  extends DataBase
{
  private static DataDm368GetPushCheckStatus instance;
  
  public static DataDm368GetPushCheckStatus getInstance()
  {
    try
    {
      if (instance == null)
      {
        localDataDm368GetPushCheckStatus = new DataDm368GetPushCheckStatus();
        instance = localDataDm368GetPushCheckStatus;
        localDataDm368GetPushCheckStatus.isNeedPushLosed = true;
        instance.isRemoteModel = true;
      }
      DataDm368GetPushCheckStatus localDataDm368GetPushCheckStatus = instance;
      return localDataDm368GetPushCheckStatus;
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
  
  public int getVideoBps()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataDm368GetPushCheckStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */