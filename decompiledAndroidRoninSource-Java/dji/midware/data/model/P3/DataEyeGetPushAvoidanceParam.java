package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushAvoidanceParam
  extends DataBase
{
  private static DataEyeGetPushAvoidanceParam instance;
  
  public static DataEyeGetPushAvoidanceParam getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushAvoidanceParam();
      }
      DataEyeGetPushAvoidanceParam localDataEyeGetPushAvoidanceParam = instance;
      return localDataEyeGetPushAvoidanceParam;
    }
    finally {}
  }
  
  public boolean allowBack()
  {
    return false;
  }
  
  public boolean allowFront()
  {
    return false;
  }
  
  public boolean allowLeft()
  {
    return false;
  }
  
  public boolean allowRight()
  {
    return false;
  }
  
  public boolean beShuttleMode()
  {
    return false;
  }
  
  protected void doPack() {}
  
  public int getAvoidBehindAlertLevel()
  {
    return 0;
  }
  
  public int getAvoidBehindDistanceLevel()
  {
    return 0;
  }
  
  public int getAvoidFrontAlertLevel()
  {
    return 0;
  }
  
  public int getAvoidFrontDistanceLevel()
  {
    return 0;
  }
  
  public int getAvoidLeftAlertLevel()
  {
    return 0;
  }
  
  public int getAvoidLeftDistanceLevel()
  {
    return 0;
  }
  
  public int getAvoidRightAlertLevel()
  {
    return 0;
  }
  
  public int getAvoidRightDistanceLevel()
  {
    return 0;
  }
  
  public int getIndex()
  {
    return 0;
  }
  
  public boolean isAvoidBehindWork()
  {
    return false;
  }
  
  public boolean isAvoidFrontWork()
  {
    return false;
  }
  
  public boolean isAvoidLeftWork()
  {
    return false;
  }
  
  public boolean isAvoidOpen()
  {
    return false;
  }
  
  public boolean isAvoidRightWork()
  {
    return false;
  }
  
  public boolean isBraking()
  {
    return false;
  }
  
  public boolean isVisualSensorWorking()
  {
    return false;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    setRecData(paramArrayOfByte);
    if (isWantPush()) {
      post();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushAvoidanceParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */