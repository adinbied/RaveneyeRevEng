package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataThirdPartyCameraParamGetTable
  extends DJICameraDataBase
  implements DJIDataSyncListener
{
  private static final int LENGTH_DATA_SIZE = 2;
  private static final int LENGTH_PARAM_TYPE = 2;
  private static final String TAG = "CameraParamGetTable";
  private byte[] mAllParamsTable = new byte[0];
  private int mCurPackIndex = 0;
  private boolean mMonitorControl;
  private int mTotalPackCount = 0;
  
  public static DataThirdPartyCameraParamGetTable getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  public void clearParamsTable()
  {
    this.mAllParamsTable = new byte[0];
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public byte[] getAllParamsTable()
  {
    return this.mAllParamsTable;
  }
  
  public int getCurPackIndex()
  {
    return this.mCurPackIndex;
  }
  
  public int getTotalPackCount()
  {
    return this.mTotalPackCount;
  }
  
  public DataThirdPartyCameraParamGetTable setMonitorControl(boolean paramBoolean)
  {
    this.mMonitorControl = paramBoolean;
    return this;
  }
  
  public DataThirdPartyCameraParamGetTable setPackIndex(int paramInt)
  {
    this.mCurPackIndex = paramInt;
    return this;
  }
  
  /* Error */
  public void setRecData(byte[] arg1)
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
  
  private static final class SingletonHolder
  {
    private static final DataThirdPartyCameraParamGetTable mInstance = new DataThirdPartyCameraParamGetTable();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataThirdPartyCameraParamGetTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */