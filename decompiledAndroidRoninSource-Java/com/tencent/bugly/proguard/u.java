package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public final class u
{
  private static u a;
  private final p b;
  private final Context c;
  private Map<Integer, Long> d = new HashMap();
  private long e;
  private long f;
  private LinkedBlockingQueue<Runnable> g = new LinkedBlockingQueue();
  private LinkedBlockingQueue<Runnable> h = new LinkedBlockingQueue();
  private final Object i = new Object();
  private int j = 0;
  
  private u(Context paramContext)
  {
    this.c = paramContext;
    this.b = p.a();
  }
  
  public static u a()
  {
    try
    {
      u localu = a;
      return localu;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static u a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new u(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (paramRunnable == null) {
      x.d("[UploadManager] Upload task should not be null", new Object[0]);
    }
    x.c("[UploadManager] Add upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    if (paramBoolean2)
    {
      if (paramRunnable == null)
      {
        x.d("[UploadManager] Upload task should not be null", new Object[0]);
        return;
      }
      x.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      Thread localThread = z.a(paramRunnable, "BUGLY_SYNC_UPLOAD");
      if (localThread == null)
      {
        x.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
        a(paramRunnable, true);
        return;
      }
      try
      {
        localThread.join(paramLong);
        return;
      }
      finally
      {
        x.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", new Object[] { ((Throwable)localObject).getMessage() });
        a(paramRunnable, true);
        c(0);
        return;
      }
    }
    a(paramRunnable, paramBoolean1);
    c(0);
  }
  
  private boolean a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramRunnable == null)
    {
      x.a("[UploadManager] Upload task should not be null", new Object[0]);
      return false;
    }
    try
    {
      x.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      Object localObject = this.i;
      if (paramBoolean) {}
      try
      {
        this.g.put(paramRunnable);
        break label74;
        this.h.put(paramRunnable);
        label74:
        return true;
      }
      finally {}
      return false;
    }
    finally
    {
      x.e("[UploadManager] Failed to add upload task to queue: %s", new Object[] { paramRunnable.getMessage() });
    }
  }
  
  /* Error */
  private void c(final int paramInt)
  {
    // Byte code:
    //   0: invokestatic 143	com/tencent/bugly/proguard/w:a	()Lcom/tencent/bugly/proguard/w;
    //   3: astore 4
    //   5: new 42	java/util/concurrent/LinkedBlockingQueue
    //   8: dup
    //   9: invokespecial 43	java/util/concurrent/LinkedBlockingQueue:<init>	()V
    //   12: astore 5
    //   14: new 42	java/util/concurrent/LinkedBlockingQueue
    //   17: dup
    //   18: invokespecial 43	java/util/concurrent/LinkedBlockingQueue:<init>	()V
    //   21: astore 6
    //   23: aload_0
    //   24: getfield 49	com/tencent/bugly/proguard/u:i	Ljava/lang/Object;
    //   27: astore 7
    //   29: aload 7
    //   31: monitorenter
    //   32: ldc -111
    //   34: iconst_2
    //   35: anewarray 4	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: invokestatic 83	android/os/Process:myPid	()I
    //   43: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: invokestatic 92	android/os/Process:myTid	()I
    //   52: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: invokestatic 94	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   59: pop
    //   60: aload_0
    //   61: getfield 45	com/tencent/bugly/proguard/u:g	Ljava/util/concurrent/LinkedBlockingQueue;
    //   64: invokevirtual 148	java/util/concurrent/LinkedBlockingQueue:size	()I
    //   67: istore_3
    //   68: aload_0
    //   69: getfield 47	com/tencent/bugly/proguard/u:h	Ljava/util/concurrent/LinkedBlockingQueue;
    //   72: invokevirtual 148	java/util/concurrent/LinkedBlockingQueue:size	()I
    //   75: istore_1
    //   76: iload_3
    //   77: ifne +21 -> 98
    //   80: iload_1
    //   81: ifne +17 -> 98
    //   84: ldc -106
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 94	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   93: pop
    //   94: aload 7
    //   96: monitorexit
    //   97: return
    //   98: aload 4
    //   100: ifnull +412 -> 512
    //   103: aload 4
    //   105: invokevirtual 153	com/tencent/bugly/proguard/w:c	()Z
    //   108: ifne +406 -> 514
    //   111: goto +401 -> 512
    //   114: iload_2
    //   115: iload_3
    //   116: if_icmpge +410 -> 526
    //   119: aload_0
    //   120: getfield 45	com/tencent/bugly/proguard/u:g	Ljava/util/concurrent/LinkedBlockingQueue;
    //   123: invokevirtual 157	java/util/concurrent/LinkedBlockingQueue:peek	()Ljava/lang/Object;
    //   126: checkcast 159	java/lang/Runnable
    //   129: astore 8
    //   131: aload 8
    //   133: ifnull +393 -> 526
    //   136: aload 5
    //   138: aload 8
    //   140: invokevirtual 135	java/util/concurrent/LinkedBlockingQueue:put	(Ljava/lang/Object;)V
    //   143: aload_0
    //   144: getfield 45	com/tencent/bugly/proguard/u:g	Ljava/util/concurrent/LinkedBlockingQueue;
    //   147: invokevirtual 162	java/util/concurrent/LinkedBlockingQueue:poll	()Ljava/lang/Object;
    //   150: pop
    //   151: goto +368 -> 519
    //   154: astore 8
    //   156: ldc -92
    //   158: iconst_1
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload 8
    //   166: invokevirtual 124	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   169: aastore
    //   170: invokestatic 107	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   173: pop
    //   174: goto +345 -> 519
    //   177: iload_2
    //   178: iload_1
    //   179: if_icmpge +61 -> 240
    //   182: aload_0
    //   183: getfield 47	com/tencent/bugly/proguard/u:h	Ljava/util/concurrent/LinkedBlockingQueue;
    //   186: invokevirtual 157	java/util/concurrent/LinkedBlockingQueue:peek	()Ljava/lang/Object;
    //   189: checkcast 159	java/lang/Runnable
    //   192: astore 8
    //   194: aload 8
    //   196: ifnull +44 -> 240
    //   199: aload 6
    //   201: aload 8
    //   203: invokevirtual 135	java/util/concurrent/LinkedBlockingQueue:put	(Ljava/lang/Object;)V
    //   206: aload_0
    //   207: getfield 47	com/tencent/bugly/proguard/u:h	Ljava/util/concurrent/LinkedBlockingQueue;
    //   210: invokevirtual 162	java/util/concurrent/LinkedBlockingQueue:poll	()Ljava/lang/Object;
    //   213: pop
    //   214: goto +317 -> 531
    //   217: astore 8
    //   219: ldc -92
    //   221: iconst_1
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: aload 8
    //   229: invokevirtual 124	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   232: aastore
    //   233: invokestatic 107	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   236: pop
    //   237: goto +294 -> 531
    //   240: aload 7
    //   242: monitorexit
    //   243: iload_3
    //   244: ifle +38 -> 282
    //   247: ldc -90
    //   249: iconst_3
    //   250: anewarray 4	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: iload_3
    //   256: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: aastore
    //   260: dup
    //   261: iconst_1
    //   262: invokestatic 83	android/os/Process:myPid	()I
    //   265: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   268: aastore
    //   269: dup
    //   270: iconst_2
    //   271: invokestatic 92	android/os/Process:myTid	()I
    //   274: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: aastore
    //   278: invokestatic 94	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   281: pop
    //   282: iconst_0
    //   283: istore_2
    //   284: iload_2
    //   285: iload_3
    //   286: if_icmpge +156 -> 442
    //   289: aload 5
    //   291: invokevirtual 162	java/util/concurrent/LinkedBlockingQueue:poll	()Ljava/lang/Object;
    //   294: checkcast 159	java/lang/Runnable
    //   297: astore 8
    //   299: aload 8
    //   301: ifnull +141 -> 442
    //   304: aload_0
    //   305: getfield 49	com/tencent/bugly/proguard/u:i	Ljava/lang/Object;
    //   308: astore 7
    //   310: aload 7
    //   312: monitorenter
    //   313: aload_0
    //   314: getfield 51	com/tencent/bugly/proguard/u:j	I
    //   317: iconst_2
    //   318: if_icmplt +22 -> 340
    //   321: aload 4
    //   323: ifnull +17 -> 340
    //   326: aload 4
    //   328: aload 8
    //   330: invokevirtual 169	com/tencent/bugly/proguard/w:a	(Ljava/lang/Runnable;)Z
    //   333: pop
    //   334: aload 7
    //   336: monitorexit
    //   337: goto +90 -> 427
    //   340: aload 7
    //   342: monitorexit
    //   343: ldc -85
    //   345: iconst_1
    //   346: anewarray 4	java/lang/Object
    //   349: dup
    //   350: iconst_0
    //   351: ldc -83
    //   353: aastore
    //   354: invokestatic 129	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   357: pop
    //   358: new 6	com/tencent/bugly/proguard/u$1
    //   361: dup
    //   362: aload_0
    //   363: aload 8
    //   365: invokespecial 176	com/tencent/bugly/proguard/u$1:<init>	(Lcom/tencent/bugly/proguard/u;Ljava/lang/Runnable;)V
    //   368: ldc -83
    //   370: invokestatic 103	com/tencent/bugly/proguard/z:a	(Ljava/lang/Runnable;Ljava/lang/String;)Ljava/lang/Thread;
    //   373: ifnull +36 -> 409
    //   376: aload_0
    //   377: getfield 49	com/tencent/bugly/proguard/u:i	Ljava/lang/Object;
    //   380: astore 7
    //   382: aload 7
    //   384: monitorenter
    //   385: aload_0
    //   386: aload_0
    //   387: getfield 51	com/tencent/bugly/proguard/u:j	I
    //   390: iconst_1
    //   391: iadd
    //   392: putfield 51	com/tencent/bugly/proguard/u:j	I
    //   395: aload 7
    //   397: monitorexit
    //   398: goto +29 -> 427
    //   401: astore 4
    //   403: aload 7
    //   405: monitorexit
    //   406: aload 4
    //   408: athrow
    //   409: ldc -78
    //   411: iconst_0
    //   412: anewarray 4	java/lang/Object
    //   415: invokestatic 75	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   418: pop
    //   419: aload_0
    //   420: aload 8
    //   422: iconst_1
    //   423: invokespecial 110	com/tencent/bugly/proguard/u:a	(Ljava/lang/Runnable;Z)Z
    //   426: pop
    //   427: iload_2
    //   428: iconst_1
    //   429: iadd
    //   430: istore_2
    //   431: goto -147 -> 284
    //   434: astore 4
    //   436: aload 7
    //   438: monitorexit
    //   439: aload 4
    //   441: athrow
    //   442: iload_1
    //   443: ifle +38 -> 481
    //   446: ldc -76
    //   448: iconst_3
    //   449: anewarray 4	java/lang/Object
    //   452: dup
    //   453: iconst_0
    //   454: iload_1
    //   455: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   458: aastore
    //   459: dup
    //   460: iconst_1
    //   461: invokestatic 83	android/os/Process:myPid	()I
    //   464: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   467: aastore
    //   468: dup
    //   469: iconst_2
    //   470: invokestatic 92	android/os/Process:myTid	()I
    //   473: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   476: aastore
    //   477: invokestatic 94	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   480: pop
    //   481: aload 4
    //   483: ifnull +20 -> 503
    //   486: aload 4
    //   488: new 8	com/tencent/bugly/proguard/u$2
    //   491: dup
    //   492: aload_0
    //   493: iload_1
    //   494: aload 6
    //   496: invokespecial 183	com/tencent/bugly/proguard/u$2:<init>	(Lcom/tencent/bugly/proguard/u;ILjava/util/concurrent/LinkedBlockingQueue;)V
    //   499: invokevirtual 169	com/tencent/bugly/proguard/w:a	(Ljava/lang/Runnable;)Z
    //   502: pop
    //   503: return
    //   504: astore 4
    //   506: aload 7
    //   508: monitorexit
    //   509: aload 4
    //   511: athrow
    //   512: iconst_0
    //   513: istore_1
    //   514: iconst_0
    //   515: istore_2
    //   516: goto -402 -> 114
    //   519: iload_2
    //   520: iconst_1
    //   521: iadd
    //   522: istore_2
    //   523: goto -409 -> 114
    //   526: iconst_0
    //   527: istore_2
    //   528: goto -351 -> 177
    //   531: iload_2
    //   532: iconst_1
    //   533: iadd
    //   534: istore_2
    //   535: goto -358 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	this	u
    //   0	538	1	paramInt	int
    //   114	421	2	k	int
    //   67	220	3	m	int
    //   3	324	4	localw	w
    //   401	6	4	localObject1	Object
    //   434	53	4	localObject2	Object
    //   504	6	4	localObject3	Object
    //   12	278	5	localLinkedBlockingQueue1	LinkedBlockingQueue
    //   21	474	6	localLinkedBlockingQueue2	LinkedBlockingQueue
    //   129	10	8	localRunnable1	Runnable
    //   154	11	8	localObject5	Object
    //   192	10	8	localRunnable2	Runnable
    //   217	11	8	localObject6	Object
    //   297	124	8	localRunnable3	Runnable
    // Exception table:
    //   from	to	target	type
    //   136	151	154	finally
    //   199	214	217	finally
    //   385	398	401	finally
    //   313	321	434	finally
    //   326	337	434	finally
    //   32	76	504	finally
    //   84	97	504	finally
    //   103	111	504	finally
    //   119	131	504	finally
    //   156	174	504	finally
    //   182	194	504	finally
    //   219	237	504	finally
    //   240	243	504	finally
  }
  
  public final long a(int paramInt)
  {
    if (paramInt >= 0) {}
    try
    {
      Long localLong = (Long)this.d.get(Integer.valueOf(paramInt));
      if (localLong != null)
      {
        long l = localLong.longValue();
        return l;
        x.e("[UploadManager] Unknown upload ID: %d", new Object[] { Integer.valueOf(paramInt) });
      }
      return 0L;
    }
    finally {}
  }
  
  public final long a(boolean paramBoolean)
  {
    long l4 = z.b();
    int k;
    if (paramBoolean) {
      k = 5;
    } else {
      k = 3;
    }
    List localList = this.b.a(k);
    long l2;
    long l1;
    if ((localList != null) && (localList.size() > 0))
    {
      long l3 = 0L;
      l2 = l3;
      try
      {
        r localr = (r)localList.get(0);
        l2 = l3;
        l1 = l3;
        if (localr.e >= l4)
        {
          l2 = l3;
          l1 = z.b(localr.g);
          if (k == 3)
          {
            l2 = l1;
            this.e = l1;
          }
          else
          {
            l2 = l1;
            this.f = l1;
          }
          l2 = l1;
          localList.remove(localr);
        }
      }
      finally
      {
        x.a(localThrowable);
        l1 = l2;
      }
      l2 = l1;
      if (localList.size() > 0)
      {
        this.b.a(localList);
        l2 = l1;
      }
    }
    else
    {
      if (paramBoolean) {
        l1 = this.f;
      } else {
        l1 = this.e;
      }
      l2 = l1;
    }
    x.c("[UploadManager] Local network consume: %d KB", new Object[] { Long.valueOf(l2 / 1024L) });
    return l2;
  }
  
  public final void a(int paramInt, long paramLong)
  {
    if (paramInt >= 0) {}
    try
    {
      this.d.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
      r localr = new r();
      localr.b = paramInt;
      localr.e = paramLong;
      localr.c = "";
      localr.d = "";
      localr.g = new byte[0];
      this.b.b(paramInt);
      this.b.a(localr);
      x.c("[UploadManager] Uploading(ID:%d) time: %s", new Object[] { Integer.valueOf(paramInt), z.a(paramLong) });
      return;
    }
    finally {}
    x.e("[UploadManager] Unknown uploading ID: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  /* Error */
  public final void a(int arg1, am arg2, String arg3, String arg4, t arg5, long arg6, boolean arg8)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 271	com/tencent/bugly/proguard/am:g	I
    //   4: istore 9
    //   6: aload_2
    //   7: invokestatic 276	com/tencent/bugly/proguard/a:a	(Ljava/lang/Object;)[B
    //   10: astore_2
    //   11: aload_0
    //   12: new 278	com/tencent/bugly/proguard/v
    //   15: dup
    //   16: aload_0
    //   17: getfield 53	com/tencent/bugly/proguard/u:c	Landroid/content/Context;
    //   20: iload_1
    //   21: iload 9
    //   23: aload_2
    //   24: aload_3
    //   25: aload 4
    //   27: aload 5
    //   29: iconst_1
    //   30: iload 8
    //   32: invokespecial 281	com/tencent/bugly/proguard/v:<init>	(Landroid/content/Context;II[BLjava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/proguard/t;ZZ)V
    //   35: iconst_1
    //   36: iconst_1
    //   37: lload 6
    //   39: invokespecial 283	com/tencent/bugly/proguard/u:a	(Ljava/lang/Runnable;ZZJ)V
    //   42: return
    //   43: astore_2
    //   44: goto +4 -> 48
    //   47: astore_3
    //   48: aload_2
    //   49: invokestatic 230	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   52: ifne +7 -> 59
    //   55: aload_2
    //   56: invokevirtual 286	java/lang/Throwable:printStackTrace	()V
    //   59: return
    // Exception table:
    //   from	to	target	type
    //   11	42	43	finally
  }
  
  /* Error */
  public final void a(int arg1, am arg2, String arg3, String arg4, t arg5, boolean arg6)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 271	com/tencent/bugly/proguard/am:g	I
    //   4: istore 7
    //   6: aload_2
    //   7: invokestatic 276	com/tencent/bugly/proguard/a:a	(Ljava/lang/Object;)[B
    //   10: astore_2
    //   11: aload_0
    //   12: new 278	com/tencent/bugly/proguard/v
    //   15: dup
    //   16: aload_0
    //   17: getfield 53	com/tencent/bugly/proguard/u:c	Landroid/content/Context;
    //   20: iload_1
    //   21: iload 7
    //   23: aload_2
    //   24: aload_3
    //   25: aload 4
    //   27: aload 5
    //   29: iconst_0
    //   30: iconst_0
    //   31: iconst_0
    //   32: aconst_null
    //   33: invokespecial 290	com/tencent/bugly/proguard/v:<init>	(Landroid/content/Context;II[BLjava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/proguard/t;IIZLjava/util/Map;)V
    //   36: iload 6
    //   38: iconst_0
    //   39: lconst_0
    //   40: invokespecial 283	com/tencent/bugly/proguard/u:a	(Ljava/lang/Runnable;ZZJ)V
    //   43: return
    //   44: astore_2
    //   45: goto +4 -> 49
    //   48: astore_3
    //   49: aload_2
    //   50: invokestatic 230	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   53: ifne +7 -> 60
    //   56: aload_2
    //   57: invokevirtual 286	java/lang/Throwable:printStackTrace	()V
    //   60: return
    // Exception table:
    //   from	to	target	type
    //   11	43	44	finally
  }
  
  protected final void a(long paramLong, boolean paramBoolean)
  {
    int k;
    if (paramBoolean) {
      k = 5;
    } else {
      k = 3;
    }
    try
    {
      r localr = new r();
      localr.b = k;
      localr.e = z.b();
      localr.c = "";
      localr.d = "";
      localr.g = z.c(paramLong);
      this.b.b(k);
      this.b.a(localr);
      if (paramBoolean) {
        this.f = paramLong;
      } else {
        this.e = paramLong;
      }
      x.c("[UploadManager] Network total consume: %d KB", new Object[] { Long.valueOf(paramLong / 1024L) });
      return;
    }
    finally {}
  }
  
  public final boolean b(int paramInt)
  {
    if (b.c)
    {
      x.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
      return true;
    }
    long l = System.currentTimeMillis() - a(paramInt);
    x.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(paramInt) });
    if (l < 30000L)
    {
      x.a("[UploadManager] Data only be uploaded once in %d seconds.", new Object[] { Long.valueOf(30L) });
      return false;
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguar\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */