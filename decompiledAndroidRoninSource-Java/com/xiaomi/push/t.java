package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.lang.reflect.Field;

public class t
{
  private static Context jdField_a_of_type_AndroidContentContext;
  private static String jdField_a_of_type_JavaLangString;
  
  public static int a()
  {
    try
    {
      Class localClass = a(null, "miui.os.Build");
      if (localClass.getField("IS_STABLE_VERSION").getBoolean(null)) {
        return 3;
      }
      boolean bool = localClass.getField("IS_DEVELOPMENT_VERSION").getBoolean(null);
      if (bool) {
        return 2;
      }
      return 1;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return 0;
  }
  
  public static Context a()
  {
    return jdField_a_of_type_AndroidContentContext;
  }
  
  public static Class<?> a(Context paramContext, String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      boolean bool;
      if (paramContext != null) {
        bool = true;
      } else {
        bool = false;
      }
      if ((bool) && (Build.VERSION.SDK_INT >= 29)) {}
      for (;;)
      {
        try
        {
          paramContext = paramContext.getClassLoader().loadClass(paramString);
          return paramContext;
        }
        catch (ClassNotFoundException paramContext)
        {
          continue;
        }
        try
        {
          paramContext = Class.forName(paramString);
          return paramContext;
        }
        catch (ClassNotFoundException paramContext)
        {
          b.a(String.format("loadClass fail hasContext= %s, errMsg = %s", new Object[] { Boolean.valueOf(bool), paramContext.getLocalizedMessage() }));
          throw new ClassNotFoundException("loadClass fail ", paramContext);
        }
      }
    }
    throw new ClassNotFoundException("class is empty");
  }
  
  public static String a()
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_JavaLangString != null)
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          return (String)localObject1;
        }
        String str = Build.VERSION.INCREMENTAL;
        Object localObject1 = str;
        if (a() <= 0)
        {
          localObject1 = b();
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = c();
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = d();
              if (TextUtils.isEmpty((CharSequence)localObject1))
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(s.a("ro.product.brand", "Android"));
                ((StringBuilder)localObject1).append("_");
                ((StringBuilder)localObject1).append(str);
                localObject1 = String.valueOf(((StringBuilder)localObject1).toString());
              }
            }
          }
        }
        else
        {
          jdField_a_of_type_JavaLangString = (String)localObject1;
          return (String)localObject1;
        }
      }
      finally {}
    }
  }
  
  public static String a(Context paramContext)
  {
    if (l.b()) {
      return "";
    }
    String str = (String)ba.a("com.xiaomi.xmsf.helper.MIIDAccountHelper", "getMIID", new Object[] { paramContext });
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = "0";
    }
    return paramContext;
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static boolean a()
  {
    return TextUtils.equals((String)ba.a("android.os.SystemProperties", "get", new Object[] { "sys.boot_completed" }), "1");
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getApplicationInfo().flags;
      if ((i & 0x2) != 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      b.a(paramContext);
    }
    return false;
  }
  
  private static String b()
  {
    String str = s.a("ro.build.version.emui", "");
    jdField_a_of_type_JavaLangString = str;
    return str;
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.valueOf(false));
      return bool;
    }
    catch (Exception localException)
    {
      b.a(localException);
      return false;
      b.d("miui.os.Build ClassNotFound");
      return false;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
  }
  
  private static String c()
  {
    String str = s.a("ro.build.version.opporom", "");
    if ((!TextUtils.isEmpty(str)) && (!str.startsWith("ColorOS_")))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ColorOS_");
      localStringBuilder.append(str);
      jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  private static String d()
  {
    String str = s.a("ro.vivo.os.version", "");
    if ((!TextUtils.isEmpty(str)) && (!str.startsWith("FuntouchOS_")))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FuntouchOS_");
      localStringBuilder.append(str);
      jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    }
    return jdField_a_of_type_JavaLangString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */