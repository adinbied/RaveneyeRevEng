package dji.common.flightcontroller;

public enum ControlMode
{
  private int data;
  
  static
  {
    ControlMode localControlMode = new ControlMode("UNKNOWN", 2, 255);
    UNKNOWN = localControlMode;
    $VALUES = new ControlMode[] { MANUAL, SMART, localControlMode };
  }
  
  private ControlMode(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static ControlMode find(int paramInt)
  {
    ControlMode localControlMode = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localControlMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\ControlMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */