package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;

public class RefCountCloseableReference<T>
  extends CloseableReference<T>
{
  private RefCountCloseableReference(SharedReference<T> paramSharedReference, CloseableReference.LeakHandler paramLeakHandler, @Nullable Throwable paramThrowable)
  {
    super(paramSharedReference, paramLeakHandler, paramThrowable);
  }
  
  RefCountCloseableReference(T paramT, ResourceReleaser<T> paramResourceReleaser, CloseableReference.LeakHandler paramLeakHandler, @Nullable Throwable paramThrowable)
  {
    super(paramT, paramResourceReleaser, paramLeakHandler, paramThrowable);
  }
  
  public CloseableReference<T> clone()
  {
    Preconditions.checkState(isValid());
    return new RefCountCloseableReference(this.mSharedReference, this.mLeakHandler, this.mStacktrace);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\references\RefCountCloseableReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */