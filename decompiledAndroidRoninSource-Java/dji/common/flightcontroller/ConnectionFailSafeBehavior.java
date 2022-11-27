package dji.common.flightcontroller;

public enum ConnectionFailSafeBehavior
{
  private int data;
  
  static
  {
    GO_HOME = new ConnectionFailSafeBehavior("GO_HOME", 2, 2);
    ConnectionFailSafeBehavior localConnectionFailSafeBehavior = new ConnectionFailSafeBehavior("UNKNOWN", 3, 255);
    UNKNOWN = localConnectionFailSafeBehavior;
    $VALUES = new ConnectionFailSafeBehavior[] { HOVER, LANDING, GO_HOME, localConnectionFailSafeBehavior };
  }
  
  private ConnectionFailSafeBehavior(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static ConnectionFailSafeBehavior find(int paramInt)
  {
    ConnectionFailSafeBehavior localConnectionFailSafeBehavior = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localConnectionFailSafeBehavior;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\ConnectionFailSafeBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */