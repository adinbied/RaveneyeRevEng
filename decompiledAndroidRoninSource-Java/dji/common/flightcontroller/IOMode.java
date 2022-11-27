package dji.common.flightcontroller;

public enum IOMode
{
  static
  {
    IOMode localIOMode = new IOMode("OTHER", 2);
    OTHER = localIOMode;
    $VALUES = new IOMode[] { GPIO, PWM, localIOMode };
  }
  
  private IOMode() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\IOMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */