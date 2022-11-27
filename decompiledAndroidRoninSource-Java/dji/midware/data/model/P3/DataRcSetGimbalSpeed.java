package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcSetGimbalSpeed
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcSetGimbalSpeed instance;
  private int pitch;
  private int roll;
  private int yaw;
  
  public static DataRcSetGimbalSpeed getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSetGimbalSpeed();
      }
      DataRcSetGimbalSpeed localDataRcSetGimbalSpeed = instance;
      return localDataRcSetGimbalSpeed;
    }
    finally {}
  }
  
  /* Error */
  protected void LogPack(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataRcSetGimbalSpeed setPitch(int paramInt)
  {
    this.pitch = paramInt;
    return this;
  }
  
  public DataRcSetGimbalSpeed setRoll(int paramInt)
  {
    this.roll = paramInt;
    return this;
  }
  
  public DataRcSetGimbalSpeed setYaw(int paramInt)
  {
    this.yaw = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetGimbalSpeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */