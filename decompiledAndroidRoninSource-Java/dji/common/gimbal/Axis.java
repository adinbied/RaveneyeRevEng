package dji.common.gimbal;

public enum Axis
{
  private int value;
  
  static
  {
    Axis localAxis = new Axis("ROLL", 2, 2);
    ROLL = localAxis;
    $VALUES = new Axis[] { PITCH, YAW, localAxis };
  }
  
  private Axis(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static Axis find(int paramInt)
  {
    Axis localAxis = PITCH;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localAxis;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\Axis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */