package com.huawei.hms.support.api.sns;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.sns.UnreadMsg;

public class UnreadMsgCountResult
  extends Result
{
  private UnreadMsg a;
  
  public UnreadMsg getUnreadMsg()
  {
    return this.a;
  }
  
  public void setUnreadMsg(UnreadMsg paramUnreadMsg)
  {
    this.a = paramUnreadMsg;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\sns\UnreadMsgCountResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */