package dji.common.gimbal;

public enum RotationMode
{
  static
  {
    ABSOLUTE_ANGLE = new RotationMode("ABSOLUTE_ANGLE", 1);
    RotationMode localRotationMode = new RotationMode("SPEED", 2);
    SPEED = localRotationMode;
    $VALUES = new RotationMode[] { RELATIVE_ANGLE, ABSOLUTE_ANGLE, localRotationMode };
  }
  
  private RotationMode() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\RotationMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */