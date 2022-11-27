package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetAELock
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetAELock instance;
  private boolean isLock;
  
  public static DataCameraSetAELock getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetAELock();
      }
      DataCameraSetAELock localDataCameraSetAELock = instance;
      return localDataCameraSetAELock;
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
  
  public DataCameraSetAELock setIsLock(boolean paramBoolean)
  {
    this.isLock = paramBoolean;
    return this;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetAELock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */