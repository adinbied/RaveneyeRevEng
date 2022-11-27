package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushActiveRequest
  extends DataBase
{
  private static DataFlycGetPushActiveRequest instance;
  
  public static DataFlycGetPushActiveRequest getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushActiveRequest();
      }
      DataFlycGetPushActiveRequest localDataFlycGetPushActiveRequest = instance;
      return localDataFlycGetPushActiveRequest;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public String getAppBundleId()
  {
    return null;
  }
  
  public int getAppId()
  {
    return 0;
  }
  
  public int getAppLevel()
  {
    return 0;
  }
  
  public int getAppVersion()
  {
    return 0;
  }
  
  public String getDevSn()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushActiveRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */