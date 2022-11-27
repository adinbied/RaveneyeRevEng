package com.huawei.hianalytics.process;

import android.content.Context;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private static a c;
  private static final Object d = new Object();
  private static final Object e = new Object();
  private ConcurrentHashMap<String, d> a = new ConcurrentHashMap();
  private c b = null;
  private Context f;
  
  public static a b()
  {
    if (c == null) {
      f();
    }
    return c;
  }
  
  private static void f()
  {
    try
    {
      if (c == null) {
        c = new a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public d a(String paramString)
  {
    return null;
  }
  
  public d a(String paramString, d paramd)
  {
    return null;
  }
  
  /* Error */
  public void a(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(Context arg1, HiAnalyticsLogConfig arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(HiAnalyticsLogConfig arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(c arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean b(String paramString)
  {
    return false;
  }
  
  public List<String> c()
  {
    return null;
  }
  
  /* Error */
  public void c(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public c d()
  {
    return this.b;
  }
  
  /* Error */
  public void d(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\process\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */