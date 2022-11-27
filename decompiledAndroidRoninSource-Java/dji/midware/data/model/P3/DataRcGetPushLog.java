package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataRcGetPushLog
  extends DataBase
{
  private static DataRcGetPushLog instance;
  
  public static DataRcGetPushLog getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetPushLog();
      }
      DataRcGetPushLog localDataRcGetPushLog = instance;
      return localDataRcGetPushLog;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetPushLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */