package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycNavigationSwitch
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycNavigationSwitch instance;
  private int mRetryTimes = 2;
  private GS_COMMAND type;
  
  public static DataFlycNavigationSwitch getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycNavigationSwitch();
      }
      DataFlycNavigationSwitch localDataFlycNavigationSwitch = instance;
      return localDataFlycNavigationSwitch;
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
  
  public DataFlycNavigationSwitch setCommand(GS_COMMAND paramGS_COMMAND)
  {
    this.type = paramGS_COMMAND;
    return this;
  }
  
  public DataFlycNavigationSwitch setRetryTimes(int paramInt)
  {
    this.mRetryTimes = paramInt;
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
  
  public static enum GS_COMMAND
  {
    private int data;
    
    static
    {
      CLOSE_GROUND_STATION = new GS_COMMAND("CLOSE_GROUND_STATION", 1, 2);
      GS_COMMAND localGS_COMMAND = new GS_COMMAND("OTHER", 2, 100);
      OTHER = localGS_COMMAND;
      $VALUES = new GS_COMMAND[] { OPEN_GROUND_STATION, CLOSE_GROUND_STATION, localGS_COMMAND };
    }
    
    private GS_COMMAND(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static GS_COMMAND find(int paramInt)
    {
      GS_COMMAND localGS_COMMAND = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localGS_COMMAND;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycNavigationSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */