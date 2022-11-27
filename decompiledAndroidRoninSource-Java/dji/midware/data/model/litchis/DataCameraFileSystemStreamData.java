package dji.midware.data.model.litchis;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.packages.litchis.FileRecvPack;

public class DataCameraFileSystemStreamData
  extends DataBase
{
  private static DataCameraFileSystemStreamData instance;
  private FileRecvPack recvPack;
  
  public static DataCameraFileSystemStreamData getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraFileSystemStreamData();
      }
      DataCameraFileSystemStreamData localDataCameraFileSystemStreamData = instance;
      return localDataCameraFileSystemStreamData;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public long getDuration()
  {
    return 277699492L;
  }
  
  public int getFrameDuration()
  {
    return 0;
  }
  
  public int getInfoLen()
  {
    return 32;
  }
  
  public FileRecvPack getRecvPack()
  {
    return this.recvPack;
  }
  
  public long getStartTime()
  {
    return 277699504L;
  }
  
  public int getTimeScale()
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
  
  public void setRecvPack(FileRecvPack paramFileRecvPack)
  {
    this.recvPack = paramFileRecvPack;
    setPushRecData(paramFileRecvPack.data);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\litchis\DataCameraFileSystemStreamData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */