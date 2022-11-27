package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushAgpsStatus
  extends DataBase
{
  private static DataFlycGetPushAgpsStatus instance;
  
  public static DataFlycGetPushAgpsStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushAgpsStatus();
      }
      DataFlycGetPushAgpsStatus localDataFlycGetPushAgpsStatus = instance;
      return localDataFlycGetPushAgpsStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public Short getCRC16Hash()
  {
    return null;
  }
  
  public int getDataLength()
  {
    return 0;
  }
  
  public int getTimeStamp()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushAgpsStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */