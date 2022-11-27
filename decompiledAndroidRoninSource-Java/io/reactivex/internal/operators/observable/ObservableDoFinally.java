package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableDoFinally<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final Action onFinally;
  
  public ObservableDoFinally(ObservableSource<T> paramObservableSource, Action paramAction)
  {
    super(paramObservableSource);
    this.onFinally = paramAction;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DoFinallyObserver<T>
    extends BasicIntQueueDisposable<T>
    implements Observer<T>
  {
    private static final long serialVersionUID = 4109457741734051389L;
    final Observer<? super T> downstream;
    final Action onFinally;
    QueueDisposable<T> qd;
    boolean syncFused;
    Disposable upstream;
    
    DoFinallyObserver(Observer<? super T> paramObserver, Action paramAction)
    {
      this.downstream = paramObserver;
      this.onFinally = paramAction;
    }
    
    public void clear()
    {
      this.qd.clear();
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
    
    public boolean isEmpty()
    {
      return this.qd.isEmpty();
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
      this.downstream.onNext(paramT);
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public T poll()
      throws Exception
    {
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      return 0;
    }
    
    /* Error */
    void runFinally()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDoFinally.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */