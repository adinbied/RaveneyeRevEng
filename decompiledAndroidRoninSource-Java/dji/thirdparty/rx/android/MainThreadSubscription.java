package dji.thirdparty.rx.android;

import android.os.Looper;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class MainThreadSubscription
  implements Subscription
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
  
  public final boolean isUnsubscribed()
  {
    return this.unsubscribed.get();
  }
  
  protected abstract void onUnsubscribe();
  
  /* Error */
  public final void unsubscribe()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\android\MainThreadSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */