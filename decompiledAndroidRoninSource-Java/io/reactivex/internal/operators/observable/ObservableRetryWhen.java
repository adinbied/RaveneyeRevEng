package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRetryWhen<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final Function<? super Observable<Throwable>, ? extends ObservableSource<?>> handler;
  
  public ObservableRetryWhen(ObservableSource<T> paramObservableSource, Function<? super Observable<Throwable>, ? extends ObservableSource<?>> paramFunction)
  {
    super(paramObservableSource);
    this.handler = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class RepeatWhenObserver<T>
    extends AtomicInteger
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = 802743776666017014L;
    volatile boolean active;
    final Observer<? super T> downstream;
    final AtomicThrowable error;
    final RepeatWhenObserver<T>.InnerRepeatObserver inner;
    final Subject<Throwable> signaller;
    final ObservableSource<T> source;
    final AtomicReference<Disposable> upstream;
    final AtomicInteger wip;
    
    RepeatWhenObserver(Observer<? super T> paramObserver, Subject<Throwable> paramSubject, ObservableSource<T> paramObservableSource)
    {
      this.downstream = paramObserver;
      this.signaller = paramSubject;
      this.source = paramObservableSource;
      this.wip = new AtomicInteger();
      this.error = new AtomicThrowable();
      this.inner = new InnerRepeatObserver();
      this.upstream = new AtomicReference();
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void innerNext()
    {
      subscribeNext();
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
    
    public void onNext(T paramT)
    {
      HalfSerializer.onNext(this.downstream, paramT, this, this.error);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.replace(this.upstream, paramDisposable);
    }
    
    /* Error */
    void subscribeNext()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    final class InnerRepeatObserver
      extends AtomicReference<Disposable>
      implements Observer<Object>
    {
      private static final long serialVersionUID = 3254781284376480842L;
      
      InnerRepeatObserver() {}
      
      public void onComplete()
      {
        ObservableRetryWhen.RepeatWhenObserver.this.innerComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        ObservableRetryWhen.RepeatWhenObserver.this.innerError(paramThrowable);
      }
      
      public void onNext(Object paramObject)
      {
        ObservableRetryWhen.RepeatWhenObserver.this.innerNext();
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(this, paramDisposable);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableRetryWhen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */