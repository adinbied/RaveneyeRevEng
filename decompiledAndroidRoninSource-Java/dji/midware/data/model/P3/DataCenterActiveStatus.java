package dji.midware.data.model.P3;

import dji.midware.data.model.common.DataAbstractGetPushActiveStatus;
import dji.midware.data.packages.P3.Pack;

public class DataCenterActiveStatus
  extends DataAbstractGetPushActiveStatus
{
  private static DataCenterActiveStatus instance;
  
  public static DataCenterActiveStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCenterActiveStatus();
      }
      DataCenterActiveStatus localDataCenterActiveStatus = instance;
      return localDataCenterActiveStatus;
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
  
  public int getSenderIndex()
  {
    return this.pack.senderId;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCenterActiveStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */