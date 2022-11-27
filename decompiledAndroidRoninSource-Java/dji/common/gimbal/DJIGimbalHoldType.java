package dji.common.gimbal;

public enum DJIGimbalHoldType
{
  private final int value;
  
  static
  {
    Car = new DJIGimbalHoldType("Car", 1, 2);
    Machine = new DJIGimbalHoldType("Machine", 2, 3);
    DJIGimbalHoldType localDJIGimbalHoldType = new DJIGimbalHoldType("Tripod", 3, 4);
    Tripod = localDJIGimbalHoldType;
    $VALUES = new DJIGimbalHoldType[] { Hand, Car, Machine, localDJIGimbalHoldType };
  }
  
  private DJIGimbalHoldType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\DJIGimbalHoldType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */