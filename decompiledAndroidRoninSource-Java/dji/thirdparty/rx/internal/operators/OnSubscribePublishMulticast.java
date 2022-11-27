package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.internal.util.atomic.SpscAtomicArrayQueue;
import dji.thirdparty.rx.internal.util.unsafe.SpscArrayQueue;
import dji.thirdparty.rx.internal.util.unsafe.UnsafeAccess;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class OnSubscribePublishMulticast<T>
  extends AtomicInteger
  implements Observable.OnSubscribe<T>, Observer<T>, Subscription
{
  static final PublishProducer<?>[] EMPTY = new PublishProducer[0];
  static final PublishProducer<?>[] TERMINATED = new PublishProducer[0];
  private static final long serialVersionUID = -3741892510772238743L;
  final boolean delayError;
  volatile boolean done;
  Throwable error;
  final ParentSubscriber<T> parent;
  final int prefetch;
  volatile Producer producer;
  final Queue<T> queue;
  volatile PublishProducer<T>[] subscribers;
  
  public OnSubscribePublishMulticast(int paramInt, boolean paramBoolean)
  {
    if (paramInt > 0)
    {
      this.prefetch = paramInt;
      this.delayError = paramBoolean;
      if (UnsafeAccess.isUnsafeAvailable()) {
        this.queue = new SpscArrayQueue(paramInt);
      } else {
        this.queue = new SpscAtomicArrayQueue(paramInt);
      }
      this.subscribers = ((PublishProducer[])EMPTY);
      this.parent = new ParentSubscriber(this);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("prefetch > 0 required but it was ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  boolean add(PublishProducer<T> paramPublishProducer)
  {
    return false;
  }
  
  /* Error */
  public void call(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2)
  {
    return false;
  }
  
  /* Error */
  void drain()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isUnsubscribed()
  {
    return this.parent.isUnsubscribed();
  }
  
  public void onCompleted()
  {
    this.done = true;
    drain();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.error = paramThrowable;
    this.done = true;
    drain();
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
  void remove(PublishProducer<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void setProducer(Producer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Subscriber<T> subscriber()
  {
    return this.parent;
  }
  
  PublishProducer<T>[] terminate()
  {
    return null;
  }
  
  public void unsubscribe()
  {
    this.parent.unsubscribe();
  }
  
  static final class ParentSubscriber<T>
    extends Subscriber<T>
  {
    final OnSubscribePublishMulticast<T> state;
    
    public ParentSubscriber(OnSubscribePublishMulticast<T> paramOnSubscribePublishMulticast)
    {
      this.state = paramOnSubscribePublishMulticast;
    }
    
    public void onCompleted()
    {
      this.state.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.state.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.state.onNext(paramT);
    }
    
    public void setProducer(Producer paramProducer)
    {
      this.state.setProducer(paramProducer);
    }
  }
  
  static final class PublishProducer<T>
    extends AtomicLong
    implements Producer, Subscription
  {
    private static final long serialVersionUID = 960704844171597367L;
    final Subscriber<? super T> actual;
    final AtomicBoolean once;
    final OnSubscribePublishMulticast<T> parent;
    
    public PublishProducer(Subscriber<? super T> paramSubscriber, OnSubscribePublishMulticast<T> paramOnSubscribePublishMulticast)
    {
      this.actual = paramSubscriber;
      this.parent = paramOnSubscribePublishMulticast;
      this.once = new AtomicBoolean();
    }
    
    public boolean isUnsubscribed()
    {
      return this.once.get();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribePublishMulticast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */