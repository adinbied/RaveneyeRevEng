package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;

public class DataGimbalGetPushUserParams
  extends DJICameraDataBase
{
  private static DataGimbalGetPushUserParams instance;
  
  public static DataGimbalGetPushUserParams getInstance()
  {
    try
    {
      if (instance == null)
      {
        localDataGimbalGetPushUserParams = new DataGimbalGetPushUserParams();
        instance = localDataGimbalGetPushUserParams;
        localDataGimbalGetPushUserParams.isNeedPushLosed = true;
        instance.isRemoteModel = true;
      }
      DataGimbalGetPushUserParams localDataGimbalGetPushUserParams = instance;
      return localDataGimbalGetPushUserParams;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getPitchAccel()
  {
    return 0;
  }
  
  public int getPitchDeadband()
  {
    return 0;
  }
  
  public int getPitchSmoothTrack()
  {
    return 0;
  }
  
  public int getPitchSpeed()
  {
    return 0;
  }
  
  public int getPresetID(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getRollAccel()
  {
    return 0;
  }
  
  public int getRollDeadband()
  {
    return 0;
  }
  
  public int getRollSmoothTrack()
  {
    return 0;
  }
  
  public int getRollSpeed()
  {
    return 0;
  }
  
  public int getStickPitchSmooth()
  {
    return 0;
  }
  
  public int getStickPitchSpeed()
  {
    return 0;
  }
  
  public int getStickYawSmooth()
  {
    return 0;
  }
  
  public int getStickYawSpeed()
  {
    return 0;
  }
  
  public int getYawAccel()
  {
    return 0;
  }
  
  public int getYawDeadband()
  {
    return 0;
  }
  
  public int getYawSmoothTrack()
  {
    return 0;
  }
  
  public int getYawSpeed()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetPushUserParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */