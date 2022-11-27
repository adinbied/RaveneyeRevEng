package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class OperatorOnBackpressureLatest<T>
  implements Observable.Operator<T, T>
{
  public static <T> OperatorOnBackpressureLatest<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  static final class Holder
  {
    static final OperatorOnBackpressureLatest<Object> INSTANCE = new OperatorOnBackpressureLatest();
  }
  
  static final class LatestEmitter<T>
    extends AtomicLong
    implements Producer, Subscription, Observer<T>
  {
    static final Object EMPTY = new Object();
    static final long NOT_REQUESTED = -4611686018427387904L;
    private static final long serialVersionUID = -1364393685005146274L;
    final Subscriber<? super T> child;
    volatile boolean done;
    boolean emitting;
    boolean missed;
    OperatorOnBackpressureLatest.LatestSubscriber<? super T> parent;
    Throwable terminal;
    final AtomicReference<Object> value;
    
    public LatestEmitter(Subscriber<? super T> paramSubscriber)
    {
      this.child = paramSubscriber;
      this.value = new AtomicReference(EMPTY);
      lazySet(-4611686018427387904L);
    }
    
    /* Error */
    void emit()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isUnsubscribed()
    {
      return false;
    }
    
    public void onCompleted()
    {
      this.done = true;
      emit();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.terminal = paramThrowable;
      this.done = true;
      emit();
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    long produced(long paramLong)
    {
      return 277873834L;
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void unsubscribe()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class LatestSubscriber<T>
    extends Subscriber<T>
  {
    private final OperatorOnBackpressureLatest.LatestEmitter<T> producer;
    
    LatestSubscriber(OperatorOnBackpressureLatest.LatestEmitter<T> paramLatestEmitter)
    {
      this.producer = paramLatestEmitter;
    }
    
    public void onCompleted()
    {
      this.producer.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.producer.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.producer.onNext(paramT);
    }
    
    public void onStart()
    {
      request(0L);
    }
    
    void requestMore(long paramLong)
    {
      request(paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorOnBackpressureLatest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */