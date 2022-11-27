package org.junit.internal.runners.statements;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestTimedOutException;

public class FailOnTimeout
  extends Statement
{
  private final boolean lookForStuckThread;
  private final Statement originalStatement;
  private volatile ThreadGroup threadGroup = null;
  private final TimeUnit timeUnit;
  private final long timeout;
  
  private FailOnTimeout(Builder paramBuilder, Statement paramStatement)
  {
    this.originalStatement = paramStatement;
    this.timeout = paramBuilder.timeout;
    this.timeUnit = paramBuilder.unit;
    this.lookForStuckThread = paramBuilder.lookForStuckThread;
  }
  
  @Deprecated
  public FailOnTimeout(Statement paramStatement, long paramLong)
  {
    this(builder().withTimeout(paramLong, TimeUnit.MILLISECONDS), paramStatement);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  private Thread[] copyThreads(Thread[] paramArrayOfThread, int paramInt)
  {
    int i = Math.min(paramInt, paramArrayOfThread.length);
    Thread[] arrayOfThread = new Thread[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfThread[paramInt] = paramArrayOfThread[paramInt];
      paramInt += 1;
    }
    return arrayOfThread;
  }
  
  private long cpuTime(Thread paramThread)
  {
    ThreadMXBean localThreadMXBean = ManagementFactory.getThreadMXBean();
    if (localThreadMXBean.isThreadCpuTimeSupported()) {}
    try
    {
      long l = localThreadMXBean.getThreadCpuTime(paramThread.getId());
      return l;
    }
    catch (UnsupportedOperationException paramThread)
    {
      for (;;) {}
    }
    return 0L;
  }
  
  private Exception createTimeoutException(Thread paramThread)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramThread.getStackTrace();
    Thread localThread;
    if (this.lookForStuckThread) {
      localThread = getStuckThread(paramThread);
    } else {
      localThread = null;
    }
    TestTimedOutException localTestTimedOutException = new TestTimedOutException(this.timeout, this.timeUnit);
    if (arrayOfStackTraceElement != null)
    {
      localTestTimedOutException.setStackTrace(arrayOfStackTraceElement);
      paramThread.interrupt();
    }
    if (localThread != null)
    {
      paramThread = new StringBuilder();
      paramThread.append("Appears to be stuck in thread ");
      paramThread.append(localThread.getName());
      paramThread = new Exception(paramThread.toString());
      paramThread.setStackTrace(getStackTrace(localThread));
      return new MultipleFailureException(Arrays.asList(new Throwable[] { localTestTimedOutException, paramThread }));
    }
    return localTestTimedOutException;
  }
  
  private Throwable getResult(FutureTask<Throwable> paramFutureTask, Thread paramThread)
  {
    try
    {
      if (this.timeout > 0L) {
        return (Throwable)paramFutureTask.get(this.timeout, this.timeUnit);
      }
      paramFutureTask = (Throwable)paramFutureTask.get();
      return paramFutureTask;
    }
    catch (ExecutionException paramFutureTask)
    {
      return paramFutureTask.getCause();
    }
    catch (InterruptedException paramFutureTask)
    {
      return paramFutureTask;
    }
    catch (TimeoutException paramFutureTask)
    {
      for (;;) {}
    }
    return createTimeoutException(paramThread);
  }
  
  private StackTraceElement[] getStackTrace(Thread paramThread)
  {
    try
    {
      paramThread = paramThread.getStackTrace();
      return paramThread;
    }
    catch (SecurityException paramThread)
    {
      for (;;) {}
    }
    return new StackTraceElement[0];
  }
  
  private Thread getStuckThread(Thread paramThread)
  {
    if (this.threadGroup == null) {
      return null;
    }
    Thread[] arrayOfThread = getThreadArray(this.threadGroup);
    if (arrayOfThread == null) {
      return null;
    }
    long l1 = 0L;
    int j = arrayOfThread.length;
    int i = 0;
    Object localObject2;
    for (Object localObject1 = null; i < j; localObject1 = localObject2)
    {
      Thread localThread = arrayOfThread[i];
      long l2 = l1;
      localObject2 = localObject1;
      if (localThread.getState() == Thread.State.RUNNABLE)
      {
        long l3 = cpuTime(localThread);
        if (localObject1 != null)
        {
          l2 = l1;
          localObject2 = localObject1;
          if (l3 <= l1) {}
        }
        else
        {
          localObject2 = localThread;
          l2 = l3;
        }
      }
      i += 1;
      l1 = l2;
    }
    if (localObject1 == paramThread) {
      return null;
    }
    return (Thread)localObject1;
  }
  
  private Thread[] getThreadArray(ThreadGroup paramThreadGroup)
  {
    int j = Math.max(paramThreadGroup.activeCount() * 2, 100);
    int i = 0;
    int k;
    do
    {
      Thread[] arrayOfThread = new Thread[j];
      k = paramThreadGroup.enumerate(arrayOfThread);
      if (k < j) {
        return copyThreads(arrayOfThread, k);
      }
      j += 100;
      k = i + 1;
      i = k;
    } while (k < 5);
    return null;
  }
  
  public void evaluate()
    throws Throwable
  {
    Object localObject = new CallableStatement(null);
    FutureTask localFutureTask = new FutureTask((Callable)localObject);
    this.threadGroup = new ThreadGroup("FailOnTimeoutGroup");
    Thread localThread = new Thread(this.threadGroup, localFutureTask, "Time-limited test");
    localThread.setDaemon(true);
    localThread.start();
    ((CallableStatement)localObject).awaitStarted();
    localObject = getResult(localFutureTask, localThread);
    if (localObject == null) {
      return;
    }
    throw ((Throwable)localObject);
  }
  
  public static class Builder
  {
    private boolean lookForStuckThread = false;
    private long timeout = 0L;
    private TimeUnit unit = TimeUnit.SECONDS;
    
    public FailOnTimeout build(Statement paramStatement)
    {
      if (paramStatement != null) {
        return new FailOnTimeout(this, paramStatement, null);
      }
      throw new NullPointerException("statement cannot be null");
    }
    
    public Builder withLookingForStuckThread(boolean paramBoolean)
    {
      this.lookForStuckThread = paramBoolean;
      return this;
    }
    
    public Builder withTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong >= 0L)
      {
        if (paramTimeUnit != null)
        {
          this.timeout = paramLong;
          this.unit = paramTimeUnit;
          return this;
        }
        throw new NullPointerException("TimeUnit cannot be null");
      }
      throw new IllegalArgumentException("timeout must be non-negative");
    }
  }
  
  private class CallableStatement
    implements Callable<Throwable>
  {
    private final CountDownLatch startLatch = new CountDownLatch(1);
    
    private CallableStatement() {}
    
    public void awaitStarted()
      throws InterruptedException
    {
      this.startLatch.await();
    }
    
    /* Error */
    public Throwable call()
      throws Exception
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 28	org/junit/internal/runners/statements/FailOnTimeout$CallableStatement:startLatch	Ljava/util/concurrent/CountDownLatch;
      //   4: invokevirtual 49	java/util/concurrent/CountDownLatch:countDown	()V
      //   7: aload_0
      //   8: getfield 18	org/junit/internal/runners/statements/FailOnTimeout$CallableStatement:this$0	Lorg/junit/internal/runners/statements/FailOnTimeout;
      //   11: invokestatic 53	org/junit/internal/runners/statements/FailOnTimeout:access$600	(Lorg/junit/internal/runners/statements/FailOnTimeout;)Lorg/junit/runners/model/Statement;
      //   14: invokevirtual 58	org/junit/runners/model/Statement:evaluate	()V
      //   17: aconst_null
      //   18: areturn
      //   19: astore_1
      //   20: aload_1
      //   21: areturn
      //   22: astore_1
      //   23: aload_1
      //   24: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	25	0	this	CallableStatement
      //   19	2	1	localThrowable	Throwable
      //   22	2	1	localException	Exception
      // Exception table:
      //   from	to	target	type
      //   0	17	19	finally
      //   0	17	22	java/lang/Exception
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\runners\statements\FailOnTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */