package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.internal.util.RxRingBuffer;
import dji.thirdparty.rx.internal.util.SynchronizedQueue;
import dji.thirdparty.rx.internal.util.unsafe.SpscArrayQueue;
import dji.thirdparty.rx.internal.util.unsafe.UnsafeAccess;
import dji.thirdparty.rx.observables.ConnectableObservable;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class OperatorPublish<T>
  extends ConnectableObservable<T>
{
  final AtomicReference<PublishSubscriber<T>> current;
  final Observable<? extends T> source;
  
  private OperatorPublish(Observable.OnSubscribe<T> paramOnSubscribe, Observable<? extends T> paramObservable, AtomicReference<PublishSubscriber<T>> paramAtomicReference)
  {
    super(paramOnSubscribe);
    this.source = paramObservable;
    this.current = paramAtomicReference;
  }
  
  public static <T, R> Observable<R> create(Observable<? extends T> paramObservable, Func1<? super Observable<T>, ? extends Observable<R>> paramFunc1)
  {
    return create(paramObservable, paramFunc1, false);
  }
  
  public static <T, R> Observable<R> create(final Observable<? extends T> paramObservable, final Func1<? super Observable<T>, ? extends Observable<R>> paramFunc1, boolean paramBoolean)
  {
    create(new Observable.OnSubscribe()
    {
      /* Error */
      public void call(Subscriber<? super R> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable)
  {
    AtomicReference localAtomicReference = new AtomicReference();
    new OperatorPublish(new Observable.OnSubscribe()
    {
      /* Error */
      public void call(Subscriber<? super T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    }, paramObservable, localAtomicReference);
  }
  
  /* Error */
  public void connect(dji.thirdparty.rx.functions.Action1<? super Subscription> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class InnerProducer<T>
    extends AtomicLong
    implements Producer, Subscription
  {
    static final long NOT_REQUESTED = -4611686018427387904L;
    static final long UNSUBSCRIBED = Long.MIN_VALUE;
    private static final long serialVersionUID = -4453897557930727610L;
    final Subscriber<? super T> child;
    final OperatorPublish.PublishSubscriber<T> parent;
    
    public InnerProducer(OperatorPublish.PublishSubscriber<T> paramPublishSubscriber, Subscriber<? super T> paramSubscriber)
    {
      this.parent = paramPublishSubscriber;
      this.child = paramSubscriber;
      lazySet(-4611686018427387904L);
    }
    
    public boolean isUnsubscribed()
    {
      return false;
    }
    
    public long produced(long paramLong)
    {
      return 277873872L;
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void unsubscribe()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class PublishSubscriber<T>
    extends Subscriber<T>
    implements Subscription
  {
    static final OperatorPublish.InnerProducer[] EMPTY = new OperatorPublish.InnerProducer[0];
    static final OperatorPublish.InnerProducer[] TERMINATED = new OperatorPublish.InnerProducer[0];
    final AtomicReference<PublishSubscriber<T>> current;
    boolean emitting;
    boolean missed;
    final NotificationLite<T> nl;
    final AtomicReference<OperatorPublish.InnerProducer[]> producers;
    final Queue<Object> queue;
    final AtomicBoolean shouldConnect;
    volatile Object terminalEvent;
    
    public PublishSubscriber(AtomicReference<PublishSubscriber<T>> paramAtomicReference)
    {
      Object localObject;
      if (UnsafeAccess.isUnsafeAvailable()) {
        localObject = new SpscArrayQueue(RxRingBuffer.SIZE);
      } else {
        localObject = new SynchronizedQueue(RxRingBuffer.SIZE);
      }
      this.queue = ((Queue)localObject);
      this.nl = NotificationLite.instance();
      this.producers = new AtomicReference(EMPTY);
      this.current = paramAtomicReference;
      this.shouldConnect = new AtomicBoolean();
    }
    
    boolean add(OperatorPublish.InnerProducer<T> paramInnerProducer)
    {
      return false;
    }
    
    boolean checkTerminated(Object paramObject, boolean paramBoolean)
    {
      return false;
    }
    
    /* Error */
    void dispatch()
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
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onStart()
    {
      request(RxRingBuffer.SIZE);
    }
    
    /* Error */
    void remove(OperatorPublish.InnerProducer<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorPublish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */