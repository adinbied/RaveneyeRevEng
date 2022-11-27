package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycHotPointMissionDownload
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycHotPointMissionDownload instance;
  
  public static DataFlycHotPointMissionDownload getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycHotPointMissionDownload();
      }
      DataFlycHotPointMissionDownload localDataFlycHotPointMissionDownload = instance;
      return localDataFlycHotPointMissionDownload;
    }
    finally {}
  }
  
  protected void doPack()
  {
    this._sendData = null;
  }
  
  public float getHotPointAngleSpeed()
  {
    return 0.0F;
  }
  
  public double getHotPointAttitude()
  {
    return 1.371887005E-315D;
  }
  
  public DataFlycStartHotPointMissionWithInfo.CAMERA_DIR getHotPointCameraDir()
  {
    return null;
  }
  
  public DataFlycStartHotPointMissionWithInfo.ROTATION_DIR getHotPointClockWise()
  {
    return null;
  }
  
  public double getHotPointLatitude()
  {
    return 1.371887093E-315D;
  }
  
  public double getHotPointLongitude()
  {
    return 1.371887113E-315D;
  }
  
  public double getHotPointRadius()
  {
    return 1.371887133E-315D;
  }
  
  public DataFlycStartHotPointMissionWithInfo.TO_START_POINT_MODE getHotPointToStartPointMode()
  {
    return null;
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public int getVersion()
  {
    return 0;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycHotPointMissionDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */