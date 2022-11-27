package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.util.BytesUtil;

public class DataEyeGetPushPointLog
  extends DataBase
{
  private static DataEyeGetPushPointLog instance;
  
  public static DataEyeGetPushPointLog getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushPointLog();
      }
      DataEyeGetPushPointLog localDataEyeGetPushPointLog = instance;
      return localDataEyeGetPushPointLog;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public String getLog()
  {
    return BytesUtil.getStringUTF8(this._recData);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushPointLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */