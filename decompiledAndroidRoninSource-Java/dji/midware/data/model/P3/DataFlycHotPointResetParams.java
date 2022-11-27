package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycHotPointResetParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycHotPointResetParams instance;
  private float angleSpeed = 0.0F;
  private DataFlycStartHotPointMissionWithInfo.ROTATION_DIR rotationDir = DataFlycStartHotPointMissionWithInfo.ROTATION_DIR.Anti_Clockwise;
  
  public static DataFlycHotPointResetParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycHotPointResetParams();
      }
      DataFlycHotPointResetParams localDataFlycHotPointResetParams = instance;
      return localDataFlycHotPointResetParams;
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
  
  public DataFlycHotPointResetParams setRotationDir(DataFlycStartHotPointMissionWithInfo.ROTATION_DIR paramROTATION_DIR)
  {
    this.rotationDir = paramROTATION_DIR;
    return this;
  }
  
  public DataFlycHotPointResetParams setVelocity(float paramFloat)
  {
    this.angleSpeed = paramFloat;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycHotPointResetParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */