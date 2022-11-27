package com.huawei.hms.api;

public final class ConnectionResult
{
  public static final int API_UNAVAILABLE = 1000;
  public static final int BINDFAIL_RESOLUTION_REQUIRED = 6;
  public static final int CANCELED = 13;
  public static final int DEVELOPER_ERROR = 10;
  public static final int INTERNAL_ERROR = 8;
  public static final int INVALID_ACCOUNT = 5;
  public static final int LICENSE_CHECK_FAILED = 11;
  public static final int NETWORK_ERROR = 7;
  public static final int SERVICE_DISABLED = 3;
  public static final int SERVICE_INVALID = 9;
  public static final int SERVICE_MISSING = 1;
  public static final int SERVICE_MISSING_PERMISSION = 19;
  public static final int SERVICE_UNSUPPORTED = 21;
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  public static final int SIGN_IN_REQUIRED = 4;
  public static final int SUCCESS = 0;
  public static final int TIMEOUT = 14;
  private final int a;
  
  public ConnectionResult(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.a;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\api\ConnectionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */