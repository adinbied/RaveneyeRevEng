package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.functions.Func1;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class OperatorMapNotification<T, R>
  implements Observable.Operator<R, T>
{
  final Func0<? extends R> onCompleted;
  final Func1<? super Throwable, ? extends R> onError;
  final Func1<? super T, ? extends R> onNext;
  
  public OperatorMapNotification(Func1<? super T, ? extends R> paramFunc1, Func1<? super Throwable, ? extends R> paramFunc11, Func0<? extends R> paramFunc0)
  {
    this.onNext = paramFunc1;
    this.onError = paramFunc11;
    this.onCompleted = paramFunc0;
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    return null;
  }
  
  static final class MapNotificationSubscriber<T, R>
    extends Subscriber<T>
  {
    static final long COMPLETED_FLAG = Long.MIN_VALUE;
    static final long REQUESTED_MASK = Long.MAX_VALUE;
    final Subscriber<? super R> actual;
    final AtomicLong missedRequested;
    final Func0<? extends R> onCompleted;
    final Func1<? super Throwable, ? extends R> onError;
    final Func1<? super T, ? extends R> onNext;
    long produced;
    final AtomicReference<Producer> producer;
    final AtomicLong requested;
    R value;
    
    public MapNotificationSubscriber(Subscriber<? super R> paramSubscriber, Func1<? super T, ? extends R> paramFunc1, Func1<? super Throwable, ? extends R> paramFunc11, Func0<? extends R> paramFunc0)
    {
      this.actual = paramSubscriber;
      this.onNext = paramFunc1;
      this.onError = paramFunc11;
      this.onCompleted = paramFunc0;
      this.requested = new AtomicLong();
      this.missedRequested = new AtomicLong();
      this.producer = new AtomicReference();
    }
    
    /* Error */
    void accountProduced()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    void requestInner(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void setProducer(Producer arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void tryEmit()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorMapNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */