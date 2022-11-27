package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataGimbalGetPushCheckStatus
  extends DataBase
{
  private static DataGimbalGetPushCheckStatus instance;
  
  public static DataGimbalGetPushCheckStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalGetPushCheckStatus();
      }
      DataGimbalGetPushCheckStatus localDataGimbalGetPushCheckStatus = instance;
      return localDataGimbalGetPushCheckStatus;
    }
    finally {}
  }
  
  private boolean isHandheldGimbal()
  {
    return false;
  }
  
  protected void doPack() {}
  
  public boolean getCalibration()
  {
    return false;
  }
  
  public boolean getDataReceiveStatus()
  {
    return false;
  }
  
  public boolean getGimbalCalibrateIsError()
  {
    return false;
  }
  
  public boolean getGyroscopeStatus()
  {
    return false;
  }
  
  public boolean getIMUCalibrateMatchStatus()
  {
    return false;
  }
  
  public boolean getJoystickStatus()
  {
    return false;
  }
  
  public int getLimitStatus()
  {
    return 0;
  }
  
  public boolean getPitchMotorStatus()
  {
    return false;
  }
  
  public boolean getPitchStatus()
  {
    return false;
  }
  
  public boolean getPosture()
  {
    return false;
  }
  
  public boolean getRollMotorStatus()
  {
    return false;
  }
  
  public boolean getRollStatus()
  {
    return false;
  }
  
  public boolean getVibrateStatus()
  {
    return false;
  }
  
  public boolean getYawMotorStatus()
  {
    return false;
  }
  
  public boolean getYawStatus()
  {
    return false;
  }
  
  public boolean getZeroPosition()
  {
    return false;
  }
  
  public boolean hasException()
  {
    return false;
  }
  
  public boolean isConnectBackupGPS()
  {
    return false;
  }
  
  public boolean isConnectGPS()
  {
    return false;
  }
  
  public boolean isConnectLiveView()
  {
    return false;
  }
  
  public boolean isConnectRemoteControl()
  {
    return false;
  }
  
  public boolean isConnectShutter()
  {
    return false;
  }
  
  public boolean isConnectZoomFocus()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetPushCheckStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */