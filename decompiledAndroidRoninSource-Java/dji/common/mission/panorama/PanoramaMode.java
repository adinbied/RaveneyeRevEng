package dji.common.mission.panorama;

public enum PanoramaMode
{
  private int value;
  
  static
  {
    PanoramaMode localPanoramaMode = new PanoramaMode("UNKNOWN", 2, 255);
    UNKNOWN = localPanoramaMode;
    $VALUES = new PanoramaMode[] { FULL_CIRCLE, HALF_CIRCLE, localPanoramaMode };
  }
  
  private PanoramaMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static PanoramaMode find(int paramInt)
  {
    PanoramaMode localPanoramaMode = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i].value == paramInt) {
        return values()[i];
      }
      i += 1;
    }
    return localPanoramaMode;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\panorama\PanoramaMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */