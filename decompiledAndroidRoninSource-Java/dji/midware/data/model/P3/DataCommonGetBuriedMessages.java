package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.HashMap;

public class DataCommonGetBuriedMessages
  extends DataBase
  implements DJIDataSyncListener
{
  private static final int CMD_CLEAR_DATA_ALL = 4;
  private static final int CMD_GET_DATA_ALL = 1;
  private static final int CMD_GET_DATA_SPECIFIED = 0;
  private static final String TAG = "CommonGetBuriedMessages";
  private boolean mClearDataSuccess;
  HashMap<String, Integer> mDeviceDataMap = new HashMap();
  private int mSessionId;
  private int mTotalPackCount;
  
  public static DataCommonGetBuriedMessages getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  /* Error */
  private void setSendData(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public DataCommonGetBuriedMessages clearAllDeviceData()
  {
    setSendData(4, 0);
    return this;
  }
  
  protected void doPack() {}
  
  public boolean getClearSuccess()
  {
    return this.mClearDataSuccess;
  }
  
  public HashMap<String, Integer> getDeviceDataMap()
  {
    return this.mDeviceDataMap;
  }
  
  public DataCommonGetBuriedMessages getDeviceDataPack(int paramInt)
  {
    setSendData(1, paramInt);
    return this;
  }
  
  public int getSessionId()
  {
    return this.mSessionId;
  }
  
  public int getTotalPackCount()
  {
    return this.mTotalPackCount;
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
    private static final DataCommonGetBuriedMessages mInstance = new DataCommonGetBuriedMessages();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonGetBuriedMessages.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */