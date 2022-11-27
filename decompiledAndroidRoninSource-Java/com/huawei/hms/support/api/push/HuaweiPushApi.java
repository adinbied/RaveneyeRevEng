package com.huawei.hms.support.api.push;

import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import java.util.List;
import java.util.Map;

public abstract interface HuaweiPushApi
{
  public abstract PendingResult<HandleTagsResult> deleteTags(ApiClient paramApiClient, List<String> paramList)
    throws PushException;
  
  public abstract void deleteToken(ApiClient paramApiClient, String paramString)
    throws PushException;
  
  public abstract void enableReceiveNormalMsg(ApiClient paramApiClient, boolean paramBoolean);
  
  public abstract void enableReceiveNotifyMsg(ApiClient paramApiClient, boolean paramBoolean);
  
  public abstract boolean getPushState(ApiClient paramApiClient);
  
  public abstract PendingResult<GetTagResult> getTags(ApiClient paramApiClient)
    throws PushException;
  
  public abstract PendingResult<TokenResult> getToken(ApiClient paramApiClient);
  
  public abstract void queryAgreement(ApiClient paramApiClient)
    throws PushException;
  
  public abstract PendingResult<HandleTagsResult> setTags(ApiClient paramApiClient, Map<String, String> paramMap)
    throws PushException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\HuaweiPushApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */