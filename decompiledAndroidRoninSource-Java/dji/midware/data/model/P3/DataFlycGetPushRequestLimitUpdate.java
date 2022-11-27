package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushRequestLimitUpdate
  extends DataBase
{
  private static DataFlycGetPushRequestLimitUpdate instance;
  
  public static DataFlycGetPushRequestLimitUpdate getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushRequestLimitUpdate();
      }
      DataFlycGetPushRequestLimitUpdate localDataFlycGetPushRequestLimitUpdate = instance;
      return localDataFlycGetPushRequestLimitUpdate;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushRequestLimitUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */