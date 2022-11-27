package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCommonSetMultiParam
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCommonSetMultiParam mInstance;
  private byte[] mParams = null;
  private DeviceType mReceiverType = DeviceType.CAMERA;
  
  public static DataCommonSetMultiParam getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataCommonSetMultiParam();
      }
      DataCommonSetMultiParam localDataCommonSetMultiParam = mInstance;
      return localDataCommonSetMultiParam;
    }
    finally {}
  }
  
  protected void doPack()
  {
    this._sendData = this.mParams;
  }
  
  public int getErrorCmdId()
  {
    return 0;
  }
  
  public DataCommonSetMultiParam setMultiParam(byte[] paramArrayOfByte)
  {
    this.mParams = paramArrayOfByte;
    return this;
  }
  
  public DataCommonSetMultiParam setReceiverType(DeviceType paramDeviceType)
  {
    this.mReceiverType = paramDeviceType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonSetMultiParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */