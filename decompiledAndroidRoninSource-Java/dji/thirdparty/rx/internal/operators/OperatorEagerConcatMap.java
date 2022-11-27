package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.internal.util.atomic.SpscAtomicArrayQueue;
import dji.thirdparty.rx.internal.util.unsafe.SpscArrayQueue;
import dji.thirdparty.rx.internal.util.unsafe.UnsafeAccess;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class OperatorEagerConcatMap<T, R>
  implements Observable.Operator<R, T>
{
  final int bufferSize;
  final Func1<? super T, ? extends Observable<? extends R>> mapper;
  
  public OperatorEagerConcatMap(Func1<? super T, ? extends Observable<? extends R>> paramFunc1, int paramInt)
  {
    this.mapper = paramFunc1;
    this.bufferSize = paramInt;
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    return null;
  }
  
  static final class EagerInnerSubscriber<T>
    extends Subscriber<T>
  {
    volatile boolean done;
    Throwable error;
    final NotificationLite<T> nl;
    final OperatorEagerConcatMap.EagerOuterSubscriber<?, T> parent;
    final Queue<Object> queue;
    
    public EagerInnerSubscriber(OperatorEagerConcatMap.EagerOuterSubscriber<?, T> paramEagerOuterSubscriber, int paramInt)
    {
      this.parent = paramEagerOuterSubscriber;
      if (UnsafeAccess.isUnsafeAvailable()) {
        paramEagerOuterSubscriber = new SpscArrayQueue(paramInt);
      } else {
        paramEagerOuterSubscriber = new SpscAtomicArrayQueue(paramInt);
      }
      this.queue = paramEagerOuterSubscriber;
      this.nl = NotificationLite.instance();
      request(paramInt);
    }
    
    /* Error */
    public void onCompleted()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      this.done = true;
      this.parent.drain();
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void requestMore(long paramLong)
    {
      request(paramLong);
    }
  }
  
  static final class EagerOuterProducer
    extends AtomicLong
    implements Producer
  {
    private static final long serialVersionUID = -657299606803478389L;
    final OperatorEagerConcatMap.EagerOuterSubscriber<?, ?> parent;
    
    public EagerOuterProducer(OperatorEagerConcatMap.EagerOuterSubscriber<?, ?> paramEagerOuterSubscriber)
    {
      this.parent = paramEagerOuterSubscriber;
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
  
  static final class EagerOuterSubscriber<T, R>
    extends Subscriber<T>
  {
    final Subscriber<? super R> actual;
    final int bufferSize;
    volatile boolean cancelled;
    volatile boolean done;
    Throwable error;
    final Func1<? super T, ? extends Observable<? extends R>> mapper;
    private OperatorEagerConcatMap.EagerOuterProducer sharedProducer;
    final LinkedList<OperatorEagerConcatMap.EagerInnerSubscriber<R>> subscribers;
    final AtomicInteger wip;
    
    public EagerOuterSubscriber(Func1<? super T, ? extends Observable<? extends R>> paramFunc1, int paramInt, Subscriber<? super R> paramSubscriber)
    {
      this.mapper = paramFunc1;
      this.bufferSize = paramInt;
      this.actual = paramSubscriber;
      this.subscribers = new LinkedList();
      this.wip = new AtomicInteger();
    }
    
    /* Error */
    void cleanup()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
    void init()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onCompleted()
    {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      this.done = true;
      drain();
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorEagerConcatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */