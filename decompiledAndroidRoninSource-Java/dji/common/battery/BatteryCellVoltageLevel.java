package dji.common.battery;

public enum BatteryCellVoltageLevel
{
  private int data;
  
  static
  {
    BatteryCellVoltageLevel localBatteryCellVoltageLevel = new BatteryCellVoltageLevel("UNKNOWN", 4, 255);
    UNKNOWN = localBatteryCellVoltageLevel;
    $VALUES = new BatteryCellVoltageLevel[] { LEVEL_0, LEVEL_1, LEVEL_2, LEVEL_3, localBatteryCellVoltageLevel };
  }
  
  private BatteryCellVoltageLevel(int paramInt)
  {
    this.data = paramInt;
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\battery\BatteryCellVoltageLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */