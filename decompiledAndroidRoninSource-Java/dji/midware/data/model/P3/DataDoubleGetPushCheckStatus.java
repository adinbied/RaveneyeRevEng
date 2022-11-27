package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataDoubleGetPushCheckStatus
  extends DataBase
{
  private static DataDoubleGetPushCheckStatus instance;
  
  public static DataDoubleGetPushCheckStatus getInstance()
  {
    try
    {
      if (instance == null)
      {
        localDataDoubleGetPushCheckStatus = new DataDoubleGetPushCheckStatus();
        instance = localDataDoubleGetPushCheckStatus;
        localDataDoubleGetPushCheckStatus.isNeedPushLosed = true;
        instance.isRemoteModel = true;
      }
      DataDoubleGetPushCheckStatus localDataDoubleGetPushCheckStatus = instance;
      return localDataDoubleGetPushCheckStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataDoubleGetPushCheckStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */