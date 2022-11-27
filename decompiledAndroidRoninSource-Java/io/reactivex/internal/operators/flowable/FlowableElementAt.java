package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableElementAt<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final T defaultValue;
  final boolean errorOnFewer;
  final long index;
  
  public FlowableElementAt(Flowable<T> paramFlowable, long paramLong, T paramT, boolean paramBoolean)
  {
    super(paramFlowable);
    this.index = paramLong;
    this.defaultValue = paramT;
    this.errorOnFewer = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ElementAtSubscriber<T>
    extends DeferredScalarSubscription<T>
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = 4066607327284737757L;
    long count;
    final T defaultValue;
    boolean done;
    final boolean errorOnFewer;
    final long index;
    Subscription upstream;
    
    ElementAtSubscriber(Subscriber<? super T> paramSubscriber, long paramLong, T paramT, boolean paramBoolean)
    {
      super();
      this.index = paramLong;
      this.defaultValue = paramT;
      this.errorOnFewer = paramBoolean;
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
      //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableElementAt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */