package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataOsdGetPushConfig
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataOsdGetPushConfig instance;
  
  public static DataOsdGetPushConfig getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushConfig();
      }
      DataOsdGetPushConfig localDataOsdGetPushConfig = instance;
      return localDataOsdGetPushConfig;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getBandWidthPercent()
  {
    return 0;
  }
  
  public int getChannel()
  {
    return 0;
  }
  
  public boolean getIsAuto()
  {
    return false;
  }
  
  public boolean getIsMaster()
  {
    return false;
  }
  
  public int getMcs()
  {
    return 0;
  }
  
  public boolean getSingleOrDouble()
  {
    return false;
  }
  
  public int getWorkingFreq()
  {
    return 0;
  }
  
  /* Error */
  protected void setPushRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */