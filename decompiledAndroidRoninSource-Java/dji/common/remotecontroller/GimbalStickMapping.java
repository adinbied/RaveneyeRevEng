package dji.common.remotecontroller;

public class GimbalStickMapping
{
  private boolean isReversed;
  private GimbalStickMappingTarget mappingTarget;
  
  private GimbalStickMapping(Builder paramBuilder)
  {
    this.mappingTarget = paramBuilder.target;
    this.isReversed = paramBuilder.isReversed;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public GimbalStickMappingTarget getMappingTarget()
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
    private GimbalStickMappingTarget target;
    
    public GimbalStickMapping build()
    {
      return new GimbalStickMapping(this, null);
    }
    
    public Builder isReversed(boolean paramBoolean)
    {
      this.isReversed = paramBoolean;
      return this;
    }
    
    public Builder mappingTarget(GimbalStickMappingTarget paramGimbalStickMappingTarget)
    {
      this.target = paramGimbalStickMappingTarget;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\GimbalStickMapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */