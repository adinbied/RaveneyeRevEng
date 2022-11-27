package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSimulatorSetGetArmLength
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSimulatorSetGetArmLength instance;
  private float mArmLength;
  private int mFlag;
  
  public static DataSimulatorSetGetArmLength getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataSimulatorSetGetArmLength();
      }
      DataSimulatorSetGetArmLength localDataSimulatorSetGetArmLength = instance;
      return localDataSimulatorSetGetArmLength;
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
  
  public DataSimulatorSetGetArmLength setAckFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFlag |= 0x1;
      return this;
    }
    this.mFlag |= 0x0;
    return this;
  }
  
  public DataSimulatorSetGetArmLength setArmLength(float paramFloat)
  {
    this.mArmLength = paramFloat;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSimulatorSetGetArmLength.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */