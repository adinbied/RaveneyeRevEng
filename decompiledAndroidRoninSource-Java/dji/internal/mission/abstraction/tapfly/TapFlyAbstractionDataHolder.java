package dji.internal.mission.abstraction.tapfly;

import dji.common.mission.MissionEvent;
import dji.internal.mission.abstraction.AbstractionDataHolder;
import dji.internal.mission.abstraction.AbstractionDataHolder.Builder;

public class TapFlyAbstractionDataHolder
  extends AbstractionDataHolder
{
  public TapFlyAbstractionDataHolder(AbstractionDataHolder.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static class TapFlyBuilder
    extends AbstractionDataHolder.Builder
  {
    public TapFlyBuilder() {}
    
    public TapFlyBuilder(MissionEvent paramMissionEvent)
    {
      super();
    }
    
    public TapFlyAbstractionDataHolder build()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\tapfly\TapFlyAbstractionDataHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */