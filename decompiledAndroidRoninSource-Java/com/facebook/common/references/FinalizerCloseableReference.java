package com.facebook.common.references;

import javax.annotation.Nullable;

public class FinalizerCloseableReference<T>
  extends CloseableReference<T>
{
  private static final String TAG = "FinalizerCloseableReference";
  
  FinalizerCloseableReference(T paramT, ResourceReleaser<T> paramResourceReleaser, CloseableReference.LeakHandler paramLeakHandler, @Nullable Throwable paramThrowable)
  {
    super(paramT, paramResourceReleaser, paramLeakHandler, paramThrowable);
  }
  
  public CloseableReference<T> clone()
  {
    return this;
  }
  
  public void close() {}
  
  /* Error */
  protected void finalize()
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/facebook/common/references/FinalizerCloseableReference:mIsClosed	Z
    //   6: ifeq +10 -> 16
    //   9: aload_0
    //   10: monitorexit
    //   11: aload_0
    //   12: invokespecial 38	com/facebook/common/references/CloseableReference:finalize	()V
    //   15: return
    //   16: aload_0
    //   17: monitorexit
    //   18: ldc 9
    //   20: ldc 40
    //   22: iconst_3
    //   23: anewarray 42	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: invokestatic 48	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   32: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: aload_0
    //   39: getfield 58	com/facebook/common/references/FinalizerCloseableReference:mSharedReference	Lcom/facebook/common/references/SharedReference;
    //   42: invokestatic 48	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   45: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: aload_0
    //   52: getfield 58	com/facebook/common/references/FinalizerCloseableReference:mSharedReference	Lcom/facebook/common/references/SharedReference;
    //   55: invokevirtual 63	com/facebook/common/references/SharedReference:get	()Ljava/lang/Object;
    //   58: invokevirtual 67	java/lang/Object:getClass	()Ljava/lang/Class;
    //   61: invokevirtual 73	java/lang/Class:getName	()Ljava/lang/String;
    //   64: aastore
    //   65: invokestatic 79	com/facebook/common/logging/FLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: aload_0
    //   69: getfield 58	com/facebook/common/references/FinalizerCloseableReference:mSharedReference	Lcom/facebook/common/references/SharedReference;
    //   72: invokevirtual 82	com/facebook/common/references/SharedReference:deleteReference	()V
    //   75: aload_0
    //   76: invokespecial 38	com/facebook/common/references/CloseableReference:finalize	()V
    //   79: return
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: invokespecial 38	com/facebook/common/references/CloseableReference:finalize	()V
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	FinalizerCloseableReference
    //   80	4	1	localObject1	Object
    //   85	6	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	80	finally
    //   16	18	80	finally
    //   81	83	80	finally
    //   0	2	85	finally
    //   18	75	85	finally
    //   83	85	85	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\references\FinalizerCloseableReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */