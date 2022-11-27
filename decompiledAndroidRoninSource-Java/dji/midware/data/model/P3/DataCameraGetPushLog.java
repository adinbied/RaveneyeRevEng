package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataCameraGetPushLog
  extends DataBase
{
  private static DataCameraGetPushLog instance;
  
  public static DataCameraGetPushLog getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushLog();
      }
      DataCameraGetPushLog localDataCameraGetPushLog = instance;
      return localDataCameraGetPushLog;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */