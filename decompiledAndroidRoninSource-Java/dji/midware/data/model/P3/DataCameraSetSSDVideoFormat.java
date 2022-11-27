package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetSSDVideoFormat
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetSSDVideoFormat instance;
  private int fps;
  private int ratio;
  
  public static DataCameraSetSSDVideoFormat getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetSSDVideoFormat();
      }
      DataCameraSetSSDVideoFormat localDataCameraSetSSDVideoFormat = instance;
      return localDataCameraSetSSDVideoFormat;
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
  
  public DataCameraSetSSDVideoFormat setFps(int paramInt)
  {
    this.fps = paramInt;
    return this;
  }
  
  public DataCameraSetSSDVideoFormat setRatio(int paramInt)
  {
    this.ratio = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetSSDVideoFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */