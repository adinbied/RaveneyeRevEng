package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.util.BytesUtil;

public class DataWifiGetPushLog
  extends DataBase
{
  private static DataWifiGetPushLog mInstance;
  
  public static DataWifiGetPushLog getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiGetPushLog();
      }
      DataWifiGetPushLog localDataWifiGetPushLog = mInstance;
      return localDataWifiGetPushLog;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public String getPushLogStrs()
  {
    return BytesUtil.getStringUTF8(this._recData);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiGetPushLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */