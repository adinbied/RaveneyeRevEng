package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class ObservableElementAt<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final T defaultValue;
  final boolean errorOnFewer;
  final long index;
  
  public ObservableElementAt(ObservableSource<T> paramObservableSource, long paramLong, T paramT, boolean paramBoolean)
  {
    super(paramObservableSource);
    this.index = paramLong;
    this.defaultValue = paramT;
    this.errorOnFewer = paramBoolean;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ElementAtObserver<T>
    implements Observer<T>, Disposable
  {
    long count;
    final T defaultValue;
    boolean done;
    final Observer<? super T> downstream;
    final boolean errorOnFewer;
    final long index;
    Disposable upstream;
    
    ElementAtObserver(Observer<? super T> paramObserver, long paramLong, T paramT, boolean paramBoolean)
    {
      this.downstream = paramObserver;
      this.index = paramLong;
      this.defaultValue = paramT;
      this.errorOnFewer = paramBoolean;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableElementAt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */