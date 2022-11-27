package dji.internal.mission.abstraction.panorama;

import dji.common.mission.MissionEvent;
import dji.internal.mission.abstraction.AbstractionDataHolder;
import dji.internal.mission.abstraction.AbstractionDataHolder.Builder;

public class PanoramaAbstractionDataHolder
  extends AbstractionDataHolder
{
  public PanoramaAbstractionDataHolder(AbstractionDataHolder.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static class PanoramaBuilder
    extends AbstractionDataHolder.Builder
  {
    public PanoramaBuilder() {}
    
    public PanoramaBuilder(MissionEvent paramMissionEvent)
    {
      super();
    }
    
    public PanoramaAbstractionDataHolder build()
    {
      return new PanoramaAbstractionDataHolder(this);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\panorama\PanoramaAbstractionDataHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */