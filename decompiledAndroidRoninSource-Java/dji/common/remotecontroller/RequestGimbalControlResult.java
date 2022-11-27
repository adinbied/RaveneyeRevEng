package dji.common.remotecontroller;

public enum RequestGimbalControlResult
{
  private int value;
  
  static
  {
    RequestGimbalControlResult localRequestGimbalControlResult = new RequestGimbalControlResult("UNKNOWN", 3, 4);
    UNKNOWN = localRequestGimbalControlResult;
    $VALUES = new RequestGimbalControlResult[] { ACCEPTED, REJECTED, TIMEOUT, localRequestGimbalControlResult };
  }
  
  private RequestGimbalControlResult(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static RequestGimbalControlResult find(int paramInt)
  {
    RequestGimbalControlResult localRequestGimbalControlResult = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localRequestGimbalControlResult;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\RequestGimbalControlResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */