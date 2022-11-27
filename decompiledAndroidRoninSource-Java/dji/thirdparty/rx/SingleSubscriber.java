package dji.thirdparty.rx;

import dji.thirdparty.rx.internal.util.SubscriptionList;

public abstract class SingleSubscriber<T>
  implements Subscription
{
  private final SubscriptionList cs = new SubscriptionList();
  
  public final void add(Subscription paramSubscription)
  {
    this.cs.add(paramSubscription);
  }
  
  public final boolean isUnsubscribed()
  {
    return this.cs.isUnsubscribed();
  }
  
  public abstract void onError(Throwable paramThrowable);
  
  public abstract void onSuccess(T paramT);
  
  public final void unsubscribe()
  {
    this.cs.unsubscribe();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\SingleSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */