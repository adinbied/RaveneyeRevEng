package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalSetPanoramaParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataGimbalSetPanoramaParams instance;
  private int mBottom;
  private int mCommand;
  private int mExposure;
  private int mHorizontal;
  private int mLeft;
  private int mRight;
  private int mTop;
  private int mVertical;
  
  public static DataGimbalSetPanoramaParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalSetPanoramaParams();
      }
      DataGimbalSetPanoramaParams localDataGimbalSetPanoramaParams = instance;
      return localDataGimbalSetPanoramaParams;
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
  
  public DataGimbalSetPanoramaParams setExposureTime(int paramInt)
  {
    this.mExposure = paramInt;
    return this;
  }
  
  public DataGimbalSetPanoramaParams setPictures(int paramInt1, int paramInt2)
  {
    this.mHorizontal = paramInt1;
    this.mVertical = paramInt2;
    return this;
  }
  
  public DataGimbalSetPanoramaParams setRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLeft = paramInt1;
    this.mTop = paramInt2;
    this.mRight = paramInt3;
    this.mBottom = paramInt4;
    return this;
  }
  
  public DataGimbalSetPanoramaParams setStopStartOrPreview(int paramInt)
  {
    this.mCommand = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalSetPanoramaParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */