package io.reactivex.android;

import android.os.Looper;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class MainThreadDisposable
  implements Disposable
{
  private final AtomicBoolean unsubscribed = new AtomicBoolean();
  
  public static void verifyMainThread()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected to be called on the main thread but was ");
    localStringBuilder.append(Thread.currentThread().getName());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  /* Error */
  public final void dispose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final boolean isDisposed()
  {
    return this.unsubscribed.get();
  }
  
  protected abstract void onDispose();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\android\MainThreadDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */