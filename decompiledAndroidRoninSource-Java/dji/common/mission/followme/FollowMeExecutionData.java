package dji.common.mission.followme;

import dji.midware.data.model.P3.DataFlycGetPushWayPointMissionInfo;

public class FollowMeExecutionData
{
  private float distance;
  private FollowMeMissionExecuteState executeState;
  private int gpsRate;
  
  public FollowMeExecutionData(DataFlycGetPushWayPointMissionInfo paramDataFlycGetPushWayPointMissionInfo)
  {
    this.executeState = FollowMeMissionExecuteState.find(paramDataFlycGetPushWayPointMissionInfo.getFollowMeStatus());
    this.distance = (paramDataFlycGetPushWayPointMissionInfo.getFollowMeDistance() / 100.0F);
    this.gpsRate = paramDataFlycGetPushWayPointMissionInfo.getFollowMeGpsLevel();
  }
  
  public FollowMeMissionExecuteState getExecutionState()
  {
    return this.executeState;
  }
  
  public int getGpsRate()
  {
    return this.gpsRate;
  }
  
  public float getHorizontalDistance()
  {
    return this.distance;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\followme\FollowMeExecutionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */