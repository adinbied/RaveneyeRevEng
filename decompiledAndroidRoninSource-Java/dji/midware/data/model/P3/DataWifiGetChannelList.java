package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataWifiGetChannelList
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataWifiGetChannelList mInstance;
  private boolean isSupport5G = true;
  private int mCurChannel = -1;
  
  public static DataWifiGetChannelList getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiGetChannelList();
      }
      DataWifiGetChannelList localDataWifiGetChannelList = mInstance;
      return localDataWifiGetChannelList;
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
  
  public int[] get24GChannelList()
  {
    return null;
  }
  
  public int[] get5GChannelList()
  {
    return null;
  }
  
  public int getCurChannel()
  {
    return 0;
  }
  
  public DataWifiGetChannelList setSupport5G(boolean paramBoolean)
  {
    this.isSupport5G = paramBoolean;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiGetChannelList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */