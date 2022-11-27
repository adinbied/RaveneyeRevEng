package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycDownloadWayPointMissionMsg
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycDownloadWayPointMissionMsg instance;
  
  public static DataFlycDownloadWayPointMissionMsg getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycDownloadWayPointMissionMsg();
      }
      DataFlycDownloadWayPointMissionMsg localDataFlycDownloadWayPointMissionMsg = instance;
      return localDataFlycDownloadWayPointMissionMsg;
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
  
  public DataFlycUploadWayPointMissionMsg.ACTION_ON_RC_LOST getActionOnRCLost()
  {
    return null;
  }
  
  public float getCmdSpeed()
  {
    return 0.0F;
  }
  
  public DataFlycUploadWayPointMissionMsg.FINISH_ACTION getFinishAction()
  {
    return null;
  }
  
  public DataFlycUploadWayPointMissionMsg.GIMBAL_PITCH_MODE getGimbalPitchMode()
  {
    return null;
  }
  
  public int getGotoFirstFlag()
  {
    return 0;
  }
  
  public float getHPHeight()
  {
    return 0.0F;
  }
  
  public double getHPLat()
  {
    return 1.3718718E-315D;
  }
  
  public double getHPLng()
  {
    return 1.37187182E-315D;
  }
  
  public float getIdleSpeed()
  {
    return 0.0F;
  }
  
  public int getRepeatNum()
  {
    return 0;
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public DataFlycUploadWayPointMissionMsg.TRACE_MODE getTraceMode()
  {
    return null;
  }
  
  public int getWayPointCount()
  {
    return 0;
  }
  
  public DataFlycUploadWayPointMissionMsg.YAW_MODE getYawMode()
  {
    return null;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycDownloadWayPointMissionMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */