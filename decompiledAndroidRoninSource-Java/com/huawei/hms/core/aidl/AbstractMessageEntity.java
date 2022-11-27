package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.client.Status;

public class AbstractMessageEntity
  implements IMessageEntity
{
  @a
  private Status commonStatus;
  
  public Status getCommonStatus()
  {
    return this.commonStatus;
  }
  
  public void setCommonStatus(Status paramStatus)
  {
    this.commonStatus = paramStatus;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\core\aidl\AbstractMessageEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */