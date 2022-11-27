package org.junit.rules;

import java.util.List;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract class TestWatcher
  implements TestRule
{
  private void failedQuietly(Throwable paramThrowable, Description paramDescription, List<Throwable> paramList)
  {
    try
    {
      failed(paramThrowable, paramDescription);
      return;
    }
    finally
    {
      paramList.add(paramThrowable);
    }
  }
  
  private void finishedQuietly(Description paramDescription, List<Throwable> paramList)
  {
    try
    {
      finished(paramDescription);
      return;
    }
    finally
    {
      paramList.add(paramDescription);
    }
  }
  
  private void skippedQuietly(org.junit.internal.AssumptionViolatedException paramAssumptionViolatedException, Description paramDescription, List<Throwable> paramList)
  {
    try
    {
      if ((paramAssumptionViolatedException instanceof org.junit.AssumptionViolatedException))
      {
        skipped((org.junit.AssumptionViolatedException)paramAssumptionViolatedException, paramDescription);
        return;
      }
      skipped(paramAssumptionViolatedException, paramDescription);
      return;
    }
    finally
    {
      paramList.add(paramAssumptionViolatedException);
    }
  }
  
  private void startingQuietly(Description paramDescription, List<Throwable> paramList)
  {
    try
    {
      starting(paramDescription);
      return;
    }
    finally
    {
      paramList.add(paramDescription);
    }
  }
  
  private void succeededQuietly(Description paramDescription, List<Throwable> paramList)
  {
    try
    {
      succeeded(paramDescription);
      return;
    }
    finally
    {
      paramList.add(paramDescription);
    }
  }
  
  public Statement apply(final Statement paramStatement, final Description paramDescription)
  {
    new Statement()
    {
      /* Error */
      public void evaluate()
        throws Throwable
      {
        // Byte code:
        //   0: new 37	java/util/ArrayList
        //   3: dup
        //   4: invokespecial 38	java/util/ArrayList:<init>	()V
        //   7: astore_1
        //   8: aload_0
        //   9: getfield 21	org/junit/rules/TestWatcher$1:this$0	Lorg/junit/rules/TestWatcher;
        //   12: aload_0
        //   13: getfield 23	org/junit/rules/TestWatcher$1:val$description	Lorg/junit/runner/Description;
        //   16: aload_1
        //   17: invokestatic 42	org/junit/rules/TestWatcher:access$000	(Lorg/junit/rules/TestWatcher;Lorg/junit/runner/Description;Ljava/util/List;)V
        //   20: aload_0
        //   21: getfield 25	org/junit/rules/TestWatcher$1:val$base	Lorg/junit/runners/model/Statement;
        //   24: invokevirtual 44	org/junit/runners/model/Statement:evaluate	()V
        //   27: aload_0
        //   28: getfield 21	org/junit/rules/TestWatcher$1:this$0	Lorg/junit/rules/TestWatcher;
        //   31: aload_0
        //   32: getfield 23	org/junit/rules/TestWatcher$1:val$description	Lorg/junit/runner/Description;
        //   35: aload_1
        //   36: invokestatic 47	org/junit/rules/TestWatcher:access$100	(Lorg/junit/rules/TestWatcher;Lorg/junit/runner/Description;Ljava/util/List;)V
        //   39: aload_0
        //   40: getfield 21	org/junit/rules/TestWatcher$1:this$0	Lorg/junit/rules/TestWatcher;
        //   43: aload_0
        //   44: getfield 23	org/junit/rules/TestWatcher$1:val$description	Lorg/junit/runner/Description;
        //   47: aload_1
        //   48: invokestatic 50	org/junit/rules/TestWatcher:access$400	(Lorg/junit/rules/TestWatcher;Lorg/junit/runner/Description;Ljava/util/List;)V
        //   51: goto +53 -> 104
        //   54: astore_2
        //   55: aload_1
        //   56: aload_2
        //   57: invokeinterface 56 2 0
        //   62: pop
        //   63: aload_0
        //   64: getfield 21	org/junit/rules/TestWatcher$1:this$0	Lorg/junit/rules/TestWatcher;
        //   67: aload_2
        //   68: aload_0
        //   69: getfield 23	org/junit/rules/TestWatcher$1:val$description	Lorg/junit/runner/Description;
        //   72: aload_1
        //   73: invokestatic 60	org/junit/rules/TestWatcher:access$300	(Lorg/junit/rules/TestWatcher;Ljava/lang/Throwable;Lorg/junit/runner/Description;Ljava/util/List;)V
        //   76: goto -37 -> 39
        //   79: astore_2
        //   80: aload_1
        //   81: aload_2
        //   82: invokeinterface 56 2 0
        //   87: pop
        //   88: aload_0
        //   89: getfield 21	org/junit/rules/TestWatcher$1:this$0	Lorg/junit/rules/TestWatcher;
        //   92: aload_2
        //   93: aload_0
        //   94: getfield 23	org/junit/rules/TestWatcher$1:val$description	Lorg/junit/runner/Description;
        //   97: aload_1
        //   98: invokestatic 64	org/junit/rules/TestWatcher:access$200	(Lorg/junit/rules/TestWatcher;Lorg/junit/internal/AssumptionViolatedException;Lorg/junit/runner/Description;Ljava/util/List;)V
        //   101: goto -62 -> 39
        //   104: aload_1
        //   105: invokestatic 70	org/junit/runners/model/MultipleFailureException:assertEmpty	(Ljava/util/List;)V
        //   108: return
        //   109: astore_2
        //   110: aload_0
        //   111: getfield 21	org/junit/rules/TestWatcher$1:this$0	Lorg/junit/rules/TestWatcher;
        //   114: aload_0
        //   115: getfield 23	org/junit/rules/TestWatcher$1:val$description	Lorg/junit/runner/Description;
        //   118: aload_1
        //   119: invokestatic 50	org/junit/rules/TestWatcher:access$400	(Lorg/junit/rules/TestWatcher;Lorg/junit/runner/Description;Ljava/util/List;)V
        //   122: aload_2
        //   123: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	124	0	this	1
        //   7	112	1	localArrayList	java.util.ArrayList
        //   54	14	2	localObject1	Object
        //   79	14	2	localAssumptionViolatedException	org.junit.internal.AssumptionViolatedException
        //   109	14	2	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   20	39	54	finally
        //   20	39	79	org/junit/internal/AssumptionViolatedException
        //   55	76	109	finally
        //   80	101	109	finally
      }
    };
  }
  
  protected void failed(Throwable paramThrowable, Description paramDescription) {}
  
  protected void finished(Description paramDescription) {}
  
  protected void skipped(org.junit.AssumptionViolatedException paramAssumptionViolatedException, Description paramDescription)
  {
    skipped(paramAssumptionViolatedException, paramDescription);
  }
  
  @Deprecated
  protected void skipped(org.junit.internal.AssumptionViolatedException paramAssumptionViolatedException, Description paramDescription) {}
  
  protected void starting(Description paramDescription) {}
  
  protected void succeeded(Description paramDescription) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\rules\TestWatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */