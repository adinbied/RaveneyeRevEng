package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetVideoFormat
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetVideoFormat instance;
  private int fov;
  private int fps;
  private int ratio;
  private int secondOpen;
  private int secondRatio;
  
  public static DataCameraSetVideoFormat getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetVideoFormat();
      }
      DataCameraSetVideoFormat localDataCameraSetVideoFormat = instance;
      return localDataCameraSetVideoFormat;
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
  
  public DataCameraSetVideoFormat setAll()
  {
    return null;
  }
  
  public DataCameraSetVideoFormat setFov(int paramInt)
  {
    this.fov = paramInt;
    return this;
  }
  
  public DataCameraSetVideoFormat setFps(int paramInt)
  {
    this.fps = paramInt;
    return this;
  }
  
  public DataCameraSetVideoFormat setRatio(int paramInt)
  {
    this.ratio = paramInt;
    return this;
  }
  
  public DataCameraSetVideoFormat setSecondOpen(int paramInt)
  {
    this.secondOpen = paramInt;
    return this;
  }
  
  public DataCameraSetVideoFormat setSecondRatio(int paramInt)
  {
    this.secondRatio = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetVideoFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */