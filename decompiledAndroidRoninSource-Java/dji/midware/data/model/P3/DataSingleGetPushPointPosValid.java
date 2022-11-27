package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataSingleGetPushPointPosValid
  extends DataBase
{
  private static DataSingleGetPushPointPosValid instance;
  
  public static DataSingleGetPushPointPosValid getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataSingleGetPushPointPosValid();
      }
      DataSingleGetPushPointPosValid localDataSingleGetPushPointPosValid = instance;
      return localDataSingleGetPushPointPosValid;
    }
    finally {}
  }
  
  public boolean canFly()
  {
    return false;
  }
  
  protected void doPack() {}
  
  public short getErrorCode()
  {
    return 0;
  }
  
  public int getSessionId()
  {
    return 0;
  }
  
  public boolean hasObstacle()
  {
    return false;
  }
  
  public boolean isFovLimetReached()
  {
    return false;
  }
  
  public boolean isInRestrictedArea()
  {
    return false;
  }
  
  public boolean isNotFlying()
  {
    return false;
  }
  
  public boolean isPointedAreaInvalid()
  {
    return false;
  }
  
  public boolean isRouteCollectionLoadFailed()
  {
    return false;
  }
  
  public boolean isTooHigh()
  {
    return false;
  }
  
  public boolean isTooLow()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSingleGetPushPointPosValid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */