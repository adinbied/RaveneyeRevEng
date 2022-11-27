package dji.common.remotecontroller;

public enum GimbalAxis
{
  private int value;
  
  static
  {
    GimbalAxis localGimbalAxis = new GimbalAxis("YAW", 2, 2);
    YAW = localGimbalAxis;
    $VALUES = new GimbalAxis[] { PITCH, ROLL, localGimbalAxis };
  }
  
  private GimbalAxis(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static GimbalAxis find(int paramInt)
  {
    GimbalAxis localGimbalAxis = PITCH;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localGimbalAxis;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\GimbalAxis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */