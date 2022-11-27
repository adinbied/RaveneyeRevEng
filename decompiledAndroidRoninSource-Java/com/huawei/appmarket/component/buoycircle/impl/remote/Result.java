package com.huawei.appmarket.component.buoycircle.impl.remote;

public class Result
{
  public static final int RESULT_ERR_AUTH = 6;
  public static final int RESULT_ERR_BIND_HIGAME = 10;
  public static final int RESULT_ERR_CANCEL = 7;
  public static final int RESULT_ERR_CANCEL_LOGIN = 9;
  public static final int RESULT_ERR_COMM = 2;
  public static final int RESULT_ERR_NETWORK = 5;
  public static final int RESULT_ERR_NOT_INIT = 8;
  public static final int RESULT_ERR_PARAM = 4;
  public static final int RESULT_ERR_SIGN = 1;
  public static final int RESULT_ERR_UNSUPPORT = 3;
  public static final int RESULT_OK = 0;
  public String description;
  public int rtnCode;
  
  public Result(int paramInt)
  {
    this(paramInt, "");
  }
  
  public Result(int paramInt, String paramString)
  {
    this.rtnCode = paramInt;
    this.description = paramString;
  }
  
  public static int transferErrorCode(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 10)) {
      return paramInt;
    }
    return 2;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\remote\Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */