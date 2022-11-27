package dji.pilot.usercenter;

public abstract interface IMemberProtocol
  extends IProtocol
{
  public static final int CMDID_ACCOUNT_CENTER_EMAIL_LOGIN = 262224;
  public static final int CMDID_ACCOUNT_CENTER_EMAIL_REGISTER = 262208;
  public static final int CMDID_ACCOUNT_CENTER_PHONE_LOGIN = 262192;
  public static final int CMDID_ACCOUNT_CENTER_PHONE_REGISTER = 262176;
  public static final int CMDID_ACCOUNT_EMAIL_VALID = 196704;
  public static final int CMDID_ACCOUNT_FORGOT_PSW = 196720;
  public static final int CMDID_ACCOUNT_GET_PROFILES = 196656;
  public static final int CMDID_ACCOUNT_LOGOUT = 196640;
  public static final int CMDID_ACCOUNT_SET_PROFILES = 196672;
  public static final int CMDID_ACCOUNT_SIGNIN = 196608;
  public static final int CMDID_ACCOUNT_SIGNUP = 196624;
  public static final int CMDID_ACCOUNT_UPDATE_AVATAR = 196688;
  public static final int CMDID_PHONE_GET_CODE = 262144;
  public static final int CMDID_PHONE_VER_PHONE_CODE = 262160;
  public static final int STATUS_CODE_FORGOT_EMAIL_ERROR = 107;
  public static final int STATUS_CODE_NEED_VERIFY_CODE = 526;
  public static final int STATUS_CODE_NETWORK_ERROR = -1;
  public static final int STATUS_CODE_SIGNIN_ACCOUNT_FROZEN_AUTO = 521;
  public static final int STATUS_CODE_SIGNIN_ACCOUNT_FROZEN_MANUAL = 523;
  public static final int STATUS_CODE_SIGNIN_EMAIL_ERROR = 107;
  public static final int STATUS_CODE_SIGNIN_LEAK_PARAM = 200;
  public static final int STATUS_CODE_SIGNIN_PWD_ERROR = 305;
  public static final int STATUS_CODE_SIGNIN_PWD_ERROR2 = 500;
  public static final int STATUS_CODE_SIGNIN_USER_NOT_FOUND = 502;
  public static final int STATUS_CODE_SIGNIN_VERIFY_ERROR = 300;
  public static final int STATUS_CODE_SIGNIN_VERIFY_ERROR_2 = 524;
  public static final int STATUS_CODE_SIGNUP_EMAIL_ERROR = 200;
  public static final int STATUS_CODE_SIGNUP_EMAIL_EXIST = 306;
  public static final int STATUS_CODE_SIGNUP_PWD_NOT_MATCH_RULE = 522;
  public static final int STATUS_CODE_TOEKN_INVALID = 315;
  public static final String STRING_EMAIL = "email";
  public static final String STRING_KEY = "key";
  public static final String STRING_RUCAPTCHA = "_rucaptcha";
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\IMemberProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */