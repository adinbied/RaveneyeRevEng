package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRefCount<T>
  extends Flowable<T>
{
  RefConnection connection;
  final int n;
  final Scheduler scheduler;
  final ConnectableFlowable<T> source;
  final long timeout;
  final TimeUnit unit;
  
  public FlowableRefCount(ConnectableFlowable<T> paramConnectableFlowable)
  {
    this(paramConnectableFlowable, 1, 0L, TimeUnit.NANOSECONDS, null);
  }
  
  public FlowableRefCount(ConnectableFlowable<T> paramConnectableFlowable, int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    this.source = paramConnectableFlowable;
    this.n = paramInt;
    this.timeout = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
  }
  
  /* Error */
  void cancel(RefConnection arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void terminated(RefConnection arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void timeout(RefConnection arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class RefConnection
    extends AtomicReference<Disposable>
    implements Runnable, Consumer<Disposable>
  {
    private static final long serialVersionUID = -4552101107598366241L;
    boolean connected;
    boolean disconnectedEarly;
    final FlowableRefCount<?> parent;
    long subscriberCount;
    Disposable timer;
    
    RefConnection(FlowableRefCount<?> paramFlowableRefCount)
    {
      this.parent = paramFlowableRefCount;
    }
    
    /* Error */
    public void accept(Disposable arg1)
      throws java.lang.Exception
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void run()
    {
      this.parent.timeout(this);
    }
  }
  
  static final class RefCountSubscriber<T>
    extends AtomicBoolean
    implements FlowableSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = -7419642935409022375L;
    final FlowableRefCount.RefConnection connection;
    final Subscriber<? super T> downstream;
    final FlowableRefCount<T> parent;
    Subscription upstream;
    
    RefCountSubscriber(Subscriber<? super T> paramSubscriber, FlowableRefCount<T> paramFlowableRefCount, FlowableRefCount.RefConnection paramRefConnection)
    {
      this.downstream = paramSubscriber;
      this.parent = paramFlowableRefCount;
      this.connection = paramRefConnection;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    
    public void request(long paramLong)
    {
      this.upstream.request(paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableRefCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */