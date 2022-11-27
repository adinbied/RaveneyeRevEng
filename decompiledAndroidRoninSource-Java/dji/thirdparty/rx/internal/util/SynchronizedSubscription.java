package dji.thirdparty.rx.internal.util;

import dji.thirdparty.rx.Subscription;

public class SynchronizedSubscription
  implements Subscription
{
  private final Subscription s;
  
  public SynchronizedSubscription(Subscription paramSubscription)
  {
    this.s = paramSubscription;
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
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\SynchronizedSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */