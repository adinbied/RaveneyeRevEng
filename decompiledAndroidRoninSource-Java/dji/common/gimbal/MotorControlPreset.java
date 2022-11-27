package dji.common.gimbal;

public enum MotorControlPreset
{
  static
  {
    DSLR = new MotorControlPreset("DSLR", 1);
    MotorControlPreset localMotorControlPreset = new MotorControlPreset("MIRRORLESS", 2);
    MIRRORLESS = localMotorControlPreset;
    $VALUES = new MotorControlPreset[] { RED, DSLR, localMotorControlPreset };
  }
  
  private MotorControlPreset() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\MotorControlPreset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */