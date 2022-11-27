package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushRTKLocationData
  extends DataBase
{
  private static DataFlycGetPushRTKLocationData instance;
  
  public static DataFlycGetPushRTKLocationData getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushRTKLocationData();
      }
      DataFlycGetPushRTKLocationData localDataFlycGetPushRTKLocationData = instance;
      return localDataFlycGetPushRTKLocationData;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getHeading()
  {
    return 0;
  }
  
  public float getHeight()
  {
    return 0.0F;
  }
  
  public double getLatitude()
  {
    return 1.37188384E-315D;
  }
  
  public double getLongitude()
  {
    return 1.371883857E-315D;
  }
  
  public boolean isRTKCanbeUsed()
  {
    return false;
  }
  
  public boolean isRTKConnected()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushRTKLocationData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */