package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushParams
  extends DataBase
{
  private static DataFlycGetPushParams instance;
  
  public static DataFlycGetPushParams getInstance()
  {
    try
    {
      if (instance == null)
      {
        instance = new DataFlycGetPushParams();
        DataFlycGetPushParamsByHash.getInstance();
        DataFlycGetPushParamsByIndex.getInstance();
      }
      DataFlycGetPushParams localDataFlycGetPushParams = instance;
      return localDataFlycGetPushParams;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public String getFirstIndex()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */