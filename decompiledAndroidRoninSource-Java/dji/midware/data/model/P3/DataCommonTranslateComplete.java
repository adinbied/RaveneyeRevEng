package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCommonTranslateComplete
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCommonTranslateComplete instance;
  private int mEncrypt = 0;
  private byte[] mMd5 = null;
  private int mReceiveId = 0;
  private DeviceType mReceiveType = DeviceType.RC;
  private int mTimeOut = -1;
  
  public static DataCommonTranslateComplete getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCommonTranslateComplete();
      }
      DataCommonTranslateComplete localDataCommonTranslateComplete = instance;
      return localDataCommonTranslateComplete;
    }
    finally {}
  }
  
  /* Error */
  protected void LogPack(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataCommonTranslateComplete setMD5(byte[] paramArrayOfByte)
  {
    this.mMd5 = paramArrayOfByte;
    return this;
  }
  
  public DataCommonTranslateComplete setReceiveId(int paramInt)
  {
    this.mReceiveId = paramInt;
    return this;
  }
  
  public DataCommonTranslateComplete setReceiveType(DeviceType paramDeviceType)
  {
    this.mReceiveType = paramDeviceType;
    return this;
  }
  
  public DataCommonTranslateComplete setTimeOut(int paramInt)
  {
    this.mTimeOut = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonTranslateComplete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */