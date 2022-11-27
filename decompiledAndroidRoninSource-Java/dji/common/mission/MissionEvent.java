package dji.common.mission;

public class MissionEvent
{
  public static final MissionEvent CAMERA_MODE_CHANGE = new MissionEvent("CAMERA_MODE_CHANGE");
  public static final MissionEvent CONNECTED;
  public static final MissionEvent DISCONNECTED;
  public static final MissionEvent DOWNLOAD_DONE;
  public static final MissionEvent DOWNLOAD_FAILED;
  public static final MissionEvent ENTER_NAVIGATION_MODE;
  public static final MissionEvent EXECUTION_FAILED;
  public static final MissionEvent EXECUTION_FINISHED;
  public static final MissionEvent EXECUTION_INTERRUPTED;
  public static final MissionEvent EXECUTION_PAUSED;
  public static final MissionEvent EXECUTION_PAUSE_FAILED;
  public static final MissionEvent EXECUTION_PROGRESS_UPDATE;
  public static final MissionEvent EXECUTION_RESUMED;
  public static final MissionEvent EXECUTION_RESUME_FAILED;
  public static final MissionEvent EXECUTION_STARTED;
  public static final MissionEvent EXECUTION_START_FAILED;
  public static final MissionEvent EXECUTION_STOPPED;
  public static final MissionEvent EXECUTION_STOP_FAILED;
  public static final MissionEvent EXIT_NAVIGATION_MODE;
  public static final MissionEvent INITIALIZED = new MissionEvent("INITIALIZED");
  public static final MissionEvent RC_MODE_CHANGED;
  public static final MissionEvent SETUP_DONE;
  public static final MissionEvent SETUP_FAILED;
  public static final MissionEvent UNKNOWN;
  private final String name;
  
  static
  {
    ENTER_NAVIGATION_MODE = new MissionEvent("ENTER_NAVIGATION_MODE");
    EXIT_NAVIGATION_MODE = new MissionEvent("EXIT_NAVIGATION_MODE");
    RC_MODE_CHANGED = new MissionEvent("RC_MODE_CHANGED");
    DISCONNECTED = new MissionEvent("DISCONNECTED");
    CONNECTED = new MissionEvent("CONNECTED");
    EXECUTION_STARTED = new MissionEvent("EXECUTION_STARTED");
    EXECUTION_START_FAILED = new MissionEvent("EXECUTION_START_FAILED");
    EXECUTION_PAUSED = new MissionEvent("EXECUTION_PAUSED");
    EXECUTION_PAUSE_FAILED = new MissionEvent("EXECUTION_PAUSE_FAILED");
    EXECUTION_STOPPED = new MissionEvent("EXECUTION_STOPPED");
    EXECUTION_STOP_FAILED = new MissionEvent("EXECUTION_STOP_FAILED");
    EXECUTION_RESUMED = new MissionEvent("EXECUTION_RESUMED");
    EXECUTION_RESUME_FAILED = new MissionEvent("EXECUTION_RESUME_FAILED");
    EXECUTION_PROGRESS_UPDATE = new MissionEvent("EXECUTION_PROGRESS_UPDATE");
    EXECUTION_INTERRUPTED = new MissionEvent("EXECUTION_INTERRUPTED");
    EXECUTION_FINISHED = new MissionEvent("EXECUTION_FINISHED");
    EXECUTION_FAILED = new MissionEvent("EXECUTION_FAILED");
    DOWNLOAD_FAILED = new MissionEvent("DOWNLOAD_FAILED");
    DOWNLOAD_DONE = new MissionEvent("DOWNLOAD_DONE");
    SETUP_FAILED = new MissionEvent("SETUP_FAILED");
    UNKNOWN = new MissionEvent("UNKNOWN");
    SETUP_DONE = new MissionEvent("SETUP_DONE");
  }
  
  public MissionEvent(String paramString)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\MissionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */