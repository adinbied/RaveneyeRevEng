package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcSetFrequency
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcSetFrequency instance;
  private FreqMode mode;
  
  public static DataRcSetFrequency getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSetFrequency();
      }
      DataRcSetFrequency localDataRcSetFrequency = instance;
      return localDataRcSetFrequency;
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
  
  public FreqCcode getCcode()
  {
    return null;
  }
  
  public DataRcSetFrequency setMode(FreqMode paramFreqMode)
  {
    this.mode = paramFreqMode;
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
  
  public static enum FreqCcode
  {
    private int data;
    
    static
    {
      Finish = new FreqCcode("Finish", 2, 2);
      FreqCcode localFreqCcode = new FreqCcode("OTHER", 3, 6);
      OTHER = localFreqCcode;
      $VALUES = new FreqCcode[] { Idle, Progress, Finish, localFreqCcode };
    }
    
    private FreqCcode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FreqCcode find(int paramInt)
    {
      FreqCcode localFreqCcode = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFreqCcode;
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
  
  public static enum FreqMode
  {
    private int data;
    
    static
    {
      Cancel = new FreqMode("Cancel", 2, 2);
      MasterEnter = new FreqMode("MasterEnter", 3, 5);
      SlaveEnter = new FreqMode("SlaveEnter", 4, 6);
      SubEnter = new FreqMode("SubEnter", 5, 7);
      FreqMode localFreqMode = new FreqMode("OTHER", 6, 10);
      OTHER = localFreqMode;
      $VALUES = new FreqMode[] { Current, Enter, Cancel, MasterEnter, SlaveEnter, SubEnter, localFreqMode };
    }
    
    private FreqMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FreqMode find(int paramInt)
    {
      FreqMode localFreqMode = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFreqMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetFrequency.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */