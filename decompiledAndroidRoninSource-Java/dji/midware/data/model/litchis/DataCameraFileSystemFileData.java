package dji.midware.data.model.litchis;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.packages.litchis.FileRecvPack;
import java.io.File;
import java.io.FileOutputStream;

public class DataCameraFileSystemFileData
  extends DataBase
{
  private static DataCameraFileSystemFileData instance;
  private File file = new File("/sdcard/testwrite.bin");
  private int i = 0;
  private boolean isDebug = false;
  private FileOutputStream outputStream;
  private FileRecvPack recvPack;
  
  public static DataCameraFileSystemFileData getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraFileSystemFileData();
      }
      DataCameraFileSystemFileData localDataCameraFileSystemFileData = instance;
      return localDataCameraFileSystemFileData;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getIndex()
  {
    return 0;
  }
  
  public int getInfoLen()
  {
    return getPathLen() + 13;
  }
  
  public int getOffset()
  {
    return 0;
  }
  
  public String getPath()
  {
    return null;
  }
  
  public int getPathLen()
  {
    return 0;
  }
  
  public FileRecvPack getRecvPack()
  {
    return this.recvPack;
  }
  
  public int getSize()
  {
    return 0;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    super.setPushRecData(paramArrayOfByte);
  }
  
  /* Error */
  public void setRecvPack(FileRecvPack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\litchis\DataCameraFileSystemFileData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */