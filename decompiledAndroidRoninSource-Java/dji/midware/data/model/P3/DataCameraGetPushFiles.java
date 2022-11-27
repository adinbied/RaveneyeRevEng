package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataCameraGetPushFiles
  extends DataBase
{
  private static DataCameraGetPushFiles instance;
  private byte[] data = new byte['ǯ'];
  
  public static DataCameraGetPushFiles getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushFiles();
      }
      DataCameraGetPushFiles localDataCameraGetPushFiles = instance;
      return localDataCameraGetPushFiles;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public byte[] getData()
  {
    return null;
  }
  
  public int getIndex()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushFiles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */