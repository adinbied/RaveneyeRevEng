package dji.common.flightcontroller.virtualstick;

public enum YawControlMode
{
  private int data;
  
  static
  {
    YawControlMode localYawControlMode = new YawControlMode("ANGULAR_VELOCITY", 1, 1);
    ANGULAR_VELOCITY = localYawControlMode;
    $VALUES = new YawControlMode[] { ANGLE, localYawControlMode };
  }
  
  private YawControlMode(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static YawControlMode find(int paramInt)
  {
    YawControlMode localYawControlMode = ANGLE;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localYawControlMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\virtualstick\YawControlMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */