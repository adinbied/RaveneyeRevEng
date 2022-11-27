package dji.common.flightcontroller;

public enum VisionLandingProtectionState
{
  private int data;
  
  static
  {
    ANALYZING = new VisionLandingProtectionState("ANALYZING", 1, 1);
    ANALYSIS_FAILED = new VisionLandingProtectionState("ANALYSIS_FAILED", 2, 2);
    SAFE_TO_LAND = new VisionLandingProtectionState("SAFE_TO_LAND", 3, 3);
    NOT_SAFE_TO_LAND = new VisionLandingProtectionState("NOT_SAFE_TO_LAND", 4, 4);
    VisionLandingProtectionState localVisionLandingProtectionState = new VisionLandingProtectionState("UNKNOWN", 5, 255);
    UNKNOWN = localVisionLandingProtectionState;
    $VALUES = new VisionLandingProtectionState[] { NONE, ANALYZING, ANALYSIS_FAILED, SAFE_TO_LAND, NOT_SAFE_TO_LAND, localVisionLandingProtectionState };
  }
  
  private VisionLandingProtectionState(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static VisionLandingProtectionState find(int paramInt)
  {
    VisionLandingProtectionState localVisionLandingProtectionState = UNKNOWN;
    if (paramInt != -10)
    {
      if (paramInt != 10) {}
      switch (paramInt)
      {
      default: 
        return localVisionLandingProtectionState;
      case 3: 
      case 4: 
        return NOT_SAFE_TO_LAND;
      case 2: 
        return SAFE_TO_LAND;
      case 0: 
        return NONE;
      case 1: 
        return ANALYZING;
      }
    }
    return ANALYSIS_FAILED;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\VisionLandingProtectionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */