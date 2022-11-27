package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublish<T>
  extends ConnectableFlowable<T>
  implements HasUpstreamPublisher<T>, FlowablePublishClassic<T>
{
  static final long CANCELLED = Long.MIN_VALUE;
  final int bufferSize;
  final AtomicReference<PublishSubscriber<T>> current;
  final Publisher<T> onSubscribe;
  final Flowable<T> source;
  
  private FlowablePublish(Publisher<T> paramPublisher, Flowable<T> paramFlowable, AtomicReference<PublishSubscriber<T>> paramAtomicReference, int paramInt)
  {
    this.onSubscribe = paramPublisher;
    this.source = paramFlowable;
    this.current = paramAtomicReference;
    this.bufferSize = paramInt;
  }
  
  public static <T> ConnectableFlowable<T> create(Flowable<T> paramFlowable, int paramInt)
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return RxJavaPlugins.onAssembly(new FlowablePublish(new FlowablePublisher(localAtomicReference, paramInt), paramFlowable, localAtomicReference, paramInt));
  }
  
  /* Error */
  public void connect(io.reactivex.functions.Consumer<? super Disposable> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public int publishBufferSize()
  {
    return this.bufferSize;
  }
  
  public Publisher<T> publishSource()
  {
    return this.source;
  }
  
  public Publisher<T> source()
  {
    return this.source;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber)
  {
    this.onSubscribe.subscribe(paramSubscriber);
  }
  
  static final class FlowablePublisher<T>
    implements Publisher<T>
  {
    private final int bufferSize;
    private final AtomicReference<FlowablePublish.PublishSubscriber<T>> curr;
    
    FlowablePublisher(AtomicReference<FlowablePublish.PublishSubscriber<T>> paramAtomicReference, int paramInt)
    {
      this.curr = paramAtomicReference;
      this.bufferSize = paramInt;
    }
    
    /* Error */
    public void subscribe(Subscriber<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class InnerSubscriber<T>
    extends AtomicLong
    implements Subscription
  {
    private static final long serialVersionUID = -4453897557930727610L;
    final Subscriber<? super T> child;
    long emitted;
    volatile FlowablePublish.PublishSubscriber<T> parent;
    
    InnerSubscriber(Subscriber<? super T> paramSubscriber)
    {
      this.child = paramSubscriber;
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
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
  
  static final class PublishSubscriber<T>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Disposable
  {
    static final FlowablePublish.InnerSubscriber[] EMPTY = new FlowablePublish.InnerSubscriber[0];
    static final FlowablePublish.InnerSubscriber[] TERMINATED = new FlowablePublish.InnerSubscriber[0];
    private static final long serialVersionUID = -202316842419149694L;
    final int bufferSize;
    final AtomicReference<PublishSubscriber<T>> current;
    volatile SimpleQueue<T> queue;
    final AtomicBoolean shouldConnect;
    int sourceMode;
    final AtomicReference<FlowablePublish.InnerSubscriber<T>[]> subscribers = new AtomicReference(EMPTY);
    volatile Object terminalEvent;
    final AtomicReference<Subscription> upstream = new AtomicReference();
    
    PublishSubscriber(AtomicReference<PublishSubscriber<T>> paramAtomicReference, int paramInt)
    {
      this.current = paramAtomicReference;
      this.shouldConnect = new AtomicBoolean();
      this.bufferSize = paramInt;
    }
    
    boolean add(FlowablePublish.InnerSubscriber<T> paramInnerSubscriber)
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
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void remove(FlowablePublish.InnerSubscriber<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowablePublish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */