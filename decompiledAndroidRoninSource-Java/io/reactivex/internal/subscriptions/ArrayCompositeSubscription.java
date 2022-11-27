package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscription;

public final class ArrayCompositeSubscription
  extends AtomicReferenceArray<Subscription>
  implements Disposable
{
  private static final long serialVersionUID = 2746389416410565408L;
  
  public ArrayCompositeSubscription(int paramInt)
  {
    super(paramInt);
  }
  
  /* Error */
  public void dispose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isDisposed()
  {
    return false;
  }
  
  public Subscription replaceResource(int paramInt, Subscription paramSubscription)
  {
    return null;
  }
  
  public boolean setResource(int paramInt, Subscription paramSubscription)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscriptions\ArrayCompositeSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */