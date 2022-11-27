package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublishAlt<T>
  extends ConnectableFlowable<T>
  implements HasUpstreamPublisher<T>, ResettableConnectable
{
  final int bufferSize;
  final AtomicReference<PublishConnection<T>> current;
  final Publisher<T> source;
  
  public FlowablePublishAlt(Publisher<T> paramPublisher, int paramInt)
  {
    this.source = paramPublisher;
    this.bufferSize = paramInt;
    this.current = new AtomicReference();
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
  
  /* Error */
  public void resetIf(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Publisher<T> source()
  {
    return this.source;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class InnerSubscription<T>
    extends AtomicLong
    implements Subscription
  {
    private static final long serialVersionUID = 2845000326761540265L;
    final Subscriber<? super T> downstream;
    long emitted;
    final FlowablePublishAlt.PublishConnection<T> parent;
    
    InnerSubscription(Subscriber<? super T> paramSubscriber, FlowablePublishAlt.PublishConnection<T> paramPublishConnection)
    {
      this.downstream = paramSubscriber;
      this.parent = paramPublishConnection;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isCancelled()
    {
      return false;
    }
    
    public void request(long paramLong)
    {
      BackpressureHelper.addCancel(this, paramLong);
      this.parent.drain();
    }
  }
  
  static final class PublishConnection<T>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Disposable
  {
    static final FlowablePublishAlt.InnerSubscription[] EMPTY = new FlowablePublishAlt.InnerSubscription[0];
    static final FlowablePublishAlt.InnerSubscription[] TERMINATED = new FlowablePublishAlt.InnerSubscription[0];
    private static final long serialVersionUID = -1672047311619175801L;
    final int bufferSize;
    final AtomicBoolean connect;
    int consumed;
    final AtomicReference<PublishConnection<T>> current;
    volatile boolean done;
    Throwable error;
    volatile SimpleQueue<T> queue;
    int sourceMode;
    final AtomicReference<FlowablePublishAlt.InnerSubscription<T>[]> subscribers;
    final AtomicReference<Subscription> upstream;
    
    PublishConnection(AtomicReference<PublishConnection<T>> paramAtomicReference, int paramInt)
    {
      this.current = paramAtomicReference;
      this.upstream = new AtomicReference();
      this.connect = new AtomicBoolean();
      this.bufferSize = paramInt;
      this.subscribers = new AtomicReference(EMPTY);
    }
    
    boolean add(FlowablePublishAlt.InnerSubscription<T> paramInnerSubscription)
    {
      return false;
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2)
    {
      return false;
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    public void onComplete()
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
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void remove(FlowablePublishAlt.InnerSubscription<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void signalError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowablePublishAlt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */