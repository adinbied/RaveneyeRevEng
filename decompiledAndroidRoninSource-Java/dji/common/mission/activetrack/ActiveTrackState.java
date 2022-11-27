package dji.common.mission.activetrack;

import dji.common.mission.MissionState;

public class ActiveTrackState
  extends MissionState
{
  public static final ActiveTrackState AIRCRAFT_FOLLOWING;
  public static final ActiveTrackState CANNOT_CONFIRM;
  public static final ActiveTrackState CANNOT_START;
  public static final ActiveTrackState DETECTING_HUMAN;
  public static final ActiveTrackState DISCONNECTED;
  public static final ActiveTrackState FINDING_TRACKED_TARGET;
  public static final ActiveTrackState IDLE;
  public static final ActiveTrackState NOT_SUPPORT;
  public static final ActiveTrackState ONLY_CAMERA_FOLLOWING = new ActiveTrackState("ONLY_CAMERA_FOLLOWING");
  public static final ActiveTrackState RECOVERING;
  public static final ActiveTrackState UNKNOWN = new ActiveTrackState("UNKNOWN");
  public static final ActiveTrackState WAITING_FOR_CONFIRMATION = new ActiveTrackState("WAITING_FOR_CONFIRMATION");
  
  static
  {
    DISCONNECTED = new ActiveTrackState("DISCONNECTED");
    CANNOT_CONFIRM = new ActiveTrackState("CANNOT_CONFIRM");
    AIRCRAFT_FOLLOWING = new ActiveTrackState("AIRCRAFT_FOLLOWING");
    CANNOT_START = new ActiveTrackState("CANNOT_START");
    DETECTING_HUMAN = new ActiveTrackState("DETECTING_HUMAN");
    FINDING_TRACKED_TARGET = new ActiveTrackState("FINDING_TRACKED_TARGET");
    IDLE = new ActiveTrackState("IDLE");
    NOT_SUPPORT = new ActiveTrackState("NOT_SUPPORT");
    RECOVERING = new ActiveTrackState("RECOVERING");
  }
  
  private ActiveTrackState(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\activetrack\ActiveTrackState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */