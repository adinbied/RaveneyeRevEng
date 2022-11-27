package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy.a;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static int a = 0;
  public static boolean b = false;
  public static int c = 2;
  public static boolean d = true;
  public static int e = 20480;
  public static int f = 20480;
  public static long g = 604800000L;
  public static String h;
  public static boolean i = false;
  public static String j;
  public static int k = 5000;
  public static boolean l = true;
  public static boolean m;
  public static String n;
  public static String o;
  private static c r;
  public final b p;
  private final Context q;
  private final e s;
  private final NativeCrashHandler t;
  private com.tencent.bugly.crashreport.common.strategy.a u;
  private w v;
  private final com.tencent.bugly.crashreport.crash.anr.b w;
  private Boolean x;
  private int y = 31;
  private boolean z = false;
  
  private c(int paramInt, Context paramContext, w paramw, boolean paramBoolean, BuglyStrategy.a parama, o paramo, String paramString)
  {
    a = paramInt;
    paramContext = z.a(paramContext);
    this.q = paramContext;
    this.u = com.tencent.bugly.crashreport.common.strategy.a.a();
    this.v = paramw;
    u localu = u.a();
    p localp = p.a();
    this.p = new b(paramInt, paramContext, localu, localp, this.u, parama, paramo);
    paramo = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    this.s = new e(paramContext, this.p, this.u, paramo);
    paramString = NativeCrashHandler.getInstance(paramContext, paramo, this.p, this.u, paramw, paramBoolean, paramString);
    this.t = paramString;
    paramo.D = paramString;
    this.w = com.tencent.bugly.crashreport.crash.anr.b.a(paramContext, this.u, paramo, paramw, localp, this.p, parama);
  }
  
  public static c a()
  {
    try
    {
      c localc = r;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static c a(int paramInt, Context paramContext, boolean paramBoolean, BuglyStrategy.a parama, o paramo, String paramString)
  {
    try
    {
      if (r == null) {
        r = new c(1004, paramContext, w.a(), paramBoolean, parama, null, null);
      }
      paramContext = r;
      return paramContext;
    }
    finally {}
  }
  
  public final void a(int paramInt)
  {
    this.y = paramInt;
  }
  
  public final void a(long paramLong)
  {
    w.a().a(new Thread()
    {
      public final void run()
      {
        boolean bool = z.a(c.b(c.this), "local_crash_lock", 10000L);
        int i = 0;
        if (!bool)
        {
          x.c("Failed to lock file for uploading local crash.", new Object[0]);
          return;
        }
        Object localObject = c.this.p.a();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          x.c("Size of crash list: %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
          int j = ((List)localObject).size();
          if (j > 20L)
          {
            ArrayList localArrayList = new ArrayList();
            Collections.sort((List)localObject);
            while (i < 20L)
            {
              localArrayList.add(((List)localObject).get(j - 1 - i));
              i += 1;
            }
            localObject = localArrayList;
          }
          c.this.p.a((List)localObject, 0L, false, false, false);
        }
        else
        {
          x.c("no crash need to be uploaded at this start", new Object[0]);
        }
        z.b(c.b(c.this), "local_crash_lock");
      }
    }, paramLong);
  }
  
  public final void a(StrategyBean paramStrategyBean)
  {
    this.s.a(paramStrategyBean);
    this.t.onStrategyChanged(paramStrategyBean);
    this.w.c();
    w.a().a(new Thread()
    {
      public final void run()
      {
        boolean bool = z.a(c.b(c.this), "local_crash_lock", 10000L);
        int i = 0;
        if (!bool)
        {
          x.c("Failed to lock file for uploading local crash.", new Object[0]);
          return;
        }
        Object localObject = c.this.p.a();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          x.c("Size of crash list: %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
          int j = ((List)localObject).size();
          if (j > 20L)
          {
            ArrayList localArrayList = new ArrayList();
            Collections.sort((List)localObject);
            while (i < 20L)
            {
              localArrayList.add(((List)localObject).get(j - 1 - i));
              i += 1;
            }
            localObject = localArrayList;
          }
          c.this.p.a((List)localObject, 0L, false, false, false);
        }
        else
        {
          x.c("no crash need to be uploaded at this start", new Object[0]);
        }
        z.b(c.b(c.this), "local_crash_lock");
      }
    }, 3000L);
  }
  
  public final void a(CrashDetailBean paramCrashDetailBean)
  {
    this.p.e(paramCrashDetailBean);
  }
  
  public final void a(final Thread paramThread, final Throwable paramThrowable, boolean paramBoolean1, String paramString, byte[] paramArrayOfByte, final boolean paramBoolean2)
  {
    this.v.a(new Runnable()
    {
      public final void run()
      {
        try
        {
          x.c("post a throwable %b", new Object[] { Boolean.valueOf(this.a) });
          c.a(c.this).a(paramThread, paramThrowable, false, this.d, this.e);
          if (paramBoolean2)
          {
            x.a("clear user datas", new Object[0]);
            com.tencent.bugly.crashreport.common.info.a.a(c.b(c.this)).v();
          }
          return;
        }
        finally
        {
          if (x.b(localThrowable) != true) {
            localThrowable.printStackTrace();
          }
          x.e("java catch error: %s", new Object[] { paramThrowable.toString() });
        }
      }
    });
  }
  
  public final void a(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      this.t.testNativeCrash(paramBoolean1, paramBoolean2, paramBoolean3);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean b()
  {
    Object localObject1 = this.x;
    if (localObject1 != null) {
      return ((Boolean)localObject1).booleanValue();
    }
    localObject1 = com.tencent.bugly.crashreport.common.info.a.b().d;
    Object localObject2 = p.a().a(1);
    ArrayList localArrayList = new ArrayList();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        r localr = (r)((Iterator)localObject2).next();
        if (((String)localObject1).equals(localr.c))
        {
          this.x = Boolean.valueOf(true);
          localArrayList.add(localr);
        }
      }
      if (localArrayList.size() > 0) {
        p.a().a(localArrayList);
      }
      return true;
    }
    this.x = Boolean.valueOf(false);
    return false;
  }
  
  public final void c()
  {
    try
    {
      this.s.a();
      this.t.setUserOpened(true);
      this.w.a(true);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void d()
  {
    try
    {
      this.s.b();
      this.t.setUserOpened(false);
      this.w.a(false);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void e()
  {
    this.s.b();
  }
  
  public final void f()
  {
    this.s.a();
  }
  
  public final void g()
  {
    this.t.setUserOpened(false);
  }
  
  public final void h()
  {
    this.t.setUserOpened(true);
  }
  
  public final void i()
  {
    this.w.a(true);
  }
  
  public final void j()
  {
    this.w.a(false);
  }
  
  public final void k()
  {
    this.t.enableCatchAnrTrace();
  }
  
  /* Error */
  public final void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_1
    //   4: iload_1
    //   5: iconst_1
    //   6: iadd
    //   7: istore_2
    //   8: iload_1
    //   9: bipush 30
    //   11: if_icmpge +51 -> 62
    //   14: ldc -7
    //   16: iconst_1
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: iload_2
    //   23: invokestatic 254	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: invokestatic 259	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   30: pop
    //   31: ldc2_w 260
    //   34: invokestatic 263	com/tencent/bugly/proguard/z:b	(J)V
    //   37: iload_2
    //   38: istore_1
    //   39: goto -35 -> 4
    //   42: astore_3
    //   43: aload_3
    //   44: invokestatic 266	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   47: ifne +7 -> 54
    //   50: aload_3
    //   51: invokevirtual 271	java/lang/Throwable:printStackTrace	()V
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: astore_3
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_3
    //   61: athrow
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	c
    //   3	36	1	i1	int
    //   7	31	2	i2	int
    //   42	9	3	localThrowable	Throwable
    //   57	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	37	42	finally
    //   43	54	57	finally
  }
  
  public final boolean m()
  {
    return this.w.a();
  }
  
  public final void n()
  {
    this.t.checkUploadRecordCrash();
  }
  
  public final void o()
  {
    if (com.tencent.bugly.crashreport.common.info.a.b().d.equals(AppInfo.a(this.q))) {
      this.t.removeEmptyNativeRecordFiles();
    }
  }
  
  public final boolean p()
  {
    return this.z;
  }
  
  public final boolean q()
  {
    return (this.y & 0x10) > 0;
  }
  
  public final boolean r()
  {
    return (this.y & 0x8) > 0;
  }
  
  public final boolean s()
  {
    return (this.y & 0x4) > 0;
  }
  
  public final boolean t()
  {
    return (this.y & 0x2) > 0;
  }
  
  public final boolean u()
  {
    return (this.y & 0x1) > 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\crash\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */