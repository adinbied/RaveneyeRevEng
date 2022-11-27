package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetParamName
  extends DataBase
  implements DJIDataSyncListener
{
  public static final int MAX_NAME_LENGTH = 63;
  private static DataCameraSetParamName instance;
  private DataCameraSaveParams.USER mParamIndex = DataCameraSaveParams.USER.USER1;
  private byte[] mParamName = null;
  
  public DataCameraSetParamName(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public static DataCameraSetParamName getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetParamName(true);
      }
      DataCameraSetParamName localDataCameraSetParamName = instance;
      return localDataCameraSetParamName;
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
  
  public DataCameraSetParamName setName(byte[] paramArrayOfByte)
  {
    this.mParamName = paramArrayOfByte;
    return this;
  }
  
  public DataCameraSetParamName setParamIndex(DataCameraSaveParams.USER paramUSER)
  {
    this.mParamIndex = paramUSER;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetParamName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */