package com.huawei.hianalytics.e;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class a
{
  static Map<String, e> a = new HashMap();
  private static final Object e = new Object();
  private static a g;
  private d b = new d();
  private f c = null;
  private g d = new g();
  private boolean f = false;
  
  public static a a()
  {
    if (g == null) {
      h();
    }
    return g;
  }
  
  private static void h()
  {
    try
    {
      if (g == null) {
        g = new a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public e a(String paramString)
  {
    return null;
  }
  
  /* Error */
  public void a(f arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void a(String paramString, e parame)
  {
    a.put(paramString, parame);
  }
  
  public Set<String> b()
  {
    return a.keySet();
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean d()
  {
    return false;
  }
  
  public f e()
  {
    return null;
  }
  
  public d f()
  {
    return this.b;
  }
  
  public g g()
  {
    return this.d;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */