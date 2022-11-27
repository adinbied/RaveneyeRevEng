package dji.common.gimbal;

public enum DJIGimbalRonin2AxisMode
{
  int value;
  
  static
  {
    Roll360 = new DJIGimbalRonin2AxisMode("Roll360", 2, 2);
    DJIGimbalRonin2AxisMode localDJIGimbalRonin2AxisMode = new DJIGimbalRonin2AxisMode("ThreeDRoll360", 3, 3);
    ThreeDRoll360 = localDJIGimbalRonin2AxisMode;
    $VALUES = new DJIGimbalRonin2AxisMode[] { ThreeAxis, TwoAxis, Roll360, localDJIGimbalRonin2AxisMode };
  }
  
  private DJIGimbalRonin2AxisMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\DJIGimbalRonin2AxisMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */