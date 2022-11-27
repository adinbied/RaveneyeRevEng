package dji.common.remotecontroller;

public enum ChargeMobileMode
{
  private int value;
  
  static
  {
    ALWAYS = new ChargeMobileMode("ALWAYS", 1, 1);
    INTELLIGENT = new ChargeMobileMode("INTELLIGENT", 2, 2);
    ChargeMobileMode localChargeMobileMode = new ChargeMobileMode("Unknown", 3, 3);
    Unknown = localChargeMobileMode;
    $VALUES = new ChargeMobileMode[] { NEVER, ALWAYS, INTELLIGENT, localChargeMobileMode };
  }
  
  private ChargeMobileMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static ChargeMobileMode find(int paramInt)
  {
    ChargeMobileMode localChargeMobileMode = Unknown;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localChargeMobileMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\ChargeMobileMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */