package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycHotPointMissionSwitch
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycHotPointMissionSwitch instance;
  private HOTPOINTMISSIONSWITCH missionSwitch;
  
  public static DataFlycHotPointMissionSwitch getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycHotPointMissionSwitch();
      }
      DataFlycHotPointMissionSwitch localDataFlycHotPointMissionSwitch = instance;
      return localDataFlycHotPointMissionSwitch;
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
  
  /* Error */
  public void printResult()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataFlycHotPointMissionSwitch setSwitch(HOTPOINTMISSIONSWITCH paramHOTPOINTMISSIONSWITCH)
  {
    this.missionSwitch = paramHOTPOINTMISSIONSWITCH;
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
  
  public static enum HOTPOINTMISSIONSWITCH
  {
    private int data;
    
    static
    {
      HOTPOINTMISSIONSWITCH localHOTPOINTMISSIONSWITCH = new HOTPOINTMISSIONSWITCH("RESUME", 1, 1);
      RESUME = localHOTPOINTMISSIONSWITCH;
      $VALUES = new HOTPOINTMISSIONSWITCH[] { PAUSE, localHOTPOINTMISSIONSWITCH };
    }
    
    private HOTPOINTMISSIONSWITCH(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static HOTPOINTMISSIONSWITCH find(int paramInt)
    {
      HOTPOINTMISSIONSWITCH localHOTPOINTMISSIONSWITCH = PAUSE;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localHOTPOINTMISSIONSWITCH;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycHotPointMissionSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */