package dji.common.flightcontroller;

public enum GPIOWorkModeOnBoard
{
  private int data;
  
  static
  {
    PULL_DOWN_INPUT = new GPIOWorkModeOnBoard("PULL_DOWN_INPUT", 2, 2);
    PUSH_PULL_INPUT = new GPIOWorkModeOnBoard("PUSH_PULL_INPUT", 3, 3);
    GPIOWorkModeOnBoard localGPIOWorkModeOnBoard = new GPIOWorkModeOnBoard("OTHER", 4, 255);
    OTHER = localGPIOWorkModeOnBoard;
    $VALUES = new GPIOWorkModeOnBoard[] { FLOAT_INPUT, PULL_UP_INPUT, PULL_DOWN_INPUT, PUSH_PULL_INPUT, localGPIOWorkModeOnBoard };
  }
  
  private GPIOWorkModeOnBoard(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static GPIOWorkModeOnBoard find(int paramInt)
  {
    GPIOWorkModeOnBoard localGPIOWorkModeOnBoard = OTHER;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localGPIOWorkModeOnBoard;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\GPIOWorkModeOnBoard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */