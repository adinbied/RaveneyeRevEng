package dji.common.mission;

import dji.common.mission.activetrack.ActiveTrackState;
import dji.common.mission.followme.FollowMeMissionState;
import dji.common.mission.hotpoint.HotpointMissionState;
import dji.common.mission.panorama.PanoramaMissionState;
import dji.common.mission.tapfly.TapFlyMissionState;
import dji.common.mission.waypoint.WaypointMissionState;

public class StateHelper
{
  private static final ActiveTrackState[] PUBLIC_ACTIVE_TRACK_STATE;
  private static final FollowMeMissionState[] PUBLIC_FOLLOW_ME_STATE = { FollowMeMissionState.UNKNOWN, FollowMeMissionState.DISCONNECTED, FollowMeMissionState.NOT_SUPPORTED, FollowMeMissionState.RECOVERING, FollowMeMissionState.READY_TO_EXECUTE, FollowMeMissionState.EXECUTING };
  private static final HotpointMissionState[] PUBLIC_HOTPOINT_STATE;
  private static final PanoramaMissionState[] PUBLIC_PANORAMA_STATE = { PanoramaMissionState.UNKNOWN, PanoramaMissionState.DISCONNECTED, PanoramaMissionState.NOT_SUPPORTED, PanoramaMissionState.READY_TO_SETUP, PanoramaMissionState.SETTING_UP, PanoramaMissionState.READY_TO_EXECUTE, PanoramaMissionState.EXECUTING };
  private static final TapFlyMissionState[] PUBLIC_TAP_FLY_STATE;
  private static final WaypointMissionState[] PUBLIC_WAYPOINT_STATE = { WaypointMissionState.UNKNOWN, WaypointMissionState.DISCONNECTED, WaypointMissionState.NOT_SUPPORTED, WaypointMissionState.RECOVERING, WaypointMissionState.READY_TO_UPLOAD, WaypointMissionState.UPLOADING, WaypointMissionState.READY_TO_EXECUTE, WaypointMissionState.EXECUTING, WaypointMissionState.EXECUTION_PAUSED };
  
  static
  {
    PUBLIC_HOTPOINT_STATE = new HotpointMissionState[] { HotpointMissionState.UNKNOWN, HotpointMissionState.DISCONNECTED, HotpointMissionState.NOT_SUPPORTED, HotpointMissionState.RECOVERING, HotpointMissionState.READY_TO_EXECUTE, HotpointMissionState.INITIAL_PHASE, HotpointMissionState.EXECUTING, HotpointMissionState.EXECUTION_PAUSED };
    PUBLIC_ACTIVE_TRACK_STATE = new ActiveTrackState[] { ActiveTrackState.UNKNOWN, ActiveTrackState.DISCONNECTED, ActiveTrackState.CANNOT_CONFIRM, ActiveTrackState.AIRCRAFT_FOLLOWING, ActiveTrackState.CANNOT_START, ActiveTrackState.DETECTING_HUMAN, ActiveTrackState.FINDING_TRACKED_TARGET, ActiveTrackState.IDLE, ActiveTrackState.NOT_SUPPORT, ActiveTrackState.RECOVERING, ActiveTrackState.ONLY_CAMERA_FOLLOWING, ActiveTrackState.WAITING_FOR_CONFIRMATION };
    PUBLIC_TAP_FLY_STATE = new TapFlyMissionState[] { TapFlyMissionState.UNKNOWN, TapFlyMissionState.NOT_SUPPORT, TapFlyMissionState.CAN_NOT_START, TapFlyMissionState.IDLE, TapFlyMissionState.EXECUTION_STARTING, TapFlyMissionState.EXECUTING, TapFlyMissionState.EXECUTION_PAUSED, TapFlyMissionState.EXECUTION_RESETTING, TapFlyMissionState.RECOVERING, TapFlyMissionState.DISCONNECTED };
  }
  
  public static ActiveTrackState convertToActiveTrackPublicState(MissionState paramMissionState)
  {
    if (paramMissionState == null) {
      return ActiveTrackState.UNKNOWN;
    }
    ActiveTrackState[] arrayOfActiveTrackState = PUBLIC_ACTIVE_TRACK_STATE;
    int j = arrayOfActiveTrackState.length;
    int i = 0;
    while (i < j)
    {
      ActiveTrackState localActiveTrackState = arrayOfActiveTrackState[i];
      if (localActiveTrackState.equals(paramMissionState)) {
        return localActiveTrackState;
      }
      i += 1;
    }
    return ActiveTrackState.UNKNOWN;
  }
  
  public static FollowMeMissionState convertToFollowMePublicState(MissionState paramMissionState)
  {
    if (paramMissionState == null) {
      return FollowMeMissionState.UNKNOWN;
    }
    FollowMeMissionState[] arrayOfFollowMeMissionState = PUBLIC_FOLLOW_ME_STATE;
    int j = arrayOfFollowMeMissionState.length;
    int i = 0;
    while (i < j)
    {
      FollowMeMissionState localFollowMeMissionState = arrayOfFollowMeMissionState[i];
      if (localFollowMeMissionState.equals(paramMissionState)) {
        return localFollowMeMissionState;
      }
      i += 1;
    }
    if ((paramMissionState != MissionState.NOT_READY) && (paramMissionState != MissionState.EXECUTION_STARTING))
    {
      if ((paramMissionState != MissionState.EXECUTION_PAUSED) && (paramMissionState != MissionState.EXECUTION_PAUSING) && (paramMissionState != MissionState.EXECUTION_STOPPING) && (paramMissionState != MissionState.GOT_STUCK) && (paramMissionState != MissionState.EXECUTION_RESUMING)) {
        return FollowMeMissionState.UNKNOWN;
      }
      return FollowMeMissionState.EXECUTING;
    }
    return FollowMeMissionState.READY_TO_EXECUTE;
  }
  
  public static HotpointMissionState convertToHotpointPublicState(MissionState paramMissionState)
  {
    if (paramMissionState == null) {
      return HotpointMissionState.UNKNOWN;
    }
    HotpointMissionState[] arrayOfHotpointMissionState = PUBLIC_HOTPOINT_STATE;
    int j = arrayOfHotpointMissionState.length;
    int i = 0;
    while (i < j)
    {
      HotpointMissionState localHotpointMissionState = arrayOfHotpointMissionState[i];
      if (localHotpointMissionState.equals(paramMissionState)) {
        return localHotpointMissionState;
      }
      i += 1;
    }
    if ((paramMissionState != MissionState.NOT_READY) && (paramMissionState != MissionState.EXECUTION_STARTING))
    {
      if ((paramMissionState != MissionState.EXECUTION_PAUSING) && (paramMissionState != MissionState.EXECUTION_STOPPING))
      {
        if (paramMissionState == MissionState.EXECUTION_RESUMING) {
          return HotpointMissionState.EXECUTION_PAUSED;
        }
        return HotpointMissionState.UNKNOWN;
      }
      return HotpointMissionState.EXECUTING;
    }
    return HotpointMissionState.READY_TO_EXECUTE;
  }
  
  public static PanoramaMissionState convertToPanoramaPublicState(MissionState paramMissionState)
  {
    if (paramMissionState == null) {
      return null;
    }
    PanoramaMissionState[] arrayOfPanoramaMissionState = PUBLIC_PANORAMA_STATE;
    int j = arrayOfPanoramaMissionState.length;
    int i = 0;
    while (i < j)
    {
      PanoramaMissionState localPanoramaMissionState = arrayOfPanoramaMissionState[i];
      if (localPanoramaMissionState.equals(paramMissionState)) {
        return localPanoramaMissionState;
      }
      i += 1;
    }
    if ((paramMissionState != MissionState.EXECUTION_STARTING) && (paramMissionState != MissionState.EXECUTION_STOPPING)) {
      return null;
    }
    return PanoramaMissionState.EXECUTING;
  }
  
  public static TapFlyMissionState convertToTapFlyMissionPublicState(MissionState paramMissionState)
  {
    if (paramMissionState == null) {
      return TapFlyMissionState.UNKNOWN;
    }
    TapFlyMissionState[] arrayOfTapFlyMissionState = PUBLIC_TAP_FLY_STATE;
    int j = arrayOfTapFlyMissionState.length;
    int i = 0;
    while (i < j)
    {
      TapFlyMissionState localTapFlyMissionState = arrayOfTapFlyMissionState[i];
      if (localTapFlyMissionState.equals(paramMissionState)) {
        return localTapFlyMissionState;
      }
      i += 1;
    }
    if (paramMissionState == TapFlyMissionState.EXECUTION_STARTING) {
      return TapFlyMissionState.EXECUTING;
    }
    return TapFlyMissionState.UNKNOWN;
  }
  
  public static WaypointMissionState convertToWaypointPublicState(MissionState paramMissionState)
  {
    if (paramMissionState == null) {
      return WaypointMissionState.UNKNOWN;
    }
    WaypointMissionState[] arrayOfWaypointMissionState = PUBLIC_WAYPOINT_STATE;
    int j = arrayOfWaypointMissionState.length;
    int i = 0;
    while (i < j)
    {
      WaypointMissionState localWaypointMissionState = arrayOfWaypointMissionState[i];
      if (localWaypointMissionState.equals(paramMissionState)) {
        return localWaypointMissionState;
      }
      i += 1;
    }
    if ((paramMissionState != MissionState.NOT_READY) && (paramMissionState != MissionState.READY_TO_RETRY_UPLOAD) && (paramMissionState != MissionState.UPLOAD_STARTING))
    {
      if (paramMissionState == MissionState.EXECUTION_STARTING) {
        return WaypointMissionState.READY_TO_EXECUTE;
      }
      if ((paramMissionState != MissionState.EXECUTION_PAUSING) && (paramMissionState != MissionState.EXECUTION_STOPPING))
      {
        if (paramMissionState == MissionState.EXECUTION_RESUMING) {
          return WaypointMissionState.EXECUTION_PAUSED;
        }
        return WaypointMissionState.UNKNOWN;
      }
      return WaypointMissionState.EXECUTING;
    }
    return WaypointMissionState.READY_TO_UPLOAD;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\StateHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */