package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSingleSetTrackSelect
  extends DataBase
  implements DJIDataSyncListener
{
  private float mCenterX = 0.0F;
  private float mCenterY = 0.0F;
  private int mException = 0;
  private float mHeight = 0.0F;
  private DataSingleVisualParam.TrackingMode mMode = DataSingleVisualParam.TrackingMode.HEADLESS_FOLLOW;
  private short mSessionId = 0;
  private float mWidth = 0.0F;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataSingleSetTrackSelect setCenterX(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mCenterX = paramFloat1;
    this.mCenterY = paramFloat2;
    this.mWidth = paramFloat3;
    this.mHeight = paramFloat4;
    return this;
  }
  
  public DataSingleSetTrackSelect setMode(DataSingleVisualParam.TrackingMode paramTrackingMode)
  {
    this.mMode = paramTrackingMode;
    return this;
  }
  
  public DataSingleSetTrackSelect setSessionId(short paramShort)
  {
    this.mSessionId = paramShort;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSingleSetTrackSelect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */