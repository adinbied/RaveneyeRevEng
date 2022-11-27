package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSimulatorConnectHeartPacket
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSimulatorConnectHeartPacket instance;
  private int flag;
  
  public static DataSimulatorConnectHeartPacket getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataSimulatorConnectHeartPacket();
      }
      DataSimulatorConnectHeartPacket localDataSimulatorConnectHeartPacket = instance;
      return localDataSimulatorConnectHeartPacket;
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
  
  public DataSimulatorConnectHeartPacket setFlag(int paramInt)
  {
    this.flag = paramInt;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSimulatorConnectHeartPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */