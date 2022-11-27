package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMap<T, R>
  extends AbstractObservableWithUpstream<T, R>
{
  final int bufferSize;
  final boolean delayErrors;
  final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
  
  public ObservableSwitchMap(ObservableSource<T> paramObservableSource, Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, int paramInt, boolean paramBoolean)
  {
    super(paramObservableSource);
    this.mapper = paramFunction;
    this.bufferSize = paramInt;
    this.delayErrors = paramBoolean;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SwitchMapInnerObserver<T, R>
    extends AtomicReference<Disposable>
    implements Observer<R>
  {
    private static final long serialVersionUID = 3837284832786408377L;
    final int bufferSize;
    volatile boolean done;
    final long index;
    final ObservableSwitchMap.SwitchMapObserver<T, R> parent;
    volatile SimpleQueue<R> queue;
    
    SwitchMapInnerObserver(ObservableSwitchMap.SwitchMapObserver<T, R> paramSwitchMapObserver, long paramLong, int paramInt)
    {
      this.parent = paramSwitchMapObserver;
      this.index = paramLong;
      this.bufferSize = paramInt;
    }
    
    public void cancel()
    {
      DisposableHelper.dispose(this);
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.innerError(this, paramThrowable);
    }
    
    /* Error */
    public void onNext(R arg1)
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
  
  static final class SwitchMapObserver<T, R>
    extends AtomicInteger
    implements Observer<T>, Disposable
  {
    static final ObservableSwitchMap.SwitchMapInnerObserver<Object, Object> CANCELLED;
    private static final long serialVersionUID = -3491074160481096299L;
    final AtomicReference<ObservableSwitchMap.SwitchMapInnerObserver<T, R>> active = new AtomicReference();
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable errors;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    volatile long unique;
    Disposable upstream;
    
    static
    {
      ObservableSwitchMap.SwitchMapInnerObserver localSwitchMapInnerObserver = new ObservableSwitchMap.SwitchMapInnerObserver(null, -1L, 1);
      CANCELLED = localSwitchMapInnerObserver;
      localSwitchMapInnerObserver.cancel();
    }
    
    SwitchMapObserver(Observer<? super R> paramObserver, Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, int paramInt, boolean paramBoolean)
    {
      this.downstream = paramObserver;
      this.mapper = paramFunction;
      this.bufferSize = paramInt;
      this.delayErrors = paramBoolean;
      this.errors = new AtomicThrowable();
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
      //   2: return
    }
    
    /* Error */
    void innerError(ObservableSwitchMap.SwitchMapInnerObserver<T, R> arg1, Throwable arg2)
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSwitchMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */