package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class ForEachWhileSubscriber<T>
  extends AtomicReference<Subscription>
  implements FlowableSubscriber<T>, Disposable
{
  private static final long serialVersionUID = -4403180040475402120L;
  boolean done;
  final Action onComplete;
  final Consumer<? super Throwable> onError;
  final Predicate<? super T> onNext;
  
  public ForEachWhileSubscriber(Predicate<? super T> paramPredicate, Consumer<? super Throwable> paramConsumer, Action paramAction)
  {
    this.onNext = paramPredicate;
    this.onError = paramConsumer;
    this.onComplete = paramAction;
  }
  
  public void dispose()
  {
    SubscriptionHelper.cancel(this);
  }
  
  public boolean isDisposed()
  {
    return false;
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
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscribers\ForEachWhileSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */