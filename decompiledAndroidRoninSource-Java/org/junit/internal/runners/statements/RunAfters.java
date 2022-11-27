package org.junit.internal.runners.statements;

import java.util.List;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class RunAfters
  extends Statement
{
  private final List<FrameworkMethod> afters;
  private final Statement next;
  private final Object target;
  
  public RunAfters(Statement paramStatement, List<FrameworkMethod> paramList, Object paramObject)
  {
    this.next = paramStatement;
    this.afters = paramList;
    this.target = paramObject;
  }
  
  /* Error */
  public void evaluate()
    throws java.lang.Throwable
  {
    // Byte code:
    //   0: new 30	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 31	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 18	org/junit/internal/runners/statements/RunAfters:next	Lorg/junit/runners/model/Statement;
    //   12: invokevirtual 33	org/junit/runners/model/Statement:evaluate	()V
    //   15: aload_0
    //   16: getfield 20	org/junit/internal/runners/statements/RunAfters:afters	Ljava/util/List;
    //   19: invokeinterface 39 1 0
    //   24: astore_2
    //   25: aload_2
    //   26: invokeinterface 45 1 0
    //   31: ifeq +107 -> 138
    //   34: aload_2
    //   35: invokeinterface 48 1 0
    //   40: checkcast 50	org/junit/runners/model/FrameworkMethod
    //   43: astore_3
    //   44: aload_3
    //   45: aload_0
    //   46: getfield 22	org/junit/internal/runners/statements/RunAfters:target	Ljava/lang/Object;
    //   49: iconst_0
    //   50: anewarray 52	java/lang/Object
    //   53: invokevirtual 56	org/junit/runners/model/FrameworkMethod:invokeExplosively	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   56: pop
    //   57: goto -32 -> 25
    //   60: astore_3
    //   61: aload_1
    //   62: aload_3
    //   63: invokeinterface 60 2 0
    //   68: pop
    //   69: goto -44 -> 25
    //   72: astore_2
    //   73: aload_1
    //   74: aload_2
    //   75: invokeinterface 60 2 0
    //   80: pop
    //   81: aload_0
    //   82: getfield 20	org/junit/internal/runners/statements/RunAfters:afters	Ljava/util/List;
    //   85: invokeinterface 39 1 0
    //   90: astore_2
    //   91: aload_2
    //   92: invokeinterface 45 1 0
    //   97: ifeq +41 -> 138
    //   100: aload_2
    //   101: invokeinterface 48 1 0
    //   106: checkcast 50	org/junit/runners/model/FrameworkMethod
    //   109: astore_3
    //   110: aload_3
    //   111: aload_0
    //   112: getfield 22	org/junit/internal/runners/statements/RunAfters:target	Ljava/lang/Object;
    //   115: iconst_0
    //   116: anewarray 52	java/lang/Object
    //   119: invokevirtual 56	org/junit/runners/model/FrameworkMethod:invokeExplosively	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   122: pop
    //   123: goto -32 -> 91
    //   126: astore_3
    //   127: aload_1
    //   128: aload_3
    //   129: invokeinterface 60 2 0
    //   134: pop
    //   135: goto -44 -> 91
    //   138: aload_1
    //   139: invokestatic 66	org/junit/runners/model/MultipleFailureException:assertEmpty	(Ljava/util/List;)V
    //   142: return
    //   143: astore_2
    //   144: aload_0
    //   145: getfield 20	org/junit/internal/runners/statements/RunAfters:afters	Ljava/util/List;
    //   148: invokeinterface 39 1 0
    //   153: astore_3
    //   154: aload_3
    //   155: invokeinterface 45 1 0
    //   160: ifeq +45 -> 205
    //   163: aload_3
    //   164: invokeinterface 48 1 0
    //   169: checkcast 50	org/junit/runners/model/FrameworkMethod
    //   172: astore 4
    //   174: aload 4
    //   176: aload_0
    //   177: getfield 22	org/junit/internal/runners/statements/RunAfters:target	Ljava/lang/Object;
    //   180: iconst_0
    //   181: anewarray 52	java/lang/Object
    //   184: invokevirtual 56	org/junit/runners/model/FrameworkMethod:invokeExplosively	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   187: pop
    //   188: goto -34 -> 154
    //   191: astore 4
    //   193: aload_1
    //   194: aload 4
    //   196: invokeinterface 60 2 0
    //   201: pop
    //   202: goto -48 -> 154
    //   205: aload_2
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	RunAfters
    //   7	187	1	localArrayList	java.util.ArrayList
    //   24	11	2	localIterator1	java.util.Iterator
    //   72	3	2	localObject1	Object
    //   90	11	2	localIterator2	java.util.Iterator
    //   143	63	2	localObject2	Object
    //   43	2	3	localFrameworkMethod1	FrameworkMethod
    //   60	3	3	localObject3	Object
    //   109	2	3	localFrameworkMethod2	FrameworkMethod
    //   126	3	3	localObject4	Object
    //   153	11	3	localIterator3	java.util.Iterator
    //   172	3	4	localFrameworkMethod3	FrameworkMethod
    //   191	4	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   44	57	60	finally
    //   8	15	72	finally
    //   110	123	126	finally
    //   73	81	143	finally
    //   174	188	191	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\runners\statements\RunAfters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */