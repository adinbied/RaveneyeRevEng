package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICommonDataBase;

public class DataFlycGetPushPowerParam
  extends DJICommonDataBase
{
  private static DataFlycGetPushPowerParam instance;
  
  public static DataFlycGetPushPowerParam getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushPowerParam();
      }
      DataFlycGetPushPowerParam localDataFlycGetPushPowerParam = instance;
      return localDataFlycGetPushPowerParam;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public float getEscAverageSpeed()
  {
    return 0.0F;
  }
  
  public float getLift()
  {
    return 0.0F;
  }
  
  public float getPowerPercentage()
  {
    return 0.0F;
  }
  
  public float getRemainingPower()
  {
    return 0.0F;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushPowerParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */