package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapCompletable<T>
  extends Completable
{
  final boolean delayErrors;
  final Function<? super T, ? extends CompletableSource> mapper;
  final Observable<T> source;
  
  public ObservableSwitchMapCompletable(Observable<T> paramObservable, Function<? super T, ? extends CompletableSource> paramFunction, boolean paramBoolean)
  {
    this.source = paramObservable;
    this.mapper = paramFunction;
    this.delayErrors = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SwitchMapCompletableObserver<T>
    implements Observer<T>, Disposable
  {
    static final SwitchMapInnerObserver INNER_DISPOSED = new SwitchMapInnerObserver(null);
    final boolean delayErrors;
    volatile boolean done;
    final CompletableObserver downstream;
    final AtomicThrowable errors;
    final AtomicReference<SwitchMapInnerObserver> inner;
    final Function<? super T, ? extends CompletableSource> mapper;
    Disposable upstream;
    
    SwitchMapCompletableObserver(CompletableObserver paramCompletableObserver, Function<? super T, ? extends CompletableSource> paramFunction, boolean paramBoolean)
    {
      this.downstream = paramCompletableObserver;
      this.mapper = paramFunction;
      this.delayErrors = paramBoolean;
      this.errors = new AtomicThrowable();
      this.inner = new AtomicReference();
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
    void disposeInner()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerComplete(SwitchMapInnerObserver arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerError(SwitchMapInnerObserver arg1, Throwable arg2)
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
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    static final class SwitchMapInnerObserver
      extends AtomicReference<Disposable>
      implements CompletableObserver
    {
      private static final long serialVersionUID = -8003404460084760287L;
      final ObservableSwitchMapCompletable.SwitchMapCompletableObserver<?> parent;
      
      SwitchMapInnerObserver(ObservableSwitchMapCompletable.SwitchMapCompletableObserver<?> paramSwitchMapCompletableObserver)
      {
        this.parent = paramSwitchMapCompletableObserver;
      }
      
      void dispose()
      {
        DisposableHelper.dispose(this);
      }
      
      public void onComplete()
      {
        this.parent.innerComplete(this);
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.parent.innerError(this, paramThrowable);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(this, paramDisposable);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\mixed\ObservableSwitchMapCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */