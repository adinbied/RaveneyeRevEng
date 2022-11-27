package com.huawei.hianalytics.a;

import com.huawei.hianalytics.e.b;
import com.huawei.hianalytics.e.c;
import com.huawei.hianalytics.e.e;

public abstract class a
{
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.e();
    }
    return "";
  }
  
  public static String b(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.f();
    }
    return "";
  }
  
  public static String c(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.g();
    }
    return "";
  }
  
  public static String d(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.h();
    }
    return "";
  }
  
  public static boolean e(String paramString1, String paramString2)
  {
    paramString1 = com.huawei.hianalytics.e.a.a().a(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.a(paramString2);
      if (paramString1 != null) {
        return paramString1.d();
      }
    }
    return false;
  }
  
  public static boolean f(String paramString1, String paramString2)
  {
    paramString1 = com.huawei.hianalytics.e.a.a().a(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.a(paramString2);
      if (paramString1 != null) {
        return paramString1.e();
      }
    }
    return false;
  }
  
  public static boolean g(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    return (paramString1 != null) && (paramString1.a());
  }
  
  public static boolean h(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    return (paramString1 != null) && (paramString1.c());
  }
  
  public static boolean i(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    return (paramString1 != null) && (paramString1.d());
  }
  
  public static boolean j(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1, paramString2);
    return (paramString1 != null) && (paramString1.b());
  }
  
  private static b k(String paramString1, String paramString2)
  {
    paramString1 = com.huawei.hianalytics.e.a.a().a(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.a(paramString2);
      if (paramString1 != null) {
        return paramString1.a();
      }
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */