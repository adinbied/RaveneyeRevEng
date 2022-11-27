package dji.common.mission.tapfly;

public enum TapFlyMode
{
  private final int value;
  
  static
  {
    BACKWARD = new TapFlyMode("BACKWARD", 1, 1);
    FREE = new TapFlyMode("FREE", 2, 2);
    TapFlyMode localTapFlyMode = new TapFlyMode("UNKNOWN", 3, 255);
    UNKNOWN = localTapFlyMode;
    $VALUES = new TapFlyMode[] { FORWARD, BACKWARD, FREE, localTapFlyMode };
  }
  
  private TapFlyMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static TapFlyMode find(int paramInt)
  {
    TapFlyMode localTapFlyMode = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localTapFlyMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\tapfly\TapFlyMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */