package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataGimbalGetPushHandheldStickState
  extends DataBase
{
  private static DataGimbalGetPushHandheldStickState instance;
  
  public static DataGimbalGetPushHandheldStickState getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalGetPushHandheldStickState();
      }
      DataGimbalGetPushHandheldStickState localDataGimbalGetPushHandheldStickState = instance;
      return localDataGimbalGetPushHandheldStickState;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getStickX()
  {
    return 0;
  }
  
  public int getStickY()
  {
    return 0;
  }
  
  public boolean isStickGimbalControlEnabled()
  {
    return false;
  }
  
  public boolean isTriggerPressed()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetPushHandheldStickState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */