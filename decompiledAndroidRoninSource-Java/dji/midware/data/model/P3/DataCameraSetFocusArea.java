package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetFocusArea
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetFocusArea instance;
  private float mFocusX = 0.5F;
  private float mFocusY = 0.5F;
  
  public static DataCameraSetFocusArea getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetFocusArea();
      }
      DataCameraSetFocusArea localDataCameraSetFocusArea = instance;
      return localDataCameraSetFocusArea;
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
  
  public DataCameraSetFocusArea setFocusAxisX(float paramFloat)
  {
    this.mFocusX = paramFloat;
    return this;
  }
  
  public DataCameraSetFocusArea setFocusAxisY(float paramFloat)
  {
    this.mFocusY = paramFloat;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetFocusArea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */