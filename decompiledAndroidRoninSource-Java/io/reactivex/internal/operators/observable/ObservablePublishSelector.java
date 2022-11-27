package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishSelector<T, R>
  extends AbstractObservableWithUpstream<T, R>
{
  final Function<? super Observable<T>, ? extends ObservableSource<R>> selector;
  
  public ObservablePublishSelector(ObservableSource<T> paramObservableSource, Function<? super Observable<T>, ? extends ObservableSource<R>> paramFunction)
  {
    super(paramObservableSource);
    this.selector = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class SourceObserver<T, R>
    implements Observer<T>
  {
    final PublishSubject<T> subject;
    final AtomicReference<Disposable> target;
    
    SourceObserver(PublishSubject<T> paramPublishSubject, AtomicReference<Disposable> paramAtomicReference)
    {
      this.subject = paramPublishSubject;
      this.target = paramAtomicReference;
    }
    
    public void onComplete()
    {
      this.subject.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.subject.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.subject.onNext(paramT);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this.target, paramDisposable);
    }
  }
  
  static final class TargetObserver<T, R>
    extends AtomicReference<Disposable>
    implements Observer<R>, Disposable
  {
    private static final long serialVersionUID = 854110278590336484L;
    final Observer<? super R> downstream;
    Disposable upstream;
    
    TargetObserver(Observer<? super R> paramObserver)
    {
      this.downstream = paramObserver;
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
      return this.upstream.isDisposed();
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
    
    public void onNext(R paramR)
    {
      this.downstream.onNext(paramR);
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservablePublishSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */