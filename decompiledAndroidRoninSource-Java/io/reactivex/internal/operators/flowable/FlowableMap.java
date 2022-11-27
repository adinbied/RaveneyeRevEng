package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableMap<T, U>
  extends AbstractFlowableWithUpstream<T, U>
{
  final Function<? super T, ? extends U> mapper;
  
  public FlowableMap(Flowable<T> paramFlowable, Function<? super T, ? extends U> paramFunction)
  {
    super(paramFlowable);
    this.mapper = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class MapConditionalSubscriber<T, U>
    extends BasicFuseableConditionalSubscriber<T, U>
  {
    final Function<? super T, ? extends U> mapper;
    
    MapConditionalSubscriber(ConditionalSubscriber<? super U> paramConditionalSubscriber, Function<? super T, ? extends U> paramFunction)
    {
      super();
      this.mapper = paramFunction;
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public U poll()
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
  
  static final class MapSubscriber<T, U>
    extends BasicFuseableSubscriber<T, U>
  {
    final Function<? super T, ? extends U> mapper;
    
    MapSubscriber(Subscriber<? super U> paramSubscriber, Function<? super T, ? extends U> paramFunction)
    {
      super();
      this.mapper = paramFunction;
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public U poll()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */