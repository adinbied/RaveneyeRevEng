package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicLong;

final class TakeLastQueueProducer<T>
  extends AtomicLong
  implements Producer
{
  private final Deque<Object> deque;
  private volatile boolean emittingStarted = false;
  private final NotificationLite<T> notification;
  private final Subscriber<? super T> subscriber;
  
  public TakeLastQueueProducer(NotificationLite<T> paramNotificationLite, Deque<Object> paramDeque, Subscriber<? super T> paramSubscriber)
  {
    this.notification = paramNotificationLite;
    this.deque = paramDeque;
    this.subscriber = paramSubscriber;
  }
  
  /* Error */
  void emit(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
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
  void startEmitting()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\TakeLastQueueProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */