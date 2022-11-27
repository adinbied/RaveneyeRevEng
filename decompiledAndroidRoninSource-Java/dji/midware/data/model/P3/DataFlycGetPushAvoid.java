package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushAvoid
  extends DataBase
{
  private static DataFlycGetPushAvoid instance;
  private final int[] mDistances = new int[4];
  
  public static DataFlycGetPushAvoid getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushAvoid();
      }
      DataFlycGetPushAvoid localDataFlycGetPushAvoid = instance;
      return localDataFlycGetPushAvoid;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int[] getDistance()
  {
    return null;
  }
  
  public boolean isInStop()
  {
    return false;
  }
  
  public boolean isVisualSensorEnable()
  {
    return false;
  }
  
  public boolean isVisualSensorWork()
  {
    return false;
  }
  
  public void setRecData(byte[] paramArrayOfByte)
  {
    super.setRecData(paramArrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushAvoid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */