package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushParamsByHash
  extends DataBase
{
  private static DataFlycGetPushParamsByHash instance;
  
  public static DataFlycGetPushParamsByHash getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushParamsByHash();
      }
      DataFlycGetPushParamsByHash localDataFlycGetPushParamsByHash = instance;
      return localDataFlycGetPushParamsByHash;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public String getFirstIndex()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushParamsByHash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */