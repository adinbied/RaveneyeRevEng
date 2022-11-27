package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableConcatWithSingle<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final SingleSource<? extends T> other;
  
  public FlowableConcatWithSingle(Flowable<T> paramFlowable, SingleSource<? extends T> paramSingleSource)
  {
    super(paramFlowable);
    this.other = paramSingleSource;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ConcatWithSubscriber<T>
    extends SinglePostCompleteSubscriber<T, T>
    implements SingleObserver<T>
  {
    private static final long serialVersionUID = -7346385463600070225L;
    SingleSource<? extends T> other;
    final AtomicReference<Disposable> otherDisposable;
    
    ConcatWithSubscriber(Subscriber<? super T> paramSubscriber, SingleSource<? extends T> paramSingleSource)
    {
      super();
      this.other = paramSingleSource;
      this.otherDisposable = new AtomicReference();
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onComplete()
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
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this.otherDisposable, paramDisposable);
    }
    
    public void onSuccess(T paramT)
    {
      complete(paramT);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableConcatWithSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */