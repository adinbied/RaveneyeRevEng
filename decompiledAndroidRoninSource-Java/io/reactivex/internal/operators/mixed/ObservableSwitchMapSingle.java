package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapSingle<T, R>
  extends Observable<R>
{
  final boolean delayErrors;
  final Function<? super T, ? extends SingleSource<? extends R>> mapper;
  final Observable<T> source;
  
  public ObservableSwitchMapSingle(Observable<T> paramObservable, Function<? super T, ? extends SingleSource<? extends R>> paramFunction, boolean paramBoolean)
  {
    this.source = paramObservable;
    this.mapper = paramFunction;
    this.delayErrors = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SwitchMapSingleMainObserver<T, R>
    extends AtomicInteger
    implements Observer<T>, Disposable
  {
    static final SwitchMapSingleObserver<Object> INNER_DISPOSED = new SwitchMapSingleObserver(null);
    private static final long serialVersionUID = -5402190102429853762L;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable errors;
    final AtomicReference<SwitchMapSingleObserver<R>> inner;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    Disposable upstream;
    
    SwitchMapSingleMainObserver(Observer<? super R> paramObserver, Function<? super T, ? extends SingleSource<? extends R>> paramFunction, boolean paramBoolean)
    {
      this.downstream = paramObserver;
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
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerError(SwitchMapSingleObserver<R> arg1, Throwable arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
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
    
    static final class SwitchMapSingleObserver<R>
      extends AtomicReference<Disposable>
      implements SingleObserver<R>
    {
      private static final long serialVersionUID = 8042919737683345351L;
      volatile R item;
      final ObservableSwitchMapSingle.SwitchMapSingleMainObserver<?, R> parent;
      
      SwitchMapSingleObserver(ObservableSwitchMapSingle.SwitchMapSingleMainObserver<?, R> paramSwitchMapSingleMainObserver)
      {
        this.parent = paramSwitchMapSingleMainObserver;
      }
      
      void dispose()
      {
        DisposableHelper.dispose(this);
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.parent.innerError(this, paramThrowable);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(this, paramDisposable);
      }
      
      public void onSuccess(R paramR)
      {
        this.item = paramR;
        this.parent.drain();
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\mixed\ObservableSwitchMapSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */