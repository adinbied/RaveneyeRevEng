package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class UserSearchResp
  implements IMessageEntity
{
  @a
  private long userId;
  
  public long getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(long paramLong)
  {
    this.userId = paramLong;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\internal\UserSearchResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */