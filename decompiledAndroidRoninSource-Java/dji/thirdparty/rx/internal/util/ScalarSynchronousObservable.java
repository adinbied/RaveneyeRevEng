package dji.thirdparty.rx.internal.util;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.internal.producers.SingleProducer;
import dji.thirdparty.rx.internal.schedulers.EventLoopsScheduler;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ScalarSynchronousObservable<T>
  extends Observable<T>
{
  static final boolean STRONG_MODE = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
  final T t;
  
  protected ScalarSynchronousObservable(T paramT)
  {
    super(new Observable.OnSubscribe()
    {
      /* Error */
      public void call(Subscriber<? super T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
    this.t = paramT;
  }
  
  public static <T> ScalarSynchronousObservable<T> create(T paramT)
  {
    return new ScalarSynchronousObservable(paramT);
  }
  
  static <T> Producer createProducer(Subscriber<? super T> paramSubscriber, T paramT)
  {
    if (STRONG_MODE) {
      return new SingleProducer(paramSubscriber, paramT);
    }
    return new WeakSingleProducer(paramSubscriber, paramT);
  }
  
  public T get()
  {
    return (T)this.t;
  }
  
  public <R> Observable<R> scalarFlatMap(Func1<? super T, ? extends Observable<? extends R>> paramFunc1)
  {
    return null;
  }
  
  public Observable<T> scalarScheduleOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  static final class ScalarAsyncOnSubscribe<T>
    implements Observable.OnSubscribe<T>
  {
    final Func1<Action0, Subscription> onSchedule;
    final T value;
    
    ScalarAsyncOnSubscribe(T paramT, Func1<Action0, Subscription> paramFunc1)
    {
      this.value = paramT;
      this.onSchedule = paramFunc1;
    }
    
    /* Error */
    public void call(Subscriber<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class ScalarAsyncProducer<T>
    extends AtomicBoolean
    implements Producer, Action0
  {
    private static final long serialVersionUID = -2466317989629281651L;
    final Subscriber<? super T> actual;
    final Func1<Action0, Subscription> onSchedule;
    final T value;
    
    public ScalarAsyncProducer(Subscriber<? super T> paramSubscriber, T paramT, Func1<Action0, Subscription> paramFunc1)
    {
      this.actual = paramSubscriber;
      this.value = paramT;
      this.onSchedule = paramFunc1;
    }
    
    /* Error */
    public void call()
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
      //   2: goto -2 -> 0
    }
    
    public String toString()
    {
      return null;
    }
  }
  
  static final class WeakSingleProducer<T>
    implements Producer
  {
    final Subscriber<? super T> actual;
    boolean once;
    final T value;
    
    public WeakSingleProducer(Subscriber<? super T> paramSubscriber, T paramT)
    {
      this.actual = paramSubscriber;
      this.value = paramT;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\ScalarSynchronousObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */