package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableReduceSeedSingle<T, R>
  extends Single<R>
{
  final BiFunction<R, ? super T, R> reducer;
  final R seed;
  final Publisher<T> source;
  
  public FlowableReduceSeedSingle(Publisher<T> paramPublisher, R paramR, BiFunction<R, ? super T, R> paramBiFunction)
  {
    this.source = paramPublisher;
    this.seed = paramR;
    this.reducer = paramBiFunction;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ReduceSeedObserver<T, R>
    implements FlowableSubscriber<T>, Disposable
  {
    final SingleObserver<? super R> downstream;
    final BiFunction<R, ? super T, R> reducer;
    Subscription upstream;
    R value;
    
    ReduceSeedObserver(SingleObserver<? super R> paramSingleObserver, BiFunction<R, ? super T, R> paramBiFunction, R paramR)
    {
      this.downstream = paramSingleObserver;
      this.value = paramR;
      this.reducer = paramBiFunction;
    }
    
    /* Error */
    public void dispose()
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
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableReduceSeedSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */