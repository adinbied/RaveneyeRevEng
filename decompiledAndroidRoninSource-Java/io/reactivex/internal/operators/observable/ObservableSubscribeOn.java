package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSubscribeOn<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final Scheduler scheduler;
  
  public ObservableSubscribeOn(ObservableSource<T> paramObservableSource, Scheduler paramScheduler)
  {
    super(paramObservableSource);
    this.scheduler = paramScheduler;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SubscribeOnObserver<T>
    extends AtomicReference<Disposable>
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = 8094547886072529208L;
    final Observer<? super T> downstream;
    final AtomicReference<Disposable> upstream;
    
    SubscribeOnObserver(Observer<? super T> paramObserver)
    {
      this.downstream = paramObserver;
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
    
    public boolean isDisposed()
    {
      return false;
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
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
      DisposableHelper.setOnce(this.upstream, paramDisposable);
    }
    
    void setDisposable(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this, paramDisposable);
    }
  }
  
  final class SubscribeTask
    implements Runnable
  {
    private final ObservableSubscribeOn.SubscribeOnObserver<T> parent;
    
    SubscribeTask()
    {
      ObservableSubscribeOn.SubscribeOnObserver localSubscribeOnObserver;
      this.parent = localSubscribeOnObserver;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSubscribeOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */