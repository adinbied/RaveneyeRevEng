package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.entity.sns.SnsMsg;

public class SnsSendMsgIntentReq
  implements IMessageEntity
{
  @a
  private String callerPackageName;
  @a
  private boolean needResult;
  @a
  private SnsMsg snsMsg;
  
  public String getCallerPackageName()
  {
    return this.callerPackageName;
  }
  
  public SnsMsg getSnsMsg()
  {
    return this.snsMsg;
  }
  
  public boolean isNeedResult()
  {
    return this.needResult;
  }
  
  public void setCallerPackageName(String paramString)
  {
    this.callerPackageName = paramString;
  }
  
  public void setNeedResult(boolean paramBoolean)
  {
    this.needResult = paramBoolean;
  }
  
  public void setSnsMsg(SnsMsg paramSnsMsg)
  {
    this.snsMsg = paramSnsMsg;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\internal\SnsSendMsgIntentReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */