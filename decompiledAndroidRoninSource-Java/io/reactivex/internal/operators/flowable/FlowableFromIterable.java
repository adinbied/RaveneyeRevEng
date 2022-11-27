package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Iterator;
import org.reactivestreams.Subscriber;

public final class FlowableFromIterable<T>
  extends Flowable<T>
{
  final Iterable<? extends T> source;
  
  public FlowableFromIterable(Iterable<? extends T> paramIterable)
  {
    this.source = paramIterable;
  }
  
  public static <T> void subscribe(Subscriber<? super T> paramSubscriber, Iterator<? extends T> paramIterator)
  {
    try
    {
      boolean bool = paramIterator.hasNext();
      if (!bool)
      {
        EmptySubscription.complete(paramSubscriber);
        return;
      }
      if ((paramSubscriber instanceof ConditionalSubscriber))
      {
        paramSubscriber.onSubscribe(new IteratorConditionalSubscription((ConditionalSubscriber)paramSubscriber, paramIterator));
        return;
      }
      paramSubscriber.onSubscribe(new IteratorSubscription(paramSubscriber, paramIterator));
      return;
    }
    finally
    {
      Exceptions.throwIfFatal(paramIterator);
      EmptySubscription.error(paramIterator, paramSubscriber);
    }
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static abstract class BaseRangeSubscription<T>
    extends BasicQueueSubscription<T>
  {
    private static final long serialVersionUID = -2252972430506210021L;
    volatile boolean cancelled;
    Iterator<? extends T> it;
    boolean once;
    
    BaseRangeSubscription(Iterator<? extends T> paramIterator)
    {
      this.it = paramIterator;
    }
    
    public final void cancel()
    {
      this.cancelled = true;
    }
    
    public final void clear()
    {
      this.it = null;
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
  
  static final class IteratorConditionalSubscription<T>
    extends FlowableFromIterable.BaseRangeSubscription<T>
  {
    private static final long serialVersionUID = -6022804456014692607L;
    final ConditionalSubscriber<? super T> downstream;
    
    IteratorConditionalSubscription(ConditionalSubscriber<? super T> paramConditionalSubscriber, Iterator<? extends T> paramIterator)
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
      //   2: return
    }
    
    /* Error */
    void slowPath(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: return
    }
  }
  
  static final class IteratorSubscription<T>
    extends FlowableFromIterable.BaseRangeSubscription<T>
  {
    private static final long serialVersionUID = -6022804456014692607L;
    final Subscriber<? super T> downstream;
    
    IteratorSubscription(Subscriber<? super T> paramSubscriber, Iterator<? extends T> paramIterator)
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
      //   2: return
    }
    
    /* Error */
    void slowPath(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableFromIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */