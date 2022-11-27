package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataCameraGetPushFile
  extends DataBase
{
  private static DataCameraGetPushFile instance;
  
  public static DataCameraGetPushFile getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushFile();
      }
      DataCameraGetPushFile localDataCameraGetPushFile = instance;
      return localDataCameraGetPushFile;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  /* Error */
  public void setPushRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */