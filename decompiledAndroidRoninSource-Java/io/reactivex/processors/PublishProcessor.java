package io.reactivex.processors;

import io.reactivex.annotations.CheckReturnValue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class PublishProcessor<T>
  extends FlowableProcessor<T>
{
  static final PublishSubscription[] EMPTY = new PublishSubscription[0];
  static final PublishSubscription[] TERMINATED = new PublishSubscription[0];
  Throwable error;
  final AtomicReference<PublishSubscription<T>[]> subscribers = new AtomicReference(EMPTY);
  
  @CheckReturnValue
  public static <T> PublishProcessor<T> create()
  {
    return new PublishProcessor();
  }
  
  boolean add(PublishSubscription<T> paramPublishSubscription)
  {
    return false;
  }
  
  public Throwable getThrowable()
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
  
  public boolean offer(T paramT)
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
  void remove(PublishSubscription<T> arg1)
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
  
  static final class PublishSubscription<T>
    extends AtomicLong
    implements Subscription
  {
    private static final long serialVersionUID = 3562861878281475070L;
    final Subscriber<? super T> downstream;
    final PublishProcessor<T> parent;
    
    PublishSubscription(Subscriber<? super T> paramSubscriber, PublishProcessor<T> paramPublishProcessor)
    {
      this.downstream = paramSubscriber;
      this.parent = paramPublishProcessor;
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
    
    boolean isFull()
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
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\processors\PublishProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */