package dji.pilot.usercenter.mode;

public enum AccountCenterSmsType
{
  public String id;
  
  static
  {
    AccountCenterSmsType localAccountCenterSmsType = new AccountCenterSmsType("RESET_PW", 2, 3);
    RESET_PW = localAccountCenterSmsType;
    $VALUES = new AccountCenterSmsType[] { BIND, REGISTER, localAccountCenterSmsType };
  }
  
  private AccountCenterSmsType(int paramInt)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramInt);
    ((StringBuilder)???).append("");
    this.id = ((StringBuilder)???).toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\mode\AccountCenterSmsType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */