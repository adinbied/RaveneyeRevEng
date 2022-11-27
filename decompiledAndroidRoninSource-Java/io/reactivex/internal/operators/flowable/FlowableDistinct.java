package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableDistinct<T, K>
  extends AbstractFlowableWithUpstream<T, T>
{
  final Callable<? extends Collection<? super K>> collectionSupplier;
  final Function<? super T, K> keySelector;
  
  public FlowableDistinct(Flowable<T> paramFlowable, Function<? super T, K> paramFunction, Callable<? extends Collection<? super K>> paramCallable)
  {
    super(paramFlowable);
    this.keySelector = paramFunction;
    this.collectionSupplier = paramCallable;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class DistinctSubscriber<T, K>
    extends BasicFuseableSubscriber<T, T>
  {
    final Collection<? super K> collection;
    final Function<? super T, K> keySelector;
    
    DistinctSubscriber(Subscriber<? super T> paramSubscriber, Function<? super T, K> paramFunction, Collection<? super K> paramCollection)
    {
      super();
      this.keySelector = paramFunction;
      this.collection = paramCollection;
    }
    
    /* Error */
    public void clear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDistinct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */