package dji.common.airlink;

public enum SDRInterferedTerminal
{
  private int value;
  
  static
  {
    SDRInterferedTerminal localSDRInterferedTerminal = new SDRInterferedTerminal("Non", 2, 255);
    Non = localSDRInterferedTerminal;
    $VALUES = new SDRInterferedTerminal[] { Ground, UAV, localSDRInterferedTerminal };
  }
  
  private SDRInterferedTerminal(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static SDRInterferedTerminal find(int paramInt)
  {
    SDRInterferedTerminal localSDRInterferedTerminal = Non;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localSDRInterferedTerminal;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\SDRInterferedTerminal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */