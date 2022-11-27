package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.HashMap;
import java.util.Map;

public final class e
  implements Thread.UncaughtExceptionHandler
{
  private static String h;
  private static final Object i = new Object();
  private Context a;
  private b b;
  private com.tencent.bugly.crashreport.common.strategy.a c;
  private com.tencent.bugly.crashreport.common.info.a d;
  private Thread.UncaughtExceptionHandler e;
  private Thread.UncaughtExceptionHandler f;
  private boolean g = false;
  private int j;
  
  public e(Context paramContext, b paramb, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.crashreport.common.info.a parama1)
  {
    this.a = paramContext;
    this.b = paramb;
    this.c = parama;
    this.d = parama1;
  }
  
  private static String a(Throwable paramThrowable, int paramInt)
  {
    if (paramThrowable == null) {
      return null;
    }
    localStringBuilder = new StringBuilder();
    try
    {
      if (paramThrowable.getStackTrace() != null)
      {
        paramThrowable = paramThrowable.getStackTrace();
        int m = paramThrowable.length;
        int k = 0;
        while (k < m)
        {
          Object localObject = paramThrowable[k];
          if ((paramInt > 0) && (localStringBuilder.length() >= paramInt))
          {
            paramThrowable = new StringBuilder("\n[Stack over limit size :");
            paramThrowable.append(paramInt);
            paramThrowable.append(" , has been cutted !]");
            localStringBuilder.append(paramThrowable.toString());
            return localStringBuilder.toString();
          }
          localStringBuilder.append(((StackTraceElement)localObject).toString());
          localStringBuilder.append("\n");
          k += 1;
        }
      }
      return localStringBuilder.toString();
    }
    finally
    {
      x.e("gen stack error %s", new Object[] { paramThrowable.toString() });
    }
  }
  
  private static boolean a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    if (paramUncaughtExceptionHandler == null) {
      return true;
    }
    paramUncaughtExceptionHandler = paramUncaughtExceptionHandler.getClass().getName();
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int m = arrayOfStackTraceElement.length;
    int k = 0;
    while (k < m)
    {
      Object localObject = arrayOfStackTraceElement[k];
      String str = ((StackTraceElement)localObject).getClassName();
      localObject = ((StackTraceElement)localObject).getMethodName();
      if ((paramUncaughtExceptionHandler.equals(str)) && ("uncaughtException".equals(localObject))) {
        return false;
      }
      k += 1;
    }
    return true;
  }
  
  private static boolean a(Thread paramThread)
  {
    synchronized (i)
    {
      if (h != null)
      {
        boolean bool = paramThread.getName().equals(h);
        if (bool) {
          return true;
        }
      }
      h = paramThread.getName();
      return false;
    }
  }
  
  private CrashDetailBean b(Thread paramThread, Throwable paramThrowable, boolean paramBoolean, String paramString, byte[] paramArrayOfByte)
  {
    if (paramThrowable == null)
    {
      x.d("We can do nothing with a null throwable.", new Object[0]);
      return null;
    }
    boolean bool = c.a().m();
    Object localObject1;
    if ((bool) && (paramBoolean)) {
      localObject1 = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
    } else {
      localObject1 = "";
    }
    if ((bool) && (paramBoolean)) {
      x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
    }
    CrashDetailBean localCrashDetailBean = new CrashDetailBean();
    localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
    localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
    localCrashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
    localCrashDetailBean.F = this.d.l();
    localCrashDetailBean.G = this.d.k();
    localCrashDetailBean.H = this.d.m();
    localCrashDetailBean.w = z.a(this.a, c.e, null);
    localCrashDetailBean.y = y.a();
    if (localCrashDetailBean.y == null) {
      k = 0;
    } else {
      k = localCrashDetailBean.y.length;
    }
    x.a("user log size:%d", new Object[] { Integer.valueOf(k) });
    if (paramBoolean) {
      k = 0;
    } else {
      k = 2;
    }
    localCrashDetailBean.b = k;
    localCrashDetailBean.e = this.d.h();
    localCrashDetailBean.f = this.d.j;
    localCrashDetailBean.g = this.d.r();
    localCrashDetailBean.m = this.d.g();
    String str3 = paramThrowable.getClass().getName();
    String str2 = b(paramThrowable, 1000);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    int k = paramThrowable.getStackTrace().length;
    if (paramThrowable.getCause() != null) {
      bool = true;
    } else {
      bool = false;
    }
    x.e("stack frame :%d, has cause %b", new Object[] { Integer.valueOf(k), Boolean.valueOf(bool) });
    if (paramThrowable.getStackTrace().length > 0) {
      str2 = paramThrowable.getStackTrace()[0].toString();
    } else {
      str2 = "";
    }
    for (Object localObject2 = paramThrowable; (localObject2 != null) && (((Throwable)localObject2).getCause() != null); localObject2 = ((Throwable)localObject2).getCause()) {}
    if ((localObject2 != null) && (localObject2 != paramThrowable))
    {
      localCrashDetailBean.n = localObject2.getClass().getName();
      localCrashDetailBean.o = b((Throwable)localObject2, 1000);
      if (localCrashDetailBean.o == null) {
        localCrashDetailBean.o = "";
      }
      if (((Throwable)localObject2).getStackTrace().length > 0) {
        localCrashDetailBean.p = localObject2.getStackTrace()[0].toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str3);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append("\n......");
      ((StringBuilder)localObject1).append("\nCaused by:\n");
      ((StringBuilder)localObject1).append(localCrashDetailBean.n);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(localCrashDetailBean.o);
      ((StringBuilder)localObject1).append("\n");
      paramThrowable = a((Throwable)localObject2, c.f);
      ((StringBuilder)localObject1).append(paramThrowable);
      localCrashDetailBean.q = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localCrashDetailBean.n = str3;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append((String)localObject1);
      localCrashDetailBean.o = ((StringBuilder)localObject2).toString();
      if (localCrashDetailBean.o == null) {
        localCrashDetailBean.o = "";
      }
      localCrashDetailBean.p = str2;
      paramThrowable = a(paramThrowable, c.f);
      localCrashDetailBean.q = paramThrowable;
    }
    localCrashDetailBean.r = System.currentTimeMillis();
    localCrashDetailBean.u = z.a(localCrashDetailBean.q.getBytes());
    for (;;)
    {
      try
      {
        localCrashDetailBean.z = z.a(c.f, false);
        localCrashDetailBean.A = this.d.d;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramThread.getName());
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append(paramThread.getId());
        ((StringBuilder)localObject1).append(")");
        localCrashDetailBean.B = ((StringBuilder)localObject1).toString();
        localCrashDetailBean.z.put(localCrashDetailBean.B, paramThrowable);
        localCrashDetailBean.I = this.d.t();
        localCrashDetailBean.h = this.d.q();
        localCrashDetailBean.i = this.d.C();
        localCrashDetailBean.M = this.d.a;
        localCrashDetailBean.N = this.d.a();
        if (paramBoolean)
        {
          this.b.d(localCrashDetailBean);
        }
        else
        {
          if ((paramString == null) || (paramString.length() <= 0)) {
            break label1039;
          }
          k = 1;
          if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
            break label1045;
          }
          m = 1;
          if (k != 0)
          {
            localCrashDetailBean.O = new HashMap(1);
            localCrashDetailBean.O.put("UserData", paramString);
          }
          if (m != 0) {
            localCrashDetailBean.U = paramArrayOfByte;
          }
        }
        localCrashDetailBean.Q = this.d.A();
        localCrashDetailBean.R = this.d.B();
        localCrashDetailBean.S = this.d.u();
        localCrashDetailBean.T = this.d.z();
        return localCrashDetailBean;
      }
      finally
      {
        x.e("handle crash error %s", new Object[] { paramThread.toString() });
        return localCrashDetailBean;
      }
      label1039:
      k = 0;
      continue;
      label1045:
      int m = 0;
    }
  }
  
  private static String b(Throwable paramThrowable, int paramInt)
  {
    if (paramThrowable.getMessage() == null) {
      return "";
    }
    if (paramThrowable.getMessage().length() <= 1000) {
      return paramThrowable.getMessage();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.getMessage().substring(0, 1000));
    localStringBuilder.append("\n[Message over limit size:1000");
    localStringBuilder.append(", has been cutted!]");
    return localStringBuilder.toString();
  }
  
  public final void a()
  {
    try
    {
      if (this.j >= 10)
      {
        x.a("java crash handler over %d, no need set.", new Object[] { Integer.valueOf(10) });
        return;
      }
      this.g = true;
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      if (localUncaughtExceptionHandler != null)
      {
        boolean bool = getClass().getName().equals(localUncaughtExceptionHandler.getClass().getName());
        if (bool) {
          return;
        }
        if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(localUncaughtExceptionHandler.getClass().getName()))
        {
          x.a("backup system java handler: %s", new Object[] { localUncaughtExceptionHandler.toString() });
          this.f = localUncaughtExceptionHandler;
          this.e = localUncaughtExceptionHandler;
        }
        else
        {
          x.a("backup java handler: %s", new Object[] { localUncaughtExceptionHandler.toString() });
          this.e = localUncaughtExceptionHandler;
        }
      }
      Thread.setDefaultUncaughtExceptionHandler(this);
      this.j += 1;
      x.a("registered java monitor: %s", new Object[] { toString() });
      return;
    }
    finally {}
  }
  
  public final void a(StrategyBean paramStrategyBean)
  {
    if (paramStrategyBean != null) {
      try
      {
        if (paramStrategyBean.e != this.g)
        {
          x.a("java changed to %b", new Object[] { Boolean.valueOf(paramStrategyBean.e) });
          if (paramStrategyBean.e)
          {
            a();
            return;
          }
          b();
        }
      }
      finally {}
    }
  }
  
  public final void a(Thread paramThread, Throwable paramThrowable, boolean paramBoolean, String paramString, byte[] paramArrayOfByte)
  {
    if (paramBoolean)
    {
      x.e("Java Crash Happen cause by %s(%d)", new Object[] { paramThread.getName(), Long.valueOf(paramThread.getId()) });
      if (a(paramThread))
      {
        x.a("this class has handled this exception", new Object[0]);
        if (this.f != null)
        {
          x.a("call system handler", new Object[0]);
          this.f.uncaughtException(paramThread, paramThrowable);
        }
        else
        {
          x.e("current process die", new Object[0]);
          Process.killProcess(Process.myPid());
          System.exit(1);
        }
      }
    }
    else
    {
      x.e("Java Catch Happen", new Object[0]);
    }
    try
    {
      if (!this.g)
      {
        x.c("Java crash handler is disable. Just return.", new Object[0]);
        if (paramBoolean)
        {
          paramString = this.e;
          if ((paramString != null) && (a(paramString)))
          {
            x.e("sys default last handle start!", new Object[0]);
            this.e.uncaughtException(paramThread, paramThrowable);
            x.e("sys default last handle end!", new Object[0]);
            return;
          }
          if (this.f != null)
          {
            x.e("system handle start!", new Object[0]);
            this.f.uncaughtException(paramThread, paramThrowable);
            x.e("system handle end!", new Object[0]);
            return;
          }
          x.e("crashreport last handle start!", new Object[0]);
          x.e("current process die", new Object[0]);
          Process.killProcess(Process.myPid());
          System.exit(1);
          x.e("crashreport last handle end!", new Object[0]);
        }
        return;
      }
      if (!this.c.b()) {
        x.d("no remote but still store!", new Object[0]);
      }
      boolean bool = this.c.c().e;
      if ((bool) || (!this.c.b())) {
        break label514;
      }
      x.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
      if (!paramBoolean) {
        break label1217;
      }
      paramString = "JAVA_CRASH";
    }
    finally
    {
      for (;;)
      {
        try
        {
          if (!x.a(paramString)) {
            paramString.printStackTrace();
          }
          if (paramBoolean)
          {
            paramString = this.e;
            if ((paramString != null) && (a(paramString)))
            {
              x.e("sys default last handle start!", new Object[0]);
              this.e.uncaughtException(paramThread, paramThrowable);
              x.e("sys default last handle end!", new Object[0]);
              return;
            }
            if (this.f != null)
            {
              x.e("system handle start!", new Object[0]);
              this.f.uncaughtException(paramThread, paramThrowable);
              x.e("system handle end!", new Object[0]);
              return;
            }
            x.e("crashreport last handle start!", new Object[0]);
            x.e("current process die", new Object[0]);
            Process.killProcess(Process.myPid());
            System.exit(1);
            x.e("crashreport last handle end!", new Object[0]);
          }
          return;
        }
        finally
        {
          if (paramBoolean)
          {
            paramArrayOfByte = this.e;
            if ((paramArrayOfByte != null) && (a(paramArrayOfByte)))
            {
              x.e("sys default last handle start!", new Object[0]);
              this.e.uncaughtException(paramThread, paramThrowable);
              x.e("sys default last handle end!", new Object[0]);
            }
            else if (this.f != null)
            {
              x.e("system handle start!", new Object[0]);
              this.f.uncaughtException(paramThread, paramThrowable);
              x.e("system handle end!", new Object[0]);
            }
            else
            {
              x.e("crashreport last handle start!", new Object[0]);
              x.e("current process die", new Object[0]);
              Process.killProcess(Process.myPid());
              System.exit(1);
              x.e("crashreport last handle end!", new Object[0]);
            }
          }
        }
        paramString = "JAVA_CATCH";
      }
    }
    b.a(paramString, z.a(), this.d.d, paramThread.getName(), z.a(paramThrowable), null);
    if (paramBoolean)
    {
      paramString = this.e;
      if ((paramString != null) && (a(paramString)))
      {
        x.e("sys default last handle start!", new Object[0]);
        this.e.uncaughtException(paramThread, paramThrowable);
        x.e("sys default last handle end!", new Object[0]);
        return;
      }
      if (this.f != null)
      {
        x.e("system handle start!", new Object[0]);
        this.f.uncaughtException(paramThread, paramThrowable);
        x.e("system handle end!", new Object[0]);
        return;
      }
      x.e("crashreport last handle start!", new Object[0]);
      x.e("current process die", new Object[0]);
      Process.killProcess(Process.myPid());
      System.exit(1);
      x.e("crashreport last handle end!", new Object[0]);
    }
    return;
    label514:
    paramArrayOfByte = b(paramThread, paramThrowable, paramBoolean, paramString, paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      x.e("pkg crash datas fail!", new Object[0]);
      if (paramBoolean)
      {
        paramString = this.e;
        if ((paramString != null) && (a(paramString)))
        {
          x.e("sys default last handle start!", new Object[0]);
          this.e.uncaughtException(paramThread, paramThrowable);
          x.e("sys default last handle end!", new Object[0]);
          return;
        }
        if (this.f != null)
        {
          x.e("system handle start!", new Object[0]);
          this.f.uncaughtException(paramThread, paramThrowable);
          x.e("system handle end!", new Object[0]);
          return;
        }
        x.e("crashreport last handle start!", new Object[0]);
        x.e("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
        x.e("crashreport last handle end!", new Object[0]);
      }
      return;
    }
    if (paramBoolean) {
      paramString = "JAVA_CRASH";
    } else {
      paramString = "JAVA_CATCH";
    }
    b.a(paramString, z.a(), this.d.d, paramThread.getName(), z.a(paramThrowable), paramArrayOfByte);
    if (!this.b.a(paramArrayOfByte)) {
      this.b.a(paramArrayOfByte, 3000L, paramBoolean);
    }
    if (paramBoolean) {
      this.b.c(paramArrayOfByte);
    }
    if (paramBoolean)
    {
      paramString = this.e;
      if ((paramString != null) && (a(paramString)))
      {
        x.e("sys default last handle start!", new Object[0]);
        this.e.uncaughtException(paramThread, paramThrowable);
        x.e("sys default last handle end!", new Object[0]);
        return;
      }
      if (this.f != null)
      {
        x.e("system handle start!", new Object[0]);
        this.f.uncaughtException(paramThread, paramThrowable);
        x.e("system handle end!", new Object[0]);
        return;
      }
      x.e("crashreport last handle start!", new Object[0]);
      x.e("current process die", new Object[0]);
      Process.killProcess(Process.myPid());
      System.exit(1);
      x.e("crashreport last handle end!", new Object[0]);
      return;
    }
  }
  
  public final void b()
  {
    try
    {
      this.g = false;
      x.a("close java monitor!", new Object[0]);
      if ("bugly".equals(Thread.getDefaultUncaughtExceptionHandler().getClass().getName()))
      {
        x.a("Java monitor to unregister: %s", new Object[] { toString() });
        Thread.setDefaultUncaughtExceptionHandler(this.e);
        this.j -= 1;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    synchronized (i)
    {
      a(paramThread, paramThrowable, true, null, null);
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\crash\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */