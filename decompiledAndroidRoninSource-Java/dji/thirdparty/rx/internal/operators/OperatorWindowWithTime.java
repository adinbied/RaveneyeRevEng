package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.observers.SerializedObserver;
import dji.thirdparty.rx.observers.SerializedSubscriber;
import dji.thirdparty.rx.subscriptions.Subscriptions;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class OperatorWindowWithTime<T>
  implements Observable.Operator<Observable<T>, T>
{
  static final Object NEXT_SUBJECT = new Object();
  static final NotificationLite<Object> nl = NotificationLite.instance();
  final Scheduler scheduler;
  final int size;
  final long timeshift;
  final long timespan;
  final TimeUnit unit;
  
  public OperatorWindowWithTime(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler)
  {
    this.timespan = paramLong1;
    this.timeshift = paramLong2;
    this.unit = paramTimeUnit;
    this.size = paramInt;
    this.scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<T>> paramSubscriber)
  {
    return null;
  }
  
  static final class CountedSerializedSubject<T>
  {
    final Observer<T> consumer;
    int count;
    final Observable<T> producer;
    
    public CountedSerializedSubject(Observer<T> paramObserver, Observable<T> paramObservable)
    {
      this.consumer = new SerializedObserver(paramObserver);
      this.producer = paramObservable;
    }
  }
  
  final class ExactSubscriber
    extends Subscriber<T>
  {
    final Subscriber<? super Observable<T>> child;
    boolean emitting;
    final Object guard;
    List<Object> queue;
    volatile OperatorWindowWithTime.State<T> state;
    final Scheduler.Worker worker;
    
    public ExactSubscriber(Scheduler.Worker paramWorker)
    {
      this.child = new SerializedSubscriber(paramWorker);
      Scheduler.Worker localWorker;
      this.worker = localWorker;
      this.guard = new Object();
      this.state = OperatorWindowWithTime.State.empty();
      paramWorker.add(Subscriptions.create(new Action0()
      {
        /* Error */
        public void call()
        {
          // Byte code:
          //   0: return
          //   1: astore_1
          //   2: goto -2 -> 0
        }
      }));
    }
    
    /* Error */
    void complete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean drain(List<Object> paramList)
    {
      return false;
    }
    
    boolean emitValue(T paramT)
    {
      return false;
    }
    
    /* Error */
    void error(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void nextWindow()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onCompleted()
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
    public void onStart()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean replaceSubject()
    {
      return false;
    }
    
    /* Error */
    void scheduleExact()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  final class InexactSubscriber
    extends Subscriber<T>
  {
    final Subscriber<? super Observable<T>> child;
    final List<OperatorWindowWithTime.CountedSerializedSubject<T>> chunks;
    boolean done;
    final Object guard;
    final Scheduler.Worker worker;
    
    public InexactSubscriber(Scheduler.Worker paramWorker)
    {
      super();
      this.child = paramWorker;
      Scheduler.Worker localWorker;
      this.worker = localWorker;
      this.guard = new Object();
      this.chunks = new LinkedList();
    }
    
    OperatorWindowWithTime.CountedSerializedSubject<T> createCountedSerializedSubject()
    {
      return null;
    }
    
    /* Error */
    public void onCompleted()
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
    public void onStart()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void scheduleChunk()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void startNewChunk()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void terminateChunk(OperatorWindowWithTime.CountedSerializedSubject<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  static final class State<T>
  {
    static final State<Object> EMPTY = new State(null, null, 0);
    final Observer<T> consumer;
    final int count;
    final Observable<T> producer;
    
    public State(Observer<T> paramObserver, Observable<T> paramObservable, int paramInt)
    {
      this.consumer = paramObserver;
      this.producer = paramObservable;
      this.count = paramInt;
    }
    
    public static <T> State<T> empty()
    {
      return EMPTY;
    }
    
    public State<T> clear()
    {
      return empty();
    }
    
    public State<T> create(Observer<T> paramObserver, Observable<T> paramObservable)
    {
      return new State(paramObserver, paramObservable, 0);
    }
    
    public State<T> next()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorWindowWithTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */