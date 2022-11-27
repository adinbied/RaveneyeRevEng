package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithCompletable<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final CompletableSource other;
  
  public ObservableMergeWithCompletable(Observable<T> paramObservable, CompletableSource paramCompletableSource)
  {
    super(paramObservable);
    this.other = paramCompletableSource;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class MergeWithObserver<T>
    extends AtomicInteger
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = -4592979584110982903L;
    final Observer<? super T> downstream;
    final AtomicThrowable error;
    final AtomicReference<Disposable> mainDisposable;
    volatile boolean mainDone;
    volatile boolean otherDone;
    final OtherObserver otherObserver;
    
    MergeWithObserver(Observer<? super T> paramObserver)
    {
      this.downstream = paramObserver;
      this.mainDisposable = new AtomicReference();
      this.otherObserver = new OtherObserver(this);
      this.error = new AtomicThrowable();
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
    
    public void onNext(T paramT)
    {
      HalfSerializer.onNext(this.downstream, paramT, this, this.error);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this.mainDisposable, paramDisposable);
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
    
    static final class OtherObserver
      extends AtomicReference<Disposable>
      implements CompletableObserver
    {
      private static final long serialVersionUID = -2935427570954647017L;
      final ObservableMergeWithCompletable.MergeWithObserver<?> parent;
      
      OtherObserver(ObservableMergeWithCompletable.MergeWithObserver<?> paramMergeWithObserver)
      {
        this.parent = paramMergeWithObserver;
      }
      
      public void onComplete()
      {
        this.parent.otherComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.parent.otherError(paramThrowable);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(this, paramDisposable);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableMergeWithCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */