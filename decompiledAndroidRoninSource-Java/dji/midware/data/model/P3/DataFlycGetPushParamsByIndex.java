package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.params.P3.ParamInfo;

public class DataFlycGetPushParamsByIndex
  extends DataBase
{
  private static DataFlycGetPushParamsByIndex instance;
  
  public static DataFlycGetPushParamsByIndex getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushParamsByIndex();
      }
      DataFlycGetPushParamsByIndex localDataFlycGetPushParamsByIndex = instance;
      return localDataFlycGetPushParamsByIndex;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public String getFirstIndex()
  {
    return null;
  }
  
  public ParamInfo getInfo(ParamInfo paramParamInfo)
  {
    return null;
  }
  
  /* Error */
  protected void setPushRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushParamsByIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */