package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import org.reactivestreams.Subscriber;

public final class FlowableRange
  extends Flowable<Integer>
{
  final int end;
  final int start;
  
  public FlowableRange(int paramInt1, int paramInt2)
  {
    this.start = paramInt1;
    this.end = (paramInt1 + paramInt2);
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super Integer> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static abstract class BaseRangeSubscription
    extends BasicQueueSubscription<Integer>
  {
    private static final long serialVersionUID = -2252972430506210021L;
    volatile boolean cancelled;
    final int end;
    int index;
    
    BaseRangeSubscription(int paramInt1, int paramInt2)
    {
      this.index = paramInt1;
      this.end = paramInt2;
    }
    
    public final void cancel()
    {
      this.cancelled = true;
    }
    
    public final void clear()
    {
      this.index = this.end;
    }
    
    abstract void fastPath();
    
    public final boolean isEmpty()
    {
      return false;
    }
    
    public final Integer poll()
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
  
  static final class RangeConditionalSubscription
    extends FlowableRange.BaseRangeSubscription
  {
    private static final long serialVersionUID = 2587302975077663557L;
    final ConditionalSubscriber<? super Integer> downstream;
    
    RangeConditionalSubscription(ConditionalSubscriber<? super Integer> paramConditionalSubscriber, int paramInt1, int paramInt2)
    {
      super(paramInt2);
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
  
  static final class RangeSubscription
    extends FlowableRange.BaseRangeSubscription
  {
    private static final long serialVersionUID = 2587302975077663557L;
    final Subscriber<? super Integer> downstream;
    
    RangeSubscription(Subscriber<? super Integer> paramSubscriber, int paramInt1, int paramInt2)
    {
      super(paramInt2);
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */