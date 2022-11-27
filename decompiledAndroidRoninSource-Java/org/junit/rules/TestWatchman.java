package org.junit.rules;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

@Deprecated
public class TestWatchman
  implements MethodRule
{
  public Statement apply(final Statement paramStatement, final FrameworkMethod paramFrameworkMethod, Object paramObject)
  {
    new Statement()
    {
      /* Error */
      public void evaluate()
        throws Throwable
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 21	org/junit/rules/TestWatchman$1:this$0	Lorg/junit/rules/TestWatchman;
        //   4: aload_0
        //   5: getfield 23	org/junit/rules/TestWatchman$1:val$method	Lorg/junit/runners/model/FrameworkMethod;
        //   8: invokevirtual 37	org/junit/rules/TestWatchman:starting	(Lorg/junit/runners/model/FrameworkMethod;)V
        //   11: aload_0
        //   12: getfield 25	org/junit/rules/TestWatchman$1:val$base	Lorg/junit/runners/model/Statement;
        //   15: invokevirtual 39	org/junit/runners/model/Statement:evaluate	()V
        //   18: aload_0
        //   19: getfield 21	org/junit/rules/TestWatchman$1:this$0	Lorg/junit/rules/TestWatchman;
        //   22: aload_0
        //   23: getfield 23	org/junit/rules/TestWatchman$1:val$method	Lorg/junit/runners/model/FrameworkMethod;
        //   26: invokevirtual 42	org/junit/rules/TestWatchman:succeeded	(Lorg/junit/runners/model/FrameworkMethod;)V
        //   29: aload_0
        //   30: getfield 21	org/junit/rules/TestWatchman$1:this$0	Lorg/junit/rules/TestWatchman;
        //   33: aload_0
        //   34: getfield 23	org/junit/rules/TestWatchman$1:val$method	Lorg/junit/runners/model/FrameworkMethod;
        //   37: invokevirtual 45	org/junit/rules/TestWatchman:finished	(Lorg/junit/runners/model/FrameworkMethod;)V
        //   40: return
        //   41: astore_1
        //   42: aload_0
        //   43: getfield 21	org/junit/rules/TestWatchman$1:this$0	Lorg/junit/rules/TestWatchman;
        //   46: aload_1
        //   47: aload_0
        //   48: getfield 23	org/junit/rules/TestWatchman$1:val$method	Lorg/junit/runners/model/FrameworkMethod;
        //   51: invokevirtual 49	org/junit/rules/TestWatchman:failed	(Ljava/lang/Throwable;Lorg/junit/runners/model/FrameworkMethod;)V
        //   54: aload_1
        //   55: athrow
        //   56: astore_1
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_0
        //   61: getfield 21	org/junit/rules/TestWatchman$1:this$0	Lorg/junit/rules/TestWatchman;
        //   64: aload_0
        //   65: getfield 23	org/junit/rules/TestWatchman$1:val$method	Lorg/junit/runners/model/FrameworkMethod;
        //   68: invokevirtual 45	org/junit/rules/TestWatchman:finished	(Lorg/junit/runners/model/FrameworkMethod;)V
        //   71: aload_1
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	1
        //   41	14	1	localThrowable	Throwable
        //   56	2	1	localAssumptionViolatedException	org.junit.internal.AssumptionViolatedException
        //   59	13	1	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   11	29	41	finally
        //   11	29	56	org/junit/internal/AssumptionViolatedException
        //   42	56	59	finally
        //   57	59	59	finally
      }
    };
  }
  
  public void failed(Throwable paramThrowable, FrameworkMethod paramFrameworkMethod) {}
  
  public void finished(FrameworkMethod paramFrameworkMethod) {}
  
  public void starting(FrameworkMethod paramFrameworkMethod) {}
  
  public void succeeded(FrameworkMethod paramFrameworkMethod) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\rules\TestWatchman.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */