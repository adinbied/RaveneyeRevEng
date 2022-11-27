package io.reactivex.internal.subscriptions;

import org.reactivestreams.Subscriber;

public class DeferredScalarSubscription<T>
  extends BasicIntQueueSubscription<T>
{
  static final int CANCELLED = 4;
  static final int FUSED_CONSUMED = 32;
  static final int FUSED_EMPTY = 8;
  static final int FUSED_READY = 16;
  static final int HAS_REQUEST_HAS_VALUE = 3;
  static final int HAS_REQUEST_NO_VALUE = 2;
  static final int NO_REQUEST_HAS_VALUE = 1;
  static final int NO_REQUEST_NO_VALUE = 0;
  private static final long serialVersionUID = -2151279923272604993L;
  protected final Subscriber<? super T> downstream;
  protected T value;
  
  public DeferredScalarSubscription(Subscriber<? super T> paramSubscriber)
  {
    this.downstream = paramSubscriber;
  }
  
  public void cancel()
  {
    set(4);
    this.value = null;
  }
  
  /* Error */
  public final void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void complete(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final boolean isCancelled()
  {
    return false;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  public final T poll()
  {
    return null;
  }
  
  /* Error */
  public final void request(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public final int requestFusion(int paramInt)
  {
    return 0;
  }
  
  public final boolean tryCancel()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscriptions\DeferredScalarSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */