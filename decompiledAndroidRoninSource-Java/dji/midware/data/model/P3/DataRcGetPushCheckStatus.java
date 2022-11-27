package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataRcGetPushCheckStatus
  extends DataBase
{
  private static DataRcGetPushCheckStatus instance;
  
  public static DataRcGetPushCheckStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetPushCheckStatus();
      }
      DataRcGetPushCheckStatus localDataRcGetPushCheckStatus = instance;
      return localDataRcGetPushCheckStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean getIs5_8ModuleInitError()
  {
    return false;
  }
  
  public boolean getIsEncryptionError()
  {
    return false;
  }
  
  public boolean getIsF330ModuleInitError()
  {
    return false;
  }
  
  public boolean getIsFpgaInitError()
  {
    return false;
  }
  
  public boolean getIsGpsInitError()
  {
    return false;
  }
  
  public boolean getIsIdleTooLong()
  {
    return false;
  }
  
  public boolean getIsRcBatteryTooLow()
  {
    return false;
  }
  
  public boolean getIsRcOverHeat()
  {
    return false;
  }
  
  public boolean getIsReseted()
  {
    return false;
  }
  
  public boolean getNeedCalibration()
  {
    return false;
  }
  
  public boolean isInStrongMagneticDistrub()
  {
    return false;
  }
  
  public boolean isInWeakMageneticDistrub()
  {
    return false;
  }
  
  public boolean isInWeakMageneticDistrubDetectedFromRC()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetPushCheckStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */