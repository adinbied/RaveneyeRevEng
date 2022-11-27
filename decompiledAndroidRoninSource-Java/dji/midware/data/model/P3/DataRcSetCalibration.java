package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcSetCalibration
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcSetCalibration instance;
  private MODE mode;
  
  public static DataRcSetCalibration getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSetCalibration();
      }
      DataRcSetCalibration localDataRcSetCalibration = instance;
      return localDataRcSetCalibration;
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
  
  public MODE getMode()
  {
    return null;
  }
  
  public DataRcSetCalibration setMode(MODE paramMODE)
  {
    this.mode = paramMODE;
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
  
  public static enum MODE
  {
    private int data;
    
    static
    {
      Middle = new MODE("Middle", 1, 1);
      Limits = new MODE("Limits", 2, 2);
      Quit = new MODE("Quit", 3, 3);
      TimeOut = new MODE("TimeOut", 4, 4);
      OTHER = new MODE("OTHER", 5, 6);
      MODE localMODE = new MODE("Disconnect", 6, 255);
      Disconnect = localMODE;
      $VALUES = new MODE[] { Normal, Middle, Limits, Quit, TimeOut, OTHER, localMODE };
    }
    
    private MODE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static MODE find(int paramInt)
    {
      MODE localMODE = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localMODE;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetCalibration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */