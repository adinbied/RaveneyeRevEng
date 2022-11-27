package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.internal.util.LinkedArrayList;
import dji.thirdparty.rx.subscriptions.SerialSubscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class CachedObservable<T>
  extends Observable<T>
{
  private final CacheState<T> state;
  
  private CachedObservable(Observable.OnSubscribe<T> paramOnSubscribe, CacheState<T> paramCacheState)
  {
    super(paramOnSubscribe);
    this.state = paramCacheState;
  }
  
  public static <T> CachedObservable<T> from(Observable<? extends T> paramObservable)
  {
    return from(paramObservable, 16);
  }
  
  public static <T> CachedObservable<T> from(Observable<? extends T> paramObservable, int paramInt)
  {
    if (paramInt >= 1)
    {
      paramObservable = new CacheState(paramObservable, paramInt);
      return new CachedObservable(new CachedSubscribe(paramObservable), paramObservable);
    }
    throw new IllegalArgumentException("capacityHint > 0 required");
  }
  
  boolean hasObservers()
  {
    return false;
  }
  
  boolean isConnected()
  {
    return this.state.isConnected;
  }
  
  static final class CacheState<T>
    extends LinkedArrayList
    implements Observer<T>
  {
    static final CachedObservable.ReplayProducer<?>[] EMPTY = new CachedObservable.ReplayProducer[0];
    final SerialSubscription connection;
    volatile boolean isConnected;
    final NotificationLite<T> nl;
    volatile CachedObservable.ReplayProducer<?>[] producers;
    final Observable<? extends T> source;
    boolean sourceDone;
    
    public CacheState(Observable<? extends T> paramObservable, int paramInt)
    {
      super();
      this.source = paramObservable;
      this.producers = EMPTY;
      this.nl = NotificationLite.instance();
      this.connection = new SerialSubscription();
    }
    
    /* Error */
    public void addProducer(CachedObservable.ReplayProducer<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void connect()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void dispatch()
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
    
    /* Error */
    public void removeProducer(CachedObservable.ReplayProducer<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  static final class CachedSubscribe<T>
    extends AtomicBoolean
    implements Observable.OnSubscribe<T>
  {
    private static final long serialVersionUID = -2817751667698696782L;
    final CachedObservable.CacheState<T> state;
    
    public CachedSubscribe(CachedObservable.CacheState<T> paramCacheState)
    {
      this.state = paramCacheState;
    }
    
    /* Error */
    public void call(Subscriber<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class ReplayProducer<T>
    extends AtomicLong
    implements Producer, Subscription
  {
    private static final long serialVersionUID = -2557562030197141021L;
    final Subscriber<? super T> child;
    Object[] currentBuffer;
    int currentIndexInBuffer;
    boolean emitting;
    int index;
    boolean missed;
    final CachedObservable.CacheState<T> state;
    
    public ReplayProducer(Subscriber<? super T> paramSubscriber, CachedObservable.CacheState<T> paramCacheState)
    {
      this.child = paramSubscriber;
      this.state = paramCacheState;
    }
    
    public boolean isUnsubscribed()
    {
      return false;
    }
    
    public long produced(long paramLong)
    {
      return addAndGet(-paramLong);
    }
    
    /* Error */
    public void replay()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\CachedObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */