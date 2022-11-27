package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.internal.producers.ProducerArbiter;
import dji.thirdparty.rx.internal.util.atomic.SpscAtomicArrayQueue;
import dji.thirdparty.rx.internal.util.unsafe.SpscArrayQueue;
import dji.thirdparty.rx.internal.util.unsafe.UnsafeAccess;
import dji.thirdparty.rx.subscriptions.SerialSubscription;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class OnSubscribeConcatMap<T, R>
  implements Observable.OnSubscribe<R>
{
  public static final int BOUNDARY = 1;
  public static final int END = 2;
  public static final int IMMEDIATE = 0;
  final int delayErrorMode;
  final Func1<? super T, ? extends Observable<? extends R>> mapper;
  final int prefetch;
  final Observable<? extends T> source;
  
  public OnSubscribeConcatMap(Observable<? extends T> paramObservable, Func1<? super T, ? extends Observable<? extends R>> paramFunc1, int paramInt1, int paramInt2)
  {
    this.source = paramObservable;
    this.mapper = paramFunc1;
    this.prefetch = paramInt1;
    this.delayErrorMode = paramInt2;
  }
  
  /* Error */
  public void call(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ConcatMapInnerScalarProducer<T, R>
    implements Producer
  {
    boolean once;
    final OnSubscribeConcatMap.ConcatMapSubscriber<T, R> parent;
    final R value;
    
    public ConcatMapInnerScalarProducer(R paramR, OnSubscribeConcatMap.ConcatMapSubscriber<T, R> paramConcatMapSubscriber)
    {
      this.value = paramR;
      this.parent = paramConcatMapSubscriber;
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
  
  static final class ConcatMapInnerSubscriber<T, R>
    extends Subscriber<R>
  {
    final OnSubscribeConcatMap.ConcatMapSubscriber<T, R> parent;
    long produced;
    
    public ConcatMapInnerSubscriber(OnSubscribeConcatMap.ConcatMapSubscriber<T, R> paramConcatMapSubscriber)
    {
      this.parent = paramConcatMapSubscriber;
    }
    
    public void onCompleted()
    {
      this.parent.innerCompleted(this.produced);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.innerError(paramThrowable, this.produced);
    }
    
    /* Error */
    public void onNext(R arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void setProducer(Producer paramProducer)
    {
      this.parent.arbiter.setProducer(paramProducer);
    }
  }
  
  static final class ConcatMapSubscriber<T, R>
    extends Subscriber<T>
  {
    volatile boolean active;
    final Subscriber<? super R> actual;
    final ProducerArbiter arbiter;
    final int delayErrorMode;
    volatile boolean done;
    final AtomicReference<Throwable> error;
    final SerialSubscription inner;
    final Func1<? super T, ? extends Observable<? extends R>> mapper;
    final Queue<Object> queue;
    final AtomicInteger wip;
    
    public ConcatMapSubscriber(Subscriber<? super R> paramSubscriber, Func1<? super T, ? extends Observable<? extends R>> paramFunc1, int paramInt1, int paramInt2)
    {
      this.actual = paramSubscriber;
      this.mapper = paramFunc1;
      this.delayErrorMode = paramInt2;
      this.arbiter = new ProducerArbiter();
      this.wip = new AtomicInteger();
      this.error = new AtomicReference();
      if (UnsafeAccess.isUnsafeAvailable()) {
        paramSubscriber = new SpscArrayQueue(paramInt1);
      } else {
        paramSubscriber = new SpscAtomicArrayQueue(paramInt1);
      }
      this.queue = paramSubscriber;
      this.inner = new SerialSubscription();
      request(paramInt1);
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void drainError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerCompleted(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerError(Throwable arg1, long arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void innerNext(R paramR)
    {
      this.actual.onNext(paramR);
    }
    
    public void onCompleted()
    {
      this.done = true;
      drain();
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
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void pluginError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void requestMore(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeConcatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */