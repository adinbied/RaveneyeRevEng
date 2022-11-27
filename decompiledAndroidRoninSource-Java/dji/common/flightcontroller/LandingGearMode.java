package dji.common.flightcontroller;

public enum LandingGearMode
{
  private int data;
  
  static
  {
    AUTO = new LandingGearMode("AUTO", 1, 1);
    MANUAL = new LandingGearMode("MANUAL", 2, 2);
    LandingGearMode localLandingGearMode = new LandingGearMode("UNKNOWN", 3, 3);
    UNKNOWN = localLandingGearMode;
    $VALUES = new LandingGearMode[] { TRANSPORT, AUTO, MANUAL, localLandingGearMode };
  }
  
  private LandingGearMode(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static LandingGearMode find(int paramInt)
  {
    LandingGearMode localLandingGearMode = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localLandingGearMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\LandingGearMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */