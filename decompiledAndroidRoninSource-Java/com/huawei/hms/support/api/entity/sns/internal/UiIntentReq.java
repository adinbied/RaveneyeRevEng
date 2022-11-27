package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class UiIntentReq
  implements IMessageEntity
{
  @a
  private long param;
  @a
  private int type;
  
  public long getParam()
  {
    return this.param;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setParam(long paramLong)
  {
    this.param = paramLong;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\internal\UiIntentReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */