package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataRcGetPushConnectStatus
  extends DataBase
{
  private static DataRcGetPushConnectStatus instance;
  
  public static DataRcGetPushConnectStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetPushConnectStatus();
      }
      DataRcGetPushConnectStatus localDataRcGetPushConnectStatus = instance;
      return localDataRcGetPushConnectStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getIP()
  {
    return 0;
  }
  
  public int getSignalMaster()
  {
    return 0;
  }
  
  public int getSignalSlave(int paramInt)
  {
    return 0;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public boolean isSlaveConnected()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetPushConnectStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */