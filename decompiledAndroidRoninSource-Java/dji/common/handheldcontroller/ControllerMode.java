package dji.common.handheldcontroller;

public enum ControllerMode
{
  private final int value;
  
  static
  {
    ControllerMode localControllerMode = new ControllerMode("UNKNOWN", 2, 255);
    UNKNOWN = localControllerMode;
    $VALUES = new ControllerMode[] { ONE_AXIS, TWO_AXIS, localControllerMode };
  }
  
  private ControllerMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static ControllerMode find(int paramInt)
  {
    ControllerMode localControllerMode = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localControllerMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\handheldcontroller\ControllerMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */