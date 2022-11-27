package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataCenterGetPushPackModeFailReason
  extends DataBase
{
  private static DataCenterGetPushPackModeFailReason instance;
  
  public static DataCenterGetPushPackModeFailReason getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCenterGetPushPackModeFailReason();
      }
      DataCenterGetPushPackModeFailReason localDataCenterGetPushPackModeFailReason = instance;
      return localDataCenterGetPushPackModeFailReason;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getPackType()
  {
    return 0;
  }
  
  public boolean isDronePlaceError()
  {
    return false;
  }
  
  public boolean isGimbalPositonError()
  {
    return false;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    setRecData(paramArrayOfByte);
    if ((isWantPush()) && (this.isRegist)) {
      post();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCenterGetPushPackModeFailReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */