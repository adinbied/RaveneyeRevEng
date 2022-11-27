package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataDm368GetPushStatus
  extends DataBase
{
  private static DataDm368GetPushStatus instance;
  
  public static DataDm368GetPushStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataDm368GetPushStatus();
      }
      DataDm368GetPushStatus localDataDm368GetPushStatus = instance;
      return localDataDm368GetPushStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getDualEncodeModePercentage()
  {
    return 0;
  }
  
  public int getEncodeMode()
  {
    return 0;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public boolean isDisableLiveview()
  {
    return false;
  }
  
  public boolean isDualEncodeModeSupported()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataDm368GetPushStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */