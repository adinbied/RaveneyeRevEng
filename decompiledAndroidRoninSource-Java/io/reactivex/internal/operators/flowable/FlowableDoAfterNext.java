package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableDoAfterNext<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final Consumer<? super T> onAfterNext;
  
  public FlowableDoAfterNext(Flowable<T> paramFlowable, Consumer<? super T> paramConsumer)
  {
    super(paramFlowable);
    this.onAfterNext = paramConsumer;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DoAfterConditionalSubscriber<T>
    extends BasicFuseableConditionalSubscriber<T, T>
  {
    final Consumer<? super T> onAfterNext;
    
    DoAfterConditionalSubscriber(ConditionalSubscriber<? super T> paramConditionalSubscriber, Consumer<? super T> paramConsumer)
    {
      super();
      this.onAfterNext = paramConsumer;
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public T poll()
      throws Exception
    {
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      return transitiveBoundaryFusion(paramInt);
    }
    
    public boolean tryOnNext(T paramT)
    {
      return false;
    }
  }
  
  static final class DoAfterSubscriber<T>
    extends BasicFuseableSubscriber<T, T>
  {
    final Consumer<? super T> onAfterNext;
    
    DoAfterSubscriber(Subscriber<? super T> paramSubscriber, Consumer<? super T> paramConsumer)
    {
      super();
      this.onAfterNext = paramConsumer;
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public T poll()
      throws Exception
    {
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      return transitiveBoundaryFusion(paramInt);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDoAfterNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */