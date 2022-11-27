package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

public abstract class ConnectableObservable<T>
  extends Observable<T>
{
  private ConnectableObservable<T> onRefCount()
  {
    return null;
  }
  
  public Observable<T> autoConnect()
  {
    return autoConnect(1);
  }
  
  public Observable<T> autoConnect(int paramInt)
  {
    return null;
  }
  
  public Observable<T> autoConnect(int paramInt, Consumer<? super Disposable> paramConsumer)
  {
    return null;
  }
  
  public final Disposable connect()
  {
    return null;
  }
  
  public abstract void connect(Consumer<? super Disposable> paramConsumer);
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public Observable<T> refCount()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> refCount(int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> refCount(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> refCount(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Observable<T> refCount(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Observable<T> refCount(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\observables\ConnectableObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */