package dji.thirdparty.rx.internal.producers;

import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class QueuedValueProducer<T>
  extends AtomicLong
  implements Producer
{
  static final Object NULL_SENTINEL = new Object();
  private static final long serialVersionUID = 7277121710709137047L;
  final Subscriber<? super T> child;
  final Queue<Object> queue;
  final AtomicInteger wip;
  
  public QueuedValueProducer(Subscriber<? super T> paramSubscriber)
  {
    this(paramSubscriber, (Queue)localObject);
  }
  
  public QueuedValueProducer(Subscriber<? super T> paramSubscriber, Queue<Object> paramQueue)
  {
    this.child = paramSubscriber;
    this.queue = paramQueue;
    this.wip = new AtomicInteger();
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
  
  /* Error */
  public void request(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\producers\QueuedValueProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */