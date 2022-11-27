package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class GetIMStatusResp
  implements IMessageEntity
{
  @a
  private int onlineStatus;
  
  public int getOnlineStatus()
  {
    return this.onlineStatus;
  }
  
  public void setOnlineStatus(int paramInt)
  {
    this.onlineStatus = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\internal\GetIMStatusResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */