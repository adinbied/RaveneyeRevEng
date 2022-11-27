package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdOsmoPushCalibration
  extends DataBase
{
  private static DataOsdOsmoPushCalibration instance;
  
  public static DataOsdOsmoPushCalibration getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdOsmoPushCalibration();
      }
      DataOsdOsmoPushCalibration localDataOsdOsmoPushCalibration = instance;
      return localDataOsdOsmoPushCalibration;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getCompassStatus()
  {
    return 0;
  }
  
  public int getMotorStatus()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdOsmoPushCalibration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */