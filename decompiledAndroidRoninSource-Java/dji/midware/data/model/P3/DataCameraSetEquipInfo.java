package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetEquipInfo
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetEquipInfo instance;
  private int mClipId;
  private char mEquipLabel;
  private int mRealName;
  
  public static DataCameraSetEquipInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetEquipInfo();
      }
      DataCameraSetEquipInfo localDataCameraSetEquipInfo = instance;
      return localDataCameraSetEquipInfo;
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
  
  public DataCameraSetEquipInfo setClipId(int paramInt)
  {
    this.mClipId = paramInt;
    return this;
  }
  
  public DataCameraSetEquipInfo setEquipLabel(char paramChar)
  {
    this.mEquipLabel = paramChar;
    return this;
  }
  
  public DataCameraSetEquipInfo setRealName(int paramInt)
  {
    this.mRealName = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetEquipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */