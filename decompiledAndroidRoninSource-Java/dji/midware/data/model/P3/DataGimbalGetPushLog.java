package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataGimbalGetPushLog
  extends DataBase
{
  private static DataGimbalGetPushLog instance;
  
  public static DataGimbalGetPushLog getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalGetPushLog();
      }
      DataGimbalGetPushLog localDataGimbalGetPushLog = instance;
      return localDataGimbalGetPushLog;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetPushLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */