package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class TestSubscriber<T>
  extends BaseTestConsumer<T, TestSubscriber<T>>
  implements FlowableSubscriber<T>, Subscription, Disposable
{
  private volatile boolean cancelled;
  private final Subscriber<? super T> downstream;
  private final AtomicLong missedRequested;
  private QueueSubscription<T> qs;
  private final AtomicReference<Subscription> upstream;
  
  public TestSubscriber()
  {
    this(EmptySubscriber.INSTANCE, Long.MAX_VALUE);
  }
  
  public TestSubscriber(long paramLong)
  {
    this(EmptySubscriber.INSTANCE, paramLong);
  }
  
  public TestSubscriber(Subscriber<? super T> paramSubscriber)
  {
    this(paramSubscriber, Long.MAX_VALUE);
  }
  
  public TestSubscriber(Subscriber<? super T> paramSubscriber, long paramLong)
  {
    if (paramLong >= 0L)
    {
      this.downstream = paramSubscriber;
      this.upstream = new AtomicReference();
      this.missedRequested = new AtomicLong(paramLong);
      return;
    }
    throw new IllegalArgumentException("Negative initial request not allowed");
  }
  
  public static <T> TestSubscriber<T> create()
  {
    return new TestSubscriber();
  }
  
  public static <T> TestSubscriber<T> create(long paramLong)
  {
    return new TestSubscriber(paramLong);
  }
  
  public static <T> TestSubscriber<T> create(Subscriber<? super T> paramSubscriber)
  {
    return new TestSubscriber(paramSubscriber);
  }
  
  static String fusionModeToString(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown(");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(")");
          return localStringBuilder.toString();
        }
        return "ASYNC";
      }
      return "SYNC";
    }
    return "NONE";
  }
  
  final TestSubscriber<T> assertFuseable()
  {
    return null;
  }
  
  final TestSubscriber<T> assertFusionMode(int paramInt)
  {
    return null;
  }
  
  final TestSubscriber<T> assertNotFuseable()
  {
    return null;
  }
  
  public final TestSubscriber<T> assertNotSubscribed()
  {
    return null;
  }
  
  public final TestSubscriber<T> assertOf(Consumer<? super TestSubscriber<T>> paramConsumer)
  {
    try
    {
      paramConsumer.accept(this);
      return this;
    }
    finally {}
  }
  
  public final TestSubscriber<T> assertSubscribed()
  {
    return null;
  }
  
  /* Error */
  public final void cancel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final void dispose()
  {
    cancel();
  }
  
  public final boolean hasSubscription()
  {
    return false;
  }
  
  public final boolean isCancelled()
  {
    return this.cancelled;
  }
  
  public final boolean isDisposed()
  {
    return this.cancelled;
  }
  
  /* Error */
  public void onComplete()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onError(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onNext(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected void onStart() {}
  
  /* Error */
  public void onSubscribe(Subscription arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public final void request(long paramLong)
  {
    SubscriptionHelper.deferredRequest(this.upstream, this.missedRequested, paramLong);
  }
  
  public final TestSubscriber<T> requestMore(long paramLong)
  {
    request(paramLong);
    return this;
  }
  
  final TestSubscriber<T> setInitialFusionMode(int paramInt)
  {
    this.initialFusionMode = paramInt;
    return this;
  }
  
  static enum EmptySubscriber
    implements FlowableSubscriber<Object>
  {
    static
    {
      EmptySubscriber localEmptySubscriber = new EmptySubscriber("INSTANCE", 0);
      INSTANCE = localEmptySubscriber;
      $VALUES = new EmptySubscriber[] { localEmptySubscriber };
    }
    
    private EmptySubscriber() {}
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable) {}
    
    public void onNext(Object paramObject) {}
    
    public void onSubscribe(Subscription paramSubscription) {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\subscribers\TestSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */