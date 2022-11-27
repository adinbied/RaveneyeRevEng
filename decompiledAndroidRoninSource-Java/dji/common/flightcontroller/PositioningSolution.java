package dji.common.flightcontroller;

public enum PositioningSolution
{
  private int data;
  
  static
  {
    FLOAT = new PositioningSolution("FLOAT", 2, 34);
    PositioningSolution localPositioningSolution = new PositioningSolution("FIXED_POINT", 3, 50);
    FIXED_POINT = localPositioningSolution;
    $VALUES = new PositioningSolution[] { NONE, SINGLE_POINT, FLOAT, localPositioningSolution };
  }
  
  private PositioningSolution(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static PositioningSolution find(int paramInt)
  {
    PositioningSolution localPositioningSolution = NONE;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localPositioningSolution;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\PositioningSolution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */