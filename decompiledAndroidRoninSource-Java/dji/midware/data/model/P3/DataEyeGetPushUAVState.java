package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushUAVState
  extends DataBase
{
  private static DataEyeGetPushUAVState instance;
  
  public static DataEyeGetPushUAVState getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushUAVState();
      }
      DataEyeGetPushUAVState localDataEyeGetPushUAVState = instance;
      return localDataEyeGetPushUAVState;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public float getCurrentStepInTrajectory()
  {
    return 0.0F;
  }
  
  public int getCurrentTrajectoryIndex()
  {
    return 0;
  }
  
  public float getGimbalPitch()
  {
    return 0.0F;
  }
  
  public float getGimbalRoll()
  {
    return 0.0F;
  }
  
  public float getGimbalYaw()
  {
    return 0.0F;
  }
  
  public float getPosX()
  {
    return 0.0F;
  }
  
  public float getPosY()
  {
    return 0.0F;
  }
  
  public float getPosZ()
  {
    return 0.0F;
  }
  
  public float getRemainingDistance()
  {
    return 0.0F;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushUAVState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */