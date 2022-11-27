package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCommonTranslateData
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCommonTranslateData instance;
  private byte[] mDatas = null;
  private int mEncrypt = 0;
  private int mReceiveId = 0;
  private DeviceType mReceiveType = DeviceType.RC;
  private int mSequence = 0;
  private int mSize = 0;
  
  public static DataCommonTranslateData getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCommonTranslateData();
      }
      DataCommonTranslateData localDataCommonTranslateData = instance;
      return localDataCommonTranslateData;
    }
    finally {}
  }
  
  protected void LogPack(String paramString)
  {
    super.LogPack(paramString);
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getFailSequence()
  {
    return 0;
  }
  
  public int getSequence()
  {
    return 0;
  }
  
  public DataCommonTranslateData setData(byte[] paramArrayOfByte)
  {
    this.mDatas = paramArrayOfByte;
    return this;
  }
  
  public DataCommonTranslateData setData(byte[] paramArrayOfByte, int paramInt)
  {
    this.mDatas = paramArrayOfByte;
    this.mSize = paramInt;
    return this;
  }
  
  public void setRecData(byte[] paramArrayOfByte)
  {
    super.setRecData(paramArrayOfByte);
    paramArrayOfByte = this._recData;
  }
  
  public DataCommonTranslateData setReceiveId(int paramInt)
  {
    this.mReceiveId = paramInt;
    return this;
  }
  
  public DataCommonTranslateData setReceiveType(DeviceType paramDeviceType)
  {
    this.mReceiveType = paramDeviceType;
    return this;
  }
  
  public DataCommonTranslateData setSequence(int paramInt)
  {
    this.mSequence = paramInt;
    return this;
  }
  
  /* Error */
  public void start()
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonTranslateData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */