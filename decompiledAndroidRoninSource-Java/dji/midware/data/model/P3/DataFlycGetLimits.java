package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycGetLimits
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycGetLimits instance;
  private MODE mode;
  
  public static DataFlycGetLimits getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetLimits();
      }
      DataFlycGetLimits localDataFlycGetLimits = instance;
      return localDataFlycGetLimits;
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
  
  public int getValue()
  {
    return 0;
  }
  
  public DataFlycGetLimits setMode(MODE paramMODE)
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
      Far = new MODE("Far", 1, 2);
      Low = new MODE("Low", 2, 3);
      MODE localMODE = new MODE("OTHER", 3, 100);
      OTHER = localMODE;
      $VALUES = new MODE[] { High, Far, Low, localMODE };
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetLimits.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */