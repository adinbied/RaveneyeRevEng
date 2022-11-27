package com.huawei.hms.support.api.push;

import android.content.Context;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.c;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.entity.push.TokenResp;

public class GetTokenPendingResultImpl
  extends c<TokenResult, TokenResp>
{
  private Context a;
  
  public GetTokenPendingResultImpl(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
  {
    super(paramApiClient, paramString, paramIMessageEntity);
    this.a = paramApiClient.getContext();
  }
  
  public TokenResult onComplete(TokenResp paramTokenResp)
  {
    return null;
  }
  
  protected TokenResult onError(int paramInt)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\GetTokenPendingResultImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */