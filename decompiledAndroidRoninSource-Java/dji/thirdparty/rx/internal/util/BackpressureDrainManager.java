package dji.thirdparty.rx.internal.util;

import dji.thirdparty.rx.Producer;
import java.util.concurrent.atomic.AtomicLong;

public final class BackpressureDrainManager
  extends AtomicLong
  implements Producer
{
  protected final BackpressureQueueCallback actual;
  protected boolean emitting;
  protected Throwable exception;
  protected volatile boolean terminated;
  
  public BackpressureDrainManager(BackpressureQueueCallback paramBackpressureQueueCallback)
  {
    this.actual = paramBackpressureQueueCallback;
  }
  
  /* Error */
  public final void drain()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public final boolean isTerminated()
  {
    return this.terminated;
  }
  
  /* Error */
  public final void request(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public final void terminate()
  {
    this.terminated = true;
  }
  
  /* Error */
  public final void terminate(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final void terminateAndDrain()
  {
    this.terminated = true;
    drain();
  }
  
  /* Error */
  public final void terminateAndDrain(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface BackpressureQueueCallback
  {
    public abstract boolean accept(Object paramObject);
    
    public abstract void complete(Throwable paramThrowable);
    
    public abstract Object peek();
    
    public abstract Object poll();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\BackpressureDrainManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */