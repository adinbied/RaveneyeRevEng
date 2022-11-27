package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetPhotoMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetPhotoMode instance;
  private int continueNum;
  private int timeInterval;
  private int timeNum;
  private int timeType;
  private DataCameraSetPhoto.TYPE type;
  
  public static DataCameraSetPhotoMode getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetPhotoMode();
      }
      DataCameraSetPhotoMode localDataCameraSetPhotoMode = instance;
      return localDataCameraSetPhotoMode;
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
  
  public DataCameraSetPhotoMode setContinueNum(int paramInt)
  {
    this.continueNum = paramInt;
    return this;
  }
  
  public DataCameraSetPhotoMode setTimeInterval(int paramInt)
  {
    this.timeInterval = paramInt;
    return this;
  }
  
  public DataCameraSetPhotoMode setTimeNum(int paramInt)
  {
    this.timeNum = paramInt;
    return this;
  }
  
  public DataCameraSetPhotoMode setTimeType(int paramInt)
  {
    this.timeType = paramInt;
    return this;
  }
  
  public DataCameraSetPhotoMode setType(int paramInt)
  {
    this.type = DataCameraSetPhoto.TYPE.find(paramInt);
    return this;
  }
  
  public DataCameraSetPhotoMode setType(DataCameraSetPhoto.TYPE paramTYPE)
  {
    this.type = paramTYPE;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetPhotoMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */