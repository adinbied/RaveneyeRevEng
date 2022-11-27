package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSetPlaneName
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycSetPlaneName instance;
  private String name;
  
  public static DataFlycSetPlaneName getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycSetPlaneName();
      }
      DataFlycSetPlaneName localDataFlycSetPlaneName = instance;
      return localDataFlycSetPlaneName;
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
  
  public DataFlycSetPlaneName setName(String paramString)
  {
    this.name = paramString;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSetPlaneName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */