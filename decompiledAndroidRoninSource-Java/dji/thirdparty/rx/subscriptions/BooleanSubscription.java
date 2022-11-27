package dji.thirdparty.rx.subscriptions;

import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import java.util.concurrent.atomic.AtomicReference;

public final class BooleanSubscription
  implements Subscription
{
  static final Action0 EMPTY_ACTION = new Action0()
  {
    public void call() {}
  };
  final AtomicReference<Action0> actionRef;
  
  public BooleanSubscription()
  {
    this.actionRef = new AtomicReference();
  }
  
  private BooleanSubscription(Action0 paramAction0)
  {
    this.actionRef = new AtomicReference(paramAction0);
  }
  
  public static BooleanSubscription create()
  {
    return new BooleanSubscription();
  }
  
  public static BooleanSubscription create(Action0 paramAction0)
  {
    return new BooleanSubscription(paramAction0);
  }
  
  public boolean isUnsubscribed()
  {
    return false;
  }
  
  /* Error */
  public final void unsubscribe()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\subscriptions\BooleanSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */