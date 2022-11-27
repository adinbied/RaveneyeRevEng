package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.internal.util.RxRingBuffer;
import dji.thirdparty.rx.internal.util.atomic.SpscAtomicArrayQueue;
import dji.thirdparty.rx.internal.util.unsafe.SpscArrayQueue;
import dji.thirdparty.rx.internal.util.unsafe.UnsafeAccess;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public final class OperatorObserveOn<T>
  implements Observable.Operator<T, T>
{
  private final boolean delayError;
  private final Scheduler scheduler;
  
  public OperatorObserveOn(Scheduler paramScheduler, boolean paramBoolean)
  {
    this.scheduler = paramScheduler;
    this.delayError = paramBoolean;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  private static final class ObserveOnSubscriber<T>
    extends Subscriber<T>
    implements Action0
  {
    final Subscriber<? super T> child;
    final AtomicLong counter = new AtomicLong();
    final boolean delayError;
    Throwable error;
    volatile boolean finished;
    final NotificationLite<T> on;
    final Queue<Object> queue;
    final Scheduler.Worker recursiveScheduler;
    final AtomicLong requested = new AtomicLong();
    
    public ObserveOnSubscriber(Scheduler paramScheduler, Subscriber<? super T> paramSubscriber, boolean paramBoolean)
    {
      this.child = paramSubscriber;
      this.recursiveScheduler = paramScheduler.createWorker();
      this.delayError = paramBoolean;
      this.on = NotificationLite.instance();
      if (UnsafeAccess.isUnsafeAvailable())
      {
        this.queue = new SpscArrayQueue(RxRingBuffer.SIZE);
        return;
      }
      this.queue = new SpscAtomicArrayQueue(RxRingBuffer.SIZE);
    }
    
    /* Error */
    public void call()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super T> paramSubscriber, Queue<Object> paramQueue)
    {
      return false;
    }
    
    /* Error */
    void init()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onCompleted()
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
    
    public void onStart()
    {
      request(RxRingBuffer.SIZE);
    }
    
    /* Error */
    protected void schedule()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorObserveOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */