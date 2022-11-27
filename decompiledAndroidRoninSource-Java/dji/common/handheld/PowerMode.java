package dji.common.handheld;

public enum PowerMode
{
  private int value;
  
  static
  {
    OFF = new PowerMode("OFF", 2, 2);
    PowerMode localPowerMode = new PowerMode("UNKNOWN", 3, 255);
    UNKNOWN = localPowerMode;
    $VALUES = new PowerMode[] { ON, SLEEPING, OFF, localPowerMode };
  }
  
  private PowerMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static PowerMode find(int paramInt)
  {
    PowerMode localPowerMode = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localPowerMode;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public int value()
  {
    return this.value;
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(PowerMode paramPowerMode);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\handheld\PowerMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */