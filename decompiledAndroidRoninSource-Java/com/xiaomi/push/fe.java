package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMJobService;

public final class fe
{
  private static int jdField_a_of_type_Int = 0;
  private static a jdField_a_of_type_ComXiaomiPushFe$a;
  private static final String jdField_a_of_type_JavaLangString = XMJobService.class.getCanonicalName();
  
  public static void a()
  {
    try
    {
      a locala = jdField_a_of_type_ComXiaomiPushFe$a;
      if (locala == null) {
        return;
      }
      b.c("stop alarm.");
      jdField_a_of_type_ComXiaomiPushFe$a.a();
      return;
    }
    finally {}
  }
  
  public static void a(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if ("com.xiaomi.xmsf".equals(localContext.getPackageName())) {}
    for (paramContext = new ff(localContext);; paramContext = new ff(localContext))
    {
      jdField_a_of_type_ComXiaomiPushFe$a = paramContext;
      return;
      paramContext = localContext.getPackageManager();
      int j = 0;
      int i = 0;
      int m = 0;
      for (;;)
      {
        try
        {
          paramContext = paramContext.getPackageInfo(localContext.getPackageName(), 4);
          if (paramContext.services != null)
          {
            paramContext = paramContext.services;
            int n = paramContext.length;
            i = 0;
            j = i;
            if (m < n)
            {
              localStringBuilder = paramContext[m];
              j = i;
              int k = i;
              try
              {
                if ("android.permission.BIND_JOB_SERVICE".equals(localStringBuilder.permission))
                {
                  k = i;
                  bool = jdField_a_of_type_JavaLangString.equals(localStringBuilder.name);
                  if (bool) {
                    i = 1;
                  }
                }
              }
              catch (Exception paramContext)
              {
                boolean bool;
                Class localClass;
                i = k;
              }
            }
          }
        }
        catch (Exception paramContext)
        {
          i = j;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("check service err : ");
          localStringBuilder.append(paramContext.getMessage());
          b.a(localStringBuilder.toString());
        }
        try
        {
          localClass = t.a(localContext, localStringBuilder.name);
          bool = jdField_a_of_type_JavaLangString.equals(localClass.getSuperclass().getCanonicalName());
          if (!bool) {}
        }
        catch (Exception localException)
        {
          continue;
        }
        j = i;
        if (i == 1)
        {
          j = i;
          continue;
        }
        k = j;
        if (jdField_a_of_type_JavaLangString.equals(localStringBuilder.name))
        {
          k = j;
          bool = "android.permission.BIND_JOB_SERVICE".equals(localStringBuilder.permission);
          if (bool)
          {
            i = 1;
            break label281;
          }
        }
        m += 1;
        i = j;
      }
      i = j;
      label281:
      if ((i == 0) && (t.a(localContext)))
      {
        paramContext = new StringBuilder();
        paramContext.append("Should export service: ");
        paramContext.append(jdField_a_of_type_JavaLangString);
        paramContext.append(" with permission ");
        paramContext.append("android.permission.BIND_JOB_SERVICE");
        paramContext.append(" in AndroidManifest.xml file");
        throw new RuntimeException(paramContext.toString());
      }
      i = Build.VERSION.SDK_INT;
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    try
    {
      int i = jdField_a_of_type_Int;
      if (!"com.xiaomi.xmsf".equals(paramContext.getPackageName())) {
        if (paramInt == 2) {
          jdField_a_of_type_Int = 2;
        } else {
          jdField_a_of_type_Int = 0;
        }
      }
      if ((i != jdField_a_of_type_Int) && (jdField_a_of_type_Int == 2))
      {
        a();
        jdField_a_of_type_ComXiaomiPushFe$a = new fh(paramContext);
      }
      return;
    }
    finally {}
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      if (jdField_a_of_type_ComXiaomiPushFe$a == null)
      {
        b.a("timer is not initialized");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("register alarm. (");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(")");
      b.c(localStringBuilder.toString());
      jdField_a_of_type_ComXiaomiPushFe$a.a(paramBoolean);
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    try
    {
      a locala = jdField_a_of_type_ComXiaomiPushFe$a;
      if (locala == null) {
        return false;
      }
      boolean bool = jdField_a_of_type_ComXiaomiPushFe$a.a();
      return bool;
    }
    finally {}
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(boolean paramBoolean);
    
    public abstract boolean a();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\fe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */