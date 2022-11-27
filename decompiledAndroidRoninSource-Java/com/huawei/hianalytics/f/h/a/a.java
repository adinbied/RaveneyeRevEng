package com.huawei.hianalytics.f.h.a;

import android.content.Context;
import com.huawei.hianalytics.f.f.g;
import com.huawei.hianalytics.f.g.j;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final Object a = new Object();
  private static Context b;
  
  public static void a(Context paramContext)
  {
    b = paramContext.getApplicationContext();
  }
  
  private static void a(Context paramContext, String paramString1, long paramLong1, LinkedHashMap<String, String> paramLinkedHashMap, String paramString2, String paramString3, long paramLong2, String paramString4)
  {
    j.a(new com.huawei.hianalytics.f.f.c(paramContext, paramString4, paramString2, j.a(paramString1, paramLong1, paramLinkedHashMap, paramString3).toString(), paramLong2));
  }
  
  public static void a(com.huawei.hianalytics.f.h.c.a parama, String paramString)
  {
    if (parama != null)
    {
      if (!parama.d()) {
        return;
      }
      a(b, parama.a(), parama.c(), null, "$AppOnPause", "OnPause", parama.b(), paramString);
    }
  }
  
  public static void a(com.huawei.hianalytics.f.h.c.b paramb, String paramString)
  {
    if (b == null)
    {
      com.huawei.hianalytics.g.b.c("HiAnalytics/V1Server", "onEvent null context");
      return;
    }
    String str1 = paramb.a();
    String str2 = paramb.b();
    paramb = paramb.c();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("_constants", str2);
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
    com.huawei.hianalytics.g.b.c("HiAnalytics/V1Server", "onEvent(): JSONException");
    str2 = localJSONObject.toString();
    j.a(new com.huawei.hianalytics.f.f.c(b, paramString, str1, str2, paramb.longValue()));
  }
  
  public static void a(String paramString)
  {
    g.a().a(paramString, 0);
  }
  
  public static void b(com.huawei.hianalytics.f.h.c.a parama, String paramString)
  {
    if (parama != null)
    {
      if (!parama.d()) {
        return;
      }
      a(b, parama.a(), 0L, null, "$AppOnResume", "OnResume", parama.b(), paramString);
    }
  }
  
  public static void b(String paramString)
  {
    if (b == null)
    {
      com.huawei.hianalytics.g.b.b("HiAnalytics/event", "You must execute Builder.create() before you execute this method.");
      return;
    }
    synchronized (a)
    {
      if (com.huawei.hianalytics.f.h.b.a.a(b))
      {
        com.huawei.hianalytics.g.b.b("HiAnalytics/V1Server", "cached data by BISDK has already handled.");
        return;
      }
      com.huawei.hianalytics.f.h.b.a.b(b);
      j.a(new c(b, paramString));
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\h\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */