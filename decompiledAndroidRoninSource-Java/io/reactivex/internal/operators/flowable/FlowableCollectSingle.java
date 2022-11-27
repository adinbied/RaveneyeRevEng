package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.fuseable.FuseToFlowable;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

public final class FlowableCollectSingle<T, U>
  extends Single<U>
  implements FuseToFlowable<U>
{
  final BiConsumer<? super U, ? super T> collector;
  final Callable<? extends U> initialSupplier;
  final Flowable<T> source;
  
  public FlowableCollectSingle(Flowable<T> paramFlowable, Callable<? extends U> paramCallable, BiConsumer<? super U, ? super T> paramBiConsumer)
  {
    this.source = paramFlowable;
    this.initialSupplier = paramCallable;
    this.collector = paramBiConsumer;
  }
  
  public Flowable<U> fuseToFlowable()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class CollectSubscriber<T, U>
    implements FlowableSubscriber<T>, Disposable
  {
    final BiConsumer<? super U, ? super T> collector;
    boolean done;
    final SingleObserver<? super U> downstream;
    final U u;
    Subscription upstream;
    
    CollectSubscriber(SingleObserver<? super U> paramSingleObserver, U paramU, BiConsumer<? super U, ? super T> paramBiConsumer)
    {
      this.downstream = paramSingleObserver;
      this.collector = paramBiConsumer;
      this.u = paramU;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableCollectSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */