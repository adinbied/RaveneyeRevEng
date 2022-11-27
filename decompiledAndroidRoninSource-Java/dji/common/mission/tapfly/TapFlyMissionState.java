package dji.common.mission.tapfly;

import dji.common.mission.MissionState;

public final class TapFlyMissionState
  extends MissionState
{
  public static final TapFlyMissionState CAN_NOT_START;
  public static final TapFlyMissionState DISCONNECTED = new TapFlyMissionState("DISCONNECTED");
  public static final TapFlyMissionState EXECUTING;
  public static final TapFlyMissionState EXECUTION_PAUSED;
  public static final TapFlyMissionState EXECUTION_RESETTING;
  public static final TapFlyMissionState EXECUTION_STARTING;
  public static final TapFlyMissionState IDLE;
  public static final TapFlyMissionState NOT_SUPPORT = new TapFlyMissionState("NOT_SUPPORT");
  public static final TapFlyMissionState RECOVERING;
  public static final TapFlyMissionState UNKNOWN = new TapFlyMissionState("UNKNOWN");
  
  static
  {
    CAN_NOT_START = new TapFlyMissionState("CAN_NOT_START");
    IDLE = new TapFlyMissionState("IDLE");
    EXECUTION_STARTING = new TapFlyMissionState("EXECUTION_STARTING");
    EXECUTING = new TapFlyMissionState("EXECUTING");
    EXECUTION_PAUSED = new TapFlyMissionState("EXECUTION_PAUSED");
    EXECUTION_RESETTING = new TapFlyMissionState("EXECUTION_RESETTING");
    RECOVERING = new TapFlyMissionState("RECOVERING");
  }
  
  private TapFlyMissionState(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\tapfly\TapFlyMissionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */