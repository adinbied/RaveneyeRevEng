package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataWifiGetPushFirstConnectedMac
  extends DataBase
{
  private static DataWifiGetPushFirstConnectedMac mInstance;
  
  public static DataWifiGetPushFirstConnectedMac getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiGetPushFirstConnectedMac();
      }
      DataWifiGetPushFirstConnectedMac localDataWifiGetPushFirstConnectedMac = mInstance;
      return localDataWifiGetPushFirstConnectedMac;
    }
    finally {}
  }
  
  protected void doPack() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiGetPushFirstConnectedMac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */