package dji.common.remotecontroller;

public class AircraftStickMapping
{
  private boolean isReversed;
  private AircraftStickMappingTarget mappingTarget;
  
  private AircraftStickMapping(Builder paramBuilder)
  {
    this.mappingTarget = paramBuilder.target;
    this.isReversed = paramBuilder.isReversed;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public AircraftStickMappingTarget getMappingTarget()
  {
    return this.mappingTarget;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isReversed()
  {
    return this.isReversed;
  }
  
  public static final class Builder
  {
    private boolean isReversed;
    private AircraftStickMappingTarget target;
    
    public AircraftStickMapping build()
    {
      return new AircraftStickMapping(this, null);
    }
    
    public Builder isReversed(boolean paramBoolean)
    {
      this.isReversed = paramBoolean;
      return this;
    }
    
    public Builder mappingTarget(AircraftStickMappingTarget paramAircraftStickMappingTarget)
    {
      this.target = paramAircraftStickMappingTarget;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\AircraftStickMapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */