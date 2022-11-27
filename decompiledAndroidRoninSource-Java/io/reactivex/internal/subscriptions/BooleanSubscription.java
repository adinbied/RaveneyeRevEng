package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscription;

public final class BooleanSubscription
  extends AtomicBoolean
  implements Subscription
{
  private static final long serialVersionUID = -8127758972444290902L;
  
  public void cancel()
  {
    lazySet(true);
  }
  
  public boolean isCancelled()
  {
    return get();
  }
  
  public void request(long paramLong)
  {
    SubscriptionHelper.validate(paramLong);
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscriptions\BooleanSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */