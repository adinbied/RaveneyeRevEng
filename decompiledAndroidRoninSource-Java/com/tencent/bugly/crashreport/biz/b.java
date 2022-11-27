package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;

public class b
{
  public static a a;
  private static boolean b = false;
  private static int c = 10;
  private static long d = 300000L;
  private static long e = 30000L;
  private static long f = 0L;
  private static int g = 0;
  private static long h = 0L;
  private static long i = 0L;
  private static long j = 0L;
  private static Application.ActivityLifecycleCallbacks k;
  private static Class<?> l;
  private static boolean m = true;
  
  public static void a()
  {
    a locala = a;
    if (locala != null) {
      locala.a(2, false, 0L);
    }
  }
  
  public static void a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = com.tencent.bugly.crashreport.common.strategy.a.a().c().o;
    }
    f = l1;
  }
  
  public static void a(Context paramContext)
  {
    if (b)
    {
      if (paramContext == null) {
        return;
      }
      Application localApplication = null;
      if (Build.VERSION.SDK_INT >= 14)
      {
        if ((paramContext.getApplicationContext() instanceof Application)) {
          localApplication = (Application)paramContext.getApplicationContext();
        }
        if (localApplication != null) {
          try
          {
            if (k != null) {
              localApplication.unregisterActivityLifecycleCallbacks(k);
            }
          }
          catch (Exception paramContext)
          {
            if (!x.a(paramContext)) {
              paramContext.printStackTrace();
            }
          }
        }
      }
      b = false;
    }
  }
  
  public static void a(Context paramContext, final BuglyStrategy paramBuglyStrategy)
  {
    if (b) {
      return;
    }
    boolean bool = com.tencent.bugly.crashreport.common.info.a.a(paramContext).e;
    m = bool;
    a = new a(paramContext, bool);
    b = true;
    long l1;
    if (paramBuglyStrategy != null)
    {
      l = paramBuglyStrategy.getUserInfoActivity();
      l1 = paramBuglyStrategy.getAppReportDelay();
    }
    else
    {
      l1 = 0L;
    }
    if (l1 <= 0L)
    {
      c(paramContext, paramBuglyStrategy);
      return;
    }
    w.a().a(new Runnable()
    {
      public final void run()
      {
        b.b(this.a, paramBuglyStrategy);
      }
    }, l1);
  }
  
  public static void a(StrategyBean paramStrategyBean, boolean paramBoolean)
  {
    a locala = a;
    if ((locala != null) && (!paramBoolean))
    {
      w localw = w.a();
      if (localw != null) {
        localw.a(new a.2(locala));
      }
    }
    if (paramStrategyBean == null) {
      return;
    }
    if (paramStrategyBean.o > 0L) {
      e = paramStrategyBean.o;
    }
    if (paramStrategyBean.t > 0) {
      c = paramStrategyBean.t;
    }
    if (paramStrategyBean.u > 0L) {
      d = paramStrategyBean.u;
    }
  }
  
  private static void c(Context paramContext, BuglyStrategy paramBuglyStrategy)
  {
    boolean bool2;
    boolean bool1;
    if (paramBuglyStrategy != null)
    {
      bool2 = paramBuglyStrategy.recordUserInfoOnceADay();
      bool1 = paramBuglyStrategy.isEnableUserInfo();
    }
    else
    {
      bool1 = true;
      bool2 = false;
    }
    int n;
    if (bool2)
    {
      paramBuglyStrategy = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
      localObject1 = paramBuglyStrategy.d;
      localObject1 = a.a((String)localObject1);
      if (localObject1 != null)
      {
        n = 0;
        while (n < ((List)localObject1).size())
        {
          localObject2 = (UserInfoBean)((List)localObject1).get(n);
          if ((((UserInfoBean)localObject2).n.equals(paramBuglyStrategy.j)) && (((UserInfoBean)localObject2).b == 1))
          {
            long l1 = z.b();
            if (l1 <= 0L) {
              break;
            }
            if (((UserInfoBean)localObject2).e >= l1)
            {
              if (((UserInfoBean)localObject2).f <= 0L)
              {
                paramBuglyStrategy = a;
                localObject1 = w.a();
                if (localObject1 != null) {
                  ((w)localObject1).a(new a.2(paramBuglyStrategy));
                }
              }
              n = 0;
              break label181;
            }
          }
          n += 1;
        }
      }
      n = 1;
      label181:
      if (n == 0) {
        return;
      }
      bool1 = false;
    }
    Object localObject2 = com.tencent.bugly.crashreport.common.info.a.b();
    Object localObject1 = null;
    if (localObject2 != null)
    {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      int i2 = arrayOfStackTraceElement.length;
      paramBuglyStrategy = null;
      n = 0;
      int i1 = 0;
      while (n < i2)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[n];
        if (localStackTraceElement.getMethodName().equals("onCreate")) {
          paramBuglyStrategy = localStackTraceElement.getClassName();
        }
        if (localStackTraceElement.getClassName().equals("android.app.Activity")) {
          i1 = 1;
        }
        n += 1;
      }
      if (paramBuglyStrategy != null)
      {
        if (i1 != 0) {
          ((com.tencent.bugly.crashreport.common.info.a)localObject2).a(true);
        } else {
          paramBuglyStrategy = "background";
        }
      }
      else {
        paramBuglyStrategy = "unknown";
      }
      ((com.tencent.bugly.crashreport.common.info.a)localObject2).p = paramBuglyStrategy;
    }
    if ((bool1) && (Build.VERSION.SDK_INT >= 14))
    {
      paramBuglyStrategy = (BuglyStrategy)localObject1;
      if ((paramContext.getApplicationContext() instanceof Application)) {
        paramBuglyStrategy = (Application)paramContext.getApplicationContext();
      }
      if (paramBuglyStrategy != null) {
        try
        {
          if (k == null) {
            k = new Application.ActivityLifecycleCallbacks()
            {
              public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
              {
                if (paramAnonymousActivity != null) {
                  paramAnonymousActivity = paramAnonymousActivity.getClass().getName();
                } else {
                  paramAnonymousActivity = "unknown";
                }
                if ((b.b() != null) && (!b.b().getName().equals(paramAnonymousActivity))) {
                  return;
                }
                x.c(">>> %s onCreated <<<", new Object[] { paramAnonymousActivity });
                paramAnonymousBundle = com.tencent.bugly.crashreport.common.info.a.b();
                if (paramAnonymousBundle != null) {
                  paramAnonymousBundle.C.add(b.a(paramAnonymousActivity, "onCreated"));
                }
              }
              
              public final void onActivityDestroyed(Activity paramAnonymousActivity)
              {
                if (paramAnonymousActivity != null) {
                  paramAnonymousActivity = paramAnonymousActivity.getClass().getName();
                } else {
                  paramAnonymousActivity = "unknown";
                }
                if ((b.b() != null) && (!b.b().getName().equals(paramAnonymousActivity))) {
                  return;
                }
                x.c(">>> %s onDestroyed <<<", new Object[] { paramAnonymousActivity });
                com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
                if (locala != null) {
                  locala.C.add(b.a(paramAnonymousActivity, "onDestroyed"));
                }
              }
              
              public final void onActivityPaused(Activity paramAnonymousActivity)
              {
                String str;
                if (paramAnonymousActivity != null) {
                  str = paramAnonymousActivity.getClass().getName();
                } else {
                  str = "unknown";
                }
                if ((b.b() != null) && (!b.b().getName().equals(str))) {
                  return;
                }
                x.c(">>> %s onPaused <<<", new Object[] { str });
                com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
                if (locala == null) {
                  return;
                }
                locala.C.add(b.a(str, "onPaused"));
                locala.r = System.currentTimeMillis();
                locala.s = (locala.r - locala.q);
                b.c(locala.r);
                if (locala.s < 0L) {
                  locala.s = 0L;
                }
                if (paramAnonymousActivity != null)
                {
                  locala.p = "background";
                  return;
                }
                locala.p = "unknown";
              }
              
              public final void onActivityResumed(Activity paramAnonymousActivity)
              {
                if (paramAnonymousActivity != null) {
                  paramAnonymousActivity = paramAnonymousActivity.getClass().getName();
                } else {
                  paramAnonymousActivity = "unknown";
                }
                if ((b.b() != null) && (!b.b().getName().equals(paramAnonymousActivity))) {
                  return;
                }
                x.c(">>> %s onResumed <<<", new Object[] { paramAnonymousActivity });
                com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
                if (locala == null) {
                  return;
                }
                locala.C.add(b.a(paramAnonymousActivity, "onResumed"));
                locala.p = paramAnonymousActivity;
                locala.q = System.currentTimeMillis();
                locala.t = (locala.q - b.c());
                long l2 = locala.q - b.d();
                long l1;
                if (b.e() > 0L) {
                  l1 = b.e();
                } else {
                  l1 = b.f();
                }
                if (l2 > l1)
                {
                  locala.d();
                  b.g();
                  x.a("[session] launch app one times (app in background %d seconds and over %d seconds)", new Object[] { Long.valueOf(l2 / 1000L), Long.valueOf(b.f() / 1000L) });
                  if (b.h() % b.i() == 0)
                  {
                    b.a.a(4, b.j(), 0L);
                    return;
                  }
                  b.a.a(4, false, 0L);
                  l1 = System.currentTimeMillis();
                  if (l1 - b.k() > b.l())
                  {
                    b.b(l1);
                    x.a("add a timer to upload hot start user info", new Object[0]);
                    if (b.j())
                    {
                      paramAnonymousActivity = b.a;
                      l1 = b.l();
                      w.a().a(new a.a(paramAnonymousActivity, null, true), l1);
                    }
                  }
                }
              }
              
              public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
              
              public final void onActivityStarted(Activity paramAnonymousActivity)
              {
                if (paramAnonymousActivity != null) {
                  paramAnonymousActivity = paramAnonymousActivity.getClass().getName();
                } else {
                  paramAnonymousActivity = "unknown";
                }
                x.c(">>> %s onStart <<<", new Object[] { paramAnonymousActivity });
                com.tencent.bugly.crashreport.common.info.a.b().a(true);
              }
              
              public final void onActivityStopped(Activity paramAnonymousActivity)
              {
                if (paramAnonymousActivity != null) {
                  paramAnonymousActivity = paramAnonymousActivity.getClass().getName();
                } else {
                  paramAnonymousActivity = "unknown";
                }
                x.c(">>> %s onStop <<<", new Object[] { paramAnonymousActivity });
                com.tencent.bugly.crashreport.common.info.a.b().a(false);
              }
            };
          }
          paramBuglyStrategy.registerActivityLifecycleCallbacks(k);
        }
        catch (Exception paramContext)
        {
          if (!x.a(paramContext)) {
            paramContext.printStackTrace();
          }
        }
      }
    }
    if (m)
    {
      i = System.currentTimeMillis();
      a.a(1, false, 0L);
      x.a("[session] launch app, new start", new Object[0]);
      a.a();
      paramContext = a;
      w.a().a(new a.c(paramContext, 21600000L), 21600000L);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\biz\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */