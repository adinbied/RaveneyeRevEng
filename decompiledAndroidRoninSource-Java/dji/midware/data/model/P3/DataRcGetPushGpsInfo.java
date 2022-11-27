package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataRcGetPushGpsInfo
  extends DataBase
{
  private static DataRcGetPushGpsInfo instance;
  
  public DataRcGetPushGpsInfo() {}
  
  public DataRcGetPushGpsInfo(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public static DataRcGetPushGpsInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetPushGpsInfo();
      }
      DataRcGetPushGpsInfo localDataRcGetPushGpsInfo = instance;
      return localDataRcGetPushGpsInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public Float getAccuracy()
  {
    return null;
  }
  
  public short getDay()
  {
    return 0;
  }
  
  public int getGpsNum()
  {
    return 0;
  }
  
  public boolean getGpsStatus()
  {
    return false;
  }
  
  public short getHour()
  {
    return 0;
  }
  
  public double getLatitude()
  {
    return 1.37196187E-315D;
  }
  
  public double getLongitude()
  {
    return 1.37196189E-315D;
  }
  
  public short getMinute()
  {
    return 0;
  }
  
  public short getMonth()
  {
    return 0;
  }
  
  public short getSecond()
  {
    return 0;
  }
  
  public int getXSpeed()
  {
    return 0;
  }
  
  public int getYSpeed()
  {
    return 0;
  }
  
  public int getYear()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetPushGpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */