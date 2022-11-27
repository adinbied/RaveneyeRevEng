package dji.common.flightcontroller;

public enum GPSSignalLevel
{
  private int data;
  
  static
  {
    GPSSignalLevel localGPSSignalLevel = new GPSSignalLevel("NONE", 6, 255);
    NONE = localGPSSignalLevel;
    $VALUES = new GPSSignalLevel[] { LEVEL_0, LEVEL_1, LEVEL_2, LEVEL_3, LEVEL_4, LEVEL_5, localGPSSignalLevel };
  }
  
  private GPSSignalLevel(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static GPSSignalLevel find(int paramInt)
  {
    GPSSignalLevel localGPSSignalLevel = NONE;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localGPSSignalLevel;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\GPSSignalLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */