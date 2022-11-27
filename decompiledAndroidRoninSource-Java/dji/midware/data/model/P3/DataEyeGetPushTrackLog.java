package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.util.BytesUtil;

public class DataEyeGetPushTrackLog
  extends DataBase
{
  private static DataEyeGetPushTrackLog instance;
  
  public static DataEyeGetPushTrackLog getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushTrackLog();
      }
      DataEyeGetPushTrackLog localDataEyeGetPushTrackLog = instance;
      return localDataEyeGetPushTrackLog;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public String getLog()
  {
    return BytesUtil.getStringUTF8(this._recData);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushTrackLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */