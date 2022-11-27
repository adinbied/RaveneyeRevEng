package dji.thirdparty.rx.internal.schedulers;

import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.internal.util.SubscriptionList;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ScheduledAction
  extends AtomicReference<Thread>
  implements Runnable, Subscription
{
  private static final long serialVersionUID = -3962399486978279857L;
  final Action0 action;
  final SubscriptionList cancel;
  
  public ScheduledAction(Action0 paramAction0)
  {
    this.action = paramAction0;
    this.cancel = new SubscriptionList();
  }
  
  public ScheduledAction(Action0 paramAction0, SubscriptionList paramSubscriptionList)
  {
    this.action = paramAction0;
    this.cancel = new SubscriptionList(new Remover2(this, paramSubscriptionList));
  }
  
  public ScheduledAction(Action0 paramAction0, CompositeSubscription paramCompositeSubscription)
  {
    this.action = paramAction0;
    this.cancel = new SubscriptionList(new Remover(this, paramCompositeSubscription));
  }
  
  public void add(Subscription paramSubscription)
  {
    this.cancel.add(paramSubscription);
  }
  
  /* Error */
  public void add(Future<?> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addParent(SubscriptionList arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addParent(CompositeSubscription arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isUnsubscribed()
  {
    return this.cancel.isUnsubscribed();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void unsubscribe()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private final class FutureCompleter
    implements Subscription
  {
    private final Future<?> f;
    
    FutureCompleter()
    {
      Future localFuture;
      this.f = localFuture;
    }
    
    public boolean isUnsubscribed()
    {
      return this.f.isCancelled();
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
  
  private static final class Remover
    extends AtomicBoolean
    implements Subscription
  {
    private static final long serialVersionUID = 247232374289553518L;
    final CompositeSubscription parent;
    final ScheduledAction s;
    
    public Remover(ScheduledAction paramScheduledAction, CompositeSubscription paramCompositeSubscription)
    {
      this.s = paramScheduledAction;
      this.parent = paramCompositeSubscription;
    }
    
    public boolean isUnsubscribed()
    {
      return this.s.isUnsubscribed();
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
  
  private static final class Remover2
    extends AtomicBoolean
    implements Subscription
  {
    private static final long serialVersionUID = 247232374289553518L;
    final SubscriptionList parent;
    final ScheduledAction s;
    
    public Remover2(ScheduledAction paramScheduledAction, SubscriptionList paramSubscriptionList)
    {
      this.s = paramScheduledAction;
      this.parent = paramSubscriptionList;
    }
    
    public boolean isUnsubscribed()
    {
      return this.s.isUnsubscribed();
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\schedulers\ScheduledAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */