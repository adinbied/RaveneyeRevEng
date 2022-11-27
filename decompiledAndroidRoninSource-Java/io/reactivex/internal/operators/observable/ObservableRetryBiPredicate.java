package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryBiPredicate<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final BiPredicate<? super Integer, ? super Throwable> predicate;
  
  public ObservableRetryBiPredicate(Observable<T> paramObservable, BiPredicate<? super Integer, ? super Throwable> paramBiPredicate)
  {
    super(paramObservable);
    this.predicate = paramBiPredicate;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class RetryBiObserver<T>
    extends AtomicInteger
    implements Observer<T>
  {
    private static final long serialVersionUID = -7098360935104053232L;
    final Observer<? super T> downstream;
    final BiPredicate<? super Integer, ? super Throwable> predicate;
    int retries;
    final ObservableSource<? extends T> source;
    final SequentialDisposable upstream;
    
    RetryBiObserver(Observer<? super T> paramObserver, BiPredicate<? super Integer, ? super Throwable> paramBiPredicate, SequentialDisposable paramSequentialDisposable, ObservableSource<? extends T> paramObservableSource)
    {
      this.downstream = paramObserver;
      this.upstream = paramSequentialDisposable;
      this.source = paramObservableSource;
      this.predicate = paramBiPredicate;
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void onNext(T paramT)
    {
      this.downstream.onNext(paramT);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.upstream.replace(paramDisposable);
    }
    
    /* Error */
    void subscribeNext()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableRetryBiPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */