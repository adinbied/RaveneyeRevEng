package dji.pilot.usercenter.mode;

public enum AccountCenterResCode
{
  public int desId = -1;
  int id = -1;
  
  static
  {
    PARAM_VALID = new AccountCenterResCode("PARAM_VALID", 1, 200);
    SERVICE_ERROR = new AccountCenterResCode("SERVICE_ERROR", 2, 301);
    PW_ERROR = new AccountCenterResCode("PW_ERROR", 3, 305, 2131756244);
    USER_NOT_EXIST = new AccountCenterResCode("USER_NOT_EXIST", 4, 502, 2131755101);
    SMS_MAX_TIMES = new AccountCenterResCode("SMS_MAX_TIMES", 5, 507, 2131756259);
    SMS_MAX_DAY = new AccountCenterResCode("SMS_MAX_DAY", 6, 508, 2131756259);
    PHONE_USED = new AccountCenterResCode("PHONE_USED", 7, 510, 2131756238);
    PHONE_FORMAT_ERROR = new AccountCenterResCode("PHONE_FORMAT_ERROR", 8, 512, 2131756234);
    PHONE_CODE_ERROR = new AccountCenterResCode("PHONE_CODE_ERROR", 9, 513, 2131756239);
    PW_WEAK = new AccountCenterResCode("PW_WEAK", 10, 522, 2131756246);
    CAPTCHA_ERROR = new AccountCenterResCode("CAPTCHA_ERROR", 11, 524, 2131756274);
    NEED_CAPTCHA = new AccountCenterResCode("NEED_CAPTCHA", 12, 526, 2131756228);
    AccountCenterResCode localAccountCenterResCode = new AccountCenterResCode("UNKNOWN", 13, Integer.MAX_VALUE, 2131756250);
    UNKNOWN = localAccountCenterResCode;
    $VALUES = new AccountCenterResCode[] { SUCCESS, PARAM_VALID, SERVICE_ERROR, PW_ERROR, USER_NOT_EXIST, SMS_MAX_TIMES, SMS_MAX_DAY, PHONE_USED, PHONE_FORMAT_ERROR, PHONE_CODE_ERROR, PW_WEAK, CAPTCHA_ERROR, NEED_CAPTCHA, localAccountCenterResCode };
  }
  
  private AccountCenterResCode(int paramInt)
  {
    this.id = paramInt;
  }
  
  private AccountCenterResCode(int paramInt1, int paramInt2)
  {
    this.id = paramInt1;
    this.desId = paramInt2;
  }
  
  public static AccountCenterResCode findById(int paramInt)
  {
    AccountCenterResCode localAccountCenterResCode1 = UNKNOWN;
    AccountCenterResCode[] arrayOfAccountCenterResCode = values();
    int j = arrayOfAccountCenterResCode.length;
    int i = 0;
    while (i < j)
    {
      AccountCenterResCode localAccountCenterResCode2 = arrayOfAccountCenterResCode[i];
      if (localAccountCenterResCode2.id == paramInt) {
        return localAccountCenterResCode2;
      }
      i += 1;
    }
    return localAccountCenterResCode1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\mode\AccountCenterResCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */