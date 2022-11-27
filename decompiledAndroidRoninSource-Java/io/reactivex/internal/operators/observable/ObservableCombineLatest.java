package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCombineLatest<T, R>
  extends Observable<R>
{
  final int bufferSize;
  final Function<? super Object[], ? extends R> combiner;
  final boolean delayError;
  final ObservableSource<? extends T>[] sources;
  final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;
  
  public ObservableCombineLatest(ObservableSource<? extends T>[] paramArrayOfObservableSource, Iterable<? extends ObservableSource<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction, int paramInt, boolean paramBoolean)
  {
    this.sources = paramArrayOfObservableSource;
    this.sourcesIterable = paramIterable;
    this.combiner = paramFunction;
    this.bufferSize = paramInt;
    this.delayError = paramBoolean;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CombinerObserver<T, R>
    extends AtomicReference<Disposable>
    implements Observer<T>
  {
    private static final long serialVersionUID = -4823716997131257941L;
    final int index;
    final ObservableCombineLatest.LatestCoordinator<T, R> parent;
    
    CombinerObserver(ObservableCombineLatest.LatestCoordinator<T, R> paramLatestCoordinator, int paramInt)
    {
      this.parent = paramLatestCoordinator;
      this.index = paramInt;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
    }
    
    public void onComplete()
    {
      this.parent.innerComplete(this.index);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.innerError(this.index, paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.parent.innerNext(this.index, paramT);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this, paramDisposable);
    }
  }
  
  static final class LatestCoordinator<T, R>
    extends AtomicInteger
    implements Disposable
  {
    private static final long serialVersionUID = 8567835998786448817L;
    int active;
    volatile boolean cancelled;
    final Function<? super Object[], ? extends R> combiner;
    int complete;
    final boolean delayError;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable errors = new AtomicThrowable();
    Object[] latest;
    final ObservableCombineLatest.CombinerObserver<T, R>[] observers;
    final SpscLinkedArrayQueue<Object[]> queue;
    
    LatestCoordinator(Observer<? super R> paramObserver, Function<? super Object[], ? extends R> paramFunction, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.downstream = paramObserver;
      this.combiner = paramFunction;
      this.delayError = paramBoolean;
      this.latest = new Object[paramInt1];
      paramObserver = new ObservableCombineLatest.CombinerObserver[paramInt1];
      int i = 0;
      while (i < paramInt1)
      {
        paramObserver[i] = new ObservableCombineLatest.CombinerObserver(this, i);
        i += 1;
      }
      this.observers = paramObserver;
      this.queue = new SpscLinkedArrayQueue(paramInt2);
    }
    
    /* Error */
    void cancelSources()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void clear(SpscLinkedArrayQueue<?> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void innerComplete(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    /* Error */
    void innerError(int arg1, Throwable arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    /* Error */
    void innerNext(int arg1, T arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    /* Error */
    public void subscribe(ObservableSource<? extends T>[] arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableCombineLatest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */