package dji.thirdparty.rx.subscriptions;

import dji.thirdparty.rx.Subscription;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class RefCountSubscription
  implements Subscription
{
  static final State EMPTY_STATE = new State(false, 0);
  private final Subscription actual;
  final AtomicReference<State> state = new AtomicReference(EMPTY_STATE);
  
  public RefCountSubscription(Subscription paramSubscription)
  {
    if (paramSubscription != null)
    {
      this.actual = paramSubscription;
      return;
    }
    throw new IllegalArgumentException("s");
  }
  
  /* Error */
  private void unsubscribeActualIfApplicable(State arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Subscription get()
  {
    return null;
  }
  
  public boolean isUnsubscribed()
  {
    return false;
  }
  
  /* Error */
  public void unsubscribe()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void unsubscribeAChild()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static final class InnerSubscription
    extends AtomicInteger
    implements Subscription
  {
    final RefCountSubscription parent;
    
    public InnerSubscription(RefCountSubscription paramRefCountSubscription)
    {
      this.parent = paramRefCountSubscription;
    }
    
    public boolean isUnsubscribed()
    {
      return false;
    }
    
    /* Error */
    public void unsubscribe()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private static final class State
  {
    final int children;
    final boolean isUnsubscribed;
    
    State(boolean paramBoolean, int paramInt)
    {
      this.isUnsubscribed = paramBoolean;
      this.children = paramInt;
    }
    
    State addChild()
    {
      return null;
    }
    
    State removeChild()
    {
      return null;
    }
    
    State unsubscribe()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\subscriptions\RefCountSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */