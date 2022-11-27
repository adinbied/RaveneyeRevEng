package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDoFinally<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final Action onFinally;
  
  public FlowableDoFinally(Flowable<T> paramFlowable, Action paramAction)
  {
    super(paramFlowable);
    this.onFinally = paramAction;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DoFinallyConditionalSubscriber<T>
    extends BasicIntQueueSubscription<T>
    implements ConditionalSubscriber<T>
  {
    private static final long serialVersionUID = 4109457741734051389L;
    final ConditionalSubscriber<? super T> downstream;
    final Action onFinally;
    QueueSubscription<T> qs;
    boolean syncFused;
    Subscription upstream;
    
    DoFinallyConditionalSubscriber(ConditionalSubscriber<? super T> paramConditionalSubscriber, Action paramAction)
    {
      this.downstream = paramConditionalSubscriber;
      this.onFinally = paramAction;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void clear()
    {
      this.qs.clear();
    }
    
    public boolean isEmpty()
    {
      return this.qs.isEmpty();
    }
    
    /* Error */
    public void onComplete()
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
    
    public void onNext(T paramT)
    {
      this.downstream.onNext(paramT);
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public T poll()
      throws Exception
    {
      return null;
    }
    
    public void request(long paramLong)
    {
      this.upstream.request(paramLong);
    }
    
    public int requestFusion(int paramInt)
    {
      return 0;
    }
    
    /* Error */
    void runFinally()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean tryOnNext(T paramT)
    {
      return this.downstream.tryOnNext(paramT);
    }
  }
  
  static final class DoFinallySubscriber<T>
    extends BasicIntQueueSubscription<T>
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = 4109457741734051389L;
    final Subscriber<? super T> downstream;
    final Action onFinally;
    QueueSubscription<T> qs;
    boolean syncFused;
    Subscription upstream;
    
    DoFinallySubscriber(Subscriber<? super T> paramSubscriber, Action paramAction)
    {
      this.downstream = paramSubscriber;
      this.onFinally = paramAction;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void clear()
    {
      this.qs.clear();
    }
    
    public boolean isEmpty()
    {
      return this.qs.isEmpty();
    }
    
    /* Error */
    public void onComplete()
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
    
    public void onNext(T paramT)
    {
      this.downstream.onNext(paramT);
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public T poll()
      throws Exception
    {
      return null;
    }
    
    public void request(long paramLong)
    {
      this.upstream.request(paramLong);
    }
    
    public int requestFusion(int paramInt)
    {
      return 0;
    }
    
    /* Error */
    void runFinally()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDoFinally.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */