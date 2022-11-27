package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;
import dji.midware.data.model.hg702.CameraParamType;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataThirdPartyCameraParamSubscribe
  extends DJICameraDataBase
  implements DJIDataSyncListener
{
  private static final int LENGTH_PARAM_TYPE = 2;
  private static final String TAG = "CameraParamSubscribe";
  private boolean mMonitorControl;
  private byte[] mSubscribeParams;
  
  public static DataThirdPartyCameraParamSubscribe getInstance()
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
  
  public DataThirdPartyCameraParamSubscribe setMonitorControl(boolean paramBoolean)
  {
    this.mMonitorControl = paramBoolean;
    return this;
  }
  
  public DataThirdPartyCameraParamSubscribe setSubscribeParams(CameraParamType... paramVarArgs)
  {
    return null;
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
    private static final DataThirdPartyCameraParamSubscribe mInstance = new DataThirdPartyCameraParamSubscribe();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataThirdPartyCameraParamSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */