package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetSDRPushCustomCodeRate
  extends DataBase
{
  private static DataOsdGetSDRPushCustomCodeRate instance;
  
  public static DataOsdGetSDRPushCustomCodeRate getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetSDRPushCustomCodeRate();
      }
      DataOsdGetSDRPushCustomCodeRate localDataOsdGetSDRPushCustomCodeRate = instance;
      return localDataOsdGetSDRPushCustomCodeRate;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public float getCodeRate()
  {
    return 0.0F;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetSDRPushCustomCodeRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */