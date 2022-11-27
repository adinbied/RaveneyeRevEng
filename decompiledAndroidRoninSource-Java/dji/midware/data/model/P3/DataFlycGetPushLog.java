package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushLog
  extends DataBase
{
  private static DataFlycGetPushLog instance;
  
  public static DataFlycGetPushLog getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushLog();
      }
      DataFlycGetPushLog localDataFlycGetPushLog = instance;
      return localDataFlycGetPushLog;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public String getLog()
  {
    return null;
  }
  
  public int getType()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */