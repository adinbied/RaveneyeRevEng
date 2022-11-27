package io.reactivex.disposables;

import org.reactivestreams.Subscription;

final class SubscriptionDisposable
  extends ReferenceDisposable<Subscription>
{
  private static final long serialVersionUID = -707001650852963139L;
  
  SubscriptionDisposable(Subscription paramSubscription)
  {
    super(paramSubscription);
  }
  
  protected void onDisposed(Subscription paramSubscription)
  {
    paramSubscription.cancel();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\disposables\SubscriptionDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */