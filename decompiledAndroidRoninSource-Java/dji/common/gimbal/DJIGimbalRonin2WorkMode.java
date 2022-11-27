package dji.common.gimbal;

public enum DJIGimbalRonin2WorkMode
{
  private final int value;
  
  static
  {
    Flower = new DJIGimbalRonin2WorkMode("Flower", 1, 1);
    Fpv = new DJIGimbalRonin2WorkMode("Fpv", 2, 2);
    DJIGimbalRonin2WorkMode localDJIGimbalRonin2WorkMode = new DJIGimbalRonin2WorkMode("Center", 3, 3);
    Center = localDJIGimbalRonin2WorkMode;
    $VALUES = new DJIGimbalRonin2WorkMode[] { Free, Flower, Fpv, localDJIGimbalRonin2WorkMode };
  }
  
  private DJIGimbalRonin2WorkMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\DJIGimbalRonin2WorkMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */