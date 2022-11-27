package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import org.reactivestreams.Subscriber;

public final class FlowableRangeLong
  extends Flowable<Long>
{
  final long end;
  final long start;
  
  public FlowableRangeLong(long paramLong1, long paramLong2)
  {
    this.start = paramLong1;
    this.end = (paramLong1 + paramLong2);
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super Long> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static abstract class BaseRangeSubscription
    extends BasicQueueSubscription<Long>
  {
    private static final long serialVersionUID = -2252972430506210021L;
    volatile boolean cancelled;
    final long end;
    long index;
    
    BaseRangeSubscription(long paramLong1, long paramLong2)
    {
      this.index = paramLong1;
      this.end = paramLong2;
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
    
    public final Long poll()
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
    extends FlowableRangeLong.BaseRangeSubscription
  {
    private static final long serialVersionUID = 2587302975077663557L;
    final ConditionalSubscriber<? super Long> downstream;
    
    RangeConditionalSubscription(ConditionalSubscriber<? super Long> paramConditionalSubscriber, long paramLong1, long paramLong2)
    {
      super(paramLong2);
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
    extends FlowableRangeLong.BaseRangeSubscription
  {
    private static final long serialVersionUID = 2587302975077663557L;
    final Subscriber<? super Long> downstream;
    
    RangeSubscription(Subscriber<? super Long> paramSubscriber, long paramLong1, long paramLong2)
    {
      super(paramLong2);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableRangeLong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */