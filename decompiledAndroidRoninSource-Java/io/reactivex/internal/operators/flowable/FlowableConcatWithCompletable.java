package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatWithCompletable<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final CompletableSource other;
  
  public FlowableConcatWithCompletable(Flowable<T> paramFlowable, CompletableSource paramCompletableSource)
  {
    super(paramFlowable);
    this.other = paramCompletableSource;
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
    extends AtomicReference<Disposable>
    implements FlowableSubscriber<T>, CompletableObserver, Subscription
  {
    private static final long serialVersionUID = -7346385463600070225L;
    final Subscriber<? super T> downstream;
    boolean inCompletable;
    CompletableSource other;
    Subscription upstream;
    
    ConcatWithSubscriber(Subscriber<? super T> paramSubscriber, CompletableSource paramCompletableSource)
    {
      this.downstream = paramSubscriber;
      this.other = paramCompletableSource;
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
    
    public void onNext(T paramT)
    {
      this.downstream.onNext(paramT);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this, paramDisposable);
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void request(long paramLong)
    {
      this.upstream.request(paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableConcatWithCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */