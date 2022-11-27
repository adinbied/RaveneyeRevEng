package dji.common.camera;

public enum SSDCapacity
{
  private int value;
  
  static
  {
    CAPACITY_1_TB = new SSDCapacity("CAPACITY_1_TB", 2, 2);
    SSDCapacity localSSDCapacity = new SSDCapacity("UNKNOWN", 3, 255);
    UNKNOWN = localSSDCapacity;
    $VALUES = new SSDCapacity[] { CAPACITY_256_GB, CAPACITY_512_GB, CAPACITY_1_TB, localSSDCapacity };
  }
  
  private SSDCapacity(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static SSDCapacity find(int paramInt)
  {
    SSDCapacity localSSDCapacity = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localSSDCapacity;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\SSDCapacity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */