package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalSpeedControl
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataGimbalSpeedControl instance;
  private boolean isGetPermission;
  private boolean multiControl;
  private int pitch;
  private int roll;
  private int yaw;
  
  public static DataGimbalSpeedControl getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalSpeedControl();
      }
      DataGimbalSpeedControl localDataGimbalSpeedControl = instance;
      return localDataGimbalSpeedControl;
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
  
  public DataGimbalSpeedControl setMultiControl(boolean paramBoolean)
  {
    this.multiControl = paramBoolean;
    return this;
  }
  
  public DataGimbalSpeedControl setPermission(boolean paramBoolean)
  {
    this.isGetPermission = paramBoolean;
    return this;
  }
  
  public DataGimbalSpeedControl setPitch(int paramInt)
  {
    this.pitch = paramInt;
    return this;
  }
  
  public DataGimbalSpeedControl setRoll(int paramInt)
  {
    this.roll = paramInt;
    return this;
  }
  
  public DataGimbalSpeedControl setYaw(int paramInt)
  {
    this.yaw = paramInt;
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
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalSpeedControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */