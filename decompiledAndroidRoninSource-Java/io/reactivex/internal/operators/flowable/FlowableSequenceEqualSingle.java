package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

public final class FlowableSequenceEqualSingle<T>
  extends Single<Boolean>
  implements FuseToFlowable<Boolean>
{
  final BiPredicate<? super T, ? super T> comparer;
  final Publisher<? extends T> first;
  final int prefetch;
  final Publisher<? extends T> second;
  
  public FlowableSequenceEqualSingle(Publisher<? extends T> paramPublisher1, Publisher<? extends T> paramPublisher2, BiPredicate<? super T, ? super T> paramBiPredicate, int paramInt)
  {
    this.first = paramPublisher1;
    this.second = paramPublisher2;
    this.comparer = paramBiPredicate;
    this.prefetch = paramInt;
  }
  
  public Flowable<Boolean> fuseToFlowable()
  {
    return null;
  }
  
  /* Error */
  public void subscribeActual(SingleObserver<? super Boolean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class EqualCoordinator<T>
    extends AtomicInteger
    implements Disposable, FlowableSequenceEqual.EqualCoordinatorHelper
  {
    private static final long serialVersionUID = -6178010334400373240L;
    final BiPredicate<? super T, ? super T> comparer;
    final SingleObserver<? super Boolean> downstream;
    final AtomicThrowable error;
    final FlowableSequenceEqual.EqualSubscriber<T> first;
    final FlowableSequenceEqual.EqualSubscriber<T> second;
    T v1;
    T v2;
    
    EqualCoordinator(SingleObserver<? super Boolean> paramSingleObserver, int paramInt, BiPredicate<? super T, ? super T> paramBiPredicate)
    {
      this.downstream = paramSingleObserver;
      this.comparer = paramBiPredicate;
      this.first = new FlowableSequenceEqual.EqualSubscriber(this, paramInt);
      this.second = new FlowableSequenceEqual.EqualSubscriber(this, paramInt);
      this.error = new AtomicThrowable();
    }
    
    /* Error */
    void cancelAndClear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void innerError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    /* Error */
    void subscribe(Publisher<? extends T> arg1, Publisher<? extends T> arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSequenceEqualSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */