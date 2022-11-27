package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSimulatorSetGetArea
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSimulatorSetGetArea instance;
  private float mAreaX;
  private float mAreaY;
  private float mAreaZ;
  private int mFlag;
  
  public static DataSimulatorSetGetArea getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataSimulatorSetGetArea();
      }
      DataSimulatorSetGetArea localDataSimulatorSetGetArea = instance;
      return localDataSimulatorSetGetArea;
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
  
  public DataSimulatorSetGetArea setAckFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFlag = 1;
      return this;
    }
    this.mFlag = 0;
    return this;
  }
  
  public DataSimulatorSetGetArea setAreaX(float paramFloat)
  {
    this.mAreaX = paramFloat;
    return this;
  }
  
  public DataSimulatorSetGetArea setAreaY(float paramFloat)
  {
    this.mAreaY = paramFloat;
    return this;
  }
  
  public DataSimulatorSetGetArea setAreaZ(float paramFloat)
  {
    this.mAreaZ = paramFloat;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSimulatorSetGetArea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */