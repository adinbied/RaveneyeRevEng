package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapCompletable<T>
  extends Completable
{
  final ErrorMode errorMode;
  final Function<? super T, ? extends CompletableSource> mapper;
  final int prefetch;
  final Observable<T> source;
  
  public ObservableConcatMapCompletable(Observable<T> paramObservable, Function<? super T, ? extends CompletableSource> paramFunction, ErrorMode paramErrorMode, int paramInt)
  {
    this.source = paramObservable;
    this.mapper = paramFunction;
    this.errorMode = paramErrorMode;
    this.prefetch = paramInt;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ConcatMapCompletableObserver<T>
    extends AtomicInteger
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = 3610901111000061034L;
    volatile boolean active;
    volatile boolean disposed;
    volatile boolean done;
    final CompletableObserver downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapInnerObserver inner;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int prefetch;
    SimpleQueue<T> queue;
    Disposable upstream;
    
    ConcatMapCompletableObserver(CompletableObserver paramCompletableObserver, Function<? super T, ? extends CompletableSource> paramFunction, ErrorMode paramErrorMode, int paramInt)
    {
      this.downstream = paramCompletableObserver;
      this.mapper = paramFunction;
      this.errorMode = paramErrorMode;
      this.prefetch = paramInt;
      this.errors = new AtomicThrowable();
      this.inner = new ConcatMapInnerObserver(this);
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
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    void innerComplete()
    {
      this.active = false;
      drain();
    }
    
    /* Error */
    void innerError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return this.disposed;
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
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    static final class ConcatMapInnerObserver
      extends AtomicReference<Disposable>
      implements CompletableObserver
    {
      private static final long serialVersionUID = 5638352172918776687L;
      final ObservableConcatMapCompletable.ConcatMapCompletableObserver<?> parent;
      
      ConcatMapInnerObserver(ObservableConcatMapCompletable.ConcatMapCompletableObserver<?> paramConcatMapCompletableObserver)
      {
        this.parent = paramConcatMapCompletableObserver;
      }
      
      void dispose()
      {
        DisposableHelper.dispose(this);
      }
      
      public void onComplete()
      {
        this.parent.innerComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.parent.innerError(paramThrowable);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.replace(this, paramDisposable);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\mixed\ObservableConcatMapCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */