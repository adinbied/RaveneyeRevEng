package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataCameraGetPushShutterCmd
  extends DataBase
{
  private static DataCameraGetPushShutterCmd instance;
  private final String TAG = DataCameraGetPushShutterCmd.class.getSimpleName();
  
  public static DataCameraGetPushShutterCmd getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushShutterCmd();
      }
      DataCameraGetPushShutterCmd localDataCameraGetPushShutterCmd = instance;
      return localDataCameraGetPushShutterCmd;
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
  
  public int getShutterType()
  {
    return 0;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return false;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushShutterCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */