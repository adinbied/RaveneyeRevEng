package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Iterator;
import java.util.List;

public class f
{
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      paramString = paramContext.getPackageManager().getPackageInfo(paramString, 4).services;
      if (paramString != null)
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramString[i];
          if ((((ServiceInfo)localObject).exported) && (((ServiceInfo)localObject).enabled) && ("com.xiaomi.mipush.sdk.PushMessageHandler".equals(((ServiceInfo)localObject).name)))
          {
            boolean bool = paramContext.getPackageName().equals(((ServiceInfo)localObject).packageName);
            if (!bool) {
              return true;
            }
          }
          i += 1;
        }
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      b.a(paramContext);
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getPackageManager();
      paramString2 = new Intent(paramString2);
      paramString2.setPackage(paramString1);
      paramContext = paramContext.queryIntentServices(paramString2, 32);
      if (paramContext != null)
      {
        boolean bool = paramContext.isEmpty();
        if (!bool) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      b.a(paramContext);
    }
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool2 = false;
    boolean bool3 = bool4;
    try
    {
      paramContext = paramContext.getPackageManager();
      bool3 = bool4;
      int i = Build.VERSION.SDK_INT;
      boolean bool1 = true;
      if (i >= 19)
      {
        bool3 = bool4;
        paramContext = paramContext.queryContentProviders(null, 0, 8);
        bool1 = bool5;
        if (paramContext != null)
        {
          bool3 = bool4;
          bool1 = bool5;
          if (!paramContext.isEmpty())
          {
            bool3 = bool4;
            paramContext = paramContext.iterator();
            for (;;)
            {
              bool3 = bool2;
              bool1 = bool2;
              if (!paramContext.hasNext()) {
                break;
              }
              bool3 = bool2;
              ProviderInfo localProviderInfo = (ProviderInfo)paramContext.next();
              bool3 = bool2;
              if (localProviderInfo.enabled)
              {
                bool3 = bool2;
                if (localProviderInfo.exported)
                {
                  bool3 = bool2;
                  bool1 = localProviderInfo.authority.equals(paramString);
                  if (bool1) {
                    bool2 = true;
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    catch (Exception paramContext)
    {
      b.a(paramContext);
      bool1 = bool3;
    }
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getPackageManager();
      paramString2 = new Intent(paramString2);
      paramString2.setPackage(paramString1);
      paramContext = paramContext.queryIntentActivities(paramString2, 32);
      if (paramContext != null)
      {
        boolean bool = paramContext.isEmpty();
        if (!bool) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      b.a(paramContext);
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */