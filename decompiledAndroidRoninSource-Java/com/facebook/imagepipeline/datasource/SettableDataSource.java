package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import javax.annotation.Nullable;

public final class SettableDataSource<T>
  extends AbstractDataSource<CloseableReference<T>>
{
  public static <V> SettableDataSource<V> create()
  {
    return new SettableDataSource();
  }
  
  protected void closeResult(@Nullable CloseableReference<T> paramCloseableReference)
  {
    CloseableReference.closeSafely(paramCloseableReference);
  }
  
  @Nullable
  public CloseableReference<T> getResult()
  {
    return CloseableReference.cloneOrNull((CloseableReference)super.getResult());
  }
  
  public boolean set(@Nullable CloseableReference<T> paramCloseableReference)
  {
    return super.setResult(CloseableReference.cloneOrNull(paramCloseableReference), true, null);
  }
  
  public boolean setException(Throwable paramThrowable)
  {
    return super.setFailure(paramThrowable);
  }
  
  public boolean setProgress(float paramFloat)
  {
    return super.setProgress(paramFloat);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\datasource\SettableDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */