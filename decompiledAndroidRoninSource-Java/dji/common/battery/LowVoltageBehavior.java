package dji.common.battery;

public enum LowVoltageBehavior
{
  private int data;
  
  static
  {
    LowVoltageBehavior localLowVoltageBehavior = new LowVoltageBehavior("UNKNOWN", 3, 255);
    UNKNOWN = localLowVoltageBehavior;
    $VALUES = new LowVoltageBehavior[] { FLASH_LED, GO_HOME, LAND, localLowVoltageBehavior };
  }
  
  private LowVoltageBehavior(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static LowVoltageBehavior find(int paramInt)
  {
    LowVoltageBehavior localLowVoltageBehavior = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localLowVoltageBehavior;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\battery\LowVoltageBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */