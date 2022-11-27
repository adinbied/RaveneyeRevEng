package dji.common.gimbal;

public enum DJIGimbalRCControlType
{
  private final int value;
  
  static
  {
    High = new DJIGimbalRCControlType("High", 3, 3);
    DJIGimbalRCControlType localDJIGimbalRCControlType = new DJIGimbalRCControlType("Unknown", 4, 255);
    Unknown = localDJIGimbalRCControlType;
    $VALUES = new DJIGimbalRCControlType[] { Custom, Low, Middle, High, localDJIGimbalRCControlType };
  }
  
  private DJIGimbalRCControlType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\DJIGimbalRCControlType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */