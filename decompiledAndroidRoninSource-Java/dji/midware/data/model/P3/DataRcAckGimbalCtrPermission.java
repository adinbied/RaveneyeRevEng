package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataAsync2Listener;

public class DataRcAckGimbalCtrPermission
  extends DataBase
  implements DJIDataAsync2Listener
{
  private static DataRcAckGimbalCtrPermission instance;
  private boolean isAgree;
  
  public static DataRcAckGimbalCtrPermission getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcAckGimbalCtrPermission();
      }
      DataRcAckGimbalCtrPermission localDataRcAckGimbalCtrPermission = instance;
      return localDataRcAckGimbalCtrPermission;
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
  
  public String getName()
  {
    return null;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public DataRcAckGimbalCtrPermission setIsAgree(boolean paramBoolean)
  {
    this.isAgree = paramBoolean;
    return this;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcAckGimbalCtrPermission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */