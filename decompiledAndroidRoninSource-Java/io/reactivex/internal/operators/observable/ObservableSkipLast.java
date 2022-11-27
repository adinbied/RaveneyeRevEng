package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayDeque;

public final class ObservableSkipLast<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final int skip;
  
  public ObservableSkipLast(ObservableSource<T> paramObservableSource, int paramInt)
  {
    super(paramObservableSource);
    this.skip = paramInt;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SkipLastObserver<T>
    extends ArrayDeque<T>
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = -3807491841935125653L;
    final Observer<? super T> downstream;
    final int skip;
    Disposable upstream;
    
    SkipLastObserver(Observer<? super T> paramObserver, int paramInt)
    {
      super();
      this.downstream = paramObserver;
      this.skip = paramInt;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSkipLast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */