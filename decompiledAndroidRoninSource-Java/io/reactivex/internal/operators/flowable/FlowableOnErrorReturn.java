package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableOnErrorReturn<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final Function<? super Throwable, ? extends T> valueSupplier;
  
  public FlowableOnErrorReturn(Flowable<T> paramFlowable, Function<? super Throwable, ? extends T> paramFunction)
  {
    super(paramFlowable);
    this.valueSupplier = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class OnErrorReturnSubscriber<T>
    extends SinglePostCompleteSubscriber<T, T>
  {
    private static final long serialVersionUID = -3740826063558713822L;
    final Function<? super Throwable, ? extends T> valueSupplier;
    
    OnErrorReturnSubscriber(Subscriber<? super T> paramSubscriber, Function<? super Throwable, ? extends T> paramFunction)
    {
      super();
      this.valueSupplier = paramFunction;
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableOnErrorReturn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */