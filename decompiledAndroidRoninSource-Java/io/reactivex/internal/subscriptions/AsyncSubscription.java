package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class AsyncSubscription
  extends AtomicLong
  implements Subscription, Disposable
{
  private static final long serialVersionUID = 7028635084060361255L;
  final AtomicReference<Subscription> actual = new AtomicReference();
  final AtomicReference<Disposable> resource = new AtomicReference();
  
  public AsyncSubscription() {}
  
  public AsyncSubscription(Disposable paramDisposable)
  {
    this();
    this.resource.lazySet(paramDisposable);
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
  
  public boolean replaceResource(Disposable paramDisposable)
  {
    return DisposableHelper.replace(this.resource, paramDisposable);
  }
  
  public void request(long paramLong)
  {
    SubscriptionHelper.deferredRequest(this.actual, this, paramLong);
  }
  
  public boolean setResource(Disposable paramDisposable)
  {
    return DisposableHelper.set(this.resource, paramDisposable);
  }
  
  public void setSubscription(Subscription paramSubscription)
  {
    SubscriptionHelper.deferredSetOnce(this.actual, this, paramSubscription);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscriptions\AsyncSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */