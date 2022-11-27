package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCollect<T, U>
  extends AbstractFlowableWithUpstream<T, U>
{
  final BiConsumer<? super U, ? super T> collector;
  final Callable<? extends U> initialSupplier;
  
  public FlowableCollect(Flowable<T> paramFlowable, Callable<? extends U> paramCallable, BiConsumer<? super U, ? super T> paramBiConsumer)
  {
    super(paramFlowable);
    this.initialSupplier = paramCallable;
    this.collector = paramBiConsumer;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class CollectSubscriber<T, U>
    extends DeferredScalarSubscription<U>
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = -3589550218733891694L;
    final BiConsumer<? super U, ? super T> collector;
    boolean done;
    final U u;
    Subscription upstream;
    
    CollectSubscriber(Subscriber<? super U> paramSubscriber, U paramU, BiConsumer<? super U, ? super T> paramBiConsumer)
    {
      super();
      this.collector = paramBiConsumer;
      this.u = paramU;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableCollect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */