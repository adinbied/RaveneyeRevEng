package dji.common.gimbal;

public enum GimbalMode
{
  private int value;
  
  static
  {
    FPV = new GimbalMode("FPV", 1, 1);
    YAW_FOLLOW = new GimbalMode("YAW_FOLLOW", 2, 2);
    GimbalMode localGimbalMode = new GimbalMode("UNKNOWN", 3, 255);
    UNKNOWN = localGimbalMode;
    $VALUES = new GimbalMode[] { FREE, FPV, YAW_FOLLOW, localGimbalMode };
  }
  
  private GimbalMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static GimbalMode find(int paramInt)
  {
    GimbalMode localGimbalMode = FREE;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localGimbalMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\GimbalMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */