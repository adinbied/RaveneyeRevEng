package dji.midware.data.model.common;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataAsync2Listener;

public class DataHeartBeat
  extends DataBase
  implements DJIDataAsync2Listener
{
  private static DataHeartBeat instance;
  
  public static DataHeartBeat getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataHeartBeat();
      }
      DataHeartBeat localDataHeartBeat = instance;
      return localDataHeartBeat;
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
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  protected boolean isWantPush()
  {
    return false;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    super.setPushRecData(paramArrayOfByte);
    start();
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\common\DataHeartBeat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */