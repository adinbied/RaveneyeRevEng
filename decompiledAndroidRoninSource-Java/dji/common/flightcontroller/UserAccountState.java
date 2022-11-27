package dji.common.flightcontroller;

public enum UserAccountState
{
  private int data;
  
  static
  {
    NOT_AUTHORIZED = new UserAccountState("NOT_AUTHORIZED", 1, 1);
    AUTHORIZED = new UserAccountState("AUTHORIZED", 2, 2);
    TOKEN_OUT_OF_DATE = new UserAccountState("TOKEN_OUT_OF_DATE", 3, 3);
    INVALID_TOKEN = new UserAccountState("INVALID_TOKEN", 4, 4);
    UserAccountState localUserAccountState = new UserAccountState("UNKNOWN", 5, 255);
    UNKNOWN = localUserAccountState;
    $VALUES = new UserAccountState[] { NOT_LOGGED_IN, NOT_AUTHORIZED, AUTHORIZED, TOKEN_OUT_OF_DATE, INVALID_TOKEN, localUserAccountState };
  }
  
  private UserAccountState(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static UserAccountState find(int paramInt)
  {
    UserAccountState localUserAccountState = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localUserAccountState;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\UserAccountState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */