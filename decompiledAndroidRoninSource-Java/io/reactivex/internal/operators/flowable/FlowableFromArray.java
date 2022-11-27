package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import org.reactivestreams.Subscriber;

public final class FlowableFromArray<T>
  extends Flowable<T>
{
  final T[] array;
  
  public FlowableFromArray(T[] paramArrayOfT)
  {
    this.array = paramArrayOfT;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ArrayConditionalSubscription<T>
    extends FlowableFromArray.BaseArraySubscription<T>
  {
    private static final long serialVersionUID = 2587302975077663557L;
    final ConditionalSubscriber<? super T> downstream;
    
    ArrayConditionalSubscription(ConditionalSubscriber<? super T> paramConditionalSubscriber, T[] paramArrayOfT)
    {
      super();
      this.downstream = paramConditionalSubscriber;
    }
    
    /* Error */
    void fastPath()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void slowPath(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
  
  static final class ArraySubscription<T>
    extends FlowableFromArray.BaseArraySubscription<T>
  {
    private static final long serialVersionUID = 2587302975077663557L;
    final Subscriber<? super T> downstream;
    
    ArraySubscription(Subscriber<? super T> paramSubscriber, T[] paramArrayOfT)
    {
      super();
      this.downstream = paramSubscriber;
    }
    
    /* Error */
    void fastPath()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void slowPath(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
  
  static abstract class BaseArraySubscription<T>
    extends BasicQueueSubscription<T>
  {
    private static final long serialVersionUID = -2252972430506210021L;
    final T[] array;
    volatile boolean cancelled;
    int index;
    
    BaseArraySubscription(T[] paramArrayOfT)
    {
      this.array = paramArrayOfT;
    }
    
    public final void cancel()
    {
      this.cancelled = true;
    }
    
    public final void clear()
    {
      this.index = this.array.length;
    }
    
    abstract void fastPath();
    
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
      return paramInt & 0x1;
    }
    
    abstract void slowPath(long paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableFromArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */