package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

@Metadata(bv={1, 0, 3}, d1={"\000J\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\004\n\002\020!\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\t\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\020 \n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\r\030\000 #2\0020\001:\003\"#$B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\f\020\023\032\b\022\004\022\0020\t0\024J\030\020\025\032\0020\0262\006\020\027\032\0020\0302\006\020\031\032\0020\rH\002J\b\020\032\032\004\030\0010\030J\020\020\033\032\0020\0262\006\020\027\032\0020\030H\002J\b\020\034\032\0020\026H\002J\025\020\035\032\0020\0262\006\020\036\032\0020\tH\000¢\006\002\b\037J\006\020 \032\0020\tJ\020\020!\032\0020\0262\006\020\027\032\0020\030H\002R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006R\024\020\007\032\b\022\004\022\0020\t0\bX\004¢\006\002\n\000R\016\020\n\032\0020\013X\016¢\006\002\n\000R\016\020\f\032\0020\rX\016¢\006\002\n\000R\016\020\016\032\0020\017X\016¢\006\002\n\000R\024\020\020\032\b\022\004\022\0020\t0\bX\004¢\006\002\n\000R\016\020\021\032\0020\022X\004¢\006\002\n\000¨\006%"}, d2={"Lokhttp3/internal/concurrent/TaskRunner;", "", "backend", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "(Lokhttp3/internal/concurrent/TaskRunner$Backend;)V", "getBackend", "()Lokhttp3/internal/concurrent/TaskRunner$Backend;", "busyQueues", "", "Lokhttp3/internal/concurrent/TaskQueue;", "coordinatorWaiting", "", "coordinatorWakeUpAt", "", "nextQueueName", "", "readyQueues", "runnable", "Ljava/lang/Runnable;", "activeQueues", "", "afterRun", "", "task", "Lokhttp3/internal/concurrent/Task;", "delayNanos", "awaitTaskToRun", "beforeRun", "cancelAll", "kickCoordinator", "taskQueue", "kickCoordinator$okhttp", "newQueue", "runTask", "Backend", "Companion", "RealBackend", "okhttp"}, k=1, mv={1, 1, 16})
public final class TaskRunner
{
  public static final Companion Companion = new Companion(null);
  public static final TaskRunner INSTANCE;
  private static final Logger logger;
  private final Backend backend;
  private final List<TaskQueue> busyQueues;
  private boolean coordinatorWaiting;
  private long coordinatorWakeUpAt;
  private int nextQueueName;
  private final List<TaskQueue> readyQueues;
  private final Runnable runnable;
  
  static
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Util.okHttpName);
    ((StringBuilder)localObject).append(" TaskRunner");
    INSTANCE = new TaskRunner((Backend)new RealBackend(Util.threadFactory(((StringBuilder)localObject).toString(), true)));
    localObject = Logger.getLogger(TaskRunner.class.getName());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Logger.getLogger(TaskRunner::class.java.name)");
    logger = (Logger)localObject;
  }
  
  public TaskRunner(Backend paramBackend)
  {
    this.backend = paramBackend;
    this.nextQueueName = 10000;
    this.busyQueues = ((List)new ArrayList());
    this.readyQueues = ((List)new ArrayList());
    this.runnable = ((Runnable)new Runnable()
    {
      public void run()
      {
        Task localTask;
        long l1;
        boolean bool;
        Object localObject3;
        long l2;
        StringBuilder localStringBuilder;
        synchronized (this.this$0)
        {
          localTask = this.this$0.awaitTaskToRun();
          if (localTask != null)
          {
            ??? = localTask.getQueue$okhttp();
            if (??? == null) {
              Intrinsics.throwNpe();
            }
            l1 = -1L;
            bool = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
            if (bool)
            {
              l1 = ((TaskQueue)???).getTaskRunner$okhttp().getBackend().nanoTime();
              TaskLoggerKt.access$log(localTask, (TaskQueue)???, "starting");
            }
          }
        }
      }
    });
  }
  
  private final void afterRun(Task paramTask, long paramLong)
  {
    if ((Util.assertionsEnabled) && (!Thread.holdsLock(this)))
    {
      paramTask = new StringBuilder();
      paramTask.append("Thread ");
      localObject = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Thread.currentThread()");
      paramTask.append(((Thread)localObject).getName());
      paramTask.append(" MUST hold lock on ");
      paramTask.append(this);
      throw ((Throwable)new AssertionError(paramTask.toString()));
    }
    Object localObject = paramTask.getQueue$okhttp();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    int i;
    if (((TaskQueue)localObject).getActiveTask$okhttp() == paramTask) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      boolean bool = ((TaskQueue)localObject).getCancelActiveTask$okhttp();
      ((TaskQueue)localObject).setCancelActiveTask$okhttp(false);
      ((TaskQueue)localObject).setActiveTask$okhttp((Task)null);
      this.busyQueues.remove(localObject);
      if ((paramLong != -1L) && (!bool) && (!((TaskQueue)localObject).getShutdown$okhttp())) {
        ((TaskQueue)localObject).scheduleAndDecide$okhttp(paramTask, paramLong, true);
      }
      if ((((Collection)((TaskQueue)localObject).getFutureTasks$okhttp()).isEmpty() ^ true)) {
        this.readyQueues.add(localObject);
      }
      return;
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
  }
  
  private final void beforeRun(Task paramTask)
  {
    if ((Util.assertionsEnabled) && (!Thread.holdsLock(this)))
    {
      paramTask = new StringBuilder();
      paramTask.append("Thread ");
      localObject = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Thread.currentThread()");
      paramTask.append(((Thread)localObject).getName());
      paramTask.append(" MUST hold lock on ");
      paramTask.append(this);
      throw ((Throwable)new AssertionError(paramTask.toString()));
    }
    paramTask.setNextExecuteNanoTime$okhttp(-1L);
    Object localObject = paramTask.getQueue$okhttp();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((TaskQueue)localObject).getFutureTasks$okhttp().remove(paramTask);
    this.readyQueues.remove(localObject);
    ((TaskQueue)localObject).setActiveTask$okhttp(paramTask);
    this.busyQueues.add(localObject);
  }
  
  private final void cancelAll()
  {
    int i = this.busyQueues.size() - 1;
    while (i >= 0)
    {
      ((TaskQueue)this.readyQueues.get(i)).cancelAllAndDecide$okhttp();
      i -= 1;
    }
    i = this.readyQueues.size() - 1;
    while (i >= 0)
    {
      TaskQueue localTaskQueue = (TaskQueue)this.readyQueues.get(i);
      localTaskQueue.cancelAllAndDecide$okhttp();
      if (localTaskQueue.getFutureTasks$okhttp().isEmpty()) {
        this.readyQueues.remove(i);
      }
      i -= 1;
    }
  }
  
  /* Error */
  private final void runTask(Task paramTask)
  {
    // Byte code:
    //   0: getstatic 161	okhttp3/internal/Util:assertionsEnabled	Z
    //   3: ifeq +79 -> 82
    //   6: aload_0
    //   7: invokestatic 167	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifne +6 -> 16
    //   13: goto +69 -> 82
    //   16: new 74	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   23: astore_1
    //   24: aload_1
    //   25: ldc -87
    //   27: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   34: astore 4
    //   36: aload 4
    //   38: ldc -81
    //   40: invokestatic 122	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   43: aload_1
    //   44: aload 4
    //   46: invokevirtual 176	java/lang/Thread:getName	()Ljava/lang/String;
    //   49: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_1
    //   54: ldc_w 266
    //   57: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_1
    //   62: aload_0
    //   63: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: new 183	java/lang/AssertionError
    //   70: dup
    //   71: aload_1
    //   72: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokespecial 186	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   78: checkcast 188	java/lang/Throwable
    //   81: athrow
    //   82: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   85: astore 4
    //   87: aload 4
    //   89: ldc_w 267
    //   92: invokestatic 122	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   95: aload 4
    //   97: invokevirtual 176	java/lang/Thread:getName	()Ljava/lang/String;
    //   100: astore 5
    //   102: aload 4
    //   104: aload_1
    //   105: invokevirtual 268	okhttp3/internal/concurrent/Task:getName	()Ljava/lang/String;
    //   108: invokevirtual 271	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   111: aload_1
    //   112: invokevirtual 275	okhttp3/internal/concurrent/Task:runOnce	()J
    //   115: lstore_2
    //   116: aload_0
    //   117: monitorenter
    //   118: aload_0
    //   119: aload_1
    //   120: lload_2
    //   121: invokespecial 277	okhttp3/internal/concurrent/TaskRunner:afterRun	(Lokhttp3/internal/concurrent/Task;J)V
    //   124: getstatic 282	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload 4
    //   132: aload 5
    //   134: invokevirtual 271	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   137: return
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    //   143: astore 6
    //   145: aload_0
    //   146: monitorenter
    //   147: aload_0
    //   148: aload_1
    //   149: ldc2_w 218
    //   152: invokespecial 277	okhttp3/internal/concurrent/TaskRunner:afterRun	(Lokhttp3/internal/concurrent/Task;J)V
    //   155: getstatic 282	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: aload 4
    //   163: aload 5
    //   165: invokevirtual 271	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   168: aload 6
    //   170: athrow
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	TaskRunner
    //   0	176	1	paramTask	Task
    //   115	6	2	l	long
    //   34	128	4	localThread	Thread
    //   100	64	5	str	String
    //   143	26	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   118	128	138	finally
    //   111	116	143	finally
    //   147	159	171	finally
  }
  
  public final List<TaskQueue> activeQueues()
  {
    try
    {
      List localList = CollectionsKt.plus((Collection)this.busyQueues, (Iterable)this.readyQueues);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final Task awaitTaskToRun()
  {
    // Byte code:
    //   0: getstatic 161	okhttp3/internal/Util:assertionsEnabled	Z
    //   3: ifeq +84 -> 87
    //   6: aload_0
    //   7: invokestatic 167	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +6 -> 16
    //   13: goto +74 -> 87
    //   16: new 74	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   23: astore 8
    //   25: aload 8
    //   27: ldc -87
    //   29: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   36: astore 9
    //   38: aload 9
    //   40: ldc -81
    //   42: invokestatic 122	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   45: aload 8
    //   47: aload 9
    //   49: invokevirtual 176	java/lang/Thread:getName	()Ljava/lang/String;
    //   52: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 8
    //   58: ldc -78
    //   60: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 8
    //   66: aload_0
    //   67: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: new 183	java/lang/AssertionError
    //   74: dup
    //   75: aload 8
    //   77: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 186	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   83: checkcast 188	java/lang/Throwable
    //   86: athrow
    //   87: aload_0
    //   88: getfield 143	okhttp3/internal/concurrent/TaskRunner:readyQueues	Ljava/util/List;
    //   91: invokeinterface 262 1 0
    //   96: ifeq +5 -> 101
    //   99: aconst_null
    //   100: areturn
    //   101: aload_0
    //   102: getfield 132	okhttp3/internal/concurrent/TaskRunner:backend	Lokhttp3/internal/concurrent/TaskRunner$Backend;
    //   105: invokeinterface 297 1 0
    //   110: lstore 4
    //   112: ldc2_w 298
    //   115: lstore_2
    //   116: aconst_null
    //   117: checkcast 190	okhttp3/internal/concurrent/Task
    //   120: astore 8
    //   122: aload_0
    //   123: getfield 143	okhttp3/internal/concurrent/TaskRunner:readyQueues	Ljava/util/List;
    //   126: invokeinterface 303 1 0
    //   131: astore 10
    //   133: aload 10
    //   135: invokeinterface 308 1 0
    //   140: ifeq +75 -> 215
    //   143: aload 10
    //   145: invokeinterface 312 1 0
    //   150: checkcast 199	okhttp3/internal/concurrent/TaskQueue
    //   153: invokevirtual 230	okhttp3/internal/concurrent/TaskQueue:getFutureTasks$okhttp	()Ljava/util/List;
    //   156: iconst_0
    //   157: invokeinterface 258 2 0
    //   162: checkcast 190	okhttp3/internal/concurrent/Task
    //   165: astore 9
    //   167: lconst_0
    //   168: aload 9
    //   170: invokevirtual 315	okhttp3/internal/concurrent/Task:getNextExecuteNanoTime$okhttp	()J
    //   173: lload 4
    //   175: lsub
    //   176: invokestatic 321	java/lang/Math:max	(JJ)J
    //   179: lstore 6
    //   181: lload 6
    //   183: lconst_0
    //   184: lcmp
    //   185: ifle +13 -> 198
    //   188: lload 6
    //   190: lload_2
    //   191: invokestatic 324	java/lang/Math:min	(JJ)J
    //   194: lstore_2
    //   195: goto -62 -> 133
    //   198: aload 8
    //   200: ifnull +8 -> 208
    //   203: iconst_1
    //   204: istore_1
    //   205: goto +12 -> 217
    //   208: aload 9
    //   210: astore 8
    //   212: goto -79 -> 133
    //   215: iconst_0
    //   216: istore_1
    //   217: aload 8
    //   219: ifnull +53 -> 272
    //   222: aload_0
    //   223: aload 8
    //   225: invokespecial 326	okhttp3/internal/concurrent/TaskRunner:beforeRun	(Lokhttp3/internal/concurrent/Task;)V
    //   228: iload_1
    //   229: ifne +27 -> 256
    //   232: aload_0
    //   233: getfield 328	okhttp3/internal/concurrent/TaskRunner:coordinatorWaiting	Z
    //   236: ifne +33 -> 269
    //   239: aload_0
    //   240: getfield 143	okhttp3/internal/concurrent/TaskRunner:readyQueues	Ljava/util/List;
    //   243: checkcast 232	java/util/Collection
    //   246: invokeinterface 235 1 0
    //   251: iconst_1
    //   252: ixor
    //   253: ifeq +16 -> 269
    //   256: aload_0
    //   257: getfield 132	okhttp3/internal/concurrent/TaskRunner:backend	Lokhttp3/internal/concurrent/TaskRunner$Backend;
    //   260: aload_0
    //   261: getfield 150	okhttp3/internal/concurrent/TaskRunner:runnable	Ljava/lang/Runnable;
    //   264: invokeinterface 332 2 0
    //   269: aload 8
    //   271: areturn
    //   272: aload_0
    //   273: getfield 328	okhttp3/internal/concurrent/TaskRunner:coordinatorWaiting	Z
    //   276: ifeq +27 -> 303
    //   279: lload_2
    //   280: aload_0
    //   281: getfield 334	okhttp3/internal/concurrent/TaskRunner:coordinatorWakeUpAt	J
    //   284: lload 4
    //   286: lsub
    //   287: lcmp
    //   288: ifge +13 -> 301
    //   291: aload_0
    //   292: getfield 132	okhttp3/internal/concurrent/TaskRunner:backend	Lokhttp3/internal/concurrent/TaskRunner$Backend;
    //   295: aload_0
    //   296: invokeinterface 337 2 0
    //   301: aconst_null
    //   302: areturn
    //   303: aload_0
    //   304: iconst_1
    //   305: putfield 328	okhttp3/internal/concurrent/TaskRunner:coordinatorWaiting	Z
    //   308: aload_0
    //   309: lload 4
    //   311: lload_2
    //   312: ladd
    //   313: putfield 334	okhttp3/internal/concurrent/TaskRunner:coordinatorWakeUpAt	J
    //   316: aload_0
    //   317: getfield 132	okhttp3/internal/concurrent/TaskRunner:backend	Lokhttp3/internal/concurrent/TaskRunner$Backend;
    //   320: aload_0
    //   321: lload_2
    //   322: invokeinterface 341 4 0
    //   327: aload_0
    //   328: iconst_0
    //   329: putfield 328	okhttp3/internal/concurrent/TaskRunner:coordinatorWaiting	Z
    //   332: goto -245 -> 87
    //   335: astore 8
    //   337: goto +10 -> 347
    //   340: aload_0
    //   341: invokespecial 343	okhttp3/internal/concurrent/TaskRunner:cancelAll	()V
    //   344: goto -17 -> 327
    //   347: aload_0
    //   348: iconst_0
    //   349: putfield 328	okhttp3/internal/concurrent/TaskRunner:coordinatorWaiting	Z
    //   352: aload 8
    //   354: athrow
    //   355: astore 8
    //   357: goto -17 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	TaskRunner
    //   204	25	1	i	int
    //   115	207	2	l1	long
    //   110	200	4	l2	long
    //   179	10	6	l3	long
    //   23	247	8	localObject1	Object
    //   335	18	8	localObject2	Object
    //   355	1	8	localInterruptedException	InterruptedException
    //   36	173	9	localObject3	Object
    //   131	13	10	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   316	327	335	finally
    //   340	344	335	finally
    //   316	327	355	java/lang/InterruptedException
  }
  
  public final Backend getBackend()
  {
    return this.backend;
  }
  
  public final void kickCoordinator$okhttp(TaskQueue paramTaskQueue)
  {
    Intrinsics.checkParameterIsNotNull(paramTaskQueue, "taskQueue");
    if ((Util.assertionsEnabled) && (!Thread.holdsLock(this)))
    {
      paramTaskQueue = new StringBuilder();
      paramTaskQueue.append("Thread ");
      Thread localThread = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
      paramTaskQueue.append(localThread.getName());
      paramTaskQueue.append(" MUST hold lock on ");
      paramTaskQueue.append(this);
      throw ((Throwable)new AssertionError(paramTaskQueue.toString()));
    }
    if (paramTaskQueue.getActiveTask$okhttp() == null) {
      if ((((Collection)paramTaskQueue.getFutureTasks$okhttp()).isEmpty() ^ true)) {
        Util.addIfAbsent(this.readyQueues, paramTaskQueue);
      } else {
        this.readyQueues.remove(paramTaskQueue);
      }
    }
    if (this.coordinatorWaiting)
    {
      this.backend.coordinatorNotify(this);
      return;
    }
    this.backend.execute(this.runnable);
  }
  
  public final TaskQueue newQueue()
  {
    try
    {
      int i = this.nextQueueName;
      this.nextQueueName = (i + 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('Q');
      localStringBuilder.append(i);
      return new TaskQueue(this, localStringBuilder.toString());
    }
    finally {}
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000(\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\003\n\002\020\t\n\002\b\002\n\002\030\002\n\002\b\002\bf\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\005H&J\020\020\006\032\0020\0032\006\020\004\032\0020\005H&J\030\020\007\032\0020\0032\006\020\004\032\0020\0052\006\020\b\032\0020\tH&J\020\020\n\032\0020\0032\006\020\013\032\0020\fH&J\b\020\r\032\0020\tH&¨\006\016"}, d2={"Lokhttp3/internal/concurrent/TaskRunner$Backend;", "", "beforeTask", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", "", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "okhttp"}, k=1, mv={1, 1, 16})
  public static abstract interface Backend
  {
    public abstract void beforeTask(TaskRunner paramTaskRunner);
    
    public abstract void coordinatorNotify(TaskRunner paramTaskRunner);
    
    public abstract void coordinatorWait(TaskRunner paramTaskRunner, long paramLong);
    
    public abstract void execute(Runnable paramRunnable);
    
    public abstract long nanoTime();
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\032\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000R\021\020\005\032\0020\006¢\006\b\n\000\032\004\b\007\020\b¨\006\t"}, d2={"Lokhttp3/internal/concurrent/TaskRunner$Companion;", "", "()V", "INSTANCE", "Lokhttp3/internal/concurrent/TaskRunner;", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final Logger getLogger()
    {
      return TaskRunner.access$getLogger$cp();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0006\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\003\n\002\020\t\n\002\b\002\n\002\030\002\n\002\b\003\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\007\032\0020\b2\006\020\t\032\0020\nH\026J\020\020\013\032\0020\b2\006\020\t\032\0020\nH\026J\030\020\f\032\0020\b2\006\020\t\032\0020\n2\006\020\r\032\0020\016H\026J\020\020\017\032\0020\b2\006\020\020\032\0020\021H\026J\b\020\022\032\0020\016H\026J\006\020\023\032\0020\bR\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\024"}, d2={"Lokhttp3/internal/concurrent/TaskRunner$RealBackend;", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(Ljava/util/concurrent/ThreadFactory;)V", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "beforeTask", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", "", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "shutdown", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class RealBackend
    implements TaskRunner.Backend
  {
    private final ThreadPoolExecutor executor;
    
    public RealBackend(ThreadFactory paramThreadFactory)
    {
      this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), paramThreadFactory);
    }
    
    public void beforeTask(TaskRunner paramTaskRunner)
    {
      Intrinsics.checkParameterIsNotNull(paramTaskRunner, "taskRunner");
    }
    
    public void coordinatorNotify(TaskRunner paramTaskRunner)
    {
      Intrinsics.checkParameterIsNotNull(paramTaskRunner, "taskRunner");
      ((Object)paramTaskRunner).notify();
    }
    
    public void coordinatorWait(TaskRunner paramTaskRunner, long paramLong)
      throws InterruptedException
    {
      Intrinsics.checkParameterIsNotNull(paramTaskRunner, "taskRunner");
      long l = paramLong / 1000000L;
      if ((l > 0L) || (paramLong > 0L)) {
        ((Object)paramTaskRunner).wait(l, (int)(paramLong - 1000000L * l));
      }
    }
    
    public void execute(Runnable paramRunnable)
    {
      Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
      this.executor.execute(paramRunnable);
    }
    
    public long nanoTime()
    {
      return System.nanoTime();
    }
    
    public final void shutdown()
    {
      this.executor.shutdown();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\concurrent\TaskRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */