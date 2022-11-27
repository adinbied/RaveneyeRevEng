package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetPushCheckStatus
  extends DataBase
{
  private static DataOsdGetPushCheckStatus instance;
  
  public static DataOsdGetPushCheckStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushCheckStatus();
      }
      DataOsdGetPushCheckStatus localDataOsdGetPushCheckStatus = instance;
      return localDataOsdGetPushCheckStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean get58GinitStatus()
  {
    return false;
  }
  
  public boolean getEncryptStatus()
  {
    return false;
  }
  
  public boolean getF330initStatus()
  {
    return false;
  }
  
  public boolean getFPGAinitStatus()
  {
    return false;
  }
  
  public boolean getGPSinitStatus()
  {
    return false;
  }
  
  public boolean getPowerStatus()
  {
    return false;
  }
  
  public boolean getResetStatus()
  {
    return false;
  }
  
  public boolean getStickMiddleStatus()
  {
    return false;
  }
  
  public boolean getTimeoutStatus()
  {
    return false;
  }
  
  public boolean isInHighTemperature()
  {
    return false;
  }
  
  public boolean isOK()
  {
    return false;
  }
  
  /* Error */
  protected void setPushRecPack(dji.midware.data.packages.P3.Pack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushCheckStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */