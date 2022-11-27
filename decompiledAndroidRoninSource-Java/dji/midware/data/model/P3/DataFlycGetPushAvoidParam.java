package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushAvoidParam
  extends DataBase
{
  private static DataFlycGetPushAvoidParam instance;
  
  public static DataFlycGetPushAvoidParam getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushAvoidParam();
      }
      DataFlycGetPushAvoidParam localDataFlycGetPushAvoidParam = instance;
      return localDataFlycGetPushAvoidParam;
    }
    finally {}
  }
  
  public boolean avoidGroundForceLanding()
  {
    return false;
  }
  
  protected void doPack() {}
  
  public boolean getAvoidObstacleWorkFlag()
  {
    return false;
  }
  
  public boolean getEmergencyBrakeWorkFlag()
  {
    return false;
  }
  
  public boolean gohomeAvoidEnable()
  {
    return false;
  }
  
  public boolean hitGroundLimitWorkFlag()
  {
    return false;
  }
  
  public boolean horizNearBoundary()
  {
    return false;
  }
  
  public boolean isAirportLimitWorking()
  {
    return false;
  }
  
  public boolean isAvoidObstacleEnable()
  {
    return false;
  }
  
  public boolean isAvoidObstacleWorking()
  {
    return false;
  }
  
  public boolean isAvoidOvershotAct()
  {
    return false;
  }
  
  public boolean isRadiusLimitWorking()
  {
    return false;
  }
  
  public boolean isUserAvoidEnable()
  {
    return false;
  }
  
  public boolean roofLimitWorkFlag()
  {
    return false;
  }
  
  public boolean vertAirportLimitWorkFlag()
  {
    return false;
  }
  
  public boolean vertLowLimitWorkFlag()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushAvoidParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */