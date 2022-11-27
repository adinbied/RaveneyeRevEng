package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataSimulatorGetPushConnectHeartPacket
  extends DataBase
{
  private static DataSimulatorGetPushConnectHeartPacket instance;
  
  public static DataSimulatorGetPushConnectHeartPacket getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataSimulatorGetPushConnectHeartPacket();
      }
      DataSimulatorGetPushConnectHeartPacket localDataSimulatorGetPushConnectHeartPacket = instance;
      return localDataSimulatorGetPushConnectHeartPacket;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getResult()
  {
    return 0;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSimulatorGetPushConnectHeartPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */