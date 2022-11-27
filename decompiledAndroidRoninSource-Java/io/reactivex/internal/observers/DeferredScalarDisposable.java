package io.reactivex.internal.observers;

import io.reactivex.Observer;

public class DeferredScalarDisposable<T>
  extends BasicIntQueueDisposable<T>
{
  static final int DISPOSED = 4;
  static final int FUSED_CONSUMED = 32;
  static final int FUSED_EMPTY = 8;
  static final int FUSED_READY = 16;
  static final int TERMINATED = 2;
  private static final long serialVersionUID = -5502432239815349361L;
  protected final Observer<? super T> downstream;
  protected T value;
  
  public DeferredScalarDisposable(Observer<? super T> paramObserver)
  {
    this.downstream = paramObserver;
  }
  
  /* Error */
  public final void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void complete()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void complete(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void dispose()
  {
    set(4);
    this.value = null;
  }
  
  /* Error */
  public final void error(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final boolean isDisposed()
  {
    return false;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  public final T poll()
    throws Exception
  {
    return null;
  }
  
  public final int requestFusion(int paramInt)
  {
    return 0;
  }
  
  public final boolean tryDispose()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\DeferredScalarDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */