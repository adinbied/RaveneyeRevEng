package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import org.reactivestreams.Subscription;

public final class FlowableElementAtSingle<T>
  extends Single<T>
  implements FuseToFlowable<T>
{
  final T defaultValue;
  final long index;
  final Flowable<T> source;
  
  public FlowableElementAtSingle(Flowable<T> paramFlowable, long paramLong, T paramT)
  {
    this.source = paramFlowable;
    this.index = paramLong;
    this.defaultValue = paramT;
  }
  
  public Flowable<T> fuseToFlowable()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ElementAtSubscriber<T>
    implements FlowableSubscriber<T>, Disposable
  {
    long count;
    final T defaultValue;
    boolean done;
    final SingleObserver<? super T> downstream;
    final long index;
    Subscription upstream;
    
    ElementAtSubscriber(SingleObserver<? super T> paramSingleObserver, long paramLong, T paramT)
    {
      this.downstream = paramSingleObserver;
      this.index = paramLong;
      this.defaultValue = paramT;
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
      //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableElementAtSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */