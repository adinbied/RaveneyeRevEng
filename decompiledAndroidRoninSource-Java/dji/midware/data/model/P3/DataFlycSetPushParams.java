package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.params.P3.ParamInfo;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSetPushParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycSetPushParams instance;
  private int frequency;
  private int group;
  private ParamInfo[] infolist;
  private int size;
  private int startIndex;
  
  public static DataFlycSetPushParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycSetPushParams();
      }
      DataFlycSetPushParams localDataFlycSetPushParams = instance;
      return localDataFlycSetPushParams;
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
  
  public DataFlycSetPushParams setFrequency(int paramInt)
  {
    this.frequency = paramInt;
    return this;
  }
  
  public DataFlycSetPushParams setGroup(int paramInt)
  {
    this.group = paramInt;
    return this;
  }
  
  public DataFlycSetPushParams setList(String[] paramArrayOfString)
  {
    return null;
  }
  
  public DataFlycSetPushParams setStartIndex(int paramInt)
  {
    this.startIndex = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSetPushParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */