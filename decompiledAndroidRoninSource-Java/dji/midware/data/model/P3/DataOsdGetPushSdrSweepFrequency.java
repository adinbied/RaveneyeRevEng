package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetPushSdrSweepFrequency
  extends DataBase
{
  private static DataOsdGetPushSdrSweepFrequency instance;
  
  public static DataOsdGetPushSdrSweepFrequency getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushSdrSweepFrequency();
      }
      DataOsdGetPushSdrSweepFrequency localDataOsdGetPushSdrSweepFrequency = instance;
      return localDataOsdGetPushSdrSweepFrequency;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int[] getSignalList()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushSdrSweepFrequency.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */