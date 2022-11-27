package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeTimeoutPublisher<T, U>
  extends AbstractMaybeWithUpstream<T, T>
{
  final MaybeSource<? extends T> fallback;
  final Publisher<U> other;
  
  public MaybeTimeoutPublisher(MaybeSource<T> paramMaybeSource, Publisher<U> paramPublisher, MaybeSource<? extends T> paramMaybeSource1)
  {
    super(paramMaybeSource);
    this.other = paramPublisher;
    this.fallback = paramMaybeSource1;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class TimeoutFallbackMaybeObserver<T>
    extends AtomicReference<Disposable>
    implements MaybeObserver<T>
  {
    private static final long serialVersionUID = 8663801314800248617L;
    final MaybeObserver<? super T> downstream;
    
    TimeoutFallbackMaybeObserver(MaybeObserver<? super T> paramMaybeObserver)
    {
      this.downstream = paramMaybeObserver;
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this, paramDisposable);
    }
    
    public void onSuccess(T paramT)
    {
      this.downstream.onSuccess(paramT);
    }
  }
  
  static final class TimeoutMainMaybeObserver<T, U>
    extends AtomicReference<Disposable>
    implements MaybeObserver<T>, Disposable
  {
    private static final long serialVersionUID = -5955289211445418871L;
    final MaybeObserver<? super T> downstream;
    final MaybeSource<? extends T> fallback;
    final MaybeTimeoutPublisher.TimeoutOtherMaybeObserver<T, U> other;
    final MaybeTimeoutPublisher.TimeoutFallbackMaybeObserver<T> otherObserver;
    
    TimeoutMainMaybeObserver(MaybeObserver<? super T> paramMaybeObserver, MaybeSource<? extends T> paramMaybeSource)
    {
      this.downstream = paramMaybeObserver;
      this.other = new MaybeTimeoutPublisher.TimeoutOtherMaybeObserver(this);
      this.fallback = paramMaybeSource;
      if (paramMaybeSource != null) {
        paramMaybeObserver = new MaybeTimeoutPublisher.TimeoutFallbackMaybeObserver(paramMaybeObserver);
      } else {
        paramMaybeObserver = null;
      }
      this.otherObserver = paramMaybeObserver;
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
    public void otherComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void otherError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class TimeoutOtherMaybeObserver<T, U>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<Object>
  {
    private static final long serialVersionUID = 8663801314800248617L;
    final MaybeTimeoutPublisher.TimeoutMainMaybeObserver<T, U> parent;
    
    TimeoutOtherMaybeObserver(MaybeTimeoutPublisher.TimeoutMainMaybeObserver<T, U> paramTimeoutMainMaybeObserver)
    {
      this.parent = paramTimeoutMainMaybeObserver;
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
      ((Subscription)get()).cancel();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeTimeoutPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */