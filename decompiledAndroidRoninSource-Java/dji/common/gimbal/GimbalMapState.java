package dji.common.gimbal;

public enum GimbalMapState
{
  private int value;
  
  static
  {
    PITCH = new GimbalMapState("PITCH", 1, 1);
    YAW = new GimbalMapState("YAW", 2, 2);
    GimbalMapState localGimbalMapState = new GimbalMapState("OTHER", 3, 255);
    OTHER = localGimbalMapState;
    $VALUES = new GimbalMapState[] { ROLL, PITCH, YAW, localGimbalMapState };
  }
  
  private GimbalMapState(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static GimbalMapState find(int paramInt)
  {
    GimbalMapState localGimbalMapState = OTHER;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localGimbalMapState;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\GimbalMapState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */