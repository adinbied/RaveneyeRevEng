package dji.thirdparty.rx.subscriptions;

import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import java.util.concurrent.Future;

public final class Subscriptions
{
  private static final Unsubscribed UNSUBSCRIBED = new Unsubscribed();
  
  private Subscriptions()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static Subscription create(Action0 paramAction0)
  {
    return BooleanSubscription.create(paramAction0);
  }
  
  public static Subscription empty()
  {
    return BooleanSubscription.create();
  }
  
  public static Subscription from(Future<?> paramFuture)
  {
    return new FutureSubscription(paramFuture);
  }
  
  public static CompositeSubscription from(Subscription... paramVarArgs)
  {
    return new CompositeSubscription(paramVarArgs);
  }
  
  public static Subscription unsubscribed()
  {
    return UNSUBSCRIBED;
  }
  
  private static final class FutureSubscription
    implements Subscription
  {
    final Future<?> f;
    
    public FutureSubscription(Future<?> paramFuture)
    {
      this.f = paramFuture;
    }
    
    public boolean isUnsubscribed()
    {
      return this.f.isCancelled();
    }
    
    public void unsubscribe()
    {
      this.f.cancel(true);
    }
  }
  
  static final class Unsubscribed
    implements Subscription
  {
    public boolean isUnsubscribed()
    {
      return true;
    }
    
    public void unsubscribe() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\subscriptions\Subscriptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */