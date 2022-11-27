package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class DefaultObserver<T>
  implements Observer<T>
{
  private Disposable upstream;
  
  /* Error */
  protected final void cancel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void onStart() {}
  
  /* Error */
  public final void onSubscribe(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\observers\DefaultObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */