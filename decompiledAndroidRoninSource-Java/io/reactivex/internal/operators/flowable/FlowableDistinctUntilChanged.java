package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableDistinctUntilChanged<T, K>
  extends AbstractFlowableWithUpstream<T, T>
{
  final BiPredicate<? super K, ? super K> comparer;
  final Function<? super T, K> keySelector;
  
  public FlowableDistinctUntilChanged(Flowable<T> paramFlowable, Function<? super T, K> paramFunction, BiPredicate<? super K, ? super K> paramBiPredicate)
  {
    super(paramFlowable);
    this.keySelector = paramFunction;
    this.comparer = paramBiPredicate;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DistinctUntilChangedConditionalSubscriber<T, K>
    extends BasicFuseableConditionalSubscriber<T, T>
  {
    final BiPredicate<? super K, ? super K> comparer;
    boolean hasValue;
    final Function<? super T, K> keySelector;
    K last;
    
    DistinctUntilChangedConditionalSubscriber(ConditionalSubscriber<? super T> paramConditionalSubscriber, Function<? super T, K> paramFunction, BiPredicate<? super K, ? super K> paramBiPredicate)
    {
      super();
      this.keySelector = paramFunction;
      this.comparer = paramBiPredicate;
    }
    
    /* Error */
    public void onNext(T arg1)
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
    
    public int requestFusion(int paramInt)
    {
      return transitiveBoundaryFusion(paramInt);
    }
    
    public boolean tryOnNext(T paramT)
    {
      return false;
    }
  }
  
  static final class DistinctUntilChangedSubscriber<T, K>
    extends BasicFuseableSubscriber<T, T>
    implements ConditionalSubscriber<T>
  {
    final BiPredicate<? super K, ? super K> comparer;
    boolean hasValue;
    final Function<? super T, K> keySelector;
    K last;
    
    DistinctUntilChangedSubscriber(Subscriber<? super T> paramSubscriber, Function<? super T, K> paramFunction, BiPredicate<? super K, ? super K> paramBiPredicate)
    {
      super();
      this.keySelector = paramFunction;
      this.comparer = paramBiPredicate;
    }
    
    /* Error */
    public void onNext(T arg1)
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
    
    public int requestFusion(int paramInt)
    {
      return transitiveBoundaryFusion(paramInt);
    }
    
    public boolean tryOnNext(T paramT)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDistinctUntilChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */