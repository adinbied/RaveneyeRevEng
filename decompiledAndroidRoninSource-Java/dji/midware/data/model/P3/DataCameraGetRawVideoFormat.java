package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraGetRawVideoFormat
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraGetRawVideoFormat mInstance;
  
  public static DataCameraGetRawVideoFormat getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataCameraGetRawVideoFormat();
      }
      DataCameraGetRawVideoFormat localDataCameraGetRawVideoFormat = mInstance;
      return localDataCameraGetRawVideoFormat;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getFOVType()
  {
    return 0;
  }
  
  public int getPlaySpeedType()
  {
    return 0;
  }
  
  public int getPlaySpeedValue()
  {
    return 0;
  }
  
  public int getRawFrameRate()
  {
    return 0;
  }
  
  public DataCameraGetPushRawParams.RawMode getRawMode()
  {
    return null;
  }
  
  public int getRawResolution()
  {
    return 0;
  }
  
  public int getSecondVideoResolution()
  {
    return 0;
  }
  
  public int getSecondVideoSetting()
  {
    return 0;
  }
  
  public int getVideoFrameRate()
  {
    return 0;
  }
  
  public int getVideoResolution()
  {
    return 0;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetRawVideoFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */