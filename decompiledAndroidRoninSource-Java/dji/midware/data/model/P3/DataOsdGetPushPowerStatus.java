package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJIOsdDataBase;

public class DataOsdGetPushPowerStatus
  extends DJIOsdDataBase
{
  private static DataOsdGetPushPowerStatus instance;
  
  public static DataOsdGetPushPowerStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushPowerStatus();
      }
      DataOsdGetPushPowerStatus localDataOsdGetPushPowerStatus = instance;
      return localDataOsdGetPushPowerStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean getIsPowerOff()
  {
    return false;
  }
  
  public int getPowerStatus()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushPowerStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */