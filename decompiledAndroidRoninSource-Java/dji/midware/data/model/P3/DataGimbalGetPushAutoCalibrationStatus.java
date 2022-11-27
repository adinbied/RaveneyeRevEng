package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataGimbalGetPushAutoCalibrationStatus
  extends DataBase
{
  private static DataGimbalGetPushAutoCalibrationStatus instance;
  
  public static DataGimbalGetPushAutoCalibrationStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalGetPushAutoCalibrationStatus();
      }
      DataGimbalGetPushAutoCalibrationStatus localDataGimbalGetPushAutoCalibrationStatus = instance;
      return localDataGimbalGetPushAutoCalibrationStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getProgress(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getStatus()
  {
    return 0;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetPushAutoCalibrationStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */