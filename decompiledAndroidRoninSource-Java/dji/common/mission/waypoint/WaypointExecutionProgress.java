package dji.common.mission.waypoint;

import dji.midware.data.model.P3.DataFlycGetPushWayPointMissionInfo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class WaypointExecutionProgress
{
  public static final int UNKNOWN = -1;
  public WaypointMissionExecuteState executeState;
  public boolean isWaypointReached;
  public int targetWaypointIndex;
  public int totalWaypointCount;
  
  public WaypointExecutionProgress(DataFlycGetPushWayPointMissionInfo paramDataFlycGetPushWayPointMissionInfo)
  {
    this.targetWaypointIndex = paramDataFlycGetPushWayPointMissionInfo.getTargetWayPoint();
    this.executeState = WaypointMissionExecuteState.find(paramDataFlycGetPushWayPointMissionInfo.getCurrentStatus());
    if (paramDataFlycGetPushWayPointMissionInfo.getCurrentStatus() == 7) {
      paramDataFlycGetPushWayPointMissionInfo = WaypointMissionExecuteState.MOVING;
    } else {
      paramDataFlycGetPushWayPointMissionInfo = WaypointMissionExecuteState.find(paramDataFlycGetPushWayPointMissionInfo.getCurrentStatus());
    }
    this.executeState = paramDataFlycGetPushWayPointMissionInfo;
    int i = 1.$SwitchMap$dji$common$mission$waypoint$WaypointMissionExecuteState[this.executeState.ordinal()];
    if ((i != 1) && (i != 2) && (i != 3)) {
      this.isWaypointReached = false;
    } else {
      this.isWaypointReached = true;
    }
    this.totalWaypointCount = -1;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface InitialValue {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointExecutionProgress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */