package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataOsdSetPower
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataOsdSetPower instance;
  private POWER_TYPE mPowerType = POWER_TYPE.OTHER;
  
  public static DataOsdSetPower getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdSetPower();
      }
      DataOsdSetPower localDataOsdSetPower = instance;
      return localDataOsdSetPower;
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
  
  public DataOsdSetPower setPowerType(POWER_TYPE paramPOWER_TYPE)
  {
    this.mPowerType = paramPOWER_TYPE;
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
  
  public static enum POWER_TYPE
  {
    private int data;
    
    static
    {
      AWEAK = new POWER_TYPE("AWEAK", 2, 2);
      RESET = new POWER_TYPE("RESET", 3, 3);
      POWER_OFF = new POWER_TYPE("POWER_OFF", 4, 4);
      POWER_TYPE localPOWER_TYPE = new POWER_TYPE("OTHER", 5, 10);
      OTHER = localPOWER_TYPE;
      $VALUES = new POWER_TYPE[] { NOT_CHANGE, SLEEP, AWEAK, RESET, POWER_OFF, localPOWER_TYPE };
    }
    
    private POWER_TYPE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static POWER_TYPE find(int paramInt)
    {
      POWER_TYPE localPOWER_TYPE = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPOWER_TYPE;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdSetPower.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */