package dji.thirdparty.rx.subscriptions;

import dji.thirdparty.rx.Subscription;
import java.util.concurrent.atomic.AtomicReference;

public final class SerialSubscription
  implements Subscription
{
  final AtomicReference<State> state = new AtomicReference(new State(false, Subscriptions.empty()));
  
  public Subscription get()
  {
    return null;
  }
  
  public boolean isUnsubscribed()
  {
    return false;
  }
  
  /* Error */
  public void set(Subscription arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void unsubscribe()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static final class State
  {
    final boolean isUnsubscribed;
    final Subscription subscription;
    
    State(boolean paramBoolean, Subscription paramSubscription)
    {
      this.isUnsubscribed = paramBoolean;
      this.subscription = paramSubscription;
    }
    
    State set(Subscription paramSubscription)
    {
      return new State(this.isUnsubscribed, paramSubscription);
    }
    
    State unsubscribe()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\subscriptions\SerialSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */