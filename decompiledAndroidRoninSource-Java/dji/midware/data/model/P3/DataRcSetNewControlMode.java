package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcSetNewControlMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcSetNewControlMode instance;
  private int mFunction = 0;
  private DataRcGetRcRole.RcRole mRcRole = DataRcGetRcRole.RcRole.OTHER;
  
  public static DataRcSetNewControlMode getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSetNewControlMode();
      }
      DataRcSetNewControlMode localDataRcSetNewControlMode = instance;
      return localDataRcSetNewControlMode;
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
  
  public DataRcSetNewControlMode setRcFunction(int paramInt)
  {
    this.mFunction = paramInt;
    return this;
  }
  
  public DataRcSetNewControlMode setRcRole(DataRcGetRcRole.RcRole paramRcRole)
  {
    this.mRcRole = paramRcRole;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetNewControlMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */