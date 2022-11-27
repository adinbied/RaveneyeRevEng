package dji.common.mission.activetrack;

public enum ActiveTrackMode
{
  static
  {
    PROFILE = new ActiveTrackMode("PROFILE", 1);
    SPOTLIGHT = new ActiveTrackMode("SPOTLIGHT", 2);
    SPOTLIGHT_PRO = new ActiveTrackMode("SPOTLIGHT_PRO", 3);
    ActiveTrackMode localActiveTrackMode = new ActiveTrackMode("UNKNOWN", 4);
    UNKNOWN = localActiveTrackMode;
    $VALUES = new ActiveTrackMode[] { TRACE, PROFILE, SPOTLIGHT, SPOTLIGHT_PRO, localActiveTrackMode };
  }
  
  private ActiveTrackMode() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\activetrack\ActiveTrackMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */