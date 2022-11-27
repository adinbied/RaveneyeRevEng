package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public abstract class AbstractResp
  implements IMessageEntity
{
  @a
  private String errorReason;
  @a
  private int rtnCode = 0;
  
  public String getErrorReason()
  {
    return this.errorReason;
  }
  
  public int getRtnCode()
  {
    return this.rtnCode;
  }
  
  public void setErrorReason(String paramString)
  {
    this.errorReason = paramString;
  }
  
  public void setRtnCode(int paramInt)
  {
    this.rtnCode = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\auth\AbstractResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */