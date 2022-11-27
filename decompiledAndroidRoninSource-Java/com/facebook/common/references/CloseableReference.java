package com.facebook.common.references;

import android.graphics.Bitmap;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public abstract class CloseableReference<T>
  implements Cloneable, Closeable
{
  private static final ResourceReleaser<Closeable> DEFAULT_CLOSEABLE_RELEASER = new ResourceReleaser()
  {
    public void release(Closeable paramAnonymousCloseable)
    {
      try
      {
        Closeables.close(paramAnonymousCloseable, true);
        return;
      }
      catch (IOException paramAnonymousCloseable) {}
    }
  };
  private static final LeakHandler DEFAULT_LEAK_HANDLER = new LeakHandler()
  {
    public void reportLeak(SharedReference<Object> paramAnonymousSharedReference, @Nullable Throwable paramAnonymousThrowable)
    {
      FLog.w(CloseableReference.TAG, "Finalized without closing: %x %x (type = %s)", new Object[] { Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(paramAnonymousSharedReference)), paramAnonymousSharedReference.get().getClass().getName() });
    }
    
    public boolean requiresStacktrace()
    {
      return false;
    }
  };
  public static final int REF_TYPE_DEFAULT = 0;
  public static final int REF_TYPE_FINALIZER = 1;
  public static final int REF_TYPE_NOOP = 3;
  public static final int REF_TYPE_REF_COUNT = 2;
  private static Class<CloseableReference> TAG = CloseableReference.class;
  private static int sBitmapCloseableRefType;
  protected boolean mIsClosed = false;
  protected final LeakHandler mLeakHandler;
  protected final SharedReference<T> mSharedReference;
  @Nullable
  protected final Throwable mStacktrace;
  
  protected CloseableReference(SharedReference<T> paramSharedReference, LeakHandler paramLeakHandler, @Nullable Throwable paramThrowable)
  {
    this.mSharedReference = ((SharedReference)Preconditions.checkNotNull(paramSharedReference));
    paramSharedReference.addReference();
    this.mLeakHandler = paramLeakHandler;
    this.mStacktrace = paramThrowable;
  }
  
  protected CloseableReference(T paramT, ResourceReleaser<T> paramResourceReleaser, LeakHandler paramLeakHandler, @Nullable Throwable paramThrowable)
  {
    this.mSharedReference = new SharedReference(paramT, paramResourceReleaser);
    this.mLeakHandler = paramLeakHandler;
    this.mStacktrace = paramThrowable;
  }
  
  @Nullable
  public static <T> CloseableReference<T> cloneOrNull(@Nullable CloseableReference<T> paramCloseableReference)
  {
    if (paramCloseableReference != null) {
      return paramCloseableReference.cloneOrNull();
    }
    return null;
  }
  
  public static <T> List<CloseableReference<T>> cloneOrNull(Collection<CloseableReference<T>> paramCollection)
  {
    if (paramCollection == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(cloneOrNull((CloseableReference)paramCollection.next()));
    }
    return localArrayList;
  }
  
  public static void closeSafely(@Nullable CloseableReference<?> paramCloseableReference)
  {
    if (paramCloseableReference != null) {
      paramCloseableReference.close();
    }
  }
  
  public static void closeSafely(@Nullable Iterable<? extends CloseableReference<?>> paramIterable)
  {
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        closeSafely((CloseableReference)paramIterable.next());
      }
    }
  }
  
  public static boolean isValid(@Nullable CloseableReference<?> paramCloseableReference)
  {
    return (paramCloseableReference != null) && (paramCloseableReference.isValid());
  }
  
  public static <T extends Closeable> CloseableReference<T> of(T paramT)
  {
    return of(paramT, DEFAULT_CLOSEABLE_RELEASER);
  }
  
  public static <T extends Closeable> CloseableReference<T> of(T paramT, LeakHandler paramLeakHandler)
  {
    Throwable localThrowable = null;
    if (paramT == null) {
      return null;
    }
    ResourceReleaser localResourceReleaser = DEFAULT_CLOSEABLE_RELEASER;
    if (paramLeakHandler.requiresStacktrace()) {
      localThrowable = new Throwable();
    }
    return of(paramT, localResourceReleaser, paramLeakHandler, localThrowable);
  }
  
  public static <T> CloseableReference<T> of(T paramT, ResourceReleaser<T> paramResourceReleaser)
  {
    return of(paramT, paramResourceReleaser, DEFAULT_LEAK_HANDLER);
  }
  
  public static <T> CloseableReference<T> of(T paramT, ResourceReleaser<T> paramResourceReleaser, LeakHandler paramLeakHandler)
  {
    Throwable localThrowable = null;
    if (paramT == null) {
      return null;
    }
    if (paramLeakHandler.requiresStacktrace()) {
      localThrowable = new Throwable();
    }
    return of(paramT, paramResourceReleaser, paramLeakHandler, localThrowable);
  }
  
  public static <T> CloseableReference<T> of(T paramT, ResourceReleaser<T> paramResourceReleaser, LeakHandler paramLeakHandler, @Nullable Throwable paramThrowable)
  {
    if (paramT == null) {
      return null;
    }
    if (((paramT instanceof Bitmap)) || ((paramT instanceof HasBitmap)))
    {
      int i = sBitmapCloseableRefType;
      if (i == 1) {
        break label79;
      }
      if (i == 2) {
        break label67;
      }
      if (i == 3) {}
    }
    else
    {
      return new DefaultCloseableReference(paramT, paramResourceReleaser, paramLeakHandler, paramThrowable);
    }
    return new NoOpCloseableReference(paramT, paramResourceReleaser, paramLeakHandler, paramThrowable);
    label67:
    return new RefCountCloseableReference(paramT, paramResourceReleaser, paramLeakHandler, paramThrowable);
    label79:
    return new FinalizerCloseableReference(paramT, paramResourceReleaser, paramLeakHandler, paramThrowable);
  }
  
  public static void setDisableCloseableReferencesForBitmaps(int paramInt)
  {
    sBitmapCloseableRefType = paramInt;
  }
  
  public static boolean useGc()
  {
    return sBitmapCloseableRefType == 3;
  }
  
  public abstract CloseableReference<T> clone();
  
  @Nullable
  public CloseableReference<T> cloneOrNull()
  {
    try
    {
      if (isValid())
      {
        CloseableReference localCloseableReference = clone();
        return localCloseableReference;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void close()
  {
    try
    {
      if (this.mIsClosed) {
        return;
      }
      this.mIsClosed = true;
      this.mSharedReference.deleteReference();
      return;
    }
    finally {}
  }
  
  /* Error */
  protected void finalize()
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	com/facebook/common/references/CloseableReference:mIsClosed	Z
    //   6: ifeq +10 -> 16
    //   9: aload_0
    //   10: monitorexit
    //   11: aload_0
    //   12: invokespecial 207	java/lang/Object:finalize	()V
    //   15: return
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_0
    //   19: getfield 78	com/facebook/common/references/CloseableReference:mLeakHandler	Lcom/facebook/common/references/CloseableReference$LeakHandler;
    //   22: aload_0
    //   23: getfield 73	com/facebook/common/references/CloseableReference:mSharedReference	Lcom/facebook/common/references/SharedReference;
    //   26: aload_0
    //   27: getfield 80	com/facebook/common/references/CloseableReference:mStacktrace	Ljava/lang/Throwable;
    //   30: invokeinterface 211 3 0
    //   35: aload_0
    //   36: invokevirtual 137	com/facebook/common/references/CloseableReference:close	()V
    //   39: aload_0
    //   40: invokespecial 207	java/lang/Object:finalize	()V
    //   43: return
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    //   49: astore_1
    //   50: aload_0
    //   51: invokespecial 207	java/lang/Object:finalize	()V
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	CloseableReference
    //   44	4	1	localObject1	Object
    //   49	6	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	44	finally
    //   16	18	44	finally
    //   45	47	44	finally
    //   0	2	49	finally
    //   18	39	49	finally
    //   47	49	49	finally
  }
  
  public T get()
  {
    for (;;)
    {
      try
      {
        if (!this.mIsClosed)
        {
          bool = true;
          Preconditions.checkState(bool);
          Object localObject1 = this.mSharedReference.get();
          return (T)localObject1;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public SharedReference<T> getUnderlyingReferenceTestOnly()
  {
    try
    {
      SharedReference localSharedReference = this.mSharedReference;
      return localSharedReference;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getValueHash()
  {
    if (isValid()) {
      return System.identityHashCode(this.mSharedReference.get());
    }
    return 0;
  }
  
  public boolean isValid()
  {
    try
    {
      boolean bool = this.mIsClosed;
      return bool ^ true;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static @interface CloseableRefType {}
  
  public static abstract interface LeakHandler
  {
    public abstract void reportLeak(SharedReference<Object> paramSharedReference, @Nullable Throwable paramThrowable);
    
    public abstract boolean requiresStacktrace();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\references\CloseableReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */