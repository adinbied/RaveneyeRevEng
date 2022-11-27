package dji.internal.mission.abstraction.followme;

import dji.common.mission.MissionEvent;
import dji.internal.mission.abstraction.AbstractionDataHolder;
import dji.internal.mission.abstraction.AbstractionDataHolder.Builder;

public class FollowMeAbstractionDataHolder
  extends AbstractionDataHolder
{
  public FollowMeAbstractionDataHolder(AbstractionDataHolder.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static class FollowMeBuilder
    extends AbstractionDataHolder.Builder
  {
    public FollowMeBuilder() {}
    
    public FollowMeBuilder(MissionEvent paramMissionEvent)
    {
      super();
    }
    
    public FollowMeAbstractionDataHolder build()
    {
      return new FollowMeAbstractionDataHolder(this);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\followme\FollowMeAbstractionDataHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */