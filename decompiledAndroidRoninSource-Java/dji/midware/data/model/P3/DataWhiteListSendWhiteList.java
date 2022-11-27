package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataWhiteListSendWhiteList
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataWhiteListSendWhiteList instance;
  private int blockNum = -1;
  private byte[] data = null;
  private int index = -1;
  private int mDataLength = 0;
  
  public static DataWhiteListSendWhiteList getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataWhiteListSendWhiteList();
      }
      DataWhiteListSendWhiteList localDataWhiteListSendWhiteList = instance;
      return localDataWhiteListSendWhiteList;
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
  
  public int getExpectIndex()
  {
    return 0;
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public DataWhiteListSendWhiteList setBlockNum(int paramInt)
  {
    this.blockNum = paramInt;
    return this;
  }
  
  public DataWhiteListSendWhiteList setData(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    return this;
  }
  
  public DataWhiteListSendWhiteList setDataLength(int paramInt)
  {
    this.mDataLength = paramInt;
    return this;
  }
  
  public DataWhiteListSendWhiteList setIndex(int paramInt)
  {
    this.index = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWhiteListSendWhiteList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */