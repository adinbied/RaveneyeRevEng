package com.huawei.hianalytics.process;

import android.content.Context;
import com.huawei.hianalytics.f.f.g;
import com.huawei.hianalytics.f.h.a.a;
import java.util.LinkedHashMap;

public final class b
{
  private static b a;
  private Context b;
  private final Object c = new Object();
  
  public static b a()
  {
    if (a == null) {
      c();
    }
    return a;
  }
  
  private static void c()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void a(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void a(String paramString)
  {
    a.b(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    g.a().a(paramString, paramInt);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    g.a().a(paramString1, paramInt, paramString2, paramLinkedHashMap);
  }
  
  public void a(String paramString, Context paramContext)
  {
    g.a().a(paramString, paramContext);
  }
  
  /* Error */
  public void a(String arg1, Context arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(String paramString1, Context paramContext, String paramString2, String paramString3)
  {
    g.a().a(paramString1, paramString2, paramString3);
  }
  
  public void a(String paramString, Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    g.a().a(paramString, paramContext, paramLinkedHashMap);
  }
  
  public void a(String paramString1, String paramString2)
  {
    g.a().b(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    g.a().a(paramString1, paramString2, paramLinkedHashMap);
  }
  
  public void a(boolean paramBoolean)
  {
    g.a().a(paramBoolean);
  }
  
  public void b()
  {
    g.a().d();
  }
  
  public void b(String paramString1, int paramInt, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    g.a().b(paramString1, paramInt, paramString2, paramLinkedHashMap);
  }
  
  public void b(String paramString, Context paramContext)
  {
    g.a().b(paramString, paramContext);
  }
  
  public void b(String paramString, Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    g.a().b(paramString, paramContext, paramLinkedHashMap);
  }
  
  public void b(String paramString1, String paramString2)
  {
    g.a().c(paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    g.a().b(paramString1, paramString2, paramLinkedHashMap);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\process\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */