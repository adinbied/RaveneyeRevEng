package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushPointAvoidance
  extends DataBase
{
  private static DataEyeGetPushPointAvoidance instance;
  
  public static DataEyeGetPushPointAvoidance getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushPointAvoidance();
      }
      DataEyeGetPushPointAvoidance localDataEyeGetPushPointAvoidance = instance;
      return localDataEyeGetPushPointAvoidance;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getAlertLevel()
  {
    return 0;
  }
  
  public int getObserveCount()
  {
    return 0;
  }
  
  public int[] getObserveValues()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushPointAvoidance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */