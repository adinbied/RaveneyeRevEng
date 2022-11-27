package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataWifiGetPushSignal
  extends DataBase
{
  private static DataWifiGetPushSignal mInstance;
  
  public static DataWifiGetPushSignal getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiGetPushSignal();
      }
      DataWifiGetPushSignal localDataWifiGetPushSignal = mInstance;
      return localDataWifiGetPushSignal;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getSignal()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiGetPushSignal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */