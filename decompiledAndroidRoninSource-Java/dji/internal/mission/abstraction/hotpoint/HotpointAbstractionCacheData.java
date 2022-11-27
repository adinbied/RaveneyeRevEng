package dji.internal.mission.abstraction.hotpoint;

import dji.common.mission.hotpoint.HotpointMission;
import dji.midware.data.model.P3.DataFlycGetPushWayPointMissionInfo;
import dji.midware.data.model.P3.DataOsdGetPushCommon.FLYC_STATE;
import dji.midware.data.model.P3.DataOsdGetPushCommon.RcModeChannel;
import java.util.Date;

public class HotpointAbstractionCacheData
{
  private static final double MISSION_CACHE_EXPIRATION = 5000.0D;
  private DataOsdGetPushCommon.FLYC_STATE fcMode;
  private HotpointMission mission;
  private DataFlycGetPushWayPointMissionInfo missionStatus;
  private Date missionValidDate;
  private Boolean navigationEnabled;
  private DataOsdGetPushCommon.RcModeChannel rcMode;
  
  public HotpointAbstractionCacheData()
  {
    reset();
  }
  
  public DataOsdGetPushCommon.FLYC_STATE getFcMode()
  {
    return this.fcMode;
  }
  
  public DataFlycGetPushWayPointMissionInfo getMissionStatus()
  {
    return this.missionStatus;
  }
  
  public DataOsdGetPushCommon.RcModeChannel getRcMode()
  {
    return this.rcMode;
  }
  
  public boolean isMissionStatusChanged(DataFlycGetPushWayPointMissionInfo paramDataFlycGetPushWayPointMissionInfo)
  {
    return false;
  }
  
  public boolean isMissionStatusInitialized()
  {
    return this.missionStatus != null;
  }
  
  public boolean isMissionValid()
  {
    return false;
  }
  
  public Boolean isNavigationEnabled()
  {
    return this.navigationEnabled;
  }
  
  /* Error */
  public void renewMissionDate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void replaceMission(HotpointMission paramHotpointMission)
  {
    this.mission = paramHotpointMission;
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
  
  public void setFcMode(DataOsdGetPushCommon.FLYC_STATE paramFLYC_STATE)
  {
    this.fcMode = paramFLYC_STATE;
  }
  
  public void setMissionStatus(DataFlycGetPushWayPointMissionInfo paramDataFlycGetPushWayPointMissionInfo)
  {
    this.missionStatus = paramDataFlycGetPushWayPointMissionInfo;
  }
  
  public void setNavigationEnabled(boolean paramBoolean)
  {
    this.navigationEnabled = Boolean.valueOf(paramBoolean);
  }
  
  public void setRcMode(DataOsdGetPushCommon.RcModeChannel paramRcModeChannel)
  {
    this.rcMode = paramRcModeChannel;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\hotpoint\HotpointAbstractionCacheData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */