package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraGetParamName
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraGetParamName instance;
  private DataCameraSaveParams.USER mParamIndex = DataCameraSaveParams.USER.USER1;
  
  public DataCameraGetParamName(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public static DataCameraGetParamName getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetParamName(true);
      }
      DataCameraGetParamName localDataCameraGetParamName = instance;
      return localDataCameraGetParamName;
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
  
  public String getName()
  {
    return null;
  }
  
  public DataCameraGetParamName setParamIndex(DataCameraSaveParams.USER paramUSER)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetParamName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */