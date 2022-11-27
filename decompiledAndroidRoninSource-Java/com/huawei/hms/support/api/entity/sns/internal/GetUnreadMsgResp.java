package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.entity.sns.UnreadMsg;

public class GetUnreadMsgResp
  implements IMessageEntity
{
  @a
  private UnreadMsg unreadMsg;
  
  public UnreadMsg getUnreadMsg()
  {
    return this.unreadMsg;
  }
  
  public void setUnreadMsg(UnreadMsg paramUnreadMsg)
  {
    this.unreadMsg = paramUnreadMsg;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\internal\GetUnreadMsgResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */