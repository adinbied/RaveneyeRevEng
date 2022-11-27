package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalSetAngle
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataGimbalSetAngle instance;
  int mErrorValue = 10;
  int mPitchAngle;
  int mRef = 0;
  int mRollAngle;
  int mYawAngle;
  int timtout = 2;
  
  public static DataGimbalSetAngle getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalSetAngle();
      }
      DataGimbalSetAngle localDataGimbalSetAngle = instance;
      return localDataGimbalSetAngle;
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
  
  public DataGimbalSetAngle setAngleRef(int paramInt)
  {
    this.mRef = paramInt;
    return this;
  }
  
  public DataGimbalSetAngle setErrorValue(int paramInt)
  {
    this.mErrorValue = paramInt;
    return this;
  }
  
  public DataGimbalSetAngle setPitchAngle(int paramInt)
  {
    this.mPitchAngle = paramInt;
    return this;
  }
  
  public DataGimbalSetAngle setRollAngle(int paramInt)
  {
    this.mRollAngle = paramInt;
    return this;
  }
  
  public DataGimbalSetAngle setTimeout(int paramInt)
  {
    this.timtout = paramInt;
    return this;
  }
  
  public DataGimbalSetAngle setYawAngle(int paramInt)
  {
    this.mYawAngle = paramInt;
    return this;
  }
  
  /* Error */
  public void start(int arg1, int arg2, dji.midware.interfaces.DJIDataCallBack arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalSetAngle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */