package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCreate<T>
  extends Observable<T>
{
  final ObservableOnSubscribe<T> source;
  
  public ObservableCreate(ObservableOnSubscribe<T> paramObservableOnSubscribe)
  {
    this.source = paramObservableOnSubscribe;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class CreateEmitter<T>
    extends AtomicReference<Disposable>
    implements ObservableEmitter<T>, Disposable
  {
    private static final long serialVersionUID = -3434801548987643227L;
    final Observer<? super T> observer;
    
    CreateEmitter(Observer<? super T> paramObserver)
    {
      this.observer = paramObserver;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
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
      //   2: return
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
    
    public ObservableEmitter<T> serialize()
    {
      return new ObservableCreate.SerializedEmitter(this);
    }
    
    /* Error */
    public void setCancellable(Cancellable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void setDisposable(Disposable paramDisposable)
    {
      DisposableHelper.set(this, paramDisposable);
    }
    
    public String toString()
    {
      return null;
    }
    
    public boolean tryOnError(Throwable paramThrowable)
    {
      return false;
    }
  }
  
  static final class SerializedEmitter<T>
    extends AtomicInteger
    implements ObservableEmitter<T>
  {
    private static final long serialVersionUID = 4883307006032401862L;
    volatile boolean done;
    final ObservableEmitter<T> emitter;
    final AtomicThrowable error;
    final SpscLinkedArrayQueue<T> queue;
    
    SerializedEmitter(ObservableEmitter<T> paramObservableEmitter)
    {
      this.emitter = paramObservableEmitter;
      this.error = new AtomicThrowable();
      this.queue = new SpscLinkedArrayQueue(16);
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void drainLoop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return this.emitter.isDisposed();
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
    
    public ObservableEmitter<T> serialize()
    {
      return this;
    }
    
    public void setCancellable(Cancellable paramCancellable)
    {
      this.emitter.setCancellable(paramCancellable);
    }
    
    public void setDisposable(Disposable paramDisposable)
    {
      this.emitter.setDisposable(paramDisposable);
    }
    
    public String toString()
    {
      return this.emitter.toString();
    }
    
    public boolean tryOnError(Throwable paramThrowable)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */