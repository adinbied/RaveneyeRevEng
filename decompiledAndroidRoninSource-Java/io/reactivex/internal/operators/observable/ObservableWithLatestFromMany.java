package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ObservableWithLatestFromMany<T, R>
  extends AbstractObservableWithUpstream<T, R>
{
  final Function<? super Object[], R> combiner;
  final ObservableSource<?>[] otherArray;
  final Iterable<? extends ObservableSource<?>> otherIterable;
  
  public ObservableWithLatestFromMany(ObservableSource<T> paramObservableSource, Iterable<? extends ObservableSource<?>> paramIterable, Function<? super Object[], R> paramFunction)
  {
    super(paramObservableSource);
    this.otherArray = null;
    this.otherIterable = paramIterable;
    this.combiner = paramFunction;
  }
  
  public ObservableWithLatestFromMany(ObservableSource<T> paramObservableSource, ObservableSource<?>[] paramArrayOfObservableSource, Function<? super Object[], R> paramFunction)
  {
    super(paramObservableSource);
    this.otherArray = paramArrayOfObservableSource;
    this.otherIterable = null;
    this.combiner = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  final class SingletonArrayFunc
    implements Function<T, R>
  {
    SingletonArrayFunc() {}
    
    public R apply(T paramT)
      throws Exception
    {
      return null;
    }
  }
  
  static final class WithLatestFromObserver<T, R>
    extends AtomicInteger
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = 1577321883966341961L;
    final Function<? super Object[], R> combiner;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable error;
    final ObservableWithLatestFromMany.WithLatestInnerObserver[] observers;
    final AtomicReference<Disposable> upstream;
    final AtomicReferenceArray<Object> values;
    
    WithLatestFromObserver(Observer<? super R> paramObserver, Function<? super Object[], R> paramFunction, int paramInt)
    {
      this.downstream = paramObserver;
      this.combiner = paramFunction;
      paramObserver = new ObservableWithLatestFromMany.WithLatestInnerObserver[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        paramObserver[i] = new ObservableWithLatestFromMany.WithLatestInnerObserver(this, i);
        i += 1;
      }
      this.observers = paramObserver;
      this.values = new AtomicReferenceArray(paramInt);
      this.upstream = new AtomicReference();
      this.error = new AtomicThrowable();
    }
    
    /* Error */
    void cancelAllBut(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void innerComplete(int paramInt, boolean paramBoolean)
    {
      if (!paramBoolean)
      {
        this.done = true;
        cancelAllBut(paramInt);
        HalfSerializer.onComplete(this.downstream, this, this.error);
      }
    }
    
    /* Error */
    void innerError(int arg1, Throwable arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    void innerNext(int paramInt, Object paramObject)
    {
      this.values.set(paramInt, paramObject);
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
      //   2: return
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this.upstream, paramDisposable);
    }
    
    /* Error */
    void subscribe(ObservableSource<?>[] arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class WithLatestInnerObserver
    extends AtomicReference<Disposable>
    implements Observer<Object>
  {
    private static final long serialVersionUID = 3256684027868224024L;
    boolean hasValue;
    final int index;
    final ObservableWithLatestFromMany.WithLatestFromObserver<?, ?> parent;
    
    WithLatestInnerObserver(ObservableWithLatestFromMany.WithLatestFromObserver<?, ?> paramWithLatestFromObserver, int paramInt)
    {
      this.parent = paramWithLatestFromObserver;
      this.index = paramInt;
    }
    
    public void dispose()
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
      this.parent.innerError(this.index, paramThrowable);
    }
    
    /* Error */
    public void onNext(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this, paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableWithLatestFromMany.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */