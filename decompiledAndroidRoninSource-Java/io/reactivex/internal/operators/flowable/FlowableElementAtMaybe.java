package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import org.reactivestreams.Subscription;

public final class FlowableElementAtMaybe<T>
  extends Maybe<T>
  implements FuseToFlowable<T>
{
  final long index;
  final Flowable<T> source;
  
  public FlowableElementAtMaybe(Flowable<T> paramFlowable, long paramLong)
  {
    this.source = paramFlowable;
    this.index = paramLong;
  }
  
  public Flowable<T> fuseToFlowable()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
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
    boolean done;
    final MaybeObserver<? super T> downstream;
    final long index;
    Subscription upstream;
    
    ElementAtSubscriber(MaybeObserver<? super T> paramMaybeObserver, long paramLong)
    {
      this.downstream = paramMaybeObserver;
      this.index = paramLong;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableElementAtMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */