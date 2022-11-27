package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetRecordFan
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetRecordFan mInstance;
  private int mFanOffT = 0;
  private int mFanOnT = 0;
  private byte mValue = 0;
  
  public static DataCameraSetRecordFan getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataCameraSetRecordFan();
      }
      DataCameraSetRecordFan localDataCameraSetRecordFan = mInstance;
      return localDataCameraSetRecordFan;
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
  
  public DataCameraSetRecordFan reset()
  {
    this.mValue = 0;
    return this;
  }
  
  public DataCameraSetRecordFan setFanOffT(int paramInt)
  {
    this.mFanOffT = paramInt;
    return this;
  }
  
  public DataCameraSetRecordFan setFanOnT(int paramInt)
  {
    this.mFanOnT = paramInt;
    return this;
  }
  
  public DataCameraSetRecordFan setIsForceTurnOffFan(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mValue = 1;
      return this;
    }
    this.mValue = 0;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetRecordFan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */