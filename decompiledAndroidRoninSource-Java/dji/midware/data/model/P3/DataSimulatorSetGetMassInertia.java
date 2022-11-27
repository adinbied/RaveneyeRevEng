package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSimulatorSetGetMassInertia
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSimulatorSetGetMassInertia instance;
  private int mFlag;
  private float mInertiaX;
  private float mInertiaY;
  private float mInertiaZ;
  private float mMass;
  
  public static DataSimulatorSetGetMassInertia getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataSimulatorSetGetMassInertia();
      }
      DataSimulatorSetGetMassInertia localDataSimulatorSetGetMassInertia = instance;
      return localDataSimulatorSetGetMassInertia;
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
  
  public DataSimulatorSetGetMassInertia setAckFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFlag |= 0x1;
      return this;
    }
    this.mFlag |= 0x0;
    return this;
  }
  
  public DataSimulatorSetGetMassInertia setInertiaX(float paramFloat)
  {
    this.mInertiaX = paramFloat;
    return this;
  }
  
  public DataSimulatorSetGetMassInertia setInertiaY(float paramFloat)
  {
    this.mInertiaY = paramFloat;
    return this;
  }
  
  public DataSimulatorSetGetMassInertia setInertiaZ(float paramFloat)
  {
    this.mInertiaZ = paramFloat;
    return this;
  }
  
  public DataSimulatorSetGetMassInertia setMass(float paramFloat)
  {
    this.mMass = paramFloat;
    return this;
  }
  
  public void start(DJIDataCallBack paramDJIDataCallBack) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSimulatorSetGetMassInertia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */