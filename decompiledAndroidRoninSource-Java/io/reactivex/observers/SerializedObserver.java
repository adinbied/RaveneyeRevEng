package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;

public final class SerializedObserver<T>
  implements Observer<T>, Disposable
{
  static final int QUEUE_LINK_SIZE = 4;
  final boolean delayError;
  volatile boolean done;
  final Observer<? super T> downstream;
  boolean emitting;
  AppendOnlyLinkedArrayList<Object> queue;
  Disposable upstream;
  
  public SerializedObserver(Observer<? super T> paramObserver)
  {
    this(paramObserver, false);
  }
  
  public SerializedObserver(Observer<? super T> paramObserver, boolean paramBoolean)
  {
    this.downstream = paramObserver;
    this.delayError = paramBoolean;
  }
  
  public void dispose()
  {
    this.upstream.dispose();
  }
  
  /* Error */
  void emitLoop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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
    //   2: return
  }
  
  /* Error */
  public void onError(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\observers\SerializedObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */