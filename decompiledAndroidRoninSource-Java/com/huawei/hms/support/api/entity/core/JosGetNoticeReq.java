package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.a.a;

public class JosGetNoticeReq
  extends JosBaseReq
{
  public static final int NOTICE_TYPE_CONN = 0;
  public static final int NOTICE_TYPE_SIGN = 1;
  @a
  private int noticeType;
  
  private static <T> T get(T paramT)
  {
    return paramT;
  }
  
  public int getNoticeType()
  {
    return 0;
  }
  
  public void setNoticeType(int paramInt)
  {
    this.noticeType = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\core\JosGetNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */