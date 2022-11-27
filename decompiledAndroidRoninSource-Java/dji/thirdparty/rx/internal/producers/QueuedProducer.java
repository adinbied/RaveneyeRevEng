package dji.thirdparty.rx.internal.producers;

import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.exceptions.MissingBackpressureException;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class QueuedProducer<T>
  extends AtomicLong
  implements Producer, Observer<T>
{
  static final Object NULL_SENTINEL = new Object();
  private static final long serialVersionUID = 7277121710709137047L;
  final Subscriber<? super T> child;
  volatile boolean done;
  Throwable error;
  final Queue<Object> queue;
  final AtomicInteger wip;
  
  public QueuedProducer(Subscriber<? super T> paramSubscriber)
  {
    this(paramSubscriber, (Queue)localObject);
  }
  
  public QueuedProducer(Subscriber<? super T> paramSubscriber, Queue<Object> paramQueue)
  {
    this.child = paramSubscriber;
    this.queue = paramQueue;
    this.wip = new AtomicInteger();
  }
  
  private boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2)
  {
    return false;
  }
  
  /* Error */
  private void drain()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean offer(T paramT)
  {
    return false;
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
  
  public void onNext(T paramT)
  {
    if (!offer(paramT)) {
      onError(new MissingBackpressureException());
    }
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\producers\QueuedProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */