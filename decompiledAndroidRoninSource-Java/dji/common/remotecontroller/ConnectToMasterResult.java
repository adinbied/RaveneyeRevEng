package dji.common.remotecontroller;

public enum ConnectToMasterResult
{
  private int value;
  
  static
  {
    MAXIMUM_CAPACITY = new ConnectToMasterResult("MAXIMUM_CAPACITY", 3, 3);
    TIMEOUT = new ConnectToMasterResult("TIMEOUT", 4, 4);
    ConnectToMasterResult localConnectToMasterResult = new ConnectToMasterResult("UNKNOWN", 5, 5);
    UNKNOWN = localConnectToMasterResult;
    $VALUES = new ConnectToMasterResult[] { ACCEPTED, PASSWORD_ERROR, REJECTED, MAXIMUM_CAPACITY, TIMEOUT, localConnectToMasterResult };
  }
  
  private ConnectToMasterResult(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static ConnectToMasterResult find(int paramInt)
  {
    ConnectToMasterResult localConnectToMasterResult = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localConnectToMasterResult;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\ConnectToMasterResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */