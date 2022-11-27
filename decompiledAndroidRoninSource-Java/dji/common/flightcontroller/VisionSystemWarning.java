package dji.common.flightcontroller;

public enum VisionSystemWarning
{
  private int value;
  
  static
  {
    DANGEROUS = new VisionSystemWarning("DANGEROUS", 1, 3);
    INVALID = new VisionSystemWarning("INVALID", 2, 15);
    VisionSystemWarning localVisionSystemWarning = new VisionSystemWarning("UNKNOWN", 3, 255);
    UNKNOWN = localVisionSystemWarning;
    $VALUES = new VisionSystemWarning[] { SAFE, DANGEROUS, INVALID, localVisionSystemWarning };
  }
  
  private VisionSystemWarning(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static VisionSystemWarning find(int paramInt)
  {
    VisionSystemWarning localVisionSystemWarning = UNKNOWN;
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3)
      {
        if (paramInt != 15) {
          return localVisionSystemWarning;
        }
        return INVALID;
      }
      return DANGEROUS;
    }
    return SAFE;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\VisionSystemWarning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */