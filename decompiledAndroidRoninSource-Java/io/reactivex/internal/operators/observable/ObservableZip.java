package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableZip<T, R>
  extends Observable<R>
{
  final int bufferSize;
  final boolean delayError;
  final ObservableSource<? extends T>[] sources;
  final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;
  final Function<? super Object[], ? extends R> zipper;
  
  public ObservableZip(ObservableSource<? extends T>[] paramArrayOfObservableSource, Iterable<? extends ObservableSource<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction, int paramInt, boolean paramBoolean)
  {
    this.sources = paramArrayOfObservableSource;
    this.sourcesIterable = paramIterable;
    this.zipper = paramFunction;
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
  
  static final class ZipCoordinator<T, R>
    extends AtomicInteger
    implements Disposable
  {
    private static final long serialVersionUID = 2983708048395377667L;
    volatile boolean cancelled;
    final boolean delayError;
    final Observer<? super R> downstream;
    final ObservableZip.ZipObserver<T, R>[] observers;
    final T[] row;
    final Function<? super Object[], ? extends R> zipper;
    
    ZipCoordinator(Observer<? super R> paramObserver, Function<? super Object[], ? extends R> paramFunction, int paramInt, boolean paramBoolean)
    {
      this.downstream = paramObserver;
      this.zipper = paramFunction;
      this.observers = new ObservableZip.ZipObserver[paramInt];
      this.row = ((Object[])new Object[paramInt]);
      this.delayError = paramBoolean;
    }
    
    void cancel()
    {
      clear();
      cancelSources();
    }
    
    /* Error */
    void cancelSources()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Observer<? super R> paramObserver, boolean paramBoolean3, ObservableZip.ZipObserver<?, ?> paramZipObserver)
    {
      return false;
    }
    
    /* Error */
    void clear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
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
    
    /* Error */
    public void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    /* Error */
    public void subscribe(ObservableSource<? extends T>[] arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class ZipObserver<T, R>
    implements Observer<T>
  {
    volatile boolean done;
    Throwable error;
    final ObservableZip.ZipCoordinator<T, R> parent;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicReference<Disposable> upstream = new AtomicReference();
    
    ZipObserver(ObservableZip.ZipCoordinator<T, R> paramZipCoordinator, int paramInt)
    {
      this.parent = paramZipCoordinator;
      this.queue = new SpscLinkedArrayQueue(paramInt);
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this.upstream);
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
      this.error = paramThrowable;
      this.done = true;
      this.parent.drain();
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableZip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */