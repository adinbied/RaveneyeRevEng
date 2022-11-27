package dji.common.flightcontroller;

public enum BatteryThresholdBehavior
{
  private int data;
  
  static
  {
    BatteryThresholdBehavior localBatteryThresholdBehavior = new BatteryThresholdBehavior("LAND_IMMEDIATELY", 2, 2);
    LAND_IMMEDIATELY = localBatteryThresholdBehavior;
    $VALUES = new BatteryThresholdBehavior[] { FLY_NORMALLY, GO_HOME, localBatteryThresholdBehavior };
  }
  
  private BatteryThresholdBehavior(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static BatteryThresholdBehavior find(int paramInt)
  {
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return null;
  }
  
  boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\BatteryThresholdBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */