package com.huawei.hianalytics.d;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.e.d;
import com.huawei.hianalytics.util.f;

public abstract class c
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(com.huawei.hianalytics.a.a.c(paramString1, paramString2))) {
      return com.huawei.hianalytics.a.a.c(paramString1, paramString2);
    }
    com.huawei.hianalytics.g.b.b("HianalyticsSDK", "getAndroidId(): to getConfigByType()");
    return c(paramContext, paramString1, paramString2);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return com.huawei.hianalytics.a.c.e(paramString1, paramString2);
  }
  
  public static void a(int paramInt)
  {
    com.huawei.hianalytics.e.a.a().f().a(paramInt);
  }
  
  public static void a(String paramString)
  {
    com.huawei.hianalytics.e.a.a().f().h(paramString);
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString2.equals("oper")) {
      return d(paramContext, paramString1, paramString2);
    }
    if (paramString2.equals("maint")) {
      return d(paramContext, paramString1, paramString2);
    }
    if (paramString2.equals("diffprivacy")) {
      return d(paramContext, paramString1, paramString2);
    }
    if (paramString2.equals("preins")) {
      return d(paramContext, paramString1, paramString2);
    }
    paramContext = new StringBuilder();
    paramContext.append("getChannel(): Invalid type: ");
    paramContext.append(paramString2);
    com.huawei.hianalytics.g.b.c("HianalyticsSDK", paramContext.toString());
    return "";
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return com.huawei.hianalytics.a.c.d(paramString1, paramString2);
  }
  
  private static String c(Context paramContext, String paramString1, String paramString2)
  {
    if (com.huawei.hianalytics.a.a.i(paramString1, paramString2))
    {
      if (TextUtils.isEmpty(com.huawei.hianalytics.a.b.c()))
      {
        paramContext = com.huawei.hianalytics.c.c.d(paramContext);
        com.huawei.hianalytics.e.a.a().f().f(paramContext);
      }
      return com.huawei.hianalytics.a.b.c();
    }
    return "";
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    return com.huawei.hianalytics.a.c.i(paramString1, paramString2);
  }
  
  private static String d(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(com.huawei.hianalytics.a.c.b(paramString1, paramString2))) {
      return com.huawei.hianalytics.a.c.b(paramString1, paramString2);
    }
    paramString2 = com.huawei.hianalytics.e.a.a().f();
    if (TextUtils.isEmpty(paramString2.d()))
    {
      paramString1 = com.huawei.hianalytics.c.c.f(paramContext);
      paramContext = paramString1;
      if (!f.a("channel", paramString1, 256)) {
        paramContext = "";
      }
      paramString2.b(paramContext);
    }
    return paramString2.d();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */