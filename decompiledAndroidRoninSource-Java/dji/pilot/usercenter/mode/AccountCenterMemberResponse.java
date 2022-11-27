package dji.pilot.usercenter.mode;

import com.google.gson.Gson;

public class AccountCenterMemberResponse
  extends AccountCenterBaseResponse
{
  public Data data;
  
  public static AccountCenterBaseResponse parse(String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = (AccountCenterBaseResponse)new Gson().fromJson(paramString, AccountCenterMemberResponse.class);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    paramString = new AccountCenterBaseResponse();
    paramString.code = Integer.MAX_VALUE;
    return paramString;
  }
  
  public String getToken()
  {
    return null;
  }
  
  public boolean isSuccess()
  {
    return this.code == 0;
  }
  
  public class Data
  {
    public static final String VIP_LEVEL_00 = "00";
    public static final String VIP_LEVEL_01 = "01";
    public static final String VIP_LEVEL_02 = "02";
    public String active;
    public String area_code;
    public String cookie_key;
    public String cookie_name;
    public String email;
    public String inner_email;
    public String nick_name;
    public String register_phone;
    public String subscription;
    public String token;
    public String user_id;
    public String validity;
    public String vipLevel;
    
    public Data() {}
    
    public String toString()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\mode\AccountCenterMemberResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */