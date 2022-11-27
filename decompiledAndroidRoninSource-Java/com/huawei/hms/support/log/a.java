package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class a
{
  private static final b a = new b();
  
  private static String a(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    if (localObject != null) {}
    try
    {
      paramContext = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("HMS-");
      ((StringBuilder)localObject).append(paramContext.versionName);
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(paramContext.versionCode);
      ((StringBuilder)localObject).append(")");
      paramContext = ((StringBuilder)localObject).toString();
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return "HMS-[unknown-version]";
    return "HMS-[unknown-version]";
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    a.a(paramContext, paramInt, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("============================================================================");
    localStringBuilder.append('\n');
    localStringBuilder.append("====== ");
    localStringBuilder.append(a(paramContext));
    localStringBuilder.append('\n');
    localStringBuilder.append("============================================================================");
    a.a(paramString, localStringBuilder.toString());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a.a(3, paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a.a(6, paramString1, paramString2, paramThrowable);
  }
  
  public static boolean a()
  {
    return a.a(3);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a.a(4, paramString1, paramString2);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a.a(5, paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a.a(6, paramString1, paramString2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\log\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */