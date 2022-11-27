package dji.midware.data.model.P3;

import dji.logic.album.manager.litchis.DJIFileType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.Date;

public class DataCameraGetSpecialFileParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraGetSpecialFileParams instance;
  private int index;
  private int subIndex;
  
  public static DataCameraGetSpecialFileParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetSpecialFileParams();
      }
      DataCameraGetSpecialFileParams localDataCameraGetSpecialFileParams = instance;
      return localDataCameraGetSpecialFileParams;
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
  
  public Date getCreateDate()
  {
    return null;
  }
  
  public long getCreateTimestamp()
  {
    return 277656665L;
  }
  
  public int getFileSize()
  {
    return 0;
  }
  
  public DJIFileType getFileType()
  {
    return null;
  }
  
  public long getOrgCreateTimestamp()
  {
    return 277656680L;
  }
  
  public int getSubImageNum()
  {
    return 0;
  }
  
  public Date parseTime(long paramLong)
  {
    return null;
  }
  
  public DataCameraGetSpecialFileParams setIndex(int paramInt)
  {
    this.index = paramInt;
    return this;
  }
  
  public DataCameraGetSpecialFileParams setSubindex(int paramInt)
  {
    this.subIndex = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetSpecialFileParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */