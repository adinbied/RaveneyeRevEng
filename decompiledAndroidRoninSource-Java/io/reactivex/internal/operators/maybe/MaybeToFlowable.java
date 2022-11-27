package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

public final class MaybeToFlowable<T>
  extends Flowable<T>
  implements HasUpstreamMaybeSource<T>
{
  final MaybeSource<T> source;
  
  public MaybeToFlowable(MaybeSource<T> paramMaybeSource)
  {
    this.source = paramMaybeSource;
  }
  
  public MaybeSource<T> source()
  {
    return this.source;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class MaybeToFlowableSubscriber<T>
    extends DeferredScalarSubscription<T>
    implements MaybeObserver<T>
  {
    private static final long serialVersionUID = 7603343402964826922L;
    Disposable upstream;
    
    MaybeToFlowableSubscriber(Subscriber<? super T> paramSubscriber)
    {
      super();
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSuccess(T paramT)
    {
      complete(paramT);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeToFlowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */