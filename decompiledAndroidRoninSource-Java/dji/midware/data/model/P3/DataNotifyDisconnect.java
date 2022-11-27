package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataAsync2Listener;

public class DataNotifyDisconnect
  extends DataBase
  implements DJIDataAsync2Listener
{
  private static DataNotifyDisconnect instance;
  
  public static DataNotifyDisconnect getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataNotifyDisconnect();
      }
      DataNotifyDisconnect localDataNotifyDisconnect = instance;
      return localDataNotifyDisconnect;
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
  
  public RebootReason getRebootReason()
  {
    return null;
  }
  
  public int getTimeout()
  {
    return 0;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum RebootReason
  {
    private int data;
    
    static
    {
      RebootReason localRebootReason = new RebootReason("OTHER", 2, 7);
      OTHER = localRebootReason;
      $VALUES = new RebootReason[] { For1860, ForAircraft, localRebootReason };
    }
    
    private RebootReason(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static RebootReason find(int paramInt)
    {
      RebootReason localRebootReason = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localRebootReason;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataNotifyDisconnect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */