package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;

public class DefaultCloseableReference<T>
  extends CloseableReference<T>
{
  private static final String TAG = "DefaultCloseableReference";
  
  private DefaultCloseableReference(SharedReference<T> paramSharedReference, CloseableReference.LeakHandler paramLeakHandler, @Nullable Throwable paramThrowable)
  {
    super(paramSharedReference, paramLeakHandler, paramThrowable);
  }
  
  DefaultCloseableReference(T paramT, ResourceReleaser<T> paramResourceReleaser, CloseableReference.LeakHandler paramLeakHandler, @Nullable Throwable paramThrowable)
  {
    super(paramT, paramResourceReleaser, paramLeakHandler, paramThrowable);
  }
  
  public CloseableReference<T> clone()
  {
    Preconditions.checkState(isValid());
    return new DefaultCloseableReference(this.mSharedReference, this.mLeakHandler, this.mStacktrace);
  }
  
  /* Error */
  protected void finalize()
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/facebook/common/references/DefaultCloseableReference:mIsClosed	Z
    //   6: ifeq +10 -> 16
    //   9: aload_0
    //   10: monitorexit
    //   11: aload_0
    //   12: invokespecial 64	com/facebook/common/references/CloseableReference:finalize	()V
    //   15: return
    //   16: aload_0
    //   17: monitorexit
    //   18: ldc 9
    //   20: ldc 66
    //   22: iconst_3
    //   23: anewarray 68	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: invokestatic 74	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   32: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: aload_0
    //   39: getfield 38	com/facebook/common/references/DefaultCloseableReference:mSharedReference	Lcom/facebook/common/references/SharedReference;
    //   42: invokestatic 74	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   45: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: aload_0
    //   52: getfield 38	com/facebook/common/references/DefaultCloseableReference:mSharedReference	Lcom/facebook/common/references/SharedReference;
    //   55: invokevirtual 85	com/facebook/common/references/SharedReference:get	()Ljava/lang/Object;
    //   58: invokevirtual 89	java/lang/Object:getClass	()Ljava/lang/Class;
    //   61: invokevirtual 95	java/lang/Class:getName	()Ljava/lang/String;
    //   64: aastore
    //   65: invokestatic 101	com/facebook/common/logging/FLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: aload_0
    //   69: getfield 42	com/facebook/common/references/DefaultCloseableReference:mLeakHandler	Lcom/facebook/common/references/CloseableReference$LeakHandler;
    //   72: aload_0
    //   73: getfield 38	com/facebook/common/references/DefaultCloseableReference:mSharedReference	Lcom/facebook/common/references/SharedReference;
    //   76: aload_0
    //   77: getfield 46	com/facebook/common/references/DefaultCloseableReference:mStacktrace	Ljava/lang/Throwable;
    //   80: invokeinterface 107 3 0
    //   85: aload_0
    //   86: invokevirtual 110	com/facebook/common/references/DefaultCloseableReference:close	()V
    //   89: aload_0
    //   90: invokespecial 64	com/facebook/common/references/CloseableReference:finalize	()V
    //   93: return
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    //   99: astore_1
    //   100: aload_0
    //   101: invokespecial 64	com/facebook/common/references/CloseableReference:finalize	()V
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	DefaultCloseableReference
    //   94	4	1	localObject1	Object
    //   99	6	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	94	finally
    //   16	18	94	finally
    //   95	97	94	finally
    //   0	2	99	finally
    //   18	89	99	finally
    //   97	99	99	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\references\DefaultCloseableReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */