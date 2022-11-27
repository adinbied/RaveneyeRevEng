package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import java.util.concurrent.atomic.AtomicReference;

public final class InnerQueuedObserver<T>
  extends AtomicReference<Disposable>
  implements Observer<T>, Disposable
{
  private static final long serialVersionUID = -5417183359794346637L;
  volatile boolean done;
  int fusionMode;
  final InnerQueuedObserverSupport<T> parent;
  final int prefetch;
  SimpleQueue<T> queue;
  
  public InnerQueuedObserver(InnerQueuedObserverSupport<T> paramInnerQueuedObserverSupport, int paramInt)
  {
    this.parent = paramInnerQueuedObserverSupport;
    this.prefetch = paramInt;
  }
  
  public void dispose()
  {
    DisposableHelper.dispose(this);
  }
  
  public int fusionMode()
  {
    return this.fusionMode;
  }
  
  public boolean isDisposed()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return this.done;
  }
  
  public void onComplete()
  {
    this.parent.innerComplete(this);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.parent.innerError(this, paramThrowable);
  }
  
  /* Error */
  public void onNext(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onSubscribe(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public SimpleQueue<T> queue()
  {
    return this.queue;
  }
  
  public void setDone()
  {
    this.done = true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\InnerQueuedObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */