package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureDrop<T>
  extends AbstractFlowableWithUpstream<T, T>
  implements Consumer<T>
{
  final Consumer<? super T> onDrop;
  
  public FlowableOnBackpressureDrop(Flowable<T> paramFlowable)
  {
    super(paramFlowable);
    this.onDrop = this;
  }
  
  public FlowableOnBackpressureDrop(Flowable<T> paramFlowable, Consumer<? super T> paramConsumer)
  {
    super(paramFlowable);
    this.onDrop = paramConsumer;
  }
  
  public void accept(T paramT) {}
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class BackpressureDropSubscriber<T>
    extends AtomicLong
    implements FlowableSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = -6246093802440953054L;
    boolean done;
    final Subscriber<? super T> downstream;
    final Consumer<? super T> onDrop;
    Subscription upstream;
    
    BackpressureDropSubscriber(Subscriber<? super T> paramSubscriber, Consumer<? super T> paramConsumer)
    {
      this.downstream = paramSubscriber;
      this.onDrop = paramConsumer;
    }
    
    public void cancel()
    {
      this.upstream.cancel();
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
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableOnBackpressureDrop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */