package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Completable;
import dji.thirdparty.rx.Completable.CompletableOnSubscribe;
import dji.thirdparty.rx.Completable.CompletableSubscriber;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.exceptions.CompositeException;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class CompletableOnSubscribeMerge
  implements Completable.CompletableOnSubscribe
{
  final boolean delayErrors;
  final int maxConcurrency;
  final Observable<? extends Completable> source;
  
  public CompletableOnSubscribeMerge(Observable<? extends Completable> paramObservable, int paramInt, boolean paramBoolean)
  {
    this.source = paramObservable;
    this.maxConcurrency = paramInt;
    this.delayErrors = paramBoolean;
  }
  
  public static Throwable collectErrors(Queue<Throwable> paramQueue)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Throwable localThrowable = (Throwable)paramQueue.poll();
      if (localThrowable == null) {
        break;
      }
      localArrayList.add(localThrowable);
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    if (localArrayList.size() == 1) {
      return (Throwable)localArrayList.get(0);
    }
    return new CompositeException(localArrayList);
  }
  
  /* Error */
  public void call(Completable.CompletableSubscriber arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CompletableMergeSubscriber
    extends Subscriber<Completable>
  {
    static final AtomicReferenceFieldUpdater<CompletableMergeSubscriber, Queue> ERRORS = AtomicReferenceFieldUpdater.newUpdater(CompletableMergeSubscriber.class, Queue.class, "errors");
    static final AtomicIntegerFieldUpdater<CompletableMergeSubscriber> ONCE = AtomicIntegerFieldUpdater.newUpdater(CompletableMergeSubscriber.class, "once");
    final Completable.CompletableSubscriber actual;
    final boolean delayErrors;
    volatile boolean done;
    volatile Queue<Throwable> errors;
    final int maxConcurrency;
    volatile int once;
    final CompositeSubscription set;
    final AtomicInteger wip;
    
    public CompletableMergeSubscriber(Completable.CompletableSubscriber paramCompletableSubscriber, int paramInt, boolean paramBoolean)
    {
      this.actual = paramCompletableSubscriber;
      this.maxConcurrency = paramInt;
      this.delayErrors = paramBoolean;
      this.set = new CompositeSubscription();
      this.wip = new AtomicInteger(1);
      if (paramInt == Integer.MAX_VALUE)
      {
        request(Long.MAX_VALUE);
        return;
      }
      request(paramInt);
    }
    
    Queue<Throwable> getOrCreateErrors()
    {
      return null;
    }
    
    /* Error */
    public void onCompleted()
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
    public void onNext(Completable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void terminate()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\CompletableOnSubscribeMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */