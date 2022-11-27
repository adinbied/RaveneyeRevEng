package dji.common.remotecontroller;

public enum RCMode
{
  private int value;
  
  static
  {
    MasterSub = new RCMode("MasterSub", 2, 2);
    SlaveSub = new RCMode("SlaveSub", 3, 3);
    NORMAL = new RCMode("NORMAL", 4, 10);
    RCMode localRCMode = new RCMode("UNKNOWN", 5, 15);
    UNKNOWN = localRCMode;
    $VALUES = new RCMode[] { MASTER, SLAVE, MasterSub, SlaveSub, NORMAL, localRCMode };
  }
  
  private RCMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static RCMode find(int paramInt)
  {
    RCMode localRCMode = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localRCMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\RCMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */