package dji.common.mission.panorama;

import dji.common.mission.MissionState;

public class PanoramaMissionState
  extends MissionState
{
  public static final PanoramaMissionState DISCONNECTED;
  public static final PanoramaMissionState EXECUTING = new PanoramaMissionState("EXECUTING");
  public static final PanoramaMissionState NOT_SUPPORTED;
  public static final PanoramaMissionState READY_TO_EXECUTE;
  public static final PanoramaMissionState READY_TO_SETUP;
  public static final PanoramaMissionState SETTING_UP;
  public static final PanoramaMissionState UNKNOWN = new PanoramaMissionState("UNKNOWN");
  
  static
  {
    DISCONNECTED = new PanoramaMissionState("DISCONNECTED");
    NOT_SUPPORTED = new PanoramaMissionState("NOT_SUPPORTED");
    READY_TO_SETUP = new PanoramaMissionState("READY_TO_SETUP");
    SETTING_UP = new PanoramaMissionState("SETTING_UP");
    READY_TO_EXECUTE = new PanoramaMissionState("READY_TO_EXECUTE");
  }
  
  public PanoramaMissionState(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\panorama\PanoramaMissionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */