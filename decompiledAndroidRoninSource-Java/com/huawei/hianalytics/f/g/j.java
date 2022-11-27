package com.huawei.hianalytics.f.g;

import android.text.TextUtils;
import com.huawei.hianalytics.i.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class j
{
  private static JSONObject a(long paramLong, String paramString1, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if (paramLinkedHashMap == null) {
      paramLinkedHashMap = new JSONObject();
    } else {
      paramLinkedHashMap = a(paramLinkedHashMap);
    }
    try
    {
      if ("OnPause".equals(paramString2)) {
        paramLinkedHashMap.put("_event_duration", paramLong);
      }
      paramLinkedHashMap.put("_activity_name", paramString1);
      return paramLinkedHashMap;
    }
    catch (JSONException paramString1)
    {
      for (;;) {}
    }
    com.huawei.hianalytics.g.b.c("ThreadUtil", "getEventContent(): JSONException");
    return paramLinkedHashMap;
  }
  
  public static JSONObject a(String paramString1, long paramLong, LinkedHashMap<String, String> paramLinkedHashMap, String paramString2)
  {
    return a(paramLong, paramString1, paramString2, paramLinkedHashMap);
  }
  
  public static JSONObject a(LinkedHashMap<String, String> paramLinkedHashMap)
  {
    JSONObject localJSONObject = new JSONObject();
    paramLinkedHashMap = paramLinkedHashMap.entrySet().iterator();
    while (paramLinkedHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramLinkedHashMap.next();
      try
      {
        if (TextUtils.isEmpty((CharSequence)localEntry.getKey())) {
          continue;
        }
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
      com.huawei.hianalytics.g.b.c("ThreadUtil", "onEvent(): JSONException: mapValue");
    }
    return localJSONObject;
  }
  
  public static void a(a parama)
  {
    if (parama == null)
    {
      com.huawei.hianalytics.g.b.c("ThreadUtil", "runTaskSessionHandler - task is null");
      return;
    }
    com.huawei.hianalytics.i.b localb = com.huawei.hianalytics.i.b.a();
    if (localb != null)
    {
      localb.a(parama);
      return;
    }
    com.huawei.hianalytics.g.b.c("ThreadUtil", "SessionHandler is NULL, failed to call task: %s", new Object[] { parama.getClass().getSimpleName() });
  }
  
  public static boolean a(String paramString, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return paramLong1 - l > paramLong2;
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    com.huawei.hianalytics.g.b.c("ThreadUtil", "isTimeExpired(): Data type conversion error : number format !");
    return true;
  }
  
  public static void b(a parama)
  {
    if (parama == null)
    {
      com.huawei.hianalytics.g.b.c("ThreadUtil", "runTaskMessageThread - task is null");
      return;
    }
    com.huawei.hianalytics.i.b localb = com.huawei.hianalytics.i.b.b();
    if (localb != null)
    {
      localb.a(parama);
      return;
    }
    com.huawei.hianalytics.g.b.c("ThreadUtil", "runTaskMessageThread is NULL, failed to call task: %s", new Object[] { parama.getClass().getSimpleName() });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\g\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */