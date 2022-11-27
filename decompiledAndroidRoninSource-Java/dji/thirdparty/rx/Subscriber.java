package dji.thirdparty.rx;

import dji.thirdparty.rx.internal.util.SubscriptionList;

public abstract class Subscriber<T>
  implements Observer<T>, Subscription
{
  private static final Long NOT_SET = Long.valueOf(Long.MIN_VALUE);
  private Producer producer;
  private long requested = NOT_SET.longValue();
  private final Subscriber<?> subscriber;
  private final SubscriptionList subscriptions;
  
  protected Subscriber()
  {
    this(null, false);
  }
  
  protected Subscriber(Subscriber<?> paramSubscriber)
  {
    this(paramSubscriber, true);
  }
  
  protected Subscriber(Subscriber<?> paramSubscriber, boolean paramBoolean)
  {
    this.subscriber = paramSubscriber;
    if ((paramBoolean) && (paramSubscriber != null)) {
      paramSubscriber = paramSubscriber.subscriptions;
    } else {
      paramSubscriber = new SubscriptionList();
    }
    this.subscriptions = paramSubscriber;
  }
  
  /* Error */
  private void addToRequested(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public final void add(Subscription paramSubscription)
  {
    this.subscriptions.add(paramSubscription);
  }
  
  public final boolean isUnsubscribed()
  {
    return this.subscriptions.isUnsubscribed();
  }
  
  public void onStart() {}
  
  /* Error */
  protected final void request(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  /* Error */
  public void setProducer(Producer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public final void unsubscribe()
  {
    this.subscriptions.unsubscribe();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\Subscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */