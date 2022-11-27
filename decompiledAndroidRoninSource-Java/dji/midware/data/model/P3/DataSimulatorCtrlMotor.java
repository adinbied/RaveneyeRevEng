package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSimulatorCtrlMotor
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSimulatorCtrlMotor instance;
  private int[] mMotorOutPut = new int[8];
  
  public static DataSimulatorCtrlMotor getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataSimulatorCtrlMotor();
      }
      DataSimulatorCtrlMotor localDataSimulatorCtrlMotor = instance;
      return localDataSimulatorCtrlMotor;
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
  
  public DataSimulatorCtrlMotor setMotoOutput(int[] paramArrayOfInt)
  {
    this.mMotorOutPut = paramArrayOfInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSimulatorCtrlMotor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */