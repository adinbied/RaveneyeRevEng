package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Completable;
import dji.thirdparty.rx.Completable.CompletableOnSubscribe;
import dji.thirdparty.rx.Completable.CompletableSubscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableOnSubscribeMergeDelayErrorArray
  implements Completable.CompletableOnSubscribe
{
  final Completable[] sources;
  
  public CompletableOnSubscribeMergeDelayErrorArray(Completable[] paramArrayOfCompletable)
  {
    this.sources = paramArrayOfCompletable;
  }
  
  /* Error */
  public void call(Completable.CompletableSubscriber arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\CompletableOnSubscribeMergeDelayErrorArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */