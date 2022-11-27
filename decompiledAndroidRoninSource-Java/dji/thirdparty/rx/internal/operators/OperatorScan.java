package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.functions.Func2;
import dji.thirdparty.rx.internal.util.atomic.SpscLinkedAtomicQueue;
import dji.thirdparty.rx.internal.util.unsafe.SpscLinkedQueue;
import dji.thirdparty.rx.internal.util.unsafe.UnsafeAccess;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public final class OperatorScan<R, T>
  implements Observable.Operator<R, T>
{
  private static final Object NO_INITIAL_VALUE = new Object();
  final Func2<R, ? super T, R> accumulator;
  private final Func0<R> initialValueFactory;
  
  public OperatorScan(Func0<R> paramFunc0, Func2<R, ? super T, R> paramFunc2)
  {
    this.initialValueFactory = paramFunc0;
    this.accumulator = paramFunc2;
  }
  
  public OperatorScan(Func2<R, ? super T, R> paramFunc2)
  {
    this(NO_INITIAL_VALUE, paramFunc2);
  }
  
  public OperatorScan(R paramR, Func2<R, ? super T, R> paramFunc2)
  {
    this(new Func0()
    {
      public R call()
      {
        return OperatorScan.this;
      }
    }, paramFunc2);
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    return null;
  }
  
  static final class InitialProducer<R>
    implements Producer, Observer<R>
  {
    final Subscriber<? super R> child;
    volatile boolean done;
    boolean emitting;
    Throwable error;
    boolean missed;
    long missedRequested;
    volatile Producer producer;
    final Queue<Object> queue;
    final AtomicLong requested;
    
    public InitialProducer(R paramR, Subscriber<? super R> paramSubscriber)
    {
      this.child = paramSubscriber;
      if (UnsafeAccess.isUnsafeAvailable()) {
        paramSubscriber = new SpscLinkedQueue();
      } else {
        paramSubscriber = new SpscLinkedAtomicQueue();
      }
      this.queue = paramSubscriber;
      paramSubscriber.offer(NotificationLite.instance().next(paramR));
      this.requested = new AtomicLong();
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super R> paramSubscriber)
    {
      return false;
    }
    
    /* Error */
    void emit()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void emitLoop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void onCompleted()
    {
      this.done = true;
      emit();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      this.done = true;
      emit();
    }
    
    /* Error */
    public void onNext(R arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: return
    }
    
    /* Error */
    public void setProducer(Producer arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorScan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */