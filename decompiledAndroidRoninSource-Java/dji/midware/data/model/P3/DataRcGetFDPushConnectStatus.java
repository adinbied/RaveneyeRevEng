package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcGetFDPushConnectStatus
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcGetFDPushConnectStatus instance;
  
  public static DataRcGetFDPushConnectStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetFDPushConnectStatus();
      }
      DataRcGetFDPushConnectStatus localDataRcGetFDPushConnectStatus = instance;
      return localDataRcGetFDPushConnectStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getControlNums()
  {
    return 0;
  }
  
  public int getCurTrainer()
  {
    return 0;
  }
  
  public int getMainControlStatus()
  {
    return 0;
  }
  
  public int getMainDeviceType()
  {
    return 0;
  }
  
  public DataRcGetRcRole.RcRole getRole()
  {
    return null;
  }
  
  public int getSlaveControlStatus()
  {
    return 0;
  }
  
  public int getSlaveDeviceType()
  {
    return 0;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetFDPushConnectStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */