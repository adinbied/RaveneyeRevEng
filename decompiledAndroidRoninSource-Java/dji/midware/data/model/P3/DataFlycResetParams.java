package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.params.P3.ParamInfo;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycResetParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycResetParams instance;
  private String[] indexs = null;
  private ParamInfo paramInfo;
  
  public static DataFlycResetParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycResetParams();
      }
      DataFlycResetParams localDataFlycResetParams = instance;
      return localDataFlycResetParams;
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
  
  public DataFlycResetParams setIndexs(String... paramVarArgs)
  {
    this.indexs = paramVarArgs;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycResetParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */