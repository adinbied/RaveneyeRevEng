package com.huawei.hms.support.api.push;

import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import java.util.List;
import java.util.Map;

public class HuaweiPushApiImp
  implements HuaweiPushApi
{
  public PendingResult<HandleTagsResult> deleteTags(ApiClient paramApiClient, List<String> paramList)
    throws PushException
  {
    return null;
  }
  
  /* Error */
  public void deleteToken(ApiClient arg1, String arg2)
    throws PushException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void enableReceiveNormalMsg(ApiClient arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void enableReceiveNotifyMsg(ApiClient arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean getPushState(ApiClient paramApiClient)
  {
    return false;
  }
  
  public PendingResult<GetTagResult> getTags(ApiClient paramApiClient)
    throws PushException
  {
    return null;
  }
  
  public PendingResult<TokenResult> getToken(ApiClient paramApiClient)
  {
    return null;
  }
  
  /* Error */
  public void queryAgreement(ApiClient arg1)
    throws PushException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public PendingResult<HandleTagsResult> setTags(ApiClient paramApiClient, Map<String, String> paramMap)
    throws PushException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\HuaweiPushApiImp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */