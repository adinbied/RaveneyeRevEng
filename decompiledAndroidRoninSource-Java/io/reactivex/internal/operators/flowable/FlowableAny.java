package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableAny<T>
  extends AbstractFlowableWithUpstream<T, Boolean>
{
  final Predicate<? super T> predicate;
  
  public FlowableAny(Flowable<T> paramFlowable, Predicate<? super T> paramPredicate)
  {
    super(paramFlowable);
    this.predicate = paramPredicate;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super Boolean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class AnySubscriber<T>
    extends DeferredScalarSubscription<Boolean>
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = -2311252482644620661L;
    boolean done;
    final Predicate<? super T> predicate;
    Subscription upstream;
    
    AnySubscriber(Subscriber<? super Boolean> paramSubscriber, Predicate<? super T> paramPredicate)
    {
      super();
      this.predicate = paramPredicate;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableAny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */