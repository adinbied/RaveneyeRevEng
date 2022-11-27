package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Completable;
import dji.thirdparty.rx.Completable.CompletableOnSubscribe;
import dji.thirdparty.rx.Completable.CompletableSubscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableOnSubscribeMergeIterable
  implements Completable.CompletableOnSubscribe
{
  final Iterable<? extends Completable> sources;
  
  public CompletableOnSubscribeMergeIterable(Iterable<? extends Completable> paramIterable)
  {
    this.sources = paramIterable;
  }
  
  /* Error */
  public void call(Completable.CompletableSubscriber arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\CompletableOnSubscribeMergeIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */