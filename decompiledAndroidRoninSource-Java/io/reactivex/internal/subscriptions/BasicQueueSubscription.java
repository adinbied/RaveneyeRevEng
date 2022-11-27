package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import java.util.concurrent.atomic.AtomicLong;

public abstract class BasicQueueSubscription<T>
  extends AtomicLong
  implements QueueSubscription<T>
{
  private static final long serialVersionUID = -6671519529404341862L;
  
  public final boolean offer(T paramT)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public final boolean offer(T paramT1, T paramT2)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscriptions\BasicQueueSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */