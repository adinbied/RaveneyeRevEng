package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushTrackingStatus
  extends DataBase
{
  private static DataEyeGetPushTrackingStatus instance;
  
  public static DataEyeGetPushTrackingStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushTrackingStatus();
      }
      DataEyeGetPushTrackingStatus localDataEyeGetPushTrackingStatus = instance;
      return localDataEyeGetPushTrackingStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getSenderType()
  {
    return 0;
  }
  
  public int getTrackingStatus()
  {
    return 0;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushTrackingStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */