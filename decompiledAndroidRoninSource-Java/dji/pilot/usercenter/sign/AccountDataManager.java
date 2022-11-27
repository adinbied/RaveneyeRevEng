package dji.pilot.usercenter.sign;

import dji.pilot.usercenter.mode.AccountCenterSmsType;

public class AccountDataManager
{
  static String areaCode = "86";
  static boolean isCanBack = true;
  private static boolean isCanSendAdEmail = true;
  static AccountCenterSmsType passwordViewType = AccountCenterSmsType.REGISTER;
  static String registerCaptcha;
  static String registerCaptchaKey;
  static String registerEmail;
  static String registerPassword;
  static String registerPhone;
  static String registerPhoneCode;
  static String registerSuccessEmail;
  private static DJIAccountSignActivity.SignUpType signUpType;
  
  public static String getAreaCode()
  {
    return areaCode;
  }
  
  public static AccountCenterSmsType getPasswordViewType()
  {
    return passwordViewType;
  }
  
  public static String getRegisterCaptcha()
  {
    return registerCaptcha;
  }
  
  public static String getRegisterCaptchaKey()
  {
    return registerCaptchaKey;
  }
  
  public static String getRegisterEmail()
  {
    return registerEmail;
  }
  
  public static String getRegisterPassword()
  {
    return registerPassword;
  }
  
  public static String getRegisterPhone()
  {
    return registerPhone;
  }
  
  public static String getRegisterPhoneCode()
  {
    return registerPhoneCode;
  }
  
  public static String getRegisterSuccessEmail()
  {
    return registerSuccessEmail;
  }
  
  public static DJIAccountSignActivity.SignUpType getSignUpType()
  {
    return signUpType;
  }
  
  public static boolean isCanBack()
  {
    return isCanBack;
  }
  
  public static boolean isCanSendAdEmail()
  {
    return isCanSendAdEmail;
  }
  
  public static void setIsCanBack(boolean paramBoolean)
  {
    isCanBack = paramBoolean;
  }
  
  public static void setIsCanSendAdEmail(boolean paramBoolean)
  {
    isCanSendAdEmail = paramBoolean;
  }
  
  public static void setPasswordViewType(AccountCenterSmsType paramAccountCenterSmsType)
  {
    passwordViewType = paramAccountCenterSmsType;
  }
  
  public static void setRegisterCaptcha(String paramString)
  {
    registerCaptcha = paramString;
  }
  
  public static void setRegisterCaptchaKey(String paramString)
  {
    registerCaptchaKey = paramString;
  }
  
  public static void setRegisterEmail(String paramString)
  {
    registerEmail = paramString;
  }
  
  public static void setRegisterPassword(String paramString)
  {
    registerPassword = paramString;
  }
  
  public static void setRegisterPhone(String paramString)
  {
    registerPhone = paramString;
  }
  
  public static void setRegisterPhoneCode(String paramString)
  {
    registerPhoneCode = paramString;
  }
  
  public static void setRegisterSuccessEmail(String paramString)
  {
    registerSuccessEmail = paramString;
  }
  
  static void setSignUpType(DJIAccountSignActivity.SignUpType paramSignUpType)
  {
    signUpType = paramSignUpType;
  }
  
  public static enum PasswordViewType
  {
    static
    {
      PasswordViewType localPasswordViewType = new PasswordViewType("RESET", 1);
      RESET = localPasswordViewType;
      $VALUES = new PasswordViewType[] { SIGN_UP, localPasswordViewType };
    }
    
    private PasswordViewType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\sign\AccountDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */