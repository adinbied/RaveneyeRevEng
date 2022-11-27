package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataDm368GetPushLog
  extends DataBase
{
  private static DataDm368GetPushLog instance;
  
  public static DataDm368GetPushLog getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataDm368GetPushLog();
      }
      DataDm368GetPushLog localDataDm368GetPushLog = instance;
      return localDataDm368GetPushLog;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataDm368GetPushLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */