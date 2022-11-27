package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetTrackingParms
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetTrackingParms instance;
  private boolean isTrackingEnable;
  private TrackingParam mTrackingParam;
  private int mXCoord;
  private int mYCoord;
  
  public static DataCameraSetTrackingParms getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetTrackingParms();
      }
      DataCameraSetTrackingParms localDataCameraSetTrackingParms = instance;
      return localDataCameraSetTrackingParms;
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
  
  public DataCameraSetTrackingParms setIsTrackingEnable(boolean paramBoolean)
  {
    this.isTrackingEnable = paramBoolean;
    return this;
  }
  
  public DataCameraSetTrackingParms setTracking(TrackingParam paramTrackingParam)
  {
    this.mTrackingParam = paramTrackingParam;
    return this;
  }
  
  public DataCameraSetTrackingParms setXCoord(int paramInt)
  {
    this.mXCoord = paramInt;
    return this;
  }
  
  public DataCameraSetTrackingParms setYCoord(int paramInt)
  {
    this.mYCoord = paramInt;
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
  
  public static class TrackingParam
  {
    private float mCenterX;
    private float mCenterY;
    private float mHeight;
    private boolean mIsStart;
    private float mWidth;
    
    public TrackingParam(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.mIsStart = paramBoolean;
      this.mCenterX = paramFloat1;
      this.mCenterY = paramFloat2;
      this.mWidth = paramFloat3;
      this.mHeight = paramFloat4;
    }
    
    public byte[] getSendData()
    {
      return null;
    }
    
    public String toString()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetTrackingParms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */