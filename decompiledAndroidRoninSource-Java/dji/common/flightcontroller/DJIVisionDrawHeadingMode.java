package dji.common.flightcontroller;

public enum DJIVisionDrawHeadingMode
{
  private int value;
  
  static
  {
    FORWARD = new DJIVisionDrawHeadingMode("FORWARD", 1, 1);
    DJIVisionDrawHeadingMode localDJIVisionDrawHeadingMode = new DJIVisionDrawHeadingMode("Unknown", 2, 255);
    Unknown = localDJIVisionDrawHeadingMode;
    $VALUES = new DJIVisionDrawHeadingMode[] { FREE, FORWARD, localDJIVisionDrawHeadingMode };
  }
  
  private DJIVisionDrawHeadingMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static DJIVisionDrawHeadingMode find(int paramInt)
  {
    DJIVisionDrawHeadingMode localDJIVisionDrawHeadingMode = Unknown;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localDJIVisionDrawHeadingMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\DJIVisionDrawHeadingMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */