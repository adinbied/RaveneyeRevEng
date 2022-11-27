package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycWayPointMissionPauseOrResume
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycWayPointMissionPauseOrResume instance;
  private CMD cmd;
  
  public static DataFlycWayPointMissionPauseOrResume getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycWayPointMissionPauseOrResume();
      }
      DataFlycWayPointMissionPauseOrResume localDataFlycWayPointMissionPauseOrResume = instance;
      return localDataFlycWayPointMissionPauseOrResume;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public DataFlycWayPointMissionPauseOrResume setCMD(CMD paramCMD)
  {
    this.cmd = paramCMD;
    return this;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum CMD
  {
    private int data;
    
    static
    {
      CMD localCMD = new CMD("RESUME", 1, 1);
      RESUME = localCMD;
      $VALUES = new CMD[] { PAUSE, localCMD };
    }
    
    private CMD(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CMD find(int paramInt)
    {
      CMD localCMD = RESUME;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localCMD;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycWayPointMissionPauseOrResume.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */