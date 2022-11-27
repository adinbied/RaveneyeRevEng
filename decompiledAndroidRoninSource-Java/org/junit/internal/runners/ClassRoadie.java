package org.junit.internal.runners;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

@Deprecated
public class ClassRoadie
{
  private Description description;
  private RunNotifier notifier;
  private final Runnable runnable;
  private TestClass testClass;
  
  public ClassRoadie(RunNotifier paramRunNotifier, TestClass paramTestClass, Description paramDescription, Runnable paramRunnable)
  {
    this.notifier = paramRunNotifier;
    this.testClass = paramTestClass;
    this.description = paramDescription;
    this.runnable = paramRunnable;
  }
  
  /* Error */
  private void runAfters()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	org/junit/internal/runners/ClassRoadie:testClass	Lorg/junit/internal/runners/TestClass;
    //   4: invokevirtual 36	org/junit/internal/runners/TestClass:getAfters	()Ljava/util/List;
    //   7: invokeinterface 42 1 0
    //   12: astore_1
    //   13: aload_1
    //   14: invokeinterface 48 1 0
    //   19: ifeq +47 -> 66
    //   22: aload_1
    //   23: invokeinterface 52 1 0
    //   28: checkcast 54	java/lang/reflect/Method
    //   31: astore_2
    //   32: aload_2
    //   33: aconst_null
    //   34: iconst_0
    //   35: anewarray 4	java/lang/Object
    //   38: invokevirtual 58	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: goto -29 -> 13
    //   45: astore_2
    //   46: aload_0
    //   47: aload_2
    //   48: invokevirtual 62	org/junit/internal/runners/ClassRoadie:addFailure	(Ljava/lang/Throwable;)V
    //   51: goto -38 -> 13
    //   54: astore_2
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 66	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   60: invokevirtual 62	org/junit/internal/runners/ClassRoadie:addFailure	(Ljava/lang/Throwable;)V
    //   63: goto -50 -> 13
    //   66: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	ClassRoadie
    //   12	11	1	localIterator	java.util.Iterator
    //   31	2	2	localMethod	java.lang.reflect.Method
    //   45	3	2	localThrowable	Throwable
    //   54	3	2	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    // Exception table:
    //   from	to	target	type
    //   32	42	45	finally
    //   32	42	54	java/lang/reflect/InvocationTargetException
  }
  
  /* Error */
  private void runBefores()
    throws FailedBefore
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	org/junit/internal/runners/ClassRoadie:testClass	Lorg/junit/internal/runners/TestClass;
    //   4: invokevirtual 74	org/junit/internal/runners/TestClass:getBefores	()Ljava/util/List;
    //   7: invokeinterface 42 1 0
    //   12: astore_1
    //   13: aload_1
    //   14: invokeinterface 48 1 0
    //   19: ifeq +24 -> 43
    //   22: aload_1
    //   23: invokeinterface 52 1 0
    //   28: checkcast 54	java/lang/reflect/Method
    //   31: aconst_null
    //   32: iconst_0
    //   33: anewarray 4	java/lang/Object
    //   36: invokevirtual 58	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   39: pop
    //   40: goto -27 -> 13
    //   43: return
    //   44: astore_1
    //   45: goto +9 -> 54
    //   48: astore_1
    //   49: aload_1
    //   50: invokevirtual 66	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   53: athrow
    //   54: aload_0
    //   55: aload_1
    //   56: invokevirtual 62	org/junit/internal/runners/ClassRoadie:addFailure	(Ljava/lang/Throwable;)V
    //   59: new 69	org/junit/internal/runners/FailedBefore
    //   62: dup
    //   63: invokespecial 75	org/junit/internal/runners/FailedBefore:<init>	()V
    //   66: athrow
    //   67: new 69	org/junit/internal/runners/FailedBefore
    //   70: dup
    //   71: invokespecial 75	org/junit/internal/runners/FailedBefore:<init>	()V
    //   74: athrow
    //   75: astore_1
    //   76: goto -9 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ClassRoadie
    //   12	11	1	localIterator	java.util.Iterator
    //   44	1	1	localObject	Object
    //   48	8	1	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   75	1	1	localAssumptionViolatedException	org.junit.internal.AssumptionViolatedException
    // Exception table:
    //   from	to	target	type
    //   0	13	44	finally
    //   13	40	44	finally
    //   49	54	44	finally
    //   0	13	48	java/lang/reflect/InvocationTargetException
    //   13	40	48	java/lang/reflect/InvocationTargetException
    //   0	13	75	org/junit/internal/AssumptionViolatedException
    //   13	40	75	org/junit/internal/AssumptionViolatedException
    //   49	54	75	org/junit/internal/AssumptionViolatedException
  }
  
  protected void addFailure(Throwable paramThrowable)
  {
    this.notifier.fireTestFailure(new Failure(this.description, paramThrowable));
  }
  
  /* Error */
  public void runProtected()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 90	org/junit/internal/runners/ClassRoadie:runBefores	()V
    //   4: aload_0
    //   5: invokevirtual 93	org/junit/internal/runners/ClassRoadie:runUnprotected	()V
    //   8: goto +10 -> 18
    //   11: astore_1
    //   12: aload_0
    //   13: invokespecial 95	org/junit/internal/runners/ClassRoadie:runAfters	()V
    //   16: aload_1
    //   17: athrow
    //   18: aload_0
    //   19: invokespecial 95	org/junit/internal/runners/ClassRoadie:runAfters	()V
    //   22: return
    //   23: astore_1
    //   24: goto -6 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	ClassRoadie
    //   11	6	1	localObject	Object
    //   23	1	1	localFailedBefore	FailedBefore
    // Exception table:
    //   from	to	target	type
    //   0	8	11	finally
    //   0	8	23	org/junit/internal/runners/FailedBefore
  }
  
  protected void runUnprotected()
  {
    this.runnable.run();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\runners\ClassRoadie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */