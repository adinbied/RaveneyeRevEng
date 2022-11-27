package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataCameraGetPushCheckStatus
  extends DataBase
{
  private static DataCameraGetPushCheckStatus instance;
  
  public static DataCameraGetPushCheckStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushCheckStatus();
      }
      DataCameraGetPushCheckStatus localDataCameraGetPushCheckStatus = instance;
      return localDataCameraGetPushCheckStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean encryptionStatus()
  {
    return false;
  }
  
  public boolean hdmiStatus()
  {
    return false;
  }
  
  public boolean upgradeStatus()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushCheckStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */