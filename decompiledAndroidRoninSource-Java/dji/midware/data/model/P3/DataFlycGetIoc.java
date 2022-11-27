package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycGetIoc
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycGetIoc instance;
  
  public static DataFlycGetIoc getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetIoc();
      }
      DataFlycGetIoc localDataFlycGetIoc = instance;
      return localDataFlycGetIoc;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public MODE getMode()
  {
    return null;
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
      MODE localMODE = new MODE("OTHER", 3, 100);
      OTHER = localMODE;
      $VALUES = new MODE[] { CourseLock, HomeLock, HotspotSurround, localMODE };
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetIoc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */