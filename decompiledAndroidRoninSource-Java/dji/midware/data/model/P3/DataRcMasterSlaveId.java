package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcMasterSlaveId
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcMasterSlaveId instance;
  private boolean isGetMode = true;
  private String rcId;
  
  public static DataRcMasterSlaveId getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcMasterSlaveId();
      }
      DataRcMasterSlaveId localDataRcMasterSlaveId = instance;
      return localDataRcMasterSlaveId;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String getRcId()
  {
    return null;
  }
  
  public void setGetMode(boolean paramBoolean)
  {
    this.isGetMode = paramBoolean;
  }
  
  public void setRcId(String paramString)
  {
    this.rcId = paramString;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcMasterSlaveId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */