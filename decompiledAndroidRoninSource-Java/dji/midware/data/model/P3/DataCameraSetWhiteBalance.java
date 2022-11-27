package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetWhiteBalance
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetWhiteBalance instance;
  private int colorTemp;
  protected int mRepeatTime = 2;
  protected int mTimeOut = 1000;
  private int type;
  
  public static DataCameraSetWhiteBalance getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetWhiteBalance();
      }
      DataCameraSetWhiteBalance localDataCameraSetWhiteBalance = instance;
      return localDataCameraSetWhiteBalance;
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
  
  public DataCameraSetWhiteBalance setAll()
  {
    return null;
  }
  
  public DataCameraSetWhiteBalance setColorTemp(int paramInt)
  {
    this.colorTemp = paramInt;
    return this;
  }
  
  public void setPackParam(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.mTimeOut = paramInt1;
    }
    if ((paramInt2 > 0) && (paramInt2 <= 3)) {
      this.mRepeatTime = paramInt2;
    }
  }
  
  public DataCameraSetWhiteBalance setType(int paramInt)
  {
    this.type = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetWhiteBalance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */