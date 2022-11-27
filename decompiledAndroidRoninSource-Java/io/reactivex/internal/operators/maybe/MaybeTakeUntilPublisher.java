package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeTakeUntilPublisher<T, U>
  extends AbstractMaybeWithUpstream<T, T>
{
  final Publisher<U> other;
  
  public MaybeTakeUntilPublisher(MaybeSource<T> paramMaybeSource, Publisher<U> paramPublisher)
  {
    super(paramMaybeSource);
    this.other = paramPublisher;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class TakeUntilMainMaybeObserver<T, U>
    extends AtomicReference<Disposable>
    implements MaybeObserver<T>, Disposable
  {
    private static final long serialVersionUID = -2187421758664251153L;
    final MaybeObserver<? super T> downstream;
    final TakeUntilOtherMaybeObserver<U> other;
    
    TakeUntilMainMaybeObserver(MaybeObserver<? super T> paramMaybeObserver)
    {
      this.downstream = paramMaybeObserver;
      this.other = new TakeUntilOtherMaybeObserver(this);
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
    void otherComplete()
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
    
    static final class TakeUntilOtherMaybeObserver<U>
      extends AtomicReference<Subscription>
      implements FlowableSubscriber<U>
    {
      private static final long serialVersionUID = -1266041316834525931L;
      final MaybeTakeUntilPublisher.TakeUntilMainMaybeObserver<?, U> parent;
      
      TakeUntilOtherMaybeObserver(MaybeTakeUntilPublisher.TakeUntilMainMaybeObserver<?, U> paramTakeUntilMainMaybeObserver)
      {
        this.parent = paramTakeUntilMainMaybeObserver;
      }
      
      public void onComplete()
      {
        this.parent.otherComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.parent.otherError(paramThrowable);
      }
      
      public void onNext(Object paramObject)
      {
        SubscriptionHelper.cancel(this);
        this.parent.otherComplete();
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeTakeUntilPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */