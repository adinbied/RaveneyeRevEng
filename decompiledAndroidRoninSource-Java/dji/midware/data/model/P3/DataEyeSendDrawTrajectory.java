package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataEyeSendDrawTrajectory
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataEyeSendDrawTrajectory instance;
  private byte mCount = 0;
  private byte mFragment = 0;
  private byte mSequence = 0;
  private short[] mTrajectoryLocation = null;
  private boolean mbLastFragment = false;
  
  public static DataEyeSendDrawTrajectory getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeSendDrawTrajectory();
      }
      DataEyeSendDrawTrajectory localDataEyeSendDrawTrajectory = instance;
      return localDataEyeSendDrawTrajectory;
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
  
  public DataEyeSendDrawTrajectory setCount(byte paramByte)
  {
    this.mCount = paramByte;
    return this;
  }
  
  public DataEyeSendDrawTrajectory setFragment(byte paramByte)
  {
    this.mFragment = paramByte;
    return this;
  }
  
  public DataEyeSendDrawTrajectory setIsLastFragment(boolean paramBoolean)
  {
    this.mbLastFragment = paramBoolean;
    return this;
  }
  
  public DataEyeSendDrawTrajectory setSequence(byte paramByte)
  {
    this.mSequence = paramByte;
    return this;
  }
  
  public DataEyeSendDrawTrajectory setTrajectory(short[] paramArrayOfShort)
  {
    this.mTrajectoryLocation = paramArrayOfShort;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeSendDrawTrajectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */