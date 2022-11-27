package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycUpdateFlyforbidArea
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycUpdateFlyforbidArea instance;
  private byte[] mData = new byte[0];
  private short mPkgSeq = 0;
  private int mPkgTotalSize = 0;
  private int mType = 0;
  
  public static DataFlycUpdateFlyforbidArea getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycUpdateFlyforbidArea();
      }
      DataFlycUpdateFlyforbidArea localDataFlycUpdateFlyforbidArea = instance;
      return localDataFlycUpdateFlyforbidArea;
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
  
  public int getAckCode()
  {
    return 0;
  }
  
  public int getAckType()
  {
    return 0;
  }
  
  public int getNexSeqNum()
  {
    return 0;
  }
  
  public String getRemoteUuid()
  {
    return null;
  }
  
  public int getVerifyResult()
  {
    return 0;
  }
  
  public DataFlycUpdateFlyforbidArea setData(byte[] paramArrayOfByte)
  {
    this.mData = paramArrayOfByte;
    return this;
  }
  
  public DataFlycUpdateFlyforbidArea setPkgSeq(short paramShort)
  {
    this.mPkgSeq = paramShort;
    return this;
  }
  
  public DataFlycUpdateFlyforbidArea setPkgTotalSize(int paramInt)
  {
    this.mPkgTotalSize = paramInt;
    return this;
  }
  
  public DataFlycUpdateFlyforbidArea setType(int paramInt)
  {
    this.mType = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycUpdateFlyforbidArea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */