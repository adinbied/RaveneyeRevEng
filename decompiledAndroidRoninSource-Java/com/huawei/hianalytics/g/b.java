package com.huawei.hianalytics.g;

import android.content.Context;

public abstract class b
{
  private static c a = new c();
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    a.a(paramContext, paramInt, paramString);
    paramContext = new StringBuilder();
    paramContext.append('\n');
    paramContext.append("============================================================================");
    paramContext.append('\n');
    paramContext.append("====== ");
    paramContext.append(d());
    paramContext.append("");
    paramContext.append('\n');
    paramContext.append("============================================================================");
    a.a(paramString, paramContext.toString());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a.a(3, paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a())
    {
      if (paramString2 == null) {
        return;
      }
      a(paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static boolean a()
  {
    return a.a(3);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a.a(4, paramString1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (b())
    {
      if (paramString2 == null) {
        return;
      }
      b(paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static boolean b()
  {
    return a.a(4);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a.a(5, paramString1, paramString2);
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (c())
    {
      if (paramString2 == null) {
        return;
      }
      paramString2 = String.format(paramString2, paramVarArgs);
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("HiAnalytics_");
      paramVarArgs.append(paramString1);
      c(paramVarArgs.toString(), paramString2);
    }
  }
  
  public static boolean c()
  {
    return a.a(5);
  }
  
  private static String d()
  {
    return "HiAnalytics-2.1.3.300";
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a.a(6, paramString1, paramString2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */