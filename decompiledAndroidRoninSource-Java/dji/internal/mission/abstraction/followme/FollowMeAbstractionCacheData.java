package dji.internal.mission.abstraction.followme;

import dji.midware.data.model.P3.DataFlycGetPushWayPointMissionInfo;
import dji.midware.data.model.P3.DataOsdGetPushCommon.FLYC_STATE;
import dji.midware.data.model.P3.DataOsdGetPushCommon.RcModeChannel;

public class FollowMeAbstractionCacheData
{
  private DataOsdGetPushCommon.FLYC_STATE fcMode;
  private DataFlycGetPushWayPointMissionInfo missionStatus;
  private Boolean navigationEnabled;
  private DataOsdGetPushCommon.RcModeChannel rcMode;
  
  public FollowMeAbstractionCacheData()
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
  
  public Boolean isNavigationEnabled()
  {
    return this.navigationEnabled;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\followme\FollowMeAbstractionCacheData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */