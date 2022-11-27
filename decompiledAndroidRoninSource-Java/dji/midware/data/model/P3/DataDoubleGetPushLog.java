package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataDoubleGetPushLog
  extends DataBase
{
  private static DataDoubleGetPushLog instance;
  
  public static DataDoubleGetPushLog getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataDoubleGetPushLog();
      }
      DataDoubleGetPushLog localDataDoubleGetPushLog = instance;
      return localDataDoubleGetPushLog;
    }
    finally {}
  }
  
  protected void doPack() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataDoubleGetPushLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */