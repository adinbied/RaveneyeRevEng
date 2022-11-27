package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSimulatorMomentum
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSimulatorMomentum instance;
  private int mDurationTime;
  private int mMomentumX;
  private int mMomentumY;
  private int mMomentumZ;
  
  public static DataSimulatorMomentum getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataSimulatorMomentum();
      }
      DataSimulatorMomentum localDataSimulatorMomentum = instance;
      return localDataSimulatorMomentum;
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
  
  public DataSimulatorMomentum setDurationTime(int paramInt)
  {
    this.mDurationTime = paramInt;
    return this;
  }
  
  public DataSimulatorMomentum setMomentumX(int paramInt)
  {
    this.mMomentumX = paramInt;
    return this;
  }
  
  public DataSimulatorMomentum setMomentumY(int paramInt)
  {
    this.mMomentumY = paramInt;
    return this;
  }
  
  public DataSimulatorMomentum setMomentumZ(int paramInt)
  {
    this.mMomentumZ = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSimulatorMomentum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */