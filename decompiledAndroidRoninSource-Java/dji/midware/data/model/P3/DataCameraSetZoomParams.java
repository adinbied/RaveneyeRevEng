package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetZoomParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetZoomParams instance;
  private int mDigitalScaleValue = 1;
  private byte mZoomControlByte = 9;
  
  public static DataCameraSetZoomParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetZoomParams();
      }
      DataCameraSetZoomParams localDataCameraSetZoomParams = instance;
      return localDataCameraSetZoomParams;
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
  
  public DataCameraSetZoomParams setDigitalZoomControl(int paramInt)
  {
    return null;
  }
  
  public DataCameraSetZoomParams setDigitalZoomType(int paramInt)
  {
    return null;
  }
  
  public DataCameraSetZoomParams setDigitalZoomValue(int paramInt)
  {
    this.mDigitalScaleValue = paramInt;
    return this;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetZoomParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */