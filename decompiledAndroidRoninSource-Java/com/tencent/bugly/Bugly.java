package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.Map;

public class Bugly
{
  public static final String SDK_IS_DEV = "false";
  private static boolean a = false;
  public static Context applicationContext;
  private static String[] b = { "BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule" };
  private static String[] c = { "BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule" };
  public static boolean enable = true;
  public static Boolean isDev;
  
  public static String getAppChannel()
  {
    try
    {
      Object localObject1 = a.b();
      if (localObject1 == null) {
        return null;
      }
      if (TextUtils.isEmpty(((a)localObject1).l))
      {
        Object localObject3 = p.a();
        if (localObject3 == null)
        {
          localObject1 = ((a)localObject1).l;
          return (String)localObject1;
        }
        localObject3 = ((p)localObject3).a(556, null, true);
        if (localObject3 != null)
        {
          localObject3 = (byte[])((Map)localObject3).get("app_channel");
          if (localObject3 != null)
          {
            localObject1 = new String((byte[])localObject3);
            return (String)localObject1;
          }
        }
      }
      localObject1 = ((a)localObject1).l;
      return (String)localObject1;
    }
    finally {}
  }
  
  public static void init(Context paramContext, String paramString, boolean paramBoolean)
  {
    init(paramContext, paramString, paramBoolean, null);
  }
  
  public static void init(Context paramContext, String paramString, boolean paramBoolean, BuglyStrategy paramBuglyStrategy)
  {
    for (;;)
    {
      int i;
      try
      {
        boolean bool = a;
        if (bool) {
          return;
        }
        a = true;
        paramContext = z.a(paramContext);
        applicationContext = paramContext;
        if (paramContext == null)
        {
          Log.e(x.a, "init arg 'context' should not be null!");
          return;
        }
        if (isDev()) {
          b = c;
        }
        paramContext = b;
        int j = paramContext.length;
        i = 0;
        if (i < j)
        {
          Object localObject = paramContext[i];
          try
          {
            if (((String)localObject).equals("BuglyCrashModule")) {
              b.a(CrashModule.getInstance());
            } else if ((!((String)localObject).equals("BuglyBetaModule")) && (!((String)localObject).equals("BuglyRqdModule"))) {
              ((String)localObject).equals("BuglyFeedbackModule");
            }
          }
          finally
          {
            x.b(localThrowable);
            break label169;
          }
        }
        b.a = enable;
        b.a(applicationContext, paramString, paramBoolean, paramBuglyStrategy);
        return;
      }
      finally {}
      label169:
      i += 1;
    }
  }
  
  public static boolean isDev()
  {
    if (isDev == null) {
      isDev = Boolean.valueOf(Boolean.parseBoolean("false".replace("@", "")));
    }
    return isDev.booleanValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\Bugly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */