package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.observables.ConnectableObservable;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public final class OnSubscribeRefCount<T>
  implements Observable.OnSubscribe<T>
{
  volatile CompositeSubscription baseSubscription = new CompositeSubscription();
  final ReentrantLock lock = new ReentrantLock();
  private final ConnectableObservable<? extends T> source;
  final AtomicInteger subscriptionCount = new AtomicInteger(0);
  
  public OnSubscribeRefCount(ConnectableObservable<? extends T> paramConnectableObservable)
  {
    this.source = paramConnectableObservable;
  }
  
  private Subscription disconnect(CompositeSubscription paramCompositeSubscription)
  {
    return null;
  }
  
  private Action1<Subscription> onSubscribe(final Subscriber<? super T> paramSubscriber, final AtomicBoolean paramAtomicBoolean)
  {
    new Action1()
    {
      /* Error */
      public void call(Subscription arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    };
  }
  
  /* Error */
  public void call(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void doSubscribe(Subscriber<? super T> arg1, CompositeSubscription arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeRefCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */