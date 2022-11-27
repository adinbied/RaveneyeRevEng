package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class ScalarSubscription<T>
  extends AtomicInteger
  implements QueueSubscription<T>
{
  static final int CANCELLED = 2;
  static final int NO_REQUEST = 0;
  static final int REQUESTED = 1;
  private static final long serialVersionUID = -3830916580126663321L;
  final Subscriber<? super T> subscriber;
  final T value;
  
  public ScalarSubscription(Subscriber<? super T> paramSubscriber, T paramT)
  {
    this.subscriber = paramSubscriber;
    this.value = paramT;
  }
  
  public void cancel()
  {
    lazySet(2);
  }
  
  public void clear()
  {
    lazySet(1);
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean offer(T paramT)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public boolean offer(T paramT1, T paramT2)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public T poll()
  {
    return null;
  }
  
  /* Error */
  public void request(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public int requestFusion(int paramInt)
  {
    return paramInt & 0x1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscriptions\ScalarSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */