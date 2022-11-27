package com.huawei.updatesdk.support.c;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.huawei.updatesdk.sdk.a.d.e;
import java.io.File;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  private static Integer a;
  private static boolean b;
  private static boolean c;
  private static Field d;
  
  public static PackageInfo a(String paramString, Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    paramContext = new StringBuilder();
    paramContext.append("not found: ");
    paramContext.append(paramString);
    com.huawei.updatesdk.sdk.a.c.a.a.a.d("PackageUtils", paramContext.toString());
    return null;
  }
  
  public static a a(Context paramContext, String paramString)
  {
    a locala = a.a;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null)
      {
        if (paramContext.versionCode < 70203000) {
          return a.c;
        }
        paramContext = a.b;
        return paramContext;
      }
      return locala;
    }
    catch (UnsupportedOperationException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("isInstallByPackage UnsupportedOperationException:");
      paramContext = paramContext.toString();
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("isInstallByPackage NameNotFoundException:");
      paramContext = paramContext.toString();
    }
    paramString.append(paramContext);
    com.huawei.updatesdk.sdk.a.c.a.a.a.b("PackageUtils", paramString.toString());
    return locala;
  }
  
  public static Integer a()
  {
    if (b) {
      return a;
    }
    StringBuilder localStringBuilder;
    String str4;
    try
    {
      Class localClass = Class.forName("android.content.pm.PackageParser");
      a = Integer.valueOf(localClass.getDeclaredField("PARSE_IS_REMOVABLE_PREINSTALLED_APK").getInt(localClass));
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDelApp error NoSuchFieldException:");
      String str1 = localIllegalArgumentException.toString();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDelApp error NoSuchFieldException:");
      String str2 = localIllegalAccessException.toString();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDelApp error NoSuchFieldException:");
      String str3 = localClassNotFoundException.toString();
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDelApp error NoSuchFieldException:");
      str4 = localNoSuchFieldException.toString();
    }
    localStringBuilder.append(str4);
    com.huawei.updatesdk.sdk.a.c.a.a.a.a("PackageUtils", localStringBuilder.toString());
    b = true;
    return a;
  }
  
  public static boolean a(Context paramContext)
  {
    String str2;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.huawei.appmarket", 0);
      if (paramContext == null) {
        break label88;
      }
      int i = paramContext.versionCode;
      if (i <= 90000000) {
        break label88;
      }
      return true;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      paramContext = new StringBuilder();
      paramContext.append("isInstallByPackage UnsupportedOperationException:");
      String str1 = localUnsupportedOperationException.toString();
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      paramContext = new StringBuilder();
      paramContext.append("isInstallByPackage NameNotFoundException:");
      str2 = localNameNotFoundException.toString();
    }
    paramContext.append(str2);
    com.huawei.updatesdk.sdk.a.c.a.a.a.b("PackageUtils", paramContext.toString());
    label88:
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (e.b(paramString)) {
      return false;
    }
    if (Pattern.compile("(\\.)+[\\\\/]+").matcher(paramString).find())
    {
      com.huawei.updatesdk.sdk.a.c.a.a.a.a("PackageUtils", "remov APK fail. the apk path is not valid");
      return false;
    }
    return new File(paramString).delete();
  }
  
  public static Field b()
  {
    if (c) {
      return d;
    }
    try
    {
      d = ApplicationInfo.class.getField("hwFlags");
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
    com.huawei.updatesdk.sdk.a.c.a.a.a.a("PackageUtils", "can not find hwFlags");
    c = true;
    return d;
  }
  
  public static boolean c()
  {
    return (Build.VERSION.SDK_INT >= 23) && (new ContextWrapper(com.huawei.updatesdk.sdk.service.a.a.a().b()).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
  }
  
  public static enum a
  {
    static
    {
      a locala = new a("INSTALLED_LOWCODE", 2);
      c = locala;
      d = new a[] { a, b, locala };
    }
    
    private a() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\support\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */