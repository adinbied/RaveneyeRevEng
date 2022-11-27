package io.reactivex.flowables;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

public abstract class ConnectableFlowable<T>
  extends Flowable<T>
{
  private ConnectableFlowable<T> onRefCount()
  {
    return null;
  }
  
  public Flowable<T> autoConnect()
  {
    return autoConnect(1);
  }
  
  public Flowable<T> autoConnect(int paramInt)
  {
    return null;
  }
  
  public Flowable<T> autoConnect(int paramInt, Consumer<? super Disposable> paramConsumer)
  {
    return null;
  }
  
  public final Disposable connect()
  {
    return null;
  }
  
  public abstract void connect(Consumer<? super Disposable> paramConsumer);
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public Flowable<T> refCount()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> refCount(int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> refCount(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> refCount(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Flowable<T> refCount(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Flowable<T> refCount(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\flowables\ConnectableFlowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */