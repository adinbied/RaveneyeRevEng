package dji.internal.mission.abstraction.activetrack;

import dji.common.mission.MissionEvent;
import dji.internal.mission.abstraction.AbstractionDataHolder;
import dji.internal.mission.abstraction.AbstractionDataHolder.Builder;

public class ActiveTrackAbstractionDataHolder
  extends AbstractionDataHolder
{
  public ActiveTrackAbstractionDataHolder(AbstractionDataHolder.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static class ActiveTrackBuilder
    extends AbstractionDataHolder.Builder
  {
    public ActiveTrackBuilder() {}
    
    public ActiveTrackBuilder(MissionEvent paramMissionEvent)
    {
      super();
    }
    
    public ActiveTrackAbstractionDataHolder build()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\activetrack\ActiveTrackAbstractionDataHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */