package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataCenterGetPushBatteryInPosition
  extends DataBase
{
  private static DataCenterGetPushBatteryInPosition instance;
  
  public static DataCenterGetPushBatteryInPosition getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCenterGetPushBatteryInPosition();
      }
      DataCenterGetPushBatteryInPosition localDataCenterGetPushBatteryInPosition = instance;
      return localDataCenterGetPushBatteryInPosition;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int[] getBatteryInPosition()
  {
    return null;
  }
  
  public int getBatteryNum()
  {
    return 0;
  }
  
  public boolean hasError()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCenterGetPushBatteryInPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */