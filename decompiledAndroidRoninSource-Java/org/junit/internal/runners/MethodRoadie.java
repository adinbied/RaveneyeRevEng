package org.junit.internal.runners;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.TestTimedOutException;

@Deprecated
public class MethodRoadie
{
  private final Description description;
  private final RunNotifier notifier;
  private final Object test;
  private TestMethod testMethod;
  
  public MethodRoadie(Object paramObject, TestMethod paramTestMethod, RunNotifier paramRunNotifier, Description paramDescription)
  {
    this.test = paramObject;
    this.notifier = paramRunNotifier;
    this.description = paramDescription;
    this.testMethod = paramTestMethod;
  }
  
  /* Error */
  private void runAfters()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 32	org/junit/internal/runners/MethodRoadie:testMethod	Lorg/junit/internal/runners/TestMethod;
    //   4: invokevirtual 42	org/junit/internal/runners/TestMethod:getAfters	()Ljava/util/List;
    //   7: invokeinterface 48 1 0
    //   12: astore_1
    //   13: aload_1
    //   14: invokeinterface 54 1 0
    //   19: ifeq +50 -> 69
    //   22: aload_1
    //   23: invokeinterface 58 1 0
    //   28: checkcast 60	java/lang/reflect/Method
    //   31: astore_2
    //   32: aload_2
    //   33: aload_0
    //   34: getfield 26	org/junit/internal/runners/MethodRoadie:test	Ljava/lang/Object;
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokevirtual 64	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: goto -32 -> 13
    //   48: astore_2
    //   49: aload_0
    //   50: aload_2
    //   51: invokevirtual 68	org/junit/internal/runners/MethodRoadie:addFailure	(Ljava/lang/Throwable;)V
    //   54: goto -41 -> 13
    //   57: astore_2
    //   58: aload_0
    //   59: aload_2
    //   60: invokevirtual 72	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   63: invokevirtual 68	org/junit/internal/runners/MethodRoadie:addFailure	(Ljava/lang/Throwable;)V
    //   66: goto -53 -> 13
    //   69: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	MethodRoadie
    //   12	11	1	localIterator	java.util.Iterator
    //   31	2	2	localMethod	java.lang.reflect.Method
    //   48	3	2	localThrowable	Throwable
    //   57	3	2	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    // Exception table:
    //   from	to	target	type
    //   32	45	48	finally
    //   32	45	57	java/lang/reflect/InvocationTargetException
  }
  
  /* Error */
  private void runBefores()
    throws FailedBefore
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 32	org/junit/internal/runners/MethodRoadie:testMethod	Lorg/junit/internal/runners/TestMethod;
    //   4: invokevirtual 80	org/junit/internal/runners/TestMethod:getBefores	()Ljava/util/List;
    //   7: invokeinterface 48 1 0
    //   12: astore_1
    //   13: aload_1
    //   14: invokeinterface 54 1 0
    //   19: ifeq +27 -> 46
    //   22: aload_1
    //   23: invokeinterface 58 1 0
    //   28: checkcast 60	java/lang/reflect/Method
    //   31: aload_0
    //   32: getfield 26	org/junit/internal/runners/MethodRoadie:test	Ljava/lang/Object;
    //   35: iconst_0
    //   36: anewarray 4	java/lang/Object
    //   39: invokevirtual 64	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   42: pop
    //   43: goto -30 -> 13
    //   46: return
    //   47: astore_1
    //   48: goto +9 -> 57
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 72	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   56: athrow
    //   57: aload_0
    //   58: aload_1
    //   59: invokevirtual 68	org/junit/internal/runners/MethodRoadie:addFailure	(Ljava/lang/Throwable;)V
    //   62: new 75	org/junit/internal/runners/FailedBefore
    //   65: dup
    //   66: invokespecial 81	org/junit/internal/runners/FailedBefore:<init>	()V
    //   69: athrow
    //   70: new 75	org/junit/internal/runners/FailedBefore
    //   73: dup
    //   74: invokespecial 81	org/junit/internal/runners/FailedBefore:<init>	()V
    //   77: athrow
    //   78: astore_1
    //   79: goto -9 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	MethodRoadie
    //   12	11	1	localIterator	java.util.Iterator
    //   47	1	1	localObject	Object
    //   51	8	1	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   78	1	1	localAssumptionViolatedException	org.junit.internal.AssumptionViolatedException
    // Exception table:
    //   from	to	target	type
    //   0	13	47	finally
    //   13	43	47	finally
    //   52	57	47	finally
    //   0	13	51	java/lang/reflect/InvocationTargetException
    //   13	43	51	java/lang/reflect/InvocationTargetException
    //   0	13	78	org/junit/internal/AssumptionViolatedException
    //   13	43	78	org/junit/internal/AssumptionViolatedException
    //   52	57	78	org/junit/internal/AssumptionViolatedException
  }
  
  private void runWithTimeout(final long paramLong)
  {
    runBeforesThenTestThenAfters(new Runnable()
    {
      public void run()
      {
        ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
        Future localFuture = localExecutorService.submit(new Callable()
        {
          public Object call()
            throws Exception
          {
            MethodRoadie.this.runTestMethod();
            return null;
          }
        });
        localExecutorService.shutdown();
        try
        {
          if (!localExecutorService.awaitTermination(paramLong, TimeUnit.MILLISECONDS)) {
            localExecutorService.shutdownNow();
          }
          localFuture.get(0L, TimeUnit.MILLISECONDS);
          return;
        }
        catch (Exception localException)
        {
          MethodRoadie.this.addFailure(localException);
          return;
          MethodRoadie.this.addFailure(new TestTimedOutException(paramLong, TimeUnit.MILLISECONDS));
          return;
        }
        catch (TimeoutException localTimeoutException)
        {
          for (;;) {}
        }
      }
    });
  }
  
  protected void addFailure(Throwable paramThrowable)
  {
    this.notifier.fireTestFailure(new Failure(this.description, paramThrowable));
  }
  
  public void run()
  {
    if (this.testMethod.isIgnored())
    {
      this.notifier.fireTestIgnored(this.description);
      return;
    }
    this.notifier.fireTestStarted(this.description);
    try
    {
      long l = this.testMethod.getTimeout();
      if (l > 0L) {
        runWithTimeout(l);
      } else {
        runTest();
      }
      return;
    }
    finally
    {
      this.notifier.fireTestFinished(this.description);
    }
  }
  
  public void runBeforesThenTestThenAfters(Runnable paramRunnable)
  {
    try
    {
      try
      {
        runBefores();
        paramRunnable.run();
      }
      finally
      {
        break label27;
      }
    }
    catch (FailedBefore paramRunnable)
    {
      for (;;) {}
    }
    catch (Exception paramRunnable)
    {
      label27:
      for (;;) {}
    }
    throw new RuntimeException("test should never throw an exception to this level");
    runAfters();
    throw paramRunnable;
    runAfters();
  }
  
  public void runTest()
  {
    runBeforesThenTestThenAfters(new Runnable()
    {
      public void run()
      {
        MethodRoadie.this.runTestMethod();
      }
    });
  }
  
  /* Error */
  protected void runTestMethod()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 32	org/junit/internal/runners/MethodRoadie:testMethod	Lorg/junit/internal/runners/TestMethod;
    //   4: aload_0
    //   5: getfield 26	org/junit/internal/runners/MethodRoadie:test	Ljava/lang/Object;
    //   8: invokevirtual 149	org/junit/internal/runners/TestMethod:invoke	(Ljava/lang/Object;)V
    //   11: aload_0
    //   12: getfield 32	org/junit/internal/runners/MethodRoadie:testMethod	Lorg/junit/internal/runners/TestMethod;
    //   15: invokevirtual 152	org/junit/internal/runners/TestMethod:expectsException	()Z
    //   18: ifeq +169 -> 187
    //   21: new 154	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   28: astore_1
    //   29: aload_1
    //   30: ldc -99
    //   32: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_1
    //   37: aload_0
    //   38: getfield 32	org/junit/internal/runners/MethodRoadie:testMethod	Lorg/junit/internal/runners/TestMethod;
    //   41: invokevirtual 165	org/junit/internal/runners/TestMethod:getExpectedException	()Ljava/lang/Class;
    //   44: invokevirtual 171	java/lang/Class:getName	()Ljava/lang/String;
    //   47: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_0
    //   52: new 173	java/lang/AssertionError
    //   55: dup
    //   56: aload_1
    //   57: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokespecial 178	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   63: invokevirtual 68	org/junit/internal/runners/MethodRoadie:addFailure	(Ljava/lang/Throwable;)V
    //   66: return
    //   67: astore_1
    //   68: aload_0
    //   69: aload_1
    //   70: invokevirtual 68	org/junit/internal/runners/MethodRoadie:addFailure	(Ljava/lang/Throwable;)V
    //   73: return
    //   74: astore_1
    //   75: aload_1
    //   76: invokevirtual 72	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   79: astore_1
    //   80: aload_1
    //   81: instanceof 77
    //   84: ifeq +4 -> 88
    //   87: return
    //   88: aload_0
    //   89: getfield 32	org/junit/internal/runners/MethodRoadie:testMethod	Lorg/junit/internal/runners/TestMethod;
    //   92: invokevirtual 152	org/junit/internal/runners/TestMethod:expectsException	()Z
    //   95: ifne +9 -> 104
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 68	org/junit/internal/runners/MethodRoadie:addFailure	(Ljava/lang/Throwable;)V
    //   103: return
    //   104: aload_0
    //   105: getfield 32	org/junit/internal/runners/MethodRoadie:testMethod	Lorg/junit/internal/runners/TestMethod;
    //   108: aload_1
    //   109: invokevirtual 182	org/junit/internal/runners/TestMethod:isUnexpected	(Ljava/lang/Throwable;)Z
    //   112: ifeq +75 -> 187
    //   115: new 154	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   122: astore_2
    //   123: aload_2
    //   124: ldc -72
    //   126: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_2
    //   131: aload_0
    //   132: getfield 32	org/junit/internal/runners/MethodRoadie:testMethod	Lorg/junit/internal/runners/TestMethod;
    //   135: invokevirtual 165	org/junit/internal/runners/TestMethod:getExpectedException	()Ljava/lang/Class;
    //   138: invokevirtual 171	java/lang/Class:getName	()Ljava/lang/String;
    //   141: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_2
    //   146: ldc -70
    //   148: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_2
    //   153: aload_1
    //   154: invokevirtual 189	java/lang/Object:getClass	()Ljava/lang/Class;
    //   157: invokevirtual 171	java/lang/Class:getName	()Ljava/lang/String;
    //   160: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_2
    //   165: ldc -65
    //   167: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_0
    //   172: new 127	java/lang/Exception
    //   175: dup
    //   176: aload_2
    //   177: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: aload_1
    //   181: invokespecial 194	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: invokevirtual 68	org/junit/internal/runners/MethodRoadie:addFailure	(Ljava/lang/Throwable;)V
    //   187: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	MethodRoadie
    //   28	29	1	localStringBuilder1	StringBuilder
    //   67	3	1	localThrowable1	Throwable
    //   74	2	1	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   79	102	1	localThrowable2	Throwable
    //   122	55	2	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	66	67	finally
    //   0	66	74	java/lang/reflect/InvocationTargetException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\runners\MethodRoadie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */