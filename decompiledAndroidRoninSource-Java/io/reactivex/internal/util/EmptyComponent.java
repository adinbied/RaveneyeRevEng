package io.reactivex.internal.util;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public enum EmptyComponent
  implements FlowableSubscriber<Object>, Observer<Object>, MaybeObserver<Object>, SingleObserver<Object>, CompletableObserver, Subscription, Disposable
{
  static
  {
    EmptyComponent localEmptyComponent = new EmptyComponent("INSTANCE", 0);
    INSTANCE = localEmptyComponent;
    $VALUES = new EmptyComponent[] { localEmptyComponent };
  }
  
  private EmptyComponent() {}
  
  public static <T> Observer<T> asObserver()
  {
    return INSTANCE;
  }
  
  public static <T> Subscriber<T> asSubscriber()
  {
    return INSTANCE;
  }
  
  public void cancel() {}
  
  public void dispose() {}
  
  public boolean isDisposed()
  {
    return true;
  }
  
  public void onComplete() {}
  
  public void onError(Throwable paramThrowable)
  {
    RxJavaPlugins.onError(paramThrowable);
  }
  
  public void onNext(Object paramObject) {}
  
  public void onSubscribe(Disposable paramDisposable)
  {
    paramDisposable.dispose();
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    paramSubscription.cancel();
  }
  
  public void onSuccess(Object paramObject) {}
  
  public void request(long paramLong) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\EmptyComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */