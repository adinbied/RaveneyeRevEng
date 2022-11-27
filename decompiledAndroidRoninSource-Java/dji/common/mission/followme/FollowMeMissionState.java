package dji.common.mission.followme;

import dji.common.mission.MissionState;

public final class FollowMeMissionState
  extends MissionState
{
  public static final FollowMeMissionState DISCONNECTED;
  public static final FollowMeMissionState EXECUTING = new FollowMeMissionState("EXECUTING");
  public static final FollowMeMissionState GOT_STUCK = new FollowMeMissionState("GOT_STUCK");
  public static final FollowMeMissionState NOT_READY;
  public static final FollowMeMissionState NOT_SUPPORTED;
  public static final FollowMeMissionState READY_TO_EXECUTE;
  public static final FollowMeMissionState RECOVERING;
  public static final FollowMeMissionState UNKNOWN = new FollowMeMissionState("UNKNOWN");
  
  static
  {
    DISCONNECTED = new FollowMeMissionState("DISCONNECTED");
    NOT_SUPPORTED = new FollowMeMissionState("NOT_SUPPORTED");
    RECOVERING = new FollowMeMissionState("RECOVERING");
    NOT_READY = new FollowMeMissionState("NOT_READY");
    READY_TO_EXECUTE = new FollowMeMissionState("READY_TO_EXECUTE");
  }
  
  private FollowMeMissionState(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\followme\FollowMeMissionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */