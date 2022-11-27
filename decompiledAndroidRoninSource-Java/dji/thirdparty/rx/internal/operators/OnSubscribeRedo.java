package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Notification;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.functions.Func2;
import dji.thirdparty.rx.internal.producers.ProducerArbiter;
import dji.thirdparty.rx.schedulers.Schedulers;
import dji.thirdparty.rx.subjects.BehaviorSubject;
import dji.thirdparty.rx.subscriptions.SerialSubscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class OnSubscribeRedo<T>
  implements Observable.OnSubscribe<T>
{
  static final Func1<Observable<? extends Notification<?>>, Observable<?>> REDO_INFINITE = new Func1()
  {
    public Observable<?> call(Observable<? extends Notification<?>> paramAnonymousObservable)
    {
      return null;
    }
  };
  private final Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> controlHandlerFunction;
  private final Scheduler scheduler;
  final Observable<T> source;
  final boolean stopOnComplete;
  final boolean stopOnError;
  
  private OnSubscribeRedo(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1, boolean paramBoolean1, boolean paramBoolean2, Scheduler paramScheduler)
  {
    this.source = paramObservable;
    this.controlHandlerFunction = paramFunc1;
    this.stopOnComplete = paramBoolean1;
    this.stopOnError = paramBoolean2;
    this.scheduler = paramScheduler;
  }
  
  public static <T> Observable<T> redo(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1, Scheduler paramScheduler)
  {
    return Observable.create(new OnSubscribeRedo(paramObservable, paramFunc1, false, false, paramScheduler));
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable)
  {
    return repeat(paramObservable, Schedulers.trampoline());
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable, long paramLong)
  {
    return repeat(paramObservable, paramLong, Schedulers.trampoline());
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable, long paramLong, Scheduler paramScheduler)
  {
    boolean bool = paramLong < 0L;
    if (!bool) {
      return Observable.empty();
    }
    if (!bool) {
      return repeat(paramObservable, new RedoFinite(paramLong - 1L), paramScheduler);
    }
    throw new IllegalArgumentException("count >= 0 expected");
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable, Scheduler paramScheduler)
  {
    return repeat(paramObservable, REDO_INFINITE, paramScheduler);
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1)
  {
    return Observable.create(new OnSubscribeRedo(paramObservable, paramFunc1, false, true, Schedulers.trampoline()));
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1, Scheduler paramScheduler)
  {
    return Observable.create(new OnSubscribeRedo(paramObservable, paramFunc1, false, true, paramScheduler));
  }
  
  public static <T> Observable<T> retry(Observable<T> paramObservable)
  {
    return retry(paramObservable, REDO_INFINITE);
  }
  
  public static <T> Observable<T> retry(Observable<T> paramObservable, long paramLong)
  {
    boolean bool = paramLong < 0L;
    if (!bool)
    {
      if (!bool) {
        return paramObservable;
      }
      return retry(paramObservable, new RedoFinite(paramLong));
    }
    throw new IllegalArgumentException("count >= 0 expected");
  }
  
  public static <T> Observable<T> retry(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1)
  {
    return Observable.create(new OnSubscribeRedo(paramObservable, paramFunc1, true, false, Schedulers.trampoline()));
  }
  
  public static <T> Observable<T> retry(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1, Scheduler paramScheduler)
  {
    return Observable.create(new OnSubscribeRedo(paramObservable, paramFunc1, true, false, paramScheduler));
  }
  
  /* Error */
  public void call(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static final class RedoFinite
    implements Func1<Observable<? extends Notification<?>>, Observable<?>>
  {
    final long count;
    
    public RedoFinite(long paramLong)
    {
      this.count = paramLong;
    }
    
    public Observable<?> call(Observable<? extends Notification<?>> paramObservable)
    {
      return null;
    }
  }
  
  public static final class RetryWithPredicate
    implements Func1<Observable<? extends Notification<?>>, Observable<? extends Notification<?>>>
  {
    final Func2<Integer, Throwable, Boolean> predicate;
    
    public RetryWithPredicate(Func2<Integer, Throwable, Boolean> paramFunc2)
    {
      this.predicate = paramFunc2;
    }
    
    public Observable<? extends Notification<?>> call(Observable<? extends Notification<?>> paramObservable)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeRedo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */