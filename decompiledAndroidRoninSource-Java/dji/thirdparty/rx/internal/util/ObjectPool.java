package dji.thirdparty.rx.internal.util;

import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.internal.schedulers.SchedulerLifecycle;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ObjectPool<T>
  implements SchedulerLifecycle
{
  final int maxSize;
  final int minSize;
  Queue<T> pool;
  private final AtomicReference<Scheduler.Worker> schedulerWorker;
  private final long validationInterval;
  
  public ObjectPool()
  {
    this(0, 0, 67L);
  }
  
  private ObjectPool(int paramInt1, int paramInt2, long paramLong)
  {
    this.minSize = paramInt1;
    this.maxSize = paramInt2;
    this.validationInterval = paramLong;
    this.schedulerWorker = new AtomicReference();
    initialize(paramInt1);
    start();
  }
  
  /* Error */
  private void initialize(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public T borrowObject()
  {
    return null;
  }
  
  protected abstract T createObject();
  
  /* Error */
  public void returnObject(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void shutdown()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\ObjectPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */