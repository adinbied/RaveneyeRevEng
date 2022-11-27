package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelPeek<T>
  extends ParallelFlowable<T>
{
  final Consumer<? super T> onAfterNext;
  final Action onAfterTerminated;
  final Action onCancel;
  final Action onComplete;
  final Consumer<? super Throwable> onError;
  final Consumer<? super T> onNext;
  final LongConsumer onRequest;
  final Consumer<? super Subscription> onSubscribe;
  final ParallelFlowable<T> source;
  
  public ParallelPeek(ParallelFlowable<T> paramParallelFlowable, Consumer<? super T> paramConsumer1, Consumer<? super T> paramConsumer2, Consumer<? super Throwable> paramConsumer, Action paramAction1, Action paramAction2, Consumer<? super Subscription> paramConsumer3, LongConsumer paramLongConsumer, Action paramAction3)
  {
    this.source = paramParallelFlowable;
    this.onNext = ((Consumer)ObjectHelper.requireNonNull(paramConsumer1, "onNext is null"));
    this.onAfterNext = ((Consumer)ObjectHelper.requireNonNull(paramConsumer2, "onAfterNext is null"));
    this.onError = ((Consumer)ObjectHelper.requireNonNull(paramConsumer, "onError is null"));
    this.onComplete = ((Action)ObjectHelper.requireNonNull(paramAction1, "onComplete is null"));
    this.onAfterTerminated = ((Action)ObjectHelper.requireNonNull(paramAction2, "onAfterTerminated is null"));
    this.onSubscribe = ((Consumer)ObjectHelper.requireNonNull(paramConsumer3, "onSubscribe is null"));
    this.onRequest = ((LongConsumer)ObjectHelper.requireNonNull(paramLongConsumer, "onRequest is null"));
    this.onCancel = ((Action)ObjectHelper.requireNonNull(paramAction3, "onCancel is null"));
  }
  
  public int parallelism()
  {
    return this.source.parallelism();
  }
  
  /* Error */
  public void subscribe(Subscriber<? super T>[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ParallelPeekSubscriber<T>
    implements FlowableSubscriber<T>, Subscription
  {
    boolean done;
    final Subscriber<? super T> downstream;
    final ParallelPeek<T> parent;
    Subscription upstream;
    
    ParallelPeekSubscriber(Subscriber<? super T> paramSubscriber, ParallelPeek<T> paramParallelPeek)
    {
      this.downstream = paramSubscriber;
      this.parent = paramParallelPeek;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
      //   2: return
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelPeek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */