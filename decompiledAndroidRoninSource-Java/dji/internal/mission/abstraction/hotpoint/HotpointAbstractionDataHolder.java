package dji.internal.mission.abstraction.hotpoint;

import dji.common.mission.MissionEvent;
import dji.internal.mission.abstraction.AbstractionDataHolder;
import dji.internal.mission.abstraction.AbstractionDataHolder.Builder;

public class HotpointAbstractionDataHolder
  extends AbstractionDataHolder
{
  public HotpointAbstractionDataHolder(AbstractionDataHolder.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static class HotpointBuilder
    extends AbstractionDataHolder.Builder
  {
    public HotpointBuilder() {}
    
    public HotpointBuilder(MissionEvent paramMissionEvent)
    {
      super();
    }
    
    public HotpointAbstractionDataHolder build()
    {
      return new HotpointAbstractionDataHolder(this);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\hotpoint\HotpointAbstractionDataHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */