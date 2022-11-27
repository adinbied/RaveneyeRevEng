package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcSetPowerMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcSetPowerMode mInstance;
  private DJIRcPowerMode mode = null;
  
  public static DataRcSetPowerMode getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataRcSetPowerMode();
      }
      DataRcSetPowerMode localDataRcSetPowerMode = mInstance;
      return localDataRcSetPowerMode;
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
  
  public DataRcSetPowerMode setMode(DJIRcPowerMode paramDJIRcPowerMode)
  {
    this.mode = paramDJIRcPowerMode;
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
  
  public static enum DJIRcPowerMode
  {
    private int data;
    
    static
    {
      DJIRcPowerMode localDJIRcPowerMode = new DJIRcPowerMode("OTHER", 2, 100);
      OTHER = localDJIRcPowerMode;
      $VALUES = new DJIRcPowerMode[] { CE, FCC, localDJIRcPowerMode };
    }
    
    private DJIRcPowerMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DJIRcPowerMode find(int paramInt)
    {
      DJIRcPowerMode localDJIRcPowerMode = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDJIRcPowerMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetPowerMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */