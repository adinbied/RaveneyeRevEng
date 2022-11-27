package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishAlt<T>
  extends ConnectableObservable<T>
  implements HasUpstreamObservableSource<T>, ResettableConnectable
{
  final AtomicReference<PublishConnection<T>> current;
  final ObservableSource<T> source;
  
  public ObservablePublishAlt(ObservableSource<T> paramObservableSource)
  {
    this.source = paramObservableSource;
    this.current = new AtomicReference();
  }
  
  /* Error */
  public void connect(io.reactivex.functions.Consumer<? super Disposable> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void resetIf(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ObservableSource<T> source()
  {
    return this.source;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class InnerDisposable<T>
    extends AtomicReference<ObservablePublishAlt.PublishConnection<T>>
    implements Disposable
  {
    private static final long serialVersionUID = 7463222674719692880L;
    final Observer<? super T> downstream;
    
    public InnerDisposable(Observer<? super T> paramObserver, ObservablePublishAlt.PublishConnection<T> paramPublishConnection)
    {
      this.downstream = paramObserver;
      lazySet(paramPublishConnection);
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
  }
  
  static final class PublishConnection<T>
    extends AtomicReference<ObservablePublishAlt.InnerDisposable<T>[]>
    implements Observer<T>, Disposable
  {
    static final ObservablePublishAlt.InnerDisposable[] EMPTY = new ObservablePublishAlt.InnerDisposable[0];
    static final ObservablePublishAlt.InnerDisposable[] TERMINATED = new ObservablePublishAlt.InnerDisposable[0];
    private static final long serialVersionUID = -3251430252873581268L;
    final AtomicBoolean connect = new AtomicBoolean();
    final AtomicReference<PublishConnection<T>> current;
    Throwable error;
    final AtomicReference<Disposable> upstream;
    
    public PublishConnection(AtomicReference<PublishConnection<T>> paramAtomicReference)
    {
      this.current = paramAtomicReference;
      this.upstream = new AtomicReference();
      lazySet(EMPTY);
    }
    
    public boolean add(ObservablePublishAlt.InnerDisposable<T> paramInnerDisposable)
    {
      return false;
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
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this.upstream, paramDisposable);
    }
    
    /* Error */
    public void remove(ObservablePublishAlt.InnerDisposable<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservablePublishAlt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */