package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.packages.P3.RecvPack;

public class DataGimbalCameraIdNotify
  extends DataBase
{
  private static final String TAG = DataGimbalCameraIdNotify.class.getSimpleName();
  private static DataGimbalCameraIdNotify instance = null;
  private int cameraId = -1;
  
  public static DataGimbalCameraIdNotify getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalCameraIdNotify();
      }
      DataGimbalCameraIdNotify localDataGimbalCameraIdNotify = instance;
      return localDataGimbalCameraIdNotify;
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
  
  public RecvPack getRecvPack()
  {
    return this.recvPack;
  }
  
  public DataGimbalCameraIdNotify setCameraId(int paramInt)
  {
    this.cameraId = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalCameraIdNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */