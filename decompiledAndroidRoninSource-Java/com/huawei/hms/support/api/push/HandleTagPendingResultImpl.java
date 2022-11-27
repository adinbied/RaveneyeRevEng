package com.huawei.hms.support.api.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.entity.push.TagsResp;
import org.json.JSONArray;
import org.json.JSONObject;

public class HandleTagPendingResultImpl
  extends com.huawei.hms.support.api.c<HandleTagsResult, TagsResp>
{
  private ApiClient a;
  
  public HandleTagPendingResultImpl(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
  {
    super(paramApiClient, paramString, paramIMessageEntity);
    this.a = paramApiClient;
  }
  
  private static void a(ApiClient paramApiClient, String paramString)
  {
    if (paramApiClient == null)
    {
      com.huawei.hms.support.log.a.a("HandleTagPendingResultImpl", "the client is null when adding or deleting tags from file.");
      return;
    }
    try
    {
      paramString = com.huawei.hms.support.api.push.b.a.a.a.a(paramString);
      if (paramString == null) {
        return;
      }
      paramApiClient = new com.huawei.hms.support.api.push.b.a.a.c(paramApiClient.getContext(), "tags_info");
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        if (localJSONObject != null)
        {
          String str = localJSONObject.optString("tagKey");
          int k = localJSONObject.optInt("opType");
          if (1 == k) {
            paramApiClient.a(str, localJSONObject.optString("tagValue"));
          } else if (2 == k) {
            paramApiClient.d(str);
          }
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramApiClient)
    {
      paramString = new StringBuilder();
      paramString.append("when adding or deleting tags from file excepiton,");
      paramString.append(paramApiClient.getMessage());
      com.huawei.hms.support.log.a.c("HandleTagPendingResultImpl", paramString.toString());
    }
  }
  
  public HandleTagsResult onComplete(TagsResp paramTagsResp)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\HandleTagPendingResultImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */