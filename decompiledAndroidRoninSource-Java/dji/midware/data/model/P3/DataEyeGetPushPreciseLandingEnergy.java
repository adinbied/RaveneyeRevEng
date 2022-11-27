package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushPreciseLandingEnergy
  extends DataBase
{
  private static DataEyeGetPushPreciseLandingEnergy instance;
  
  public static DataEyeGetPushPreciseLandingEnergy getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushPreciseLandingEnergy();
      }
      DataEyeGetPushPreciseLandingEnergy localDataEyeGetPushPreciseLandingEnergy = instance;
      return localDataEyeGetPushPreciseLandingEnergy;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getEnery()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushPreciseLandingEnergy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */