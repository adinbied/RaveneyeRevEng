package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataRcSimPushParams
  extends DataBase
{
  public static final int MAX_VALUE = 1684;
  public static final int MID_VALUE = 1024;
  public static final int MIN_VALUE = 364;
  private static DataRcSimPushParams instance;
  
  private int getData(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public static DataRcSimPushParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSimPushParams();
      }
      DataRcSimPushParams localDataRcSimPushParams = instance;
      return localDataRcSimPushParams;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getAileron()
  {
    return getData(0, 2);
  }
  
  public int getElevator()
  {
    return getData(2, 2);
  }
  
  public int getRudder()
  {
    return getData(6, 2);
  }
  
  public int getThrottle()
  {
    return getData(4, 2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSimPushParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */