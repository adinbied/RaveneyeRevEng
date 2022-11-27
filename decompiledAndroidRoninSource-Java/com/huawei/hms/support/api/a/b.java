package com.huawei.hms.support.api.a;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.c;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.entity.core.ConnectResp;

final class b
  extends c<ResolveResult<ConnectResp>, ConnectResp>
{
  b(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
  {
    super(paramApiClient, paramString, paramIMessageEntity);
  }
  
  public ResolveResult<ConnectResp> a(ConnectResp paramConnectResp)
  {
    return null;
  }
  
  protected boolean checkApiClient(ApiClient paramApiClient)
  {
    return paramApiClient != null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */