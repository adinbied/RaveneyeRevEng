package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableReduceMaybe<T>
  extends Maybe<T>
  implements HasUpstreamPublisher<T>, FuseToFlowable<T>
{
  final BiFunction<T, T, T> reducer;
  final Flowable<T> source;
  
  public FlowableReduceMaybe(Flowable<T> paramFlowable, BiFunction<T, T, T> paramBiFunction)
  {
    this.source = paramFlowable;
    this.reducer = paramBiFunction;
  }
  
  public Flowable<T> fuseToFlowable()
  {
    return null;
  }
  
  public Publisher<T> source()
  {
    return this.source;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ReduceSubscriber<T>
    implements FlowableSubscriber<T>, Disposable
  {
    boolean done;
    final MaybeObserver<? super T> downstream;
    final BiFunction<T, T, T> reducer;
    Subscription upstream;
    T value;
    
    ReduceSubscriber(MaybeObserver<? super T> paramMaybeObserver, BiFunction<T, T, T> paramBiFunction)
    {
      this.downstream = paramMaybeObserver;
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
      return this.done;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableReduceMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */