package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZip<T, R>
  extends Flowable<R>
{
  final int bufferSize;
  final boolean delayError;
  final Publisher<? extends T>[] sources;
  final Iterable<? extends Publisher<? extends T>> sourcesIterable;
  final Function<? super Object[], ? extends R> zipper;
  
  public FlowableZip(Publisher<? extends T>[] paramArrayOfPublisher, Iterable<? extends Publisher<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction, int paramInt, boolean paramBoolean)
  {
    this.sources = paramArrayOfPublisher;
    this.sourcesIterable = paramIterable;
    this.zipper = paramFunction;
    this.bufferSize = paramInt;
    this.delayError = paramBoolean;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ZipCoordinator<T, R>
    extends AtomicInteger
    implements Subscription
  {
    private static final long serialVersionUID = -2434867452883857743L;
    volatile boolean cancelled;
    final Object[] current;
    final boolean delayErrors;
    final Subscriber<? super R> downstream;
    final AtomicThrowable errors;
    final AtomicLong requested;
    final FlowableZip.ZipSubscriber<T, R>[] subscribers;
    final Function<? super Object[], ? extends R> zipper;
    
    ZipCoordinator(Subscriber<? super R> paramSubscriber, Function<? super Object[], ? extends R> paramFunction, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.downstream = paramSubscriber;
      this.zipper = paramFunction;
      this.delayErrors = paramBoolean;
      paramSubscriber = new FlowableZip.ZipSubscriber[paramInt1];
      int i = 0;
      while (i < paramInt1)
      {
        paramSubscriber[i] = new FlowableZip.ZipSubscriber(this, paramInt2);
        i += 1;
      }
      this.current = new Object[paramInt1];
      this.subscribers = paramSubscriber;
      this.requested = new AtomicLong();
      this.errors = new AtomicThrowable();
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
    void cancelAll()
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
    
    /* Error */
    void error(FlowableZip.ZipSubscriber<T, R> arg1, Throwable arg2)
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
    
    /* Error */
    void subscribe(Publisher<? extends T>[] arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class ZipSubscriber<T, R>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = -4627193790118206028L;
    volatile boolean done;
    final int limit;
    final FlowableZip.ZipCoordinator<T, R> parent;
    final int prefetch;
    long produced;
    SimpleQueue<T> queue;
    int sourceMode;
    
    ZipSubscriber(FlowableZip.ZipCoordinator<T, R> paramZipCoordinator, int paramInt)
    {
      this.parent = paramZipCoordinator;
      this.prefetch = paramInt;
      this.limit = (paramInt - (paramInt >> 2));
    }
    
    public void cancel()
    {
      SubscriptionHelper.cancel(this);
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.error(this, paramThrowable);
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
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableZip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */