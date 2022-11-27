package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish<T>
  extends ConnectableObservable<T>
  implements HasUpstreamObservableSource<T>, ObservablePublishClassic<T>
{
  final AtomicReference<PublishObserver<T>> current;
  final ObservableSource<T> onSubscribe;
  final ObservableSource<T> source;
  
  private ObservablePublish(ObservableSource<T> paramObservableSource1, ObservableSource<T> paramObservableSource2, AtomicReference<PublishObserver<T>> paramAtomicReference)
  {
    this.onSubscribe = paramObservableSource1;
    this.source = paramObservableSource2;
    this.current = paramAtomicReference;
  }
  
  public static <T> ConnectableObservable<T> create(ObservableSource<T> paramObservableSource)
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return RxJavaPlugins.onAssembly(new ObservablePublish(new PublishSource(localAtomicReference), paramObservableSource, localAtomicReference));
  }
  
  /* Error */
  public void connect(io.reactivex.functions.Consumer<? super Disposable> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public ObservableSource<T> publishSource()
  {
    return this.source;
  }
  
  public ObservableSource<T> source()
  {
    return this.source;
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver)
  {
    this.onSubscribe.subscribe(paramObserver);
  }
  
  static final class InnerDisposable<T>
    extends AtomicReference<Object>
    implements Disposable
  {
    private static final long serialVersionUID = -1100270633763673112L;
    final Observer<? super T> child;
    
    InnerDisposable(Observer<? super T> paramObserver)
    {
      this.child = paramObserver;
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
    void setParent(ObservablePublish.PublishObserver<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class PublishObserver<T>
    implements Observer<T>, Disposable
  {
    static final ObservablePublish.InnerDisposable[] EMPTY = new ObservablePublish.InnerDisposable[0];
    static final ObservablePublish.InnerDisposable[] TERMINATED = new ObservablePublish.InnerDisposable[0];
    final AtomicReference<PublishObserver<T>> current;
    final AtomicReference<ObservablePublish.InnerDisposable<T>[]> observers = new AtomicReference(EMPTY);
    final AtomicBoolean shouldConnect;
    final AtomicReference<Disposable> upstream = new AtomicReference();
    
    PublishObserver(AtomicReference<PublishObserver<T>> paramAtomicReference)
    {
      this.current = paramAtomicReference;
      this.shouldConnect = new AtomicBoolean();
    }
    
    boolean add(ObservablePublish.InnerDisposable<T> paramInnerDisposable)
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
    void remove(ObservablePublish.InnerDisposable<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class PublishSource<T>
    implements ObservableSource<T>
  {
    private final AtomicReference<ObservablePublish.PublishObserver<T>> curr;
    
    PublishSource(AtomicReference<ObservablePublish.PublishObserver<T>> paramAtomicReference)
    {
      this.curr = paramAtomicReference;
    }
    
    /* Error */
    public void subscribe(Observer<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservablePublish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */