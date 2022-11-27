package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SubscriberCompletableObserver<T>
  implements CompletableObserver, Subscription
{
  final Subscriber<? super T> subscriber;
  Disposable upstream;
  
  public SubscriberCompletableObserver(Subscriber<? super T> paramSubscriber)
  {
    this.subscriber = paramSubscriber;
  }
  
  public void cancel()
  {
    this.upstream.dispose();
  }
  
  public void onComplete()
  {
    this.subscriber.onComplete();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.subscriber.onError(paramThrowable);
  }
  
  /* Error */
  public void onSubscribe(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void request(long paramLong) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\SubscriberCompletableObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */