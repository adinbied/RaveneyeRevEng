package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import org.reactivestreams.Subscription;

public final class FlowableAllSingle<T>
  extends Single<Boolean>
  implements FuseToFlowable<Boolean>
{
  final Predicate<? super T> predicate;
  final Flowable<T> source;
  
  public FlowableAllSingle(Flowable<T> paramFlowable, Predicate<? super T> paramPredicate)
  {
    this.source = paramFlowable;
    this.predicate = paramPredicate;
  }
  
  public Flowable<Boolean> fuseToFlowable()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super Boolean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class AllSubscriber<T>
    implements FlowableSubscriber<T>, Disposable
  {
    boolean done;
    final SingleObserver<? super Boolean> downstream;
    final Predicate<? super T> predicate;
    Subscription upstream;
    
    AllSubscriber(SingleObserver<? super Boolean> paramSingleObserver, Predicate<? super T> paramPredicate)
    {
      this.downstream = paramSingleObserver;
      this.predicate = paramPredicate;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableAllSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */