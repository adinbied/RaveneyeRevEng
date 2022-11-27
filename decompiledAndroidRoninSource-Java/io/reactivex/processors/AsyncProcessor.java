package io.reactivex.processors;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class AsyncProcessor<T>
  extends FlowableProcessor<T>
{
  static final AsyncSubscription[] EMPTY = new AsyncSubscription[0];
  static final AsyncSubscription[] TERMINATED = new AsyncSubscription[0];
  Throwable error;
  final AtomicReference<AsyncSubscription<T>[]> subscribers = new AtomicReference(EMPTY);
  T value;
  
  @CheckReturnValue
  public static <T> AsyncProcessor<T> create()
  {
    return new AsyncProcessor();
  }
  
  boolean add(AsyncSubscription<T> paramAsyncSubscription)
  {
    return false;
  }
  
  public Throwable getThrowable()
  {
    return null;
  }
  
  public T getValue()
  {
    return null;
  }
  
  @Deprecated
  public Object[] getValues()
  {
    return null;
  }
  
  @Deprecated
  public T[] getValues(T[] paramArrayOfT)
  {
    return null;
  }
  
  public boolean hasComplete()
  {
    return false;
  }
  
  public boolean hasSubscribers()
  {
    return false;
  }
  
  public boolean hasThrowable()
  {
    return false;
  }
  
  public boolean hasValue()
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
  public void onSubscribe(org.reactivestreams.Subscription arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void remove(AsyncSubscription<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class AsyncSubscription<T>
    extends DeferredScalarSubscription<T>
  {
    private static final long serialVersionUID = 5629876084736248016L;
    final AsyncProcessor<T> parent;
    
    AsyncSubscription(Subscriber<? super T> paramSubscriber, AsyncProcessor<T> paramAsyncProcessor)
    {
      super();
      this.parent = paramAsyncProcessor;
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
    void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\processors\AsyncProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */