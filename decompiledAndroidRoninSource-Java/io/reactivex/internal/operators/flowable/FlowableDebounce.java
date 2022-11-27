package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDebounce<T, U>
  extends AbstractFlowableWithUpstream<T, T>
{
  final Function<? super T, ? extends Publisher<U>> debounceSelector;
  
  public FlowableDebounce(Flowable<T> paramFlowable, Function<? super T, ? extends Publisher<U>> paramFunction)
  {
    super(paramFlowable);
    this.debounceSelector = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DebounceSubscriber<T, U>
    extends AtomicLong
    implements FlowableSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = 6725975399620862591L;
    final Function<? super T, ? extends Publisher<U>> debounceSelector;
    final AtomicReference<Disposable> debouncer = new AtomicReference();
    boolean done;
    final Subscriber<? super T> downstream;
    volatile long index;
    Subscription upstream;
    
    DebounceSubscriber(Subscriber<? super T> paramSubscriber, Function<? super T, ? extends Publisher<U>> paramFunction)
    {
      this.downstream = paramSubscriber;
      this.debounceSelector = paramFunction;
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
    void emit(long arg1, T arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
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
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    static final class DebounceInnerSubscriber<T, U>
      extends DisposableSubscriber<U>
    {
      boolean done;
      final long index;
      final AtomicBoolean once = new AtomicBoolean();
      final FlowableDebounce.DebounceSubscriber<T, U> parent;
      final T value;
      
      DebounceInnerSubscriber(FlowableDebounce.DebounceSubscriber<T, U> paramDebounceSubscriber, long paramLong, T paramT)
      {
        this.parent = paramDebounceSubscriber;
        this.index = paramLong;
        this.value = paramT;
      }
      
      /* Error */
      void emit()
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
      
      public void onNext(U paramU)
      {
        if (this.done) {
          return;
        }
        this.done = true;
        cancel();
        emit();
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDebounce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */