package dji.common.mission.followme;

import dji.common.mission.MissionEvent;

public class FollowMeEvent
  extends MissionEvent
{
  public static final FollowMeEvent GOT_STUCK = new FollowMeEvent("GOT_STUCK");
  
  public FollowMeEvent(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\followme\FollowMeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */