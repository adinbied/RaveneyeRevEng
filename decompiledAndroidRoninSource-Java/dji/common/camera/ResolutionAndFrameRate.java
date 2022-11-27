package dji.common.camera;

public class ResolutionAndFrameRate
  implements Comparable<ResolutionAndFrameRate>
{
  private SettingsDefinitions.VideoFrameRate frameRate;
  private SettingsDefinitions.VideoResolution resolution;
  
  public ResolutionAndFrameRate() {}
  
  public ResolutionAndFrameRate(SettingsDefinitions.VideoResolution paramVideoResolution, SettingsDefinitions.VideoFrameRate paramVideoFrameRate)
  {
    this.resolution = paramVideoResolution;
    this.frameRate = paramVideoFrameRate;
  }
  
  public int compareTo(ResolutionAndFrameRate paramResolutionAndFrameRate)
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public SettingsDefinitions.VideoFrameRate getFrameRate()
  {
    return this.frameRate;
  }
  
  public SettingsDefinitions.VideoResolution getResolution()
  {
    return this.resolution;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public void setFrameRate(SettingsDefinitions.VideoFrameRate paramVideoFrameRate)
  {
    this.frameRate = paramVideoFrameRate;
  }
  
  public void setResolution(SettingsDefinitions.VideoResolution paramVideoResolution)
  {
    this.resolution = paramVideoResolution;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\ResolutionAndFrameRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */