package dji.midware.data.model.litchis;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.packages.litchis.FileRecvPack;

public class DataCameraFileSystemListInfo
  extends DataBase
{
  private static DataCameraFileSystemListInfo instance;
  private FileRecvPack recvPack;
  
  public static DataCameraFileSystemListInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraFileSystemListInfo();
      }
      DataCameraFileSystemListInfo localDataCameraFileSystemListInfo = instance;
      return localDataCameraFileSystemListInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getDataLength()
  {
    return 0;
  }
  
  public int getFileCount()
  {
    return 0;
  }
  
  public FileRecvPack getRecvPack()
  {
    return this.recvPack;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    super.setPushRecData(paramArrayOfByte);
  }
  
  public void setRecvPack(FileRecvPack paramFileRecvPack)
  {
    this.recvPack = paramFileRecvPack;
    setPushRecData(paramFileRecvPack.data);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\litchis\DataCameraFileSystemListInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */