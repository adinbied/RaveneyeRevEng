package dji.common.mission;

public class MissionState
{
  public static final MissionState AIRCRAFT_FOLLOWING;
  public static final MissionState CANNOT_CONFIRM;
  public static final MissionState CANNOT_START;
  public static final MissionState CAN_NOT_START = new MissionState("CAN_NOT_START");
  public static final MissionState DETECTING_HUMAN;
  public static final MissionState DISCONNECTED = new MissionState("DISCONNECTED");
  public static final MissionState EXECUTING;
  public static final MissionState EXECUTION_PAUSED;
  public static final MissionState EXECUTION_PAUSING;
  public static final MissionState EXECUTION_RESETTING = new MissionState("EXECUTION_RESETTING");
  public static final MissionState EXECUTION_RESUMING;
  public static final MissionState EXECUTION_STARTING;
  public static final MissionState EXECUTION_STOPPING;
  public static final MissionState FINDING_TRACKED_TARGET;
  public static final MissionState GOT_STUCK;
  public static final MissionState IDLE;
  public static final MissionState INITIAL_PHASE;
  public static final MissionState NOT_READY;
  public static final MissionState NOT_SUPPORTED;
  public static final MissionState ONLY_CAMERA_FOLLOWING;
  public static final MissionState READY_TO_EXECUTE;
  public static final MissionState READY_TO_RETRY_UPLOAD;
  public static final MissionState READY_TO_SETUP = new MissionState("READY_TO_SETUP");
  public static final MissionState READY_TO_UPLOAD;
  public static final MissionState RECOVERING = new MissionState("RECOVERING");
  public static final MissionState SETTING_UP = new MissionState("SETTING_UP");
  public static final MissionState UNKNOWN;
  public static final MissionState UPLOADING;
  public static final MissionState UPLOAD_STARTING;
  public static final MissionState WAITING_FOR_CONFIRMATION;
  private final String name;
  
  static
  {
    NOT_READY = new MissionState("NOT_READY");
    READY_TO_EXECUTE = new MissionState("READY_TO_EXECUTE");
    NOT_SUPPORTED = new MissionState("NOT_SUPPORTED");
    UNKNOWN = new MissionState("UNKNOWN");
    READY_TO_UPLOAD = new MissionState("READY_TO_UPLOAD");
    READY_TO_RETRY_UPLOAD = new MissionState("READY_TO_RETRY_UPLOAD");
    UPLOAD_STARTING = new MissionState("UPLOAD_STARTING");
    UPLOADING = new MissionState("UPLOADING");
    EXECUTION_STARTING = new MissionState("EXECUTION_STARTING");
    EXECUTING = new MissionState("EXECUTING");
    EXECUTION_PAUSING = new MissionState("EXECUTION_PAUSING");
    EXECUTION_PAUSED = new MissionState("EXECUTION_PAUSED");
    EXECUTION_RESUMING = new MissionState("EXECUTION_RESUMING");
    EXECUTION_STOPPING = new MissionState("EXECUTION_STOPPING");
    GOT_STUCK = new MissionState("GOT_STUCK");
    INITIAL_PHASE = new MissionState("INITIAL_PHASE");
    IDLE = new MissionState("IDLE");
    CANNOT_START = new MissionState("CANNOT_START");
    DETECTING_HUMAN = new MissionState("DETECTING_HUMAN");
    WAITING_FOR_CONFIRMATION = new MissionState("WAITING_FOR_CONFIRMATION");
    CANNOT_CONFIRM = new MissionState("CANNOT_CONFIRM");
    AIRCRAFT_FOLLOWING = new MissionState("AIRCRAFT_FOLLOWING");
    ONLY_CAMERA_FOLLOWING = new MissionState("ONLY_CAMERA_FOLLOWING");
    FINDING_TRACKED_TARGET = new MissionState("FINDING_TRACKED_TARGET");
  }
  
  public MissionState(String paramString)
  {
    this.name = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    return this.name.hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\MissionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */