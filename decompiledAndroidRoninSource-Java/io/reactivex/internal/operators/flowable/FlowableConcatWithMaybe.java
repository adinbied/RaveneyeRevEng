package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableConcatWithMaybe<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final MaybeSource<? extends T> other;
  
  public FlowableConcatWithMaybe(Flowable<T> paramFlowable, MaybeSource<? extends T> paramMaybeSource)
  {
    super(paramFlowable);
    this.other = paramMaybeSource;
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
    implements MaybeObserver<T>
  {
    private static final long serialVersionUID = -7346385463600070225L;
    boolean inMaybe;
    MaybeSource<? extends T> other;
    final AtomicReference<Disposable> otherDisposable;
    
    ConcatWithSubscriber(Subscriber<? super T> paramSubscriber, MaybeSource<? extends T> paramMaybeSource)
    {
      super();
      this.other = paramMaybeSource;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableConcatWithMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */