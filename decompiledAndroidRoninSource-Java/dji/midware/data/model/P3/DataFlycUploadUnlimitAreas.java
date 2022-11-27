package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycUploadUnlimitAreas
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycUploadUnlimitAreas instance;
  private byte[] data = null;
  private int packetIndex = 0;
  
  public static DataFlycUploadUnlimitAreas getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycUploadUnlimitAreas();
      }
      DataFlycUploadUnlimitAreas localDataFlycUploadUnlimitAreas = instance;
      return localDataFlycUploadUnlimitAreas;
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
  
  public int getResult()
  {
    return 0;
  }
  
  public DataFlycUploadUnlimitAreas setData(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    return this;
  }
  
  public DataFlycUploadUnlimitAreas setIndex(int paramInt)
  {
    this.packetIndex = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycUploadUnlimitAreas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */