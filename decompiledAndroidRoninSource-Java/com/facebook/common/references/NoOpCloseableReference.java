package com.facebook.common.references;

import javax.annotation.Nullable;

public class NoOpCloseableReference<T>
  extends CloseableReference<T>
{
  NoOpCloseableReference(T paramT, ResourceReleaser<T> paramResourceReleaser, CloseableReference.LeakHandler paramLeakHandler, @Nullable Throwable paramThrowable)
  {
    super(paramT, paramResourceReleaser, paramLeakHandler, paramThrowable);
  }
  
  public CloseableReference<T> clone()
  {
    return this;
  }
  
  public void close() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\references\NoOpCloseableReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */