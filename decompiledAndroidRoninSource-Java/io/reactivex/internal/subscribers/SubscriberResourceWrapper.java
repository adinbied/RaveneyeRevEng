package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SubscriberResourceWrapper<T>
  extends AtomicReference<Disposable>
  implements FlowableSubscriber<T>, Disposable, Subscription
{
  private static final long serialVersionUID = -8612022020200669122L;
  final Subscriber<? super T> downstream;
  final AtomicReference<Subscription> upstream = new AtomicReference();
  
  public SubscriberResourceWrapper(Subscriber<? super T> paramSubscriber)
  {
    this.downstream = paramSubscriber;
  }
  
  public void cancel()
  {
    dispose();
  }
  
  /* Error */
  public void dispose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isDisposed()
  {
    return false;
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
  
  public void onNext(T paramT)
  {
    this.downstream.onNext(paramT);
  }
  
  /* Error */
  public void onSubscribe(Subscription arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void request(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void setResource(Disposable paramDisposable)
  {
    DisposableHelper.set(this, paramDisposable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscribers\SubscriberResourceWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */