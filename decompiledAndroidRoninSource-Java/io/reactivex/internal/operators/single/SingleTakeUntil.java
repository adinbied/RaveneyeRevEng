package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class SingleTakeUntil<T, U>
  extends Single<T>
{
  final Publisher<U> other;
  final SingleSource<T> source;
  
  public SingleTakeUntil(SingleSource<T> paramSingleSource, Publisher<U> paramPublisher)
  {
    this.source = paramSingleSource;
    this.other = paramPublisher;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class TakeUntilMainObserver<T>
    extends AtomicReference<Disposable>
    implements SingleObserver<T>, Disposable
  {
    private static final long serialVersionUID = -622603812305745221L;
    final SingleObserver<? super T> downstream;
    final SingleTakeUntil.TakeUntilOtherSubscriber other;
    
    TakeUntilMainObserver(SingleObserver<? super T> paramSingleObserver)
    {
      this.downstream = paramSingleObserver;
      this.other = new SingleTakeUntil.TakeUntilOtherSubscriber(this);
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
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this, paramDisposable);
    }
    
    /* Error */
    public void onSuccess(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void otherError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class TakeUntilOtherSubscriber
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<Object>
  {
    private static final long serialVersionUID = 5170026210238877381L;
    final SingleTakeUntil.TakeUntilMainObserver<?> parent;
    
    TakeUntilOtherSubscriber(SingleTakeUntil.TakeUntilMainObserver<?> paramTakeUntilMainObserver)
    {
      this.parent = paramTakeUntilMainObserver;
    }
    
    public void dispose()
    {
      SubscriptionHelper.cancel(this);
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
      this.parent.otherError(paramThrowable);
    }
    
    /* Error */
    public void onNext(Object arg1)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleTakeUntil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */