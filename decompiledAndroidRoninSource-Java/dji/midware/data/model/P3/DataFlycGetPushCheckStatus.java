package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushCheckStatus
  extends DataBase
{
  private static DataFlycGetPushCheckStatus instance;
  
  public static DataFlycGetPushCheckStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushCheckStatus();
      }
      DataFlycGetPushCheckStatus localDataFlycGetPushCheckStatus = instance;
      return localDataFlycGetPushCheckStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean getAccDataStatus()
  {
    return false;
  }
  
  public boolean getAircraftAttiStatus()
  {
    return false;
  }
  
  public boolean getDataLoggerStatus()
  {
    return false;
  }
  
  public boolean getGyroscopeStatus()
  {
    return false;
  }
  
  public boolean getIMUAdvanceCaliStatus()
  {
    return false;
  }
  
  public boolean getIMUBasicCaliStatus()
  {
    return false;
  }
  
  public boolean getIMUDataStatus()
  {
    return false;
  }
  
  public boolean getIMUDirectionStatus()
  {
    return false;
  }
  
  public boolean getIMUHorizontalCaliStatus()
  {
    return false;
  }
  
  public boolean getIMUInitStatus()
  {
    return false;
  }
  
  public boolean getLastIMUAdvanceCaliStatus()
  {
    return false;
  }
  
  public boolean getLastIMUBasicCaliStatus()
  {
    return false;
  }
  
  public boolean getPressDataStatus()
  {
    return false;
  }
  
  public boolean getPressInitStatus()
  {
    return false;
  }
  
  public boolean getVersionStatus()
  {
    return false;
  }
  
  public boolean isOK()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushCheckStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */