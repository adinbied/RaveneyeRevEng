package com.huawei.hms.support.api.push;

public class PushException
  extends RuntimeException
{
  public static final String EXCEPITON_DEL_TAGS_FAILED = "delete tags failed";
  public static final String EXCEPITON_DEL_TAGS_LIST_NULL = "the key list of delete tags is null";
  public static final String EXCEPITON_DEL_TOKEN_FAILED = "delete token failed";
  public static final String EXCEPITON_GET_TAGS_FAILED = "get tags failed";
  public static final String EXCEPITON_NO_TAG_NEED_DEL = "no tag need to delete";
  public static final String EXCEPITON_SET_TAGS_FAILED = "set tags failed";
  public static final String EXCEPITON_TAGS_NULL = "tags is null";
  public static final String EXCEPITON_TOKEN_INVALID = "push token invalid";
  
  public PushException() {}
  
  public PushException(String paramString)
  {
    super(paramString);
  }
  
  public PushException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public PushException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\PushException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */