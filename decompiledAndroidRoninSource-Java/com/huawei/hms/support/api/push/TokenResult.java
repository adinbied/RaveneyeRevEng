package com.huawei.hms.support.api.push;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.push.TokenResp;

public class TokenResult
  extends Result
{
  protected TokenResp resp;
  
  public TokenResp getTokenRes()
  {
    return this.resp;
  }
  
  public void setTokenRes(TokenResp paramTokenResp)
  {
    this.resp = paramTokenResp;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\TokenResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */