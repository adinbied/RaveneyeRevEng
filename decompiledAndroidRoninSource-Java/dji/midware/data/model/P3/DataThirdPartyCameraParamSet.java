package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;
import dji.midware.data.model.hg702.CameraParamType;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataThirdPartyCameraParamSet
  extends DJICameraDataBase
  implements DJIDataSyncListener
{
  private static final String TAG = "CameraParamSet";
  private boolean mMonitorControl;
  private int mParam;
  private CameraParamType mParamType;
  
  public static DataThirdPartyCameraParamSet getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataThirdPartyCameraParamSet setMonitorControl(boolean paramBoolean)
  {
    this.mMonitorControl = paramBoolean;
    return this;
  }
  
  public DataThirdPartyCameraParamSet setParam(int paramInt)
  {
    this.mParam = paramInt;
    return this;
  }
  
  public DataThirdPartyCameraParamSet setParamType(CameraParamType paramCameraParamType)
  {
    this.mParamType = paramCameraParamType;
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
  
  private static final class SingletonHolder
  {
    private static final DataThirdPartyCameraParamSet mInstance = new DataThirdPartyCameraParamSet();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataThirdPartyCameraParamSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */