package dji.midware.data.model.litchis;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.packages.litchis.FileRecvPack;

public class DataCameraFileSystemAbort
  extends DataBase
{
  private static DataCameraFileSystemAbort instance;
  private FileRecvPack recvPack;
  
  public static DataCameraFileSystemAbort getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraFileSystemAbort();
      }
      DataCameraFileSystemAbort localDataCameraFileSystemAbort = instance;
      return localDataCameraFileSystemAbort;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public FileRecvPack getRecvPack()
  {
    return this.recvPack;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    super.setPushRecData(paramArrayOfByte);
  }
  
  public void setRecvPack(FileRecvPack paramFileRecvPack)
  {
    this.recvPack = paramFileRecvPack;
    setPushRecData(paramFileRecvPack.buffer);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\litchis\DataCameraFileSystemAbort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */