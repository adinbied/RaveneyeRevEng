package dji.common.mission.hotpoint;

import dji.common.mission.MissionState;

public class HotpointMissionState
  extends MissionState
{
  public static final HotpointMissionState DISCONNECTED;
  public static final HotpointMissionState EXECUTING = new HotpointMissionState("EXECUTING");
  public static final HotpointMissionState EXECUTION_PAUSED = new HotpointMissionState("EXECUTION_PAUSED");
  public static final HotpointMissionState INITIAL_PHASE;
  public static final HotpointMissionState NOT_SUPPORTED;
  public static final HotpointMissionState READY_TO_EXECUTE;
  public static final HotpointMissionState RECOVERING;
  public static final HotpointMissionState UNKNOWN = new HotpointMissionState("UNKNOWN");
  
  static
  {
    DISCONNECTED = new HotpointMissionState("DISCONNECTED");
    NOT_SUPPORTED = new HotpointMissionState("NOT_SUPPORTED");
    RECOVERING = new HotpointMissionState("RECOVERING");
    READY_TO_EXECUTE = new HotpointMissionState("READY_TO_EXECUTE");
    INITIAL_PHASE = new HotpointMissionState("INITIAL_PHASE");
  }
  
  private HotpointMissionState(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\hotpoint\HotpointMissionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */