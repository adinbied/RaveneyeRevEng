package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class AgreementResp
  implements IMessageEntity
{
  @a
  private boolean bAgree = false;
  @a
  private int retCode = 0;
  
  public int getRetCode()
  {
    return this.retCode;
  }
  
  public boolean isAgree()
  {
    return this.bAgree;
  }
  
  public void setAgree(boolean paramBoolean)
  {
    this.bAgree = paramBoolean;
  }
  
  public void setRetCode(int paramInt)
  {
    this.retCode = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\push\AgreementResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */