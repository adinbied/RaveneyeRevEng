package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataWifiSetPowerMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataWifiSetPowerMode mInstance;
  private DJIWifiPowerMode mode = null;
  
  public static DataWifiSetPowerMode getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiSetPowerMode();
      }
      DataWifiSetPowerMode localDataWifiSetPowerMode = mInstance;
      return localDataWifiSetPowerMode;
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
  
  public DataWifiSetPowerMode setMode(DJIWifiPowerMode paramDJIWifiPowerMode)
  {
    this.mode = paramDJIWifiPowerMode;
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
  
  public static enum DJIWifiPowerMode
  {
    private int data;
    
    static
    {
      CE = new DJIWifiPowerMode("CE", 1, 1);
      DJIWifiPowerMode localDJIWifiPowerMode = new DJIWifiPowerMode("OTHER", 2, 100);
      OTHER = localDJIWifiPowerMode;
      $VALUES = new DJIWifiPowerMode[] { FCC, CE, localDJIWifiPowerMode };
    }
    
    private DJIWifiPowerMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DJIWifiPowerMode find(int paramInt)
    {
      DJIWifiPowerMode localDJIWifiPowerMode = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDJIWifiPowerMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiSetPowerMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */