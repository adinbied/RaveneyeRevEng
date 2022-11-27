package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSendAgpsData
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycSendAgpsData mInstance;
  private byte[] mData;
  private byte[] mHeader = new byte[3];
  
  public static DataFlycSendAgpsData getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataFlycSendAgpsData();
      }
      DataFlycSendAgpsData localDataFlycSendAgpsData = mInstance;
      return localDataFlycSendAgpsData;
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
  
  public Short getSequence()
  {
    return null;
  }
  
  public void setAgpsData(byte[] paramArrayOfByte)
  {
    this.mData = paramArrayOfByte;
  }
  
  /* Error */
  public void setHeaderData(short arg1, byte arg2, byte arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSendAgpsData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */