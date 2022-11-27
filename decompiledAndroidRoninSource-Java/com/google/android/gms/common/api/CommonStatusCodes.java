package com.google.android.gms.common.api;

public class CommonStatusCodes
{
  public static final int API_NOT_CONNECTED = 17;
  public static final int CANCELED = 16;
  public static final int DEVELOPER_ERROR = 10;
  public static final int ERROR = 13;
  public static final int INTERNAL_ERROR = 8;
  public static final int INTERRUPTED = 14;
  public static final int INVALID_ACCOUNT = 5;
  public static final int NETWORK_ERROR = 7;
  public static final int RESOLUTION_REQUIRED = 6;
  @Deprecated
  public static final int SERVICE_DISABLED = 3;
  @Deprecated
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  public static final int SIGN_IN_REQUIRED = 4;
  public static final int SUCCESS = 0;
  public static final int SUCCESS_CACHE = -1;
  public static final int TIMEOUT = 15;
  
  public static String getStatusCodeString(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 9: 
    case 11: 
    case 12: 
    default: 
      StringBuilder localStringBuilder = new StringBuilder(32);
      localStringBuilder.append("unknown status code: ");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    case 18: 
      return "DEAD_CLIENT";
    case 17: 
      return "API_NOT_CONNECTED";
    case 16: 
      return "CANCELED";
    case 15: 
      return "TIMEOUT";
    case 14: 
      return "INTERRUPTED";
    case 13: 
      return "ERROR";
    case 10: 
      return "DEVELOPER_ERROR";
    case 8: 
      return "INTERNAL_ERROR";
    case 7: 
      return "NETWORK_ERROR";
    case 6: 
      return "RESOLUTION_REQUIRED";
    case 5: 
      return "INVALID_ACCOUNT";
    case 4: 
      return "SIGN_IN_REQUIRED";
    case 3: 
      return "SERVICE_DISABLED";
    case 2: 
      return "SERVICE_VERSION_UPDATE_REQUIRED";
    case 0: 
      return "SUCCESS";
    }
    return "SUCCESS_CACHE";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\CommonStatusCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */