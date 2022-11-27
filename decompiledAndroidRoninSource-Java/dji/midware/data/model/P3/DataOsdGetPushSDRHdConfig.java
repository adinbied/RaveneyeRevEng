package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetPushSDRHdConfig
  extends DataBase
{
  private static DataOsdGetPushSDRHdConfig instance;
  
  public static DataOsdGetPushSDRHdConfig getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushSDRHdConfig();
      }
      DataOsdGetPushSDRHdConfig localDataOsdGetPushSDRHdConfig = instance;
      return localDataOsdGetPushSDRHdConfig;
    }
    finally {}
  }
  
  protected void doPack() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushSDRHdConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */