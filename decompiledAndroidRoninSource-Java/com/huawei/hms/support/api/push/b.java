package com.huawei.hms.support.api.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.push.b.a.a.c;
import com.huawei.hms.support.log.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class b
{
  private PendingResult<HandleTagsResult> a(ApiClient paramApiClient, String paramString, long paramLong, int paramInt)
    throws PushException
  {
    return null;
  }
  
  private static Map<String, String> a(Context paramContext, Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramContext = new c(paramContext, "tags_info");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      Object localObject = (String)localEntry.getKey();
      String str1 = (String)localEntry.getValue();
      if (paramContext.c((String)localObject))
      {
        String str2 = paramContext.b((String)localObject);
        if ((!TextUtils.isEmpty(str1)) && (str1.equals(str2)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("tag has reported:");
          ((StringBuilder)localObject).append(localEntry);
          a.a("PushTagManager", ((StringBuilder)localObject).toString());
          continue;
        }
      }
      localHashMap.put(localObject, str1);
    }
    return localHashMap;
  }
  
  /* Error */
  private void a(List<String> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  PendingResult<GetTagResult> a(ApiClient paramApiClient)
    throws PushException
  {
    return null;
  }
  
  PendingResult<HandleTagsResult> a(ApiClient paramApiClient, List<String> paramList)
    throws PushException
  {
    return null;
  }
  
  PendingResult<HandleTagsResult> a(ApiClient paramApiClient, Map<String, String> paramMap)
    throws PushException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */