package org.junit.internal.runners.statements;

import org.junit.runners.model.Statement;

public class ExpectException
  extends Statement
{
  private final Class<? extends Throwable> expected;
  private final Statement next;
  
  public ExpectException(Statement paramStatement, Class<? extends Throwable> paramClass)
  {
    this.next = paramStatement;
    this.expected = paramClass;
  }
  
  /* Error */
  public void evaluate()
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	org/junit/internal/runners/statements/ExpectException:next	Lorg/junit/runners/model/Statement;
    //   4: invokevirtual 28	org/junit/runners/model/Statement:evaluate	()V
    //   7: iconst_1
    //   8: istore_1
    //   9: goto +20 -> 29
    //   12: astore_2
    //   13: aload_0
    //   14: getfield 18	org/junit/internal/runners/statements/ExpectException:expected	Ljava/lang/Class;
    //   17: aload_2
    //   18: invokevirtual 34	java/lang/Object:getClass	()Ljava/lang/Class;
    //   21: invokevirtual 40	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   24: ifeq +49 -> 73
    //   27: iconst_0
    //   28: istore_1
    //   29: iload_1
    //   30: ifne +4 -> 34
    //   33: return
    //   34: new 42	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   41: astore_2
    //   42: aload_2
    //   43: ldc 45
    //   45: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_2
    //   50: aload_0
    //   51: getfield 18	org/junit/internal/runners/statements/ExpectException:expected	Ljava/lang/Class;
    //   54: invokevirtual 53	java/lang/Class:getName	()Ljava/lang/String;
    //   57: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: new 55	java/lang/AssertionError
    //   64: dup
    //   65: aload_2
    //   66: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokespecial 61	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   72: athrow
    //   73: new 42	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   80: astore_3
    //   81: aload_3
    //   82: ldc 63
    //   84: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_3
    //   89: aload_0
    //   90: getfield 18	org/junit/internal/runners/statements/ExpectException:expected	Ljava/lang/Class;
    //   93: invokevirtual 53	java/lang/Class:getName	()Ljava/lang/String;
    //   96: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_3
    //   101: ldc 65
    //   103: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_3
    //   108: aload_2
    //   109: invokevirtual 34	java/lang/Object:getClass	()Ljava/lang/Class;
    //   112: invokevirtual 53	java/lang/Class:getName	()Ljava/lang/String;
    //   115: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_3
    //   120: ldc 67
    //   122: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: new 24	java/lang/Exception
    //   129: dup
    //   130: aload_3
    //   131: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: aload_2
    //   135: invokespecial 70	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   138: athrow
    //   139: astore_2
    //   140: aload_2
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	ExpectException
    //   8	22	1	i	int
    //   12	6	2	localObject	Object
    //   41	94	2	localStringBuilder1	StringBuilder
    //   139	2	2	localAssumptionViolatedException	org.junit.internal.AssumptionViolatedException
    //   80	51	3	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	7	12	finally
    //   0	7	139	org/junit/internal/AssumptionViolatedException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\runners\statements\ExpectException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */