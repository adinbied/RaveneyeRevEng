package dji.common.mission.tapfly;

import dji.common.mission.MissionEvent;

public class TapFlyAbstractionEvent
  extends MissionEvent
{
  public static final TapFlyAbstractionEvent START_TO_EXECUTE = new TapFlyAbstractionEvent("START_TO_EXECUTE");
  public static final TapFlyAbstractionEvent TAP_FLY_DISABLE = new TapFlyAbstractionEvent("TAP_FLY_DISABLE");
  public static final TapFlyAbstractionEvent TAP_FLY_ENABLE = new TapFlyAbstractionEvent("TAP_FLY_ENABLE");
  
  public TapFlyAbstractionEvent(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\tapfly\TapFlyAbstractionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */