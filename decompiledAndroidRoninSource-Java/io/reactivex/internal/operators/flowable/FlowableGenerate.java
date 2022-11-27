package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGenerate<T, S>
  extends Flowable<T>
{
  final Consumer<? super S> disposeState;
  final BiFunction<S, Emitter<T>, S> generator;
  final Callable<S> stateSupplier;
  
  public FlowableGenerate(Callable<S> paramCallable, BiFunction<S, Emitter<T>, S> paramBiFunction, Consumer<? super S> paramConsumer)
  {
    this.stateSupplier = paramCallable;
    this.generator = paramBiFunction;
    this.disposeState = paramConsumer;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class GeneratorSubscription<T, S>
    extends AtomicLong
    implements Emitter<T>, Subscription
  {
    private static final long serialVersionUID = 7565982551505011832L;
    volatile boolean cancelled;
    final Consumer<? super S> disposeState;
    final Subscriber<? super T> downstream;
    final BiFunction<S, ? super Emitter<T>, S> generator;
    boolean hasNext;
    S state;
    boolean terminate;
    
    GeneratorSubscription(Subscriber<? super T> paramSubscriber, BiFunction<S, ? super Emitter<T>, S> paramBiFunction, Consumer<? super S> paramConsumer, S paramS)
    {
      this.downstream = paramSubscriber;
      this.generator = paramBiFunction;
      this.disposeState = paramConsumer;
      this.state = paramS;
    }
    
    /* Error */
    private void dispose(S arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableGenerate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */