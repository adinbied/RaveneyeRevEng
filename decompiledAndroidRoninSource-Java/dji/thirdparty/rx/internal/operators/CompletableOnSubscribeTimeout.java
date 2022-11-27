package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Completable;
import dji.thirdparty.rx.Completable.CompletableOnSubscribe;
import dji.thirdparty.rx.Completable.CompletableSubscriber;
import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableOnSubscribeTimeout
  implements Completable.CompletableOnSubscribe
{
  final Completable other;
  final Scheduler scheduler;
  final Completable source;
  final long timeout;
  final TimeUnit unit;
  
  public CompletableOnSubscribeTimeout(Completable paramCompletable1, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, Completable paramCompletable2)
  {
    this.source = paramCompletable1;
    this.timeout = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.other = paramCompletable2;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\CompletableOnSubscribeTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */