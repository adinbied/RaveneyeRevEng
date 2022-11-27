package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import org.reactivestreams.Subscription;

public final class FlowableCountSingle<T>
  extends Single<Long>
  implements FuseToFlowable<Long>
{
  final Flowable<T> source;
  
  public FlowableCountSingle(Flowable<T> paramFlowable)
  {
    this.source = paramFlowable;
  }
  
  public Flowable<Long> fuseToFlowable()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super Long> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CountSubscriber
    implements FlowableSubscriber<Object>, Disposable
  {
    long count;
    final SingleObserver<? super Long> downstream;
    Subscription upstream;
    
    CountSubscriber(SingleObserver<? super Long> paramSingleObserver)
    {
      this.downstream = paramSingleObserver;
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
    
    public void onNext(Object paramObject)
    {
      this.count += 1L;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableCountSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */