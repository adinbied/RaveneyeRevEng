package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

public final class SingleToFlowable<T>
  extends Flowable<T>
{
  final SingleSource<? extends T> source;
  
  public SingleToFlowable(SingleSource<? extends T> paramSingleSource)
  {
    this.source = paramSingleSource;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SingleToFlowableObserver<T>
    extends DeferredScalarSubscription<T>
    implements SingleObserver<T>
  {
    private static final long serialVersionUID = 187782011903685568L;
    Disposable upstream;
    
    SingleToFlowableObserver(Subscriber<? super T> paramSubscriber)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleToFlowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */