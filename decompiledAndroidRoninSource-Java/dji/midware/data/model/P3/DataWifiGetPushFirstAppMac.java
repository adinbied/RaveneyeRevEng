package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataWifiGetPushFirstAppMac
  extends DataBase
{
  private static DataWifiGetPushFirstAppMac mInstance;
  
  public static DataWifiGetPushFirstAppMac getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiGetPushFirstAppMac();
      }
      DataWifiGetPushFirstAppMac localDataWifiGetPushFirstAppMac = mInstance;
      return localDataWifiGetPushFirstAppMac;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public String getMac()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiGetPushFirstAppMac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */