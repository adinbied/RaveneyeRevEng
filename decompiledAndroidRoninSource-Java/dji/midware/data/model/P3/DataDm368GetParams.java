package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataDm368GetParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataDm368GetParams instance;
  private DataDm368SetParams.DM368CmdId cmdId;
  private int mPercent = 0;
  
  public static DataDm368GetParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataDm368GetParams();
      }
      DataDm368GetParams localDataDm368GetParams = instance;
      return localDataDm368GetParams;
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
  
  public int getBandWidthPercent()
  {
    return this.mPercent;
  }
  
  public int getBandWidthPercentInstant()
  {
    return 0;
  }
  
  public int getCmdId()
  {
    return this.cmdId.value();
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public DataDm368GetParams set(DataDm368SetParams.DM368CmdId paramDM368CmdId)
  {
    this.cmdId = paramDM368CmdId;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataDm368GetParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */