package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycGetVoltageWarnning
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycGetVoltageWarnning instance;
  private WarnningLevel level;
  
  public static DataFlycGetVoltageWarnning getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetVoltageWarnning();
      }
      DataFlycGetVoltageWarnning localDataFlycGetVoltageWarnning = instance;
      return localDataFlycGetVoltageWarnning;
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
  
  public int getValue()
  {
    return 0;
  }
  
  public WarnningLevel getWarnningLevel()
  {
    return null;
  }
  
  public boolean isNeedGoHome()
  {
    return false;
  }
  
  public boolean isNeedLanding()
  {
    return false;
  }
  
  public void setWarnningLevel(WarnningLevel paramWarnningLevel)
  {
    this.level = paramWarnningLevel;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum WarnningLevel
  {
    private int data;
    
    static
    {
      WarnningLevel localWarnningLevel = new WarnningLevel("OTHER", 2, 100);
      OTHER = localWarnningLevel;
      $VALUES = new WarnningLevel[] { First, Second, localWarnningLevel };
    }
    
    private WarnningLevel(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static WarnningLevel find(int paramInt)
    {
      WarnningLevel localWarnningLevel = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localWarnningLevel;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetVoltageWarnning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */