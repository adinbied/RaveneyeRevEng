package dji.common.flightcontroller.virtualstick;

public enum VerticalControlMode
{
  private int data;
  
  static
  {
    VerticalControlMode localVerticalControlMode = new VerticalControlMode("POSITION", 1, 1);
    POSITION = localVerticalControlMode;
    $VALUES = new VerticalControlMode[] { VELOCITY, localVerticalControlMode };
  }
  
  private VerticalControlMode(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static VerticalControlMode find(int paramInt)
  {
    VerticalControlMode localVerticalControlMode = VELOCITY;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localVerticalControlMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\virtualstick\VerticalControlMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */