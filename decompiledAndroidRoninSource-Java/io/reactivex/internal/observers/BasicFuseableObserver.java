package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.QueueDisposable;

public abstract class BasicFuseableObserver<T, R>
  implements Observer<T>, QueueDisposable<R>
{
  protected boolean done;
  protected final Observer<? super R> downstream;
  protected QueueDisposable<T> qd;
  protected int sourceMode;
  protected Disposable upstream;
  
  public BasicFuseableObserver(Observer<? super R> paramObserver)
  {
    this.downstream = paramObserver;
  }
  
  protected void afterDownstream() {}
  
  protected boolean beforeDownstream()
  {
    return true;
  }
  
  public void clear()
  {
    this.qd.clear();
  }
  
  public void dispose()
  {
    this.upstream.dispose();
  }
  
  /* Error */
  protected final void fail(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isDisposed()
  {
    return this.upstream.isDisposed();
  }
  
  public boolean isEmpty()
  {
    return this.qd.isEmpty();
  }
  
  public final boolean offer(R paramR)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public final boolean offer(R paramR1, R paramR2)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  /* Error */
  public void onComplete()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onError(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void onSubscribe(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected final int transitiveBoundaryFusion(int paramInt)
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\BasicFuseableObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */