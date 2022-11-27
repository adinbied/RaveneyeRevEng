package com.huawei.hms.support.api.sns;

import com.huawei.hms.support.api.client.Result;

public class UserSearchResult
  extends Result
{
  private long a;
  
  public long getUserId()
  {
    return this.a;
  }
  
  public void setUserId(long paramLong)
  {
    this.a = paramLong;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\sns\UserSearchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */