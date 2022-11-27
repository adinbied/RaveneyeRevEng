package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOfdmGetPushCheckStatus
  extends DataBase
{
  private static DataOfdmGetPushCheckStatus instance;
  
  public static DataOfdmGetPushCheckStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOfdmGetPushCheckStatus();
      }
      DataOfdmGetPushCheckStatus localDataOfdmGetPushCheckStatus = instance;
      return localDataOfdmGetPushCheckStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean isFirmwareNotMatch()
  {
    return false;
  }
  
  public boolean isOK()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOfdmGetPushCheckStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */