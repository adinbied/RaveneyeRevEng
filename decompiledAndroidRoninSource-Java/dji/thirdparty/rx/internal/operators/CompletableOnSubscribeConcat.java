package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Completable;
import dji.thirdparty.rx.Completable.CompletableOnSubscribe;
import dji.thirdparty.rx.Completable.CompletableSubscriber;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.internal.util.unsafe.SpscArrayQueue;
import dji.thirdparty.rx.subscriptions.SerialSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class CompletableOnSubscribeConcat
  implements Completable.CompletableOnSubscribe
{
  final int prefetch;
  final Observable<? extends Completable> sources;
  
  public CompletableOnSubscribeConcat(Observable<? extends Completable> paramObservable, int paramInt)
  {
    this.sources = paramObservable;
    this.prefetch = paramInt;
  }
  
  /* Error */
  public void call(Completable.CompletableSubscriber arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CompletableConcatSubscriber
    extends Subscriber<Completable>
  {
    static final AtomicIntegerFieldUpdater<CompletableConcatSubscriber> ONCE = AtomicIntegerFieldUpdater.newUpdater(CompletableConcatSubscriber.class, "once");
    final Completable.CompletableSubscriber actual;
    volatile boolean done;
    final ConcatInnerSubscriber inner;
    volatile int once;
    final int prefetch;
    final SpscArrayQueue<Completable> queue;
    final SerialSubscription sr;
    final AtomicInteger wip;
    
    public CompletableConcatSubscriber(Completable.CompletableSubscriber paramCompletableSubscriber, int paramInt)
    {
      this.actual = paramCompletableSubscriber;
      this.prefetch = paramInt;
      this.queue = new SpscArrayQueue(paramInt);
      this.sr = new SerialSubscription();
      this.inner = new ConcatInnerSubscriber();
      this.wip = new AtomicInteger();
      add(this.sr);
      request(paramInt);
    }
    
    /* Error */
    void innerComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void innerError(Throwable paramThrowable)
    {
      unsubscribe();
      onError(paramThrowable);
    }
    
    /* Error */
    void next()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onCompleted()
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
    public void onNext(Completable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    final class ConcatInnerSubscriber
      implements Completable.CompletableSubscriber
    {
      ConcatInnerSubscriber() {}
      
      public void onCompleted()
      {
        CompletableOnSubscribeConcat.CompletableConcatSubscriber.this.innerComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        CompletableOnSubscribeConcat.CompletableConcatSubscriber.this.innerError(paramThrowable);
      }
      
      public void onSubscribe(Subscription paramSubscription)
      {
        CompletableOnSubscribeConcat.CompletableConcatSubscriber.this.sr.set(paramSubscription);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\CompletableOnSubscribeConcat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */