package com.huawei.hianalytics.f.e;

import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static a a;
  private volatile Map<String, b> b = new HashMap();
  
  public static a a()
  {
    if (a == null) {
      b();
    }
    return a;
  }
  
  private b b(String paramString)
  {
    return null;
  }
  
  private static void b()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public b a(String paramString, long paramLong)
  {
    paramString = b(paramString);
    paramString.a(paramLong);
    return paramString;
  }
  
  public void a(String paramString)
  {
    b(paramString).c();
  }
  
  public void b(String paramString, long paramLong)
  {
    b(paramString).b(paramLong);
  }
  
  public void c(String paramString, long paramLong)
  {
    b(paramString).c(paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */