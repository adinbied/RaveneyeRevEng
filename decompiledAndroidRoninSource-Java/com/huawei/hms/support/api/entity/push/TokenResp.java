package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class TokenResp
  implements IMessageEntity
{
  @a
  private int retCode = 0;
  @a
  private String token = "";
  
  public int getRetCode()
  {
    return this.retCode;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public void setRetCode(int paramInt)
  {
    this.retCode = paramInt;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\push\TokenResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */