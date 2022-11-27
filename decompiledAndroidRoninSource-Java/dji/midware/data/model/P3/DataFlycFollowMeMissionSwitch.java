package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycFollowMeMissionSwitch
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycFollowMeMissionSwitch instance;
  private FOLLOWMEMISSIONSWITCH missionSwitch;
  
  public static DataFlycFollowMeMissionSwitch getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycFollowMeMissionSwitch();
      }
      DataFlycFollowMeMissionSwitch localDataFlycFollowMeMissionSwitch = instance;
      return localDataFlycFollowMeMissionSwitch;
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
  
  public DataFlycFollowMeMissionSwitch missionSwitch(FOLLOWMEMISSIONSWITCH paramFOLLOWMEMISSIONSWITCH)
  {
    this.missionSwitch = paramFOLLOWMEMISSIONSWITCH;
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
  
  public static enum FOLLOWMEMISSIONSWITCH
  {
    private int data;
    
    static
    {
      FOLLOWMEMISSIONSWITCH localFOLLOWMEMISSIONSWITCH = new FOLLOWMEMISSIONSWITCH("RESUME", 1, 1);
      RESUME = localFOLLOWMEMISSIONSWITCH;
      $VALUES = new FOLLOWMEMISSIONSWITCH[] { PAUSE, localFOLLOWMEMISSIONSWITCH };
    }
    
    private FOLLOWMEMISSIONSWITCH(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FOLLOWMEMISSIONSWITCH find(int paramInt)
    {
      FOLLOWMEMISSIONSWITCH localFOLLOWMEMISSIONSWITCH = PAUSE;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFOLLOWMEMISSIONSWITCH;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycFollowMeMissionSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */