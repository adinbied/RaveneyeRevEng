package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetPushSweepFrequency
  extends DataBase
{
  private static DataOsdGetPushSweepFrequency instance;
  
  public static DataOsdGetPushSweepFrequency getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushSweepFrequency();
      }
      DataOsdGetPushSweepFrequency localDataOsdGetPushSweepFrequency = instance;
      return localDataOsdGetPushSweepFrequency;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int[] getSignalList()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushSweepFrequency.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */