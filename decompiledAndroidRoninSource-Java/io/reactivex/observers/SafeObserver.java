package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class SafeObserver<T>
  implements Observer<T>, Disposable
{
  boolean done;
  final Observer<? super T> downstream;
  Disposable upstream;
  
  public SafeObserver(Observer<? super T> paramObserver)
  {
    this.downstream = paramObserver;
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
    //   2: return
  }
  
  /* Error */
  void onCompleteNoSubscription()
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
  void onNextNoSubscription()
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
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\observers\SafeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */