package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class QueueDrainObserver<T, U, V>
  extends QueueDrainSubscriberPad2
  implements Observer<T>, ObservableQueueDrain<U, V>
{
  protected volatile boolean cancelled;
  protected volatile boolean done;
  protected final Observer<? super V> downstream;
  protected Throwable error;
  protected final SimplePlainQueue<U> queue;
  
  public QueueDrainObserver(Observer<? super V> paramObserver, SimplePlainQueue<U> paramSimplePlainQueue)
  {
    this.downstream = paramObserver;
    this.queue = paramSimplePlainQueue;
  }
  
  public void accept(Observer<? super V> paramObserver, U paramU) {}
  
  public final boolean cancelled()
  {
    return this.cancelled;
  }
  
  public final boolean done()
  {
    return this.done;
  }
  
  public final boolean enter()
  {
    return false;
  }
  
  public final Throwable error()
  {
    return this.error;
  }
  
  public final boolean fastEnter()
  {
    return false;
  }
  
  /* Error */
  protected final void fastPathEmit(U arg1, boolean arg2, io.reactivex.disposables.Disposable arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected final void fastPathOrderedEmit(U arg1, boolean arg2, io.reactivex.disposables.Disposable arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final int leave(int paramInt)
  {
    return this.wip.addAndGet(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\QueueDrainObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */