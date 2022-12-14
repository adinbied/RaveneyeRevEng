package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class w
{
  private static final AtomicInteger a = new AtomicInteger(1);
  private static w b;
  private ScheduledExecutorService c = null;
  
  protected w()
  {
    ScheduledExecutorService localScheduledExecutorService = Executors.newScheduledThreadPool(3, new ThreadFactory()
    {
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable);
        StringBuilder localStringBuilder = new StringBuilder("BuglyThread-");
        localStringBuilder.append(w.d().getAndIncrement());
        paramAnonymousRunnable.setName(localStringBuilder.toString());
        return paramAnonymousRunnable;
      }
    });
    this.c = localScheduledExecutorService;
    if ((localScheduledExecutorService == null) || (localScheduledExecutorService.isShutdown())) {
      x.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
    }
  }
  
  public static w a()
  {
    try
    {
      if (b == null) {
        b = new w();
      }
      w localw = b;
      return localw;
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 58	com/tencent/bugly/proguard/w:c	()Z
    //   6: ifne +17 -> 23
    //   9: ldc 60
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 50	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   18: pop
    //   19: aload_0
    //   20: monitorexit
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_1
    //   24: ifnonnull +17 -> 41
    //   27: ldc 62
    //   29: iconst_0
    //   30: anewarray 4	java/lang/Object
    //   33: invokestatic 50	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: iconst_0
    //   40: ireturn
    //   41: ldc 64
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_1
    //   50: invokevirtual 68	java/lang/Object:getClass	()Ljava/lang/Class;
    //   53: invokevirtual 74	java/lang/Class:getName	()Ljava/lang/String;
    //   56: aastore
    //   57: invokestatic 76	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_0
    //   62: getfield 27	com/tencent/bugly/proguard/w:c	Ljava/util/concurrent/ScheduledExecutorService;
    //   65: aload_1
    //   66: invokeinterface 80 2 0
    //   71: aload_0
    //   72: monitorexit
    //   73: iconst_1
    //   74: ireturn
    //   75: astore_1
    //   76: getstatic 85	com/tencent/bugly/b:c	Z
    //   79: ifeq +7 -> 86
    //   82: aload_1
    //   83: invokevirtual 90	java/lang/Throwable:printStackTrace	()V
    //   86: aload_0
    //   87: monitorexit
    //   88: iconst_0
    //   89: ireturn
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	w
    //   0	95	1	paramRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   61	71	75	finally
    //   2	19	90	finally
    //   27	37	90	finally
    //   41	61	90	finally
    //   76	86	90	finally
  }
  
  /* Error */
  public final boolean a(Runnable paramRunnable, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 58	com/tencent/bugly/proguard/w:c	()Z
    //   6: ifne +17 -> 23
    //   9: ldc 60
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 50	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   18: pop
    //   19: aload_0
    //   20: monitorexit
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_1
    //   24: ifnonnull +17 -> 41
    //   27: ldc 62
    //   29: iconst_0
    //   30: anewarray 4	java/lang/Object
    //   33: invokestatic 50	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: iconst_0
    //   40: ireturn
    //   41: lload_2
    //   42: lconst_0
    //   43: lcmp
    //   44: ifle +6 -> 50
    //   47: goto +5 -> 52
    //   50: lconst_0
    //   51: lstore_2
    //   52: ldc 93
    //   54: iconst_2
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: lload_2
    //   61: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: aload_1
    //   68: invokevirtual 68	java/lang/Object:getClass	()Ljava/lang/Class;
    //   71: invokevirtual 74	java/lang/Class:getName	()Ljava/lang/String;
    //   74: aastore
    //   75: invokestatic 76	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   78: pop
    //   79: aload_0
    //   80: getfield 27	com/tencent/bugly/proguard/w:c	Ljava/util/concurrent/ScheduledExecutorService;
    //   83: aload_1
    //   84: lload_2
    //   85: getstatic 105	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   88: invokeinterface 109 5 0
    //   93: pop
    //   94: aload_0
    //   95: monitorexit
    //   96: iconst_1
    //   97: ireturn
    //   98: astore_1
    //   99: getstatic 85	com/tencent/bugly/b:c	Z
    //   102: ifeq +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 90	java/lang/Throwable:printStackTrace	()V
    //   109: aload_0
    //   110: monitorexit
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	w
    //   0	118	1	paramRunnable	Runnable
    //   0	118	2	paramLong	long
    // Exception table:
    //   from	to	target	type
    //   79	94	98	finally
    //   2	19	113	finally
    //   27	37	113	finally
    //   52	79	113	finally
    //   99	109	113	finally
  }
  
  public final void b()
  {
    try
    {
      if ((this.c != null) && (!this.c.isShutdown()))
      {
        x.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
        this.c.shutdownNow();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/bugly/proguard/w:c	Ljava/util/concurrent/ScheduledExecutorService;
    //   6: ifnull +23 -> 29
    //   9: aload_0
    //   10: getfield 27	com/tencent/bugly/proguard/w:c	Ljava/util/concurrent/ScheduledExecutorService;
    //   13: invokeinterface 42 1 0
    //   18: istore_1
    //   19: iload_1
    //   20: ifne +9 -> 29
    //   23: iconst_1
    //   24: istore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_1
    //   31: goto -6 -> 25
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	w
    //   18	13	1	bool	boolean
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	34	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */