package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcSetGimbalControlMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcSetGimbalControlMode instance;
  private MODE mode;
  
  public static DataRcSetGimbalControlMode getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSetGimbalControlMode();
      }
      DataRcSetGimbalControlMode localDataRcSetGimbalControlMode = instance;
      return localDataRcSetGimbalControlMode;
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
  
  public DataRcSetGimbalControlMode setMode(MODE paramMODE)
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
      MODE localMODE = new MODE("OTHER", 3, 10);
      OTHER = localMODE;
      $VALUES = new MODE[] { Pitch, Roll, Yaw, localMODE };
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetGimbalControlMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */