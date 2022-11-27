package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraGetRecordFan
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraGetRecordFan mInstance;
  
  public static DataCameraGetRecordFan getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataCameraGetRecordFan();
      }
      DataCameraGetRecordFan localDataCameraGetRecordFan = mInstance;
      return localDataCameraGetRecordFan;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getForceFanOffT()
  {
    return 0;
  }
  
  public int getForceFanOnT()
  {
    return 0;
  }
  
  public boolean isForceTurnOffFan()
  {
    return false;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetRecordFan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */