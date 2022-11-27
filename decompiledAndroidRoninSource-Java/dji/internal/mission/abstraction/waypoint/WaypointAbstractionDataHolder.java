package dji.internal.mission.abstraction.waypoint;

import dji.common.mission.MissionEvent;
import dji.internal.mission.abstraction.AbstractionDataHolder;
import dji.internal.mission.abstraction.AbstractionDataHolder.Builder;

public class WaypointAbstractionDataHolder
  extends AbstractionDataHolder
{
  public WaypointAbstractionDataHolder(AbstractionDataHolder.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static class WaypointBuilder
    extends AbstractionDataHolder.Builder
  {
    public WaypointBuilder() {}
    
    public WaypointBuilder(MissionEvent paramMissionEvent)
    {
      this.event = paramMissionEvent;
    }
    
    public WaypointAbstractionDataHolder build()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\waypoint\WaypointAbstractionDataHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */