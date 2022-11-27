package dji.internal.mission.abstraction.waypoint;

import dji.common.mission.waypoint.WaypointExecutionProgress;
import dji.common.mission.waypoint.WaypointMission.Builder;
import dji.common.mission.waypoint.WaypointUploadProgress;
import dji.midware.data.model.P3.DataFlycGetPushWayPointMissionInfo;
import dji.midware.data.model.P3.DataOsdGetPushCommon.FLYC_STATE;
import dji.midware.data.model.P3.DataOsdGetPushCommon.RcModeChannel;
import java.util.Date;

public class WaypointAbstractionCacheData
{
  private static final double MISSION_CACHE_EXPIRATION = 5000.0D;
  public DataOsdGetPushCommon.FLYC_STATE fcMode;
  public Boolean isBeginnerModeEnabled;
  public Boolean isMultipleModeEnabled;
  public Boolean isNavigationEnabled;
  public Boolean isSimulatorOn;
  public WaypointExecutionProgress lastProgress;
  public WaypointMission.Builder missionBuilder;
  public Integer missionEvent;
  public DataFlycGetPushWayPointMissionInfo missionStatus;
  public Date missionValidDate;
  public Integer prevReachedIndex;
  public Integer prevTargetIndex;
  public DataOsdGetPushCommon.RcModeChannel rcMode;
  public Integer reachedWaypointIndex;
  public Integer targetIndex;
  public WaypointUploadProgress uploadProgress;
  
  public WaypointAbstractionCacheData()
  {
    reset();
  }
  
  public boolean isMissionStatusChanged(DataFlycGetPushWayPointMissionInfo paramDataFlycGetPushWayPointMissionInfo)
  {
    return false;
  }
  
  public boolean isMissionStatusInited()
  {
    return this.missionStatus != null;
  }
  
  public boolean isMissionValid()
  {
    return false;
  }
  
  /* Error */
  public void renewMissionDate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void replaceMission(WaypointMission.Builder paramBuilder)
  {
    this.missionBuilder = paramBuilder;
    this.missionValidDate = null;
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void resetMissionStatus()
  {
    this.missionStatus = new DataFlycGetPushWayPointMissionInfo();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\waypoint\WaypointAbstractionCacheData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */