package com.huawei.updatesdk.support.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemProperties;
import com.huawei.updatesdk.sdk.a.d.e;

public final class a
{
  private static final String a = a.class.getSimpleName();
  private static String b = null;
  
  public static String a()
  {
    return "com.huawei.updatesdk";
  }
  
  private static void a(String paramString)
  {
    b = paramString;
  }
  
  public static String b()
  {
    Object localObject1 = b;
    if (localObject1 != null) {
      return (String)localObject1;
    }
    for (;;)
    {
      try
      {
        str = com.huawei.updatesdk.sdk.service.a.a.a().b().getPackageName();
        localObject2 = com.huawei.updatesdk.sdk.service.a.a.a().b().getPackageManager().getPackageInfo(com.huawei.updatesdk.sdk.service.a.a.a().b().getPackageName(), 0);
        localObject1 = str;
        if (localObject2 != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(((PackageInfo)localObject2).versionName);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        str = SystemProperties.get("ro.product.brand", "");
        if (!e.a(str))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("_");
          ((StringBuilder)localObject2).append(str);
          a(((StringBuilder)localObject2).toString());
          localObject1 = b;
          return (String)localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        str = a;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getUserAgent() ");
        ((StringBuilder)localObject2).append(localNameNotFoundException.toString());
        com.huawei.updatesdk.sdk.a.c.a.a.a.d(str, ((StringBuilder)localObject2).toString());
        return null;
      }
      String str = "other";
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\support\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */